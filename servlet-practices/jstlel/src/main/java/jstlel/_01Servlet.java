package jstlel;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class _01Servlet
 */
@WebServlet("/01")
public class _01Servlet extends HttpServlet {
	public static class UserVo {
		private Long no;
		private String name;
		private String email;
		private String password;
		private String gender;
		private String joinDate;
		
		public Long getNo() {
			return no;
		}
		public void setNo(Long no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getJoinDate() {
			return joinDate;
		}
		public void setJoinDate(String joinDate) {
			this.joinDate = joinDate;
		}
		@Override
		public String toString() {
			return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
					+ gender + ", joinDate=" + joinDate + "]";
		}
	}

 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값
		int iVal = 10;
		double dVal = 40.04;
		char cVal = 'd';
		request.setAttribute("cVal", cVal);
		request.setAttribute("iVal", iVal);
		request.setAttribute("dVal",  dVal);
		
		// 객체
		Object obj = null;
		
		request.setAttribute("obj", obj);
		
		UserVo vo = new UserVo();
		vo.setEmail("1dilumn0@gmail.com");
		vo.setGender("male");
		
		request.setAttribute("vo", vo);
		
		// map
		Map<String, Object> map = new HashMap<>();
		map.put("iVal", iVal);
		map.put("dVal", dVal);
		
		request.setAttribute("map", map);
		
	
		
		
		request
		.getRequestDispatcher("/WEB-INF/views/01.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
