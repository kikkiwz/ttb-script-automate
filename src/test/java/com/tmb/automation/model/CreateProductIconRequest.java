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
public class CreateProductIconRequest {

	public String icon_id;
    public String icon_name_en;
    public String icon_name_th;
    public String description;
    public String icon;
    public int last_updated_time;
    public String status;
    public String updated_by;
}
