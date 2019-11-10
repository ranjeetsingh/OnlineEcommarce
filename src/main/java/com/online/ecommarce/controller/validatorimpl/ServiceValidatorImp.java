/**
 * 
 */
package com.online.ecommarce.controller.validatorimpl;

import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.online.ecommarce.controller.ivalidator.IServiceValidator;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartRequest;

/**
 * check validation for value
 * 
 * @author RanjeetSi
 *
 */
public class ServiceValidatorImp implements IServiceValidator {

	/**
	 * This method check product in stock or not
	 * 
	 * @param Optional<Product>
	 * @return boolean
	 */

	@Override
	public boolean checkProductOutOfStack(Optional<Product> productData) {
		if (productData.get().getProductQuantity() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method check item quantity
	 * 
	 * @param CartRequest
	 * @return boolean
	 */
	@Override
	public boolean checkItemQuantity(CartRequest cartRequest) {

		if (cartRequest.getQuantity() >= 1 && cartRequest.getQuantity() < 6) {
			return true;
		} else {
			return false;
		}
	}

}
