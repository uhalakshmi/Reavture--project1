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

/**
 * Servlet implementation class DepositController
 */
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		int amount= Integer.parseInt(request.getParameter("depositAmount"));
		
		response.setContentType("text/html");
		
		CustomerService customerService = new CustomerServiceImpl();
		if(customerService.deposit(customerId, amount))
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
			String DepositFail = "Please Enter Valid Amount to Deposit";
			session.setAttribute("DepositFail", DepositFail);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DepositForm.jsp");
			dispatcher.forward(request, response);
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
