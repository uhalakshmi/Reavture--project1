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
				<div><h1>Hello <%= session.getAttribute("customerName") %>...!</h1></div>
				<h2>Enter the Recipient ID :</h2>
				<input type="number" placeholder="Recipient Id" name="recipientid" id="recipientid"/>
				<h2>Enter the Amount to transfer :</h2>	 
				<input type="number" placeholder="Amount" name="transferAmount" id="transferAmount"/>
				<div><%= session.getAttribute("TransferFail") %></div>
				<input type="submit" value="Transfer Amount" formaction="TransferAmountController"><br/>
				<input type="submit" value="Exit" formaction="LoginDisplay.jsp">
			</form>
		</div>
</body>
</html>