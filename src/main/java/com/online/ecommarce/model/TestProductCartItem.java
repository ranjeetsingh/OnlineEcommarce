package com.online.ecommarce.model;

/**
 * TestProductCartItem for creating response
 * Not use this model
 * @author RanjeetSi
 *
 */

public class TestProductCartItem {
	private long productId;
	private String productName;
	private double productPrice;
	private int productQuantity;
	private String productAvailabilty;
	private String productDescription;

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
