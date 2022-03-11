package com.tmb.automation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class AccessPinStatusPojo {
	
	
	private String code;
	 private String message;
	 private String service;
	 private String description = null;

}
