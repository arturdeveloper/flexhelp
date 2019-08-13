
<div class="col-10">
	<!-- <div class="card-deck"> -->
	<div class="row">

		<c:forEach var="offer" items="${offerList}">
			<div class="p-1 card market-display-card">
				<img class="card-img-top"
					src="${pageContext.request.contextPath }/resources/img/zapata3.jpg"
					alt="Card image cap">
				<div class=" card-body">
					<!-- 
					<p class="my-0 card-text">Provider level:</p>
				 -->
					<p class="my-0 card-text">Test: OfferId: ${offer.offerId }</p>
					<p class="my-0 card-text">Test: Location: ${offer.location }</p>
					<a class="card-text"
						href="${pageContext.request.contextPath }/offerdetails/${offer.offerId}">${offer.getCategory().catalogDescription }</a>
					<p class="my-0 card-text">Price: ${offer.price }</p>
				</div>
			</div>
		</c:forEach>

		<!-- 
		<div class="p-1 card market-display-card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath }/resources/img/zapata3.jpg"
				alt="Card image cap">
			<div class=" card-body">
				<p class="my-0 card-text">Seller level:</p>
				<a class="card-text" href="http://">Some quick example text to
					build on the card title and make up the bulk of the</a>
			</div>
		</div>
 -->

	</div>
</div>