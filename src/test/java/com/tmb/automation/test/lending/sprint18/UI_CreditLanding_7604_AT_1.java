package com.tmb.automation.test.lending.sprint18;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.ChangeUsageLimitPage;
import com.tmb.automation.test.lending.sprint15.LendingTestLib;
import com.tmb.automation.util.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class UI_CreditLanding_7604_AT_1 extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups = {"ios", "lending", "Sprint15", "1309"})
    public void BeforeTest(String deviceProfile) {
        Helper.CONFIG_PROFILE =deviceProfile;
        Base.appiumCapabilities();
        ExtentListeners.setDriver(appiumDriver);
//        mapData = Helper.getExcelData("TestData_lending", "TestData_1309", this.getClass().getSimpleName());
    }

    @AfterMethod(groups = {"ios", "lending", "Sprint15", "1309"})
    public void teardown() {
        Base.driverQuit();
    }

    @Test(groups = {"android", "lending", "Sprint15", "3123"})
    public void ADTest001() throws IOException {
        log("------------Start " + this.getClass().getSimpleName());

        ChangeUsageLimitPage ld = new ChangeUsageLimitPage(appiumDriver);
        sleep(20);
        ld.writeLog();
        LendingTestLib.navigateToHomeScreen_ios(mapData);
        LendingTestLib.navigateToUsageLimit_ios();
        LendingTestLib.navigateToEnterAccountId(mapData);


//		TC_Lending_Common.navigateToAdjustUsageLimit(mapData);
        ld.waitVisible(ld.swImg_change2_CardImage, 50);
        ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
        String value1 = ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value").replace(",", "");
//		log("value1="+value1);

        log("case right value");
        ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), String.valueOf(Integer.parseInt(value1) + 1000));
        ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);
        log("value plus = " + ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value"));


        log("case left value");
        ld.click(ld.swLb_Change2_CurrentCreditLimit_value);
        ld.setText2(ld.fX(ld.swLb_Change2_CurrentCreditLimit_value), String.valueOf(Integer.parseInt(value1) - 2000));
        ld.click(ld.swLb_Change2_PleaseChangeUsageLimit);
        log("value minus = " + ld.fX(ld.swLb_Change2_CurrentCreditLimit_value).getAttribute("value"));
        ld.click(ld.swLb_Change2_CurrentCreditLimit_text);
        sleep();
        ld.writeLog();


//		ld.assertText(ld.fX(ld.swLb_Change2_CurrentCreditLimit_ErrMsg).getText(), "Usage limit cannot be less than amount spent");
        sleep();
        log("Click Next button");
        ld.click(ld.swBtn_Change2_Next);
        sleep();

        // Confirm Adjust Usage Limit page
        ld.waitVisible(ld.swLb_Change3_ConfirmAdjustUsageLimit);
        // check title
        ld.assertText(ld.fX(ld.swLb_Change3_ConfirmAdjustUsageLimit).getText(), "aa");
        //check credit card name
        ld.assertText(ld.fX(ld.swLb_Change3_CardName).getText(), "aa");
        //check credit card number
        ld.assertText(ld.fX(ld.swLb_Change3_CardNumber).getText(), "aa");
        //check old credit limit
        ld.assertText(ld.fX(ld.swLb_Change3_OldCreditLimit_value).getText(), "aa");
        //check new credit limit
        ld.assertText(ld.fX(ld.swLb_Change3_NewCreditLimit_value).getText(), "aa");
        //check confirm menu
        ld.assertText(ld.fX(ld.swBtn_Change3_Confirm).getText(), "Confirm");
        sleep();
        log("Click Next button");

    }
}
