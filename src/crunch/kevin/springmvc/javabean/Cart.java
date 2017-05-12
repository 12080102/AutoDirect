package crunch.kevin.springmvc.javabean;

public class Cart {

	private int cartCode;
	private int customerNumber;
	private String productNumberList;
	private int productCount;
	private double price;
	public int getCartCode() {
		return cartCode;
	}
	public void setCartCode(int cartCode) {
		this.cartCode = cartCode;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getProductNumberList() {
		return productNumberList;
	}
	public void setProductNumberList(String productNumberList) {
		this.productNumberList = productNumberList;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
