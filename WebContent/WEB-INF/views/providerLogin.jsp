<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>


<html>
<head>
	<%@include file="head.html"%>
</head>
<body>

	<div id="header" style="background-color: lightblue; height: 150px;">
		<%@include file="navbar.html"%>
		<%@include file="header.html"%>
	</div>
	<hr />
	<div>

		<a href="addCatalogItem">Add Catalog Item |</a> <a
			href="updateEmployee">Update Employee |</a> <a href="showEmployees">Show
			All Employees |</a> <br />

		<%@include file="cataloglist.jsp"%>

		<div>Provider Login Form</div>
	    <div>
	        <form action="validateUser" method="post">
	            <input type="text" name="uname" placeholder="User Name">
	            <br />
	            <input type="text" name="password" placeholder="User Password">
	            <br />
	            <input type="submit" value="Login"> <input type="reset" value="Reset">
	        </form>
	    </div>
	</div>
	<hr />
	<div>(c) JDB 2019</div>
</body>
</html>