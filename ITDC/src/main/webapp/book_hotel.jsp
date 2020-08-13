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
			<form action="pay">
				<table id="tbl">
					<tr>
						<th>Registered Phone No</th>
						<td><input type="number" name="phno" id="phno" required></td>
					</tr>
					<tr>
						<th>How Many Rooms You Want?</th>
						<td><input type="number" name="wrooms" id="wrooms" required></td>
					</tr>
					<tr>
						<th>How Many Days You Want?</th>
						<td><input type="number" name="days" id="days" required></td>
					</tr>
					<tr>
						<th>From Date</th>
						<td><input type="date" name="fdate" id="fdate" required></td>
					</tr>
					<tr>
						<th>End Date</th>
						<td><input type="date" name="edate" id="edate" required></td>
					</tr>
					<tr>
						<th></th>
						<td><button>Pay for Bill</button></td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>