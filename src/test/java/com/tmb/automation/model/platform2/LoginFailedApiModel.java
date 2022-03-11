package com.tmb.automation.model.platform2;

import com.tmb.automation.api.investment.model.BaseApiModel;

public class LoginFailedApiModel extends BaseApiModel{
    public Data data;
    public class Data {
        public String error_description;
        public String error;
    }
}