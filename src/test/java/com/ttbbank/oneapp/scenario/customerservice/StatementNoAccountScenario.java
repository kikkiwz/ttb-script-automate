package com.ttbbank.oneapp.scenario.customerservice;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.accountSaving.SavingResponse;
import com.ttbbank.oneapp.framework.model.customerservice.deposit.DepositResponse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResults;

public class StatementNoAccountScenario extends BaseScenario {
    TmbServiceResponse<SavingResponse> responseSaving = null;
    ExtentTest scenario = null;
    @Test(groups = "Customer Service Statement", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void Statement() throws InterruptedException, IOException {
        testcase01();
    }

    public void testcase01() throws IOException, InterruptedException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        scenario = getFeature().createNode(Scenario.class, "Statement have not account");
        String StatementStart = "images/VirtualPassbookNoAcc_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(StatementStart);
        scenario.createNode(Given.class, "Service screen").addScreenCaptureFromPath(StatementStart).pass("Pass");

        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
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
        } else {
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        initToken();
        Map<String, String> eqParamsSaving = new HashMap<>();
        eqParamsSaving.put("", "");
        OneAppClient client = getOneAppClient();
        responseSaving = client.get("/apis/customer/accounts/saving", eqParamsSaving, SavingResponse.class);
        System.out.println("responseSaving : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(responseSaving));
        WebElement statementServiceButton = ttbTestContext.findElement(OneAppElementKeys.STATEMENT_SERVICE_BUTTON);
        statementServiceButton.click();
        WebElement TitleNoAccount = ttbTestContext.findElement(OneAppElementKeys.TITLE_PASSBOOK_NO_ACCOUNT_SCREEN);
        String elTitleNoAccount = TitleNoAccount.getText();
        WebElement labelNoAccount = ttbTestContext.findElement(OneAppElementKeys.LABEL_NO_ACCOUNT_SCREEN);
        String elLabelDepositAccount = labelNoAccount.getText();
        WebElement contentNoAccount = ttbTestContext.findElement(OneAppElementKeys.CONTENT_NO_ACCOUNT_SCREEN);
        String elContentNoAccount = contentNoAccount.getText();

        System.out.println("elTitleNoAccount : " + elTitleNoAccount);
        System.out.println("elLabelDepositAccount : " + elLabelDepositAccount);
        System.out.println("elContentNoAccount : " + elContentNoAccount);

        String result = "";
        result = CheckResults(elTitleNoAccount, "Statement", result);
        result = CheckResults(elLabelDepositAccount, "You don’t have TTB account", result);
        result = CheckResults(elContentNoAccount, "If you have account with ttb you can download or share passbook from here", result);

        String tutorial = "images/StatementNoAccount_Tutorial_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(tutorial);
        scenario.createNode(Given.class, "If the customer has not an account, The system display empty statement screen").addScreenCaptureFromPath(tutorial).pass(result);

        Assert.assertTrue(elTitleNoAccount.equals("Statement"));
        Assert.assertTrue(elLabelDepositAccount.equals("You don’t have TTB account"));
        Assert.assertTrue(elContentNoAccount.equals("If you have account with ttb you can download or share passbook from here"));
        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BTN_NO_ACC_PASSBOOK_SCREEN).click();
    }
}
