package com.revature.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.banking.service.EmployeeService;
import com.revature.banking.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AuthenticateEmployee
 */
public class AuthenticateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		boolean alreadyVisited = false;
		Cookie allCookies[] = request.getCookies();
		
		out.println("<html><body>");
		out.println("<h2>You have logged in at : " + new java.util.Date());
		out.println("<br/>");
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		if(employeeService.validateEmployee(employeeId, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("employeeId", employeeId);
			session.setAttribute("employeepassword", password);
			String employeeName = employeeService.getNameById(employeeId);
			session.setAttribute("employeeName", employeeName);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeDisplay.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			out.println("<h2>EmployeeId/password is incorrect</h2><br>");
			out.println("<h2>Please Enter a valid EmployeeId/password</h2>");
			out.println("<h1> <br/><br/><a href=EmployeeLogin.html>Login</a>");
			
			
		}

	}

}
