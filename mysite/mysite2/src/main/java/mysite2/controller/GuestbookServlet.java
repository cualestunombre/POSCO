package mysite2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysite2.dao.GuestbookDao;
import mysite2.vo.GuestbookVo;



/**
 * Servlet implementation class GuestbookServlet
 */
public class GuestbookServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("a");
		if("add".equals(action)) {
			
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("message");
			
			GuestbookDao dao = new GuestbookDao();
			GuestbookVo vo =  new GuestbookVo(name,password,contents);
			
			dao.insert(vo);
			
			response.sendRedirect(request.getContextPath()+"/guestbook");
		}else if("deleteform".equals(action)) {
			String no = request.getParameter("no");
			request.setAttribute("no", no);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/guestbook/deleteform.jsp");
			rd.forward(request, response);
		}else if("delete".equals(action)) {
			request.setCharacterEncoding("utf-8");
			String no = request.getParameter("no");

			String password = request.getParameter("password");
			
			GuestbookDao dao = new GuestbookDao();
			
			List<GuestbookVo> list = dao.findByNo(Long.parseLong(no));
			
			if (list.size() != 0 && list.get(0).getPassword().equals(password)){
				dao.delete(Long.parseLong(no));
			}
			
			response.sendRedirect(request.getContextPath()+"/guestbook");
		}
		else {
			List<GuestbookVo> list = new GuestbookDao().findAll();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/guestbook/list.jsp");
			rd.forward(request, response);
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
