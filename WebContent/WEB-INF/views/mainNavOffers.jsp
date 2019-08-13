
<nav class="sidebar-sticky bg-light sidebar">
	<h6 class="d-flex flex-column align-items-center py-1">Select
		offers</h6>

	<ul class="nav flex-column">
		<c:forEach var="category" items="${categoryList}">
			<li class="nav-item"><a class="nav-link active"
				href="${pageContext.request.contextPath }/category/${category.catalogId}"> ${category.catalogTitle}
			</a></li>
		</c:forEach>

	</ul>
</nav>