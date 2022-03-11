package com.ttbbank.oneapp.framework.model.customerservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VirtualPassbookDetail {
    public String account_name;
    public String account_nick_name;
    public String account_number;
    public String branch_name_en;
    public String branch_name_th;
    public String product_name_en;
    public String product_name_th;
    public String type;
}
