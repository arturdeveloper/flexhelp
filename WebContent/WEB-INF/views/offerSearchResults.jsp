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

		<div>Filtered offer results</div>
		<div>
		<hr />
			<c:forEach var="offer" items="${offerList}">
				<p>${offer.offerId }</p>
				<p>${offer.category.catalogTitle }</p>
				<p>${offer.provider.uname }</p>
				<p>${offer.price }</p>
				<p>${offer.location }</p>
				<hr />
			</c:forEach>
		</div>
	</div>
	<hr />
	<%-- remove scriplet below --%>
	<%
	request.getParameter("location");
	String message = "Hello";
	session.setAttribute("offerList", message);
	%>
	<div>(c) JDB 2019</div>
</body>
</html>