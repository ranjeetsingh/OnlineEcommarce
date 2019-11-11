package com.online.ecommarce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IDataRequestValidator;
import com.online.ecommarce.entity.Catlog;
import com.online.ecommarce.iservice.ICatlogService;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.model.CatlogResponse;
import com.online.ecommarce.model.ResponseModel;
/**
 * All operation related catlog
 * @author RanjeetSi
 *
 */
@RestController
public class CatLogController {

	@Autowired
	private ICatlogService catlogService;
	@Autowired
	private IDataRequestValidator validatorService;
	
	/**
	 * This is a POST method to add product Category in catlog tbl
	 * @param CatlogRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */
	
	@PostMapping("/addCatlog")
	public ResponseEntity<Object> addProductCategoryInCatlog(@RequestBody CatlogRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// ValidatorFrameWork for Data Validation for catlogName
			responseEntity = validatorService.validateCatlogName(request);
			//check responseEntity is null then add item in catlog table
			if (responseEntity == null) {
				Catlog catlogData = (Catlog) catlogService.addCatlog(request);
				responseEntity = new ResponseEntity<Object>(new ResponseModel(true, AppConstant.CAT_LOG_ADD_SUCCESS,
						new CatlogResponse(catlogData.getCatlogName()), 0), HttpStatus.CREATED);
			}
		} catch (Exception e) {

			responseEntity = new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

}
