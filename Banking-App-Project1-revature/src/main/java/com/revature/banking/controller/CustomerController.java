package com.revature.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.banking.model.Customer;
import com.revature.banking.service.CustomerService;
import com.revature.banking.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerName = request.getParameter("customername");
		String password = request.getParameter("password");
		int userage = Integer.parseInt(request.getParameter("userage"));
		String mobileNumber = request.getParameter("mobilenum");
		String address = request.getParameter("address");
		int amount = Integer.parseInt(request.getParameter("amount"));

		Customer customer = new Customer(0,customerName, password,userage ,mobileNumber,address,amount);
		
		CustomerService customerService = new CustomerServiceImpl();
		int customerId = customerService.addCustomer(customer);
		
		response.setContentType("text/html");
		
		if(customerId !=0)
		{
			response.getWriter().println("<h1> "+customerName +",Congrats you have Successfully Opened an account in our bank with balance of INR "+ amount);
			response.getWriter().println("<h1> Please note your  customer id for future logins :"+customerId);
			response.getWriter().println("<h1> <br/><br/><a href=CustomerLogin.html>Login</a>");
		}
		else
		{
			response.getWriter().println("<h1> Please Enter valid amount to signup");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
