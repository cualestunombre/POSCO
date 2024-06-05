package com.poscodx.mysite.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.poscodx.mysite.repository.template.JdbcContext;
import com.poscodx.mysite.repository.template.StatementStrategy;
import com.poscodx.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepositoryWithJdbcContext {
	private JdbcContext jdbcContext;
	
	public GuestbookRepositoryWithJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}
	
	public int insert(GuestbookVo vo) {
		return jdbcContext.executeUpdate(
			"insert into guestbook values(null, ?, ?, ?, now())",
			new Object[] {vo.getName(), vo.getPassword(), vo.getContents()});
	}
	
	public int deleteByNoAndPassword(Long no, String password) {
		return jdbcContext.executeUpdate("delete from guestbook where no = ? and password = ?", new Object[] {no, password});
	}

}
