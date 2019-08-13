
<div class="row justify-content-around w-50 mb-3">
	<a href="${pageContext.request.contextPath }/update/${offer.offerId}"
		class="btn btn-primary mx-3">Update</a>

	<form
		action="${pageContext.request.contextPath }/delete/${offer.offerId}"
		method="post">
		<input type="submit" class="btn btn-primary" value="Delete">
	</form>
</div>

<!-- 
<div class="mb-3">
	<input type="submit" value="Update" class="btn btn-primary mx-3">
	<input type="reset" value="Delete" class="btn btn-primary">
	<a
		href="${pageContext.request.contextPath }/update/${offer.offerId}"
		class="btn btn-primary mx-3">Update</a> <a
		href="${pageContext.request.contextPath }/delete/${offer.offerId}"
		class="btn btn-primary">Delete</a>
</div>
 -->