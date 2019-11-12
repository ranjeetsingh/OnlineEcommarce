/**
 * 
 */
package com.online.ecommarce.testUtills;

import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.entity.User;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.model.UserRequest;

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
	 * 
	 * @return CartSummary
	 */
	public CartSummary cartSummaryObj() {
		CartSummary cartSummary = new CartSummary();
		cartSummary.setId(1);
		cartSummary.setActioDescription("Product Add");
		return cartSummary;
	}

	/**
	 * create object of cart item
	 * 
	 * @return CartItemRequest
	 */
	/*
	 * public CartItemRequest cartItemObj() { CartItemRequest cartItemRequest = new
	 * CartItemRequest(); cartItemRequest.setCartId("1"); return cartItemRequest; }
	 */

	/**
	 * Create Cart Obj
	 * 
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

	/**
	 * Create UserRequest Obj
	 * 
	 * @return Cart
	 */
	public UserRequest userRequestObj() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUserEmailId("user04");
		userRequest.setUserName("Ranjeet");
		return userRequest;
	}

	/**
	 * Create UserEntity Obj
	 * 
	 * @return User
	 */
	public User userEntityObj() {
		User userEntity = new User();
		userEntity.setUserEmailId("4");
		userEntity.setUserName("Ranjeet");
		return userEntity;
	}

	/**
	 * Create productEntity Obj
	 * 
	 * @return Product
	 */
	public Product productEntityObj() {
		Product productEntity = new Product();
		productEntity.setCatlogId(1);
		productEntity.setProductName("iPhone 10");
		productEntity.setProductPrice(90000);
		productEntity.setProductQuantity(15);
		productEntity.setProductDescription("Black Color, 16GB RAM");
		return productEntity;
	}

	/**
	 * Create ProductRequest Obj
	 * 
	 * @return ProductRequest
	 */
	public ProductRequest productRequestObj() {
		ProductRequest prodReq = new ProductRequest();
		prodReq.setCatlogId(1);
		prodReq.setProductName("iPhone 10");
		prodReq.setProductPrice(90000);
		prodReq.setProductQuantity(15);
		prodReq.setProductAvailabilty("H");
		prodReq.setProductDescription("Black Color, 16GB RAM");
		return prodReq;
	}

	/**
	 * Create CatlogRequest Obj
	 * 
	 * @return catlogRequest
	 */

	public CatlogRequest catlogRequestObj() {
		CatlogRequest catlogRequest = new CatlogRequest();
		catlogRequest.setCatlogId("catlog04");
		catlogRequest.setCatlogName("Washing Machine");
		return catlogRequest;
	}

	/**
	 * Create Catlog Obj
	 * 
	 * @return catlog
	 */

	public Catlog catlogEntityObj() {
		Catlog catlogEntity = new Catlog();
		catlogEntity.setCatlogName("Cat01");
		return catlogEntity;
	}

}
