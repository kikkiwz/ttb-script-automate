package com.tmb.automation.model;


import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@Setter
@Getter
@ToString

public class Customer_Notification_Settings_Inbox_Pojo {
	private status status;
	private String data;
	private List<String> ids;
	private List<String> message_subject;
	
	@Data
	@Setter
	@Getter
	@ToString
	
	public class status
	{
		
			private String code;
			private String message;
			private String service;
			private String description;
			
		}
	}
