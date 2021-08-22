package com.revature.banking.DAO;

import java.util.List;

import com.revature.banking.model.Customer;

public interface CustomerDAO {
	
	public boolean isUserexists(int customerId);
	public int addCustomer(Customer customer);
	public boolean validateCustomer(int customerId,String password);
	public String getNameById (int customerId) ;
	//* As a customer, I can view the balance of a specific account. * 
	
	public int viewBalance(int customerId);
	public boolean deposit(int customerId,int amount);
	public boolean withdraw(int customerId,int amount);
	public boolean transferAmount(int senderId,int receiverId,int amount);

		
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(int customerId, String customerName,int userage ,String mobileNumber,String address);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	public boolean isCustomerExists(int customerId);
	
}
