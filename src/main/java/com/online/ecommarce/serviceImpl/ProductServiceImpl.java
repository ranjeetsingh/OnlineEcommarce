package com.online.ecommarce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.ecommarce.entity.Product;
import com.online.ecommarce.iservice.IProductService;
import com.online.ecommarce.model.ProductRequest;
import com.online.ecommarce.repository.ProductRepository;

/**
 * Product related implementation
 * @author RanjeetSi
 *
 */
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * This method use to  save product information in product tbl
	 * @param ProductRequest
	 * @return Product
	 * @exception
	 */
	
	@Override
	public Product addProduct(ProductRequest request) {
		try {
			Product productEntity = new Product();
			productEntity.setCatlogId(request.getCatlogId());
			productEntity.setProductName(request.getProductName());
			productEntity.setProductPrice(request.getProductPrice());
			productEntity.setProductQuantity(request.getProductQuantity());
			productEntity.setProductAvailability(request.getProductAvailabilty());
			productEntity.setProductDescription(request.getProductDescription());
			Product productData = productRepository.save(productEntity);
			return productData;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * This method use to  fetch product information in product tbl
	 * @param ProductRequest
	 * @return Product
	 */
	
	@Override
	public Product fetchProduct(long productId) {
		Product productData = productRepository.fetchProdcutDetails(productId);
		return productData;
	}
}
