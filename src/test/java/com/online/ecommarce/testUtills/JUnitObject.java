/**
 * 
 */
package com.online.ecommarce.testUtills;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartItemRequest;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.model.ResponseModel;

/**
 * Create object for using unit test
 * 
 * @author RanjeetSi
 *
 */
public class JUnitObject {

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
		cartRequest.setQuantity(4);
		cartRequest.setUserId(1);
		return cartRequest;
	}
	/**
	 * Create CartSummary Object
	 * @return CartSummary
	 */
	public CartSummary cartSummaryObj() {
		CartSummary cartSummary = new CartSummary(); 
		cartSummary.setActioDescription("1");
		return cartSummary;
	}
	/**
	 * create object of cart item
	 * @return CartItemRequest
	 */
	public CartItemRequest cartItemObj() {
		CartItemRequest cartRequest = new CartItemRequest();
		cartRequest.setCartId("1");
		return cartRequest;
	}
	/**
	 * Create Cart Obj
	 * @return Cart
	 */
	public Cart cartObj() {
		Cart cart =new Cart();
		cart.setId(1);
		cart.setProductId(1);
		cart.setId(1);
		cart.setProductOrderQuantity(1);
		cart.setProductPrice(100);
		cart.setCartId("1");
		return cart;
	}
	
	/**
	 * Create object for ResponseEntity<Object> 
	 * @return ResponseEntity<Object>
	 */
	public ResponseEntity<Object> commonResponseEntity() {
		return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PLEASE_ENTER_CART_ID, null, 1),
				HttpStatus.NOT_FOUND);
	}
	
}
