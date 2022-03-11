package com.tmb.automation.api.investment.model;

public class SuitabilityAnswerModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {
        public AnswerList[] answerList;
    }

    public class AnswerList {
        public String ansCode;
        public String ansName;
    }
}