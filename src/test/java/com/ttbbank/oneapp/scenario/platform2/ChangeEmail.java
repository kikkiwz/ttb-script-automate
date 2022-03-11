package com.ttbbank.oneapp.scenario.platform2;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.tmb.automation.common.MongoDB;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.util.GetJsonData;
import com.tmb.automation.util.platform2.Common;
import com.tmb.automation.util.platform2.DateTime;
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
import java.util.List;

public class ChangeEmail extends BaseScenario {
    String newEmail = "";

    public enum CASES_TYPE {
        PASS,
        FAILED,
        ERROR
    }

    public String verifyChangeEmailMenu(String citizenId, String pin) throws InterruptedException {
        registerTtbTouch(citizenId, pin, null);
        System.err.println(citizenId+" = "+pin);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_MENU_MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_MENU_SETTING_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_MENU_SETTING_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON).click();
        return ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INPUT_TEXT).getText().toString();
    }

    public void validateChangeEmailUnsuccessful(String oldEmail) throws InterruptedException, IOException {
        boolean isScenario = true;
        String testCaseId = "0001";
        for (int i = 2; i < 31; i++) {
            if (i != 3 && i != 4 && i != 8 && i != 21 && i != 24) {
                testCaseId = (i < 10 ? "000" + i : "00" + i);
                verifyChangeEmail(isScenario, CASES_TYPE.FAILED, "TC_OneApp_11889_CC_update_email_" + testCaseId, oldEmail);
                isScenario = false;
            }
        }
    }

    public void validateUpdateEmailUnsuccessfulEmptyFlagN(boolean isScenario, String testCaseId) throws InterruptedException, IOException {
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement emailTxt = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_INPUT_TEXT);
        boolean isPass = emailTxt.getText().toLowerCase().equals(dataModel.ExpectedResultKey[0].toLowerCase());
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        Assert.assertTrue(isPass);
    }

    public void validateUpdateEmailUnsuccessful(boolean isScenario, String testCaseId) throws InterruptedException, IOException {
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OTP_CODE_1_TEXT).click();
//        Thread.sleep(1000);
        ttbTestContext.getDriver().getKeyboard().sendKeys("0000");
        ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL);
        WebElement tt = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL);
        System.err.println(tt.getText());
        boolean isPass = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL).getText().toLowerCase().equals(dataModel.ExpectedResultKey[1].toLowerCase());
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        Assert.assertTrue(isPass);
    }

    public void validateUpdateEmailUnsuccessfulAttemptLimitReached(boolean isScenario, String testCaseId) throws InterruptedException, IOException {
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OTP_CODE_1_TEXT).click();
        ttbTestContext.getDriver().getKeyboard().sendKeys("0000");
        Thread.sleep(1000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        Thread.sleep(1000);
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OTP_CODE_1_TEXT).click();
        ttbTestContext.getDriver().getKeyboard().sendKeys("1111");
        ttbTestContext = getTtbTestContext();
        Thread.sleep(1000);
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ATTEMPT_TITLE_LABEL);
        boolean isPass = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ATTEMPT_TITLE_LABEL).getText().toLowerCase().equals(dataModel.ExpectedResultKey[0].toLowerCase());
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ATTEMPT_OK_BUTTON).click();
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

    public void verifyResendCodeToUpdateEmailSuccessful(boolean isScenario, String testCaseId) throws InterruptedException, IOException {
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);

        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_SUBMIT_BUTTON).click();
        String pin = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.pin);
        confirmPIN(pin);
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

    public void verifyEmailOtpCodeToUpdateEmailSuccessful(boolean isScenario, String testCaseId) throws InterruptedException, IOException {
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_RESEND_VERIFICATION_CODE_BUTTON);
        WebElement verifyCode = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OTP_CODE_1_TEXT);
        verifyCode.click();
        ttbTestContext.getDriver().getKeyboard().sendKeys("8888");
        ttbTestContext.getDriver().hideKeyboard();

        WebElement msgTitle = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_TITLE_SUCCESS_LABEL);
        boolean isPass = msgTitle.getText().equals(dataModel.ExpectedResultKey[2]);
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OK_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OK_BUTTON).click();
        Assert.assertTrue(isPass);
        WebElement email = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_MENU_BUTTON);
        WebElement emailStatus = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_MENU_SETTING_CHANGE_EMAIL_STATUS_LABEL);
        Assert.assertTrue(email.getText().toLowerCase().equals(ChangeEmailScenario.emailChange.toLowerCase()));
        Assert.assertTrue(emailStatus.getText().toLowerCase().equals(dataModel.ExpectedResultKey[3].toLowerCase()));

    }

    public void validateEmailOtpCodeBackSuccessful(boolean isScenario, String testCaseId, String pin) throws InterruptedException, IOException {
        GenerateOtpTestCasesModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getUpdateEmail().get(testCaseId)), GenerateOtpTestCasesModel.class);
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_VERIFICATION_CODE_ฺBACK_BUTTON).click();
        WebElement submitBtn = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_SUBMIT_BUTTON);
        boolean isPass = submitBtn.getText().toLowerCase().equals(dataModel.ExpectedResultKey[0].toLowerCase());
        generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
        Assert.assertTrue(isPass);
        submitBtn.click();
        confirmPIN(pin);
    }

    public void verifyChangeEmail(boolean isScenario, CASES_TYPE casesType, String testCaseId, String oldEmail) throws IOException, InterruptedException {
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
                ChangeEmailScenario.emailChange = newEmail;
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
            case ERROR:
                ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_VERIFICATION_CODE_ฺBACK_BUTTON).click();
                ttbTestContext.waitUntilVisible(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_ERROR_VERIFICATION_CODE_LABEL);
                isPass = ttbTestContext.findElement(OneAppElementKeys.PLATFORM2_CHANGE_EMAIL_OK_BUTTON).getText().toLowerCase().equals(dataModel.ExpectedResultKey[0].toLowerCase());
                generateReport(isScenario, isPass, dataModel.ScenarioName, dataModel.Description, Arrays.toString(dataModel.ExpectedResult));
                Assert.assertTrue(isPass);
                break;
        }
    }

    private void generateReport(boolean isScenario, boolean isPass, String scenarioName, String testcasesName, String expectedResult) throws IOException {
        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        if (isScenario) {
            String platformName = (String) ttbTestContext.getDriver().getCapabilities().getCapability(DeviceProfile.platformName);
            ExtentListeners.setDriver(ttbTestContext.getDriver());
            ExtentReports extentReports = new ExtentReports();
            ExtentReporter extentReporter = new ExtentHtmlReporter("reports/platform2/" + platformName + "_change_email_" + date + ".html");
            extentReports.attachReporter(extentReporter);
            ExtentTest feature = extentReports.createTest(scenarioName);
            setFeature(feature);
            setExtentReports(extentReports);
        }
        ExtentTest scenario = getFeature().createNode(Scenario.class, testcasesName);
        String dateImage = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String protectionActivateApp = "images/platform2/platform2_" + dateImage + ".png";
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

    private void verifyLogs() throws InterruptedException {
//        Long startTime = DateTime.getStartTime();
//        Thread.sleep(200);
//        MongoDB mongoDB = new MongoDB();
//        BasicDBObject query = new BasicDBObject();
//        query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject(Setting.MongoDbLogsKey.KEY_EQUAL, loginModel.TestData.body.username));
//        query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject(Setting.MongoDbLogsKey.KEY_EQUAL, loginModel.MongoDBLogs[0].activity_type_id));
//        List listData = mongoDB.connectDB(Setting.mongoEmployeeClientUrl, Setting.mongoEmployeeDatabaseName, Setting.mongoEmployeeCollectionName, query, Setting.mongoEmployeeSortsByColumn, Setting.MONGO_LIMIT);
//
//        LogsEmployeeModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LogsEmployeeModel.class);
//        Assert.assertTrue(logsData.activity_status.toUpperCase().equals(Setting.LOGS_ACTIVITY_STATUS.SUCCESS.toString()));
//        Assert.assertTrue(logsData.activity_type_id.equals(loginModel.MongoDBLogs[0].activity_type_id));
//        Assert.assertTrue(logsData.agent_id.equals(Setting.USER_ID));
//        for (int i = 0; i < loginModel.MongoDBLogs.length; i++) {
//            Assert.assertTrue(logsData.activitydescription[i].flex.toString().toLowerCase().equals(loginModel.MongoDBLogs[0].activitydescription[i].flex.toString().toLowerCase()));
//        }
//        Assert.assertTrue(DateTime.isLogsTime(startTime, DateTime.getEndTime(logsData.activity_date.$numberLong), Setting.LOGS_ACTIVITY_DATE_MIN));

    }
}
