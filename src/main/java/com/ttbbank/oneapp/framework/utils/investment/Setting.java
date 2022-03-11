package com.ttbbank.oneapp.framework.utils.investment;

import com.aventstack.extentreports.ExtentTest;
import com.ttbbank.oneapp.framework.model.investment.FundListModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Setting {

    private Date date = new Date();

    public String imageFileName() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName = formatter.format(date);
        return fileName;

    }

    public enum TRANSACTION_TYPE{
        ALL,
        BUY,
        SELL,
        SWITCH,
        DCA,
        DIVIDEND,
        AUTO_REDEMPTION
    }
    public enum FUND_TYPE{
        ALL,
        MUTUAL_FUND,
        TTB_SMART_PORT
    }

    public enum TRANSACTION_STATUS {
        COMPLETED,
        PROCESSING,
        CANCELED
    }


    public enum CATEGORY{
        TYPE_OF_FUND,
        ASSET_CLASS,
        FUND_HOUSE,
        CUSTOM

    }


    public enum TYPE_OF_FUND {
        REGULAR_MUTUAL_FUND,
        TRIGGER_FUND,
        TERM_FUND,
        LONG_TERM_EQUITY_FUND,
        RETIREMENT_MUTUAL_FUND,
        ROLLOVER_FUND
    }

    public enum ASSET_CLASS {
        TTB_SMART_PORT,
        FIXED_INCOME,
        FIF_FIXED_INCOME,
        BALANCE,
        EQUITY,
        FIF_EQUITY,
        OTHER,
        SUPER_SAVINGS_FUND,
        RETIREMENT_MUTUAL_FUND,
        FIF_BALANCE
    }

    public enum FUND_HOUSE {
        TMBAM,
        TFUND,
        TISCOASSET,
        UOBAMTH,
        PRINCIPAL,
        ABERDEEN,
        KWIAM,
        ONEAM,
        KASSET,
        KTAM,
        KSAM
    }

    public enum CUSTOM {
        CHINA,
        EU,
        JAPAN,
        THAILAND,
        USA

    }

    public enum DURATION {
        ONE_DAY,
        ONE_MONTH,
        THREE_MONTH,
        SIX_MONTH,
        YTD,
        ONE_YEAR,
        THREE_YEAR,
        FIVE_YEAR,
        ALL
    }

    public enum FUND_FLAG {
        ALL,
        BOUGHT,
        RECOMMENDED,
        WATCHLIST,
        IPO,
        TTB_SMART_PORT

    }
}
