package com.rohit.questionaire.model;

public class TinyUrl {

	private String id;
	private String tinyUrl;
	
	public TinyUrl(String id, String tinyUrl) {
		this.id = id;
		this.tinyUrl = tinyUrl;
	}
	public String getId() {
		return id;
	}
	
	public String getTinyUrl() {
		return tinyUrl;
	}
	public void setTinyUrl(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}
}
