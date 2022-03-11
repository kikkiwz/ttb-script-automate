package com.tmb.automation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class AccesspinResponseInavlidPin {
	
	private AccessInvalidPinStatus Status;
	 private String data ;
 

}
