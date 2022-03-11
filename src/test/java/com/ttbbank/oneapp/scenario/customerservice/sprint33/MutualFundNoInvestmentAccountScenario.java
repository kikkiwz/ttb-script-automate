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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResults;
import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResultsReport;
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.formatPortFolio;

public class MutualFundNoInvestmentAccountScenario extends BaseScenario {
    TmbServiceResponse<ViewPassbookResponse> response = null;
    ExtentTest scenario = null;
    @Test(priority = 0, groups = "Customer Service Mutual Fund don't have investment account", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);
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

        scenario = getFeature().createNode(Scenario.class, "Mutual Fund Passbook in case don't have investment account");
        String Service = "images/MutualFundNoInvestmentAccount_ServiceScreen_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(Service);
        scenario.createNode(Given.class, "Service screen").addScreenCaptureFromPath(Service).pass("Pass");
        initToken();
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("service_type_id", "EPB");
        Map<String, String> eqParamsHeader = new HashMap<>();
        eqParamsHeader.put("device-id", "FUzgnbIP/aegKo+se+1gkXhF9R3bWuIut4LF/TQyZUk1OvBUOeGZn0caYN3Lznn07USdt9JMmVyv1whHNTe40fHUBR5E8k+o7rh3byBLDJY9MY21UFv3p4iTLLSveC8WoavayzQvzSW2/i2AIpAEqhbm2N/8noU522mx7Rr6hnd8PQ0doeVvS2vBkeK9fJRuUVPUjd4CEdUDVAscz15fCuDFmIS6Gp3gAZ+gt2uLZIMtuiayQvVm9CuX+rKskZZOJCftpG3V6J7SYG1Y5mxKUbp+pZvEt1BxAlknGS/WoyyHl3COFALHlOD0rhb8k0RsnAwBljai7kADM+WaMgj4hg==");
        response = client.get("/apis/customer/viewVirtualPassbook", eqParams, ViewPassbookResponse.class, eqParamsHeader);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        WebElement virtualPassbook = ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        virtualPassbook.click();
        try{
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

            String tutorial = "images/MutualFundPassbook_TutorialPassBook_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            CheckResultsReport(scenario.createNode(Given.class, "When customer first time usage. The system navigate to Tutorial Passbook Screen").addScreenCaptureFromPath(tutorial), result);

            btnStart.click();

            Assert.assertTrue(elTitleTutorial.equals("Passbook Cover"));
            Assert.assertTrue(elTutorialDetail.equals("Convenient any transactions with your passbook cover right on your smartphone."));
            Assert.assertTrue(elBtnStart.equals("Start"));
        }catch (Exception e){
            String tutorial = "images/MutualFundPassbook_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            scenario.createNode(Given.class, "If the customer has already logged in for the first time, the system navigate to select account mutual screen without going through tutorial screen.").addScreenCaptureFromPath(tutorial).pass("Pass");
        }
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passbook-account-list-header-label']")));
        WebElement TitlePassBook = ttbTestContext.findElement(OneAppElementKeys.TITLE_PASSBOOK_SELECT_ACCOUNT_SCREEN);
        String elTitlePassBook = TitlePassBook.getText();
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_MUTUAL_FUND_SELECT_ACCOUNT_SCREEN, true);
        System.err.println("elTitlePassBook : " + elTitlePassBook);

        try{
            (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mutual_fund_passbook_account_list_title_label']")));
            WebElement TitleMutualFund = ttbTestContext.findElement(OneAppElementKeys.LABEL_MUTUAL_FUND_SELECT_ACCOUNT_SCREEN);
            String elTitleMutualFund = TitleMutualFund.getText();
            WebElement BtnView = ttbTestContext.findElement(OneAppElementKeys.NEXT_BUTTON_SELECT_MUTUAL_FUND_LIST);
            String elBtnView = BtnView.getText();

            String tutorial = "images/MutualFundNoInvestmentAccount_ServiceScreen_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            scenario.createNode(Given.class, "The system shouldn't display investment account").addScreenCaptureFromPath(Service).pass("Fail");

            System.err.println("elTitleMutualFund : " + elTitleMutualFund);
            System.err.println("elBtnView : " + elBtnView);
        }catch (Exception e){
            String MutualFundList = "images/MutualFundNoInvestmentAccount_SelectMutualFund_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(MutualFundList);
            scenario.createNode(Given.class, "The system isn't display investment account").addScreenCaptureFromPath(MutualFundList).pass("Pass");

            getExtent().flush();
        }

    }
}
