package com.online.ecommarce.model;

/**
 * CatlogResponse for creating response
 * @author RanjeetSi
 *
 */

public class CatlogResponse {
	private String catlogName;
	
	public CatlogResponse(String catlogName) {
		super();
		this.catlogName = catlogName;
	}
	
	public String getCatlogName() {
		return catlogName;
	}
	public void setCatlogName(String catlogName) {
		this.catlogName = catlogName;
	}

	
	
	
}
