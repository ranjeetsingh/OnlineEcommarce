package com.online.ecommarce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Create Cart Summary Entity
 * @author RanjeetSi
 *
 */
@Entity
public class CartSummary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cartId;
	private long productId;
	private String productName;
	private double productPrice;
	private String actioDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

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

	public String getActioDescription() {
		return actioDescription;
	}

	public void setActioDescription(String actioDescription) {
		this.actioDescription = actioDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
