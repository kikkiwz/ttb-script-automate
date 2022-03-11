package com.tmb.automation.model.pb1.ekyc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tmb.automation.model.pb1.transfer.Status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EKYCModule {
	
	@JsonProperty("status")
	private Status status;
	
	@JsonProperty("data")
	private List<DataE> data = null;

}