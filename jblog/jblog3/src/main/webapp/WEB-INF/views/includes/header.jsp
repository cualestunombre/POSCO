<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<img class="logo" src="data:image/png;base64,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">
		
<ul class="menu">
<c:choose>
	<c:when test='${empty authUser}'>
		<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
	</c:when>
	<c:otherwise>
		<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
		<li><a href="${pageContext.request.contextPath}/${authUser.id}">내블로그</a></li>
	</c:otherwise>
</c:choose>			
</ul>