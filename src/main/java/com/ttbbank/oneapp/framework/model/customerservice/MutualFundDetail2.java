package com.ttbbank.oneapp.framework.model.customerservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MutualFundDetail2 {
    public String account_nickname;
    public List<MutualFundDetail> mutual_fund_details;
    public String portfolio_number;
    public String type;
}
