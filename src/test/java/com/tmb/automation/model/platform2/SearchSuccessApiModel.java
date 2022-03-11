package com.tmb.automation.model.platform2;

import com.tmb.automation.api.investment.model.BaseApiModel;

public class SearchSuccessApiModel extends BaseApiModel{
    public Data data;
    public class Data {
        public String access_token;
        public String token_type;
        public String refresh_token;
        public int expires_in;
        public String scope;
        public String Mobile;
        public String current_login_time;
//        public String[] rbackdata;
        public String role_name;
        public String authority;
        public String jti;
    }

}
