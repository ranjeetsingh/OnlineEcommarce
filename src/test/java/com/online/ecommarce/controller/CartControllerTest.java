package com.online.ecommarce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.testUtills.JUnitUtils;

/**
 * Test case related to cart item
 * 
 * @author RanjeetSi
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CartControllerTest extends JUnitUtils {

	/*
	 * @Autowired CartController cartController;
	 */

	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	/**
	 * test add product in cart when success
	 */
	@Test
	public void test_AddToCart_When_Success() {

		String uri = "/addToCart";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(30);
			cartRequest.setQuantity(1);
			cartRequest.setUserId(1);

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(201, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * test add product in cart when fail
	 */
	@Test
	public void test_AddToCart_When_Fail() {

		String uri = "/addToCart";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(30);
			cartRequest.setQuantity(1);
			//cartRequest.setUserId(1);

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(404, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * test update quantity in cart
	 */
	@Test
	public void test_UpdateCartItemQuantity_When_Success() {

		String uri = "/updateCartItemQuantity";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(7);
			cartRequest.setQuantity(4);
			cartRequest.setUserId(1);
			cartRequest.setCartId("1");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * test update quantity in cart fail
	 */
	@Test
	public void test_UpdateCartItemQuantity_When_Fail() {

		String uri = "/updateCartItemQuantity";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(7);
			cartRequest.setQuantity(4);
			cartRequest.setUserId(1);
			//cartRequest.setCartId("1");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(404, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	/**
	 * test remove item from cart
	 */
	@Test
	public void test_RemoveCartItem_When_Success() {

		String uri = "/removeCartItem";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(7);
			cartRequest.setUserId(1);
			cartRequest.setCartId("1");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * test remove item from cart fail
	 */
	@Test
	public void test_RemoveCartItem_When_Fail() {

		String uri = "/removeCartItem";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(7);
			cartRequest.setUserId(1);
			//cartRequest.setCartId("1");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(404, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	/**
	 * test when user want to remove all item from cart
	 */
	@Test
	public void test_ClearCartItem_When_Success() {

		String uri = "/clearAllCartItem";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setCartId("1");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * test when user want to remove all item from fail
	 */
	@Test
	public void test_ClearCartItem_When_Fail() {

		String uri = "/clearAllCartItem";
		try {
			CartRequest cartRequest = new CartRequest();
			//cartRequest.setCartId("1");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(404, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	/**
	 * test for get user cart summary list
	 */
	@Test
	public void test_Fetch_CartSummary_When_Success() {

		String uri = "/getCartSummary";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setUserId(1);
			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * test for get user cart summary list fail
	 */
	@Test
	public void test_Fetch_CartSummary_When_Fail() {

		String uri = "/getCartSummary";
		try {
			CartRequest cartRequest = new CartRequest();
			//cartRequest.setUserId(1);
			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(404, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/**
	 * test cart summary on the basis of cart ID
	 */
	@Test
	public void test_fetch_CartItem_When_Success() {

		String uri = "/fetchUserCartItem";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setCartId("1");
			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	/**
	 * this method return status code like 200,201..etc
	 */
	public int getStatusValue(String inputJson, String uri) {
		MvcResult mvcResult = null;
		try {
			mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
					.andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int status = mvcResult.getResponse().getStatus();
		return status;
	}

}
