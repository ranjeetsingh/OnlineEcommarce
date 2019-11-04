/**
 * 
 */
package com.online.ecommarce.testUtills;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.ecommarce.OnlineEcommerceSystemApplication;

/**
 * @author RanjeetSi
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OnlineEcommerceSystemApplication.class)
@WebAppConfiguration
public class TestUtills {

	public MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {

		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	protected String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	protected <T> T mapFromJson(String json, Class<T> clas)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clas);
	}
}
