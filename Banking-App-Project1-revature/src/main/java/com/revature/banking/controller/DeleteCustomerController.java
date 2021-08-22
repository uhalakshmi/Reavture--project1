package com.revature.banking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.banking.model.Customer;
import com.revature.banking.service.CustomerService;
import com.revature.banking.service.CustomerServiceImpl;


public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCustomerController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		CustomerService customerService = new CustomerServiceImpl();
		customerService.deleteCustomer(customerId);
		
		HttpSession session = request.getSession();
		List<Customer> customers = customerService.getCustomers();
		
		session.setAttribute("allCustomers", customers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayCustomerDetails.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
