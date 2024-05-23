<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 이코드가 doGet(), 정확히 말하면 service()으로 들어간다...]
			request.setCharacterEncoding("UTF-8");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String birthYear = request.getParameter("birthYear");
			String gender = request.getParameter("gender");
			String profile = request.getParameter("profile");
			String[] hobbies = request.getParameterValues("hobby");
%>
<!-- 아래코드는 printerWriter를 통해서 html문서로 바뀐다 --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>이메일:<%=email%></div>
	<div>패스워드:<%=password%></div>
	<div>생년월일:<%=birthYear%></div>
	<div>성별:<%=gender%></div>
	<div>프로필:<%=profile%></div>
	<div>취미:<br>
		 <% 
        for (String s : hobbies) {
            %>
            <p><%= s %></p>
            <%
        }
    %>
	</div>
	

	
</body>
</html>