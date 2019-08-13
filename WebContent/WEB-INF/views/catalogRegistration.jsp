<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Marketplace home page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>
<body>

	<div id="header" style="background-color: lightblue; height: 150px;">
		<%@include file="header.html"%>
	</div>
	<hr />
	<div>

		<a href="addCatalogItem">Add Catalog Item |</a> <a
			href="updateEmployee">Update Employee |</a> <a href="showEmployees">Show
			All Employees |</a> <br />

		<%@include file="cataloglist.jsp"%>

		<div>Catalog Item Registration Form</div>
		<div>
	    <form action="addCatalogItem" method="post">
	        <input type="text" name="catalogId" placeholder="Catalog id">
	        <br />
	        <input type="text" name="catalogTitle" placeholder="Enter title">
	        <br />
	        <input type="text" name="catalogDescription" placeholder="Catalog Description">
	        <br />
	        <input type="text" name="measurementUnit" placeholder="Measurement Unit">
	        <br />
	        <input type="submit" value="Save"> <input type="reset" value="Reset">
	    </form>
		</div>
	</div>
	<hr />
	<div>(c) JDB 2019</div>
</body>
</html>