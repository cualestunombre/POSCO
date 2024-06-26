<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<div id="header">
	<h1><a style="color:white;"href="${pageContext.request.contextPath}/${blogVo.id}">${blogVo.title}</a></h1>
	<ul>
		<c:choose>
			<c:when test='${not (empty authUser) and (authUser.id eq blogVo.id)}'>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/${blogVo.id}/admin/basic">블로그 관리</a></li>
			</c:when>
			<c:when test='${not (empty authUser)}'>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
			</c:otherwise>
		</c:choose>			
	</ul>
</div>

