package com.online.ecommarce.serviceImpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IBusinessValidator;
import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.repository.CartRepository;
import com.online.ecommarce.repository.CartSummaryRepository;
import com.online.ecommarce.repository.ProductRepository;
import com.online.ecommarce.testUtills.JUnitObjectServiceImpl;


/**
 * test the cart action
 * @author RanjeetSi
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class CartServiceImplTest extends JUnitObjectServiceImpl {
	@InjectMocks
	CartServiceImpl mockCartImpl;
	@Mock
	private CartRepository cartRepository;
	@Mock
	private ProductRepository productRepository;
	@Mock
	private CartSummaryRepository cartSummaryRepo;
	@Mock
	private IBusinessValidator serviceValidator;
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	} 
	
	/**
	 * add to cart test cases
	 */
	
	@Test
	public void test_AddToCart_When_Success() {
		CartRequest cartRequest = cartRequestObj();
		Product product = findProductObj();
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		when(serviceValidator.checkItemQuantity(cartRequest)).thenReturn(true);
		Cart cartEntity = cartObj();
		when(cartRepository.save(Mockito.any())).thenReturn(cartEntity);
		String getStatus = mockCartImpl.addToCart(cartRequest); 
		Assert.assertEquals(AppConstant.ADD_PRODUCT_SUCCESS, getStatus);
		
	}
	
	/**
	 * update product quantity in cart test cases
	 */
	
	@Test
	public void test_UpdateCartQuantity_When_Success() {
		CartRequest cartRequest = cartRequestObj();
		Product product = findProductObj();
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		when(serviceValidator.checkItemQuantity(cartRequest)).thenReturn(true);
		when(cartRepository.UpdateItemQuantityInCart(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyString(),Mockito.anyDouble())).thenReturn(1);
		String getStatus = mockCartImpl.updateCartQuantity(cartRequest);
		Assert.assertEquals(AppConstant.CART_ITEM_QUANTITY, getStatus);
	}
	
	/**
	 * remove product quantity in cart test cases
	 */
	
	@Test
	public void test_RemoveProductFromCart__When_Success() {
		CartRequest cartRequest = cartRequestObj();
		when(cartRepository.RemoveItemFromCart(Mockito.anyLong(),Mockito.anyString())).thenReturn(1);
		Product product = findProductObj();
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		String getStatus = mockCartImpl.removeProductFromCart(cartRequest);
		Assert.assertEquals(AppConstant.ITEM_DELETED_SUCCESS, getStatus);
		
	}
	
	/**
	 * clear all product from cart test cases
	 */
	
	@Test
	public void test_ClearAllItemFromCart_When_Success() {
		CartRequest cartRequest = cartRequestObj();
		Cart cart =cartObj();
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cart);
		when(cartRepository.ClearAllItemFromCart(Mockito.anyString())).thenReturn(1);
		String getStatus = mockCartImpl.removeAllItemFromCart(cartRequest);
		Assert.assertEquals(AppConstant.ALL_ITEM_DELETED, getStatus);
		
		
		
	}
	
	/**
	 * get user cart summary test cases
	 */
	@Test
	public void test_GetCartSummary_When_Success() {
		CartRequest cartRequest = cartRequestObj();
		CartSummary cartSummary = cartSummaryObj();
		List<CartSummary> cartListDetails = new ArrayList<CartSummary>();
		cartListDetails.add(cartSummary);
		when(cartSummaryRepo.getCartSummary(Mockito.anyString())).thenReturn(cartListDetails);
		List<CartSummary> cartListResponse = mockCartImpl.getCartSummary(cartRequest);
		Assert.assertEquals(1, cartListResponse.size());
	}
	
	/**
	 * Fetch cart item when test cases success
	 */
	@Test
	public void test_fetchUserCartItem_When_Success() {
		CartRequest cartRequest =cartRequestObj();
		Cart cartData = cartObj();
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cartData);
		when(cartRepository.fetchCartItemByCartId(Mockito.anyString())).thenReturn(cartListDetails);
		List<Cart> cartListResponse = mockCartImpl.fetchUserCartItem(cartRequest);
		Assert.assertEquals(1, cartListResponse.size());
	}
	
}
