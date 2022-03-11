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

public class UI_SetPIN_7604_IE_1 extends Base {
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
        log("Click Card3 > More button");
        as.click(as.siAS_Card3_More);
        sleep();
        as.waitVisible(as.siAS_SetPin1);
        ExtentReport4.printReportMessage("Card No.3 > after click More button");
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
        as.click(as.siAS_SetPin1);
        sleep(7);
        as.waitVisible(as.siAS_SetATMPin_Title);
        as.assertText(as.fX(as.siAS_SetATMPin_Title).getText(), "Set ATM PIN");
        as.assertText(as.fX(as.siAS_SetATMPin_Description).getText(), "Please Set up your 4-digits PIN]");
        ExtentReport4.printReportMessage("Card No.2 > Set ATM Pin page");
        LendingTestLib.setATMPin("1234");
        as.assertText(as.fX(as.siAS_SetATMPin_msg).getText(), "Confirm ATM PIN");
        ExtentReport4.printReportMessage("Card No.2 > Enter ATM Pin = 1234 ");
        sleep();
        LendingTestLib.setATMPin("1111");
        sleep(7);
        ExtentReport4.printReportMessage("Card No.2 > Enter ATM Pin = 1111 with wrong confirm ATM Pin ");
        as.assertText(as.fX(as.siAS_SetATMPin_Error1).getText(), "ATM PIN does not match, Please try again");

        LendingTestLib.setATMPin("1234");
        ExtentReport4.printReportMessage("Card No.2 > Enter Confirm ATM Pin = 1234 ");
//        sleep();
        as.setNative();
        as.waitVisible(as.siCF_PIN_0);
        LendingTestLib.setConfirmPin("010203");
//        sleep(20);
        //        as.writeLog();
        as.waitVisible(as.siAS_SetATMPin_Complete_Title, 70);
        as.assertText(as.fX(as.siAS_SetATMPin_Complete_Title).getText(), "Complete");
        as.assertText(as.fX(as.siAS_SetATMPin_Complete_Description1).getText(), "Card Number");
        as.assertText(as.fX(as.siAS_SetATMPin_Complete_Description2).getText(), "PIN has been changed");
        as.assertText(as.fX(as.siAS_SetATMPin_Complete_BackToMain_Btn).getText(), "Back to Main Page");
        ExtentReport4.printReportMessage("Complete ");
        as.click(as.siAS_SetATMPin_Complete_BackToMain_Btn);
        sleep(10);

    }
}
