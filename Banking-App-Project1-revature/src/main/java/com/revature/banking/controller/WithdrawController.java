package com.revature.banking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.banking.service.CustomerService;
import com.revature.banking.service.CustomerServiceImpl;


public class WithdrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public WithdrawController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		int amount= Integer.parseInt(request.getParameter("withdrawAmount"));
		
		response.setContentType("text/html");
		
		CustomerService customerService = new CustomerServiceImpl();
		if(customerService.withdraw(customerId, amount))
		{
			int balance = customerService.viewBalance(customerId);
			session.setAttribute("currentBalance", balance);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewBalance.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			int balance = customerService.viewBalance(customerId);
			session.setAttribute("currentBalance", balance);
			String WithdrawFail = "Please Enter Valid Amount to Withdraw";
			session.setAttribute("WithdrawFail", WithdrawFail);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WithdrawForm.jsp");
			dispatcher.forward(request, response);
		}
			
			
		
	}

}
