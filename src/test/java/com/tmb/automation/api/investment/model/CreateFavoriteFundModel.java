package com.tmb.automation.api.investment.model;

public class CreateFavoriteFundModel {
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
