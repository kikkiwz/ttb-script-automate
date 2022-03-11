package com.tmb.automation.api.investment.model;

public class LoginModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
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
//        public String username;
//        public String password;
//        public String grant_type;
    }
}
