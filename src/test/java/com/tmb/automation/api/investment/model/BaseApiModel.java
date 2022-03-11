package com.tmb.automation.api.investment.model;

public class BaseApiModel {
    public Status status;

    public class Status {
        public String code;
        public String message;
        public String service;
        public String description;
    }
}