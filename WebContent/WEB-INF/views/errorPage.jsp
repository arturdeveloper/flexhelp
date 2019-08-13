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
	<%-- remove scriplet below --%>
	<%
		request.getParameter("location");
		String message = "Hello";
		session.setAttribute("offerList", message);
	%>
	
	<hr />
	
	<%@include file="htmlErrorPage.html"%>
	<hr />
	<div>(c) JDB 2019</div>
</body>
</html>