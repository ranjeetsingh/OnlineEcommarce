/**
 * 
 */
package com.online.ecommarce.serviceImpl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.ProductRequest;

/**
 * test product action
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductImplTest {
	@Autowired
	private ProductImpl productImpl;

	@Test
	public void testAddProduct() {
		ProductRequest  prodReq = new ProductRequest();
		prodReq.setCatlogId("catlog01");
		prodReq.setProductName("iPhone 10");
		prodReq.setProductPrice(90000);
		prodReq.setProductQuantity("15");
		prodReq.setProductAvailabilty("H");
		prodReq.setProductDescription("Black Color, 16GB RAM");
		Product productData =productImpl.addProduct(prodReq);
		Assert.assertEquals("iPhone 10", productData.getProductName());
		
	}

}
