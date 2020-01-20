package com.boot.myspringbootdata.model;

public class ExceptionModel {
	private String message;
	private String url;
	
	public ExceptionModel() {
		
	}
	
	public ExceptionModel(String message, String url) {
		this.message = message;
		this.url = url;
	}

	public String getMessage() {
		return message;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
}
