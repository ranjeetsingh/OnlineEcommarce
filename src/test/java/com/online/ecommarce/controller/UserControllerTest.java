/**
 * 
 */
package com.online.ecommarce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.online.ecommarce.model.UserRequest;
import com.online.ecommarce.testUtills.TestUtills;

/**
 * Test case related to user
 * 
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest extends TestUtills {

	/*
	 * @Autowired private UserController userController;
	 */

	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	/**
	 * test user registration
	 */
	@Test
	public void testUserRegistration() {

		String uri = "/userRegistration";
		try {
			UserRequest userRequest = new UserRequest();
			userRequest.setUserId("user05");
			userRequest.setUserName("Bipin");

			String inputJson = super.mapToJson(userRequest);
			MvcResult mvcResult = mvc.perform(
					MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(201, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
