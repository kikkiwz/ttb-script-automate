package com.tmb.automation.test.pb1.s6107;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ResponseAccountListPOJO {
	private StatusPOJO status;
	private List<FetchAccountPOJO> data;
}
