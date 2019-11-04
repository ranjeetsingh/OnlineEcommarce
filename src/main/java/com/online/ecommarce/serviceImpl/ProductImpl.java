package com.online.ecommarce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.ecommarce.entity.Product;
import com.online.ecommarce.iservice.iProduct;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.repository.ProductRepository;

/**
 * Product related implementation
 * @author RanjeetSi
 *
 */
@Service
public class ProductImpl implements iProduct{

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * save product information in product tbl
	 */

	@Override
	public Product addProduct(ProductRequest request) {
		Product productEntity = new Product();
		productEntity.setCatlogId(request.getCatlogId());
		productEntity.setProductName(request.getProductName());
		productEntity.setProductPrice(request.getProductPrice());
		productEntity.setProductQuantity(request.getProductQuantity());
		productEntity.setProductAvailability(request.getProductAvailabilty());
		productEntity.setProductDescription(request.getProductDescription());
		Product productData = productRepository.save(productEntity);
		return productData;
	}

}
