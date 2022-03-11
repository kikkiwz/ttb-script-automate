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

public class PhrasesPojo {
		public status status;
	    public data data;
        public current_phrase current_phrase;
	    public update_phrase update_phrase;
	    
	    
	    
	    
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
	    public static class data{
	    	public List<phrases> phrases;
	    	public String draft_count;
		    public String page_count;
		    public List<details> details;
	    }
	    
	    @Data
	    @Setter
	    @Getter
	    @ToString
	   
	    
	    public static class details {
			
			public String id;
			public String en;
			public String th;
			public String phrase_key;
		    public Long last_updated_time;
		    public Long created_time;
		    public String updated_by;
		    public String module_key;
		    public String module_name;
		    public String status;
		    public Long schedule_time;
		    public String temp_status;
		    
		  		
		}
	    
	    
	    
	    
	    
	    
	    @Data
	    @Setter
	    @Getter
	    @ToString
	    
	public static class phrases {
		
		public String id;
		public String en;
		public String th;
		public String phrase_key;
	    public Long last_updated_time;
	    public Long created_time;
	    public String updated_by;
	    public String module_key;
	    public String module_name;
	    public String status;
	    public Long schedule_time;
	    public String temp_status;
	    
	  		
	}
	    @Data
	    @Setter
	    @Getter
	    @ToString
public static class current_phrase {
		
		public String id;
		public String en;
		public String th;
		public String phrase_key;
	    public Long last_updated_time;
	    public Long created_time;
	    public String updated_by;
	    public String module_key;
	    public String module_name;
	    public String status;
	    public Long schedule_time;
	    public String temp_status;
	    
}
	    @Data
	    @Setter
	    @Getter
	    @ToString
public static class update_phrase {
	
	public String id;
	public String en;
	public String th;
	public String phrase_key;
    public Long last_updated_time;
    public Long created_time;
    public String updated_by;
    public String module_key;
    public String module_name;
    public String status;
    public Long schedule_time;
    public String temp_status;
    
}
	    
	    
	}


