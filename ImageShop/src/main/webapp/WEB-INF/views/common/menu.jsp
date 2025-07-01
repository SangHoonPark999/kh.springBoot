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
	<div align="right">
		<table>
			<tr>
				<!-- 회원가입 메뉴 -->
				<td width="80"><a href="/"> <spring:message
							code="header.joinMember" /></a></td>
				<!-- 코드 그룹관리 메뉴 -->
				<td width="120"><a href="/codegroup/list"><spring:message
							code="menu.codegroup.list" /></a></td>
				<!-- 코드 관리 메뉴에 추가 -->
				<td width="120"><a href="/codedetail/list"><spring:message
							code="menu.codedetail.list" /></a></td>
				<!-- 회원 관리를 메뉴에 추가한다. -->
				<td width="120"><a href="/user/list"><spring:message
							code="menu.user.admin" /></a></td>
			</tr>
		</table>
	</div>
	<hr>
</body>
</html>