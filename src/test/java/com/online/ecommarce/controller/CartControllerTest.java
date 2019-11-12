package com.online.ecommarce.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.online.ecommarce.controller.ivalidator.IDataRequestValidator;
import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.iservice.ICartService;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.testUtills.JUnitObject;

/**
 * Test case related to cart item
 * 
 * @author RanjeetSi
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CartControllerTest extends JUnitObject {

	@InjectMocks
	CartController cartController;

	@Mock
	private IDataRequestValidator validatorService;
	@Mock
	private ICartService cartService;

	/**
	 * test success add product in cart when success
	 */
	@Test
	public void test_AddToCart_When_Success() {
		CartRequest cartRequest = cartRequestObj();
		when(validatorService.validateUser(cartRequest)).thenReturn(null);
		Product product = findProductObj();
		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		when(validatorService.checkProductOutOfStack(productList)).thenReturn(false);
		ResponseEntity<Object> responseEntity = cartController.addProductInCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);

	}

	/**
	 * test fail add product in cart when success
	 */
	@Test
	public void test_AddToCart_When_Fail() {
		CartRequest cartRequest = cartRequestObj();
		ResponseEntity<Object> getResponseEntity = commonResponseEntity();
		when(validatorService.validateUser(cartRequest)).thenReturn(getResponseEntity);
		Product product = findProductObj();
		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		when(validatorService.checkProductOutOfStack(productList)).thenReturn(false);
		ResponseEntity<Object> responseEntity = cartController.addProductInCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);
	}
	
	/**
	 * test exception add product in cart when success
	 */
	@Test
	public void test_AddToCart_When_Exception() {
		CartRequest cartRequest = cartRequestObj();
		when(validatorService.validateUser(cartRequest)).thenThrow(NullPointerException.class);
		Product product = findProductObj();
		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		when(validatorService.checkProductOutOfStack(productList)).thenReturn(false);
		ResponseEntity<Object> responseEntity = cartController.addProductInCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);

	}

	
	/**
	 * test success for update quantity in cart
	 */
	@Test
	public void test_UpdateCartItemQuantity_When_Success() {

		CartRequest cartRequest = cartRequestObj();

		when(validatorService.validateCartId(cartRequest)).thenReturn(null);

		Product product = findProductObj();

		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		ResponseEntity<Object> responseEntity = cartController.updateOrderItemQuantity(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	/**
	 * test update quantity in cart fail
	 */
	@Test
	public void test_UpdateCartItemQuantity_When_Fail() {
		CartRequest cartRequest = cartRequestObj();
		ResponseEntity<Object> getResponseEntity = commonResponseEntity();
		when(validatorService.validateCartId(cartRequest)).thenReturn(getResponseEntity);
		Product product = findProductObj();
		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		ResponseEntity<Object> responseEntity = cartController.updateOrderItemQuantity(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);

	}
	
	/**
	 * test Exception quantity in cart fail
	 */
	@Test
	public void test_UpdateCartItemQuantity_When_Excetion() {
		CartRequest cartRequest = cartRequestObj();

		when(validatorService.validateCartId(cartRequest)).thenThrow(NullPointerException.class);

		Product product = findProductObj();

		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		ResponseEntity<Object> responseEntity = cartController.updateOrderItemQuantity(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);

	}

	/**
	 * test success for remove item from cart
	 */
	@Test
	public void test_RemoveCartItem_When_Success() {
		CartRequest cartRequest = cartRequestObj();

		when(validatorService.validateCartId(cartRequest)).thenReturn(null);
		ResponseEntity<Object> responseEntity = cartController.removeSingleItemFromCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	/**
	 * test fail for remove item from cart
	 */
	@Test
	public void test_RemoveCartItem_When_Fail() {
		CartRequest cartRequest = cartRequestObj();
		ResponseEntity<Object> getResponseEntity = commonResponseEntity();
		when(validatorService.validateCartId(cartRequest)).thenReturn(getResponseEntity);
		ResponseEntity<Object> responseEntity = cartController.removeSingleItemFromCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);

	}
	
	/**
	 * test Exception for remove item from cart
	 */
	@Test
	public void test_RemoveCartItem_When_Exception() {
		CartRequest cartRequest = cartRequestObj();
		when(validatorService.validateCartId(cartRequest)).thenThrow(NullPointerException.class);
		ResponseEntity<Object> responseEntity = cartController.removeSingleItemFromCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);

	}

	
	/**
	 * test success when user want to remove all item from cart
	 */
	@Test
	public void test_ClearCartItem_When_Success() {
		CartRequest cartRequest = cartRequestObj();

		when(validatorService.validateCartId(cartRequest)).thenReturn(null);
		ResponseEntity<Object> responseEntity = cartController.removeAllItemFromCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}
	
	/**
	 * test fail when user want to remove all item from cart
	 */
	@Test
	public void test_ClearCartItem_When_Fail() {
		CartRequest cartRequest = cartRequestObj();
		ResponseEntity<Object> getResponseEntity = commonResponseEntity();
		when(validatorService.validateCartId(cartRequest)).thenReturn(getResponseEntity);
		ResponseEntity<Object> responseEntity = cartController.removeAllItemFromCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);

	}
	
	/**
	 * test exception when user want to remove all item from cart
	 */
	@Test
	public void test_ClearCartItem_When_Exception() {
		CartRequest cartRequest = cartRequestObj();
		when(validatorService.validateCartId(cartRequest)).thenThrow(NullPointerException.class);
		ResponseEntity<Object> responseEntity = cartController.removeAllItemFromCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);

	}
	
	

	/**
	 * test for get user cart summary list
	 */
	@Test
	public void test_Fetch_CartSummary_When_Success() {
		try {
			CartRequest cartRequest = new CartRequest();
			cartRequest.setUserId(1);
			when(validatorService.validateCartId(cartRequest)).thenReturn(null);
			List<CartSummary> cartSummaryList = new ArrayList<>();
			CartSummary cartSummary = cartSummaryObj();
			cartSummaryList.add(cartSummary);
			when(cartService.getCartSummary(cartRequest)).thenReturn(cartSummaryList);
			ResponseEntity<Object> responseEntity = cartController.fetchCartSummary(cartRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * test fail for get user cart summary list 
	 */
	@Test
	public void test_Fetch_CartSummary_When_Fail() {

			CartRequest cartRequest = cartRequestObj();
			ResponseEntity<Object> getResponseEntity = commonResponseEntity();
			when(validatorService.validateCartId(cartRequest)).thenReturn(getResponseEntity);
			List<CartSummary> cartSummaryList = new ArrayList<>();
			when(cartService.getCartSummary(cartRequest)).thenReturn(cartSummaryList);
			ResponseEntity<Object> responseEntity = cartController.fetchCartSummary(cartRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);
	}
	
	/**
	 * test exception for get user cart summary list 
	 */
	@Test
	public void test_Fetch_CartSummary_When_Exception() {

			CartRequest cartRequest = cartRequestObj();
			when(validatorService.validateCartId(cartRequest)).thenThrow(NullPointerException.class);
			List<CartSummary> cartSummaryList = new ArrayList<>();
			when(cartService.getCartSummary(cartRequest)).thenReturn(cartSummaryList);
			ResponseEntity<Object> responseEntity = cartController.fetchCartSummary(cartRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}

	/**
	 * test success for cart summary on the basis of cart ID
	 */
	@Test
	public void test_fetch_CartItem_When_Success() {
		CartRequest cartRequest = cartRequestObj();
		Cart cart = cartObj();
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cart);
		when(validatorService.validateCartId(cartRequest)).thenReturn(null);
		when(cartService.fetchUserCartItem(cartRequest)).thenReturn(cartListDetails);
		Product product = findProductObj();
		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		ResponseEntity<Object> responseEntity = cartController.fetchCartItem(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	
	/**
	 * test fail for cart summary on the basis of cart ID
	 */
	@Test
	public void test_fetch_CartItem_When_Fail() {
		CartRequest cartRequest = cartRequestObj();
		Cart cart = cartObj();
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cart);
		ResponseEntity<Object> getResponseEntity = commonResponseEntity();
		when(validatorService.validateCartId(cartRequest)).thenReturn(getResponseEntity);
		when(cartService.fetchUserCartItem(cartRequest)).thenReturn(cartListDetails);
		Product product = findProductObj();
		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		ResponseEntity<Object> responseEntity = cartController.fetchCartItem(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);
	}
	
	/**
	 * test exception for cart summary on the basis of cart ID
	 */
	@Test
	public void test_fetch_CartItem_When_Exception() {
		CartRequest cartRequest = cartRequestObj();
		Cart cart = cartObj();
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cart);
		when(validatorService.validateCartId(cartRequest)).thenThrow(NullPointerException.class);
		when(cartService.fetchUserCartItem(cartRequest)).thenReturn(cartListDetails);
		Product product = findProductObj();
		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		ResponseEntity<Object> responseEntity = cartController.fetchCartItem(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
	
	
}
