package com.ttbbank.oneapp.scenario.customerservice.sprint34;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.CST_status.statusResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.ConvertDate;

public class CaseTrackingNoListScenario extends BaseScenario {
    TmbServiceResponse<statusResponse> response = null;
    ExtentTest scenario = null;

    @Test(priority = 0, groups = "Customer Service Case Tracking", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);

        scenario = getFeature().createNode(Scenario.class, "Customer does not have a case status for tracking");
        String CaseTracking_ServiceScreen = "images/CaseTrackingNoList_ServiceScreen_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CaseTracking_ServiceScreen);
        scenario.createNode(Given.class, "Service Screen").addScreenCaptureFromPath(CaseTracking_ServiceScreen).pass("Pass");

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
        eqParams.put("service_type_id", "CST");
        Map<String, String> eqParamsHeader = new HashMap<>();
        eqParamsHeader.put("device-id", "d9iCqhAiMJ5C0vlvbxhYm6r2Uqd5/oJH2bL3uvDVWzCFhF0TC2Apgjb5al/WumSnYJA+LhFHnWSvieshXE1GxkRKtvusWmAMkmo3P6CGG2x7YdxreMJJp1gebudmq3v6vqeih9fFGqvJzdVvbguxp0yEPBHBzEXg2v2IOX9njYia53LpYhjH0VmUyyjSdDjwuIdr77vNQNiRCBpGRhHy9oahLWb/aUCh85sh3ax3MGwwouTNGW/iCzW1f5fTjG6ccL8rxx2T8+m3GsgC28IokKUfc8AUcIOhmpBsCbv0dwbeQRnRZLYhwTo7JPm/Ggp51CKeoxUS+4xA6ri6yF5OtQ==");
        response = client.get("/apis/products/case/status", eqParams, statusResponse.class, eqParamsHeader);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));

        WebElement tabStatusTracking = ttbTestContext.findElement(OneAppElementKeys.TAB_STATUS_TRACKING);
        tabStatusTracking.click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"cs_case_case_tracking_label_id\")]")));

        WebElement caseTrackingMenu = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        String elCaseTrackingMenu = caseTrackingMenu.getText();
        String result = "";
        result = CheckResults(elCaseTrackingMenu, "Request/Complaint Tracking", result);
        String ServiceScreen_TabStatusTracing = "images/CaseTrackingNoList_ServiceScreen_TabStatusTracing_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(ServiceScreen_TabStatusTracing);
        CheckResultsReport(scenario.createNode(Given.class, "Service Screen tab status tracking").addScreenCaptureFromPath(ServiceScreen_TabStatusTracing), result);

        caseTrackingMenu.click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        try {
            (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"label_customerservice_case_tracking_title_tutorial\")]")));
            WebElement titleTutorial = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_CASE_TRACKING);
            String elTitleTutorial = titleTutorial.getText();
            WebElement tutorialDetail = ttbTestContext.findElement(OneAppElementKeys.DETAIL_TUTORIAL_SCREEN_CASE_TRACKING);
            String elTutorialDetail = tutorialDetail.getText();
            WebElement btnStart = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_CASE_TRACKING);
            String elBtnStart = btnStart.getText();

            System.out.println("elTitleTutorial : " + elTitleTutorial);
            System.out.println("elTutorialDetail : " + elTutorialDetail);
            System.out.println("elBtnStart : " + elBtnStart);

            result = "";
            result = CheckResults(elTitleTutorial, "Request/Complaint Tracking", result);
            result = CheckResults(elTutorialDetail, "Why call the Contact Center when you can track your request/complaint status by yourself.", result);
            result = CheckResults(elBtnStart, "Start", result);

            Thread.sleep(5000);
            String tutorial = "images/CaseTrackingNoList_Tutorial_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            CheckResultsReport(scenario.createNode(Given.class, "Tutorial Case Tracking Screen").addScreenCaptureFromPath(tutorial), result);
            btnStart.click();

            WebElement labelInprogress = ttbTestContext.findElement(OneAppElementKeys.LABEL_IN_PROGRESS);
            String elLabelInprogress = labelInprogress.getText();
            result = "";
            result = CheckResults(elLabelInprogress, "In Progress", result);

            String CaseTrackingList = "images/CaseTrackingNoList_CaseTrackingList_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(CaseTrackingList);
            CheckResultsReport(scenario.createNode(Given.class, "Case Tracking List").addScreenCaptureFromPath(CaseTrackingList), result);

            ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_SCREEN_CASE_TRACKING_DETAIL_SCREEN).click();

            WebElement caseTrackingMenu2 = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
            String elCaseTrackingMenu2 = caseTrackingMenu2.getText();
            result = "";
            result = CheckResults(elCaseTrackingMenu2, "Request/Complaint Tracking", result);
            String BackToService = "images/CaseTracking_BackToService_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(BackToService);
            CheckResultsReport(scenario.createNode(Given.class, "If the customer click back icon, the system navigate to service screen.").addScreenCaptureFromPath(BackToService), result);

            caseTrackingMenu2.click();
            WebElement detailNoList = ttbTestContext.findElement(OneAppElementKeys.DETAIL_CASE_TRACKING_NO_LIST_SCREEN);
            String elDetailNoList = detailNoList.getText();
            result = "";
            result = CheckResults(elDetailNoList, "You don't have any service request or complaint issue.", result);

            String secondTimeCaseTracking = "images/CaseTrackingNoList_secondTimeCaseTracking_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(secondTimeCaseTracking);
            CheckResultsReport(scenario.createNode(Given.class, "(If access case tracking on second time then system will skip tutorial screen) go to case tracking list screen").addScreenCaptureFromPath(secondTimeCaseTracking), result);

            Assert.assertTrue(elTitleTutorial.equals("Request/Complaint Tracking"));
            Assert.assertTrue(elTutorialDetail.equals("Why call the Contact Center when you can track your request/complaint status by yourself."));
            Assert.assertTrue(elBtnStart.equals("Start"));
        } catch (Exception e) {
            String SkipTutorial = "images/CaseTrackingNoList_SkipTutorial_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(SkipTutorial);
            scenario.createNode(Given.class, "If the customer has already logged in for the first time, the system navigate to case tracking screen without going through tutorial screen.").addScreenCaptureFromPath(SkipTutorial).pass("Pass");
        }
    }


    @Test(priority = 1, groups = "Customer Service case tracking no list")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement titleCaseTrackingList = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_CASE_TRACKING_NO_LIST_SCREEN);
        String elTitleCaseTrackingList = titleCaseTrackingList.getText();
        WebElement detailNoList = ttbTestContext.findElement(OneAppElementKeys.DETAIL_CASE_TRACKING_NO_LIST_SCREEN);
        String elDetailNoList = detailNoList.getText();

        String result = "";
        result = CheckResults(elTitleCaseTrackingList, "Request/Complaint Tracking", result);
        result = CheckResults(elDetailNoList, "You don't have any service request or complaint issue.", result);

        String SkipTutorial = "images/CaseTrackingNoList_SkipTutorial_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(SkipTutorial);
        CheckResultsReport(scenario.createNode(Given.class, "Customer does not have a case status for tracking").addScreenCaptureFromPath(SkipTutorial), result);

        System.err.println("elTitleCaseTrackingList : " + elTitleCaseTrackingList);
        System.err.println("elDetailNoList : " + elDetailNoList);

        Assert.assertTrue(elDetailNoList.equals("You don't have any service request or complaint issue."));
        Assert.assertTrue(elTitleCaseTrackingList.equals("Request/Complaint Tracking"));
    }
}
