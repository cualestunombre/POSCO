<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guestbook.dao.*"%>
<%
request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String contents = request.getParameter("message");
	
	GuestbookDao dao = new GuestbookDao();
	GuestbookVo vo =  new GuestbookVo(name,password,contents);
	
	dao.insert(vo);
	
	response.sendRedirect("/guestbook1");
%>
