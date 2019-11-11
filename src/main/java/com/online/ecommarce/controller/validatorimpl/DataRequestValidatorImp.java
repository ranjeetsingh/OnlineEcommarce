/**
 * 
 */
package com.online.ecommarce.controller.validatorimpl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IDataRequestValidator;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.model.CatlogRequest;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.model.UserRequest;

/**
 * this method implement the IRequestDataValidator
 * 
 * @author RanjeetSi
 */
public class DataRequestValidatorImp implements IDataRequestValidator {

	/**
	 * This method check cart id is empty
	 * 
	 * @param CartRequest
	 * @return boolean
	 */

	@Override
	public boolean checkCartIdEmpty(CartRequest request) {
		if (request.getCartId().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method validate user id
	 * 
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 */
	@Override
	public ResponseEntity<Object> validateUser(CartRequest cartRequest) {
		if (checkUserIdEmpty(cartRequest)) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PLEASE_SEND_USER_ID, null, 1),
					HttpStatus.NOT_FOUND);
		}
		return null;
	}

	/**
	 * This method validate cart id
	 * 
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 */
	@Override
	public ResponseEntity<Object> validateCartId(CartRequest cartRequest) {
		if (checkCartIdEmpty(cartRequest)) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PLEASE_ENTER_CART_ID, null, 1),
					HttpStatus.NOT_FOUND);
		}
		return null;
	}

	/**
	 * This method check user name and user email is empty
	 * 
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 */
	@Override
	public boolean checkUserNameAndUserEmail(UserRequest request) {
		if (request.getUserEmailId().isEmpty() || request.getUserName().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method check user id is 0
	 * 
	 * @param CartRequest
	 * @return boolean
	 */

	@Override
	public boolean checkUserIdEmpty(CartRequest request) {
		if (request.getUserId() == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * This method validate User name and user email
	 * 
	 * @param UserRequest
	 * @return ResponseEntity<Object>
	 */
	@Override
	public ResponseEntity<Object> validateUserNameAndUserEmail(UserRequest userRequest) {
		if (checkUserNameAndUserEmail(userRequest)) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.USER_ID_AND_USERNAME, null, 1),
					HttpStatus.NOT_FOUND);
		}
		return null;
	}

	/**
	 * This method check user name and user email is empty
	 * 
	 * @param ProductRequest
	 * @return boolean
	 */

	@Override
	public boolean checkProductNameAndDescription(ProductRequest request) {
		if (request.getProductName().isEmpty() || request.getProductDescription().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method validate product name and product description
	 * 
	 * @param ProductRequest
	 * @return ResponseEntity<Object>
	 */
	@Override
	public ResponseEntity<Object> validateProductNameAndDescription(ProductRequest request) {
		if (checkProductNameAndDescription(request)) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.PRODUCT_DATA_CAN_NOT_EMPTY, null, 1),
					HttpStatus.NOT_FOUND);
		}
		return null;
	}

	/**
	 * This method check catlogName is empty
	 * 
	 * @param CatlogRequest
	 * @return boolean
	 */
	@Override
	public boolean checkCatlogName(CatlogRequest request) {
		if (request.getCatlogName().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method validate CatlogName
	 * 
	 * @param ProductRequest
	 * @return ResponseEntity<Object>
	 */
	@Override
	public ResponseEntity<Object> validateCatlogName(CatlogRequest request) {
		if (checkCatlogName(request)) {
			return new ResponseEntity<Object>(new ResponseModel(true, AppConstant.CAT_LOG_CAN_NOT_EMPTY, null, 1),
					HttpStatus.NOT_FOUND);
		}
		return null;
	}
	/**
	 * This method check product in stock or not
	 * 
	 * @param Optional<Product>
	 * @return boolean
	 */

	@Override
	public boolean checkProductOutOfStack(Optional<Product> productData) {
		if (productData.get().getProductQuantity() == 0) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
