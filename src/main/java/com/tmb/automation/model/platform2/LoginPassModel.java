package com.tmb.automation.model.platform2;

public class LoginPassModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public MongoDBLogs[] MongoDBLogs;
    public ResponseBodyData ResponseBody;
    public boolean IsSkip;

    public class TestData {
        public Body body;
        public Headers headers;
    }
    public class Body {
        public String username;
        public String password;
        public String grant_type;
        public String scope;
    }

    public class Headers {

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

    public class ResponseBodyData {
        public Status status;
        public DataList data;
    }

    public class DataList {
        public String access_token;
        public String token_type;
        public String refresh_token;
        public String expires_in;
        public String scope;
        public String channel;
        public String ssid;
        public String jti;
    }
    public class Status {
        public String code;
        public String message;
        public String service;
        public String description;
    }

}