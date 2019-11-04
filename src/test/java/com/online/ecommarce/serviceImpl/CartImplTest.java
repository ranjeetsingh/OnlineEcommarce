package com.online.ecommarce.serviceImpl;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.model.CartRequest;


/**
 * test the cart action
 * @author RanjeetSi
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class CartImplTest {
	@Autowired
	CartImpl cartImpl;
	
	/**
	 * add to cart test cases
	 */
	
	@Test
	public void testAddToCart() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setQuantity("1");
		cartRequest.setUserId("user01");
		String addProductMsg = cartImpl.addToCart(cartRequest);
		Assert.assertEquals(AppConstant.ADD_PRODUCT_SUCCESS, addProductMsg);
		
	}
	
	/**
	 * update product quantity in cart test cases
	 */
	
	@Test
	public void testupdateCartQuantity() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setQuantity("2");
		cartRequest.setUserId("user01");
		String addProductMsg = cartImpl.updateCartQuantity(cartRequest);
		Assert.assertEquals(AppConstant.CART_ITEM_QUANTITY, addProductMsg);
		
	}
	
	/**
	 * remove product quantity in cart test cases
	 */
	
	@Test
	public void testRemoveProductFromCart() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setUserId("user01");
		String addProductMsg = cartImpl.removeProductFromCart(cartRequest);
		Assert.assertEquals(AppConstant.ITEM_DELETED_SUCCESS, addProductMsg);
		//Assert.assertEquals(AppConstant.ITEM_DELETED_SUCCESS, addProductMsg);
		
	}
	
	/**
	 * clear all product from cart test cases
	 */
	
	@Test
	public void testClearAllItemFromCart() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setUserId("user01");
		String addProductMsg = cartImpl.ClearAllItemFromCart(cartRequest);
		Assert.assertEquals(AppConstant.ALL_ITEM_DELETED, addProductMsg);
		//Assert.assertEquals(AppConstant.ITEM_DELETED_SUCCESS, addProductMsg);
		
	}
	
	/**
	 * get user cart summary test cases
	 */
	@Test
	public void testGetCartSummary() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setUserId("user01");
		List<CartSummary> cartList = cartImpl.getCartSummary(cartRequest);
		Assert.assertEquals(10, cartList.size());
	}
}
