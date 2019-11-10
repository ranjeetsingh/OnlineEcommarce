package com.online.ecommarce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.Product;

/**
 * Product Repository for product table.
 * @author RanjeetSi
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * fetch the product details on the basis of product id
	 * @param id
	 * @return Product
	 */
	@Query("SELECT p FROM Product p WHERE p.id = :id")
	public Product  fetchProdcutDetails(@Param("id") long id);
	
	
}
