package com.tmb.automation.api.investment.model;

public class AlternativeBuyModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {
        public String crmId;
        public String fundClassNameThHub;
        public String fundCode;
        public String fundHouseCode;
        public String language;
        public String orderType;
        public String processFlag;
        public String unitHolderNo;
    }
}
