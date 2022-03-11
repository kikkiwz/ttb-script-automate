package com.tmb.automation.model.Investment;

public class FundSummaryModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {
        public String Fund_Name;
        public String Fund_Full_Name_EN;
        public String Fund_Full_Name_TH;
        public String Transaction_Type;
        public String Portfolio;
    }
}
