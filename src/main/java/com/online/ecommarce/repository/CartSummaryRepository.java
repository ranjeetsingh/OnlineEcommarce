package com.online.ecommarce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.online.ecommarce.entity.CartSummary;

/**
 * cart summary Repository for cart summary table.
 * @author RanjeetSi
 *
 */
@Repository
public interface CartSummaryRepository extends JpaRepository<CartSummary, Long> {
	/**
	 * fetch the cart summary on the basis of cartId
	 * @param cartId
	 * @return List<CartSummary>
	 */
	@Query("SELECT c FROM CartSummary c WHERE c.cartId = :cartId")
	public List<CartSummary>  getCartSummary(@Param("cartId") String cartId);
}
