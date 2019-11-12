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
import com.online.ecommarce.testUtills.JUnitObjectServiceImpl;

/**
 * test product action
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest extends JUnitObjectServiceImpl{
	@InjectMocks
	private ProductServiceImpl productImpl;

	@Mock
	private ProductRepository productRepository;
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	} 
	
	/**
	 * test success when add product success
	 */
	@Test
	public void test_AddProduct_When_Success() {
		ProductRequest  prodReq = productRequestObj();
		Product productEntity = productEntityObj();
		when(productRepository.save(Mockito.any())).thenReturn(productEntity);
		Product productInfo = productImpl.addProduct(prodReq);
		Assert.assertEquals(productInfo.getProductName(), productEntity.getProductName());
	}

}
