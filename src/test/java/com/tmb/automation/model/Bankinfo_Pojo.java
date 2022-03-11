package com.tmb.automation.model;

import lombok.ToString;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
@ToString
public class Bankinfo_Pojo {
	
	private String bank_cd;
	private String bank_name_th;
	private String bank_name_en;
	private String bank_shortname;
	private String bank_acct_length;
	private String bank_status;
	private String orft_effective_date;
	private String orft_expire_date;
	private String smart_effective_date;
	private String smart_expire_date;
	private int display_order;
	private String promptpay_effective_date;
	private String promptpay_expire_date;
	private String promptpay_status;
	private String bank_logo;
	public status status;
	public String data;
	
	
	@Data
	@Setter
	@Getter
	@ToString
	public static class status{
		public String code;
		public String message;
		public String service;
	    public Long description;		
	}
	
		
	
	
	}
