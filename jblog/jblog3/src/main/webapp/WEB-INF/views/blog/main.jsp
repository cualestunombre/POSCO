<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
    <div id="container">
        <c:import url="/WEB-INF/views/includes/blog-header.jsp" />
        <div id="wrapper">
            <div id="content">
                <div class="blog-content">
                    <h4>${postVo.title}</h4>
                    <p>${postVo.contents}</p>
                </div>
                <ul class="blog-list">
                    <c:forEach items="${postList}" var="post">
                        <li class="${post.no == pno ? 'highlight' : ''}">
                            <a href="${pageContext.request.contextPath}/${blogVo.id}/${cno}/${post.no}"><c:out value="${post.title}" /></a>
                            <span><c:out value="${post.reg_date}" /></span>
                        </li>
                    </c:forEach>
                </ul>
            </div>  
        </div>

        <div id="extra">
            <div class="blog-logo">
                <img src="${pageContext.request.contextPath}${blogVo.logo}">
            </div>
        </div>

        <div id="navigation">
            <h2>카테고리</h2>
            <ul>
                <c:forEach items="${categoryList}" var="category">
                    <li class="${category.no == cno ? 'highlight' : ''}">
                        <a href="${pageContext.request.contextPath}/${blogVo.id}/${category.no}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div id="footer">
            <p>
                <strong>Spring 이야기</strong> is powered by JBlog (c)2016
            </p>
        </div>
    </div>
</body>
</html>
