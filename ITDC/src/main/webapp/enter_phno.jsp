<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Tourism</title>
</head>
<body>
		<div id="bdy">
			<form action="past_bookings">
				<table id="tbl">
					<tr>
						<th>Registered Phone No</th>
						<td><input type="number" name="phno" id="phno" required></td>
					</tr>
					<tr>
						<th></th>
						<td><button>Get Details</button></td>
					</tr>
				</table>
			</form>
	</div>

</body>
</html>