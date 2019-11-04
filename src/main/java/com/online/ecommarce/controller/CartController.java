package com.online.ecommarce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.iservice.iCart;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.model.CartSummaryResponse;
import com.online.ecommarce.model.ResponseModel;
/**
 * Action Related Cart 
 * @author RanjeetSi
 *
 */
@RestController
public class CartController {

	@Autowired
	private iCart icart;

	/**
	 * add item in Cart tbl
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/addToCart")
	public ResponseEntity<Object> addToCart(@RequestBody CartRequest request) {
		try {
			if (request.getUserId() == null || request.getUserId() == "") {
				return new ResponseEntity<Object>(
						new ResponseModel(true, AppConstant.PLEASE_SEND_USER_ID_AND_PRODUCT_ID, null, 1),
						HttpStatus.NOT_FOUND);
			} else {

				String addCartInfo = icart.addToCart(request);

				return new ResponseEntity<Object>(
						new ResponseModel(true, addCartInfo, null, 0),
						HttpStatus.CREATED);
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	/**
	 * update cart item
	 * @param request
	 * @return
	 */
	@PostMapping("/updateCartItemQuantity")
	public ResponseEntity<Object> updateCartItemQuantity(@RequestBody CartRequest request) {
		try {
			if (request.getUserId() == null || request.getUserId() == "") {
				return new ResponseEntity<Object>(
						new ResponseModel(true, AppConstant.PLEASE_SEND_USER_ID_AND_PRODUCT_ID, null, 1),
						HttpStatus.NOT_FOUND);
			} else {
				String updateCartInfo = icart.updateCartQuantity(request);
				return new ResponseEntity<Object>(
						new ResponseModel(true, updateCartInfo, null, 0),
						HttpStatus.OK);
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	/**
	 * remove cart item
	 * @param request
	 * @return
	 */
	@PostMapping("/removeCartItem")
	public ResponseEntity<Object> removeCartItem(@RequestBody CartRequest request) {
		try {
			if (request.getUserId() == null || request.getUserId() == "") {
				return new ResponseEntity<Object>(
						new ResponseModel(true, AppConstant.PLEASE_SEND_USER_ID_AND_PRODUCT_ID, null, 1),
						HttpStatus.NOT_FOUND);
			} else {
				String deleteCartInfo = icart.removeProductFromCart(request);
				return new ResponseEntity<Object>(
						new ResponseModel(true, deleteCartInfo, null, 0),
						HttpStatus.OK);
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	/**
	 * Clear all item from cart
	 * @param request
	 * @return
	 */
	@PostMapping("/clearCartItem")
	public ResponseEntity<Object> ClearCartItem(@RequestBody CartRequest request) {
		try {
			if (request.getUserId() == null || request.getUserId() == "") {
				return new ResponseEntity<Object>(
						new ResponseModel(true, AppConstant.PLEASE_SEND_USER_ID_AND_PRODUCT_ID, null, 1),
						HttpStatus.NOT_FOUND);
			} else {
				String clearAllInfo = icart.ClearAllItemFromCart(request);
				return new ResponseEntity<Object>(
						new ResponseModel(true, clearAllInfo, null, 0),
						HttpStatus.OK);
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	/**
	 * get cart summary list
	 * @param request
	 * @return
	 */
	@PostMapping("/getCartSummary")
	public ResponseEntity<Object> getCartSummary(@RequestBody CartRequest request) {
		try {
			if (request.getUserId() == null || request.getUserId() == "") {
				return new ResponseEntity<Object>(
						new ResponseModel(true, AppConstant.PLEASE_SEND_USER_ID_AND_PRODUCT_ID, null, 1),
						HttpStatus.NOT_FOUND);
			} else {
				List<CartSummary> getCartSummary = icart.getCartSummary(request);
				if(getCartSummary.size() == 0) {
					return new ResponseEntity<Object>(
							new ResponseModel(true,AppConstant.NO_DATA_IN_CART_SUMMARY , null, 0),
							HttpStatus.OK);
				}else {
				return new ResponseEntity<Object>(
						new ResponseModel(true, AppConstant.GET_USER_DATA_IN_CART_SUMMARY, new CartSummaryResponse(getCartSummary), 0),
						HttpStatus.OK);//Need to update status code
				}
			}

		} catch (Exception e) {

			return new ResponseEntity<Object>(new ResponseModel(false, e.getMessage(), null, 0),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
}
