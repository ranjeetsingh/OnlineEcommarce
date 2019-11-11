/**
 * 
 */
package com.online.ecommarce.testUtills;

import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartItemRequest;
import com.online.ecommarce.model.CartRequest;

/**
 * Create object for service implementation 
 * 
 * @author RanjeetSi
 *
 */
public class JUnitObjectServiceImpl {

	/**
	 * Create dummy product object
	 * 
	 * @return Product
	 */
	public Product findProductObj() {
		Product product = new Product();
		product.setCatlogId(3);
		product.setId(1);
		product.setProductDescription("Mobile");
		product.setProductName("MI");
		product.setProductQuantity(20);
		product.setProductPrice(5000);
		product.setProductAvailability("Y");
		return product;
	}

	/**
	 * Create CartRequest Object
	 * 
	 * @return CartRequest
	 */
	public CartRequest cartRequestObj() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(1);
		cartRequest.setQuantity(2);
		cartRequest.setUserId(1);
		cartRequest.setCartId("1");
		return cartRequest;
	}
	/**
	 * Create CartSummary Object
	 * @return CartSummary
	 */
	public CartSummary cartSummaryObj() {
	
		return null;
	}
	/**
	 * create object of cart item
	 * @return CartItemRequest
	 */
	public CartItemRequest cartItemObj() {
	
		return null;
	}
	/**
	 * Create Cart Obj
	 * @return Cart
	 */
	public Cart cartObj() {
		Cart cartEntity = new Cart();
		cartEntity.setUserId(1);
		cartEntity.setId(1);
		cartEntity.setProductId(1);
		cartEntity.setProductOrderQuantity(1);
		cartEntity.setProductPrice(20000);
		cartEntity.setCartId("cart001");
		return cartEntity;
	}
}
