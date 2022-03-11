package com.tmb.automation.model;

import java.util.List;

import com.tmb.automation.model.TermsandConditionPojo.current_product_term_and_condition;
import com.tmb.automation.model.TermsandConditionPojo.data;
import com.tmb.automation.model.TermsandConditionPojo.new_product_term_and_condition;
import com.tmb.automation.model.TermsandConditionPojo.status;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class ResponsePojoKYC_Review {
	

	private StatusKyc status;
	private dataKyc data;
	private String state;
	private String ref_id;
	private String module;
	private String pin;
	


@Data
@Setter
@Getter
@ToString

public class StatusKyc{
	
	private String code;
	private String message;
	private String service;
	private String description;
	
}
@Data
@Setter
@Getter
@ToString

public class dataKyc{
	
	private String jwt_token;
	private String kyc_web_url;
	private String ref_id;
	
}


}
