<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!-- 헤더영역 -->
<%@ include file="./header.jsp"%>

<!-- 화면영역 -->
<main>
	<h3>회원 목록</h3>
	<a href="register">New</a>

	<table border="1">
		<tr>
			<th align="center" width="60">NO</th>
			<th align="center" width="80">USERID</th>
			<th align="center" width="50">USERPW</th>
			<th align="center" width="50">USERNAME</th>
			<th align="center" width="180">REGDATE</th>
		</tr>
		<c:forEach items="${list}" var="member">
			<tr>
				<td align="center">${member.no}</td>
				<td align="center"><a href='/member/read?no=${member.no}'>${member.id}</a></td>
				<td align="left">${member.pw}</td>
				<td align="right">${member.name}</td>
				<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${member.regDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</main>

<!-- 푸터영역 -->
<%@ include file="./footer.jsp"%>