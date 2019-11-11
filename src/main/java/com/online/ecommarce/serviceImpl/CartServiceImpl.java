package com.online.ecommarce.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.ecommarce.apputil.AppConstant;
import com.online.ecommarce.controller.ivalidator.IServiceValidator;
import com.online.ecommarce.entity.Cart;
import com.online.ecommarce.entity.CartSummary;
import com.online.ecommarce.entity.Product;
import com.online.ecommarce.iservice.ICartService;
import com.online.ecommarce.model.CartItemRequest;
import com.online.ecommarce.model.CartRequest;
import com.online.ecommarce.model.ResponseModel;
import com.online.ecommarce.repository.CartRepository;
import com.online.ecommarce.repository.CartSummaryRepository;
import com.online.ecommarce.repository.ProductRepository;
/**
 * All operation related to cart implementation
 * @author RanjeetSi
 *
 */

@Service
@Transactional
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartSummaryRepository cartSummaryRepo;
	@Autowired
	private IServiceValidator serviceValidator;
	

	
	/**
	 * This method use to add product in cart
	 * @param CartRequest
	 * @return String
	 * @Exception
	 */
	
	@Override
	public String addToCart(CartRequest request) {
		try {
			Optional<Product> productData = productRepository.findById(request.getProductId());
			// check product is available or not
			if (productData.isPresent()) {
				if (serviceValidator.checkProductOutOfStack(productData)) {
					return AppConstant.PRODUCT_OUT_STOCK;
				} else {
					// Validation pattern for check item quantity
					if (serviceValidator.checkItemQuantity(request)) {
						Product productInfo = productData.get();
						Cart cartEntity = new Cart();
						cartEntity.setUserId(request.getUserId());
						cartEntity.setProductId(request.getProductId());
						cartEntity.setProductOrderQuantity(request.getQuantity());
						cartEntity.setProductPrice(productInfo.getProductPrice() * request.getQuantity());
						cartEntity.setCartId("cart00" + request.getUserId());
						Cart cartInfo = cartRepository.save(cartEntity);
						//Need to update product quantity in Table Product
						String cartId = cartInfo.getCartId();
						request.setCartId(cartId);
						// save user action summary
						maintainUserCartSummary(productInfo, request, AppConstant.YOU_ADD_PRODUCT_IN_CART);
						return AppConstant.ADD_PRODUCT_SUCCESS;

					} else {
						return AppConstant.ADD_ITEM_BETWEEN_ONE_TO_FIVE;
					}

				}
			} else {
				return AppConstant.PRODUCT_NOT_EXISTS;
			}
		} catch (Exception e) {
			return AppConstant.SOME_THING_WRONG;

		}
	}
	

	/**
	 * This method use to update order item quantity in cart
	 * @param CartRequest
	 * @return String
	 * @exception
	 */
	
	@Override
	public String updateCartQuantity(CartRequest request) {
		try {
			String productOrderUpdateQuantitystatus = "";
			Optional<Product> fetchProductData = productRepository.findById(request.getProductId());
			// check product availability
			if (fetchProductData.isPresent()) {
				// check product item quantity in stock
				if (fetchProductData.get().getProductQuantity() >= request.getQuantity()) {
					if (serviceValidator.checkItemQuantity(request)) {
						// update price on basis of quantity
						double updateTotalPrice = (fetchProductData.get().getProductPrice() * request.getQuantity());
						//Execute both or none
						//update product quantity in Table Cart
						int updateCartQuantityStatus = cartRepository.UpdateItemQuantityInCart(request.getProductId(),
								request.getQuantity(), request.getCartId(), updateTotalPrice);
						//Need to update product quantity in Table Product
						if (updateCartQuantityStatus == 1) {
							// save user action summary
							maintainUserCartSummary(fetchProductData.get(), request,
									AppConstant.YOU_UPDATE_ITEM_QUANTITY);
							productOrderUpdateQuantitystatus = AppConstant.CART_ITEM_QUANTITY;
						} else {
							productOrderUpdateQuantitystatus = AppConstant.CART_ITEM_QUANTITY_NOT;
						}
					} else {
						return AppConstant.ADD_ITEM_BETWEEN_ONE_TO_FIVE;
					}
				} else {
					productOrderUpdateQuantitystatus = AppConstant.ITEM_QUANTITY_LESS;
				}

			} else {
				productOrderUpdateQuantitystatus = AppConstant.PRODUCT_NOT_EXISTS;
			}
			return productOrderUpdateQuantitystatus;
		} catch (Exception e) {
			return AppConstant.SOME_THING_WRONG;

		}
	}
	
	/**
	 * This method use to remove single item from cart
	 * @param CartRequest
	 * @return String
	 * @exception
	 */
	@Override
	public String removeProductFromCart(CartRequest request) {
		try {
			//remove single item from cart
			int removeCartItemStatus = cartRepository.RemoveItemFromCart(request.getProductId(), request.getCartId());
			//Need to update product quantity in Table Product
			if (removeCartItemStatus == 1) {
				// get product information from product table
				Optional<Product> fetchProductData = productRepository.findById(request.getProductId());

				// save user action summary
				maintainUserCartSummary(fetchProductData.get(), request, AppConstant.YOU_REMOVE_ITEM);

				return AppConstant.ITEM_DELETED_SUCCESS;
			} else {
				return AppConstant.ITEM_NOT_DELETED;
			}
		} catch (Exception e) {
			return AppConstant.SOME_THING_WRONG;

		}
		
	}
	
	/**
	 * This method use to remove all item from cart
	 * @param CartRequest
	 * @return String
	 * @exception
	 */
	@Override
	public String removeAllItemFromCart(CartRequest request) {
		try {
			//remove all item from cart
			int removeAllItemFromCartStatus = cartRepository.ClearAllItemFromCart(request.getCartId());
			//Need to update product quantity in Table Product
			if (removeAllItemFromCartStatus > 0) {
				return AppConstant.ALL_ITEM_DELETED;
			} else {
				return AppConstant.ALL_ITEM_NOT_DELETED;
			}
		} catch (Exception e) {
			return AppConstant.SOME_THING_WRONG;

		}
	}
	/**
	 * This method use to get cart summary from cartSummary like add,update,remove product on basis of cartId
	 * @param CartRequest
	 * @return List<CartSummary>
	 * @exception
	 */
	@Override
	public List<CartSummary> getCartSummary(CartRequest request) {
		try {
			//fetch cart summary on the basis of the cart id
			List<CartSummary> fetchUserCartItemtList = cartSummaryRepo.getCartSummary(request.getCartId());
			return fetchUserCartItemtList;
		} catch (Exception e) {
			return null;

		}
	}
	/**
	 * This method use to get cart Item From cart when user add item in cart
	 * @param CartRequest
	 * @return List<Cart>
	 * @exception
	 */
	@Override
	public List<Cart> fetchUserCartItem(CartItemRequest request) {
		try {
			//fetch cart items
			List<Cart> fetchCartList = cartRepository.fetchCartItemByCartId(request.getCartId());
			return fetchCartList;
		} catch (Exception e) {
			return null;

		}

	}
	
	/**
	 * Maintain user cart summary
	 * @param productInfo
	 * @param request 
	 * @param userAction 
	 * @exception
	 */
	private void maintainUserCartSummary(Product productInfo, CartRequest request, String userAction) {
		try {
			// add action in cart summary tbl
			CartSummary cartSummary = new CartSummary();
			cartSummary.setProductId(productInfo.getId());
			cartSummary.setProductName(productInfo.getProductName());
			//when quantity will update then price will update and save updated price in cart summary table 
			if (userAction.equalsIgnoreCase(AppConstant.YOU_UPDATE_ITEM_QUANTITY)) {
				cartSummary.setProductPrice(productInfo.getProductPrice()*request.getQuantity());
			} else {
				cartSummary.setProductPrice(productInfo.getProductPrice());
			}
			cartSummary.setCartId(request.getCartId());

			cartSummary.setActioDescription(userAction);
			cartSummaryRepo.save(cartSummary);
		} catch (Exception e) {

		}
		
	}

	/**
	 * This method use to fetch product details from product table
	 * @param productId
	 * @return Product
	 * @exception
	 */

	@Override
	public Product fetchProductDetails(long prodcutId) {
		try {
			//fetch product details from product table
			Product productInfo = productRepository.fetchProdcutDetails(prodcutId);
			return productInfo;
		} catch (Exception e) {
			return null;
		}
		
	}

}
