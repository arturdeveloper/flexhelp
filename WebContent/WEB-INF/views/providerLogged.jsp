<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<%@include file="head.html"%>
<body>
	<div class="container-fluid">
		<%@include file="navbarLogged.html"%>
		<header> </header>

		<hr />

		<main>
		<div class="row">
			<%@include file="mainNavigation.jsp"%>


			<c:if test="${offerToUpdate == null}">
				<%@include file="providerDisplay.jsp"%>
			</c:if>
			<c:if test="${offerToUpdate != null}">
				<%@include file="providerDisplayUpdate.jsp"%>
			</c:if>

		</div>
		</main>
		<footer class="pt-4 my-md-5 pt-md-5 border-top">
			<%@include file="footerSection.jsp"%>
		</footer>

		<%@include file="bodyScritps.html"%>
	</div>
</body>
</html>