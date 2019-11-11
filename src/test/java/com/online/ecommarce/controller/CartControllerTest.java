package com.online.ecommarce.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
import com.online.ecommarce.model.CartItemRequest;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.testUtills.JUnitObject;
import com.online.ecommarce.testUtills.JUnitUtils;

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
	 * test add product in cart when success
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
	 * test update quantity in cart
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

		when(validatorService.validateCartId(cartRequest)).thenReturn(null);

		Product product = findProductObj();

		Optional<Product> productList = Optional.of(product);
		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);
		ResponseEntity<Object> responseEntity = cartController.updateOrderItemQuantity(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	/**
	 * test remove item from cart
	 */
	@Test
	public void test_RemoveCartItem_When_Success() {
		CartRequest cartRequest = cartRequestObj();

		when(validatorService.validateCartId(cartRequest)).thenReturn(null);
		ResponseEntity<Object> responseEntity = cartController.removeSingleItemFromCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	/**
	 * test when user want to remove all item from cart
	 */
	@Test
	public void test_ClearCartItem_When_Success() {
		CartRequest cartRequest = cartRequestObj();

		when(validatorService.validateCartId(cartRequest)).thenReturn(null);
		ResponseEntity<Object> responseEntity = cartController.removeAllItemFromCart(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

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
	 * test for get user cart summary list fail
	 */
	@Test
	public void test_Fetch_CartSummary_When_Fail() {

		try {
			CartRequest cartRequest = cartRequestObj();
			when(validatorService.validateCartId(cartRequest)).thenReturn(null);
			List<CartSummary> cartSummaryList = new ArrayList<>();
			when(cartService.getCartSummary(cartRequest)).thenReturn(cartSummaryList);
			ResponseEntity<Object> responseEntity = cartController.fetchCartSummary(cartRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
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

		CartItemRequest cartRequest = cartItemObj();

		Cart cart = cartObj();
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cart);

		when(cartService.fetchUserCartItem(cartRequest)).thenReturn(cartListDetails);

		Product product = findProductObj();

		Optional<Product> productList = Optional.of(product);

		when(cartService.fetchProductDetails(Mockito.anyLong())).thenReturn(productList);

		ResponseEntity<Object> responseEntity = cartController.fetchCartItem(cartRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
}
