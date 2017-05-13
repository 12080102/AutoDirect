package crunch.kevin.springmvc.dao;

import java.util.List;
import java.util.Map;

import crunch.kevin.springmvc.javabean.Cart;

public interface CartDao {

	public void newCart(Cart cart);
	public void updateCart(Cart cart);
	public void delectCart(int cart);
	public List<Cart> getCartbyCustomerNumber(int number);
	public Map<String,Double> getItemPricebyCustomerNumber(int number);
}
