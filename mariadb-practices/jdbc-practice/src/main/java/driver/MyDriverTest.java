package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDriverTest {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			System.out.println("not loaded yet");
			// 1. JDBC Driver 로딩
			Class.forName("driver.MyDriver");
			
			// 2. 연결하기
			String url = "jdbc:mydb://127.0.0.1:2202/webdb";
			conn = DriverManager.getConnection(url, "webdb","webdb");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("SQL 예외 발생:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("IO 예외 발생:" + e);
			}
		}
		
	}


}
