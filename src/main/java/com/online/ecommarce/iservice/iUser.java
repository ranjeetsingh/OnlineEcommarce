package com.online.ecommarce.iservice;

import com.online.ecommarce.entity.User;
import com.online.ecommarce.model.UserRequest;
/**
 * Method related to userImpl
 * @author RanjeetSi
 *
 */
public interface iUser {
	User userRegistation(UserRequest request);
	

}
