<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
<head>
    <title>mysite</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="container">
        <c:import url="/WEB-INF/views/includes/header.jsp"/>
        <div id="content">
            <div id="board" class="board-form">
                <table class="tbl-ex">
                    <tr>
                        <th colspan="2">글보기</th>
                    </tr>
                    <tr>
                        <td class="label">제목</td>
                        <td>${vo.title}</td>
                    </tr>
                    <tr>
                        <td class="label">내용</td>
                        <td>
                            <div class="view-content">
                                ${vo.contents}
                            </div>
                        </td>
                    </tr>
                </table>
                <div class="bottom">
                    <a href="${pageContext.servletContext.contextPath }/board?page=${page}">글목록</a>
                    <c:if test="${not empty sessionScope.authUser and sessionScope.authUser.no eq vo.userNo}">
                        <a href="${pageContext.servletContext.contextPath }/board?a=updateForm&no=${vo.no}">글수정</a>
                    </c:if>
                    <c:if test="${not empty sessionScope.authUser}">
                        <a href="${pageContext.servletContext.contextPath }/board?a=replyForm&no=${vo.no}">답글</a>
                    </c:if>
                </div>
            </div>
        </div>
        <c:import url="/WEB-INF/views/includes/navigation.jsp">
            <c:param name="menu" value="board"/>
        </c:import>
        <c:import url="/WEB-INF/views/includes/footer.jsp"/>
    </div>
</body>
</html>
