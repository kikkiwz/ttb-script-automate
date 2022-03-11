package com.tmb.automation.test.lending.sprint18;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.AccountSummaryPage;
import com.tmb.automation.pages.lending.ChangeUsageLimitPage;
import com.tmb.automation.test.lending.sprint15.LendingTestLib;
import com.tmb.automation.util.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class UI_SetPIN_7604_IE_2 extends Base {
	@Parameters({"DeviceProfile" })
    @BeforeMethod(groups = {"ios", "lending", "Sprint15", "1309"})
    public void BeforeTest(String deviceProfile) {
        Helper.CONFIG_PROFILE = deviceProfile;
        Base.appiumCapabilities();
        ExtentListeners.setDriver(appiumDriver);
        mapData = com.tmb.automation.helper.Helper.getExcelData("TestData_lending", "TestData_7604", this.getClass().getSimpleName());
    }

    @AfterMethod(groups = {"ios", "lending", "Sprint15", "1309"})
    public void teardown() {
        Base.driverQuit();
    }

    @Test(groups = {"android", "lending", "Sprint15", "3123"})
    public void ADTest001() throws IOException {
        log("------------Start " + this.getClass().getSimpleName());

        ChangeUsageLimitPage ld = new ChangeUsageLimitPage(appiumDriver);
        LendingTestLib.navigateToHomeScreen_ios(mapData);
        LendingTestLib.navigateToAccountSummary_ios();
        AccountSummaryPage as = new AccountSummaryPage(appiumDriver);
        ExtentReport4.printReportMessage("Card No.2 > More button");
        log("Click Card2 > More button");
        as.click(as.siAS_Card2_More);
        as.waitVisible(as.siAS_Card2_MainFeatures);
        ExtentReport4.printReportMessage("Card No.2 > after click More button");
//        as.waitVisible()
//        as.assertText(as.fX(as.siAS_Card2_MainFeatures).getText(), "Main Features");
//        as.assertText(as.fX(as.siAS_Card2_More_RedeemPoint).getText(), "Redeem point");
//        as.assertText(as.fX(as.siAS_Card2_More_CashForYou).getText(), "Cash for you");
//        as.assertText(as.fX(as.siAS_Card2_More_ApplySoGood).getText(), "Apply So GooOD");
//        as.assertText(as.fX(as.siAS_Card2_More_CardDetails).getText(), "Card details");
//        as.assertText(as.fX(as.siAS_Card2_More_BillPayment).getText(), "Bill payment");
//        as.assertText(as.fX(as.siAS_Card2_More_Topup).getText(), "Top-up");
//        as.assertText(as.fX(as.siAS_Card2_More_Paybill).getText(), "Pay bill");
//        as.assertText(as.fX(as.siAS_Card2_More_ManageCard).getText(), "Manage Card");
//        as.assertText(as.fX(as.siAS_Card2_More_AdjustUsageLimit).getText(), "Adjust usage limit");
//        as.assertText(as.fX(as.siAS_Card2_More_ApplyEStatement).getText(), "Apply e-statement");
//        as.assertText(as.fX(as.siAS_Card2_More_SetPin).getText(), "Set pin");
//        as.assertText(as.fX(as.siAS_Card2_More_BlockCard).getText(), "Block card");

        log("Click Set pin button");
        as.click(as.siAS_Card2_More_SetPin);
        as.waitVisible(as.siAS_SetATMPin_1);
        sleep();
        as.assertText(as.fX(as.siAS_SetATMPin_Title).getText(), "Set ATM PIN");
        as.assertText(as.fX(as.siAS_SetATMPin_Description).getText(), "Please Set up your 4-digits PIN]");
        ExtentReport4.printReportMessage("Card No.2 > Set ATM Pin page");
        LendingTestLib.setATMPin("1111");
        as.assertText(as.fX(as.siAS_SetATMPin_msg).getText(), "Confirm ATM PIN");
        ExtentReport4.printReportMessage("Card No.2 > Enter ATM Pin = 1111 ");
        sleep();

        LendingTestLib.setATMPin("2222");
        as.assertText(as.fX(as.siAS_SetATMPin_Error1).getText(), "ATM PIN does not match, Please try again");
        ExtentReport4.printReportMessage("Card No.2 > Enter Confirm ATM Pin = 2222 ");
        sleep();
//        as.setNative();
//        as.waitVisible(as.siCF_PIN_0);
//        UI_Lending_Common.setConfirmPin("010203");
//        sleep(10);
//        as.writeLog();

    }
}
