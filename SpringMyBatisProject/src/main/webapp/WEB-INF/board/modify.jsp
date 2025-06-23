<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>


<main>

	<h2>MODIFY</h2>
	<form:form modelAttribute="board" action="modify">
		<form:hidden path="no" />
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" /></td>
				<td><font color="red"><form:errors path="title" /></font></td>
			</tr>
			<tr>
				<td>Content</td>
				<td><form:textarea path="content" /></td>
				<td><font color="red"><form:errors path="content" /></font></td>
			</tr>
			<tr>
				<td>Writer</td>
				<td><form:input path="writer" /></td>
				<td><font color="red"><form:errors path="writer" /></font></td>
			</tr>
			
		</table>
	</form:form>

	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnList">List</button>
	</div>
</main>
<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {

		var formObj = $("#board");

		$("#btnModify").on("click", function() {
			formObj.attr("action", "/board/modify");
			formObj.attr("method", "post");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/board/list";
		});

	});
</script>
