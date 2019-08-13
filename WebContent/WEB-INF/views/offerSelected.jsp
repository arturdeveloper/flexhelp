<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<%@include file="head.html"%>
<body>
	<div class="container-fluid">
		<c:if test="${userLogin.id < 0}">
			<%@include file="navbar.html"%>
		</c:if>
		<c:if test="${userLogin.id > 0}">
			<%@include file="navbarLogged.html"%>
		</c:if>

		<c:if test="${userLogin.id < 0}">
			<%@include file="userLogin.jsp"%>
			<%@include file="customerRegistration.jsp"%>
			<%@include file="providerRegistration.jsp"%>
		</c:if>
		<header></header>

		<hr />

		<main>
		<div class="row d-flex justify-content-center">
			<%@include file="offerDisplay.jsp"%>

		</div>
		</main>
		<footer class="pt-4 my-md-5 pt-md-5 border-top">
			<%@include file="footerSection.jsp"%>
		</footer>

		<%@include file="bodyScritps.html"%>
		
		<c:if test="${loginFailed}">
			<%@include file="errorNeedToLogin.html"%>
		</c:if>
	</div>
</body>
</html>