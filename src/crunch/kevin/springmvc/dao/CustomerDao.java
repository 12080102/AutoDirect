package crunch.kevin.springmvc.dao;

import java.util.List;

import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.CustomerInfo;

public interface CustomerDao {

	public Customer getCustomerbyName(int code);
	
	public CustomerInfo getCustomerInfobyName(int code);
	
	public void updateCustomer(Customer customer);
	
	public void updateCustomerInfo(CustomerInfo customerInfo);
	
	public void addCustomer(Customer customer);
	
	public void addCustomerInfo(CustomerInfo customerInfo);
	
	public List<Customer> getAllCustomer();
	public List<CustomerInfo> getAllCustomerInfo();
}
