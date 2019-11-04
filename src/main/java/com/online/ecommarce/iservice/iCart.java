package com.online.ecommarce.iservice;

import java.util.List;

import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.model.CartRequest;
/**
 * Method related to card imple
 * @author RanjeetSi
 *
 */
public interface iCart {
	String addToCart(CartRequest request);
	String updateCartQuantity(CartRequest request);
	String removeProductFromCart(CartRequest request);
	String ClearAllItemFromCart(CartRequest request);
	List<CartSummary> getCartSummary(CartRequest request);
	

}
