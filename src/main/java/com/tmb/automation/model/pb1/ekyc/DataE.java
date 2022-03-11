package com.tmb.automation.model.pb1.ekyc;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class DataE {
	private String id;
	
	@JsonProperty("face_detect")
	private FaceDetectE faceDetect;
	
	@JsonProperty("min_age")
	private String minAge;
	
	@JsonProperty("name_title")
	private List<NameTitleE> nameTitle = null;
	
	@JsonProperty("verify_method")
	private List<VerifyMethodE> verifyMethod = null;

	private String ndid_request_timeout;
	private String prospect_expiry_days;
}


