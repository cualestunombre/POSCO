<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- jsp 지시자  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  action="/join.jsp" method="post">
		<label>이메일:</label>
		<input type="text" name="email" value=""> 
		<br><br>
		<label>비밀번호:</label>
		<input type="password" name="password" value=""> 
		<br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>