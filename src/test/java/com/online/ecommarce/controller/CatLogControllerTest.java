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
import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.iservice.ICatlogService;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.testUtills.JUnitObjectServiceImpl;

/**
 * Add Category
 * 
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CatLogControllerTest extends JUnitObjectServiceImpl {

	@InjectMocks
	private CatLogController catLogController;
	@Mock
	private IDataRequestValidator validatorService;
	@Mock
	private ICatlogService catlogService;

	/**
	 * test pass when add category in category table
	 */
	@Test
	public void test_AddCatlog_When_Success() {
		CatlogRequest catLogRequest = catlogRequestObj();
		when(validatorService.validateCatlogName(catLogRequest)).thenReturn(null);
		Catlog catlog = catlogEntityObj();
		when(catlogService.addCatlog(Mockito.any())).thenReturn(catlog);
		ResponseEntity<Object> responseEntity = catLogController.addProductCategoryInCatlog(catLogRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}
	/**
	 * test fail when add category in category table
	 */
	@Test
	public void test_AddCatlog_When_Fail() {
		CatlogRequest catLogRequest = catlogRequestObj();
		ResponseEntity<Object> getResponseEntity = commonResponseEntity();
		when(validatorService.validateCatlogName(catLogRequest)).thenReturn(getResponseEntity);
		Catlog catlog = catlogEntityObj();
		when(catlogService.addCatlog(Mockito.any())).thenReturn(catlog);
		ResponseEntity<Object> responseEntity = catLogController.addProductCategoryInCatlog(catLogRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);
	}
	
	
	
	/**
	 * test Exception when add category in category table
	 */
	@Test
	public void test_AddCatlog_When_Exception() {
		CatlogRequest catLogRequest = catlogRequestObj();
		when(validatorService.validateCatlogName(catLogRequest)).thenThrow(NullPointerException.class);
		Catlog catlog = catlogEntityObj();
		when(catlogService.addCatlog(catlogRequestObj())).thenReturn(catlog);
		ResponseEntity<Object> responseEntity = catLogController.addProductCategoryInCatlog(catlogRequestObj());
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
