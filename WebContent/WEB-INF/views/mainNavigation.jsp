<!-- 
<nav class="col-md-2 d-none d-md-block">
 -->
<div class="col-2">
	<br />
	<%@include file="mainNavOffers.jsp"%>

	<br />
	<div class="bg-light sidebar">
		<h6 class="d-flex flex-column align-items-center py-1">Select
			Filters</h6>
		<!-- 
		<form name="filterForm">
			 -->
		<form action="searchResults" method="post">
			<label class="row d-flex-inline justify-content-center"
				for="location">Location</label>
			<div class="row d-flex-inline justify-content-center">
				<input type="text" class="row" name="location" />
			</div>
			<div class="row d-flex-inline justify-content-center py-1">Budget
				$</div>
			<div class="row px-1">
				<div class="col-6 d-flex flex-column align-items-center">
					<label for="budgetStart">From</label> <input type="text"
						class="form-control" name="fromPrice" />
				</div>
				<div class="col-6 d-flex flex-column align-items-center">
					<label for="budgetEnd">To</label> <input type="text"
						class="form-control" name="toPrice" />
				</div>
			</div>

			<div class="dropdown d-flex justify-content-center py-1">
				<button type="button" class="dropdown-toggle" data-toggle="dropdown"
					name="provLevel">Provider level</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" value="0">New Provider</a> <a
						class="dropdown-item" value="1">Level One</a> <a
						class="dropdown-item" value="2">Level Two</a>
				</div>
			</div>
			<div class="row">
				<div class="col d-flex justify-content-center">
					<input type="submit" value="Apply filters" class="btn btn-primary" />
				</div>
			</div>
		</form>
	</div>
</div>
<!-- 
</nav>
	 -->