package com.online.ecommarce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.ecommarce.entity.User;
import com.online.ecommarce.iservice.iUser;
import com.online.ecommarce.model.UserRequest;
import com.online.ecommarce.repository.UserRepository;
/**
 * User related implementation
 * @author RanjeetSi
 *
 */
@Service
public class UserImpl implements iUser{

	@Autowired
	private UserRepository userReposiotry;
	
	/**
	 * save user information in user tbl
	 */
	@Override
	public User userRegistation(UserRequest request) {
		User userEntity = new User();
		userEntity.setUserId(request.getUserId());
		userEntity.setUserName(request.getUserName());
		User userdata = userReposiotry.save(userEntity);
		return userdata;
		
	}

}
