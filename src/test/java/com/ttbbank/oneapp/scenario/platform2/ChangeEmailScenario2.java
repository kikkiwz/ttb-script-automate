package com.ttbbank.oneapp.scenario.platform2;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.Gson;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.util.GetJsonData;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.DeviceProfile;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.model.platform2.GenerateOtpTestCasesModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ChangeEmailScenario2 extends BaseScenario {
    String newEmail = "";
    String oldEmail = "";

    enum CASES_TYPE {
        PASS,
        FAILED,
        ERROR
    }

    public void registerTtbTouch() throws InterruptedException {
        String citizenId = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.citizenId);
        registerTtbTouch(citizenId, "135795", null);
    }


    @Parameters({"citizenId","pin","scenarioTestName","scenarioType"})
    @Test(groups = "verifyChangeEmailMenu", priority = 1)
    public void verifyChangeEmailMenu() throws InterruptedException {
        registerTtbTouch();
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_MENU_MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_MENU_SETTING_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_MENU_SETTING_BUTTON).click();
        String pin = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.pin);
//        enterPIN(pin);


//        ttbTestContext.setContextToWebView(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON,true);

        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON).click();

        oldEmail = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INPUT_TEXT).getText().toString();
    }

    @Test(groups = "validateChangeEmailUnsuccessful", priority = 2)
    public void validateChangeEmailUnsuccessful() throws InterruptedException, IOException {
        boolean isScenario = true;
        String testCaseId = "0001";
        for (int i = 2; i < 31; i++) {
            if (i != 3 && i != 4 && i != 8 && i != 21 && i != 24) {
                testCaseId = (i < 10 ? "000" + i : "00" + i);
                verifyChangeEmail(isScenario, CASES_TYPE.FAILED, "TC_OneApp_11889_CC_update_email_" + testCaseId);
                isScenario = false;
            }
        }
    }

    @Test(groups = "verifyChangeEmailSuccess", priority = 3)
    public void verifyChangeEmailSuccess() throws InterruptedException, IOException {
        verifyChangeEmail(true, CASES_TYPE.PASS, "TC_OneApp_11889_CC_update_email_0001");
    }

    @Test(groups = "validateUpdateEmailUnsuccessful", priority = 4)
    public void validateUpdateEmailUnsuccessful() throws InterruptedException, IOException {
        boolean isScenario = false;
        String testCaseId = "TC_OneApp_11889_CC_update_email_0032";
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        ttbTestContext.getDriver().getKeyboard().sendKeys("0000");
        ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL);
        boolean isPass = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL).getText().toLowerCase().equals(dataModel.ExpectedResultKey[1].toLowerCase());
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        Assert.assertTrue(isPass);
    }

    public boolean isClickable(WebElement el, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test(groups = "verifyResendCodeToUpdateEmailSuccessful", priority = 5)
    public void verifyResendCodeToUpdateEmailSuccessful() throws InterruptedException, IOException {
        boolean isScenario = false;
        String testCaseId = "TC_OneApp_11889_CC_update_email_0033";
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        System.err.println(ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON).getText());
        boolean isPass = !ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON).isEnabled();
        /**
         * Wait 60 seconds for Enable Resend code button
         */
        Thread.sleep(55000);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        isPass = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON).isEnabled();
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        System.err.println(" 0 = " + ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON).isEnabled());
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON).click();
        ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        isPass = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON).isEnabled();
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        Assert.assertTrue(isPass);
    }

    @Test(groups = "verifyEmailOtpCodeToUpdateEmailSuccessful", priority = 6)
    public void verifyEmailOtpCodeToUpdateEmailSuccessful() throws InterruptedException, IOException {
        boolean isScenario = false;
        String testCaseId = "TC_OneApp_11889_CC_update_email_0034";
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        WebElement verifyCode = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_ONE_DIGIT_TEXT);
        verifyCode.click();
        ttbTestContext.getDriver().getKeyboard().sendKeys("8888");
        ttbTestContext.getDriver().hideKeyboard();

        WebElement msgTitle = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_TITLE_SUCCESS_LABEL);
        boolean isPass = msgTitle.getText().equals(dataModel.ExpectedResultKey[2]);
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OK_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OK_BUTTON).click();
        Assert.assertTrue(isPass);
    }

    private void verifyChangeEmail(boolean isScenario, CASES_TYPE casesType, String testCaseId) throws IOException, InterruptedException {
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        TtbTestContext ttbTestContext = getTtbTestContext();
        if (dataModel.IsSkip) {
            generateReport(isScenario, true, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
            return;
        }
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INPUT_TEXT);
        WebElement emailTxt = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INPUT_TEXT);
        emailTxt.clear();
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INFORMATION_DESC_LABEL);
        System.err.println(testCaseId);
        boolean isPass = false;
        switch (casesType) {
            case PASS:
                String postfix = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                newEmail = "qa.at." + postfix + "@tcs.com";
                emailTxt.sendKeys(newEmail);
                ttbTestContext.getDriver().hideKeyboard();
                ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INFORMATION_DESC_LABEL).click();
                isPass = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_INFORMATION_LABEL).getText().toLowerCase().equals(dataModel.ExpectedResultKey[1].toLowerCase());
                generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
                Assert.assertTrue(isPass);
                ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_SUBMIT_BUTTON).click();
                String pin = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.pin);
                confirmPIN(pin);
                generateReport(false, true, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
                break;
            case FAILED:
                if (testCaseId.equals("TC_OneApp_11889_CC_update_email_0009")) {
                    dataModel.TestData.body.new_email = oldEmail;
                }
                System.err.println(dataModel.TestData.body.new_email);
                emailTxt.sendKeys(dataModel.TestData.body.new_email);
                ttbTestContext.getDriver().hideKeyboard();
                ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INFORMATION_DESC_LABEL).click();
                ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_SUBMIT_BUTTON).click();
                isPass = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_INFORMATION_LABEL).getText().toLowerCase().equals(dataModel.ExpectedResultKey[1].toLowerCase());
                generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
                Assert.assertTrue(isPass);
                break;
        }
    }

    private void generateReport(boolean isScenario, boolean isPass, String scenarioName, String testcasesName, String expectedResult) throws IOException {
        if (isScenario) {
            String platformName = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.platformName);
            ExtentListeners.setDriver(ttbTestContext.getDriver());
            ExtentReports extentReports = new ExtentReports();
            ExtentReporter extentReporter = new ExtentHtmlReporter("reports/platform2/" + platformName + "_change_email_"+scenarioName+".html");
            extentReports.attachReporter(extentReporter);
            ExtentTest feature = extentReports.createTest(scenarioName);
            setFeature(feature);
            setExtentReports(extentReports);
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, testcasesName);
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String protectionActivateApp = "images/platform2/platform2_" + date + ".png";
        takeScreenshot(protectionActivateApp);
        protectionActivateApp = "../" + protectionActivateApp;
        scenario.createNode(Given.class, "Expected Result: <br>" + expectedResult).info("PASS");
        if (isPass) {
            scenario.createNode(Given.class, "Actual Result: PASS").addScreenCaptureFromPath(protectionActivateApp).pass("PASS");
        } else {
            scenario.createNode(Given.class, "Actual Result: FAILED").addScreenCaptureFromPath(protectionActivateApp).fail("FAILED");
        }
        getExtent().flush();
    }
}
