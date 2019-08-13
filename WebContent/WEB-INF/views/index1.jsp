<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<!-- Simple DB set up to make it work -->

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello Jsp</h3>
	<%@include file="header.html"%>

	<hr />
	<p>Content goes here</p>

	<a href="addEmployee">Add Employee</a>
	<br />

	<h4>Results of DB operation: ${viewMessage}</h4>

	<div>Nice library</div>

	<%@include file="cataloglist.jsp"%>

	<hr />

	<div>footer (c) 2019</div>
</body>
</html>