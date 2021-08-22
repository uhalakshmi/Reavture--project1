package com.revature.banking.service;

import java.util.List;

import com.revature.banking.DAO.CustomerDAO;
import com.revature.banking.DAO.CustomerDAOImpl;
import com.revature.banking.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerDAO customerDAO = new CustomerDAOImpl();

	public boolean isUserexists(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	public int addCustomer(Customer customer) {
		if(customer.getAmount()<0)
			return 0;
		else
			return customerDAO.addCustomer(customer);
	}

	public boolean validateCustomer(int customerId, String password) {
		if(customerId<0)
			return false;
		else
			return customerDAO.validateCustomer(customerId, password);
	}
	
	public String getNameById (int customerId)
	{
		return customerDAO.getNameById(customerId);
	}

	public int viewBalance(int customerId) 
	{
		return customerDAO.viewBalance(customerId);
	}
	
	public boolean withdraw(int customerId, int amount) 
	{	
		int balance = customerDAO.viewBalance(customerId);
		if(balance>amount && (balance-amount)>=500 && amount>0)
		{
			balance=balance-amount;
			return customerDAO.withdraw(customerId,balance);
		}
		else 
			return false;
		
	}
	
	public boolean deposit(int customerId,int amount) 
	{
		if(amount>0)
		{
			int balance = customerDAO.viewBalance(customerId);
			balance=balance+amount;
			return customerDAO.deposit(customerId,balance);
		}
		else 
			return false;
	}
	
	public boolean transferAmount(int senderId, int receiverId, int amount) {
		
		int sender_balance = customerDAO.viewBalance(senderId);
		
		if((sender_balance > amount) && (sender_balance -amount)>=500 && amount>0)
		{
			return customerDAO.transferAmount(senderId,receiverId,amount);
		}
		else 
			return false;
	}
	
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	
	public Customer getCustomerById(int customerId) {
		return customerDAO.getCustomerById(customerId);
	}

	public boolean deleteCustomer(int customerId) {
		return customerDAO.deleteCustomer(customerId);
	}

	public boolean updateCustomer(int customerId, String customerName,int userage ,String mobileNumber,String address) 
	 {
		return customerDAO.updateCustomer(customerId,customerName,userage,mobileNumber,address);
				
	}

	

	public boolean isCustomerExists(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

}
