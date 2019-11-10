package com.online.ecommarce.model;

/**
 * UserResponse for creating response
 * @author RanjeetSi
 *
 */

public class UserResponse {
	private String userEmailId;
	private String userName;
	
	
	public UserResponse(String userEmailId, String userName) {
		super();
		this.userEmailId = userEmailId;
		this.userName = userName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
