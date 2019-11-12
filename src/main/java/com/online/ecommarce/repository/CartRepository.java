package com.online.ecommarce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.online.ecommarce.entity.Cart;

/**
 * Cart Repository for cart table.
 * @author RanjeetSi
 *
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	/**
	 * update order item quantity
	 * @param productId
	 * @param productQuantity
	 * @param cartId
	 * @param productPrice
	 * @return int
	 */
	 @Modifying
	 @Query("UPDATE Cart c SET c.productOrderQuantity = :productQuantity,c.productPrice = :productPrice WHERE c.cartId = :cartId AND c.productId = :productId")
	public int  UpdateItemQuantityInCart(@Param("productId") long productId,@Param("productQuantity") int productQuantity,
			@Param("cartId") String cartId,@Param("productPrice") double productPrice);

	/**
	 * Remove single item from cart table on basis of cart id and product id
	 * @param productId
	 * @param cartId
	 * @return int
	 */
	@Modifying
	@Query("DELETE FROM Cart c WHERE c.cartId = :cartId AND c.productId = :productId")
	public int  RemoveItemFromCart(@Param("productId") long productId,@Param("cartId") String cartId);

	/**
	 * Remove all item from cart table on basis of cart Id
	 * @param cartId
	 * @return int
	 */
	@Modifying
	@Query("DELETE FROM Cart c WHERE c.cartId = :cartId")
	public int  ClearAllItemFromCart(@Param("cartId") String cartId);
	
	/**
	 * check product already exists or not in cart table
	 * @param userId
	 * @param productId
	 * @return Cart
	 */
	@Query("SELECT c FROM Cart c WHERE c.userId = :userId AND c.productId = :productId")
	public Cart  getProdcutDetailsFromCart(@Param("userId") long userId, @Param("productId") long productId);
	
	/**
	 * check user exists or not in cart table
	 * @param userId
	 * @return List<Cart>
	 */
	@Query("SELECT c FROM Cart c WHERE c.userId = :userId")
	public List<Cart>  getUserExists(@Param("userId") long userId);
	
	/**
	 * fetch cart details on the basis of cart Id
	 * @param cartId
	 * @return List<Cart>
	 */
	@Query("SELECT c FROM Cart c WHERE c.cartId = :cartId")
	public List<Cart>  fetchCartItemByCartId(@Param("cartId") String cartId);
	
	

}
