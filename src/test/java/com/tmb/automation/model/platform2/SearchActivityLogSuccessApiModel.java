package com.tmb.automation.model.platform2;

import com.tmb.automation.api.investment.model.BaseApiModel;

public class SearchActivityLogSuccessApiModel extends BaseApiModel {
    public Data[] data;

    public class Data {
        public String activity_date;
        public String ip_address;
        public String activity_type;
        public String result;
        public String reason;
        public String channel;
        public String employee_id;
        public String activity_detail;
    }
}
