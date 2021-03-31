<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place List</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body class="img js-fullheight"
	style="background-image: url(images/bg.jpg);">
	<div class="row justify-content-center">
		<h6 class="mb-4">
			<a href="<spring:url value='/admin-home'/>">Home</a> | <a
				href="<spring:url value='/admin-customer-list'/>">Customers</a> | 
				<a href="<spring:url value='/admin-invoice-list'/>">Invoice List</a> | <a
				href="<spring:url value='/admin-logout'/>">Logout</a>
		</h6>
	</div>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Place Details</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-bordered table-dark table-hover">
								<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Add</th>
			<th>Show</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="p" items="${requestScope.place_list}">
			<tr>
				<td>${p.placeId}</td>
				<td>${p.name}</td>
				<td>${p.address}</td>
				<td><a href="<spring:url value='/admin-add-slot?pid=${p.placeId}'/>"class="px-2 py-2 mr-md-1 rounded">Add Slots</a></td>
				<td><a href="<spring:url value='/admin-slot-list?pid=${p.placeId}'/>"class="px-2 py-2 mr-md-1 rounded">Show Slots</a></td>
				<td><a href="<spring:url value='/admin-remove-place?pid=${p.placeId}'/>"class="px-2 py-2 mr-md-1 rounded">Remove</a></td>

			</tr>
		</c:forEach>
						</table>
						<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<div class="social d-flex text-center">
							<a href="<spring:url value='/admin-add-place'/>"
								class="px-2 py-2 mr-md-1 rounded">Add Place </a>
						</div>
					</div>
				</div>
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