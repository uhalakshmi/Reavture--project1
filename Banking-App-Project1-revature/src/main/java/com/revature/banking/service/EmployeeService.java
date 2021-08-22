package com.revature.banking.service;

import java.util.List;

import com.revature.banking.model.Customer;
import com.revature.banking.model.Employee;

public interface EmployeeService {

	public boolean isEmployeeexists(int employeeId);
	public int addEmployee(Employee employee);
	public boolean validateEmployee(int employeeId,String password);
	public String getNameById (int employeeId) ;
	
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();

}
