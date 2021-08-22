package com.revature.banking.controller;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class SearchCustomerByIdController
 */
public class SearchCustomerByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCustomerByIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = customerService.getCustomerById(customerId);
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		HttpSession session = request.getSession();
		session.setAttribute("allCustomers", customers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayCustomerDetails.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
