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
<link rel="stylesheet" href="css/search.css">

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
	<div class="container">

	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">Search By Date</li>
		<li class="tab-link" data-tab="tab-2">Search By Name</li>
		<li class="tab-link" data-tab="tab-3">Search By Vehicle</li>
		<li class="tab-link" data-tab="tab-4">Search By Slot ID</li>
	</ul>

	<div id="tab-1" class="tab-content current">
		<form class="searchform cf" action="admin-parking-date">
 					 			<input type="date" placeholder="Enter Date" name="date">
 					 			<button type="submit">Search</button>
							</form>
	</div>
	<div id="tab-2" class="tab-content">
		<form class="searchform cf" action="admin-parking-name">
 					 			<input type="text" placeholder="Enter Name" name="name">
 					 			<button type="submit">Search</button>
						</form>
	</div>
	<div id="tab-3" class="tab-content">
		<form class="searchform cf" action="admin-parking-vehicle">
 					 			<input type="text" placeholder="Enter Vehicle No." name="vehicle">
 					 			<button type="submit">Search</button>
						</form>
	</div>
	<div id="tab-4" class="tab-content">
		<form class="searchform cf" action="admin-parking-slot">
 					 			<input type="text" placeholder="Enter Slot ID" name="id">
 					 			<button type="submit">Search</button>
						</form>
	</div>

</div><!-- container -->
<div><br><br></div>
<section>
			
			
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Parking Details</h2>
				</div>
				<div class="row justify-content-right">
				<div class="col-md-18 text-center mb-5">
					<a href="<spring:url value='/admin-parking-details'/>">All Details</a>
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
							<c:forEach var="p" items="${requestScope.parking_search}">
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
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
	<script src="js/search.js"></script>

</body>
</html>