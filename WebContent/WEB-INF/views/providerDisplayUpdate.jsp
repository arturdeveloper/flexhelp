
<div class="col-10">

	<div class="form-row">
		<div class="col-4">
			<h6 class="d-flex justify-content-center py-3">Offer
				Registration Form</h6>
			<form
				action="${pageContext.request.contextPath }/update/${offerToUpdate.offerId}"
				method="post">

				<%@include file="selectList.jsp"%>

				<div class="form-group row">
					<div class="col-sm-10">
						<input type="text" class="form-control" name="price"
							placeholder="Price" value="${offerToUpdate.price}">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-10">
						<input type="text" class="form-control" name="location"
							placeholder="Enter City" value="${offerToUpdate.location}">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-10">
						<input type="text" class="form-control" name="discountCriteria"
							placeholder="Acceptance Criteria"
							value="${offerToUpdate.discountCriteria}">
					</div>
				</div>

				<input type="submit" value="Update" class="btn btn-primary">
			</form>

			<div class="py-4 feedbackStyle">${cbMessage}</div>

		</div>

		<div class="col-8">
			<h6 class="d-flex justify-content-center py-3">Your Marketplace
				listed items</h6>
			<div id="accordion" class="providerAccordion">

				<c:forEach var="offer" items="${offerList}">
					<div class="card">
						<div class="card-header" id="headingOne">
							<h5 class="mb-0">
								<button class="btn btn-link" data-toggle="collapse"
									data-target="#collapse${offer.offerId}" aria-expanded="true"
									aria-controls="collapse${offer.offerId}">${offer.offerId}
									${offer.getCategory().catalogTitle }</button>
							</h5>
						</div>

						<div id="collapse${offer.offerId}" class="collapse show"
							aria-labelledby="headingOne" data-parent="#accordion">
							<div class="card-body">
								${offer.getCategory().catalogDescription }
								<div class="my-2">
									<div>Price: ${offer.price}</div>
									<div>Location: ${offer.location}</div>
									<div>Customer Acceptance Criteria:
										${offer.discountCriteria}</div>
								</div>
							</div>

							<%@include file="providerDisplayButtons.jsp"%>

						</div>
					</div>
				</c:forEach>

			</div>

		</div>
	</div>

	<script type="text/javascript">
		let elem = document.querySelector(".feedbackStyle");

		elem.style.color = "red";
		setTimeout(function() {
			elem.innerText = ""
		}, 2000);
	</script>

</div>