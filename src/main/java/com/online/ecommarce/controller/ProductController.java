package com.online.ecommarce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.entity.User;
import com.online.ecommarce.iservice.iProduct;
import com.online.ecommarce.iservice.iUser;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.model.ProductResponse;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.model.UserRequest;
import com.online.ecommarce.model.UserResponse;

/**
 * Action Related Product
 * @author RanjeetSi
 *
 */
@RestController
public class ProductController {
	
	@Autowired
	private iProduct iproduct;
	
	/**
	 * use for user registration
	 * @param request
	 * @return
	 */
	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProduct(@RequestBody ProductRequest request) {
		try {
			if (request.getProductName() == null || request.getProductDescription() == null 
					|| request.getProductName() == "" || request.getProductDescription() == "") {
				return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PRODUCT_DATA_CAN_NOT_EMPTY, null, 1),
						HttpStatus.NOT_FOUND);
			}else {
				
			Product productData = (Product) iproduct.addProduct(request);
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.ADD_PRODUCT_SUCCESS,
					new ProductResponse(productData.getId(), productData.getCatlogId(), productData.getProductName(), 
							productData.getProductPrice(),productData.getProductQuantity(), productData.getProductAvailability(),
							productData.getProductDescription()), 0), HttpStatus.CREATED);
			}
			
		} catch (Exception e) {

			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
