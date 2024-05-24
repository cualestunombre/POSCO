package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;
import bookmall.vo.UserVo;

public class CartDao {

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
	


	
	
	public void insert(CartVo vo) {
		long result = 0;
		
		String sql = "insert into cart (book_no,user_no,quantity) values(?,?,?)";
		String countSql = "select last_insert_id() from dual";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(countSql);
				){
			
	
			pstmt1.setLong(1, vo.getBookNo());
			pstmt1.setLong(2, vo.getUserNo());
			pstmt1.setInt(3, vo.getQuantity());
			
			
			
			int count = pstmt1.executeUpdate();
			
			ResultSet rs = pstmt2.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
			
			


			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		

	}

	public List<CartVo> findByUserNo(Long no) {
		List<CartVo> result = new ArrayList<>();
		ResultSet set = null;
		String sql = "select c.book_no, c.user_no, b.title, c.quantity" +
				 " from cart c inner join book b on c.book_no = b.no where c.user_no = ?";		
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			pstmt.setLong(1, no);
			set = pstmt.executeQuery();

			while (set.next()) {
				Long book_no  = set.getLong(1);
				Long user_no = set.getLong(2);
				String title = set.getString(3);
				int quantity = set.getInt(4);
				
//				String name, String email, String password, String phone
				CartVo vo = new CartVo(user_no,book_no,title,quantity);
				result.add(vo);
	
			}
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} finally {
				
			try {
				if (set != null) {
					set.close();
				}
			}catch(SQLException e) {
				System.out.println("SQL 예외 발생:" + e);
			}
		}
		
		return result;

	}

	public void deleteByUserNoAndBookNo(Long userNo, Long bookNo) {
		String sql = "delete from cart where user_no=? and book_no=?";

		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				){
			
			pstmt.setLong(1,userNo);
			pstmt.setLong(2,bookNo);
			pstmt.executeUpdate();
			
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
	}
}
