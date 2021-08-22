package com.revature.banking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.banking.model.Employee;
import com.revature.banking.service.EmployeeService;
import com.revature.banking.service.EmployeeServiceImpl;


/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
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
		
		String employeeName = request.getParameter("employeename");
		String password = request.getParameter("password");
		int userage = Integer.parseInt(request.getParameter("userage"));
		String mobileNumber = request.getParameter("mobilenum");
		String address = request.getParameter("address");

		Employee employee = new Employee(0,employeeName, password,userage ,mobileNumber,address);
		
		response.setContentType("text/html");
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		int employeeId = employeeService.addEmployee(employee);
		
		if(employeeId !=0)
		{
			response.getWriter().println("<h1> Congrats "+employeeName + ", you have successfully opened an employee account in our bank ");
			response.getWriter().println("<h1> Please note your  Employee id for future logins :"+employeeId);
			response.getWriter().println("<h1> <br/><br/><a href=EmployeeLogin.html>Login</a>");
		}
		else
		{
			response.getWriter().println("<h1> Please Enter valid amount to signup");
		}
	}

}
