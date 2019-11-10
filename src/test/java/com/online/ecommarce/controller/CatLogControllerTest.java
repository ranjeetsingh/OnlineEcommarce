/**
 * 
 */
package com.online.ecommarce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.testUtills.JUnitUtils;

/**
 * Add Category
 * 
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CatLogControllerTest extends JUnitUtils {

	/*
	 * @Autowired private CatLogController catLogController;
	 */

	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	/**
	 * test add category in category table
	 */
	@Test
	public void test_AddCatlog_When_Success() {

		String uri = "/addCatlog";
		try {
			CatlogRequest catLogRequest = new CatlogRequest();
			catLogRequest.setCatlogId("catlog05");
			catLogRequest.setCatlogName("Two Wheeler");

			String inputJson = super.mapToJson(catLogRequest);
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
