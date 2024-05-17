package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEx01 {

	public static void main(String[] args) {
		select("b","x");
	}
	
	public static void select(String f_name, String l_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.64.8:3306/employees?charsef=utf8";
			conn = DriverManager.getConnection(url, "hr","hr");
			
			// 3. Statement 생성
			String sql = "select emp_no, first_name, last_name" +
					 " from employees" +
					 " where first_name like ? and last_name like ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. parameter binding
			pstmt.setString(1,"%" + f_name + "%");
			pstmt.setString(2,"%" + l_name + "%");
			
			set = pstmt.executeQuery();
			
			//5. 결과 처리
			while (set.next()) {
				Long no = set.getLong(1);
				String first_name = set.getString(2);
				String last_name = set.getString(3);
				System.out.println("no:"+no+" name:"+first_name+" "+last_name);
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
		
	}
	
}
