package com.tmb.automation.model.platform2;

import com.tmb.automation.api.investment.model.BaseApiModel;

public class SearchActivityLogTestCasesModel extends BaseApiModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;
    public ResponseBodyData ResponseBody;

    public class TestData {
        public BodyData data;
    }

    public class BodyData {
        public String crm_id;
        public String start_date;
        public String start_time;
        public String end_date;
        public String end_time;
        public String activity_type_id;
        public int page;
    }

    public class ResponseBodyData {
        public Data data;
    }

    public class Data {
        public Status status;
        public DataList[] data;

    }

    public class Status {
        public String code;
        public String message;
        public String service;
        public String description;
    }

    public class DataList {
        public String activity_date;
        public String ip_address;
        public String activity_type;
        public String result;
        public String reason;
        public String channel;
        public String employee_id = "";
        public String activity_detail;
    }

}
