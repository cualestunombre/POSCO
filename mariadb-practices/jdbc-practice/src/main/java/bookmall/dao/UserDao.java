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
import bookmall.vo.UserVo;

public class UserDao {

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
	
	public void insert(UserVo vo) {
		long result = 0;
		
		String sql = "insert into user (name,email,password,phone) values(?,?,?,?)";
		String countSql = "select last_insert_id() from dual";
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(countSql);
				){
			pstmt1.setString(1, vo.getName());
			pstmt1.setString(2, vo.getEmail());
			pstmt1.setString(3, vo.getPassword());
			pstmt1.setString(4, vo.getPhone());
			
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

	public List<UserVo> findAll() {
		List<UserVo> result = new ArrayList<>();
		
		String sql = "select no, name, email, password, phone" +
				 " from user ";		
		try(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet set = pstmt.executeQuery();
				){
			

			while (set.next()) {
				Long no = set.getLong(1);
				String name = set.getString(2);
				String email = set.getString(3);
				String password = set.getString(4);
				String phone = set.getString(5);
				
//				String name, String email, String password, String phone
				UserVo vo = new UserVo(name,email,password,phone);
				vo.setNo(no);
				result.add(vo);
	
			}
			
		}  catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} 
		
		return result;
	}

	public void deleteByNo(Long no) {
		String sql = "delete from user where no=?";

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
