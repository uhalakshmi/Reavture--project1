package com.revature.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.banking.service.CustomerService;
import com.revature.banking.service.CustomerServiceImpl;
import com.revature.banking.model.Customer;

/**
 * Servlet implementation class AuthenticateUser
 */
public class AuthenticateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		boolean alreadyVisited = false;
		Cookie allCookies[] = request.getCookies();
		
		out.println("<html><body>");
		out.println("<h2>You have logged in at : " + new java.util.Date());
		out.println("<br/>");
		
		CustomerService customerService = new CustomerServiceImpl();
		if(customerService.validateCustomer(customerId, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("customerId", customerId);
			session.setAttribute("password", password);
			String customerName = customerService.getNameById(customerId);
			session.setAttribute("customerName", customerName);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginDisplay.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			out.println("<h2>CustomerId/password is incorrect</h2><br>");
			out.println("<h2>Please Enter a valid CustomerId/password</h2>");
			out.println("<h1><br/><a href=CustomerLogin.html>Login</a>");
			
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
