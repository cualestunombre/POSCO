<%@ page import="emaillist1.dao.EmaillistVo"%>
<%@ page import="java.util.List"%>
<%@ page import="emaillist1.dao.EmaillistDao"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo(firstName,lastName,email);
	new EmaillistDao().insert(vo);
	
	response.sendRedirect("success.jsp");
%>
