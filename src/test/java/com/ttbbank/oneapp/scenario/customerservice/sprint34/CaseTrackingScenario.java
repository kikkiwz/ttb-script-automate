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
import com.ttbbank.oneapp.framework.model.customerservice.NCB_custInfoValidation.custInfoValidationResponse;
import com.ttbbank.oneapp.framework.model.customerservice.CST_status.statusResponse;
import com.ttbbank.oneapp.framework.utils.customerservice.CheckResult;
import com.ttbbank.oneapp.framework.model.customerservice.accountSaving.SavingResponse;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

public class CaseTrackingScenario extends BaseScenario {
    TmbServiceResponse<statusResponse> response = null;
    ExtentTest scenario = null;

    @Test(priority = 0, groups = "Customer Service Case Tracking", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);

        scenario = getFeature().createNode(Scenario.class, "Case Tracking");
        String CaseTracking_ServiceScreen = "images/CaseTracking_ServiceScreen_" + ttbTestContext.getPlateFormName() + ".png";
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
        String ServiceScreen_TabStatusTracing = "images/CaseTracking_ServiceScreen_TabStatusTracing_" + ttbTestContext.getPlateFormName() + ".png";
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
            String tutorial = "images/CaseTracking_Tutorial_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(tutorial);
            CheckResultsReport(scenario.createNode(Given.class, "Tutorial Case Tracking Screen").addScreenCaptureFromPath(tutorial), result);
            btnStart.click();

            WebElement labelInprogress = ttbTestContext.findElement(OneAppElementKeys.LABEL_IN_PROGRESS);
            String elLabelInprogress = labelInprogress.getText();
            result = "";
            result = CheckResults(elLabelInprogress, "In Progress", result);

            String CaseTrackingList = "images/CaseTracking_CaseTrackingList_" + ttbTestContext.getPlateFormName() + ".png";
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
            WebElement titleCaseTrackingList = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_CASE_TRACKING_LIST_SCREEN);
            String elTitleCaseTrackingList = titleCaseTrackingList.getText();
            result = "";
            result = CheckResults(elTitleCaseTrackingList, "Request/Complaint", result);

            String secondTimeCaseTracking = "images/CaseTracking_secondTimeCaseTracking_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(secondTimeCaseTracking);
            CheckResultsReport(scenario.createNode(Given.class, "(If access case tracking on second time then system will skip tutorial screen) go to case tracking list screen").addScreenCaptureFromPath(secondTimeCaseTracking), result);

            Assert.assertTrue(elTitleTutorial.equals("Request/Complaint Tracking"));
            Assert.assertTrue(elTutorialDetail.equals("Why call the Contact Center when you can track your request/complaint status by yourself."));
            Assert.assertTrue(elBtnStart.equals("Start"));
        } catch (Exception e) {
            String SkipTutorial = "images/CaseTracking_SkipTutorial_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(SkipTutorial);
            scenario.createNode(Given.class, "If the customer has already logged in for the first time, the system navigate to case tracking screen without going through tutorial screen.").addScreenCaptureFromPath(SkipTutorial).pass("Pass");
        }
    }


    @Test(priority = 1, groups = "Customer Service case tracking list status inprogress")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement titleCaseTrackingList = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_CASE_TRACKING_LIST_SCREEN);
        String elTitleCaseTrackingList = titleCaseTrackingList.getText();
        WebElement labelInprogress = ttbTestContext.findElement(OneAppElementKeys.LABEL_IN_PROGRESS);
        String elLabelInprogress = labelInprogress.getText();
        WebElement titleCase1 = ttbTestContext.findElement(OneAppElementKeys.TITLE_CASE_1);
        String elTitleCase1 = titleCase1.getText();
        WebElement caseIDInprogress1 = ttbTestContext.findElement(OneAppElementKeys.REF_NO_CASE_TRACKING_LIST_SCREEN_1);
        String elCaseIDInprogress1 = caseIDInprogress1.getText();
        WebElement labelIssue1 = ttbTestContext.findElement(OneAppElementKeys.LABEL_ISSUE_CASE_TRACKING_LIST_SCREEN_1);
        String elLabelIssue1 = labelIssue1.getText();
        WebElement issueValue1 = ttbTestContext.findElement(OneAppElementKeys.ISSUE_CASE_TRACKING_LIST_SCREEN_1);
        String elIssueValue1 = issueValue1.getText();
        WebElement statusInprogress = ttbTestContext.findElement(OneAppElementKeys.STATUS_CASE_TRACKING_LIST_SCREEN_1);
        String elStatusInprogress = statusInprogress.getText();

        System.err.println("elTitleCaseTrackingList : " + elTitleCaseTrackingList);
        System.err.println("elTitleCase1 : " + elTitleCase1);
        System.err.println("elLabelInprogress : " + elLabelInprogress);
        System.err.println("elCaseIDInprogress1 : " + elCaseIDInprogress1);
        System.err.println("elLabelIssue1 : " + elLabelIssue1);
        System.err.println("elIssueValue1 : " + elIssueValue1);
        System.err.println("elStatusInprogress : " + elStatusInprogress);

        String result = "";
        result = CheckResults(elTitleCaseTrackingList, "Request/Complaint", result);
        result = CheckResults(elLabelInprogress, "In Progress", result);
        result = CheckResults(elTitleCase1, "Request/Complaint", result);
        result = CheckResults(elCaseIDInprogress1, "Case ID. " + response.getData().in_progress.get(0).reference_no, result);
        result = CheckResults(elLabelIssue1, "Issue", result);
        result = CheckResults(elIssueValue1, response.getData().in_progress.get(0).issue_en, result);
        result = CheckResults(elStatusInprogress, response.getData().in_progress.get(0).status, result);

        String CaseTrackingListInprogress = "images/CaseTracking_CaseTrackingListInprogress_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CaseTrackingListInprogress);
        CheckResultsReport(scenario.createNode(Given.class, "Validate case tracking list for status inprogress").addScreenCaptureFromPath(CaseTrackingListInprogress), result);

        titleCase1.click();

        Assert.assertTrue(elTitleCaseTrackingList.equals("Request/Complaint"));
        Assert.assertTrue(elLabelInprogress.equals("In Progress"));
        Assert.assertTrue(elTitleCase1.equals("Request/Complaint"));
        Assert.assertTrue(elCaseIDInprogress1.equals("Case ID. " + response.getData().in_progress.get(0).reference_no));
        Assert.assertTrue(elLabelIssue1.equals("Issue"));
        Assert.assertTrue(elIssueValue1.equals(response.getData().in_progress.get(0).issue_en));
        Assert.assertTrue(elStatusInprogress.equals(response.getData().in_progress.get(0).status));
    }

    @Test(priority = 2, groups = "Customer Service case tracking detail status inprogress")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00003() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement titleCaseTrackingDetail = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_CASE_TRACKING_DETAIL_SCREEN);
        String elTitleCaseTrackingDetail = titleCaseTrackingDetail.getText();
        WebElement caseIdDetail = ttbTestContext.findElement(OneAppElementKeys.REF_NO_CASE_TRACKING_DETAIL_SCREEN);
        String elCaseIdDetail = caseIdDetail.getText();
        WebElement labelIssue = ttbTestContext.findElement(OneAppElementKeys.LABEL_ISSUE_CASE_TRACKING_DETAIL_SCREEN);
        String elLabelIssue = labelIssue.getText();
        WebElement issueValue = ttbTestContext.findElement(OneAppElementKeys.ISSUE_CASE_TRACKING_DETAIL_SCREEN);
        String elIssueValue = issueValue.getText();
        WebElement labelProductService = ttbTestContext.findElement(OneAppElementKeys.LABEL_PRODUCT_SERVICE_CASE_TRACKING_DETAIL_SCREEN);
        String elLabelProductService = labelProductService.getText();
        WebElement productServiceValue = ttbTestContext.findElement(OneAppElementKeys.PRODUCT_SERVICE_VALUE_CASE_TRACKING_DETAIL_SCREEN);
        String elProductServiceValue = productServiceValue.getText();
        WebElement labelDateStart = ttbTestContext.findElement(OneAppElementKeys.LABEL_DATE_START_CASE_TRACKING_DETAIL_SCREEN);
        String elLabelDateStart = labelDateStart.getText();
        WebElement dateStartValue = ttbTestContext.findElement(OneAppElementKeys.DATE_START_CASE_TRACKING_DETAIL_SCREEN);
        String elDateStartValue = dateStartValue.getText();
        WebElement labelDateFinish = ttbTestContext.findElement(OneAppElementKeys.LABEL_DATE_FINISH_CASE_TRACKING_DETAIL_SCREEN);
        String elLabelDateFinish = labelDateFinish.getText();
        WebElement dateFinish = ttbTestContext.findElement(OneAppElementKeys.DATE_FINISH_CASE_TRACKING_DETAIL_SCREEN);
        String elDateFinish = dateFinish.getText();

        System.err.println("elTitleCaseTrackingDetail : " + elTitleCaseTrackingDetail);
        System.err.println("elCaseIdDetail : " + elCaseIdDetail);
        System.err.println("elLabelIssue : " + elLabelIssue);
        System.err.println("elIssueValue : " + elIssueValue);
        System.err.println("elLabelProductService : " + elLabelProductService);
        System.err.println("elProductServiceValue : " + elProductServiceValue);
        System.err.println("elLabelDateStart : " + elLabelDateStart);
        System.err.println("elDateStartValue : " + elDateStartValue);
        System.err.println("elLabelDateFinish : " + elLabelDateFinish);
        System.err.println("elDateFinish : " + elDateFinish);

        String expectedFinishDate = (response.getData().in_progress.get(0).finish_date == null) ? response.getData().in_progress.get(0).finish_date : "-";
        String result = "";
        result = CheckResults(elTitleCaseTrackingDetail, "Request/Complaint", result);
        result = CheckResults(elCaseIdDetail, "Case ID. " + response.getData().in_progress.get(0).reference_no, result);
        result = CheckResults(elLabelIssue, "Issue", result);
        result = CheckResults(elIssueValue, response.getData().in_progress.get(0).issue_en, result);
        result = CheckResults(elLabelProductService, "Product/Service", result);
        result = CheckResults(elProductServiceValue, response.getData().in_progress.get(0).product_name_en, result);
        result = CheckResults(elLabelDateStart, "Issue date", result);
        result = CheckResults(elDateStartValue, ConvertDate(response.getData().in_progress.get(0).issue_date, false, "EN"), result);
        result = CheckResults(elLabelDateFinish, "Expected finish date", result);
        result = CheckResults(elDateFinish, expectedFinishDate, result);

        String CaseTrackingDetailInprogress = "images/CaseTracking_CaseTrackingDetailInprogress_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CaseTrackingDetailInprogress);
        CheckResultsReport(scenario.createNode(Given.class, "Validate case tracking detail for status inprogress").addScreenCaptureFromPath(CaseTrackingDetailInprogress), result);

        ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_SCREEN_CASE_TRACKING_DETAIL_SCREEN).click();

        Assert.assertTrue(elTitleCaseTrackingDetail.equals("Request/Complaint"));
        Assert.assertTrue(elCaseIdDetail.equals("Case ID. " + response.getData().in_progress.get(0).reference_no));
        Assert.assertTrue(elLabelIssue.equals("Issue"));
        Assert.assertTrue(elIssueValue.equals(response.getData().in_progress.get(0).issue_en));
        Assert.assertTrue(elLabelProductService.equals("Product/Service"));
        Assert.assertTrue(elProductServiceValue.equals(response.getData().in_progress.get(0).product_name_en));
        Assert.assertTrue(elLabelDateStart.equals("Issue date"));
        Assert.assertTrue(elDateStartValue.equals(ConvertDate(response.getData().in_progress.get(0).issue_date, false, "EN")));
        Assert.assertTrue(elLabelDateFinish.equals("Expected finish date"));
        System.err.println("expectedFinishDate : " + expectedFinishDate);
        Assert.assertTrue(elDateFinish.equals(expectedFinishDate));
    }

    @Test(priority = 3, groups = "Customer Service case tracking list status complete")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00004() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();

        WebElement getLocation = ttbTestContext.findElement(OneAppElementKeys.LABEL_COMPLETE_CASE_TRACKING_LIST_SCREEN);
//        System.err.println("getLocation : " + getLocation);

        // Javascript executor
        ((JavascriptExecutor) ttbTestContext.getDriver()).executeScript("arguments[0].scrollIntoView( true);", getLocation);
        ttbTestContext.verticalSwipeByPercentages(0.3, 0.6, 0.5);
        Thread.sleep(20000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_COMPLETE_CASE_TRACKING_LIST_SCREEN, true);
        WebElement labelComplete = ttbTestContext.findElement(OneAppElementKeys.LABEL_COMPLETE_CASE_TRACKING_LIST_SCREEN);
        String elLabelComplete = labelComplete.getText();
        WebElement titleComplete1 = ttbTestContext.findElement(OneAppElementKeys.TITLE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elTitleComplete1 = titleComplete1.getText();
        WebElement caseIDComplete1 = ttbTestContext.findElement(OneAppElementKeys.REF_NO_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elCaseIDComplete1 = caseIDComplete1.getText();
        WebElement labelDocumentType = ttbTestContext.findElement(OneAppElementKeys.LABEL_DOCUMENT_TYPE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elLabelDocumentType = labelDocumentType.getText();
        WebElement documentTypeValue = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_TYPE_VALUE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elDocumentTypeValue = documentTypeValue.getText();
        WebElement statusComplete = ttbTestContext.findElement(OneAppElementKeys.STATUS_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elStatusComplete = statusComplete.getText();

        System.err.println("elLabelComplete : " + elLabelComplete);
        System.err.println("elTitleComplete1 : " + elTitleComplete1);
        System.err.println("elCaseIDComplete1 : " + elCaseIDComplete1);
        System.err.println("elLabelDocumentType : " + elLabelDocumentType);
        System.err.println("elDocumentTypeValue : " + elDocumentTypeValue);
        System.err.println("elStatus : " + elStatusComplete);

        String status = (elDocumentTypeValue.equals(response.getData().completed.get(0).status.equals("Closed"))) ? response.getData().in_progress.get(0).finish_date : "Done";
        String result = "";
        result = CheckResults(elLabelComplete, "Done/Resolved", result);
        result = CheckResults(elTitleComplete1, "Document request", result);
        result = CheckResults(elCaseIDComplete1, "Case ID. " + response.getData().completed.get(0).reference_no, result);
        result = CheckResults(elLabelDocumentType, "Document type", result);
        result = CheckResults(elDocumentTypeValue, response.getData().completed.get(0).issue_en, result);
        result = CheckResults(elStatusComplete, status, result);

        String CaseTrackingListDone = "images/CaseTracking_CaseTrackingListDone_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CaseTrackingListDone);
        CheckResultsReport(scenario.createNode(Given.class, "Validate case tracking list for status Done").addScreenCaptureFromPath(CaseTrackingListDone), result);
        titleComplete1.click();

        Assert.assertTrue(elLabelComplete.equals("Done/Resolved"));
        Assert.assertTrue(elTitleComplete1.equals("Document request"));
        Assert.assertTrue(elCaseIDComplete1.equals("Case ID. " + response.getData().completed.get(0).reference_no));
        Assert.assertTrue(elLabelDocumentType.equals("Document type"));
        Assert.assertTrue(elDocumentTypeValue.equals(response.getData().completed.get(0).issue_en));
        Assert.assertTrue(elStatusComplete.equals(status));
    }

    @Test(priority = 4, groups = "Customer Service case tracking detail status complete")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00012() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement caseIdDetail = ttbTestContext.findElement(OneAppElementKeys.REF_NO_CASE_TRACKING_DETAIL_SCREEN);
        String elCaseIdDetail = caseIdDetail.getText();
        WebElement labelDocumentTypeDetail = ttbTestContext.findElement(OneAppElementKeys.LABEL_ISSUE_CASE_TRACKING_DETAIL_SCREEN);
        String elLabelDocumentTypeDetail = labelDocumentTypeDetail.getText();
        WebElement documentTypeValueDetail = ttbTestContext.findElement(OneAppElementKeys.ISSUE_CASE_TRACKING_DETAIL_SCREEN);
        String elDocumentTypeValueDetail = documentTypeValueDetail.getText();
        WebElement statusDetail = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_DETAIL_SCREEN);
        String elStatusDetail = statusDetail.getText();
        WebElement dateFinish = ttbTestContext.findElement(OneAppElementKeys.DATE_FINISH_TRACKING_DETAIL_SCREEN);
        String elDateFinish = dateFinish.getText();
        WebElement messageBox = ttbTestContext.findElement(OneAppElementKeys.MESSAGE_BOX_CASE_TRACKING_DETAIL_SCREEN);
        String elMessageBox = messageBox.getText();
        WebElement contactNCB = ttbTestContext.findElement(OneAppElementKeys.CONTACT_CASE_TRACKING_DETAIL_SCREEN);
        String elContactNCB = contactNCB.getText();

        System.err.println("elCaseIdDetail : " + elCaseIdDetail);
        System.err.println("elLabelDocumentTypeDetail : " + elLabelDocumentTypeDetail);
        System.err.println("elDocumentTypeValueDetail : " + elDocumentTypeValueDetail);
        System.err.println("elStatusDetail : " + elStatusDetail);
        System.err.println("elDateFinish : " + elDateFinish);
        System.err.println("elMessageBox : " + elMessageBox);
        System.err.println("elContactNCB : " + elContactNCB);

        String result = "";
        result = CheckResults(elCaseIdDetail, "Case ID. " + response.getData().completed.get(0).reference_no, result);
        result = CheckResults(elLabelDocumentTypeDetail, "Document type", result);
        result = CheckResults(elDocumentTypeValueDetail, "Credit Report (NCB)", result);
        result = CheckResults(elStatusDetail, "TTB has already submit your document request", result);
        result = CheckResults(elDateFinish, ConvertDate(response.getData().completed.get(0).issue_date, false, "EN"), result);
        result = CheckResults(elMessageBox, "Credit Report (NCB) will be sent to your e-mail within 24 hours from e-report@ncb.co.th", result);
        result = CheckResults(elContactNCB, "For any further information please contact NCB Call\n" +
                "Center 0 2643 1250\n" +
                "or email consumer@ncb.co.th", result);

        String CaseTrackingDetailDone = "images/CaseTracking_CaseTrackingDetailDone_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CaseTrackingDetailDone);
        CheckResultsReport(scenario.createNode(Given.class, "Validate case tracking Detail for status Done").addScreenCaptureFromPath(CaseTrackingDetailDone), result);

        Assert.assertTrue(elCaseIdDetail.equals("Case ID. " + response.getData().completed.get(0).reference_no));
        Assert.assertTrue(elLabelDocumentTypeDetail.equals("Document type"));
        Assert.assertTrue(elDocumentTypeValueDetail.equals("Credit Report (NCB)"));
        Assert.assertTrue(elStatusDetail.equals("TTB has already submit your document request"));
        Assert.assertTrue(elDateFinish.equals(ConvertDate(response.getData().completed.get(0).issue_date, false, "EN")));
        Assert.assertTrue(elMessageBox.equals("Credit Report (NCB) will be sent to your e-mail within 24 hours from e-report@ncb.co.th"));
        Assert.assertTrue(elContactNCB.equals("For any further information please contact NCB Call\n" +
                "Center 0 2643 1250\n" +
                "or email consumer@ncb.co.th"));
    }
}
