<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all employees</title>
</head>
<body>
	<div>
		<h3>Hello Jsp</h3>

		<a href="index">Home</a>

		<hr />
	</div>
	<div>
		<h2>All Employees</h2>
		<p>Results of DB operation:</p>
		<br />

		<hr />
		<c:forEach var="employee" items="${employeeList}">
			<p>${employee.getId() }</p>
			<p>${employee.getFirstName() }</p>
			<p>${employee.getLastName() }</p>
			<p>${employee.getEmail() }</p>
			<a href="updateEmployee/${employee.id}">Update</a>
			<a href="deleteEmployee/${employee.id}">Delete</a>
			<hr />
		</c:forEach>
		<h4>${messageResult}</h4>


		<hr />
	</div>

	<div>footer (c) 2019</div>
</body>
</html>