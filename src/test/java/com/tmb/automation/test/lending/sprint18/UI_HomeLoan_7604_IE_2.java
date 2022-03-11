package com.tmb.automation.test.lending.sprint18;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.ChangeUsageLimitPage;
import com.tmb.automation.pages.lending.HomeLoanPage;
import com.tmb.automation.test.lending.sprint15.LendingTestLib;
import com.tmb.automation.util.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class UI_HomeLoan_7604_IE_2 extends Base {
//    private Map<String, Object> mapData = Helper.convertJsonToMap("LendingResources/json/ApplySoGood.json");
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups = {"ios", "lending", "Sprint15", "1309"})
    public void BeforeTest(String deviceProfile) {
        Helper.CONFIG_PROFILE = deviceProfile;
        Base.appiumCapabilities();
        ExtentListeners.setDriver(appiumDriver);
//        mapData = Helper.getExcelData("TestData_lending", "TestData_7604", this.getClass().getSimpleName());
    }

    @AfterMethod(groups = {"ios", "lending", "Sprint15", "1309"})
    public void teardown() {
        Base.driverQuit();
    }

    @Test(groups = {"android", "lending", "Sprint15", "3123"})
    public void ADTest001() throws IOException {
        log("------------Start " + this.getClass().getSimpleName());

        ChangeUsageLimitPage ld = new ChangeUsageLimitPage(appiumDriver);
//        UI_Lending_Common.navigateToService_ios(mapData);
        LendingTestLib.navigateToHomeScreen_ios(null);
//        UI_Lending_Common.navigateToHomeLoan_ios();
        LendingTestLib.navigateToLoan();
        HomeLoanPage lh = new HomeLoanPage(appiumDriver);

//        lh.touchAndMove(lh.fX("//"));
        lh.assertText(lh.fX(lh.siHL_Loan_CardName).getText(), "Cash 2 Go Loan");
//        lh.assertText(lh.fX(lh.siHL_Loan_Outstanding).getText(), "");
        lh.assertText(lh.fX(lh.siHL_Loan_PayBill).getText(), "Pay bill Double tabs to activate");
        lh.assertText(lh.fX(lh.siHL_Loan_Topup).getText(), "Top up Double tabs to activate");
    }
}
