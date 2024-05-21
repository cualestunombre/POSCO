package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookmall.vo.BookVo;
import bookshop.vo.AuthorVo;

public class BookDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		// resource 구문의 경우는 close가 존재하는 코드의 경우만 사용하도록 한다
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.64.8:3306/bookmall?charsef=utf8";
			conn = DriverManager.getConnection(url, "bookmall","bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		
		return conn;
	}
	
	public void insert(BookVo vo) {
		long result = 0;
		
		String sql = "insert into book (title,price,category_no) values(?,?,?)";
		String countSql = "select last_insert_id() from dual";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(countSql);
				){
			pstmt1.setString(1, vo.getTitle());
			pstmt1.setInt(2, vo.getPrice());
			pstmt1.setLong(3, vo.getCategoryNo());
			
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

	public void deleteByNo(Long no) {
		String sql = "delete from book where no=?";

		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				){
			
			pstmt.setLong(1,no);
			pstmt.executeUpdate();
			
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
	}
}
