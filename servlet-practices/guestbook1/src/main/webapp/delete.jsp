<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guestbook.dao.*"%>
<%@ page import="java.util.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");

	String password = request.getParameter("password");
	
	GuestbookDao dao = new GuestbookDao();
	
	List<GuestbookVo> list = dao.findByNo(Long.parseLong(no));
	
	if (list.size() != 0 && list.get(0).getPassword().equals(password)){
		dao.delete(Long.parseLong(no));
	}
	
	response.sendRedirect("/guestbook1");
	
%>
