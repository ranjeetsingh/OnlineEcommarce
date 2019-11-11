/**
 * 
 */
package com.online.ecommarce.controller.validatorimpl;

import com.online.ecommarce.controller.ivalidator.IBusinessValidator;
import com.online.ecommarce.model.CartRequest;

/**
 * check validation for value
 * 
 * @author RanjeetSi
 *
 */
public class BusinessValidatorImp implements IBusinessValidator {

	
	/**
	 * This method check item quantity
	 * @param CartRequest
	 * @return boolean
	 */
	@Override
	public boolean checkItemQuantity(CartRequest cartRequest) {

		if (cartRequest.getQuantity() >= 1 && cartRequest.getQuantity() < 6) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
