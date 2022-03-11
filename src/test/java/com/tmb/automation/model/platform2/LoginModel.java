package com.tmb.automation.model.platform2;

public class LoginModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;
    public class TestData {
        public String username;
        public String password;
        public String grant_type;

    }

}