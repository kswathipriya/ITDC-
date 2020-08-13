<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>


<body>
	
	
	<div class="tbl">
			<table id="customers">
			<tr>
				<th>SNo</th>
				<th>Hotel Name</th>
				<th>Phone No</th>
				<th>Website</th>
				<th></th>
				
			</tr>
			<c:set var="count" value="0"></c:set>
			<c:forEach var="hotel" items="${list }">
				<form action="hotels_details">
					<tr>
						<td>
							<c:set var="count" value="${count+1}"></c:set>
							<c:out value="${count}"></c:out>
						</td>
						<td>${hotel.getHname() }</td>
						<td><input type="hidden" name="phno" value="${hotel.getPhno() }">${hotel.getPhno() }</td>
						<td><a href="https://${hotel.getWebsite()}">${hotel.getWebsite()}</a></td>
						<td><button type="submit">Details</button></td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>
</body>
</html>