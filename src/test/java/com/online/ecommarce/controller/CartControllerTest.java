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
import com.online.ecommarce.testUtills.TestUtills;
/**
 * Test case related to cart item
 * @author RanjeetSi
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CartControllerTest extends TestUtills {
	
	/*
	 * @Autowired CartController cartController;
	 */
	
	@BeforeEach
	public void setUp() {
		super.setUp();
	}
	 
	
/**
 * test  add product in cart
 */
	@Test
	public void testAddToCart() {
		/*
		 * CartRequest cartRequest = new CartRequest(); cartRequest.setProductId(30);
		 * cartRequest.setQuantity("1"); cartRequest.setUserId("user01");
		 * ResponseEntity<Object> obj = cartController.addToCart(cartRequest);
		 * System.out.println(obj+"===>"); Assert.assertEquals(201,
		 * obj.getStatusCodeValue());
		 */
		
		
		String uri = "/addToCart";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(30);
			cartRequest.setQuantity("1");
			cartRequest.setUserId("user01");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(201, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}
	/**
	 * test update quantity in cart
	 */
	@Test
	public void testUpdateCartItemQuantity() {
		/*
		 * CartRequest cartRequest = new CartRequest(); cartRequest.setProductId(7);
		 * cartRequest.setQuantity("4"); cartRequest.setUserId("user01");
		 * ResponseEntity<Object> updateCartInfo =
		 * cartController.updateCartItemQuantity(cartRequest);
		 * System.out.println(updateCartInfo+"===>"); Assert.assertEquals(200,
		 * updateCartInfo.getStatusCodeValue());
		 */
		 
	
		String uri = "/updateCartItemQuantity";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(7);
			cartRequest.setQuantity("4");
			cartRequest.setUserId("user01");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * test remove item from cart
	 */
	@Test
	public void testremoveCartItem() {
		/*
		 * CartRequest cartRequest = new CartRequest(); cartRequest.setProductId(7);
		 * cartRequest.setUserId("user01"); ResponseEntity<Object> removeCartInfo =
		 * cartController.removeCartItem(cartRequest);
		 * System.out.println(removeCartInfo+"===>"); Assert.assertEquals(200,
		 * removeCartInfo.getStatusCodeValue());
		 */
		
		
		String uri = "/removeCartItem";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setProductId(7);
			cartRequest.setUserId("user01");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	/**
	 * test when user want to remove all item from cart
	 */
	@Test
	public void testClearCartItem() {
		/*
		 * CartRequest cartRequest = new CartRequest(); cartRequest.setUserId("user01");
		 * ResponseEntity<Object> clearAllItemFromCart =
		 * cartController.ClearCartItem(cartRequest);
		 * System.out.println(clearAllItemFromCart+"===>"); Assert.assertEquals(200,
		 * clearAllItemFromCart.getStatusCodeValue());
		 */
		
		
		String uri = "/clearCartItem";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setUserId("user01");

			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/**
	 * test for get user cart summary list
	 */
	@Test
	public void testCartSummary() {
		/*
		 * CartRequest cartRequest = new CartRequest(); cartRequest.setUserId("user01");
		 * ResponseEntity<Object> getCartSummary =
		 * cartController.getCartSummary(cartRequest);
		 * System.out.println(getCartSummary+"===>"); Assert.assertEquals(200,
		 * getCartSummary.getStatusCodeValue());
		 */
		
		
		String uri = "/getCartSummary";
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setUserId("user01");
			String inputJson = super.mapToJson(cartRequest);
			int status = getStatusValue(inputJson, uri);
			assertEquals(200, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/**
	 * Common method for all above method
	 * this method result mockmvcResult.
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
