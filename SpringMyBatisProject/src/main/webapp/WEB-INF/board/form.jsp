<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="./header.jsp"%>
<!-- 화면영역 -->
<main>
	<h2>List</h2>
	<a href="/register">게시판입력</a>
	<table border="1">
		<tr>
			<th align="center" width="80">NO</th>
			<th align="center" width="320">TITLE</th>
			<th align="center" width="100">WRITER</th>
			<th align="center" width="180">REGDATE</th>
		</tr>

		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="4">List is empty.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="board">
					<tr>
						<td align="center">${board.no}</td>
						<td align="left"><a
							href="/board/read?no=${board.no}">${board.title}</a></td>
						<td align="right">${board.writer}</td>
						<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${board.regDate}" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>
</main>
<%@ include file="./footer.jsp"%>