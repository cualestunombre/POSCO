<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="guestbook.dao.*"%>
<%@ page import="java.util.*"%>
<%
	String no = (String)request.getAttribute("no");
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="<%= request.getContextPath()%>/gb?a=delete">
	<input type='hidden' name="no" value="<%=no%>">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			
		</tr>
	</table>
	</form>
	<a href="/guestbook">메인으로 돌아가기</a>
</body>
</html>