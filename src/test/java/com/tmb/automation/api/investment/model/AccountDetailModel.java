package com.tmb.automation.api.investment.model;

public class AccountDetailModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;
    public class TestData {
        public String fundCode;
        public String fundHouseCode;
        public String serviceType;
        public String tranType;
        public String portfolioNumber;
    }
}
