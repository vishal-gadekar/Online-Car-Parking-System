<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
			<a href="<spring:url value='/aboutus'/>">About</a>
		</h6>
	</div>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Welcome to Online Car Parking System</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
					<h6 class="mb-4 text-center" style="color:red;">${message}</h6>
						<h3 class="mb-4 text-center">Have an account? Sign In</h3>
						<form method="post" class="signin-form">
							<div class="form-group">
								<input type="text" class="form-control" name="email"
									placeholder="Enter Email" required>
							</div>
							<div class="form-group">
								<input id="password-field" type="password" name="password"
									class="form-control" placeholder="Enter Password" required>
							</div>
							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3">Sign
									In</button>
							</div>
						</form>
						<div class="row justify-content-center">
							<h6 class="mb-4 text-center">
								Don't Have an account? <a
									href="<spring:url value='/customer-register'/>">Register
									Here</a>
							</h6>
						</div>
						<div class="row justify-content-center">
							<h6 class="mb-4 text-center">
								If YOU ARE ADMIN/STAFF PLEASE <a
									href="<spring:url value='/admin-login'/>">CLICK HERE</a>
							</h6>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>