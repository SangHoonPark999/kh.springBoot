<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>
			<spring:message code="common.joinMemberSuccess"
				arguments="${userName}" />
		</h2>
		<a href="/auth/login"><spring:message code="action.login" /></a>
	</div>
</body>
</html>