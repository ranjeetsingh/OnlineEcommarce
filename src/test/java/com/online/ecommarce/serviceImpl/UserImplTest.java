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

import com.online.ecommarce.entity.User;
import com.online.ecommarce.model.UserRequest;
import com.online.ecommarce.repository.UserRepository;

/**
 * test UserImpl action
 * @author RanjeetSi
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class UserImplTest {
	
	@InjectMocks
	private UserImpl mockUserImpl;
	
	@Mock
	private UserRepository userReposiotry;
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	} 
	
	/**
	 * test case for user registration
	 */
	@Test
	public void testUserRegistation() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUserId("user04");
		userRequest.setUserName("Ranjeet");
		
		User userInfo = new User();
		User userEntity = new User();
		userEntity.setUserId("user04");
		userEntity.setUserName("Ranjeet");
		when(userReposiotry.save(Mockito.any())).thenReturn(userEntity);
		
		userInfo = mockUserImpl.userRegistation(userRequest);
		Assert.assertEquals(userInfo.getUserId(), userEntity.getUserId());
	}
}
