<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ include file="./header.jsp"%>

<main>
	<h3>회원 상세 정보</h3>
	<form:form modelAttribute="member">

		<form:hidden path="no" />

		<table>
			<tr>
				<td>id</td>
				<td><form:input path="id" readonly="true" /></td>

			</tr>
			<tr>
				<td>name</td>
				<td><form:input path="name" readonly="true" /></td>
			</tr>
			<tr>
				<td>auth - 1</td>
				<td><form:select path="authList[0].auth">
						<form:option value="" label="=== 선택해 주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
			<tr>
				<td>auth - 2</td>
				<td><form:select path="authList[1].auth">
						<form:option value="" label="=== 선택해 주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
			<tr>
				<td>auth - 3</td>
				<td><form:select path="authList[2].auth">
						<form:option value="" label="=== 선택해 주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnRemove">Remove</button>
		<button type="submit" id="btnList">List</button>
	</div>
</main>

<%@ include file="./footer.jsp"%>
<script>
	$(document).ready(function() {

		var formObj = $("#member");
		console.log(formObj);
		$("#btnModify").on("click", function() {
			formObj.attr("action", "/member/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#btnRemove").on("click", function() {
			formObj.attr("action", "/member/remove");
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "/member/list";
		});

	});
</script>
