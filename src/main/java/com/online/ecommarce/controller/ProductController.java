package com.online.ecommarce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IDataRequestValidator;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.iservice.IProductService;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.model.ProductResponse;
import com.online.ecommarce.model.ResponseModel;

/**
 * All operation related Product
 * @author RanjeetSi
 *
 */
@RestController
public class ProductController {
	
	@Autowired
	private IProductService productService;
	@Autowired
	private IDataRequestValidator validatorService;
	
	/**
	 * This is a POST method to add product details in product table
	 * @param ProductRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */
	
	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProductDetails(@RequestBody ProductRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// ValidatorFrameWork for Data Validation for product name and product description
			responseEntity = validatorService.validateProductNameAndDescription(request);
			//check responseEntity is null then add product in table
			if (responseEntity == null) {
				Product productData = (Product) productService.addProduct(request);
				responseEntity = new ResponseEntity<Object>(new ResponseModel(true, AppConstant.ADD_PRODUCT_SUCCESS,
						new ProductResponse(productData.getId(), productData.getCatlogId(),
								productData.getProductName(), productData.getProductPrice(),
								productData.getProductQuantity(), productData.getProductAvailability(),
								productData.getProductDescription()),
						0), HttpStatus.CREATED);
			}

		} catch (Exception e) {

			responseEntity = new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

}
