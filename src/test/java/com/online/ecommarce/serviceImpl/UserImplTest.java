package com.online.ecommarce.serviceImpl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.online.ecommarce.entity.User;
import com.online.ecommarce.model.UserRequest;

/**
 * test UserImpl action
 * @author RanjeetSi
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class UserImplTest {

	@Autowired
	private UserImpl userImpl;
	/**
	 * test case for user registration
	 */
	@Test
	public void testUserRegistation() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUserId("user04");
		userRequest.setUserName("Ayaz");
		User user = userImpl.userRegistation(userRequest);
		Assert.assertEquals("user04", user.getUserId());
	}
}
