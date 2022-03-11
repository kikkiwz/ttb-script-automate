package com.tmb.automation.test.pb1.s6107;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class StatusPOJO {
	 private String code;
	 private String message;
	 private String service;
	 private DescriptionPOJO description;
}
