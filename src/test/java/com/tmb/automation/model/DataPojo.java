package com.tmb.automation.model;

import java.util.HashMap;
import java.util.List;

public class DataPojo {
	
	private  String channel ;
	private String module;
	private String key;
	private  List<DeatilsPojo> details;
	public String data;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	private HashMap<String, TempPojo> details_temp;
	
	public String getChannel() {
		return channel;
	}
	public String getModule() {
		return module;
	}
	public String getKey() {
		return key;
	}
	
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public HashMap<String, TempPojo> getDetails_temp() {
		return details_temp;
	}
	public void setDetails_temp(HashMap<String, TempPojo> details_temp) {
		this.details_temp = details_temp;
	}
	public List<DeatilsPojo> getDetails() {
		return details;
	}
	public void setDetails(List<DeatilsPojo> details) {
		this.details = details;
	}
	
	
 
}
