package com.online.ecommarce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.iservice.iCatlog;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.model.CatlogResponse;
import com.online.ecommarce.model.ResponseModel;
/**
 * Action related catlog
 * @author RanjeetSi
 *
 */
@RestController
public class CatLogController {

	@Autowired
	private iCatlog icatlog;

	/**
	 * add catlog in catlog tbl
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/addCatlog")
	public ResponseEntity<Object> addCatlog(@RequestBody CatlogRequest request) {
		try {
			if (request.getCatlogId() == null || request.getCatlogName() == null 
					|| request.getCatlogId() == "" || request.getCatlogName() == "") {
				return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.CAT_LOG_CAN_NOT_EMPTY, null, 1),
						HttpStatus.NOT_FOUND);
			} else {
				Catlog catlogData = (Catlog) icatlog.addCatlog(request);
				return new ResponseEntity<Object>(
						new ResponseModel(true, AppConstant.CAT_LOG_ADD_SUCCESS,
								new CatlogResponse(catlogData.getCatlogId(), catlogData.getCatlogName()), 0),
						HttpStatus.CREATED);
			}
		} catch (Exception e) {

			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
