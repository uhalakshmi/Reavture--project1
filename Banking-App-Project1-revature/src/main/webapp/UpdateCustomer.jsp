<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br/><br/><br/><br/>
	<div class="container">
			<form class="form1">
				<h4>Please Enter Details to Update</h4>
				<input type="text" placeholder="customerid" name="customerid" id="customerid"/>
				<input type="text" placeholder="customername" name="customername" id="customername"/>
				<input type="number" placeholder="userage" name="userage" id="userage"/>
				<input type="text" placeholder="Mobile Number" name="mobilenum" id="mobilenum"/>
				<input type="text" placeholder="Address" name="address" id="address"/>
				<br/><br/>
				<input type="submit" value="Update" formaction="UpdateCustomerByIdController">
				<div><%= session.getAttribute("UpdateFail") %></div>
				<input type="submit" value="Exit" formaction="EmployeeDisplay.jsp">
			
			</form>
	</div>
</body>
</html>