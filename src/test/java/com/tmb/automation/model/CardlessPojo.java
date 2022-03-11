package com.tmb.automation.model;

import lombok.ToString;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
@ToString
public class CardlessPojo {
	
	private String account_number;
	private String account_name;
	private String customer_name;
	private String account_type;
	private String mobile_number;
	private String transaction_date;
	private String transaction_type;
	private String amount;
	private String language;
	private String channel_id;
	private String timestamp;
	public status status;
	public data data;
	public uvAccessCodeKeys uvAccessCodeKeys;
	public String statusCode;
	public String statusDesc;
	public uvAccessCodeInfo uvAccessCodeInfo;
	public uvAddlogsKeys uvAddlogsKeys;
	public uvAddlogsInfo uvAddlogsInfo;
	
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
	
	@Data
	@Setter
	@Getter
	@ToString
	public static class uvAddlogsInfo{
		public String responseCode;
	}
	
	@Data
	@Setter
	@Getter
	@ToString
	public static class uvAccessCodeKeys{
		public String mode;
		public String accessCode;
		public String mobileNumber;
	    public String terminalId;
	    public String transactionId;
	    public String terminalLocation;
		public String tranDate;
		public String tranType;
	    public String channelId;
	}
	
	@Data
	@Setter
	@Getter
	@ToString
	public static class uvAddlogsKeys{
		public String mode;
		public String accessCode;
		public String amount;
		public String mobileNumber;
	    public String terminalId;
	    public String transactionId;
	    public String terminalLocation;
		public String tranDate;
		public String tranType;
	    public String channelId;
	    public String tranStatus;
	    public String responseCode;
	}
	
	@Data
	@Setter
	@Getter
	@ToString
	public static class uvAccessCodeInfo{
		    public String accountNumber;
			public String accountType;
			public String amount;
		    public String approvalCode;
		    public String approvalDesc;
		
	}
	
	@Data
	@Setter
	@Getter
	@ToString
	public static class data {

		private String account_number;
		private String account_name;
		private String customer_name;
		private String amount;
		private String account_type;
		private String generate_date;
		private String expire_date;
		private String access_code;
	}
	
	}
