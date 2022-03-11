package com.tmb.automation.model.platform2;

public class BaseFailedApiModel {
    public Status status;
    public String data;

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
}
