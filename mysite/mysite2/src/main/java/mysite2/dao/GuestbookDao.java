package mysite2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mysite2.vo.GuestbookVo;


public class GuestbookDao {
	
	
	public boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			// 3. Statement 생성
			String sql = "delete from guestbook where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			
			// 4. SQL 실행
			int count = pstmt.executeUpdate();
			
			//5. 결과 처리
			return count == 1;
			
			
			
			
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
			}catch(SQLException e) {
				System.out.println("IO 예외 발생:" + e);
			}
			
		}
		return false;
	}

	public boolean insert(GuestbookVo vo) {

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			// 3. Statement 생성
			String sql = "insert into guestbook (name,password,contents,regtime) values(?, ?, ?, ?)";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContents());
			pstmt.setTimestamp(4, vo.getRegtime());
			
			// 4. SQL 실행
			int count = pstmt.executeUpdate();
	
			
			//5. 결과 처리
			return count == 1;
			
			
			
			
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
			String sql = "select no, name, password, contents, regtime" +
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
			String sql = "select no, name, password, contents, regtime" +
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
