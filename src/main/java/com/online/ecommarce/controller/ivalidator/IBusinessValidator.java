/**
 * 
 */
package com.online.ecommarce.controller.ivalidator;

import com.online.ecommarce.model.CartRequest;

/**
 * Data validation like check the item quantity
 * 
 * @author RanjeetSi
 *
 */
public interface IBusinessValidator {
	
	/**
	 * Check product quantity
	 * @param cartRequest
	 * @return boolean
	 */
	boolean checkItemQuantity(CartRequest cartRequest);
}
