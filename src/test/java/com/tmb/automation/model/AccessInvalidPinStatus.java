package com.tmb.automation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AccessInvalidPinStatus {
	
	private String code;
	 private String message;
	 private String service;
	 DescriptionAccessInvalidPin description;

}
