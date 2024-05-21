<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Time</title>
</head>
<body>
    <h1>Current Time</h1>
    <p>
        <% 
            // Java 코드 블록
            java.util.Date date = new java.util.Date();
            out.println("Current date and time: " + date.toString());
        %>
    </p>
</body>
</html>
