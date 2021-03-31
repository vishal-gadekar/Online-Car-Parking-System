<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css">
</head>
<body class="img js-fullheight"
	style="background-image: url(images/bg.jpg);">
	<div class="row justify-content-center">
		<h6 class="mb-4">
			<a href="<spring:url value='/admin-login'/>">Go To Login</a>
		</h6>
	</div>
	<!-- <section class="ftco-section"> -->
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">REGISTER</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<form:form method="post" modelAttribute="admin"
						class="register-form">
						<div class="form-group">
							<form:input type="text" class="form-control" path="firstName"
								placeholder="Enter First Name" />
								<form:errors path="firstName" />
						</div>
						<div class="form-group">
							<form:input type="text" class="form-control" path="lastName"
								placeholder="Enter First Name" />
								<form:errors path="lastName" />
						</div>
						<div class="form-group">
							<form:input type="text" class="form-control" path="email"
								placeholder="Enter Email" />
								<form:errors path="email" />
						</div>
						<div class="form-group">
							<form:input type="password" class="form-control" path="password"
								placeholder="Enter Password" />
								<form:errors path="password" />
						</div>
						<div class="form-group">
							<form:input type="text" class="form-control" path="phoneNo"
								placeholder="Enter Mobile No" />
								<form:errors path="phoneNo" />
						</div>
						<div class="form-group">
							<button type="submit"
								class="form-control btn btn-primary submit px-3">Register
							</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	<!-- </section> -->

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>