package com.tmb.automation.model.Autolaon;

import com.tmb.automation.api.investment.model.BaseApiModel;

public class GetToken extends BaseApiModel {
    public Data data;
    public class Data{
        public String access_token;
    }
}

