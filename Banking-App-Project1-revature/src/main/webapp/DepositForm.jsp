<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/Style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
<title>Insert title here</title>
</head>
<body>
	<br/><br/><br/><br/>
	<div class="container">
			<form>
				<br/><br/>
				<div><h1>Hello <%= session.getAttribute("customerName") %>...!</h1>
					 <h3>Enter the Amount to Deposit</h3></div>
				<input type="number" placeholder="Enter Amount To Deposit" name="depositAmount" id="depositAmount"/>
				<div><%= session.getAttribute("DepositFail") %></div>
				<input type="submit" value="Deposit Amount" formaction="DepositController"><br/><br/><br/>
				<input type="submit" value="Exit" formaction="LoginDisplay.jsp">
			</form>
		</div>
</body>
</html>