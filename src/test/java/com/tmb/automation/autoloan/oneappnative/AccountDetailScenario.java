package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import org.testng.annotations.Test;
import java.io.IOException;

public class AccountDetailScenario extends AutoLoanBase {


    @Test(groups = "accountDetail")
    public void showAccountDetail() throws IOException, InterruptedException {
        ExtentTest scenario = feature.createNode(Scenario.class, "Show Account Detail");
//        waitHomeScreenVisible();
        Thread.sleep(30000);
        scenario.createNode(Given.class, "Tap Service Menu for entering Auto Loan").pass("pass");
        openEntryMenu();
        enterPin();
        scenario.createNode(Given.class, "Enter PIN after entering Service Menu").pass("pass");
        enterAutoLoan();
        scenario.createNode(Given.class, "Enter Auto Loan Menu").pass("pass");
        String accountDetailFileName = "images/account_detail_" + getPlatform() + ".png";
        takeScreenshot(accountDetailFileName);
        scenario.createNode(Given.class, "Shows Auto Loan Account Detail Screen").addScreenCaptureFromPath(accountDetailFileName).pass("pass");
        extent.flush();
    }


}
