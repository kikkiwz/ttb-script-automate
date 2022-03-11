package com.tmb.automation.model.pb1.ekyc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameTitleE {
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("descTH")
	private String descTH;
	
	@JsonProperty("descEN")
	private String descEN;
	
	@JsonProperty("gender")
	private String gender;
}
