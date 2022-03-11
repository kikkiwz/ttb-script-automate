package com.ttbbank.oneapp.framework.model.customerservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MutualFundDetail {
    public String fund_code;
    public String fund_name_en;
    public String fund_name_th;
}
