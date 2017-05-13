package crunch.kevin.springmvc.javabean;

import java.math.BigDecimal;

public class CartProduct {

	private int quantity;
	private int cartCode;
	private String picurl;
	private String productName;
	private String productDescription;
	private Double buyPrice;
	private Double price;
	private Double MSRP;
	private String discount;
	private String totle;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMSRP() {
		return MSRP;
	}
	public void setMSRP(Double mSRP) {
		MSRP = mSRP;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getTotle() {
		return totle;
	}
	public void setTotle(String totle) {
		this.totle = totle;
	}
	public int getCartCode() {
		return cartCode;
	}
	public void setCartCode(int cartCode) {
		this.cartCode = cartCode;
	}
	
}
