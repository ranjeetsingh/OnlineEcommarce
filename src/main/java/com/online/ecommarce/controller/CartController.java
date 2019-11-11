package com.online.ecommarce.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.online.ecommarce.model.CartItemRequest;
import com.online.ecommarce.model.CartItemResponse;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.model.CartSummaryResponse;
import com.online.ecommarce.model.TestProductCartItem;
import com.online.ecommarce.model.ProductCartItem;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.repository.ProductRepository;

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
			// Validation pattern for Data Validation for user id
			responseEntity = validatorService.validateUser(request);
			// check responseEntity is null then add item in cart
			if (responseEntity == null) {
				String addCartDataDetails = cartService.addToCart(request);
				responseEntity = new ResponseEntity<Object>(new ResponseModel(true, addCartDataDetails, null, 0),
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
			// Validation pattern for Data Validation for cart id
			responseEntity = validatorService.validateCartId(request);
			// check responseEntity is null then update item in cart
			if (responseEntity == null) {
				String updateCartDataDetails = cartService.updateCartQuantity(request);
				responseEntity = new ResponseEntity<Object>(new ResponseModel(true, updateCartDataDetails, null, 0),
						HttpStatus.OK);
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
			// Validation pattern for Data Validation for cart id
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
			// Validation pattern for Data Validation for cart id
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
			// Validation pattern for Data Validation for cartId
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
	public ResponseEntity<Object> fetchCartItem(@RequestBody CartItemRequest request) {

		// create product item list
		List<ProductCartItem> productCartItemList = new ArrayList<>();
		// get total product price
		double totalProductPrice = 0;

		// fetch cart item
		List<Cart> cartItemRespo = cartService.fetchUserCartItem(request);
		for (Cart cartItemDetails : cartItemRespo) {
			//fetch product details
			Product productInfo = cartService.fetchProductDetails(cartItemDetails.getProductId());
			totalProductPrice = totalProductPrice + cartItemDetails.getProductPrice();
			ProductCartItem productObj = new ProductCartItem(cartItemDetails.getProductId(),
					productInfo.getProductName(), cartItemDetails.getProductPrice(),
					cartItemDetails.getProductOrderQuantity(), productInfo.getProductAvailability(),
					productInfo.getProductDescription());

			ProductCartItem productInfoData = new ProductCartItem(productObj);
			productCartItemList.add(productInfoData);

		}

		CartItemResponse cartItemResponse = new CartItemResponse(request.getCartId(), totalProductPrice,
				productCartItemList);

		// check size of item in cart list
		if (cartItemRespo.size() == 0) {
			return new ResponseEntity<Object>(new ResponseModel(true, "No item in your cart.", null, 0), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new ResponseModel(true, "User Cart Item List", cartItemResponse, 0),
					HttpStatus.OK);
		}
	}

}
