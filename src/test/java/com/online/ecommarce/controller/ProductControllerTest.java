/**
 * 
 */
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

import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.testUtills.TestUtills;

/**
 * test for add product in product table
 * 
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductControllerTest extends TestUtills {

	/*
	 * @Autowired private ProductController productController;
	 */
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	/**
	 * test for add product in table
	 */
	@Test
	public void testAddProduct() {
		/*
		 * ProductRequest productRequest = new ProductRequest();
		 * productRequest.setCatlogId("catlog05");
		 * productRequest.setProductName("Hero Honda");
		 * productRequest.setProductPrice(58000);
		 * productRequest.setProductQuantity("50");
		 * productRequest.setProductAvailabilty("H");
		 * productRequest.setProductDescription("Black color "); ResponseEntity<Object>
		 * obj = productController.addProduct(productRequest);
		 * System.out.println(obj+"===>"); Assert.assertEquals(201,
		 * obj.getStatusCodeValue());
		 */

		String uri = "/addProduct";
		try {
			ProductRequest productRequest = new ProductRequest();
			productRequest.setCatlogId("catlog05");
			productRequest.setProductName("Scooty");
			productRequest.setProductPrice(58000);
			productRequest.setProductQuantity("50");
			productRequest.setProductAvailabilty("H");
			productRequest.setProductDescription("Black color ");

			String inputJson = super.mapToJson(productRequest);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(201, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
