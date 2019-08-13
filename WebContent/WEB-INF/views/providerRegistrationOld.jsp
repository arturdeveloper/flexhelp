<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<%@include file="head.html"%>
<body>

	<div id="header" style="background-color: lightblue; height: 150px;">
		<%@include file="header.html"%>
		<%@include file="navbar.html"%>
	</div>
	<hr />
	<div>

		<a href="addCatalogItem">Add Catalog Item |</a> <a
			href="updateEmployee">Update Employee |</a> <a href="showEmployees">Show
			All Employees |</a> <br />

		<%@include file="cataloglist.jsp"%>

		<div>Provider Registration Form</div>
		<div>
			<form:form action="addProviderOld" method="post"
				modelAttribute="userkey">
				<input type="text" name="id" placeholder="Provider id">
				<br />
				<form:input type="text" id="uname" path="uname"
					placeholder="User Name" />
				<form:errors path="uname" />
				<br />
				<form:input type="text" id="email" path="email"
					placeholder="User Email" />
				<form:errors path="email" />
				<br />
				<input type="text" name="password" placeholder="User Password">
				<br />
				<input type="submit" value="Save">
				<input type="reset" value="Reset">
			</form:form>

		</div>
	</div>
	<hr />
	<div>(c) JDB 2019</div>
</body>
</html>