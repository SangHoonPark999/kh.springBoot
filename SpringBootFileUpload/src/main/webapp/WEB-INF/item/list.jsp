<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 헤더영역 -->
<%@ include file="./header.jsp"%>

<!-- 화면영역 -->
<main>
	<h2>상품 목록</h2>
	<a href="register">상품 등록</a>
	<table border="1">
		<tr>
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
			<th align="center" width="80">편집</th>
			<th align="center" width="80">제거</th>
		</tr>
		<c:forEach items="${itemList}" var="item">
			<tr>
				<td align="center">${item.id}</td>
				<td align="left">${item.name}</td>
				<td align="right">${item.price}원</td>
				<td align="center"><a href="modify?id=${item.id}">상품 편집</a></td>
				<td align="center"><a href="remove?id=${item.id}">상품 제거</a></td>
			</tr>
		</c:forEach>
	</table>
</main>

<!-- 푸터영역 -->
<%@ include file="./footer.jsp"%>