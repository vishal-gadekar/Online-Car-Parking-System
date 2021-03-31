<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
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
			<a href="<spring:url value='/customer-logout'/>">Logout</a>
		</h6>
	</div>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Welcome ${requestScope.customer_details.firstName}</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Menu</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<div class="social d-flex text-center">
							<a href="<spring:url value='/customer-place-list'/>"
								class="px-2 py-2 mr-md-1 rounded">Places Available</a> <a
								href="<spring:url value='/customer-book-slot'/>"
								class="px-2 py-2 mr-md-1 rounded">Book Parking</a><a
								href="<spring:url value='/customer-booking'/>"
								class="px-2 py-2 mr-md-1 rounded">Booking Details</a> <a
								href="<spring:url value='/customer-invoice'/>"
								class="px-2 py-2 mr-md-1 rounded">Booking History</a>
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