/**
 * 
 */
package com.online.ecommarce.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IDataRequestValidator;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.iservice.IProductService;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.testUtills.JUnitObjectServiceImpl;

/**
 * test for add product in product table
 * 
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductControllerTest extends JUnitObjectServiceImpl {

	
	@InjectMocks 
	private ProductController productController;
	@Mock
	private IProductService productService;
	@Mock
	private IDataRequestValidator validatorService;
	 
	

	/**
	 * test success for add product in table
	 */
	@Test
	public void test_AddProduct_When_Success() {
			ProductRequest productRequest =productRequestObj();
			when(validatorService.validateProductNameAndDescription(productRequest)).thenReturn(null);
			Product productData = productEntityObj();
			when(productService.addProduct(Mockito.any())).thenReturn(productData);
			ResponseEntity<Object> responseEntity = productController.addProductDetails(productRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}
	
	/**
	 * test fail for add product in table
	 */
	@Test
	public void test_AddProduct_When_Fail() {
			ProductRequest productRequest =productRequestObj();
			ResponseEntity<Object> getResponseEntity = commonResponseEntity();
			when(validatorService.validateProductNameAndDescription(productRequest)).thenReturn(getResponseEntity);
			Product productData = productEntityObj();
			when(productService.addProduct(Mockito.any())).thenReturn(productData);
			ResponseEntity<Object> responseEntity = productController.addProductDetails(productRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);
	}
	
	
	/**
	 * test Exception for add product in table
	 */
	@Test
	public void test_AddProduct_When_Exception() {
			ProductRequest productRequest =productRequestObj();
			when(validatorService.validateProductNameAndDescription(productRequest)).thenThrow(NullPointerException.class);
			Product productData = productEntityObj();
			when(productService.addProduct(null)).thenReturn(productData);
			ResponseEntity<Object> responseEntity = productController.addProductDetails(productRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(500);
	}
	
	/**
	 * Create object for ResponseEntity<Object> 
	 * @return ResponseEntity<Object>
	 */
	public ResponseEntity<Object> commonResponseEntity() {
		return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PLEASE_ENTER_CART_ID, null, 1),
				HttpStatus.NOT_FOUND);
	}
}
