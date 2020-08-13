<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	
	
	<div class="tbl">
			<table id="customers">
			<tr>
				<th>Hotel Name</th>
				<th>Phone No</th>
				<th>Flat No</th>
				<th>City</th>
				<th>State</th>
				<th>Website</th>
				<th>Country</th>
				<th>Pincode</th>
				<th>Total Rooms</th>
				<th>Available Rooms</th>
				<th>Rent</th>
				<th></th>
			</tr>
			<c:forEach var="hotel" items="${list }">
				<form action="choose_rooms">
					<tr>
						<td><input type="hidden" name="hname" value="${hotel.getHname()}">${hotel.getHname()}</td>
						<td><input type="hidden" name="phno" value="${hotel.getPhno()}">${hotel.getPhno() }</td>
						<td>${hotel.getFlatno() }</td>
						<td>${hotel.getCity() }</td>
						<td>${hotel.getState() }</td>
						<td><a href="https://${hotel.getWebsite()}">${hotel.getWebsite()}</a></td>
						<td>${hotel.getCountry() }</td>
						<td>${hotel.getPincode() }</td>
						<td>${hotel.getTrooms() }</td>
						<td>${hotel.getUvrooms() }</td>
						<td><input type="hidden" name="rent" value="${hotel.getRent()}">${hotel.getRent() }</td>
						<td><button>Book Hotel</button></td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>
</body>
</html>