package com.tmb.automation.model;

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
public class SaveProductInfo_editRequest {

	public String id;
	public String icon_id;
	public String ordering_value;
	public List<String> product_shortcuts;

}
