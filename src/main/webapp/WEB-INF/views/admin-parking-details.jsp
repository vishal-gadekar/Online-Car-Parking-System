<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice List</title>
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
				href="<spring:url value='/admin-customer-list'/>">Customers</a> | <a
				href="<spring:url value='/admin-place-list'/>">Place List</a> | <a
				href="<spring:url value='/admin-logout'/>">Logout</a>
		</h6>
	</div>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Parking Details</h2>
				</div>
				<div class="row justify-content-right">
				<div class="col-md-18 text-center mb-5">
					<a href="<spring:url value='/admin-parking-advance'/>">Advance Search</a>
				</div>
			</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-bordered table-dark table-hover">
							<tr>
								<th>Date</th>
								<th>Customer First Name</th>
								<th>Customer Last Name</th>
								<th>Phone No</th>
								<th>Vehicle No</th>
								<th>Slot No</th>
								<th>Entry Time</th>
								<th>Exit Time</th>
							</tr>
							<c:forEach var="p" items="${requestScope.parking_details}">
								<tr>
									<td>${p.date}</td>
									<td>${p.custFirstName}</td>
									<td>${p.custLastName}</td>
									<td>${p.custPhoneNo}</td>
									<td>${p.vehicleNo}</td>
									<td>${p.slotId}</td>
									<td>${p.entryTime}</td>
									<td>${p.exitTime}</td>
								</tr>
							</c:forEach>
						</table>
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