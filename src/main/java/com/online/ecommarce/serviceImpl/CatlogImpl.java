package com.online.ecommarce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.iservice.iCatlog;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.repository.CatlogRepository;
/**
 * Catlog related implementation
 * @author RanjeetSi
 *
 */
@Service
public class CatlogImpl implements iCatlog{

	@Autowired
	private CatlogRepository catlogRepository;
	
	/**
	 * save catlog information in catlog tbl
	 */
	@Override
	public Catlog addCatlog(CatlogRequest catlogRequest) {
		Catlog catlogEntity = new Catlog();
		catlogEntity.setCatlogId(catlogRequest.getCatlogId());
		catlogEntity.setCatlogName(catlogRequest.getCatlogName());
		Catlog catlogdata = catlogRepository.save(catlogEntity);
		return catlogdata;
	}

}
