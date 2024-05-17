package example;

import java.sql.*;

public class InsertEx01 {
	public static void main(String[] args) {
		System.out.println(insert("인사"));
		System.out.println(insert("기획"));
	}
	public static boolean insert(String deptName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/webdb?charsef=utf8";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			// 3. Statement 생성
			String sql = "insert into dept values(null, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptName);
			
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

}
