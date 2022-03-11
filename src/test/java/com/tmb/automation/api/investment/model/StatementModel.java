package com.tmb.automation.api.investment.model;

public class StatementModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {

        public String statementType;
        public String fundCode;
        public String fundType;
        public String tranType;
        public String rowStart;
        public String rowEnd;
    }
}
//"fundCode": "ABCC",
//        "fundType": "1",
//        "rmId": "00000000028365",
//        "rowEnd": "20",
//        "rowStart": "1",
//        "statementType": "1",
//        "tranType": "0"