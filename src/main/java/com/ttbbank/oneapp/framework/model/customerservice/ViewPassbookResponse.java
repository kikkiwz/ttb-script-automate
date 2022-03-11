package com.ttbbank.oneapp.framework.model.customerservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewPassbookResponse {
    public boolean first_usage_experience;
    public List<MutualFundDetail2> mutual_fund_details;
    public String service_type_id;
    public List<VirtualPassbookDetail> virtual_passbook_details;
}
