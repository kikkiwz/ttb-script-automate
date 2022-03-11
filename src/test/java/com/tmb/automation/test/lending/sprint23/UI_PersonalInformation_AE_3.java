package com.tmb.automation.test.lending.sprint23;

import com.tmb.automation.common.PhrasesConfigServiceMongoDb;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.lending.HomeScreenPage;
import com.tmb.automation.test.lending.sprint15.LendingTestLib;
import com.tmb.automation.util.Base;
import io.restassured.path.json.JsonPath;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * "Validate Personal Information (Android)
 * - Personal information"
 */
public class UI_PersonalInformation_AE_3 extends Base {
    private final JsonPath data = new JsonPath(com.tmb.automation.helper.Helper.getInput("./LendingResources/json/WorkInfo.json"));
    private PhrasesConfigServiceMongoDb phrase;
    @Parameters({"DeviceProfile" })
    @BeforeClass
    public void setUp(String deviceProfile) {
        Helper.CONFIG_PROFILE = deviceProfile;
//        Helper.CONFIG_PROFILE = "ios.S3";
        Base.appiumCapabilities();
        ExtentListeners.setDriver(appiumDriver);
        phrase = new PhrasesConfigServiceMongoDb();
    }

    @AfterClass
    public void teardown() {
        //ExtentReport4.printReportMessage("Finish");
        Base.driverQuit();
    }

    @Test
    public void UI_FlexiLoan_Test001() {
        ExtentReport4.printReportMessage("Card Name=TTB Flash");
        log("------------Start " + this.getClass().getSimpleName());
        HomeScreenPage hs = new HomeScreenPage(appiumDriver);
        LendingTestLib.navToHomeScreen("Account", "010203");
        LendingTestLib.navToAccounts("cards");
        LendingTestLib.navToMyCreditCard();
        LendingTestLib.navToLoanSubmission();
        LendingTestLib.navToFlexiLoan1(data.getString("UI.test2.cardname"));
        LendingTestLib.navToFlexiLoan3_FlashCard("direct debit", "111-2-46922-4", "Full");
        LendingTestLib.navToFlexiLoan4_flashCard();
        LendingTestLib.navToFlexiLoan41_flashCard();
        LendingTestLib.navToFlexiLoan6_flashCard();
        LendingTestLib.navToFlexiLoan7_flashCard();
        LendingTestLib.navToFlexiLoan8();
        LendingTestLib.navToFlexiLoan9();
        LendingTestLib.navToFlexiLoan10_underconstruction("want");
    }
}
