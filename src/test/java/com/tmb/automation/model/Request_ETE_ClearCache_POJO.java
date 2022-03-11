package com.tmb.automation.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Request_ETE_ClearCache_POJO{
	
	private String crm_id;
	private String channel_name;
	private String product_group;
	
}
