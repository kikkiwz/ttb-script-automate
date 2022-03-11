package com.tmb.automation.model.pb1.ekyc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VerifyMethodE {
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("channel")
	private String channel;
	
	@JsonProperty("descTH")
	private String descTH;
	
	@JsonProperty("descEN")
	private String descEN;
}
