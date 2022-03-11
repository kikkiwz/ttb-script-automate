package com.tmb.automation.test.primarybanking2.UITest.SettingPromptPay;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;

import com.tmb.automation.helper.Log;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class SettingPromptPay extends BaseScenario {

    WebDriver webContext;
    String currentSelectedAccountNo = "";
    String newSelectedAccountNo = "";



    @Test
    public void goToSettingPromptPayList(ExtentTest scenario) throws InterruptedException, IOException {


        TtbTestContext ttbTestContext = getTtbTestContext();
        scenario = getFeature().createNode(Scenario.class, "Success - Register with MobileNo.");
        String mainMenu = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - MainMenu.png";
        takeScreenshot(mainMenu);
        scenario.createNode(Given.class, "ONEAPP - Main Screen").addScreenCaptureFromPath(mainMenu).pass("Main menu screen displaying correctly - PASSES");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.SERVICE_BUTTON);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        Thread.sleep(3000);
        serviceButton.click();
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
        Thread.sleep(10000);

        TAB_OTHER_SERVICE.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MANAGE_TTB_PROMPTPAY);
        WebElement manageTTBPromptPayMenu
                = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MANAGE_TTB_PROMPTPAY);

        Thread.sleep(1000);
        manageTTBPromptPayMenu.click();

        ttbTestContext.getDriver().context("NATIVE_APP");

        enterPin();

        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);

        WebElement signUpNowBTN = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);

        scenario = getFeature().createNode(Scenario.class, "Success - Register with MobileNo.");
        String termAndConScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - TermAndConScreen.png";
        takeScreenshot(termAndConScreen);
        scenario.createNode(Given.class, "Setting PromptPay - Term & Condition").addScreenCaptureFromPath(termAndConScreen).pass("Term & Condition screen displaying correctly - PASSES");

        signUpNowBTN.click();

        Log.logger.info("Press Done success");
        Thread.sleep(10000);

        (new WebDriverWait(ttbTestContext.getDriver(), 30000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

    }

    @Test
    public void registerWithMobileNoSuccess(int selectAccountNo, String expectedMobileNo, String expectedAccountNo)
            throws InterruptedException, IOException {

        //PromptPay List
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL);

//        ExtentTest scenario = getFeature().createNode(Scenario.class, "Setting PromptPay - Register with MobileNo Success");
//        String BeforeRegister = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - Before register.png";
//        takeScreenshot(BeforeRegister);
//        scenario.createNode(Given.class, "Setting PromptPay - Register with MobileNo Success").addScreenCaptureFromPath(BeforeRegister).pass("PASSES");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Access to Insurance feature");
        String protectionActivateApp = "images/Protection_Activate application.png";
        takeScreenshot(protectionActivateApp);
        scenario.createNode(Given.class, "Access to Insurance feature").addScreenCaptureFromPath(protectionActivateApp).pass("PASS");
        getExtent().flush();


        WebElement mobileLabel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL);
        String getMobileLabel = mobileLabel.getText();

        Log.logger.info("Mobile Label  :" + " " + getMobileLabel);

        Assert.assertEquals(getMobileLabel, "Mobile Number");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);
        Thread.sleep(5000);

        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON).getText(), "Register");

        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON).isDisplayed());

        WebElement mobileRegisterButton
                = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);
        mobileRegisterButton.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL);
        WebElement selectAccountTitle = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL);
        String getSelectAccountTitleLabel = selectAccountTitle.getText();


        String selectAccount = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - SelectAccountScreen.png";
        takeScreenshot(selectAccount);
        scenario.createNode(Given.class, "Setting PromptPay - Register with MobileNo Success").addScreenCaptureFromPath(selectAccount).pass("PASSES");

     Assert.assertEquals(getSelectAccountTitleLabel, "Select an account to receive / transfer via mobile number");

        (new WebDriverWait(ttbTestContext.getDriver(), 30000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        registerPromptPaySelectAccountNo(1);

        String accountSelected = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - SelectedAccountScreen.png";
        takeScreenshot(accountSelected);
        scenario.createNode(Given.class, "Setting PromptPay - Register with MobileNo Success").addScreenCaptureFromPath(accountSelected).pass("PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NEXT_BUTTON).click();

        //Confirm screen
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_LABEL);

        String confirmScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - ConfirmScreen.png";
        takeScreenshot(confirmScreen);
        scenario.createNode(Given.class, "Setting PromptPay - Register with MobileNo Success").addScreenCaptureFromPath(confirmScreen).pass("PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_NEXT_BUTTON).click();

        ttbTestContext.getDriver().context("NATIVE_APP");

        enterPin();

        String inputCorrectPIN = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - InputCorrectPIN.png";
        takeScreenshot(inputCorrectPIN);
        scenario.createNode(Given.class, "Setting PromptPay - Register with MobileNo Success").addScreenCaptureFromPath(inputCorrectPIN).pass("PASSES");


        //Success screen

        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_VALUE, true);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_ACCOUNT_NO_VALUE);

        WebElement actualRegisteredMobileNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_VALUE);
        String getActualRegisterMobileNo = actualRegisteredMobileNo.getText();

        WebElement actualRegisteredAccountNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_ACCOUNT_NO_VALUE);
        String getActualRegisterAccountNo = actualRegisteredAccountNo.getText();

        Log.logger.info("Registered Mobile No. :" + getActualRegisterMobileNo );
        Log.logger.info("Registered Account No. :" + getActualRegisterAccountNo );

        Assert.assertEquals(getActualRegisterMobileNo, expectedMobileNo);
        Assert.assertEquals(getActualRegisterAccountNo, expectedAccountNo);

        //capture result - success screen
        String successScreen = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - SuccessScreen.png";
        takeScreenshot(successScreen);
        scenario.createNode(Given.class, "Setting PromptPay - Register with MobileNo Success").addScreenCaptureFromPath(successScreen).pass("PASSES");

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON).click();

        verifyMobileNoAfterRegisteredSuccess();
    }

    @Test
    public void registerWithCitizenIDSuccess(int selectAccountNo, String expectedCitizenID, String expectedAccountNo)
            throws InterruptedException {

        //PromptPay List
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL);

        WebElement citizenIdCardLabel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL);
        String getCitizenIdLabel = citizenIdCardLabel.getText();

        Log.logger.info("Citizen ID Label  :" + " " + getCitizenIdLabel);

        Assert.assertEquals(getCitizenIdLabel, "Citizen ID Card");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON);
        Thread.sleep(5000);

        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON).isDisplayed());

        WebElement citizenID_Button
                = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON);
        citizenID_Button.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL);
        WebElement selectAccountTitle = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL);
        String getSelectAccountTitleLabel = selectAccountTitle.getText();

        Assert.assertEquals(getSelectAccountTitleLabel, "Select an account to receive / transfer via citizen id");

        (new WebDriverWait(ttbTestContext.getDriver(), 30000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        registerPromptPaySelectAccountNo(1);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CITIZEN_ID_LABEL);
        //Confirm screen
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_NEXT_BUTTON).click();
        ttbTestContext.getDriver().context("NATIVE_APP");

        enterPin();

        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_RESULT_REGISTER_LABEL, true);

        //Success screen

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_VALUE);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE);

        WebElement actualRegisteredCitizenID = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_VALUE);
        String getActualRegisterCitizenID= actualRegisteredCitizenID.getText();

        WebElement actualRegisteredAccountNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE);
        String getActualRegisterAccountNo = actualRegisteredAccountNo.getText();

        Log.logger.info("Registered CitizenID :" + getActualRegisterCitizenID );
        Log.logger.info("Registered Account No. :" + getActualRegisterAccountNo );

        Assert.assertEquals(getActualRegisterCitizenID, expectedCitizenID);
        Assert.assertEquals(getActualRegisterAccountNo, expectedAccountNo);

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON).click();

    }

    @Test
    public void deRegisterWithMobileNoSuccess(String expectedMobileNo) throws InterruptedException {
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_UNREGISTER_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_UNREGISTER_BUTTON).click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_CONFIRM_DESCRIPTION_LABEL);

        Thread.sleep(30000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON);

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON).click();
        Thread.sleep(2000);

        ttbTestContext.getDriver().context("NATIVE_APP");

        enterPin();

        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMPLETED_LABEL, true);
        WebElement mobileNoValue = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_MOBILE_NO_BANNER_VALUE);
        String getMobileNoValue = mobileNoValue.getText();

        Log.logger.info("DeRegister with Mobile No  :" + " " + getMobileNoValue);

        Assert.assertEquals(getMobileNoValue, expectedMobileNo);

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_DONE_BUTTON).click();


    }

    @Test
    public void deRegisterWithCitizenIDSuccess(String expectedCitizenID) throws InterruptedException {
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_UNREGISTER_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_UNREGISTER_BUTTON).click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_CONFIRM_DESCRIPTION_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON);

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_COMFIRM_BUTTON).click();
        Thread.sleep(2000);

        ttbTestContext.getDriver().context("NATIVE_APP");

        enterPin();

        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGSITER_COMPLETED_LABEL, true);
        WebElement citizenIDValue = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_CITIZEN_ID_BANNER_VALUE);
        String getCitizenIDValue = citizenIDValue.getText();

        Log.logger.info("DeRegister with Citizen ID  :" + " " + getCitizenIDValue);

        Assert.assertEquals(getCitizenIDValue, expectedCitizenID);

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_DEREGISTER_DONE_BUTTON).click();
    }

    @Test
    public void verifyMobileNoAfterRegisteredSuccess() throws InterruptedException, IOException {

        TtbTestContext ttbTestContext = getTtbTestContext();
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON).click();

        Log.logger.info("Press Done success");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Setting PromptPay - Register with MobileNo Success");
        String afterRegister = "images/" + ttbTestContext.getPlateFormName() + "/Setting PromptPay/Mobile - Before register.png";
        takeScreenshot(afterRegister);
        scenario.createNode(Given.class, "Setting PromptPay - Register with MobileNo Success").addScreenCaptureFromPath(afterRegister).pass("PASSES");

        Thread.sleep(15000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_ALREADY_REGISTERED_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNED_UP_MOBILE_GREEN_LOGO);

        Assert.assertTrue(ttbTestContext.findElement
                (OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_ALREADY_REGISTERED_LABEL).isDisplayed());

    }

    @Test
    public void verifyCitizenIDAfterRegisteredSuccess() throws InterruptedException {
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);
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

        Assert.assertTrue(ttbTestContext.findElement
                (OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_ALREADY_REGISTERED_LABEL).isDisplayed());
    }

    @Test
    public void verifyMobileNoAfterDeRegisteredSuccess() throws InterruptedException {
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON).click();

        Log.logger.info("Press Done success");

        Thread.sleep(15000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));


        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);

        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_NOT_REGISTERED_LABEL).isDisplayed());


    }

    @Test
    public void verifyCitizenIDAfterDeRegisteredSuccess() throws InterruptedException {
        webContext = ttbTestContext.setContextToWebView(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON, true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_NOW_BUTTON).click();

        Log.logger.info("Press Done success");

        Thread.sleep(15000);
        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));


        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_NOT_REGISTERED_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON);

        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_NOT_REGISTERED_LABEL).isDisplayed());

    }

    @Test
    public void editSelectedAccountNoWithMobileNoSuccess(int selectAccountNo, String expectedMobileNo, String expectedAccountNo)
            throws InterruptedException {
        //PromptPay List
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL);

        WebElement mobileLabel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_MOBILE_LABEL);
        String getMobileLabel = mobileLabel.getText();

        Log.logger.info("Mobile Label  :" + " " + getMobileLabel);

        Assert.assertEquals(getMobileLabel, "Mobile Number");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);
        Thread.sleep(5000);

        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON).getText(), "Register");

        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON).isDisplayed());

        WebElement mobileRegisterButton
                = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);
        mobileRegisterButton.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL);
        WebElement selectAccountTitle = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL);
        String getSelectAccountTitleLabel = selectAccountTitle.getText();

        Assert.assertEquals(getSelectAccountTitleLabel, "Select an account to receive / transfer via mobile number");

        (new WebDriverWait(ttbTestContext.getDriver(), 30000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        //Select Account No.1st time
        currentSelectedAccountNo = registerPromptPaySelectAccountNo(1);

        //Confirm screen
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CHANGE_ACCOUNT_NO_ICON);
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CHANGE_ACCOUNT_NO_ICON).click();

        //Select new AccountNo
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_MOBILE_NO_ACCOUNT_TO_REGISTER_LABEL);

        Assert.assertEquals(getSelectAccountTitleLabel, "Select an account to receive / transfer via mobile number");

        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));
        newSelectedAccountNo = editSelectedAccountNo(2);

        Assert.assertNotEquals(currentSelectedAccountNo, newSelectedAccountNo);

        //Success screen

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_TITLE);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_RESULT_REGISTER_LABEL);

        WebElement actualRegisteredMobileNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_MOBILE_NO_VALUE);
        String getActualRegisterMobileNo = actualRegisteredMobileNo.getText();

        WebElement actualRegisteredAccountNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE);
        String getActualRegisterAccountNo = actualRegisteredAccountNo.getText();

        Log.logger.info("Registered Mobile No. :" + getActualRegisterMobileNo );
        Log.logger.info("Registered Account No. :" + getActualRegisterAccountNo );

        Assert.assertEquals(getActualRegisterMobileNo, expectedMobileNo);
        Assert.assertEquals(getActualRegisterAccountNo, expectedAccountNo);

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON);


    }

    @Test
    public void editSelectedAccountNoWithCitizenIDSuccess(int selectedAccountNo, String expectedCitizenID, String expectedAccountNo )
            throws InterruptedException {
        //PromptPay List
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL);

        WebElement citizenIdCardLabel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_CITIZEN_ID_LABEL);
        String getCitizenIdLabel = citizenIdCardLabel.getText();

        Log.logger.info("Citizen ID Label  :" + " " + getCitizenIdLabel);

        Assert.assertEquals(getCitizenIdLabel, "Citizen ID Card");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_MOBILE_BUTTON);
        Thread.sleep(5000);

        Assert.assertEquals(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON).getText(), "Register");

        Assert.assertTrue(ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON).isDisplayed());

        WebElement citizenID_Button
                = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_CITIZEN_ID_BUTTON);
        citizenID_Button.click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL);
        WebElement selectAccountTitle = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL);
        String getSelectAccountTitleLabel = selectAccountTitle.getText();

        Assert.assertEquals(getSelectAccountTitleLabel, "Select an account to receive / transfer via mobile number");

        (new WebDriverWait(ttbTestContext.getDriver(), 30000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));

        //Select Account No.1st time
        currentSelectedAccountNo = registerPromptPaySelectAccountNo(1);

        //Confirm screen
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_MOBILE_LABEL);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CHANGE_ACCOUNT_NO_ICON);
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_COMFIRM_SIGNUP_CHANGE_ACCOUNT_NO_ICON).click();

        //Select new AccountNo
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_CITIZEN_ID_ACCOUNT_TO_REGISTER_LABEL);

        Assert.assertEquals(getSelectAccountTitleLabel, "Select an account to receive / transfer via mobile number");

        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));
        newSelectedAccountNo = editSelectedAccountNo(2);

        Assert.assertNotEquals(currentSelectedAccountNo, newSelectedAccountNo);

        //Success screen

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_TITLE);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_RESULT_REGISTER_LABEL);

        WebElement actualRegisteredCitizenID = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_CITIZEN_ID_VALUE);
        String getActualRegisterCitizenID= actualRegisteredCitizenID.getText();

        WebElement actualRegisteredAccountNo = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_ACCOUNT_NO_VALUE);
        String getActualRegisterAccountNo = actualRegisteredAccountNo.getText();

        Log.logger.info("Registered CitizenID :" + getActualRegisterCitizenID );
        Log.logger.info("Registered Account No. :" + getActualRegisterAccountNo );

        Assert.assertEquals(getActualRegisterCitizenID, expectedCitizenID);
        Assert.assertEquals(getActualRegisterAccountNo, expectedAccountNo);

        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SIGNUP_SUCCESS_SCREEN_DONE_BUTTON);

    }

    @Test
    public String registerPromptPaySelectAccountNo(int selectAccount){

        int selectedAccountNo = selectAccount;
        String selectedAccount ="";
        switch (selectedAccountNo){
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
        return selectedAccount;
    }

    @Test
    public String editSelectedAccountNo(int selectAccount){


        int selectedAccountNo = selectAccount;
        String editedAccountNo ="";

        switch (selectedAccountNo){
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
        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_PROMPTPAY_SELECT_ACCOUNT_NEXT_BUTTON).click();
        return editedAccountNo;
    }
}


