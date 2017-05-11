package crunch.kevin.springmvc.javabean;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

	private List<Product> listProduct;
	
	public ProductList() {
		// TODO Auto-generated constructor stub
		listProduct = new ArrayList<Product>();
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

}
