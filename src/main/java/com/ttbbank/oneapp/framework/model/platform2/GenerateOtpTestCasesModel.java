package com.ttbbank.oneapp.framework.model.platform2;


import com.tmb.automation.model.platform2.BaseApiModel;

public class GenerateOtpTestCasesModel extends BaseApiModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;
    public ResponseBodyData ResponseBody;
    public MongoDBLogs[] MongoDBLogs;

    public class TestData {
        public BodyData body;
        public HeadersData headers;
    }

    public class BodyData {
        public String custname_en;
        public String custname_th;
        public String new_email;
    }

    public class HeadersData {
        public String Device_Id;
        public String Channel;
    }

    public class ResponseBodyData {
        public Data data;
    }

    public class Data {
        public Status status;
        public DataList data;
    }

    public class Status {
        public String code;
        public String message;
        public String service;
        public Description description;
    }

    public class Description {
        public String en;
        public String th;
    }

    public class DataList {

    }

    public class MongoDBLogs {
        public String activity_type_id;
        public String activity_type;
        public String activity_status;
        public String fail_reason;
        public ActivityDescription[] activitydescription;
    }

    public class ActivityDescription {
        public String flex;
        public String description;
        public String value;
    }

}
