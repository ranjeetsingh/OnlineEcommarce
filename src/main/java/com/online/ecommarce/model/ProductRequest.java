package com.online.ecommarce.model;

/**
 * ProductRequest for creating request
 * @author RanjeetSi
 *
 */
public class ProductRequest {
	private long catlogId;
	private String productName;
	private double productPrice;
	private int productQuantity;
	private String productAvailabilty;
	private String productDescription;

	/*
	 * public ProductRequest(long catlogId, String productName, double productPrice,
	 * int productQuantity, String productAvailabilty, String productDescription) {
	 * super(); this.catlogId = catlogId; this.productName = productName;
	 * this.productPrice = productPrice; this.productQuantity = productQuantity;
	 * this.productAvailabilty = productAvailabilty; this.productDescription =
	 * productDescription; }
	 */

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

	public long getCatlogId() {
		return catlogId;
	}

	public void setCatlogId(long catlogId) {
		this.catlogId = catlogId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

}
