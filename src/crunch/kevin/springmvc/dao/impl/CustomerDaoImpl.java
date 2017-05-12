package crunch.kevin.springmvc.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import crunch.kevin.springmvc.dao.CustomerDao;
import crunch.kevin.springmvc.javabean.Customer;
import crunch.kevin.springmvc.javabean.CustomerInfo;
import crunch.kevin.springmvc.javabean.LoginUser;
import crunch.kevin.springmvc.javabean.Product;

public class CustomerDaoImpl implements CustomerDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Customer getCustomerbyCode(int code) {
		String sql = "select * from customerlogin where customerNubmer = ?";
		final Customer pro = new Customer();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new Object[] { code },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						pro.setName(rs.getString("customerName"));
						pro.setCustomerPW(rs.getString("customerPW"));
						pro.setCustomerNumber(rs.getInt("customerNumber"));
					}
				});
		return pro;
	}

	@Override
	public CustomerInfo getCustomerInfobyCode(int code) {
		String sql = "select * from customers where customerName = ?";
		final CustomerInfo pro = new CustomerInfo();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new Object[] { code },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						pro.setCustomerName(rs.getString("customerName"));
						pro.setCustomerNumber(rs.getInt("customerNumber"));
						pro.setAddressLine1(rs.getString("addressLine1"));
						pro.setAddressLine2(rs.getString("addressLine2"));
						pro.setCity(rs.getString("city"));
						pro.setContactFirstName(rs
								.getString("contactFirstName"));
						pro.setContactLastName(rs.getString("contactLastName"));
						pro.setCreditLimit(rs.getBigDecimal("creditLimit"));
						pro.setPhone(rs.getString("phone"));
						pro.setPostalCode(rs.getString("postalCode"));
						pro.setSalesRepEmployeeNumber(rs
								.getInt("salesRepEmployeeNumber"));
						pro.setState(rs.getString("state"));
					}
				});
		return pro;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "update customerlogin set customerName=?, customerPW=? where customerNumber=?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { customer.getName(),
							customer.getCustomerPW(),
							customer.getCustomerNumber() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomerInfo(CustomerInfo customerInfo) {
		// TODO Auto-generated method stub
		String sql = "update customers set customerName=?, contactLastName=?, contactFirstName=?, phone=?, addressLine1=?"
				+ ", addressLine2=?, city=?, state=?, postalCode=?, country=?, salesRepEmployeeNumber=?, creditLimit=?"
				+ " where customerNumber=?";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { customerInfo.getCustomerName(),
							customerInfo.getContactLastName(),
							customerInfo.getContactFirstName(),
							customerInfo.getPhone(),
							customerInfo.getAddressLine1(),
							customerInfo.getAddressLine2(),
							customerInfo.getCity(), customerInfo.getState(),
							customerInfo.getPostalCode(),
							customerInfo.getCountry(),
							customerInfo.getSalesRepEmployeeNumber(),
							customerInfo.getCreditLimit(),
							customerInfo.getCustomerNumber() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "insert into customerlogin (customerNumber,customerName, customerPW) values(?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(sql, new Object[] { customer.getCustomerNumber(),
					customer.getName(), customer.getCustomerPW() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addCustomerInfo(CustomerInfo customerInfo) {
		// TODO Auto-generated method stub
		String sql = "insert into customers(customerNumber,customerName, contactLastName, contactFirstName, phone, addressLine1"
				+ ", addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		try {
			jdbc.update(
					sql,
					new Object[] { customerInfo.getCustomerNumber(),
							customerInfo.getCustomerName(),
							customerInfo.getContactLastName(),
							customerInfo.getContactFirstName(),
							customerInfo.getPhone(),
							customerInfo.getAddressLine1(),
							customerInfo.getAddressLine2(),
							customerInfo.getCity(), customerInfo.getState(),
							customerInfo.getPostalCode(),
							customerInfo.getCountry(),
							customerInfo.getSalesRepEmployeeNumber(),
							customerInfo.getCreditLimit() });
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerInfo> getAllCustomerInfo() {
		// TODO Auto-generated method stub
		String sql = "select * from customers";
		List<CustomerInfo> product = new ArrayList<CustomerInfo>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> proRows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : proRows) {
			CustomerInfo pro = new CustomerInfo();
			pro.setCustomerNumber((Integer) (row.get("customerNumber")));
			pro.setCustomerName(String.valueOf(row.get("customerName")));
			pro.setContactLastName((String) row.get("contactLastName"));
			pro.setContactFirstName(String.valueOf(row.get("contactFirstName")));
			pro.setPhone(String.valueOf(row.get("phone")));
			pro.setAddressLine1((String) row.get("addressLine1"));
			pro.setAddressLine2((String) row.get("addressLine2"));
			pro.setCity(row.get("city").toString());
			pro.setState((String) row.get("state"));
			pro.setPostalCode((String) row.get("postalCode"));
			pro.setCountry((String) row.get("country"));
			if (null != row.get("salesRepEmployeeNumber"))
				pro.setSalesRepEmployeeNumber((Integer) row
						.get("salesRepEmployeeNumber"));
			pro.setCreditLimit((BigDecimal) row.get("creditLimit"));
			product.add(pro);
		}
		return product;
	}

	@Override
	public int checklogin(LoginUser c) {
		// TODO Auto-generated method stub
		int i1,i2;
		String sql = "select count(*) from customerlogin where customerName = ? and customerPW = ?";
		String sql2 = "select count(*) from employeelogin where email=? and employeePW=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		i1 = jdbcTemplate.queryForObject(sql,new Object[]{c.getName(),c.getPassword()} ,Integer.class);
		if(i1==1)
			return 1; //customer login
		else{
			i2 = jdbcTemplate.queryForObject(sql2,new Object[]{c.getName(),c.getPassword()} , Integer.class);
			if(i2==1)
				return 2;  //employee login
			else
				return 0;  //login failed
		}
	}
	@Override
	public int checkloginUser(String user) {
		// TODO Auto-generated method stub
		int i1,i2;
		String sql = "select count(*) from customerlogin where customerName = ?";
		String sql2 = "select count(*) from employeelogin where email=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		i1 = jdbcTemplate.queryForObject(sql,new Object[]{user} ,Integer.class);
		System.out.println("i:"+i1);
		if(i1==1)
			return 1; //customer login
		else{
			i2 = jdbcTemplate.queryForObject(sql2,new Object[]{user} , Integer.class);
			if(i2==1)
				return 2;  //employee login
			else
				return 0;  //login failed
		}
	}

	@Override
	public Customer getCustomerbyName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from customerlogin where customerName = ?";
		final Customer pro = new Customer();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(sql, new Object[] { name },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						pro.setName(rs.getString("customerName"));
						pro.setCustomerPW(rs.getString("customerPW"));
						pro.setCustomerNumber(rs.getInt("customerNumber"));
					}
				});
		return pro;
	}
}
