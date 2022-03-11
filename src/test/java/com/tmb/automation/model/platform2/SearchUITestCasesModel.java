package com.tmb.automation.model.platform2;

public class SearchUITestCasesModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public String[] ExpectedResultKeyList;
    public TestData TestData;

    public class TestData {
        public String search_type;
        public String search_value;
        public String search_value1 = "";
    }
}