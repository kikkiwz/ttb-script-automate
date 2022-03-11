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
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class ChangeEmailScenario extends ChangeEmail {
    String oldEmail = "";
    public static String emailChange = "";
    @Parameters({"citizenId", "pin", "scenarioTestName", "scenarioType"})
    @Test(groups = "verifyChangeEmailMenu", priority = 1)
    public void verifyChangeEmailMenu(String citizenId, String pin, String scenarioTestName, String scenarioType) throws InterruptedException {
        oldEmail = verifyChangeEmailMenu(citizenId, pin);
    }

//    @Test(groups = "validateChangeEmailUnsuccessful", priority = 2)
//    public void validateChangeEmailUnsuccessful() throws InterruptedException, IOException {
//        validateChangeEmailUnsuccessful(oldEmail);
//    }

    @Test(groups = "verifyChangeEmailSuccess", priority = 3)
    public void verifyChangeEmailSuccess() throws InterruptedException, IOException {
        verifyChangeEmail(true, ChangeEmail.CASES_TYPE.PASS, "TC_OneApp_11889_CC_update_email_0001", oldEmail);
    }

    @Parameters({"pin"})
    @Test(groups = "validateEmailOtpCodeBackSuccessful", priority = 4)
    public void validateEmailOtpCodeBackSuccessful(String pin) throws InterruptedException, IOException {
        String testCaseId = "TC_OneApp_11889_CC_update_email_0075";
        validateEmailOtpCodeBackSuccessful(false, testCaseId,pin);
    }

    @Test(groups = "validateUpdateEmailUnsuccessful", priority = 5)
    public void validateUpdateEmailUnsuccessful() throws InterruptedException, IOException {
        String testCaseId = "TC_OneApp_11889_CC_update_email_0032";
        validateUpdateEmailUnsuccessful(false, testCaseId);
    }

    @Test(groups = "validateUpdateEmailUnsuccessfulAttemptLimitReached", priority = 6)
    public void validateUpdateEmailUnsuccessfulAttemptLimitReached() throws InterruptedException, IOException {
        String testCaseId = "TC_OneApp_11889_CC_update_email_0074";
        validateUpdateEmailUnsuccessfulAttemptLimitReached(false, testCaseId);
    }

    @Test(groups = "verifyResendCodeToUpdateEmailSuccessful", priority = 7)
    public void verifyResendCodeToUpdateEmailSuccessful() throws InterruptedException, IOException {
        String testCaseId = "TC_OneApp_11889_CC_update_email_0033";
        verifyResendCodeToUpdateEmailSuccessful(false, testCaseId);
    }

    @Test(groups = "verifyEmailOtpCodeToUpdateEmailSuccessful", priority = 8)
    public void verifyEmailOtpCodeToUpdateEmailSuccessful() throws InterruptedException, IOException {
        String testCaseId = "TC_OneApp_11889_CC_update_email_0034";
        verifyEmailOtpCodeToUpdateEmailSuccessful(false, testCaseId);
    }

}
