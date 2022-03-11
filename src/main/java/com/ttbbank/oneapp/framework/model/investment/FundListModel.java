package com.ttbbank.oneapp.framework.model.investment;

public class FundListModel {
    public String[] ExpectedResult;
    public String Description;
    public String ScenarioName;
    public String[] ExpectedResultKey;
    public TestData TestData;
    public boolean IsSkip;
    public ResponseData ResponseData;
    public Data[] data;

    public class TestData {
    }

    public class ResponseData {
        public Data[] data;
    }

    public class Data {
        public String allotType;
        public String allowAipFlag;
        public String boughtFlag;
        public String customTag;
        public String dateAfterIpo;
        public String followingFlag;
        public String fundCode;
        public String fundHouseCode;
        public String fundNameEn;
        public String fundNameTh;
        public String fundShortName;
        public String fundTypeGroup;
        public String fundTypeL1;
        public String fundTypeL2;
        public String fundclassCode;
        public String fundclassCodeHub;
        public String fundclassNameEnHub;
        public String fundclassNameThHub;
        public String fxRisk;
        public String inceptionDate;
        public String inceptionSinceReturn;
        public String ipoDateFrom;
        public String ipoDateTo;
        public String ipoFlag;
        public String nav;
        public String navAsOfDate;
        public String recommendFlag;
        public String reserved1;
        public String reserved2;
        public String reserved3;
        public String reserved4;
        public String reserved5;
        public String return1Day;
        public String return1Month;
        public String return1Year;
        public String return3Month;
        public String return3Year;
        public String return5Year;
        public String return6Month;
        public String returnYTD;
        public String riskRate;
        public String secid;
        public String smartPortFlag;
        public String termfundFlag;
    }
}
