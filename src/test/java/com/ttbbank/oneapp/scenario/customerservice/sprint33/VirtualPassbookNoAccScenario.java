package com.ttbbank.oneapp.scenario.customerservice.sprint33;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.ViewPassbookResponse;
import com.ttbbank.oneapp.framework.model.customerservice.accountSaving.SavingResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResults;
import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResultsReport;
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.formatAccount;

public class VirtualPassbookNoAccScenario extends BaseScenario {
    TmbServiceResponse<ViewPassbookResponse> response = null;
    TmbServiceResponse<SavingResponse> responseSaving = null;
    ExtentTest scenario = null;
    @Test(priority = 0, groups = "Customer Service Passbook", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);

        scenario = getFeature().createNode(Scenario.class, "Virtual Passbook have not account");
        String PassbookStart = "images/VirtualPassbookNoAcc_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(PassbookStart);
        scenario.createNode(Given.class, "Select Mutual Fund list Screen. The system should display all of Mutual Fund sorted by Portfolio Code in ascending order.").addScreenCaptureFromPath(PassbookStart).pass("Pass");

        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        } else {
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        initToken();
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("service_type_id", "EPB");
        Map<String, String> eqParamsHeader = new HashMap<>();
        eqParamsHeader.put("device-id", "FUzgnbIP/aegKo+se+1gkXhF9R3bWuIut4LF/TQyZUk1OvBUOeGZn0caYN3Lznn07USdt9JMmVyv1whHNTe40fHUBR5E8k+o7rh3byBLDJY9MY21UFv3p4iTLLSveC8WoavayzQvzSW2/i2AIpAEqhbm2N/8noU522mx7Rr6hnd8PQ0doeVvS2vBkeK9fJRuUVPUjd4CEdUDVAscz15fCuDFmIS6Gp3gAZ+gt2uLZIMtuiayQvVm9CuX+rKskZZOJCftpG3V6J7SYG1Y5mxKUbp+pZvEt1BxAlknGS/WoyyHl3COFALHlOD0rhb8k0RsnAwBljai7kADM+WaMgj4hg==");
        response = client.get("/apis/customer/viewVirtualPassbook", eqParams, ViewPassbookResponse.class, eqParamsHeader);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        Map<String, String> eqParamsSaving = new HashMap<>();
        eqParamsSaving.put("", "");
        responseSaving = client.get("/apis/customer/accounts/saving", eqParams, SavingResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        WebElement virtualPassbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        virtualPassbook.click();
        try {
            WebElement titleTutorial = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
            String elTitleTutorial = titleTutorial.getText();
            WebElement tutorialDetail = ttbTestContext.findElement(OneAppElementKeys.TUTORIAL_DETAIL_SCREEN_VIRTUAL_PASSBOOK);
            String elTutorialDetail = tutorialDetail.getText();
            WebElement btnStart = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_VIRTUAL_PASSBOOK);
            String elBtnStart = btnStart.getText();

            String result = "";
            result = CheckResults(elTitleTutorial, "Passbook Cover", result);
            result = CheckResults(elTutorialDetail, "Convenient any transactions with your passbook cover right on your smartphone.", result);
            result = CheckResults(elBtnStart, "Start", result);

            System.out.println("elTitleTutorial : " + elTitleTutorial);
            System.out.println("elTutorialDetail : " + elTutorialDetail);
            System.out.println("elBtnStart : " + elBtnStart);
            Thread.sleep(5000);
            String tutorial = "images/VirtualPassbookNoAccount_Tutorial_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            CheckResultsReport(scenario.createNode(Given.class, "If the customer has first time usage, The system navigate to tutorial Passbook Screen").addScreenCaptureFromPath(tutorial), result);
            btnStart.click();

            Assert.assertTrue(elTitleTutorial.equals("Passbook Cover"));
            Assert.assertTrue(elTutorialDetail.equals("Convenient any transactions with your passbook cover right on your smartphone."));
            Assert.assertTrue(elBtnStart.equals("Start"));
        } catch (Exception e){
            String tutorial = "images/VirtualPassbookNoAccount_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            scenario.createNode(Given.class, "If the customer has already first time usage, The system navigate to select the account screen without going through tutorial screen.").addScreenCaptureFromPath(tutorial).pass("Pass");
        }

    }

    @Test(priority = 2, groups = "Customer Service no account")
    public void TC_ONEAPP_10582_PB_00001() throws Exception {
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passbook-no-account-header-label']")));
        WebElement TitleNoAccount = ttbTestContext.findElement(OneAppElementKeys.TITLE_PASSBOOK_NO_ACCOUNT_SCREEN);
        String elTitleNoAccount = TitleNoAccount.getText();
        WebElement labelNoAccount = ttbTestContext.findElement(OneAppElementKeys.LABEL_NO_ACCOUNT_SCREEN);
        String elLabelDepositAccount = labelNoAccount.getText();
        WebElement contentNoAccount = ttbTestContext.findElement(OneAppElementKeys.CONTENT_NO_ACCOUNT_SCREEN);
        String elContentNoAccount = contentNoAccount.getText();
        WebElement btnBack = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BTN_NO_ACC_PASSBOOK_SCREEN);

        System.err.println("elTitleNoAccount : " + elTitleNoAccount);
        System.err.println("elLabelDepositAccount : " + elLabelDepositAccount);
        System.err.println("elContentNoAccount : " + elContentNoAccount);

        String result = "";
        result = CheckResults(elTitleNoAccount, "Passbook Cover", result);
        result = CheckResults(elLabelDepositAccount, "Cannot Find Your Passbook Cover", result);
        result = CheckResults(elContentNoAccount, "Since you do not currently have a savings account with ttb.", result);

        String tutorial = "images/VirtualPassbookNoAccount_Tutorial_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(tutorial);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer has not an account, The system display empty passbook screen").addScreenCaptureFromPath(tutorial), result);

        btnBack.click();

        Assert.assertTrue(elTitleNoAccount.equals("Passbook Cover"));
        Assert.assertTrue(elLabelDepositAccount.equals("Cannot Find Your Passbook Cover"));
        Assert.assertTrue(elContentNoAccount.equals("Since you do not currently have a savings account with ttb."));
    }
}
