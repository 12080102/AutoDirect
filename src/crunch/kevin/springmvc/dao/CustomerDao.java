package crunch.kevin.springmvc.dao;

import java.util.List;

import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.CustomerInfo;
import crunch.kevin.springmvc.javabean.LoginUser;

public interface CustomerDao {

	public Customer getCustomerbyCode(int code);
	
	public Customer getCustomerbyName(String name);
	
	public CustomerInfo getCustomerInfobyCode(int code);
	
	public void updateCustomer(Customer customer);
	
	public void updateCustomerInfo(CustomerInfo customerInfo);
	
	public void addCustomer(Customer customer);
	
	public void addCustomerInfo(CustomerInfo customerInfo);
	
	public List<Customer> getAllCustomer();
	
	public List<CustomerInfo> getAllCustomerInfo();
	
	public int checklogin(LoginUser c);
	
	public int checkloginUser(String user);
}
