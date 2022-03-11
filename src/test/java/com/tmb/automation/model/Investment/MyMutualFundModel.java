package com.tmb.automation.model.Investment;

public class MyMutualFundModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {
        public String fundCode;
    }
}
