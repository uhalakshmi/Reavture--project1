package com.revature.banking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.banking.model.Customer;
import com.revature.banking.service.CustomerService;
import com.revature.banking.service.CustomerServiceImpl;

public class UpdateCustomerByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCustomerByIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int customerid = Integer.parseInt(request.getParameter("customerid"));
		String customerName = request.getParameter("customername");
		int userage = Integer.parseInt(request.getParameter("userage"));
		String mobileNumber = request.getParameter("mobilenum");
		String address = request.getParameter("address");
		
		CustomerService customerService = new CustomerServiceImpl();
		HttpSession session = request.getSession();
		
		if(customerService.updateCustomer(customerid,customerName,userage ,mobileNumber,address))
		{
			String UpdateFail = "Customer Details successfully Updated";
			session.setAttribute("UpdateFail", UpdateFail);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCustomer.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			String UpdateFail = "Enter Valid CustomerId";
			session.setAttribute("UpdateFail", UpdateFail);
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateCustomer.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
