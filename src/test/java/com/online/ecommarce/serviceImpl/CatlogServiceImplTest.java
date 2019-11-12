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
import com.online.ecommarce.testUtills.JUnitObjectServiceImpl;

/**
 * test category log
 * @author RanjeetSi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CatlogServiceImplTest extends JUnitObjectServiceImpl {
	
	@InjectMocks
	private CatlogServiceImpl catlogImpl;
	@Mock
	private CatlogRepository catlogRepository;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	} 
	
	/**
	 * test success when add catlog in catlog table
	 */
	@Test
	public void test_AddCatlog_When_Success() {
		CatlogRequest catlogRequest = catlogRequestObj();
		Catlog catlogEntity = catlogEntityObj();
		when(catlogRepository.save(Mockito.any())).thenReturn(catlogEntity);
		Catlog catlog = catlogImpl.addCatlog(catlogRequest);
		Assert.assertEquals(catlog.getCatlogName(),catlogEntity.getCatlogName());
		
		
		
		
	}

}
