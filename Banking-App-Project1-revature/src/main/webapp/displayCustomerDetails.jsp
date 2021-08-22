<%@page import="com.revature.banking.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Customer details</h2>
	<%
	List<Customer> customers = (List<Customer>) session.getAttribute("allCustomers");
	%>
	<table cellpadding="10" cellspacing="10">
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Registration Date</th>
		<th>Delete</th>
		<%
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
		%>
		<tr>
			<td><%= customer.getCustomerId() %></td>
			<td><%= customer.getCustomerName() %></td>
			<td><%= customer.getUserage() %></td>
			<td><%= customer.getMobileNumber() %></td>
			<td><%= customer.getAddress() %></td>
			<td><%= customer.getAmount() %></td>
			<td><a href="DeleteCustomerController?customerId=<%= customer.getCustomerId() %>">Delete</a></td>
		</tr>
		<%
		}
		%>

	</table>
<a href="EmployeeDisplay.jsp">Back</a>
</body>
</html>