package com.tmb.automation.model.pb1.transfer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Status {
	 private String code;
	 private String message;
	 private String service;
	 private Description description;
}
