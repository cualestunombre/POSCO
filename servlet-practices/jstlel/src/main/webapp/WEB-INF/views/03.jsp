<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	pageContext.setAttribute("newline","\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL TEST: forEach, set fn:length</h1>
	<h1>${fn:length(list)}</h1>
	<!-- pageContext에 저장하는 코드 --> 
	<c:set var="count" value="${fn:length(list)}"/>
	<c:forEach items='${list}' var='vo' varStatus='status'>
	 	${3 - status.index}:${status.index}:${status.count}:${vo.no}:${vo.name }<br> 
	 	${count}
	</c:forEach>
	
	<h1>JSTL TEST: fn:replace</h1>
	<p>
		${fn:replace(contents,newLine,"<br>")}
	</p>
	
</body>
</html>