package com.online.ecommarce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;

/**
 * Cart Repository for cart table.
 * @author RanjeetSi
 *
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	 @Modifying
	 @Query("UPDATE Cart c SET c.productQuantity = :productQuantity WHERE c.userId = :userId AND c.productId = :productId")
	public int  UpdateItemQuantityInCart(@Param("userId") String userId, @Param("productId") long productId,@Param("productQuantity") String productQuantity);

	//@Query("DELETE FROM Cart c WHERE c.userId = :userId AND c.productId = :productId")
	@Modifying
	@Query("UPDATE Cart c SET c.productStatus = :productStatus WHERE c.userId = :userId AND c.productId = :productId")
	public int  RemoveItemFromCart(@Param("userId") String userId, @Param("productId") long productId,@Param("productStatus") String productStatus);

	//remove all item from cart related to user
	@Modifying
	@Query("UPDATE Cart c SET c.productStatus = :productStatus WHERE c.userId = :userId")
	public int  ClearAllItemFromCart(@Param("userId") String userId,@Param("productStatus") String productStatus);
	
	//get product already exists or not in cart table
	@Query("SELECT c FROM Cart c WHERE c.userId = :userId AND c.productId = :productId")
	public Cart  getProdcutDetailsFromCart(@Param("userId") String userId, @Param("productId") long productId);
	
	//get user exists or not in cart table
	@Query("SELECT c FROM Cart c WHERE c.userId = :userId")
	public List<Cart>  getUserExists(@Param("userId") String userId);
	
	

}
