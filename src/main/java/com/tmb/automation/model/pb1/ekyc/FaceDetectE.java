package com.tmb.automation.model.pb1.ekyc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaceDetectE {
	@JsonProperty("motionType")
	
	private List<String> motionType = null;
	@JsonProperty("actionDelay")
	
	private String actionDelay;
	@JsonProperty("timeout")
	
	private String timeout;
	@JsonProperty("instructDelay")
	
	private String instructDelay;
	@JsonProperty("minWidth")
	
	private String minWidth;
	@JsonProperty("minHeigth")
	
	private String minHeigth;
}
