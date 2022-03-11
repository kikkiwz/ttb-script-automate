package com.tmb.automation.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@Setter
@Getter
@ToString

public class TermsandConditionPojo {
	public new_product_term_and_condition new_product_term_and_condition;
	public current_product_term_and_condition current_product_term_and_condition;
	public List<data> data;
	public status status;
  
	    

@Data
@Setter
@Getter
@ToString

public static class new_product_term_and_condition {
	public String id;
	public String term_and_condition_id;
	public String status;
	public String  temp_status;
	public String  version;
	public String  version_display;
	public String  product_code;
	public String  channel;
	public String  product_name_en;
	public String  product_name_th;
	public String  term_and_condition_description;
	public String  create_date;
	public String  update_date;
	public Long  publish_date;
	public String  update_by;
	public String  create_by;
	public String  html_th;
	public String  html_en;
	public String  pdf_link;
	public String  sftp_path;
}

@Data
@Setter
@Getter
@ToString
public static class current_product_term_and_condition {
	public String id;
	public String term_and_condition_id;
	public String status;
	public String  temp_status;
	public String  version;
	public String  version_display;
	public String  product_code;
	public String  channel;
	public String  product_name_en;
	public String  product_name_th;
	public String  term_and_condition_description;
	public String  create_date;
	public String  update_date;
	public Long  publish_date;
	public String  update_by;
	public String  create_by;
	public String  html_th;
	public String  html_en;
	public String  pdf_link;
	public String  sftp_path;
	
}

@Data
@Setter
@Getter
@ToString
public static class data {

    public details details;
    public details_temp details_temp;
}

@Data
@Setter
@Getter
@ToString
public static class details {
	public String id;
	public String term_and_condition_id;
	public String status;
	public String  temp_status;
	public String  version;
	public String  version_display;
	public String  product_code;
	public String  channel;
	public String  product_name_en;
	public String  product_name_th;
	public String  term_and_condition_description;
	public String  create_date;
	public String  update_date;
	public String  update_by;
	public String  create_by;
	public String  html_th;
	public String  html_en;
	public String  pdf_link;
	public String  sftp_path;
	
}

@Data
@Setter
@Getter
@ToString
public static class details_temp {
	public String id;
	public String term_and_condition_id;
	public String status;
	public String  temp_status;
	public String  version;
	public String  version_display;
	public String  product_code;
	public String  channel;
	public String  product_name_en;
	public String  product_name_th;
	public String  term_and_condition_description;
	public String  create_date;
	public String  update_date;
	public String  update_by;
	public String  create_by;
	public String  html_th;
	public String  html_en;
	public String  pdf_link;
	public String  sftp_path;
	
}
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