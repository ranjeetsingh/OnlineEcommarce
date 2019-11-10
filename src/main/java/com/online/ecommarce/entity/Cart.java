package com.online.ecommarce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Create Cart Entity
 * @author RanjeetSi
 *
 */

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cartId;
	private long userId;
	// private String catlogId;
	private long productId;
	// private String productName;
	private int productOrderQuantity;
	private double productPrice;
	// private String productStatus;

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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductOrderQuantity() {
		return productOrderQuantity;
	}

	public void setProductOrderQuantity(int productOrderQuantity) {
		this.productOrderQuantity = productOrderQuantity;
	}

	

}
