package com.online.ecommarce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.ecommarce.entity.Product;

/**
 * Product Repository for product table.
 * @author RanjeetSi
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
