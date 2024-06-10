package com.poscodx.mysite.repository.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.poscodx.mysite.vo.GuestbookVo;


public class JdbcContext {
	private DataSource dataSource;
	
	public JdbcContext(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int update(String sql, Object[] parameters) {
		return executeUpdateWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makeStatement(Connection connection) throws SQLException {
				PreparedStatement pstmt = connection.prepareStatement(sql);
				for(int i = 0; i < parameters.length; i++) {
					pstmt.setObject(i+1, parameters[i]);
				}
				return pstmt;
			}
		});
	}
	
	public int update(String sql) {
		return executeUpdateWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makeStatement(Connection connection) throws SQLException {
				PreparedStatement pstmt = connection.prepareStatement(sql);
				return pstmt;
			}
		});
	}
	
	
	private int executeUpdateWithStatementStrategy(StatementStrategy statementStrategy) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DataSourceUtils.getConnection(dataSource);
			pstmt = statementStrategy.makeStatement(conn);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error:" + e);
			throw new RuntimeException("DB Error");
		} finally {
			try {
				if (conn!= null) {
					DataSourceUtils.releaseConnection(conn,dataSource);
				}
				if(pstmt != null) {
					pstmt.close();
				}
			} catch(SQLException e) {
				System.out.println("Error:" + e);
			}
		}
		
		return result;		
	}
	
	private <T> List<T> executeQueryWithStatementStrategy(StatementStrategy statementStrategy, RowMapper<T> rowMapper) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> result = new ArrayList<>();
		try {
			conn = DataSourceUtils.getConnection(dataSource);
			pstmt = statementStrategy.makeStatement(conn);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				T t = rowMapper.mapRow(rs, rs.getRow());
				result.add(t);
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e);
			throw new RuntimeException("DB Error");
		} finally {
			try {
				if (conn!= null) {
					DataSourceUtils.releaseConnection(conn,dataSource);
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch(SQLException e) {
				System.out.println("Error:" + e);
			}
		}
		
		return result;		
	}

	public <T> List<T> query(String sql, RowMapper<T> rowMapper) {
		return executeQueryWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makeStatement(Connection connection) throws SQLException {
				PreparedStatement pstmt = connection.prepareStatement(sql);
				return pstmt;
			}
		},rowMapper);
	}
	
	
}
