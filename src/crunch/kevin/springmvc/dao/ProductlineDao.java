package crunch.kevin.springmvc.dao;

import java.util.List;

import crunch.kevin.springmvc.javabean.ProductLine;

public interface ProductlineDao {

	public void addProductline(ProductLine productLine);
	public void updateProductline(ProductLine productline);
	public ProductLine getProductLinebyName(String name);
	public List<ProductLine> getAllProductLine();
}
