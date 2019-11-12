package com.online.ecommarce.model;

/**
 * ProductCartItem for creating response
 * 
 * @author RanjeetSi
 *
 */

public class ProductCartItem {

	private long productId;
	private String productName;
	private double productPrice;
	private int productQuantity;
	private String productAvailabilty;
	private String productDescription;

	public ProductCartItem(long productId, String productName, double productPrice, int productQuantity,
			String productAvailabilty, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productAvailabilty = productAvailabilty;
		this.productDescription = productDescription;
	}
	/*
	 * public ProductCartItem(Product product) { this.productId = product.getId();
	 * this.productName = product.getProductName(); this.productPrice =
	 * product.getProductPrice(); this.productQuantity =
	 * product.getProductQuantity(); this.productAvailabilty =
	 * product.getProductAvailability(); this.productDescription =
	 * product.getProductDescription(); }
	 */

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
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
