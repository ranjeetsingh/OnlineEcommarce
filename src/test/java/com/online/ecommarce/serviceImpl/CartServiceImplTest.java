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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.Option;
import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IBusinessValidator;
import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartItemRequest;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.repository.CartRepository;
import com.online.ecommarce.repository.CartSummaryRepository;
import com.online.ecommarce.repository.ProductRepository;


/**
 * test the cart action
 * @author RanjeetSi
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class CartServiceImplTest {
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
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setQuantity(2);
		cartRequest.setUserId(1);
		
		Product product = new Product();
		product.setCatlogId(3);
		product.setId(1);
		product.setProductDescription("Mobile");
		product.setProductName("MI");
		product.setProductQuantity(20);
		product.setProductPrice(5000);
		product.setProductAvailability("Y");
		
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		//when(serviceValidator.checkProductOutOfStack(productList)).thenReturn(false);
		//when(serviceValidator.checkItemQuantity(cartRequest)).thenReturn(true);
		Cart cart =new Cart();
		cart.setId(2);
		cart.setProductId(1);
		cart.setProductPrice(20000);
		cart.setProductOrderQuantity(3);
		cart.setUserId(3);
		when(cartRepository.getProdcutDetailsFromCart(Mockito.anyLong(), Mockito.anyLong())).thenReturn(null);
		
		Cart cartEntity = new Cart();
		cartEntity.setId(1);
		cartEntity.setProductId(1);
		cartEntity.setProductPrice(20000);
		cartEntity.setProductPrice(50);
		cartEntity.setUserId(3);
		when(cartRepository.save(cartEntity)).thenReturn(null);
	
		
		String getStatus = mockCartImpl.addToCart(cartRequest); 
		Assert.assertEquals(AppConstant.ADD_PRODUCT_SUCCESS, getStatus);
		
	}
	
	/**
	 * add to cart test cases fail
	 */
	
	@Test
	public void test_AddToCart_When_Fail() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setQuantity(22);
		cartRequest.setUserId(1);
		
		Product product = new Product();
		product.setCatlogId(3);
		product.setId(1);
		product.setProductDescription("Mobile");
		product.setProductName("MI");
		product.setProductQuantity(0);
		product.setProductPrice(5000);
		product.setProductAvailability("Y");
		
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		//when(serviceValidator.checkProductOutOfStack(productList)).thenReturn(true);
		when(serviceValidator.checkItemQuantity(cartRequest)).thenReturn(true);
		Cart cart =new Cart();
		cart.setId(2);
		cart.setProductId(1);
		cart.setProductPrice(20000);
		cart.setProductOrderQuantity(3);
		cart.setUserId(3);
		when(cartRepository.getProdcutDetailsFromCart(Mockito.anyLong(), Mockito.anyLong())).thenReturn(null);
		
		Cart cartEntity = new Cart();
		cartEntity.setId(1);
		cartEntity.setProductId(1);
		cartEntity.setProductPrice(20000);
		cartEntity.setProductPrice(50);
		cartEntity.setUserId(3);
		when(cartRepository.save(cartEntity)).thenReturn(null);
	
		
		String getStatus = mockCartImpl.addToCart(cartRequest); 
		Assert.assertEquals(AppConstant.PRODUCT_OUT_STOCK, getStatus);
		
	}
	
	/**
	 * update product quantity in cart test cases
	 */
	
	@Test
	public void test_UpdateCartQuantity_When_Success() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setQuantity(2);
		cartRequest.setUserId(1);
		cartRequest.setCartId("1");
		
		Product product = new Product();
		product.setCatlogId(1);
		product.setId(1);
		product.setProductDescription("Mobile");
		product.setProductName("MI");
		product.setProductQuantity(20);
		product.setProductPrice(5000);
		product.setProductAvailability("Y");
		
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		//when(serviceValidator.checkItemQuantity(cartRequest)).thenReturn(true);
		when(cartRepository.UpdateItemQuantityInCart(Mockito.anyLong(),Mockito.anyInt(),Mockito.anyString(),Mockito.anyDouble())).thenReturn(1);
		
		
		String getStatus = mockCartImpl.updateCartQuantity(cartRequest);
		Assert.assertEquals(AppConstant.CART_ITEM_QUANTITY, getStatus);
	}
	
	/**
	 * remove product quantity in cart test cases
	 */
	
	@Test
	public void test_RemoveProductFromCart__When_Success() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setUserId(1);
		cartRequest.setCartId("1");
		
		Cart cart =new Cart();
		cart.setId(1);
		cart.setProductId(1);
		//when(cartRepository.getProdcutDetailsFromCart(Mockito.anyLong(), Mockito.anyLong())).thenReturn(cart);
		when(cartRepository.RemoveItemFromCart(Mockito.anyLong(),Mockito.anyString())).thenReturn(1);

		Product product = new Product();
		product.setCatlogId(1);
		product.setId(1);
		product.setProductDescription("Mobile");
		product.setProductName("MI");
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
		CartRequest cartRequest = new CartRequest();
		cartRequest.setCartId("1");
		
		Cart cart =new Cart();
		cart.setId(1);
		cart.setProductId(1);
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cart);
		
		//when(cartRepository.getUserExists(Mockito.anyLong())).thenReturn(cartListDetails);
		when(cartRepository.ClearAllItemFromCart(Mockito.anyString())).thenReturn(1);
		String getStatus = mockCartImpl.removeAllItemFromCart(cartRequest);
		Assert.assertEquals(AppConstant.ALL_ITEM_DELETED, getStatus);
		
		
		
	}
	
	/**
	 * get user cart summary test cases
	 */
	@Test
	public void test_GetCartSummary_When_Success() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setUserId(1);
		
		CartSummary cartSummary = new CartSummary();
		cartSummary.setId(1);
		cartSummary.setActioDescription("Product Add");
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
		CartItemRequest cartRequest = new CartItemRequest();
		cartRequest.setCartId("1");
		
		Cart cartData = new Cart();
		cartData.setId(1);
		cartData.setProductOrderQuantity(1);
		cartData.setCartId("1");
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cartData);
		
		when(cartRepository.fetchCartItemByCartId(Mockito.anyString())).thenReturn(cartListDetails);
		List<Cart> cartListResponse = mockCartImpl.fetchUserCartItem(cartRequest);
		Assert.assertEquals(1, cartListResponse.size());
	}
	
}
