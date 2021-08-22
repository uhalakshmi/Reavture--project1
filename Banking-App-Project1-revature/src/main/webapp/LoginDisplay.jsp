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
    <header>
		<br>
		<h3>LOGIN/SIGNUP PAGE</h3>
		<br>
	</header>
<br/><br/><br/><br/>
	<div class="container">
			<form>
				<br/><br/><h1>Welcome to Banking App... <%= session.getAttribute("customerName") %>...!</h1>
				<br/><br/>
				<input type="submit" value="View Balance" formaction="ViewBalanceController">
				<input type="submit" value="WithDraw Amount" formaction="WithdrawForm.jsp"><br/>
				<input type="submit" value="Deposit Amount" formaction="DepositForm.jsp"><br/>
				<input type="submit" value="Transfer Amount To Another Account" formaction="TransferAmount.jsp"><br/><br/><br/>
				<input type="submit" value="Exit" formaction="CustomerLogin.jsp">
			</form>
		</div>
</body>
</html>