package com.revature.banking.model;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private int employeeId;
	private String employeeName;
	private String password;
	private int userage;
	private String mobileNumber;
	private String address;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, String password, int userage, String mobileNumber,
			String address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.userage = userage;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", userage=" + userage + ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}
	
	
}

