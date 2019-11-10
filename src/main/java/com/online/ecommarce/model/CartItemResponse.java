package com.online.ecommarce.model;

import java.util.List;

/**
 * CartItemResponse for creating response
 * @author RanjeetSi
 *
 */

public class CartItemResponse{
	private String CartId;
	private double totalPrice;
	private List<ProductCartItem> cartItem;

	public CartItemResponse(String cartId, double totalPrice, List<ProductCartItem> cartItem) {
		super();
		CartId = cartId;
		this.totalPrice = totalPrice;
		this.cartItem = cartItem;
	}

	public String getCartId() {
		return CartId;
	}

	public void setCartId(String cartId) {
		CartId = cartId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ProductCartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<ProductCartItem> cartItem) {
		this.cartItem = cartItem;
	}

	
}
