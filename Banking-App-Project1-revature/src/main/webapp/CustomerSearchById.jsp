<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	

</head>
<body>
<br/><br/><br/><br/>
	<div class="container">
			<form>
				<br/><br/><h3 align="center">Enter Customer Id to Search</h3>
				<br/><br/>
				<h4>Customer ID : </h4><br/>
				<input type="text" placeholder="customerId" id="customerId" name="customerId"><br/>
				<input type="submit" value="View All Customer By Id" formaction="SearchCustomerByIdController"><br/><br/>
				<input type="submit" value="Exit" formaction="LoginDisplay.jsp">
			
			</form>
		</div>

</body>
</html>