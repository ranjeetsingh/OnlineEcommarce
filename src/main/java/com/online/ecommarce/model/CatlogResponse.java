package com.online.ecommarce.model;

public class CatlogResponse {
	private String catlogId;
	private String catlogName;
	
	public CatlogResponse(String catlogId, String catlogName) {
		super();
		this.catlogId = catlogId;
		this.catlogName = catlogName;
	}
	public String getCatlogId() {
		return catlogId;
	}
	public void setCatlogId(String catlogId) {
		this.catlogId = catlogId;
	}
	public String getCatlogName() {
		return catlogName;
	}
	public void setCatlogName(String catlogName) {
		this.catlogName = catlogName;
	}

	
	
	
}
