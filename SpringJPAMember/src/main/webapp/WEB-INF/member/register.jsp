<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>

<main>
	<h2>REGISTER</h2>
	<form:form modelAttribute="member" action="register">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" /></td>
				<td><font color="red"><form:errors path="id" /></font></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="pw" /></td>
				<td><font color="red"><form:errors path="pw" /></font></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><form:textarea path="name" /></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnRegister">게시판입력</button>
		<button type="submit" id="btnList">게시판전체출력</button>
	</div>
</main>

<style>
main {
	max-width: 600px;
	margin: 40px auto;
	background-color: #fff;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	color: #333;
	margin-bottom: 25px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

td {
	padding: 10px;
	vertical-align: top;
}

form\:input, form\:textarea {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 6px;
	box-sizing: border-box;
	font-size: 1em;
}

form\:textarea {
	resize: vertical;
	min-height: 60px;
}

font[color="red"] {
	font-size: 0.85em;
	display: block;
	margin-top: 4px;
}

#btnRegister, #btnList {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 20px;
	margin: 15px 10px 0 0;
	border-radius: 6px;
	font-size: 1em;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

#btnRegister:hover, #btnList:hover {
	background-color: #45a049;
}

/* 버튼 영역 가운데 정렬 */
main>div {
	text-align: center;
}
</style>
<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		$("#btnRegister").on("click", function() {
			formObj.attr("action", "/member/register");
			formObj.attr("method", "post");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			/*http://~:8080/member/list  */
			self.location = "/member/list";
		});
	});
</script>