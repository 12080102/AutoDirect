package crunch.kevin.springmvc.dao;

import java.util.Date;
import java.util.List;

import crunch.kevin.springmvc.javabean.Orders;

public interface OrdersDao {
	public void newOrder(Orders order);
	public void updateOrder(Orders order);
	public Orders getOrderbyNumber(int number);
	public List<Orders> getOrdersbyCustomer(int number);
	public List<Orders> getOrdersbyDate(Date orderDate);
	public List<Orders> getAllOrder();
}
