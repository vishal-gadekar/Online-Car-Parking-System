<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Place</title>
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
			<a href="<spring:url value='/admin-place-list'/>">Go to Place List</a>
		</h6>
	</div>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Add Place</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<form:form method="post" modelAttribute="place"
						class="register-form">
						<div class="form-group">
							<form:input type="text" class="form-control" path="name"
								placeholder="Enter Name of Place" />
						</div>
						<div class="form-group">
							<form:input type="text" class="form-control" path="address"
								placeholder="Enter Address" />
						</div>
						<div class="form-group">
							<button type="submit"
								class="form-control btn btn-primary submit px-3">Add Place
							</button>
						</div>
					</form:form>
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