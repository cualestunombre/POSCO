<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(()=>{
	
	$("#btn-check").click(()=>{
		const email = $("#email").val();
		if (email == null || email === ""){
			return;
		}
		
		$.ajax({
			url: "/mysite3/user/api/checkemail?email=" + email,
			type: "get",
			dataType: "json",
			error: (xhr,status,error)=>{
				console.error(error);
			},
			success: (response)=>{
				if(response.exist){
					alert("이미 존재하는 이메일 입니다");
					$("#email").val("");
					$("#email").focus();
					return;
				}
				
				// 사용할 수 있는 이메일의 경우
				$("#btn-check").hide();
				$("#email").prop("disabled", true);  // input 창을 비활성화
				$("#img-check").show();
			}
		});
	});
});
</script>
</head>
<body>
	
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">

				<form:form 
					id="join-form" 
					name="joinForm" 
					method="post" 
					modelAttribute="userVo"
					action="${pageContext.request.contextPath}/user/join">
					
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('name')}" >
					
							<p style="text-align:left; padding:0;color:red;">
								 <spring:message code='${errors.getFieldError("name").codes[0]}' />
							</p>
						</c:if>
					</spring:hasBindErrors>
					<label class="block-label" for="name">이름</label>
					<form:input path="name"/>
			
					<label class="block-label" for="email">이메일</label>
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('email')}" >
					
							<p style="text-align:left; padding:0;color:red;">
								 <spring:message code='${errors.getFieldError("email").codes[0]}' />
							</p>
						</c:if>
					</spring:hasBindErrors>
					<form:input path="email" />
					<input id="btn-check"type="button" value="이메일확인" >
					<img  id="img-check" src="${pageContext.request.contextPath}/assets/images/check.png" style="width:15px;display:none;vertical-align:bottom">
					
					
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('password')}" >
					
							<p style="text-align:left; padding:0;color:red;">
								 <spring:message code='${errors.getFieldError("password").codes[0]}' />
							</p>
						</c:if>
					</spring:hasBindErrors>
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						<form:radiobutton path="gender" value="female" label="여" checked="checked"/>
						<form:radiobutton path="gender" value="male" label="남" />
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form:form>
			</div>
		</div>
	
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>


</html>