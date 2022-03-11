package com.tmb.automation.api.investment.model;

public class PastPerformanceModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {
        public String getFlag;
        public String smartPortFlag;
    }
}
