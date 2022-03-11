package com.tmb.automation.api.investment.model;

public class PortfolioModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;

    public class TestData {
        public String jointType;
        public OccupationRequest occupationRequest;

        public class OccupationRequest {
            public String occupationCode;
            public String positionDescription;
        }

        public String portfolioNickName;
        public String portfolioType;
        public String preferredAddressType;
        public String preferredRedemptionAccountCode;
        public String preferredRedemptionAccountName;
        public String preferredSubscriptionAccountCode;
        public String preferredSubscriptionAccountName;
        public String purposeTypeCode;
        public String registeredForVat;
        public String status;
        public String suitabilityScore;
        public String vatEstablishmentBranchCode;
        public String withHoldingTaxPreference;

    }

}