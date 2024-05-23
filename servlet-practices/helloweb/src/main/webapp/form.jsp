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
		<br><br>
		
		<label>생년:</label>
		<select name="birthYear">
			<option value="2001">2001년</option>
			<option value="2000">2000년</option>
			<option value="1999">1999년</option>
			<option value="1998">1998년</option>
			<option value="1997">1997년</option>
			<option value="1996">1996년</option>
		</select>
		<br><br>
		
		<label>성별:</label>
		여자 <input type="radio" name="gender" value="여자">
		남자 <input type="radio" name="gender" value="남자">
		<br><br>
		
		<label>자기소개:</label>
		<textArea name="profile"></textArea>
		<br><br>
		
		<label>취미:</label>
		코딩 <input type="checkbox" name="hobby" value="coding"> 
		낚시 <input type="checkbox" name="hobby" value="fishing"> 
		<br><br>
		
		<input type="submit" value="회원가입">
	</form>
</body>
</html>