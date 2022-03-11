package com.tmb.automation.model;

public class StatusPojo {
	
	private String code;
	private String message;
	private String service;
	private String description;
	private String current_phrase;
	private String update_phrase;
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getService() {
		return service;
	}
	public String getDescription() {
		return description;
	}
	
	public String getCurrent_phrase() {
		return current_phrase;
	}
	public String getUpdate_phrase() {
		return update_phrase;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCurrent_phrase(String current_phrase) {
		this.current_phrase = current_phrase;
	}
	public void setUpdate_phrase(String update_phrase) {
		this.update_phrase = update_phrase;
	}
}
