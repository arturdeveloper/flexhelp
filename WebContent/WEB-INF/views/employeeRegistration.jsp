<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<!-- Simple DB iterating to routing -->

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello Jsp</h3>

	<hr />
	<p>Content goes here</p>

<!-- 
	<a href="addEmployee">Add Employee |</a>
 -->
	<a href="RegisterEmployee">Add Employee |</a>
	<a href="showEmployees">Show All Employees |</a>
	<br />
	
	<div>
	
	<div>EMPLOYEE REGISTRATION FORM</div>
	<div>
		<form action="addEmployee" method="post">
			<input type="text" name="id" placeholder="enter id">
			<br/>
			<input type="text" name="firstName" placeholder="enter First Name">
			<br/>
			<input type="text" name="lastName" placeholder="enter Last Name">
			<br/>
			<input type="text" name="email" placeholder="enter Email">
			<br/>
			
			<input type="submit" value="Save">
			<input type="reset" value="Reset">
		</form>
	</div>
	
	</div>
	<hr />
	<div>
		(c) JDB 2019
	</div>
	
</body>
</html>