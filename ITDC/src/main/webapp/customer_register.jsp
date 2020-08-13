<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Tourism</title>
	
</head>


<body>
	
		<div id="bdy">
		<h2>Register Customer</h2>
		
			<form onsubmit="return fnvalid_pincode()", action="register">
				<table id="tbl">
					<tr>
						<th>Customer Name*</th>
						<td><input type="text" name="name" id="name" required="Name is required"></td>
					</tr>
					<tr>
						<th>Password*</th>
						<td><input type="password" name="password" id="password" required="password is required"></td>
					</tr>
					<tr>
						<th>Contact No*</th>
						<td><input type="number" name="cno" id="cno" required></td>
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
						<th>Country*</th>
						<td><input type="text" name="country" id="country" required></td>
					</tr>
					<tr>
						<th>Pin Code*</th>
						<td><input type="number" name="pincode" id="pincode" required></td>
					</tr>
					<tr>
						<th>Put Money to Wallet*</th>
						<td><input type="number" name="wallet" id="wallet" required></td>
					</tr>
					<tr>
						<th></th>
						<td><button>Register</button></td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>