package mysite2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysite2.dao.UserDao;
import mysite2.vo.UserVo;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("a");
		if ("joinform".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/templates/user/joinform.jsp")
			.forward(request, response);
		}else if("joinsuccess".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/templates/user/joinsuccess.jsp")
			.forward(request, response);
		}else if("join".equals(action)) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			UserVo vo = new UserVo();
			vo.setEmail(email);
			vo.setGender(gender);
			vo.setPassword(password);
			vo.setName(name);
			
			 new UserDao().insert(vo);
			
			response.sendRedirect(request.getContextPath()+"/user?a=joinsuccess");
			
			
		}else if("loginform".equals(action)) {
			
		}else if("updateform".equals(action)) {
			
		}else {
			response.sendRedirect(request.getContextPath());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
