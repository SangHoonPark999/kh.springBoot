<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="./header.jsp"%>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/member/modify.css'/>">
<<script type="text/javascript" src="<c:url value='/js/member/modify.js'/>">

</script>
<main>
	<h2>MODIFY</h2>
	<form:form modelAttribute="member" action="modify">
		<form:hidden path="member" />
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
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnList">List</button>
	</div>

</main>


<%@ include file="./footer.jsp"%>
