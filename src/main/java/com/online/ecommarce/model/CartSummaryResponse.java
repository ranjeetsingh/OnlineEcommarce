package com.online.ecommarce.model;

import java.util.List;

import com.online.ecommarce.entity.CartSummary;

//Not Use this class
public class CartSummaryResponse {
	private List<CartSummary> cartDescription;

	
	public CartSummaryResponse(List<CartSummary> cartDescription) {
		super();
		this.cartDescription = cartDescription;
	}

	public List<CartSummary> getCartDescription() {
		return cartDescription;
	}

	public void setCartDescription(List<CartSummary> cartDescription) {
		this.cartDescription = cartDescription;
	}

	
	


	
	
}
