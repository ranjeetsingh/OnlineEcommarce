/**
 * 
 */
package com.online.ecommarce.serviceImpl;

import static org.mockito.Mockito.when;

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

import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.repository.ProductRepository;

/**
 * test product action
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductImplTest {
	@InjectMocks
	private ProductImpl productImpl;

	@Mock
	private ProductRepository productRepository;
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	} 
	
	
	@Test
	public void testAddProduct() {
		ProductRequest  prodReq = new ProductRequest();
		prodReq.setCatlogId("catlog01");
		prodReq.setProductName("iPhone 10");
		prodReq.setProductPrice(90000);
		prodReq.setProductQuantity("15");
		prodReq.setProductAvailabilty("H");
		prodReq.setProductDescription("Black Color, 16GB RAM");
		
		Product productEntity = new Product();
		productEntity.setCatlogId("catlog01");
		productEntity.setProductName("iPhone 10");
		productEntity.setProductPrice(90000);
		productEntity.setProductQuantity("15");
		productEntity.setProductDescription("Black Color, 16GB RAM");
		
		when(productRepository.save(Mockito.any())).thenReturn(productEntity);
		Product productInfo =new Product();
		productInfo = productImpl.addProduct(prodReq);
		Assert.assertEquals(productInfo.getProductName(), productEntity.getProductName());
		
		
		
		
	}

}
