<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>mysite</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="${pageContext.servletContext.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="container">
        <c:import url="/WEB-INF/views/includes/header.jsp" />
        <div id="content">
            <div id="board">
            	<c:if test='${key != null and key != "" }'>
            		<p>${key}에 대한 검색결과</p>
            	</c:if>
            	
            	<c:if test='${key != null and key != "" }'>
            		<a href="/mysite2/board">검색종료</a>
            	</c:if>
            	<a href="/"></a>
                <form id="search_form" action="${pageContext.servletContext.contextPath}/board" method="get">
                    <input type="text" id="kwd" name="kwd" value="${key}">
                    <input type="submit" value="찾기">
                </form>
                <table class="tbl-ex">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>조회수</th>
                        <th>작성일</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach var="item" items="${list}">
                        <tr>
                            <td>${item.no}</td>
                            <td style="text-align:left; padding-left:${item.depth * 20}px">
                                <c:if test="${item.depth != 0}">
                                    <img src='${pageContext.servletContext.contextPath}/assets/images/reply.png'>
                                </c:if>
                                <a href="${pageContext.servletContext.contextPath}/board/${item.no}?page=${page}">${item.title}</a>
                            </td>
                            <td>${item.name}</td>
                            <td>${item.hit}</td>
                            <td>${item.regDate}</td>
                            <td>
                                <c:if test="${not empty sessionScope.authUser and sessionScope.authUser.no eq item.userNo}">
                                    <a href="${pageContext.servletContext.contextPath}/board/delete?no=${item.no}" class="del">삭제</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                
                <!-- pager 추가 -->
                <div class="pager">
				    <ul>
				        <c:choose>
				            <c:when test="${page > 1}">
				                <li><a href="?page=${page - 1}&kwd=${key}">◀</a></li>
				            </c:when>
				            <c:otherwise>
				                <li>◀</li>
				            </c:otherwise>
				        </c:choose>
				
				        <c:forEach var="e" items="${pages}">
				            <c:choose>
				                <c:when test="${e.page == page}">
				                    <li class="selected">${e.page}</li>
				                </c:when>
				                <c:when test="${e.movable == false}">
				                    <li >${e.page}</li>
				                </c:when>
				                <c:otherwise>
				                    <li><a href="?page=${e.page}&kwd=${key}">${e.page}</a></li>
				                </c:otherwise>
				            </c:choose>
				        </c:forEach>
				
						<c:choose>
				            <c:when test="${page + 1 <= maxPage}">
				                <li><a href="?page=${page + 1}&kwd=${key}">▶</a></li>
				            </c:when>
				            <c:otherwise>
				                <li>▶</li>
				            </c:otherwise>
				        </c:choose>
				      
				
				          
				    </ul>
				</div>
                <!-- pager 추가 -->
                
                <div class="bottom">
                    <c:if test="${not empty sessionScope.authUser}">
                        <a href="${pageContext.servletContext.contextPath}/board/write" id="new-book">글쓰기</a>
                    </c:if>
                </div>
            </div>
        </div>
        <c:import url="/WEB-INF/views/includes/navigation.jsp">
            <c:param name="menu" value="board" />
        </c:import>
        <c:import url="/WEB-INF/views/includes/footer.jsp" />
    </div>
</body>
</html>
