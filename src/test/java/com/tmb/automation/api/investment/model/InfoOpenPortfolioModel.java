package com.tmb.automation.api.investment.model;

public class InfoOpenPortfolioModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {
        public String amloFlag;
        public String branchCode;
        public String crmId;
        public String customerEnglishName;
        public String customerThaiName;
        public String dateOfBirth;
        public String emailAddress;
        public String existingCustomer;
        public String kycFlag;
        public String lastDateSync;
        public String makerCode;
        public String maritalStatus;
        public String nationalDocumentExpireDate;
        public String nationalDocumentId;
        public String nationalDocumentIdentificationType;
        public String nationality;
        public String nationalitySecond;
        public String phoneNumber;
        public String residentGeoCode;
        public String taxNumber;
        public String wealthCrmId;
    }

}

