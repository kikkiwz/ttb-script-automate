package com.tmb.automation.api.investment.model;

public class FundListModel extends BaseApiModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;
    public Data[] data;
    public ResponseData ResponseData;

    public class TestData {

        public String[] unitHolderNo;
    }

    public class ResponseData {
        public Data[] data;
    }

    public class Data {
        public String fundHouseCode;
        public String fundCode;
        public String fundShortName;
        public String fundNameEn;
        public String fundNameTh;
        public String riskRate;
        public String allotType;
        public String fundTypeL1;
        public String fundTypeL2;
        public String reserved1;
        public String reserved2;
        public String reserved3;
        public String reserved4;
        public String reserved5;
        public String fxRisk;
        public String allowAipFlag;
        public String ipoDateFrom;
        public String ipoDateTo;
        public String dateAfterIpo;
        public String ipoFlag;
        public String inceptionDate;
        public String return1Day;
        public String return1Month;
        public String return3Month;
        public String return6Month;
        public String returnYTD;
        public String return1Year;
        public String return3Year;
        public String return5Year;
        public String inceptionSinceReturn;
        public String smartPortFlag;
        public String recommendFlag;
        public String followingFlag;
        public String boughtFlag;
        public String navAsOfDate;
        public String nav;
        public String fundTypeGroup;
        public String customTag;
        public String fundclassCode;
        public String secid;
        public String fundclassCodeHub;
        public String fundclassNameEnHub;
        public String fundclassNameThHub;
        public String termfundFlag;
    }
}


