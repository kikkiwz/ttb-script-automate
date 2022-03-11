package com.tmb.automation.api.investment.model;

public class AIPOrderModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {
        public String orderType;
        public String fundHouseCode;
        public String fundCode;
        public String portfolioNumber;
        public String orderAmount;
        public String orderDateTime;
        public String transferBank;
        public String transferBranch;
        public String bankAccountType;
        public String bankAccountNumber;
        public String bankAccountId;
        public String aipStartDate;
        public String aipEndDate;
        public String frequency;
        public String weekDay;
        public String dayOfMonth;
        public String quarterSchedule;
        public String investmentDate;
        public String creditCardExpiry;
        public String paymentReference;
    }


}
