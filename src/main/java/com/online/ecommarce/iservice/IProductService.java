package com.online.ecommarce.iservice;

import com.online.ecommarce.entity.Product;
import com.online.ecommarce.model.ProductRequest;
/**
 * Method related to product Impl
 * @author RanjeetSi
 *
 */
public interface IProductService {
	/**
	 * add item in product table
	 * @param productRequest
	 * @return Product
	 */
	Product addProduct(ProductRequest request);
	
	/**
	 * fetch item in product table
	 * @param productRequest
	 * @return Product
	 */
	Product fetchProduct(long productId);
	

}
