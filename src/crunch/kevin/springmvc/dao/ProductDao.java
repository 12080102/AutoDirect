package crunch.kevin.springmvc.dao;

import java.util.List;

import crunch.kevin.springmvc.javabean.Product;

public interface ProductDao {
	public Product getProductbyCode(String Code);
	
	public List<Product> getAllProducts();

	public List<Product> searchProductsbyTypes(String type);
	
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public List<Product> getPagedProducts(int start, int totle);
	
	public int getProductsCount(String type);
	
	public void addURl(String type, int c);
}
