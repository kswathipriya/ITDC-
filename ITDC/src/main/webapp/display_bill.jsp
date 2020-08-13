<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	
	<div class="bill">
		<form action="confirm_bill">
		
			<p>Your Phone no</p>
			<input type="hidden" name=cphno value="${phno }">
			<h3>${phno }</h3>
			
			<p>Hotel Name</p>
			<input type="hidden" name=hname value="${hname }">
			<h3>${hname }</h3>
			
			<p>No Of Rooms</p>
			<input type="hidden" name=wrooms value="${wrooms }">
			<h3>${wrooms}</h3>
			
			<p>No Of Days</p>
			<input type="hidden" name=days value="${days }">
			<h3>${days}</h3>
			
			<p>From Date</p>
			<input type="hidden" name=fdate value="${fdate }">
			<h3>${fdate}</h3>
			
			<p>End Date</p>
			<input type="hidden" name=edate value="${edate }">
			<h3>${edate}</h3>
			
			<p>Total Rent</p>
			<input type="hidden" name=trent value="${rent*wrooms*days }">
			<h3>${rent*wrooms*days}</h3>
			
			<h4>If you confirm rent will detect from your account</h4>
			
			<button>Confirm and pay</button>
		
		</form>
	</div>
</body>
</html>