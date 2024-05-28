<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("message", "Hello from pageScope");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>값출력</h4>
${iVal + iVal }<br>
${dVal * dVal }<br>
${cVal}<br>
${obj}<br>
${vo}<br>
${vo.email}<br>
--${map.iVal}--
<h4>산술연산</h4>
${66*(124) + iVal }
<h4>관계연산</h4>
${ iVal == 10}
${ obj == null }
${empty bc}
${not empty bc }
<h4>논리연산</h4>
${ival == 10 && ival >=1 }
<if test='${1==1}'>
	<p>ㅋㅋㅋ</p>
</if>
<h4>요청 파라미터</h4>
${param.a }
${param.b  }
--${param.c }--
${10 + param.d}
${pageContext.request.contextPath}
${pageScope.message}


</body>
</html>