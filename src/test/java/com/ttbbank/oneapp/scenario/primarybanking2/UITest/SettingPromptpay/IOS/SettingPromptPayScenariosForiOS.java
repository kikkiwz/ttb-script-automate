package com.ttbbank.oneapp.scenario.primarybanking2.UITest.SettingPromptpay.IOS;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.tmb.automation.helper.Log;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class SettingPromptPayScenariosForiOS extends BaseScenario {

    public static ExtentTest scenario;
    public String accessToken;

    WebDriver webContext;
    private static final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/DataTest/setting_promptpay.json"));
    private static final JsonPath config = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/Config/setting_promptpay_config.json"));


    @Test(groups = {"RegisterWithMobileNo"}, priority = 1)
    public void registerPromptPayWithMobileNoSuccess() throws InterruptedException, IOException {

        TtbTestContext ttbTestContext = getTtbTestContext();
        Thread.sleep(10000);

        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String mainMenu = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - MainMenu.png";
        takeScreenshot(mainMenu);
        scenario.createNode(Given.class, "ONEAPP - Main Screen").addScreenCaptureFromPath(mainMenu).pass("Main menu screen displaying correctly - PASSES");

        Thread.sleep(3000);
        ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON).click();
        Thread.sleep(3000);
        ttbTestContext.tapCenter();
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MANAGE_TTB_PROMPTPAY, true);
        if (ttbTestContext.isAndroid()) {

            Thread.sleep(3000);
            Set<String> webNames = webContext.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.TAB_OTHER_SERVICE);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        WebElement TAB_OTHER_SERVICE = ttbTestContext.findElement(OneAppElementKeys.TAB_OTHER_SERVICE);
        TAB_OTHER_SERVICE.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MANAGE_TTB_PROMPTPAY);
        WebElement manageTTBPromptPayMenu
                = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MANAGE_TTB_PROMPTPAY);

        Thread.sleep(10000);
        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String manageTTBPromptPay = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - ManageTTBPromptPayScreen.png";
        takeScreenshot(manageTTBPromptPay);
        scenario.createNode(Given.class, "Service - Manage TTB PromptPay").addScreenCaptureFromPath(manageTTBPromptPay).pass("Manage TTB PromptPay screen displaying correctly - PASSES");

        manageTTBPromptPayMenu.click();

        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);
        WebElement signUpNowBTN = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String termAndConScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - TermAndConScreen.png";
        takeScreenshot(termAndConScreen);
        scenario.createNode(Given.class, "Setting PromptPay - Term & Condition").addScreenCaptureFromPath(termAndConScreen).pass("Term & Condition screen displaying correctly - PASSES");

        signUpNowBTN.click();

        Log.logger.info("Press Done success");

        Thread.sleep(10000);

        (new WebDriverWait(ttbTestContext.getDriver(), 30000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        //PromptPay List
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL);

        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String beforeRegister = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - BeforeRegister.png";
        takeScreenshot(beforeRegister);
        scenario.createNode(Given.class, "PromptPay List Before").addScreenCaptureFromPath(beforeRegister).pass("PromptPay List screen displaying correctly - PASSES");

        WebElement mobileLabel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL);
        String getMobileLabel = mobileLabel.getText();

        Log.logger.info("Mobile Label  :" + " " + getMobileLabel);

        Assert.assertEquals(getMobileLabel, "Mobile Number");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);
        Thread.sleep(5000);

        //Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON).getText(), "Sign Up with Mobile number");

        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON).isDisplayed());

        WebElement mobileRegisterButton
                = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);
        mobileRegisterButton.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL);
        WebElement selectAccountTitle = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL);
        String getSelectAccountTitleLabel = selectAccountTitle.getText();


        Assert.assertEquals(getSelectAccountTitleLabel, "Select an account to register");

        (new WebDriverWait(ttbTestContext.getDriver(), 30000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        Thread.sleep(10000);
        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String selectAccount = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - SelectAccountScreen.png";
        takeScreenshot(selectAccount);
        scenario.createNode(Given.class, "Before Select Account No.").addScreenCaptureFromPath(selectAccount).pass("Before select account screen displaying correctly - PASSES");

        int selectedAccountNo = 1;
        switch (selectedAccountNo) {
            case 1:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_1_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.1 is selected !! <<<<<<<<<<<<<<<<<<<<");

                break;
            case 2:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_2_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.2 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 3:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_3_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.3 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 4:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_4_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.4 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 5:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_5_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.5 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 6:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_6_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.6 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 7:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_7_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.7 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 8:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_8_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.8 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 9:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_9_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.9 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 10:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_10_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.10 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            default:
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> Account no. doesn't selected by customer .... <<<<<<<<<<<<<<<<<<<<");
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_CLOSE_BUTTON).click();
        }
        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String accountSelected = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - SelectedAccountScreen.png";
        takeScreenshot(accountSelected);
        scenario.createNode(Given.class, "Selected Account By Customer").addScreenCaptureFromPath(accountSelected).pass("Selected account screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NEXT_BUTTON).click();

        //Confirm screen
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_SCREEN_TITLE);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_VALUE);

        Thread.sleep(5000);
        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String confirmScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - ConfirmScreen.png";
        takeScreenshot(confirmScreen);
        scenario.createNode(Given.class, "Confirm Screen").addScreenCaptureFromPath(confirmScreen).pass("Confirm screen displaying correctly - PASSES");
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_NEXT_BUTTON).click();

        ttbTestContext.getDriver().context("NATIVE_APP");

        //To confirm registration - enterPIN
        enterPin();

        //Success screen
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_VALUE, true);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_ACCOUNT_NO_VALUE);

        WebElement actualRegisteredMobileNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_VALUE);
        String getActualRegisterMobileNo = actualRegisteredMobileNo.getText();

        WebElement actualRegisteredAccountNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_ACCOUNT_NO_VALUE);
        String getActualRegisterAccountNo = actualRegisteredAccountNo.getText();

        Log.logger.info("Registered Mobile No. :" + getActualRegisterMobileNo);
        Log.logger.info("Registered Account No. :" + getActualRegisterAccountNo);
        Assert.assertEquals(getActualRegisterMobileNo, "XXX-XXX-0009"); //XXX-XXX-0009
        Assert.assertEquals(getActualRegisterAccountNo, "001-9-75084-3"); //001-9-75084-3

        //capture result - success screen
        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String successScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - SuccessScreen.png";
        takeScreenshot(successScreen);
        scenario.createNode(Given.class, "Success screen").addScreenCaptureFromPath(successScreen).pass("Success screen displaying correctly - PASSES");

        Thread.sleep(3000);
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON).click();
        Thread.sleep(3000);
        //Verify Screen - after register success
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String termAndCon2 = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - AfterRegisterTermAndCon.png";
        takeScreenshot(termAndCon2);
        scenario.createNode(Given.class, "Setting PromptPay - Term & Condition").addScreenCaptureFromPath(termAndCon2).pass("Term & Condition screen displaying correctly - PASSES");


        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON).click();

        Log.logger.info("Press Done success");


        Thread.sleep(15000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_ALREADY_REGISTERED_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_MOBILE_GREEN_LOGO);

        scenario = getFeature().createNode(Scenario.class, "Register with MobileNo.(Success)");
        String afterRegisterMobileSuccess = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/Mobile - PromptPayListAfterRegister.png";
        takeScreenshot(afterRegisterMobileSuccess);
        scenario.createNode(Given.class, "PromptPay list after registration success").addScreenCaptureFromPath(afterRegisterMobileSuccess).pass("PromptPay list after registration screen displaying correctly - PASSES");


        Assert.assertTrue(ttbTestContext.findElement
                (OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_ALREADY_REGISTERED_LABEL).isDisplayed());
    }

    @Test(groups = {"RegisterWithCitizenID"}, priority = 2)
    public void registerPromptPayWithCitizenIDSuccess() throws InterruptedException, IOException {

        TtbTestContext ttbTestContext = getTtbTestContext();
        Thread.sleep(10000);

        //PromptPay List
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL);

        scenario = getFeature().createNode(Scenario.class, "Register with CitizenID (Success)");
        String beforeRegister = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/CitizenID - BeforeRegister.png";
        takeScreenshot(beforeRegister);
        scenario.createNode(Given.class, "PromptPay List Before").addScreenCaptureFromPath(beforeRegister).pass("PromptPay List screen displaying correctly - PASSES");


        WebElement citizenIdCardLabel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL);
        String getCitizenIdLabel = citizenIdCardLabel.getText();

        Log.logger.info("Citizen ID Label  :" + " " + getCitizenIdLabel);

        Assert.assertEquals(getCitizenIdLabel, "Citizen ID");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON);
        Thread.sleep(5000);

        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON).isDisplayed());

        WebElement citizenID_Button
                = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON);
        citizenID_Button.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL);
        WebElement selectAccountTitle = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL);
        String getSelectAccountTitleLabel = selectAccountTitle.getText();

        Assert.assertEquals(getSelectAccountTitleLabel, "Select an account to register");

        (new WebDriverWait(ttbTestContext.getDriver(), 30000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        scenario = getFeature().createNode(Scenario.class, "Register with CitizenID (Success)");
        String selectAccount = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/CitizenID - SelectAccountScreen.png";
        takeScreenshot(selectAccount);
        scenario.createNode(Given.class, "Before Select Account No.").addScreenCaptureFromPath(selectAccount).pass("Before select account screen displaying correctly - PASSES");

        int selectedAccountNo = 1;
        switch (selectedAccountNo) {
            case 1:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_1_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.1 is selected !! <<<<<<<<<<<<<<<<<<<<");

                break;
            case 2:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_2_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.2 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 3:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_3_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.3 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 4:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_4_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.4 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 5:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_5_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.5 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 6:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_6_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.6 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 7:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_7_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.7 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 8:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_8_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.8 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 9:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_9_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.9 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            case 10:
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NO_10_CHECK_BOX_BUTTON).click();
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> AccountNo.10 is selected !! <<<<<<<<<<<<<<<<<<<<");
                break;
            default:
                Log.logger.info(">>>>>>>>>>>>>>>>>>>> Account no. doesn't selected by customer .... <<<<<<<<<<<<<<<<<<<<");
                ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_CLOSE_BUTTON).click();
        }

        scenario = getFeature().createNode(Scenario.class, "Register with CitizenID (Success)");
        String accountSelected = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/CitizenID - SelectedAccountScreen.png";
        takeScreenshot(accountSelected);
        scenario.createNode(Given.class, "Selected Account By Customer").addScreenCaptureFromPath(accountSelected).pass("Selected account screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NEXT_BUTTON).click();

        //Confirm screen
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_LABEL);

        scenario = getFeature().createNode(Scenario.class, "Register with CitizenID.(Success)");
        String confirmScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/CitizenID - ConfirmScreen.png";
        takeScreenshot(confirmScreen);
        scenario.createNode(Given.class, "Confirm screen").addScreenCaptureFromPath(confirmScreen).pass("Confirm screen displaying correctly - PASSES");
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_NEXT_BUTTON).click();

        ttbTestContext.getDriver().context("NATIVE_APP");

        enterPin();
        Thread.sleep(10000);
        scenario = getFeature().createNode(Scenario.class, "Register with CitizenID (Success)");
        String inputCorrectPIN = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/CitizenID - InputCorrectPIN.png";
        takeScreenshot(inputCorrectPIN);
        scenario.createNode(Given.class, "Input Correct PIN").addScreenCaptureFromPath(inputCorrectPIN).pass("Input correct PIN - PASSES");

        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_RESULT_REGISTER_LABEL, true);

        //Success screen

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_VALUE);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE);

        WebElement actualRegisteredCitizenID = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_VALUE);
        String getActualRegisterCitizenID = actualRegisteredCitizenID.getText();

        WebElement actualRegisteredAccountNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE);
        String getActualRegisterAccountNo = actualRegisteredAccountNo.getText();

        Log.logger.info("Registered CitizenID :" + getActualRegisterCitizenID);
        Log.logger.info("Registered Account No. :" + getActualRegisterAccountNo);

        Assert.assertEquals(getActualRegisterCitizenID, "X-XXXX-XXXX5-01-2");
        Assert.assertEquals(getActualRegisterAccountNo, "001-9-75084-3");


        //capture result - success screen
        scenario = getFeature().createNode(Scenario.class, "Register with CitizenID (Success)");
        String successScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/CitizenID - SuccessScreen.png";
        takeScreenshot(successScreen);
        scenario.createNode(Given.class, "Success screen").addScreenCaptureFromPath(successScreen).pass("Success screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON).click();

        //Verify PromptPay Screen after register success
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "Register with CitizenID (Success)");
        String termAndCon2 = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/CitizenID - AfterRegisterTermAndCon.png";
        takeScreenshot(termAndCon2);
        scenario.createNode(Given.class, "Setting PromptPay - Term & Condition").addScreenCaptureFromPath(termAndCon2).pass("Term & Condition screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON).click();

        Log.logger.info("Press Done success");

        Thread.sleep(15000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));


        Thread.sleep(15000);

        WebElement citizenDesp = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ALREADY_REGISTERED_LABEL);
        String getCitizenDesp = citizenDesp.getText();

        Log.logger.debug("Print Citizen Label :" + " " + getCitizenDesp);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ALREADY_REGISTERED_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_CITIZEN_ID_GREEN_LOGO);


        scenario = getFeature().createNode(Scenario.class, "Register with CitizenID (Success)");
        String afterRegisterMobileSuccess = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Register/CitizenID - PromptPayListAfterRegister.png";
        takeScreenshot(afterRegisterMobileSuccess);
        scenario.createNode(Given.class, "PromptPay list after registration success").addScreenCaptureFromPath(afterRegisterMobileSuccess).pass("PromptPay list after registration screen displaying correctly - PASSES");


        Assert.assertTrue(ttbTestContext.findElement
                (OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ALREADY_REGISTERED_LABEL).isDisplayed());

    }

    @Test(groups = {"DeRegisterWithMobileNo"}, priority = 3, dependsOnMethods = {"registerPromptPayWithMobileNoSuccess"})
    public void deRegisterPromptPayWithMobileNoSuccess()throws InterruptedException, IOException{

        //PromptPayList before deregister
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_UNREGISTER_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "Deregister with MobileNo.(Success)");
        String afterRegisterMobileSuccess = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/Mobile - PromptPayListBeforeDeRegister.png";
        takeScreenshot(afterRegisterMobileSuccess);
        scenario.createNode(Given.class, "PromptPay list before deregister").addScreenCaptureFromPath(afterRegisterMobileSuccess).pass("PromptPay list before deregister screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_UNREGISTER_BUTTON).click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_CONFIRM_DESCRIPTION_LABEL);

        Thread.sleep(30000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "Deregister with Mobile No. (Success)");
        String confirmDeregisterScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/Mobile - ConfirmDeregister.png";
        takeScreenshot(confirmDeregisterScreen);
        scenario.createNode(Given.class, "Confirm Deregister screen").addScreenCaptureFromPath(confirmDeregisterScreen).pass("Confirm deregister screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON).click();
        Thread.sleep(2000);

        ttbTestContext.getDriver().context("NATIVE_APP");

        enterPin();

        scenario = getFeature().createNode(Scenario.class, "DeRegister with MobileNo.(Success)");
        String inputCorrectPIN = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/Mobile - InputCorrectPIN.png";
        takeScreenshot(inputCorrectPIN);
        scenario.createNode(Given.class, "Input Correct PIN").addScreenCaptureFromPath(inputCorrectPIN).pass("PromptPay list before deregister screen displaying correctly - PASSES");


        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMPLETED_LABEL, true);
        WebElement mobileNoValue = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_MOBILE_NO_BANNER_VALUE);
        String getMobileNoValue = mobileNoValue.getText();

        Log.logger.info("DeRegister with Mobile No  :" + " " + getMobileNoValue);

        Assert.assertEquals(getMobileNoValue, "XXX-XXX-0009");

        scenario = getFeature().createNode(Scenario.class, "DeRegister with MobileNo.(Success)");
        String deRegisterSuccessScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/Mobile - Deregister success.png";
        takeScreenshot(deRegisterSuccessScreen);
        scenario.createNode(Given.class, "Deregister success").addScreenCaptureFromPath(deRegisterSuccessScreen).pass("Deregister success screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_DONE_BUTTON).click();

        //Verify after deregister success

        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "DeRegister with MobileNo.(Success)");
        String termAndCon2 = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/Mobile - AfterDeRegisterTermAndCon.png";
        takeScreenshot(termAndCon2);
        scenario.createNode(Given.class, "Setting PromptPay - Term & Condition").addScreenCaptureFromPath(termAndCon2).pass("Term & Condition screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON).click();

        Log.logger.info("Press Done success");

        Thread.sleep(15000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));


        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "DeRegister with MobileNo.(Success)");
        String afterDeRegisterMobileSuccess = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/Mobile - PromptPayListAfterDeRegister.png";
        takeScreenshot(afterDeRegisterMobileSuccess);
        scenario.createNode(Given.class, "PromptPay list after DeRegistration success").addScreenCaptureFromPath(afterDeRegisterMobileSuccess).pass("PromptPay list after DeRegistration screen displaying correctly - PASSES");


        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL).isDisplayed());

    }

    @Test(groups = {"DeRegisterWithCitizenID"}, priority = 4, dependsOnMethods = {"registerPromptPayWithCitizenIDSuccess"})
    public void deRegisterPromptPayWithCitizenIDSuccess()throws InterruptedException, IOException{

        //PromptPayList before deregister
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_UNREGISTER_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "Deregister with CitizenID (Success)");
        String afterRegisterMobileSuccess = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/CitizenID - PromptPayListBeforeDeRegister.png";
        takeScreenshot(afterRegisterMobileSuccess);
        scenario.createNode(Given.class, "PromptPay list before deregister").addScreenCaptureFromPath(afterRegisterMobileSuccess).pass("PromptPay list before deregister screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_UNREGISTER_BUTTON).click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_CONFIRM_DESCRIPTION_LABEL);

        Thread.sleep(30000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "Deregister with CitizenID (Success)");
        String confirmDeregisterScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/CitizenID - ConfirmDeregister.png";
        takeScreenshot(confirmDeregisterScreen);
        scenario.createNode(Given.class, "Confirm Deregister screen").addScreenCaptureFromPath(confirmDeregisterScreen).pass("Confirm deregister screen displaying correctly - PASSES");


        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON).click();
        Thread.sleep(2000);

        ttbTestContext.getDriver().context("NATIVE_APP");

        enterPin();

        scenario = getFeature().createNode(Scenario.class, "DeRegister with MobileNo.(Success)");
        String inputCorrectPIN = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/Mobile - InputCorrectPIN.png";
        takeScreenshot(inputCorrectPIN);
        scenario.createNode(Given.class, "Input Correct PIN").addScreenCaptureFromPath(inputCorrectPIN).pass("PromptPay list before deregister screen displaying correctly - PASSES");


        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMPLETED_LABEL, true);
        WebElement citizenIDBValue = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CITIZEN_ID_BANNER_VALUE);
        String getCitizenIDValue = citizenIDBValue.getText();

        Log.logger.info("DeRegister with Mobile No  :" + " " + getCitizenIDValue);

        Assert.assertEquals(getCitizenIDValue, "X-XXXX-XXXX5-01-2");

        scenario = getFeature().createNode(Scenario.class, "DeRegister with CitizenID (Success)");
        String deRegisterSuccessScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/CitizenID - Deregister success.png";
        takeScreenshot(deRegisterSuccessScreen);
        scenario.createNode(Given.class, "Deregister success").addScreenCaptureFromPath(deRegisterSuccessScreen).pass("Deregister success screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_DONE_BUTTON).click();

        //Verify after deregister success
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "DeRegister with CitizenID (Success)");
        String termAndCon2 = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/CitizenID - AfterDeRegisterTermAndCon.png";
        takeScreenshot(termAndCon2);
        scenario.createNode(Given.class, "Setting PromptPay - Term & Condition").addScreenCaptureFromPath(termAndCon2).pass("Term & Condition screen displaying correctly - PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON).click();

        Log.logger.info("Press Done success");

        Thread.sleep(15000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));


        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "DeRegister with CitizenID (Success)");
        String afterDeRegisterCitizenIDSuccess = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/DeRegister/Mobile - PromptPayListAfterDeRegister.png";
        takeScreenshot(afterDeRegisterCitizenIDSuccess);
        scenario.createNode(Given.class, "PromptPay list after DeRegistration success").addScreenCaptureFromPath(afterDeRegisterCitizenIDSuccess).pass("PromptPay list after DeRegistration screen displaying correctly - PASSES");


        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL).isDisplayed());



    }
}
