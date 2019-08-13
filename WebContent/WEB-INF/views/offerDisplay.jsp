
<!-- 
 -->
<div class="col">

	<div class="row justify-content-around">
		<div class="col-8">
			<h6 class="d-flex justify-content-center py-3">Personalized
				message from Provider</h6>
			<div class="p-1 card">
				<div class="card-header">
					<span class="px-2 card-text">Provider level: Level Two</span> <span
						class="px-2 card-text">Provider rating: 4.9</span>
				</div>
				<div class="card-body">
					<img class="card-img-bottom"
						src="${pageContext.request.contextPath }/resources/img/zapata3.jpg"
						alt="Card image cap" style="height: 50vh">
				</div>
				<div class="card-footer text-muted">
					Location: ${offer.location } <span>Price: ${offer.price }</span>
				</div>
			</div>

		</div>


		<div class="col-3">
			<h6 class="d-flex justify-content-center py-3"
				style="visibility: hidden"></h6>
			<div class="card text-center" style="height: 88%">
				<div class="card-header">
					<ul class="nav nav-tabs card-header-tabs">
						<li class="nav-item"><a class="nav-link active" href="#">Active</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
						</li>
					</ul>
				</div>
				<div class="card-body">
					<h5 class="card-title">Special title treatment</h5>
					<p class="card-text">Fast delivery.</p>
					<p class="card-text">Fast service.</p>
					<a href="${pageContext.request.contextPath }/comletepurchase/${offer.offerId}" class="btn btn-primary">Complete Purchase</a>
				</div>
			</div>

		</div>
	</div>

</div>
