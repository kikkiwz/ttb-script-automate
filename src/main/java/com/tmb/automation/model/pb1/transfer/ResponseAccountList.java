package com.tmb.automation.model.pb1.transfer;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ResponseAccountList {
	private Status status;
	private List<FetchAccount> data;
}
