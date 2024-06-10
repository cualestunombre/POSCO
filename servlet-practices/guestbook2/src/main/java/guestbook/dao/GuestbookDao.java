package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class GuestbookDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}
	
	
	public boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			// 1. JDBC Driver 로딩
			conn = getConnection();
			
			conn.setAutoCommit(false);
			// 3. Statement 생성
			String sql = "delete from guestbook where no = ?";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setLong(1, no);
			
			pstmt2 = conn.prepareStatement("update guestbook_log set count = count - 1 where date = (select date(reg_date) from guestbook where no=? ) ");
			pstmt2.setLong(1, no);
			
			// 4. SQL 실행
			pstmt2.executeUpdate();
			int count = pstmt1.executeUpdate();
	
	
			
			conn.commit();
			
			//5. 결과 처리
			return count == 1;
			
			
			
			
		} catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
			try {
				conn.rollback();
			} catch (SQLException ignored) {
				ignored.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt1 != null ) {
					pstmt1.close();
				}
				if (pstmt2 != null ) {
					pstmt2.close();
				}
			}catch(SQLException e) {
				System.out.println("IO 예외 발생:" + e);
			}
			
		}
		return false;
	}

	public boolean insert(GuestbookVo vo) {

		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			conn = getConnection();
			
			// TX:BEGIN //////////////
			conn.setAutoCommit(false);
			// 3. Statement 생성
			String sql = "update guestbook_log set count = count + 1 where date = DATE(NOW())";
			String sql2 = "insert into guestbook_log values(now(),1)";
			String sql3 = "insert into guestbook (name,password,contents,reg_date) values(?, ?, ?, ?)";
			
			
			pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setString(1, vo.getName());
			pstmt3.setString(2, vo.getPassword());
			pstmt3.setString(3, vo.getContents());
			pstmt3.setTimestamp(4, vo.getRegtime());
			
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			
			// 4. SQL 실행
			int count1 = pstmt.executeUpdate();
			if (count1 == 0) {
				pstmt2.executeUpdate();
			}
			
			int count3 = pstmt3.executeUpdate();
		
			
			//5. 결과 처리
			conn.commit();
			return count3 == 1;
			
		} catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
			try {
				if(conn != null) {
					conn.rollback();
				}
			} catch (SQLException ignored) {
				ignored.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt3 != null ) {
					pstmt3.close();
				}
				if (pstmt2 != null ) {
					pstmt2.close();
				}
				if (pstmt != null ) {
					pstmt.close();
				}
			}catch(SQLException e) {
				System.out.println("IO 예외 발생:" + e);
			}
			
		}
		return false;
	}
	
	public List<GuestbookVo> findByNo(Long no){
		List<GuestbookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			// 3. Statement 생성
			String sql = "select no, name, password, contents, reg_date" +
					 " from guestbook where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			// 4. parameter binding
		
			
			set = pstmt.executeQuery();
			
			//5. 결과 처리
			while (set.next()) {
				Long number = set.getLong(1);
				String name = set.getString(2);
				String password = set.getString(3);
				String contents = set.getString(4);
				Timestamp time = set.getTimestamp(5);
				
				GuestbookVo vo = new GuestbookVo(number,name,password,contents,time);
	
				result.add(vo);
	
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null ) {
					pstmt.close();
				}
				if (set != null) {
					set.close();
				}
			}catch(SQLException e) {
				System.out.println("IO 예외 발생:" + e);
			}
			
		}
		return result;
	}

	public List<GuestbookVo> findAll() {
		List<GuestbookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			// 3. Statement 생성
			String sql = "select no, name, password, contents, reg_date" +
					 " from guestbook";
			
			pstmt = conn.prepareStatement(sql);
			
			// 4. parameter binding
		
			
			set = pstmt.executeQuery();
			
			//5. 결과 처리
			while (set.next()) {
				Long no = set.getLong(1);
				String name = set.getString(2);
				String password = set.getString(3);
				String contents = set.getString(4);
				Timestamp time = set.getTimestamp(5);
				
				GuestbookVo vo = new GuestbookVo(no,name,password,contents,time);
	
				result.add(vo);
	
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null ) {
					pstmt.close();
				}
				if (set != null) {
					set.close();
				}
			}catch(SQLException e) {
				System.out.println("IO 예외 발생:" + e);
			}
			
		}
		return result;
	}
}
