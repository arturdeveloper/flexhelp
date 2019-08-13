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
		<div>Provider ${userLogin.uname} is currently logged</div>
		<div>
			<form action="addService" method="post">
				<input type="text" name="offerId" placeholder="Offer id"> <br />
				<!-- <input type="text" name="categoryId" placeholder="Category dd"> <br />  -->
				<%@include file="selectList.jsp" %> <br /> 
				<!-- <input type="text" name="providerId" placeholder="ProvId session"> <br />   -->
				<input type="hidden" name="providerId" value="${userLogin.id}" > <br />
				<input type="text" name="price" placeholder="Price"> <br />
				<input type="text" name="location" placeholder="Location"> <br />
				<input type="text" name="discountCriteria" placeholder="Enter criteria"> <br />
				<input type="submit" value="Save"> <input
					type="reset" value="Reset">
			</form>
		</div>
	</div>
	<hr />
	<div>(c) JDB 2019</div>
</body>
</html>