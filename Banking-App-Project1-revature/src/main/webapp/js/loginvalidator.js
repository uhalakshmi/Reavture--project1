function loginValidate(){
	
	var customerId=document.getElementById("customerId").value;
	var password=document.getElementById("password").value;
	if(customerId.length==0){
		alert("Please enter your customerId");
		return false;
	}
	else if(password.length==0){
		alert("Please enter your password");
		return false;
	}
	else if(password.length<6 || password.length>10){
		alert("Password length must be 6 to 10 characters");
		return false;
	}
	else 
	{
		return true;
	}
}

function loginEmployeeValidate(){
	
	var employeeId=document.getElementById("employeeId").value;
	var password=document.getElementById("password").value;
	if(employeeId.length==0){
		alert("Please enter your employeeId");
		return false;
	}
	else if(password.length==0){
		alert("Please enter your password");
		return false;
	}
	else if(password.length<6 || password.length>10){
		alert("Password length must be 6 to 10 characters");
		return false;
	}
	else 
	{
		return true;
	}
}
