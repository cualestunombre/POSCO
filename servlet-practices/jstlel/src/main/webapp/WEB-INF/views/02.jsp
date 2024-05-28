<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jstlel._01Servlet.UserVo" %>
    
 <%
 	// page context에 담기 위해서 사용
 	UserVo vo4 = new UserVo();
 	vo4.setNo(4L);
 	vo4.setName("둘리4");
 	pageContext.setAttribute("vo",vo4);
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>scope(basic)</h4>
${vo.no} ${vo.name}
<br>
<h4>== request scope ==</h4>
${requestScope.vo.no} ${requestScope.vo.name}
<br>
<h4>== session scope ==</h4>
${sessionScope.vo.no} ${sessionScope.vo.name}
<br>
<h4>== application scope ==</h4>
${applicationScope.vo.no} ${applicationScope.vo.name}
<br>
<h4>== page scope ==</h4>
${pageScope.vo.no} ${pageScope.vo.name}

</body>
</html>