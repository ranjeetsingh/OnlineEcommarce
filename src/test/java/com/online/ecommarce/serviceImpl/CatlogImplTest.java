/**
 * 
 */
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

import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.repository.CatlogRepository;

/**
 * test category log
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CatlogImplTest {
	
	@InjectMocks
	private CatlogImpl catlogImpl;
	@Mock
	private CatlogRepository catlogRepository;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	} 
	
	
	@Test
	public void testAddCatlog() {
		CatlogRequest catlogRequest = new CatlogRequest();
		catlogRequest.setCatlogId("catlog04");
		catlogRequest.setCatlogName("Washing Machine");
		
		Catlog catlog = new Catlog();
		Catlog catlogEntity = new Catlog();
		catlogEntity.setCatlogId("1");
		catlogEntity.setCatlogName("Cat01");
		
		when(catlogRepository.save(Mockito.any())).thenReturn(catlogEntity);
		
		catlog = catlogImpl.addCatlog(catlogRequest);
		Assert.assertEquals(catlog.getCatlogId(),catlogEntity.getCatlogId());
		
		
		
		
	}

}
