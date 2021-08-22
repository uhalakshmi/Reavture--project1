package com.revature.banking.DAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.banking.model.Customer;
import com.revature.banking.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	private static Logger logger = Logger.getLogger("CustomerDAOImpl");
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	public boolean isUserexists(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	public int addCustomer(Customer customer) {
		
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		int customerId = customer.getCustomerId();
		transaction.commit();
		return customerId;
	}

	public boolean validateCustomer(int customerId, String password) {
		
        Query query = session.createQuery("from Customer where customerId = "+customerId+ " and password = '"+password + "'");
        if (query.list().size() == 0)
        {
          return false;
        }
        else
        {
          return true;
        }
	}
	
	public String getNameById (int customerId)
	{
		Customer customer =  (Customer) session.load(Customer.class, customerId);
        return customer.getCustomerName();
	}
	
	
	public int viewBalance(int customerId) 
	{
		Query query = session.createQuery("select amount from Customer where customerId = "+customerId);
		int balance = (int) query.list().get(0);
		logger.info("The balance for :"+customerId + " is "+balance);
		return balance;
	}
	
	public boolean withdraw(int customerId, int amount) 
	{	
		Customer customer =  (Customer) session.load(Customer.class, customerId);
		Transaction transaction = session.beginTransaction();
		// customer.setCustomerId(customerId); customerId must be in db
		customer.setAmount(amount);
		transaction.commit();
		return true;		
	}
	
	public boolean transferAmount(int senderId, int receiverId, int amount) 
	{
		Transaction transaction = session.beginTransaction();
		Customer customer1 =  (Customer) session.load(Customer.class, senderId);
		int sender_balance = customer1.getAmount();
		sender_balance = sender_balance - amount;
		customer1.setAmount(sender_balance);
		
		Customer customer2 =  (Customer) session.load(Customer.class, receiverId);
		int receiver_balance = customer2.getAmount();
		receiver_balance = receiver_balance + amount;
		customer2.setAmount(receiver_balance);
		transaction.commit();
		return true;	
	}

	
	public boolean deposit(int customerId,int amount) 
	{	
		Customer customer =  (Customer) session.load(Customer.class, customerId);
		Transaction transaction = session.beginTransaction();
		customer.setAmount(amount);
		transaction.commit();
		return true;
	}
	
	public List<Customer> getCustomers() {
		Query query = session.createQuery("from com.revature.banking.model.Customer");
		List<Customer> customers = query.list();
		System.out.println(customers);
		return customers;
	}
	
	public Customer getCustomerById(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer =  (Customer) session.load(Customer.class, customerId);
		transaction.commit();
		return customer;
	}
	
	public boolean isCustomerExists(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		session.delete(customer);
		transaction.commit();
		return true;
	}

	@Override
	public boolean updateCustomer(int customerId, String customerName,int userage ,String mobileNumber,String address) 
	{
		Customer customer =  (Customer) session.load(Customer.class, customerId);
		Transaction transaction = session.beginTransaction();
		customer.setCustomerName(customerName);
		customer.setUserage(userage);
		customer.setMobileNumber(mobileNumber);
		customer.setAddress(address);
		transaction.commit();
		return true;
	}

	

}
