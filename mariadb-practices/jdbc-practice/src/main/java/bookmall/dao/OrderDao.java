package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDao {

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
	


	
	public void insert(OrderVo vo) {
		long result = 0;
		
		String sql = "insert into orders (order_no,payment,shipment,status,user_no) values(?,?,?,?,?)";
		String countSql = "select last_insert_id() from dual";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(countSql);
				){
			pstmt1.setString(1, vo.getNumber());
			pstmt1.setInt(2, vo.getPayment());
			pstmt1.setString(3, vo.getShipping());
			pstmt1.setString(4, vo.getStatus());
			pstmt1.setLong(5, vo.getUserNo());
			
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

	public void insertBook(OrderBookVo vo) {
		long result = 0;
		
		String sql = "insert into orders_book (orders_no,book_no,quantity,price) values(?,?,?,?)";
		String countSql = "select last_insert_id() from dual";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(countSql);
				){
			

			pstmt1.setLong(1, vo.getOrderNo());
			pstmt1.setLong(2, vo.getBookNo());
			pstmt1.setInt(3, vo.getQuantity());
			pstmt1.setInt(4, vo.getPrice());
			
			int count = pstmt1.executeUpdate();
			
			ResultSet rs = pstmt2.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
			



			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
	}

	public OrderVo findByNoAndUserNo(Long orderNo, Long userNo) {
		String sql = "SELECT no, order_no, payment, shipment, status, user_no FROM orders WHERE no = ? and user_no= ?";
		OrderVo vo = null;

	    try (
	        Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql)
	    ) {
	        pstmt.setLong(1, orderNo);
	        pstmt.setLong(2, userNo);

	        try (ResultSet set = pstmt.executeQuery()) {
	            if (set.next()) {
	                Long no = set.getLong(1);
	                String on = set.getString(2);
	                Integer payment = set.getInt(3);
	                String shipment = set.getString(4);
	                String status = set.getString(5);
	                Long un = set.getLong(6);
	                
	                return new OrderVo(no,on,payment,shipment,status,un);
	                
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("SQL 예외 발생: " + e);
	    }
		
		
		return null;
	}

	public List<OrderBookVo> findBooksByNoAndUserNo(Long orderNo, Long userNo) {
		List<OrderBookVo> result = new ArrayList<>();
		
//		private Long orderNo;
//		private Long bookNo;
//		private String bookTitle;
//		private int quantity;
//		private int price;
		String sql = "select a.orders_no, a.book_no, c.title, a.quantity, a.price " +
				 " from orders_book a inner join orders b on a.orders_no = b.no "
				 + " inner join book c on c.no = a.book_no where a.orders_no = ? and b.user_no = ? ";		
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			
			pstmt.setLong(1, orderNo);
			pstmt.setLong(2, userNo);
			ResultSet set = pstmt.executeQuery();

			while (set.next()) {
				Long order_no  = set.getLong(1);
				Long book_no = set.getLong(2);
				String title = set.getString(3);
				int quantity = set.getInt(4);
				int price = set.getInt(5);
				

				OrderBookVo vo = new OrderBookVo(order_no, book_no,title,quantity,price);
				result.add(vo);
	
			}
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
		return result;
		
		
	}

	public void deleteBooksByNo(Long no) {
		String sql = "delete from orders_book where orders_no=?";

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

	public void deleteByNo(Long no) {
		String sql = "delete from orders where no=?";

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
