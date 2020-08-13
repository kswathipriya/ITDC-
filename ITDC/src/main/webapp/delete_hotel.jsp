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
		<h2>Delete Hotel</h2>
		
			<form onsubmit="return fnvalid_phno()", action="delete_hotel">
				<table id="tbl">
					<tr>
						<th>Hotel Name*</th>
						<td><input type="text" name="hname" id="hname" required="Name is required"></td>
					</tr>
					<tr>
						<th>Contact No*</th>
						<td><input type="number" name="phno" id="phno" required></td>
					</tr>
					<tr>
						<th></th>
						<td><button>Delete Hotel</button></td>
					</tr>
				</table>
			</form>
	</div>
</body>

</html>