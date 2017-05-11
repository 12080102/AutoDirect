package crunch.kevin.springmvc.javabean;

public class Customer {

	private String name;
	private int customerNumber;
	private String customerPW;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerPW() {
		return customerPW;
	}

	public void setCustomerPW(String customerPW) {
		this.customerPW = customerPW;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{custmoer: name = "+name+", customerNumber = "+customerNumber+", customerPW"+customerPW+"}";
	}
}
