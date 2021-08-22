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
 * Servlet implementation class ViewBalanceController
 */
public class ViewBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBalanceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute("customerId");
		
		CustomerService customerService = new CustomerServiceImpl();
		int balance = customerService.viewBalance(customerId);
		
		session.setAttribute("currentBalance", balance);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewBalance.jsp");
		dispatcher.forward(request, response);
	}

}
