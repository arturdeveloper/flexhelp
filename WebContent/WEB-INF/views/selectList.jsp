<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-group" style="width:82.5%">
	<label for="categoryId">Select from below Categories</label> 
	<select
		class="form-control" name="categoryId" id="categoryId">
		<c:forEach var="category" items="${categoryList}">
			<option value="${category.catalogId }">${category.catalogTitle }</option>
		</c:forEach>
	</select>
</div>