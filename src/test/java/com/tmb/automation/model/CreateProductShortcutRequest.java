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
public class CreateProductShortcutRequest {

	public String id;
	public String url;	
    public String name_en;
    public String name_th;
    public String description;
    public String updated_by;
}
