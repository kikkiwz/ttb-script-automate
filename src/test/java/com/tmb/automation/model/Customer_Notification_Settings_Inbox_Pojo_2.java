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

public class Customer_Notification_Settings_Inbox_Pojo_2 {
	
	private status status;
	private data data;
	public String flow;
	public Boolean app_level_push_notification_enabled;
	public Boolean news_notification_enabled;
	public settings settings;
	public updated_settings updated_settings;
	
	@Data
	@Setter
	@Getter
	@ToString
	
	public static class settings{
		public String flow;
		public Boolean app_level_notification;
		public Boolean login_notification;
		public Boolean transaction_notification;
	}
	@Data
	@Setter
	@Getter
	@ToString
	public static class updated_settings{
		public String flow;
		public Boolean app_level_notification;
		public Boolean login_notification;
		public Boolean transaction_notification;
	}
	
	
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
	@Data
	@Setter
	@Getter
	@ToString
	
	public class data
	{
		
			private Boolean app_level_notification;
			private Boolean login_notification;
			private Boolean transaction_notification;
			private Boolean news_notification_enabled;
			private Boolean app_level_push_notification_enabled;
			private String login_notification_date;
			private String transaction_notification_date;

			
		}
	}
