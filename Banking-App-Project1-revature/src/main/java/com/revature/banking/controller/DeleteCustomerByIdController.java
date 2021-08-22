package com.revature.banking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.revature.banking.service.CustomerService;
import com.revature.banking.service.CustomerServiceImpl;


public class DeleteCustomerByIdController extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;      
    
    public DeleteCustomerByIdController() {
        super();    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		HttpSession session = request.getSession();
		CustomerService customerService = new CustomerServiceImpl();
		if(customerService.deleteCustomer(customerId))
		{
			String DeleteMsg = "Customer Details successfully deleted";
			session.setAttribute("DeleteMsg", DeleteMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteById.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			String DeleteMsg = "Enter Valid CustomerId";
			session.setAttribute("DeleteMsg", DeleteMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteById.jsp");
			dispatcher.forward(request, response);
		}				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
