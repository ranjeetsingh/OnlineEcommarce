package com.online.ecommarce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.iservice.ICatlogService;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.repository.CatlogRepository;
/**
 * Catlog related implementation
 * @author RanjeetSi
 *
 */
@Service
public class CatlogServiceImpl implements ICatlogService{

	@Autowired
	private CatlogRepository catlogRepository;
	
	/**
	 * This method use to save catlog information in catlog tbl
	 * @param CatlogRequest
	 * @return Catlog
	 * @exception
	 */
	@Override
	public Catlog addCatlog(CatlogRequest catlogRequest) {
		try {
			Catlog catlogEntity = new Catlog();
			// catlogEntity.setCatlogId(catlogRequest.getCatlogId());
			catlogEntity.setCatlogName(catlogRequest.getCatlogName());
			Catlog catlogdata = catlogRepository.save(catlogEntity);
			return catlogdata;
		} catch (Exception e) {
			return null;
		}
	}

}
