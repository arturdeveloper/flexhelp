
<div class="col-10">

	<div class="form-row">
		<div class="col-4">
			<h4 class="py-4 feedbackStyle">${cbMessage}</h4>
		</div>

		<div class="col-8">
			<h6 class="d-flex justify-content-center py-3">Your Transaction
				history</h6>
			<div id="accordion" class="providerAccordion">

				<c:forEach var="order" items="${orderList}">
					<div class="card">
						<div class="card-header" id="headingOne">
							<h5 class="mb-0">
								<button class="btn btn-link" data-toggle="collapse"
									data-target="#collapse${order.orderId}" aria-expanded="true"
									aria-controls="collapse${order.orderId}">${order.orderId}
									${order.getOffer().getCategory().catalogTitle }</button>
							</h5>
						</div>

						<div id="collapse${order.orderId}" class="collapse show"
							aria-labelledby="headingOne" data-parent="#accordion">
							<div class="card-body">${order.getOffer().getCategory().catalogDescription }
								<div>
									Order ID: <span>${order.orderId}</span>
								</div>
								<div>
									Date ordered <span>${order.getOrderStartDate().toString()}</span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>

		</div>
	</div>

	<script type="text/javascript">
		let elem = document.querySelector(".feedbackStyle");
		console.log(elem);

		elem.style.color = "red";

		setTimeout(function() {
			elem.innerText = ""
		}, 3000);
		/*
		elem.style.color = "red";
		elem.innerText = "Yay, first Customer transaction on our web site :)"

		setTimeout(
			function() {
				elem.innerText = "But Salah wanted to see a thank you message here..."
			}, 10000);
		setTimeout(function() {
		elem.innerText = "Let's give him that :)"
		}, 20000);
		setTimeout(function() {
		elem.style.color = "black";
		elem.innerText = "Thank you for buying the item."
		}, 23000);
		 */
	</script>

</div>