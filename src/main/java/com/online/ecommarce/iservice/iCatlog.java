package com.online.ecommarce.iservice;

import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.model.CatlogRequest;
/**
 * Method related to catlog impl
 * @author RanjeetSi
 *
 */
public interface iCatlog {
	Catlog addCatlog(CatlogRequest catlogRequest);
	

}
