<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Modal -->
<div class="modal fade" id="customerJoinForm" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="card bg-primary text-center card-form">
					<div class="card-body">
						<h3>Join As Customer</h3>
						<p>Please fill out this form to register</p>

						<form:form action="addCustomer" method="post"
							modelAttribute="userkey">
							<div class="form-group">
								<form:input type="text" id="uname" path="uname"
									class="form-control form-control-lg" placeholder="User Name" />
								<form:errors path="uname" />
							</div>
							<div class="form-group">
								<form:input type="text" id="email" path="email"
									class="form-control form-control-lg" placeholder="Email" />
								<form:errors path="email" />
							</div>
							<div class="form-group">
								<input type="password" name="password"
									class="form-control form-control-lg" placeholder="Password">
							</div>
							<div class="formAssist"></div>
							<input type="submit" value="Submit"
								class="btn btn-outline-light btn-block" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 
This is used for sign up not for sign in
action="addCustomer" method="post"
 -->