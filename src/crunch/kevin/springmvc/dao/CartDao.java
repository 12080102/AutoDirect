package crunch.kevin.springmvc.dao;

import crunch.kevin.springmvc.javabean.Cart;

public interface CartDao {

	public void newCart(Cart cart);
	public void updateCart(Cart cart);
	public Cart getCartbyCustomerNumber(int number);
}
