/**
 * 
 */
package com.online.ecommarce.controller.ivalidator;

import java.util.Optional;

import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.CartRequest;

/**
 * Data validation like product is out of stock, cart Id....etc
 * 
 * @author RanjeetSi
 *
 */
public interface IServiceValidator {
	/**
	 * Check product is out of stock or not
	 * @param productData
	 * @return
	 */
	boolean checkProductOutOfStack(Optional<Product> productData);

	/**
	 * Check product quantity
	 * @param cartRequest
	 * @return
	 */
	boolean checkItemQuantity(CartRequest cartRequest);
}
