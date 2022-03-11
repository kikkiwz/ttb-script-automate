package com.ttbbank.oneapp.scenario.primarybanking2.UITest.ManageDebitCard;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.scenario.primarybanking2.PB2Common;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManageDebitCard1Scenario extends PB2Common {

    @Test(groups = "Select_Debit_Card_Detail", dependsOnGroups = {"Select_My_DebitCard"})
    public void selectDebitCardDetail() {
        log("Select Debit Card Detail");
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        addReport("PB2 - Manage Debit Card - My Debit Card Detail");
        assertTrue(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TITLE).isDisplayed());
        assertTrue(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_IMG).isDisplayed());
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_VALUE1).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_VALUE2).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_VALUE).getAttribute("checked"), "");
//        assertTrue(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_VALUE).isSelected());
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_DESC).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKCARD).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_PAYWITHWOW).getText(), "");

        sleep(5);
    }

    @Test(groups = "PB2_ManageCard_DebitCard_Limit_Usage", dependsOnGroups = {"Select_Debit_Card_Detail"})
    public void setDebitCardLimitUsage() {
        log("Set Debit Card Limit Usage");

        //        String lbCardNumber = data.getString("config."+data.getString(dataProfile+".rm")+"."+data.getString(dataProfile+".card_number"));
        boolean isAllowforOverseasUsage = Boolean.parseBoolean(data.getString(dataProfile+".allow_for_overseas_usage"));
        boolean isAllowforPaywave = Boolean.parseBoolean(data.getString(dataProfile+".allow_for_paywave"));
        boolean isAllowforOnlineShopping = Boolean.parseBoolean(data.getString(dataProfile+".allow_for_online_shopping"));

        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        waitBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_TITLE);
        addReport("PB2 - Manage Debit Card - Debit Card - Limit Usage page");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_LB).getText(), "");
//        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE).getAttribute("value"), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_VALUE).getText(), "");

        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_LB).getText(), "");
//        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE).getAttribute("value"), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_PERMISSIONS_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB).getText(), "");

        clickToggle(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB
                , OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE, isAllowforOverseasUsage);
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB).getText(), "");

        clickToggle(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_LB
                , OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_VALUE, isAllowforPaywave);
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_LB).getText(), "");

        clickToggle(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_LB
                , OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE, isAllowforOnlineShopping);
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_LB).getText(), "");

        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE);
        int nWithdrawLimit = Integer.parseInt(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE).getAttribute("value").replaceAll(",", ""));
        if (nWithdrawLimit<=500){
            nWithdrawLimit = nWithdrawLimit+500;
        }else {
            nWithdrawLimit = nWithdrawLimit-500;
        }
        setTextBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE, String.valueOf(nWithdrawLimit));
        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_LB);

        int nSpendingLimit = Integer.parseInt(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE).getAttribute("value").replaceAll(",", ""));
        if (nSpendingLimit<=500){
            nSpendingLimit = nSpendingLimit+500;
        }else {
            nSpendingLimit = nSpendingLimit-500;
        }
        setTextBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE, String.valueOf(nSpendingLimit));
        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_LB);
        addReport("PB2 - Manage Debit Card - Debit Card - Limit Usage - Modified");
        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SAVE);

        waitBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_TITLE);
        addReport("PB2 - Manage Debit Card - Debit Card - Limit Usage - Confirmed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_TITLE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_CASHWITHDRAWLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_CASHWITHDRAWLIMIT_VALUE).getText().replaceAll(",", ""), String.valueOf(nWithdrawLimit));
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SPENDINGLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SPENDINGLIMIT_VALUE).getText().replaceAll(",", ""), String.valueOf(nSpendingLimit));
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFOROVERSEASUSAGE_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFOROVERSEASUSAGE_VALUE).getText(), isAllowforOverseasUsage?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFORPAYWAVE_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFORPAYWAVE_VALUE).getText(), isAllowforPaywave?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFORONLINESHOPPING_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_ALLOWFORONELINESHOPPING_VALUE).getText(), isAllowforOnlineShopping?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SAVE).getText(), "");

        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SAVE);
        enterConfirmPin("010203");
        waitBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_TITLE1);
        addReport("PB2 - Manage Debit Card - Debit Card - Limit Usage - Final");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_TITLE1).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_TITLE2).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_CASHWITHDRAWLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_CASHWITHDRAWLIMIT_VALUE).getText().replaceAll(",", ""), String.valueOf(nWithdrawLimit));
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_VALUE).getText().replaceAll(",", ""), String.valueOf(nSpendingLimit));
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_VALUE).getText(), isAllowforOverseasUsage?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORPAYWAVE_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORPAYWAVE_VALUE).getText(), isAllowforPaywave?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_VALUE).getText(), isAllowforOnlineShopping?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_DONE).getText(), "");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_IMG).isDisplayed()), "");
        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_DONE);
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        addReport("PB2 - Manage Debit Card - Debit Card - Limit Usage - After perform Limit Usage");
        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);

        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE).getAttribute("value").replaceAll(",", ""), String.valueOf(nWithdrawLimit));
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE).getAttribute("value").replaceAll(",", ""), String.valueOf(nSpendingLimit));
        swipeDownToUp();
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE).isSelected()?"Allowed":"Not allowed")
                , isAllowforOverseasUsage?"Allowed":"Not allowed");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_VALUE).isSelected()?"Allowed":"Not allowed")
                , isAllowforPaywave?"Allowed":"Not allowed");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE).isSelected()?"Allowed":"Not allowed")
                , isAllowforOnlineShopping?"Allowed":"Not allowed");
        sleep(5);
    }

    @Test(groups = "PB2_ManageCard_DigitalCard_Limit_Usage", dependsOnGroups = {"Select_Debit_Card_Detail"})
    public void setDigitalCardLimitUsage() {
        log("Set Digital Card Limit Usage");
        boolean isAllowforOverseasUsage = Boolean.parseBoolean(data.getString(dataProfile+".allow_for_overseas_usage"));
        boolean isAllowforOnlineShopping = Boolean.parseBoolean(data.getString(dataProfile+".allow_for_online_shopping"));

        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        waitBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_TITLE);
        addReport("PB2 - Manage Debit Card - Digital Card - Limit Usage page");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_PERMISSIONS_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB).getText(), "");

        clickToggle(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB
                , OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE, isAllowforOverseasUsage);
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB).getText(), "");
        clickToggle(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_LB
                , OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE, isAllowforOnlineShopping);
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_LB).getText(), "");
        int nSpendingLimit = Integer.parseInt(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE).getAttribute("value").replaceAll(",", ""));
        if (nSpendingLimit<=500){
            nSpendingLimit = nSpendingLimit+500;
        }else {
            nSpendingLimit = nSpendingLimit-500;
        }
        setTextBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE, String.valueOf(nSpendingLimit));
        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_LB);
        addReport("PB2 - Manage Debit Card - Digital Card - Limit Usage - Modified");
        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SAVE);

        waitBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_TITLE);
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_TITLE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_SPENDINGLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_SPENDINGLIMIT_VALUE).getText().replaceAll(",", ""), String.valueOf(nSpendingLimit));
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFOROVERSEASUSAGE_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFOROVERSEASUSAGE_VALUE).getText(), isAllowforOverseasUsage?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFORONLINESHOPPING_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_DIGITAL_ALLOWFORONELINESHOPPING_VALUE).getText(), isAllowforOnlineShopping?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SAVE).getText(), "");

        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P2_SAVE);
        enterConfirmPin("010203");
        waitBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_TITLE1);
        addReport("PB2 - Manage Debit Card - Digital Card - Limit Usage - Confirmed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_TITLE1).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_TITLE2).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_SPENDINGLIMIT_VALUE).getText().replaceAll(",", ""), String.valueOf(nSpendingLimit));
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFOROVERSEASUSAGE_VALUE).getText(), isAllowforOverseasUsage?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_ALLOWFORONLINESHOPPING_VALUE).getText(), isAllowforOnlineShopping?"Allowed":"Not allowed");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_DONE).getText(), "");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_IMG).isDisplayed()), "");
        clickBy(OneAppElementKeys.PB2W_MDC_LIMIT_P3_DONE);
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        addReport("PB2 - Manage Debit Card - Digital Card - Limit Usage - After perform Limit Usage");
        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE).getAttribute("value").replaceAll(",", ""), String.valueOf(nSpendingLimit));
        swipeDownToUp();
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE).isSelected()?"Allowed":"Not allowed")
                , isAllowforOverseasUsage?"Allowed":"Not allowed");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE).isSelected()?"Allowed":"Not allowed")
                , isAllowforOnlineShopping?"Allowed":"Not allowed");
        sleep(5);
    }

    @Test(groups = "PB2_ManageCard_DebitCard_Normal", dependsOnGroups = {"Select_My_DebitCard"})
    public void verify_DebitCard_Normal() {
        log("Verify_MyDebitCard_DebitCard_Normal");
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        waitBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_TITLE);
        addReport("PB2 - Manage Debit Card - Digital Card - Verify Normal");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE).getAttribute("value"), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_VALUE).getText(), "");

        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE).getAttribute("value"), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_PERMISSIONS_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB).getText(), "");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE).isSelected())
                , "");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_VALUE).isSelected())
                , "");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE).isSelected())
                , "");
        sleep(5);
    }



        @Test(groups = "PB2_ManageCard_DigitalCard_Blocked", dependsOnGroups = {"Select_My_DebitCard"})
    public void verify_MyDebitcard_DigitalCard_Normal() {
        log("Verify_MyDebitCard_DigitalCard_Blocked");
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        waitBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_TITLE);
        addReport("PB2 - Manage Debit Card - Digital Card - Verify Blocked");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_CURRENTLIMIT_VALUE).getAttribute("value"), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MIN_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_CASHWITHDRAW_MAX_VALUE).getText(), "");

        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_CURRENTLIMIT_VALUE).getAttribute("value"), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MIN_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_SPENDING_MAX_VALUE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_PERMISSIONS_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_LB).getText(), "");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFOROVERSEASUSAGE_VALUE).isSelected())
                , "");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORPAYWAVE_VALUE).isSelected())
                , "");
        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_LIMIT_P1_ALLOWFORONLINESHOPPING_VALUE).isSelected())
                , "");
        sleep(5);
    }

    @Test(groups = "PB2_ManageCard_DebitCard_Blocked", dependsOnGroups = {"Select_My_DebitCard"})
    public void verify_MyDebitCard_DebitCard_Blocked() {
        log("Verify_MyDebitCard_DebitCard_Blocked");

        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_TITLE);
        addReport("PB2 - Manage Debit Card - Debit Card - Verify Blocked");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_TITLE).getText(), "");
//        assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_IMAGE).isDisplayed()), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_IMAGE_NUMBER).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_BLOCKED_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_VALUE1).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_VALUE2).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKED_DESC).getText(), "");
        sleep(5);
    }

    @Test(groups = "PB2_ManageCard_DigitalCard_Normal", dependsOnGroups = {"Select_My_DebitCard"})
    public void verify_MyDebitCard_DebitCard_Normal() {
        log("Select Debit Card Detail");
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        addReport("PB2 - Manage Debit Card - Debit Card - Verify Normal");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TITLE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWDETAILS).getText(), "");
        assertTrue(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_IMG).isDisplayed());
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_VALUE1).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_ACCOUNT_VALUE2).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_LB).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_VALUE).getAttribute("checked"), "");
//        assertTrue(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_VALUE).isSelected());
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_DESC).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_BLOCKCARD).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_PAYWITHWOW).getText(), "");

        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWDETAILS);
        enterConfirmPin("010203");
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_ACCNUMBER);
        addReport("PB2 - Manage Debit Card - Debit Card - Verify Normal");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_ACCNUMBER).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_CARDEXPIRE).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_CVVNUMBER).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_HOLDERNAME).getText(), "");
        assertText(fBy(OneAppElementKeys.PB2W_MDC_DETAIL_SHOWCARD_COPYCARDNUMBER).getText(), "");
        sleep(5);
    }

/*        @Test(groups = "Verify_MyDebitCard_Temp_Block", dependsOnGroups = {"Select_My_DebitCard"})
    public void verify_MyDebitCard_Temp_Block() {
        log("Verify_MyDebitCard_Temp_Block");
        boolean isOnDebitCard = Boolean.parseBoolean(data.getString(dataProfile+".TempBlock_DebitCard"));
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);

            clickToggle(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_LB
        , OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_VALUE, isOnDebitCard);
        enterConfirmPin("010203");
        waitBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE);
        if (isOnDebitCard){
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE).getText(), "");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE).getText(), "");
            clickBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE);
            verifyStatus();
        } else {
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE).getText(), "");
            assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_IMG).isDisplayed()), "");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DESC1).getText(), "");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE).getText(), "");
            clickBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE);
            verifyStatus();
        }
        sleep(5);
    }*/

    @Test(groups = "PB2_ManageCard_Temp_Block_OnAndOff", dependsOnGroups = {"Select_My_DebitCard"})
    public void verify_MyDebitCard_Temp_Block_OnAndOff() {
        log("Verify_MyDebitCard_Temp_Block_OnAndOff");
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        addReport("PB2 - Manage Debit Card - Debit Card - Temporary Block");
        boolean isOnDebitCard = fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_VALUE).isSelected();
        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_LB);
        addReport("PB2 - Manage Debit Card - Debit Card - Temporary Block - Toggle status to ="+(!isOnDebitCard));
        enterConfirmPin("010203");
        waitBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE);
        if (!isOnDebitCard){
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE).getText(), "");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE).getText(), "");
            addReport("PB2 - Manage Debit Card - Debit Card - Temporary Block - Turn On - Done");
            clickBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE);
            verifyStatus();
        } else {
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE).getText(), "");
            assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_IMG).isDisplayed()), "");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DESC1).getText(), "");
            addReport("PB2 - Manage Debit Card - Debit Card - Temporary Block - Turn Off - Done");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE).getText(), "");
            clickBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE);
            verifyStatus();
        }
        //Round2
        waitBy(OneAppElementKeys.PB2W_MDC_DETAIL_LIMITUSAGE);
        isOnDebitCard = fBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_VALUE).isSelected();
        clickBy(OneAppElementKeys.PB2W_MDC_DETAIL_TURNONOFF_LB);
        enterConfirmPin("010203");
        waitBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE);
        if (!isOnDebitCard){
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE).getText(), "");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE).getText(), "");
            clickBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE);
            verifyStatus();
        } else {
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_TITLE).getText(), "");
            assertText(String.valueOf(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_IMG).isDisplayed()), "");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DESC1).getText(), "");
            assertText(fBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE).getText(), "");
            clickBy(OneAppElementKeys.PB2W_MDC_TEMPBLOCK_P2_DONE);
            verifyStatus();
        }
        sleep(5);
    }

    private static void verifyStatus(){
        sleep();
        waitBy(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_ACCOUNTNUMBER_LIST);
        String lbCardNumber = data.getString("config."+data.getString(dataProfile+".rm")+"."+data.getString(dataProfile+".card_number"));

        List<WebElement> cardDigitals = fsBy(OneAppElementKeys.PB2W_MDC_CARD_DIGITAL_ACCOUNTNUMBER_LIST);
        int nCount = 0;
//        log("size="+cardDigitals.size());
        for (WebElement card : cardDigitals) {
            if (card.getText().equalsIgnoreCase(lbCardNumber)){
//                log("accno="+card.getText());
                try {
                    log("accno="+fCss("#digital_card_status_text_"+nCount).getText());
                }catch (Exception e) {}
                card.click();
                return;
            }
            nCount++;
        }
        List<WebElement> cards = fsBy(OneAppElementKeys.PB2W_MDC_CARD_DEBIT_ACCOUNTNUMBER_LIST);
        nCount = 0;
//        log("size="+cards.size());
        for (WebElement card : cards) {
            if (card.getText().equalsIgnoreCase(lbCardNumber)){
//                log("accno="+card.getText());
                try {
                    log("accno="+fCss("#debit_card_status_text_"+nCount).getText());
                }catch (Exception e) {}
                 card.click();
                return;
            }
            nCount++;
        }
        if (nCount == cards.size()){
            Assert.fail(lbCardNumber + " is not found!");
        }
        sleep(5);
    }
}
