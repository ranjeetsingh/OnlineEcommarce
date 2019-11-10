package com.online.ecommarce.iservice;

import com.online.ecommarce.entity.User;
import com.online.ecommarce.model.UserRequest;
/**
 * Method related to userImpl
 * @author RanjeetSi
 *
 */
public interface IUserService {
	/**
	 * User register method
	 * @param UserRequest
	 * @return User
	 */
	User userRegistation(UserRequest request);
	

}
