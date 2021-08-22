package com.revature.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccountUser")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@Column
	private String customerName;
	
	@Column
	private String password;

	@Column
	private int userage;
	
	@Column
	private String mobileNumber;
	
	@Column
	private String address;
	
	@Column
	private int amount;

	
	
	public Customer() {
		super();
	}


	public Customer(int customerId, String customerName, String password, int userage, String mobileNumber,
			String address, int amount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.userage = userage;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.amount = amount;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getUserage() {
		return userage;
	}


	public void setUserage(int userage) {
		this.userage = userage;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", userage=" + userage + ", mobileNumber=" + mobileNumber + ", address=" + address + ", amount="
				+ amount + "]";
	}
	
	
	
}
