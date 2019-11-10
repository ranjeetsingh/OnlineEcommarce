
package com.online.ecommarce.apputil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * Define global constant of application
 * @author RanjeetSi
 *
 */
public class AppConstant {
	
	public static final Contact DEFAULT_CONTACT = new Contact(
			"Ranjeet Singh", 
			"http://www.hcl.com",
			"ranjeetsi@hcl.com");
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Online Ecommarce API",
			"OnLine Ecommarce API.", "1.0", "urn:tos", DEFAULT_CONTACT, "online Ecommarce 1.0",
			"http://www.hcl.com");

	public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));  
	
	public static final String USER_REGISTRATION_SUCCESSFULLY = "User registration successful";
	public static final String USER_ID_AND_USERNAME = "You user id and email can not blank.";
	public static final String CAT_LOG_CAN_NOT_EMPTY = "Catlog Item can not empty.";
	public static final String CAT_LOG_ADD_SUCCESS = "Catlog item add successfully";
	public static final String PRODUCT_DATA_CAN_NOT_EMPTY = "Product Name and Description can not empty";
	public static final String ADD_PRODUCT_SUCCESS = "Add product successfully";
	public static final String PRODUCT_OUT_STOCK = "Product is out of stock";
	public static final String PRODUCT_ADD_SUCCESS = "Product add successfully";
	public static final String  PLEASE_SEND_USER_ID="Please send user Id";
	public static final String PRODUCT_NOT_EXISTS = "Product not exists";
	public static final String NO_DATA_IN_CART_SUMMARY= "No data in cart summary";
	public static final String GET_CART_DATA_IN_CART_SUMMARY= "Get Cart summary data";
	public static final String ALL_ITEM_DELETED= "All Item deleted successfull";;
	public static final String ALL_ITEM_NOT_DELETED = "All Item not deleted successfull";
	public static final String ITEM_DELETED_SUCCESS = "Item deleted successfull";
	public static final String ITEM_NOT_DELETED = "Item not deleted successfull";
	public static final String  YOU_REMOVE_ITEM= "You remove item from cart";
	public static final String CART_ITEM_QUANTITY = "Cart item quantity update successfully";
	public static final String CART_ITEM_QUANTITY_NOT = "Cart item quantity not update";
	public static final String ITEM_QUANTITY_LESS= "Item quantity less in stock";
	public static final String YOU_UPDATE_ITEM_QUANTITY= "You update item quantity in cart";
	public static final String  YOU_ADD_PRODUCT_IN_CART= "You add product in cart";
	public static final String USER_ID_CAN_NOT_NULL = "User id and Name cant not be null.";
	public static final String PRODUCT_ALREADY_EXIST= "Product already exists.Please add other produt in cart.";
	public static final String USER_NOT_EXISTS = "User not exists.";
	public static final String PLEASE_ENTER_CART_ID="Please enter cart id";
	public static final String SOME_THING_WRONG ="Some thing wrong please check it.";
	
	
	


}
