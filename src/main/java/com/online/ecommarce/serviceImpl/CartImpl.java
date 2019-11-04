package com.online.ecommarce.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.iservice.iCart;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.repository.CartRepository;
import com.online.ecommarce.repository.CartSummaryRepository;
import com.online.ecommarce.repository.ProductRepository;
/**
 * Cart related implementation
 * @author RanjeetSi
 *
 */

@Service
@Transactional
public class CartImpl implements iCart {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartSummaryRepository cartSummaryRepo;

	/**
	 * check product in stock or not
	 * get product details from product table
	 * add product in cart
	 * Y = Order is Done, N = Order is cancel
	 * add action in cart summary tbl
	 */
	@Override
	public String addToCart(CartRequest request) {
		Optional<Product> productData = productRepository.findById(request.getProductId());
		if (productData.isPresent()) {
			if (productData.get().getProductQuantity().equals("0")) {
				return AppConstant.PRODUCT_OUT_STOCK;
			} else {
				// get get user product already exist in cart table or not
				Cart getProdcutDetailsFromCart = cartRepository.getProdcutDetailsFromCart(request.getUserId(),
						request.getProductId());
				if (getProdcutDetailsFromCart== null) {
					Product productInfo = productData.get();
					Cart cartEntity = new Cart();
					cartEntity.setUserId(request.getUserId());
					cartEntity.setProductId(request.getProductId());
					cartEntity.setProductQuantity(request.getQuantity());
					cartEntity.setCatlogId(productInfo.getCatlogId());
					cartEntity.setProductName(productInfo.getProductName());
					cartEntity.setProductPrice(productInfo.getProductPrice());
					cartEntity.setProductStatus("Y");// Y = Order is Done, N = Order is cancel
					cartRepository.save(cartEntity);

					// add action in cart summary tbl
					CartSummary cartSummary = new CartSummary();
					cartSummary.setUserId(request.getUserId());

					cartSummary.setProductId(productInfo.getId());
					cartSummary.setProductName(productInfo.getProductName());
					cartSummary.setProductPrice(productInfo.getProductPrice());

					cartSummary.setActioDescription(AppConstant.YOU_ADD_PRODUCT_IN_CART);
					cartSummaryRepo.save(cartSummary);
					return AppConstant.ADD_PRODUCT_SUCCESS;
				} else {
					// you have already add this product
					return AppConstant.PRODUCT_ALREADY_EXIST;
				}

			}
		} else {
			return AppConstant.PRODUCT_NOT_EXISTS;
		}
	}
	/**
	 * check product quantity in stock
	 * update cart item quantity
	 * 
	 */
	@Override
	public String updateCartQuantity(CartRequest request) {
		String status = "";
		Optional<Product> productData = productRepository.findById(request.getProductId());
		if (productData.isPresent()) {
			if (Integer.parseInt(productData.get().getProductQuantity()) > Integer.parseInt(request.getQuantity())) {
				int cartStatus = cartRepository.UpdateItemQuantityInCart(request.getUserId(), request.getProductId(),
						request.getQuantity());
				if (cartStatus == 1) {
					//add action in cart summary tbl
					CartSummary cartSummary = new CartSummary();
					cartSummary.setUserId(request.getUserId());
					
					cartSummary.setProductId(productData.get().getId());
					cartSummary.setProductName(productData.get().getProductName());
					cartSummary.setProductPrice(productData.get().getProductPrice());
					
					cartSummary.setActioDescription(AppConstant.YOU_UPDATE_ITEM_QUANTITY);
					cartSummaryRepo.save(cartSummary);
					
					status = AppConstant.CART_ITEM_QUANTITY;
				} else {
					status = AppConstant.CART_ITEM_QUANTITY_NOT;
				}
			}else {
				status = AppConstant.ITEM_QUANTITY_LESS;
			}

		} else {
			status = AppConstant.PRODUCT_NOT_EXISTS;
		}
		return status;

	}
	/**
	 * remove product from card
	 */
	@Override
	public String removeProductFromCart(CartRequest request) {
		String removeItemStatus = "N";
		// get get user product already exist in cart table or not
		Cart getProdcutDetailsFromCart = cartRepository.getProdcutDetailsFromCart(request.getUserId(),
				request.getProductId());
		if (getProdcutDetailsFromCart == null) {
			return AppConstant.PRODUCT_NOT_EXISTS;
		} else {
			int cartStatus = cartRepository.RemoveItemFromCart(request.getUserId(), request.getProductId(),
					removeItemStatus);
			if (cartStatus == 1) {
				// get product information from product table
				Optional<Product> productData = productRepository.findById(request.getProductId());
				// add action in cart summary tbl
				CartSummary cartSummary = new CartSummary();
				cartSummary.setUserId(request.getUserId());

				cartSummary.setProductId(productData.get().getId());
				cartSummary.setProductName(productData.get().getProductName());
				cartSummary.setProductPrice(productData.get().getProductPrice());

				cartSummary.setActioDescription(AppConstant.YOU_REMOVE_ITEM);
				cartSummaryRepo.save(cartSummary);

				return AppConstant.ITEM_DELETED_SUCCESS;
			} else {
				return AppConstant.ITEM_NOT_DELETED;
			}
		}
		
	}
	/**
	 * remove all item from cart related to user
	 */
	@Override
	public String ClearAllItemFromCart(CartRequest request) {
		String removeItemStatus = "N";
		// get get user product already exist in cart table or not
		List<Cart> getUserExistOrNot = cartRepository.getUserExists(request.getUserId());
		if (getUserExistOrNot.size() == 0) {
			return AppConstant.USER_NOT_EXISTS;
		} else {
			int cartStatus = cartRepository.ClearAllItemFromCart(request.getUserId(), removeItemStatus);

			if (cartStatus > 0) {
				return AppConstant.ALL_ITEM_DELETED;
			} else {
				return AppConstant.ALL_ITEM_NOT_DELETED;
			}
		}
	}
	/**
	 * get user cart summary
	 */
	@Override
	public List<CartSummary> getCartSummary(CartRequest request) {
		List<CartSummary> cartList = cartSummaryRepo.getCartSummary(request.getUserId());
		return cartList;
	}

}
