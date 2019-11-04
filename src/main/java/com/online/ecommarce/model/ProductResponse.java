package com.online.ecommarce.model;

public class ProductResponse {
	private long productId;
	private String catlogId;
	private String productName;
	private double productPrice;
	private String productQuantity;
	private String productAvailabilty;
	private String productDescription;
	
	
	public ProductResponse(long productId, String catlogId, String productName, double productPrice,
			String productQuantity, String productAvailabilty, String productDescription) {
		super();
		this.productId = productId;
		this.catlogId = catlogId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productAvailabilty = productAvailabilty;
		this.productDescription = productDescription;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getCatlogId() {
		return catlogId;
	}
	public void setCatlogId(String catlogId) {
		this.catlogId = catlogId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductAvailabilty() {
		return productAvailabilty;
	}
	public void setProductAvailabilty(String productAvailabilty) {
		this.productAvailabilty = productAvailabilty;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
}
