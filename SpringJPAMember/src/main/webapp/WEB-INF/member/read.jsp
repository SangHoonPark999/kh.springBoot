<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./header.jsp"%>

<main>
	<h2>READ</h2>
	<form:form modelAttribute="member">
		<form:hidden path="member" />
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="pw" readonly="true" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><form:textarea path="name" readonly="true" /></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnRemove">Remove</button>
		<button type="submit" id="btnList">List</button>
	</div>
</main>

<style>
	main {
		max-width: 600px;
		margin: 40px auto;
		background-color: #fafafa;
		padding: 30px;
		border-radius: 12px;
		box-shadow: 0 4px 10px rgba(0, 0, 0, 0.08);
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

	form\:input[readonly],
	form\:textarea[readonly] {
		width: 100%;
		padding: 8px;
		border: 1px solid #ccc;
		border-radius: 6px;
		background-color: #f0f0f0;
		color: #555;
		box-sizing: border-box;
		font-size: 1em;
	}

	form\:textarea[readonly] {
		min-height: 60px;
		resize: none;
	}

	#btnModify, #btnRemove, #btnList {
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

	#btnModify:hover {
		background-color: #388e3c;
	}

	#btnRemove {
		background-color: #f44336;
	}

	#btnRemove:hover {
		background-color: #d32f2f;
	}

	#btnList {
		background-color: #607d8b;
	}

	#btnList:hover {
		background-color: #455a64;
	}

	main > div {
		text-align: center;
	}
</style>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {
		var formObj = $("#member");
		console.log(formObj);
		$("#btnModify").on("click", function() {
			var memberNo = $("#member");
			var memberNoVal = memberNo.val();
			/* http://~:8080//member/modify?memberNo=1 */
			self.location = "/member/modify?member=" + memberNoVal;
		});
		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/member/remove");
			formObj.submit();
		});
		$("#btnList").on("click", function() {
			/* http://~:8080/member/list */
			self.location = "/member/list";
		});
	});
</script>