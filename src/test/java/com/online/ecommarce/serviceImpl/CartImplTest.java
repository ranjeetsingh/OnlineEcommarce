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
import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
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
class CartImplTest {
	@InjectMocks
	CartImpl mockCartImpl;
	@Mock
	private CartRepository cartRepository;
	@Mock
	private ProductRepository productRepository;
	@Mock
	private CartSummaryRepository cartSummaryRepo;
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	} 
	
	/**
	 * add to cart test cases
	 */
	
	@Test
	public void testAddToCart() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setQuantity("2");
		cartRequest.setUserId("user01");
		
		Product product = new Product();
		product.setCatlogId("3");
		product.setId(1);
		product.setProductDescription("Mobile");
		product.setProductName("MI");
		product.setProductQuantity("20");
		product.setProductPrice(5000);
		product.setProductAvailability("Y");
		
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		
		Cart cart =new Cart();
		cart.setCatlogId("1");
		cart.setId(2);
		cart.setProductId(3);
		cart.setProductName("MObile");
		cart.setProductPrice(20000);
		cart.setProductQuantity("3");
		cart.setProductStatus("Y");
		cart.setUserId("3");
		when(cartRepository.getProdcutDetailsFromCart(Mockito.anyString(), Mockito.anyLong())).thenReturn(null);
		
		Cart cartEntity = new Cart();
		cartEntity.setCatlogId("1");
		cartEntity.setId(1);
		cartEntity.setProductId(1);
		cartEntity.setProductName("MI");
		cartEntity.setProductPrice(20000);
		cartEntity.setProductPrice(50);
		cartEntity.setProductStatus("Y");
		cartEntity.setUserId("3");
		when(cartRepository.save(cartEntity)).thenReturn(null);
		
		CartSummary cartSummary = new CartSummary();
		cartSummary.setId(1);
		cartSummary.setActioDescription("Product Add");
		when(cartSummaryRepo.save(cartSummary)).thenReturn(null);
		
		String getStatus = mockCartImpl.addToCart(cartRequest); 
		Assert.assertEquals(AppConstant.ADD_PRODUCT_SUCCESS, getStatus);
		
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
		
		Product product = new Product();
		product.setCatlogId("1");
		product.setId(1);
		product.setProductDescription("Mobile");
		product.setProductName("MI");
		product.setProductQuantity("20");
		product.setProductPrice(5000);
		product.setProductAvailability("Y");
		
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		when(cartRepository.UpdateItemQuantityInCart(Mockito.anyString(), Mockito.anyLong(),Mockito.anyString())).thenReturn(1);
		CartSummary cartSummary = new CartSummary();
		cartSummary.setId(1);
		cartSummary.setActioDescription("Product Add");
		when(cartSummaryRepo.save(cartSummary)).thenReturn(null);
		
		String getStatus = mockCartImpl.updateCartQuantity(cartRequest);
		Assert.assertEquals(AppConstant.CART_ITEM_QUANTITY, getStatus);
	}
	
	/**
	 * remove product quantity in cart test cases
	 */
	
	@Test
	public void testRemoveProductFromCart() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setProductId(30);
		cartRequest.setUserId("user01");
		
		Cart cart =new Cart();
		cart.setCatlogId("1");
		cart.setId(1);
		cart.setProductId(1);
		cart.setProductName("MObile");
		when(cartRepository.getProdcutDetailsFromCart(Mockito.anyString(), Mockito.anyLong())).thenReturn(cart);
		when(cartRepository.RemoveItemFromCart(Mockito.anyString(), Mockito.anyLong(),Mockito.anyString())).thenReturn(1);

		Product product = new Product();
		product.setCatlogId("1");
		product.setId(1);
		product.setProductDescription("Mobile");
		product.setProductName("MI");
		Optional<Product> productList= Optional.of(product);
		when(productRepository.findById(Mockito.anyLong())).thenReturn(productList);
		
		CartSummary cartSummary = new CartSummary();
		cartSummary.setId(1);
		cartSummary.setActioDescription("Product Add");
		when(cartSummaryRepo.save(cartSummary)).thenReturn(null);
		
		String getStatus = mockCartImpl.removeProductFromCart(cartRequest);
		Assert.assertEquals(AppConstant.ITEM_DELETED_SUCCESS, getStatus);
		
	}
	
	/**
	 * clear all product from cart test cases
	 */
	
	@Test
	public void testClearAllItemFromCart() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setUserId("user01");
		
		Cart cart =new Cart();
		cart.setCatlogId("1");
		cart.setId(1);
		cart.setProductId(1);
		cart.setProductName("MObile");
		List<Cart> cartListDetails = new ArrayList<Cart>();
		cartListDetails.add(cart);
		
		when(cartRepository.getUserExists(Mockito.anyString())).thenReturn(cartListDetails);
		when(cartRepository.ClearAllItemFromCart(Mockito.anyString(), Mockito.anyString())).thenReturn(1);
		String getStatus = mockCartImpl.ClearAllItemFromCart(cartRequest);
		Assert.assertEquals(AppConstant.ALL_ITEM_DELETED, getStatus);
		
		
		
	}
	
	/**
	 * get user cart summary test cases
	 */
	@Test
	public void testGetCartSummary() {
		CartRequest cartRequest = new CartRequest();
		cartRequest.setUserId("user01");
		
		CartSummary cartSummary = new CartSummary();
		cartSummary.setId(1);
		cartSummary.setActioDescription("Product Add");
		List<CartSummary> cartListDetails = new ArrayList<CartSummary>();
		cartListDetails.add(cartSummary);
		
		when(cartSummaryRepo.getCartSummary(Mockito.anyString())).thenReturn(cartListDetails);
		List<CartSummary> cartListResponse = mockCartImpl.getCartSummary(cartRequest);
		Assert.assertEquals(1, cartListResponse.size());
	}
}
