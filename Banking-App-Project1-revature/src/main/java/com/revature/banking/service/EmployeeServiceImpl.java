package com.revature.banking.service;

import java.util.List;

import com.revature.banking.DAO.EmployeeDAO;
import com.revature.banking.DAO.EmployeeDAOImpl;
import com.revature.banking.model.Customer;
import com.revature.banking.model.Employee;



public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public boolean isEmployeeexists(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public boolean validateEmployee(int employeeId, String password) {
		if(employeeId<0)
			return false;
		else
			return employeeDAO.validateEmployee(employeeId, password);
	}

	@Override
	public String getNameById(int employeeId) {
		return employeeDAO.getNameById(employeeId);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
