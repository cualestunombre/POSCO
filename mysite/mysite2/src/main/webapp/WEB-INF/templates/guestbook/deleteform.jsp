<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String no = (String)request.getAttribute("no");
%> 
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/templates/includes/header.jsp" />
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="<%= request.getContextPath()%>/guestbook?a=delete">
					<input type='hidden' name="no" value="<%=no%>">
					<label>비밀번호</label>
					<input type="password" name="password">
					<input type="submit" value="확인">
				</form>
				<a href="<%= request.getContextPath() %>" > 방명록 리스트</a>
			</div>
		</div>
		<jsp:include page="/WEB-INF/templates/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/templates/includes/footer.jsp" />
	</div>
</body>
</html>
