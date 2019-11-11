/**
 * 
 */
package com.online.ecommarce.controller.ivalidator;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.model.UserRequest;

/**
 * These methods use in controller
 * Method for request field validation like userId, CartId..etc 
 * @author RanjeetSi
 *
 */
public interface IDataRequestValidator {
	
	
	/**
	 * Check user id is empty or not
	 * @param request
	 * @return boolean
	 */
	public boolean checkUserIdEmpty(CartRequest request);
	/**
	 * Check cart id is empty or not
	 * @param request
	 * @return boolean
	 */
	public boolean checkCartIdEmpty(CartRequest request);

	/**
	 * validate userId
	 * @param cartRequest
	 * @return ResponseEntity<Object>
	 */
	public ResponseEntity<Object> validateUser(CartRequest cartRequest);
	
	/**
	 * validate cart Id
	 * @param cartRequest
	 * @return ResponseEntity<Object>
	 */
	public ResponseEntity<Object> validateCartId(CartRequest cartRequest);
	
	/**
	 * check userName and User email is empty
	 * @param cartRequest
	 * @return boolean
	 */
	public boolean checkUserNameAndUserEmail(UserRequest request);
	
	/**
	 * validate userName and User Email
	 * @param UserRequest
	 * @return ResponseEntity<Object>
	 */
	public ResponseEntity<Object> validateUserNameAndUserEmail(UserRequest userRequest);
	
	/**
	 * check product name and product description is empty
	 * @param ProductRequest
	 * @return boolean
	 */
	public boolean checkProductNameAndDescription(ProductRequest request);
	
	/**
	 * validate product name and product description
	 * @param ProductRequest
	 * @return ResponseEntity<Object>
	 */
	public ResponseEntity<Object> validateProductNameAndDescription(ProductRequest request);
	
	/**
	 * check catlogName is empty
	 * @param CatlogRequest 
	 * @return boolean
	 */
	public boolean checkCatlogName(CatlogRequest request);
	
	/**
	 * validate catlogName
	 * @param ProductRequest
	 * @return ResponseEntity<Object>
	 */
	public ResponseEntity<Object> validateCatlogName(CatlogRequest request);
	/**
	 * Check product is out of stock or not
	 * @param productData
	 * @return
	 */
	boolean checkProductOutOfStack(Optional<Product> productData);

	
}
