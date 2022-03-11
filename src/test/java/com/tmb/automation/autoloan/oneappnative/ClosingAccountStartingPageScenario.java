package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.gherkin.model.Then;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClosingAccountStartingPageScenario extends ServiceRequestListScenario {
    @Test(groups = "Closing Account" ,dependsOnGroups = "serviceRequest")
    public void closingAccount() throws InterruptedException, IOException {
        ExtentTest  scenario = feature.createNode(Scenario.class, "ClosingAccount");
        Thread.sleep(3000);
        enterClosingAccount();
        String ClosingAccount = "image/closing_account_screen"+getPlatform()+".png";
        Thread.sleep(3000);
        takeScreenshot(ClosingAccount);
        scenario.createNode(Given.class,"Open Close Account service").addScreenCaptureFromPath(ClosingAccount).pass("pass");
        tapNext();
        Thread.sleep(1500);
        String AccountDetailforCloseAccout = "image/Acc_Detail_for_close"+getPlatform()+".png";
        takeScreenshot(AccountDetailforCloseAccout);
        scenario.createNode(Given.class,"Open Account Detail For Close Account").addScreenCaptureFromPath(AccountDetailforCloseAccout).pass("pass");
        tapAddEmail();
        Thread.sleep(1500);
        String editEmailScreen = "image/Edit_Email_Screen"+getPlatform()+".png";
        takeScreenshot(editEmailScreen);
        scenario.createNode(Given.class,"Open Edit email screen").addScreenCaptureFromPath(editEmailScreen).pass("pass");
        inputInvalidEmail();
        Thread.sleep(500);
        tapSaveEmail();
        String enterInvalidEmail = "image/Enter_invalid_key"+getPlatform()+".png";
        takeScreenshot(enterInvalidEmail);
        scenario.createNode(Given.class,"Enter Email invalid format").addScreenCaptureFromPath(enterInvalidEmail).pass("pass");
        inputValidEmail();
        Thread.sleep(500);
        String enterValidKey = "image/Enter_valid_email"+getPlatform()+".png";
        scenario.createNode(Given.class,"Enter valid Email").addScreenCaptureFromPath(enterValidKey).pass("pass");
        tapSaveEmail();
        Thread.sleep(300);
        String accDetailEmailvalid = "image/Account_Detail_valid"+getPlatform()+".png";
        takeScreenshot(accDetailEmailvalid);
        scenario.createNode(Given.class,"Save Valid Email").addScreenCaptureFromPath(accDetailEmailvalid).pass("pass");
        tapNext();
        Thread.sleep(1000);
        String selectMethodScreen = "image/Select_Method_Screen"+getPlatform()+".png";
        takeScreenshot(selectMethodScreen);
        scenario.createNode(Given.class,"Select Method Screen").addScreenCaptureFromPath(selectMethodScreen).pass("pass");
        extent.flush();

    }
}
