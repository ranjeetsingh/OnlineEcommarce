/**
 * 
 */
package com.online.ecommarce.serviceImpl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.model.CatlogRequest;

/**
 * test category log
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CatlogImplTest {
	
	@Autowired
	private CatlogImpl catlogImpl;

	@Test
	public void testAddCatlog() {
		CatlogRequest catlogRequest = new CatlogRequest();
		catlogRequest.setCatlogId("catlog04");
		catlogRequest.setCatlogName("Washing Machine");
		Catlog catlogData =catlogImpl.addCatlog(catlogRequest);
		Assert.assertEquals("catlog04", catlogData.getCatlogId());
		
		
		
	}

}
