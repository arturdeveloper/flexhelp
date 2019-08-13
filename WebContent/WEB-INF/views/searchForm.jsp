<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>


<html>
<head>
	<%@include file="head.html"%>
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

		<div>Offer Registration Form</div>
		<div>
	        <form action="searchResults" method="post">
	            <input type="text" name="location" placeholder="Location"> <br />
	            <input type="text" name="fromPrice" placeholder="00"> <br />
	            <input type="text" name="toPrice" placeholder="00"> <br />
	            <input type="submit" value="Search"> <input type="reset" value="Reset">
	        </form>
		</div>
	</div>
	<hr />
	<div>(c) JDB 2019</div>
</body>
</html>