package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.AuthorVo;
import bookshop.vo.BookVo;

public class BookDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;

		// resource 구문의 경우는 close가 존재하는 코드의 경우만 사용하도록 한다
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "hr","hr");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		
		return conn;
	}
	
	public List<BookVo> findAll() {
		List<BookVo> result = new ArrayList<>();
		
		String sql = "select a.no, a.title, a.status, b.name" +
				 " from book a inner join author b on a.author_no = b.no order by no desc ";		
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet set = pstmt.executeQuery();
				){
			

			while (set.next()) {
				Long no = set.getLong(1);
				String title = set.getString(2);
				String status = set.getString(3);
				String authorName = set.getString(4);
				
				BookVo vo = new BookVo();
				vo.setAuthorName(authorName);
				vo.setTitle(title);
				vo.setStatus(status);
				vo.setNo(no);
				result.add(vo);
	
			}
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
		return result;
	}
	
	public long insert(BookVo vo) {
		long result = 0;
		
		String sql = "insert into book (title,author_no) values(?,?)";
		String countSql = "select last_insert_id() from dual";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(countSql);
				){
			pstmt1.setString(1, vo.getTitle());
			pstmt1.setLong(2,vo.getAuthorNo());
			int count = pstmt1.executeUpdate();
			
			ResultSet rs = pstmt2.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
			
			vo.setNo(result != 0 ? result : null );

			return result;
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
		return result;
	}

	public int deleteByNo(Long no) {
		int result = 0;
		String sql = "delete from book where no=?";
		
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				){
			
			pstmt.setLong(1,no);
			result = pstmt.executeUpdate();
			
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
		return result;
		
	}

	public int update(Long no, String string) {
		int result = 0;

		String sql = "update book set status =? where no=?";
		
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				){
			
			pstmt.setLong(2,no);
			pstmt.setString(1, string);
			result = pstmt.executeUpdate();
			
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
		return result;
	
	}
	
	
}
