<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br/><br/><br/><br/>
	<div class="container">
			<form>
				<br/><br/>
				<div><h1>Hello <%= session.getAttribute("customerName") %>...!</h1>
					 <h2>Your Current Account Balance is : <%= session.getAttribute("currentBalance") %></h2> </div>
				<input type="submit" value="WithDraw Amount" formaction="WithdrawForm.jsp"><br/>
				<input type="submit" value="Deposit Amount" formaction="DepositForm.jsp"><br/>
				<input type="submit" value="Transfer Amount To Account" formaction="TransferAmount.jsp"><br/><br/><br/>
				<input type="submit" value="Exit" formaction="LoginDisplay.jsp">
			</form>
		</div>
	</div>
</body>
</html>