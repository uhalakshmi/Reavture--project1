function validate(){
		var customername = document.getElementById("customername").value
		var password = document.getElementById("password").value
		var confirmpassword = document.getElementById("confirmpassword").value
		var userage = document.getElementById("userage").value
		var mobilenum = document.getElementById("mobilenum").value
		var address = document.getElementById("address").value
		var amount = document.getElementById("amount").value

		//Todo
		//validate gender
		//validate notifications
		//validate payment options
		
		if(customername.length ==0)
		{
			alert("customer name is mandatory");
			return false;
		}
		else if(password.length ==0)
		{
				alert("Password is mandatory");
				return false;
		}
		else if(password.length<6 || password.length>10){
			alert("Password length must be 6 to 10 characters");
			return false;
		}
		else if(confirmpassword.length ==0)
		{
				alert("Confirm Password is mandatory");
				return false;
		}
		else if(confirmpassword != password)
		{
				alert("Confirm Password and password must be same");
				return false;
		}
		else if(userage.length ==0)
		{
				alert("userage is mandatory");
				return false;
		}
		else if(mobilenum.length ==0)
		{
				alert("mobile number is mandatory");
				return false;
		}
		else if(address.length ==0)
		{
				alert("address is mandatory");
				return false;
		}
		else if(amount.length ==0)
		{
				alert("Amount is mandatory");
				return false;
		}
		else
		{
			return true;
		}
		
}



