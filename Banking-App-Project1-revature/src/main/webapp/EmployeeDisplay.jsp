<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/Style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
<title>Insert title here</title>
<body>
<br/><br/><br/><br/>
	<div class="container">
			<form>
				<br/><br/><h1>Welcome to Banking App... <%= session.getAttribute("employeeName") %>...!</h1>
				<br/><br/>
				<input type="submit" value="View All Customers" formaction="PrintCustomerController">
				<input type="submit" value="View All Customer By Id" formaction="CustomerSearchById.jsp"><br/>
				<input type="submit" value="Update Customer Details" formaction="UpdateCustomer.jsp"><br/>
				<input type="submit" value="Delete Customers" formaction="DeleteById.jsp"><br/><br/><br/>
				<input type="submit" value="Exit" formaction="EmployeeLogin.html">
			</form>
		</div>
</body>
</html>