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
import com.online.ecommarce.entity.User;
import com.online.ecommarce.iservice.IUserService;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.model.UserRequest;
import com.online.ecommarce.testUtills.JUnitObjectServiceImpl;

/**
 * Test case related to user
 * 
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest extends JUnitObjectServiceImpl {
	@InjectMocks 
	private UserController userController;
	@Mock
	private IUserService userService;
	@Mock
	private IDataRequestValidator validatorService;
	
	/**
	 * test success for user registration
	 */
	@Test
	public void test_UserRegister_When_Success() {
			UserRequest userRequest = userRequestObj();
			ResponseEntity<Object> getResponseEntity = commonResponseEntity();
			when(validatorService.validateUserNameAndUserEmail(userRequest)).thenReturn(getResponseEntity);
			User userData = userEntityObj();
			when(userService.userRegistation(Mockito.any())).thenReturn(userData);
			ResponseEntity<Object> responseEntity = userController.userRegister(userRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(404);
	}
	
	/**
	 * test fail for user registration
	 */
	@Test
	public void test_UserRegister_When_Fail() {
			UserRequest userRequest = userRequestObj();
			when(validatorService.validateUserNameAndUserEmail(userRequest)).thenReturn(null);
			User userData = userEntityObj();
			when(userService.userRegistation(Mockito.any())).thenReturn(userData);
			ResponseEntity<Object> responseEntity = userController.userRegister(userRequest);
			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}
	
	/**
	 * test Exception for user registration
	 */
	@Test
	public void test_UserRegister_When_Exception() {
			UserRequest userRequest = userRequestObj();
			when(validatorService.validateUserNameAndUserEmail(userRequest)).thenThrow(NullPointerException.class);
			User userData = userEntityObj();
			when(userService.userRegistation(null)).thenReturn(userData);
			ResponseEntity<Object> responseEntity = userController.userRegister(userRequest);
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
