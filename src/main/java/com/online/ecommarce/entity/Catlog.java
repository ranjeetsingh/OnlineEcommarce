package com.online.ecommarce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Create Catlog table
 * @author RanjeetSi
 *
 */
@Entity
public class Catlog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String catlogId;
	private String catlogName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
