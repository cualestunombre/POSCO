package mysite2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import mysite2.vo.UserVo;

public class UserDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		// resource 구문의 경우는 close가 존재하는 코드의 경우만 사용하도록 한다
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		
		return conn;
	}

	public void insert(UserVo vo) {
		
		Long result = 0L;
		String sql = "insert into user (name,email, gender,password,joindate) values(?,?,?,?,?)";
		String countSql = "select last_insert_id() from dual";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(countSql);
				){
		
			pstmt1.setString(1, vo.getName());
			pstmt1.setString(2, vo.getEmail());
			pstmt1.setString(3, vo.getGender());
			pstmt1.setString(4, vo.getPassword());
			pstmt1.setDate(5, Date.valueOf(LocalDate.now()));
			
			int count = pstmt1.executeUpdate();
			
			ResultSet rs = pstmt2.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
			
			vo.setNo(result != 0 ? result : null );


			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
	}
	
	
	
	
	
}
