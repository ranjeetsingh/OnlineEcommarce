package com.online.ecommarce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IDataRequestValidator;
import com.online.ecommarce.entity.User;
import com.online.ecommarce.iservice.IUserService;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.model.UserRequest;
import com.online.ecommarce.model.UserResponse;

/**
 * All operation related User
 * @author RanjeetSi
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IDataRequestValidator validatorService;

	/**
	 * This is a POST method is use for user register
	 * @param UserRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */
	@PostMapping("/userRegistration")
	public ResponseEntity<Object> userRegister(@RequestBody UserRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// Validation pattern for Data Validation for user name and email
			responseEntity = validatorService.validateUserNameAndUserEmail(request);
			//check responseEntity is null then user register 
			if(responseEntity == null) {	
			User userData = (User) userService.userRegistation(request);
			responseEntity =  new ResponseEntity<Object>(new ResponseModel(true, AppConstant.USER_REGISTRATION_SUCCESSFULLY,
					new UserResponse(userData.getUserEmailId(), userData.getUserName()), 0), HttpStatus.CREATED);
			}
		} catch (Exception e) {

			responseEntity =  new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}
	/**
	 * This is a Get method is used to test
	 * @return String
	 * @Exception
	 */
	@GetMapping("/getTest")
	public String getTest() {
		return "Hello Test";
	}
	

}
