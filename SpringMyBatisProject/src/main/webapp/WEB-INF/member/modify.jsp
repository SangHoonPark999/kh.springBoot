<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ include file="./header.jsp"%>


<main>

	<h3>회원 정보 수정</h3>
	<form:form modelAttribute="member" action="modify">

		<form:hidden path="no" />

		<table>
			<tr>
				<td>userid</td>
				<td><form:input path="id" readonly="true" /></td>
				<td><font color="red"><form:errors path="id" /></font></td>
			</tr>
			<tr>
				<td>username</td>
				<td><form:input path="name" /></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
			<tr>
				<td>auth - 1</td>
				<td><form:select path="authList[0].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[0].auth" /></font></td>
			</tr>
			<tr>
				<td>auth - 2</td>
				<td><form:select path="authList[1].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[1].auth" /></font></td>
			</tr>

			<tr>
				<td>auth - 3</td>
				<td><form:select path="authList[2].auth">
						<form:option value="" label="=== 선택해주세요 ===" />
						<form:option value="ROLE_USER" label="사용자" />
						<form:option value="ROLE_MEMBER" label="회원" />
						<form:option value="ROLE_ADMIN" label="관리자" />
					</form:select></td>
				<td><font color="red"><form:errors
							path="authList[2].auth" /></font></td>
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
	 
	var formObj = $("#member"); 
	 
	$("#btnModify").on("click", function() 
	{ formObj.attr("action", "/member/modify");
	formObj.attr("method", "post");
	formObj.submit(); 
	}); 
	 
	$("#btnList").on("click", function() 
	{ self.location = "/member/list"; 
	}); 
	 
	}); 
</script>
