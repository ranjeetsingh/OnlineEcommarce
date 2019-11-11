package com.online.ecommarce.iservice;

import java.util.List;
import java.util.Optional;

import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartItemRequest;
import com.online.ecommarce.model.CartRequest;
/**
 *All card method implemented in cart service implementation class
 * @author RanjeetSi
 *
 */
public interface ICartService {
	/**
	 * Method add product in cart
	 * @param cartRequest
	 * @return String
	 */
	String addToCart(CartRequest request);
	/**
	 * Method update cart item
	 * @param cartRequest
	 * @return string
	 */
	String updateCartQuantity(CartRequest request);
	/**
	 * Method remove single item in cart
	 * @param cartRequest
	 * @return string
	 */
	String removeProductFromCart(CartRequest request);
	/**
	 * Method remove all item in cart
	 * @param cartRequest
	 * @return string
	 */
	String removeAllItemFromCart(CartRequest request);
	/**
	 * Method get all summary from cart
	 * @param cartRequest
	 * @return List<CartSummary>
	 */
	List<CartSummary> getCartSummary(CartRequest request);
	/**
	 * Method fetch cart item from cart
	 * @param cartItemRequest
	 * @return List<Cart>
	 */
	List<Cart> fetchUserCartItem(CartItemRequest request);
	
	/**
	 * Method fetch Product details from product table
	 * @param productId
	 * @return Optional<Product>
	 */
	Optional<Product> fetchProductDetails(long prodcutId);
	

}
