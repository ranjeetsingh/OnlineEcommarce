package com.online.ecommarce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IDataRequestValidator;
import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.iservice.ICartService;
import com.online.ecommarce.model.CartItemResponse;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.model.CartSummaryResponse;
import com.online.ecommarce.model.ProductCartItem;
import com.online.ecommarce.model.ResponseModel;

/**
 * All operations Related to Cart
 * 
 * @author RanjeetSi
 *
 */
@RestController
public class CartController {

	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IDataRequestValidator validatorService;

	/**
	 * This is a POST method to Add item in Cart tbl
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */
	@PostMapping("/addToCart")
	public ResponseEntity<Object> addProductInCart(@RequestBody CartRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// ValidatorFrameWork for Data Validation for user id
			responseEntity = validatorService.validateUser(request);
			// check responseEntity is null then add item in cart
			if (responseEntity == null) {
				String addCartStatusMessage = "";
				// fetch product details
				Optional<Product> productData = cartService.fetchProductDetails(request.getProductId());
				if (productData.isPresent()) {
					if (validatorService.checkProductOutOfStack(productData)) {
						addCartStatusMessage = AppConstant.PRODUCT_OUT_STOCK;
					} else {
						addCartStatusMessage = cartService.addToCart(request);
					}
				} else {
					addCartStatusMessage = AppConstant.PRODUCT_NOT_EXISTS;
				}
				// String addCartDataDetails = cartService.addToCart(request);
				responseEntity = new ResponseEntity<Object>(new ResponseModel(true, addCartStatusMessage, null, 0),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {

			responseEntity = new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return responseEntity;
	}

	/**
	 * This is a POST method to update order quantity in Cart tbl
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */

	@PostMapping("/updateCartItemQuantity")
	public ResponseEntity<Object> updateOrderItemQuantity(@RequestBody CartRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// ValidatorFrameWork for Data Validation for cart id
			responseEntity = validatorService.validateCartId(request);
			// check responseEntity is null then update item in cart
			if (responseEntity == null) {
				String updateCartItemStatusMessage = "";
				// fetch product details
				Optional<Product> productData = cartService.fetchProductDetails(request.getProductId());
				// check product availability
				if (productData.isPresent()) {
					updateCartItemStatusMessage = cartService.updateCartQuantity(request);
				} else {
					updateCartItemStatusMessage = AppConstant.PRODUCT_NOT_EXISTS;
				}
				// String updateCartDataDetails = cartService.updateCartQuantity(request);
				responseEntity = new ResponseEntity<Object>(
						new ResponseModel(true, updateCartItemStatusMessage, null, 0), HttpStatus.OK);
			}

		} catch (Exception e) {

			responseEntity = new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

	/**
	 * This is a POST method to remove item in Cart tbl
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */

	@PostMapping("/removeCartItem")
	public ResponseEntity<Object> removeSingleItemFromCart(@RequestBody CartRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// ValidatorFrameWork for Data Validation for cart id
			responseEntity = validatorService.validateCartId(request);
			// check responseEntity is null then remove item from cart
			if (responseEntity == null) {
				String removeItemFromCartMessage = cartService.removeProductFromCart(request);
				responseEntity = new ResponseEntity<Object>(new ResponseModel(true, removeItemFromCartMessage, null, 0),
						HttpStatus.OK);
			}

		} catch (Exception e) {

			responseEntity = new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

	/**
	 * This is a POST method to remove all item in Cart tbl
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */
	@PostMapping("/clearAllCartItem")
	public ResponseEntity<Object> removeAllItemFromCart(@RequestBody CartRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// ValidatorFrameWork for Data Validation for cart id
			responseEntity = validatorService.validateCartId(request);
			// check responseEntity is null then remove all item from cart
			if (responseEntity == null) {
				String removeAllItemFromCartMessage = cartService.removeAllItemFromCart(request);
				responseEntity = new ResponseEntity<Object>(
						new ResponseModel(true, removeAllItemFromCartMessage, null, 0), HttpStatus.OK);
			}

		} catch (Exception e) {

			responseEntity = new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

	/**
	 * This is a POST method to fetch cart summary in Cart tbl
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */

	@PostMapping("/getCartSummary")
	public ResponseEntity<Object> fetchCartSummary(@RequestBody CartRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// ValidatorFrameWork for Data Validation for cartId
			responseEntity = validatorService.validateCartId(request);
			// check responseEntity is null then fetch data from cart summary
			if (responseEntity == null) {
				List<CartSummary> getCartSummary = cartService.getCartSummary(request);
				// check the size of cart summary list
				if (getCartSummary != null && getCartSummary.size() == 0) {
					responseEntity = new ResponseEntity<Object>(
							new ResponseModel(true, AppConstant.NO_DATA_IN_CART_SUMMARY, null, 0), HttpStatus.OK);
				} else {
					responseEntity = new ResponseEntity<Object>(new ResponseModel(true,
							AppConstant.GET_CART_DATA_IN_CART_SUMMARY, new CartSummaryResponse(getCartSummary), 0),
							HttpStatus.OK);
				}
			}

		} catch (Exception e) {

			responseEntity = new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseEntity;
	}

	/**
	 * This is a POST method to fetch cart item
	 * @param CartRequest
	 * @return ResponseEntity<Object>
	 * @Exception
	 */
	@PostMapping("/fetchUserCartItem")
	public ResponseEntity<Object> fetchCartItem(@RequestBody CartRequest request) {
		ResponseEntity<Object> responseEntity = null;
		try {
			// ValidatorFrameWork for Data Validation for cartId
			responseEntity = validatorService.validateCartId(request);
			// check responseEntity is null then fetch data from cart item
			if (responseEntity == null) {
				// create product item list
				List<ProductCartItem> productCartItemList = new ArrayList<>();
				// get total product price
				double totalProductPrice = 0;
				// fetch cart item
				List<Cart> cartItemRespo = cartService.fetchUserCartItem(request);
				if (cartItemRespo != null) {
					for (Cart cartItemDetails : cartItemRespo) {
						// fetch product details
						Optional<Product> productData = cartService.fetchProductDetails(cartItemDetails.getProductId());
						// calculate total price
						totalProductPrice = totalProductPrice + cartItemDetails.getProductPrice();
						// put data in ProductCartItem model
						ProductCartItem productObj = cartItemObject(cartItemDetails, productData.get());
						// ProductCartItem productObj = new ProductCartItem(productInfo);
						productCartItemList.add(productObj);
					}
				}
				CartItemResponse cartItemResponse = new CartItemResponse(request.getCartId(), totalProductPrice,
						productCartItemList);
				// check size of item in cart list
				if (cartItemRespo != null && cartItemRespo.size() == 0) {
					responseEntity = new ResponseEntity<Object>(
							new ResponseModel(true, AppConstant.NO_ITEM_IN_CART, null, 0), HttpStatus.OK);
				} else {
					responseEntity = new ResponseEntity<Object>(
							new ResponseModel(true, AppConstant.USER_CART_ITEM_IN_LIST, cartItemResponse, 0),
							HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	/**
	 * set the productCart item in ProductCartItem Model
	 * @param cartItemDetails
	 * @param productInfo
	 * @return ProductCartItem
	 */
	private ProductCartItem cartItemObject(Cart cartItemDetails, Product productInfo) {
		ProductCartItem productObj = new ProductCartItem(cartItemDetails.getProductId(),
				productInfo.getProductName(), cartItemDetails.getProductPrice(),
				cartItemDetails.getProductOrderQuantity(), productInfo.getProductAvailability(),
				productInfo.getProductDescription());
		return productObj;
	}

}
