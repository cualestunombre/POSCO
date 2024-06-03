<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>메일 리스트에 가입되었습니다.</h1>
    <p>입력한 정보 내역입니다.</p>

    <table border="1" cellpadding="5" cellspacing="2">
        <tr>
            <th>No.</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email Address</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="vo" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${vo.firstName}</td>
                <td>${vo.lastName}</td>
                <td>${vo.email}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <p>
        <a href="<%= request.getContextPath() %>/mail">추가메일 등록</a>
    </p>
</body>
</html>
