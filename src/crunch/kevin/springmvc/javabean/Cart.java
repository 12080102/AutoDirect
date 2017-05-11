package crunch.kevin.springmvc.javabean;

public class Cart {
	
	private int CustomerNumber;
	private String ProductNumberList;
	private int ProductCount;

	public int getCustomerNumber() {
		return CustomerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		CustomerNumber = customerNumber;
	}
	public String getProductNumberList() {
		return ProductNumberList;
	}
	public void setProductNumberList(String productNumberList) {
		ProductNumberList = productNumberList;
	}
	public int getProductCount() {
		return ProductCount;
	}
	public void setProductCount(int productCount) {
		ProductCount = productCount;
	}
	
}
