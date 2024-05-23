package emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmaillistDao {
	
	public boolean delete(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			// 3. Statement 생성
			String sql = "delete from emaillist where address = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
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

	public boolean insert(EmaillistVo vo) {

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			// 3. Statement 생성
			String sql = "insert into emaillist values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			
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

	public List<EmaillistVo> findAll() {
		List<EmaillistVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "hr","hr");
			
			// 3. Statement 생성
			String sql = "select no, first_name, last_name, address" +
					 " from emaillist order by no desc ";
			
			pstmt = conn.prepareStatement(sql);
			
			// 4. parameter binding
		
			
			set = pstmt.executeQuery();
			
			//5. 결과 처리
			while (set.next()) {
				Long no = set.getLong(1);
				String firstName = set.getString(2);
				String lastName = set.getString(3);
				String email = set.getString(4);
				
				result.add(new EmaillistVo(firstName,lastName,email));
	
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
