package com.tmb.automation.test.lending.sprint25;

import com.tmb.automation.common.PhrasesConfigServiceMongoDb;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.HomeScreenPage;
import com.tmb.automation.test.lending.sprint15.LendingTestLib;
import com.tmb.automation.util.Base;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * "Validate Personal Information (Android)
 * - Personal information"
 */
public class UI_FlexiLoanFlashCard_AE_1 extends Base {
    private final JsonPath data = new JsonPath(Helper.getInput("./LendingResources/json/WorkInfo.json"));
    private PhrasesConfigServiceMongoDb phrase;
    @Parameters({"DeviceProfile" })
    @BeforeClass
    public void setUp(String deviceProfile) {
        Helper.CONFIG_PROFILE =deviceProfile;
        System.out.println("The device profile is---"+deviceProfile);
//        Helper.CONFIG_PROFILE = "ios.S3";
        Base.appiumCapabilities();
        ExtentListeners.setDriver(appiumDriver);
        phrase = new PhrasesConfigServiceMongoDb();
    }

    @AfterClass
    public void teardown() {
        ExtentReport4.printReportMessage("Finish");
        Base.driverQuit();
    }

    @Test
    public void UI_FlexiLoan_Test001() {
        ExtentReport4.printReportMessage("Card Name=TTB Cash2Go");
        log("------------Start " + this.getClass().getSimpleName());
        HomeScreenPage hs = new HomeScreenPage(appiumDriver);
        LendingTestLib.navToHomeScreen("Service", "010203");
        LendingTestLib.navToService(data.getString("UI.test1.mockMenu"), data.getString("UI.test1.pin"));
        LendingTestLib.navToFlexiLoan0(data.getString("UI.test1.rmid"));
        LendingTestLib.navToFlexiLoan1(data.getString("UI.test1.cardname"));
        LendingTestLib.navToFlexiLoan2();
        LendingTestLib.navToFlexiLoan3("direct debit", "111-2-46922-4", "Full");
        LendingTestLib.navToFlexiLoan4();
        LendingTestLib.navToFlexiLoan4EditAddress();
        LendingTestLib.navToFlexiLoan41();
        LendingTestLib.navToFlexiLoan6();
        LendingTestLib.navToFlexiLoan7();
        LendingTestLib.navToFlexiLoan8();
        LendingTestLib.navToFlexiLoan9();
    }
}
