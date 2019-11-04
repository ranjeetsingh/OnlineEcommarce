package com.online.ecommarce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.entity.User;
import com.online.ecommarce.iservice.iUser;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.model.UserRequest;
import com.online.ecommarce.model.UserResponse;

/**
 * Action related User
 * @author RanjeetSi
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private iUser iUser;
	
	/**
	 * use for user registration
	 * @param request
	 * @return
	 */
	@PostMapping("/userRegistration")
	public ResponseEntity<Object> userRegistration(@RequestBody UserRequest request) {
		try {
			if(request.getUserId() == null || request.getUserName() == null) {// check request value null
				return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.USER_ID_CAN_NOT_NULL, null, 1),
						HttpStatus.NOT_ACCEPTABLE);
			}
			if (request.getUserId() == "" || request.getUserName() == "") {// check for request value not empty
				return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.USER_ID_AND_USERNAME, null, 1),
						HttpStatus.NOT_FOUND);
			}else {
			User userData = (User) iUser.userRegistation(request);
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.USER_REGISTRATION_SUCCESSFULLY,
					new UserResponse(userData.getUserId(), userData.getUserName()), 0), HttpStatus.CREATED);
			}
		} catch (Exception e) {

			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	/**
	 * test method for docker 
	 */
	@GetMapping("/getTest")
	public String getTest() {
		return "Hello Test";
	}

}
