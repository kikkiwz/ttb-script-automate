package com.ttbbank.oneapp.framework.model.customerservice.ndidEligible;

import java.util.List;

public class ndidEligibleResponse {
    public boolean ndid_acceptance;
    public List<PendingRequest> pending_request;
    public String first_name_en;
    public String last_name_en;
    public String first_name_th;
    public String last_name_th;
    public String citizen_id;
    public String mobile_no;
    public String registered_date;
    public List<RequestHistory> request_history;
}
