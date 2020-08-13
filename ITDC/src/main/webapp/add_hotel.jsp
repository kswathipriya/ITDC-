<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Tourism</title>
</head>
<body>
	
		<div id="bdy">
		<h2>Add Hotel</h2>
		
			<form onsubmit="return fnvalid_pincode()", action="add_hotel">
				<table id="tbl">
					<tr>
						<th>Hotel Name*</th>
						<td><input type="text" name="hname" id="hname" required="Name is required"></td>
					</tr>
					<tr>
						<th>Contact No*</th>
						<td><input type="number" name="phno" id="cno" required></td>
					</tr>
					<tr>
						<th>Flat No</th>
						<td><input type="text" name="flatno" id="flatno"></td>
					</tr>
					<tr>
						<th>City*</th>
						<td><input type="text" name="city" id="city" required></td>
					</tr>
					<tr>
						<th>State*</th>
						<td><input type="text" name="state" id="state" required></td>
					</tr>
					<tr>
						<th>Web site</th>
						<td><input type="text" name="website" id="website"></td>
					</tr>
					<tr>
						<th>Country*</th>
						<td><input type="text" name="country" id="country" required></td>
					</tr>
					<tr>
						<th>Pin Code*</th>
						<td><input type="number" name="pincode" id="pincode" required></td>
					</tr>
					<tr>
						<th>Total Rooms*</th>
						<td><input type="number" name="trooms" id="trooms" required></td>
					</tr>
					<tr>
						<th>Available Rooms*</th>
						<td><input type="number" name="uvrooms" id="uvrooms" required></td>
					</tr>
					<tr>
						<th>Rent per Room*</th>
						<td><input type="number" name="rent" id="rent" required></td>
					</tr>
					<tr>
						<th></th>
						<td><button>Add Hotel</button></td>
					</tr>
				</table>
			</form>
	</div>
</body>

</html>