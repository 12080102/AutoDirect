package crunch.kevin.springmvc.dao;

import java.util.List;

import crunch.kevin.springmvc.javabean.OrderDetails;

public interface OrderDetailDao {
	
	public void newOrderDetail(OrderDetails od);
	
	public void updateOrderDetail(OrderDetails od);
	
	public OrderDetails getOrderDetailbyNumber(int number);
	
	public List<OrderDetails> getAllOrderDetail();

}
