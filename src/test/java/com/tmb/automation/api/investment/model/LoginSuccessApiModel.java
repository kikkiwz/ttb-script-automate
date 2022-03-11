package com.tmb.automation.api.investment.model;

public class LoginSuccessApiModel extends BaseApiModel{
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
