<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Modal -->
<div class="modal fade" id="userLoginForm" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="card bg-primary text-center card-form">

					<h4 class="card-header"></h4>

					<div class="card-body">
						<h3>Log-in here</h3>
						<p>Please enter User name and Password to login</p>
						<form action="${pageContext.request.contextPath }/validateUser"
							method="post">
							<div class="form-group">
								<input type="text" name="uname"
									class="form-control form-control-lg" placeholder="User Name" />
							</div>

							<div class="form-group">
								<input type="password" name="password"
									class="form-control form-control-lg" placeholder="Password">
							</div>
							<div class="formAssist"></div>
							<input type="submit" value="Submit"
								class="btn btn-outline-light btn-block" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>