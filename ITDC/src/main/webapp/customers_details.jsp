<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
			<table border=2>
			<tr>
				<th>Customer Name</th>
				<th>Customer PhoneNo</th>
				<th>City</th>
				<th>State</th>
				<th>Country</th>
				<th>PinCode</th>
				<th>Wallet</th>
			</tr>
			<c:forEach var="bd" items="${list }">
				<tr>
					<td>${bd.getName()}</td>
					<td>${bd.getCno()}</td>
					<td>${bd.getCity()}</td>
					<td>${bd.getState()}</td>
					<td>${bd.getCountry()}</td>
					<td>${bd.getPincode()}</td>
					<td>${bd.getWallet()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>