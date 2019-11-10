package com.online.ecommarce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.ecommarce.entity.User;
import com.online.ecommarce.iservice.IUserService;
import com.online.ecommarce.model.UserRequest;
import com.online.ecommarce.repository.UserRepository;
/**
 * User related implementation
 * @author RanjeetSi
 *
 */
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userReposiotry;
	
	/**
	 * This method use to save user information in user tbl
	 * @param UserRequest
	 * @return User
	 * @exception
	 */
	@Override
	public User userRegistation(UserRequest request) {
		try {
			User userEntity = new User();
			userEntity.setUserEmailId(request.getUserEmailId());
			userEntity.setUserName(request.getUserName());
			User userdata = userReposiotry.save(userEntity);
			return userdata;
		} catch (Exception e) {
			return null;
		}
		
	}

}
