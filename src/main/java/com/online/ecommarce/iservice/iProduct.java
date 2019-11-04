package com.online.ecommarce.iservice;

import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.ProductRequest;
/**
 * Method related to product Impl
 * @author RanjeetSi
 *
 */
public interface iProduct {
	Product addProduct(ProductRequest request);
	

}
