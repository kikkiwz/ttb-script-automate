package com.ttbbank.oneapp.framework.model.customerservice.CST_status;

import java.util.List;

public class statusResponse {
    public List<Completed> completed;
    public boolean first_usage_experience;
    public List<InProgress> in_progress;
    public String service_type_id;
}
