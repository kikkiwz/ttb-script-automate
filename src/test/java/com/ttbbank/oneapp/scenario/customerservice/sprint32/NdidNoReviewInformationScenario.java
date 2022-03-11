package com.ttbbank.oneapp.scenario.customerservice.sprint32;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.ndidEligible.ndidEligibleResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.*;

public class NdidNoReviewInformationScenario extends BaseScenario {
    ExtentTest scenario = null;
    ExtentTest scenario2 = null;
    String DateTimePresent = null;
    String DateTimeSuccess = null;
    TmbServiceResponse<ndidEligibleResponse> response = null;
    @Test(priority = 0, groups = "Customer Service NDID list not request personal detail", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.35);
        if(ttbTestContext.isAndroid()){
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.TAB_OTHER_SERVICE);
                    break;
                }catch (Exception e){
                    System.out.println("This webview is't to use");
                }
            }
        }else{
            ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
        }
        initToken();
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("", "");
        response = client.get("/apis/customer/ekyc/ndidEligibile", eqParams, ndidEligibleResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cs_service_tab_other_service_label_id']")));
        WebElement TAB_OTHER_SERVICE = ttbTestContext.findElement(OneAppElementKeys.TAB_OTHER_SERVICE);
        TAB_OTHER_SERVICE.click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cs_other_service_ndid_id']")));
        WebElement NDID = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        System.err.println("tesdt : " + NDID.getText());
        NDID.click();
        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_NDID_LIST_SCREEN);
        String elHeader = Header.getText();
        WebElement Request = ttbTestContext.findElement(OneAppElementKeys.LABEL_PENDING_REQUEST_NDID);
        String elRequest = Request.getText();
        WebElement History = ttbTestContext.findElement(OneAppElementKeys.LABEL_REQUEST_HISTORY_NDID);
        String elHistory = History.getText();
        WebElement PendingRequestList1 = ttbTestContext.findElement(OneAppElementKeys.PENDING_REQUEST_LIST_1);
        String elPendingRequestList1 = PendingRequestList1.getText();
        WebElement LabelExpiryDate1 = ttbTestContext.findElement(OneAppElementKeys.LABEL_EXPIRY_DATE_NDID_1);
        String elLabelExpiryDate1 = LabelExpiryDate1.getText();
        WebElement ExpiryDate1 = ttbTestContext.findElement(OneAppElementKeys.EXPIRY_DATE_NDID_1);
        String elExpiryDate1 = ExpiryDate1.getText();
        WebElement RequestHistoryList1 = ttbTestContext.findElement(OneAppElementKeys.REQUEST_HISTORY_LIST_1);
        String elRequestHistoryList1 = RequestHistoryList1.getText();
        WebElement LabelTransactionDate1 = ttbTestContext.findElement(OneAppElementKeys.LABEL_TRANSACTION_DATE_NDID_1);
        String elLabelTransactionDate1 = LabelTransactionDate1.getText();
        WebElement TransactionDate1 = ttbTestContext.findElement(OneAppElementKeys.TRANSACTION_DATE_NDID_1);
        String elTransactionDate1 = TransactionDate1.getText();
        WebElement StatusRequestHistory1 = ttbTestContext.findElement(OneAppElementKeys.STATUS_REQUEST_HISTORY_NDID_1);
        String elStatusRequestHistory1 = StatusRequestHistory1.getText();
        WebElement RequestHistoryList2 = ttbTestContext.findElement(OneAppElementKeys.REQUEST_HISTORY_LIST_2);
        String elRequestHistoryList2 = RequestHistoryList2.getText();
        WebElement LabelTransactionDate2 = ttbTestContext.findElement(OneAppElementKeys.LABEL_TRANSACTION_DATE_NDID_2);
        String elLabelTransactionDate2 = LabelTransactionDate2.getText();
        WebElement TransactionDate2 = ttbTestContext.findElement(OneAppElementKeys.TRANSACTION_DATE_NDID_2);
        String elTransactionDate2 = TransactionDate2.getText();
        WebElement StatusRequestHistory2 = ttbTestContext.findElement(OneAppElementKeys.STATUS_REQUEST_HISTORY_NDID_2);
        String elStatusRequestHistory2 = StatusRequestHistory2.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elRequest : " + elRequest);
        System.err.println("elHistory : " + elHistory);
        System.err.println("elPendingRequestList1 : " + elPendingRequestList1);
        System.err.println("elLabelExpiryDate1 : " + elLabelExpiryDate1);
        System.err.println("elExpiryDate1 : " + elExpiryDate1);
        System.err.println("elRequestHistoryList1 : " + elRequestHistoryList1);
        System.err.println("elLabelTransactionDate1 : " + elLabelTransactionDate1);
        System.err.println("elTransactionDate1 : " + elTransactionDate1);
        System.err.println("elStatusRequestHistory1 : " + elStatusRequestHistory1);
        System.err.println("elRequestHistoryList2 : " + elRequestHistoryList2);
        System.err.println("elLabelTransactionDate2 : " + elLabelTransactionDate2);
        System.err.println("elTransactionDate2 : " + elTransactionDate2);
        System.err.println("elStatusRequestHistory2 : " + elStatusRequestHistory2);

        scenario = getFeature().createNode(Scenario.class, "Ndid no request personal detail");
        String NdidPendingRPRequestList = "images/NdidSelfieTips_Ndid_Pending_List_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPendingRPRequestList);
        scenario.createNode(Given.class, "NDID Pending RP Request List").addScreenCaptureFromPath(NdidPendingRPRequestList).pass("Pass");

        Assert.assertTrue(elHeader.equals("NDID Service"));
        Assert.assertTrue(elRequest.equals("Pending Request"));
        Assert.assertTrue(elHistory.equals("Request History"));
        Assert.assertTrue(elPendingRequestList1.equals(response.getData().pending_request.get(0).provider));
        Assert.assertTrue(elLabelExpiryDate1.equals("Expiry date"));

        Assert.assertTrue(elExpiryDate1.equals(ConvertDate(response.getData().pending_request.get(0).expire_date,true,"EN")));
        Assert.assertTrue(elRequestHistoryList1.equals(response.getData().request_history.get(0).provider));
        Assert.assertTrue(elLabelTransactionDate1.equals("Transaction date"));
        Assert.assertTrue(elTransactionDate1.equals(ConvertDate(response.getData().request_history.get(0).datetime,false,"EN")));
        Assert.assertTrue(elStatusRequestHistory1.equals(checkStatusNdid(response.getData().request_history.get(0).status)));
        Assert.assertTrue(elRequestHistoryList2.equals(response.getData().request_history.get(1).provider));
        Assert.assertTrue(elLabelTransactionDate2.equals("Transaction date"));
        Assert.assertTrue(elTransactionDate2.equals(ConvertDate(response.getData().request_history.get(1).datetime,false,"EN")));
        Assert.assertTrue(elStatusRequestHistory2.equals(checkStatusNdid(response.getData().request_history.get(1).status)));
    }

    @Test(priority = 1, groups = "Customer Service authentication aal 2.1")
    public void TC_ONEAPP_8853_NDIDAUTH_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement PendingRequest = ttbTestContext.findElement(OneAppElementKeys.PENDING_REQUEST_LIST_1);
        PendingRequest.click();
        WebElement TMBAuthen = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_AUTHENTICATION_SCREEN);
        String elTMBAuthen = TMBAuthen.getText();
        WebElement AuthenDetail = ttbTestContext.findElement(OneAppElementKeys.LABEL_AUTHENTICATION_DETAIL);
        String elAuthenDetail = AuthenDetail.getText();
        WebElement ExpiryDate = ttbTestContext.findElement(OneAppElementKeys.LABEL_EXPIRY_AUTHENTICATION_SCREEN);
        String elExpiryDate = ExpiryDate.getText();
        WebElement ExpiryDateValue = ttbTestContext.findElement(OneAppElementKeys.EXPIRY_AUTHENTICATION_SCREEN);
        String elExpiryDateValue = ExpiryDateValue.getText();
        WebElement Message = ttbTestContext.findElement(OneAppElementKeys.LABEL_MESSASGE);
        String elMessage = Message.getText();
        WebElement MessageDetail = ttbTestContext.findElement(OneAppElementKeys.MESSAGE_AUTHENTICATION);
        String elMessageDetail = MessageDetail.getText();
        WebElement BtnProceed = ttbTestContext.findElement(OneAppElementKeys.PROCEED_BUTTON_AUTHENTICATION_SCREEN);
        String elBtnProceed = BtnProceed.getText();
        WebElement BtnReject = ttbTestContext.findElement(OneAppElementKeys.REJECT_BUTTON_AUTHENTICATION_SCREEN);
        String elBtnReject = BtnReject.getText();
        System.err.println("elTMBAuthen : " + elTMBAuthen);
        System.err.println("elAuthenDetail : " + elAuthenDetail);
        System.err.println("elExpiryDate : " + elExpiryDate);
        System.err.println("elExpiryDateValue : " + elExpiryDateValue);
        System.err.println("elMessage : " + elMessage);
        System.err.println("elMessageDetail : " + elMessageDetail);
        System.err.println("elBtnProceed : " + elBtnProceed);
        System.err.println("elBtnReject : " + elBtnReject);

        String NdidPendingRPRequestList = "images/NdidNoReviewInformation_Ndid_Authentication_aal2.1_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPendingRPRequestList);
        scenario.createNode(Given.class, "NDID Pending RP Request List").addScreenCaptureFromPath(NdidPendingRPRequestList).pass("Pass");

        BtnProceed.click();

        Assert.assertTrue(elTMBAuthen.equals(response.getData().pending_request.get(0).provider + " Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Expiry date"));
        Assert.assertTrue(elExpiryDateValue.equals(ConvertDate(response.getData().pending_request.get(0).expire_date,true,"EN")));
        Assert.assertTrue(elMessage.equals("Message"));
        Assert.assertTrue(elMessageDetail.equals(response.getData().pending_request.get(0).request_message));
        Assert.assertTrue(elBtnProceed.equals("Proceed"));
        Assert.assertTrue(elBtnReject.equals("Cancel"));
    }

    @Test(priority = 2, groups = "Customer Service confirm pin authentication ndid and successful screen")
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();

        String NdidConfirPin = "images/NdidNoReviewInformation_Ndid_ConfirmPin_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidConfirPin);
        scenario.createNode(Given.class, "After click proceed, The system isn't navigate to review personal detail screen because ndid isn't request personal detail, Then system navigate to confirm pin screen").addScreenCaptureFromPath(NdidConfirPin).pass("Pass");

        Thread.sleep(2000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, false);
        confirmPin();
        ttbTestContext.setContextToWebView(OneAppElementKeys.TITLE_AUTHEN_SUCCESS, true);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']")));
        WebElement TitleSuccessful = ttbTestContext.findElement(OneAppElementKeys.TITLE_AUTHEN_SUCCESS);
        String elTitleSuccessful = TitleSuccessful.getText();
        WebElement TitleDescription = ttbTestContext.findElement(OneAppElementKeys.AUTHEN_SUCCESS_DETAIL);
        String elTitleDescription = TitleDescription.getText();
        WebElement Transaction = ttbTestContext.findElement(OneAppElementKeys.TRANSACTION_DATE_LABEL_SUCCESS_NDID_SCREEN);
        String elTransaction = Transaction.getText();
        WebElement TransactionValue = ttbTestContext.findElement(OneAppElementKeys.TRANSACTION_DATE_VALUE_SUCCESS_NDID_SCREEN);
        DateTimeSuccess = TransactionValue.getText();
        WebElement RefNo = ttbTestContext.findElement(OneAppElementKeys.REF_NO_LABEL_SUCCESS_NDID_SCREEN);
        String elRefNo = RefNo.getText();
        WebElement RefNoValue = ttbTestContext.findElement(OneAppElementKeys.REF_NO_VALUE_SUCCESS_NDID_SCREEN);
        String elRefNoValue = RefNoValue.getText();
        WebElement BtnBackToMainMenu = ttbTestContext.findElement(OneAppElementKeys.BACK_TO_MAIN_MENU_SUCCESS_NDID_SCREEN);
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elBtnConfirm : " + elTitleSuccessful);
        System.err.println("elBtnConfirm : " + elTitleDescription);
        System.err.println("elBtnConfirm : " + elTransaction);
        System.err.println("DateTimeSuccess : " + DateTimeSuccess);
        System.err.println("elRefNo : " + elRefNo);
        System.err.println("elRefNoValue : " + elRefNoValue);
        System.err.println("elBtnConfirm : " + elBtnBackToMainMenu);

        String NdidSuccessful = "images/NdidNoReviewInformation_Ndid_Successful_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidSuccessful);
        scenario.createNode(Given.class, "NDID Successful screen").addScreenCaptureFromPath(NdidSuccessful).pass("Pass");

//        childReport.log(Status.INFO, "<pre>Actual result : Display Text Authentication Success : " + TextColor.blueColor(elTitleSuccessful)
//                + "</br>Display Text Detail : " + TextColor.blueColor(elTitleDescription)
//                + "</br>Display transaction date time success and reference no. : " + TextColor.blueColor(elTransaction)
//                + "</br>Display label button Back to Main Menu : " + TextColor.blueColor(elBtnBackToMainMenu)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>1. After Enter PIN correct, Display Authentication Successful screen</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        DateTimeFormatter time2 = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        DateTimePresent = dtf2.format(now) + "T" + time2.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("DateTimePresent : " + DateTimePresent);
        Assert.assertTrue(elTitleSuccessful.equals("Authentication Successful"));
        Assert.assertTrue(elTitleDescription.equals("ttb already submitted your authentication\n" +
                "detail, please proceed as requested in the app."));
        Assert.assertTrue(elTransaction.equals("Transaction date"));
        Assert.assertTrue(DateTimeSuccess.equals(DateTimeNow));
        Assert.assertTrue(elRefNo.equals("Ref. no."));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Service Page"));
        BtnBackToMainMenu.click();
    }

    @Test(priority = 3, groups = "Customer Service verify history success no request review information")
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00002_1() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement NDID = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        String NdidPersonal4 = "images/NdidNoReviewInformation_Ndid_ServiceScreen_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPersonal4);
        scenario.createNode(Given.class, "Back to service screen").addScreenCaptureFromPath(NdidPersonal4).pass("Pass");
        NDID.click();
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("", "");
        response = client.get("/apis/customer/ekyc/ndidEligibile", eqParams, ndidEligibleResponse.class);
        System.err.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        System.out.println(response.getData().request_history.get(0).datetime);
        System.out.println(DateTimePresent);
        while (true){
            if(response.getData().request_history.get(0).datetime.equals(DateTimePresent)){
                break;
            }else{
                ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_NDID_LIST_SCREEN).click();
                ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON).click();
                response = client.get("/apis/customer/ekyc/ndidEligibile", eqParams, ndidEligibleResponse.class);
                System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
            }
        }
        WebElement CardHead_History = ttbTestContext.findElement(OneAppElementKeys.REQUEST_HISTORY_LIST_1);
        String elCardHead_History = CardHead_History.getText();
        System.err.println("elCardHead_History : " + elCardHead_History);
        WebElement Transaction_Date = ttbTestContext.findElement(OneAppElementKeys.LABEL_TRANSACTION_DATE_NDID_1);
        String elTransaction_Date = Transaction_Date.getText();
        System.err.println("elTransaction_Date : " + elTransaction_Date);
        WebElement TranDate = ttbTestContext.findElement(OneAppElementKeys.TRANSACTION_DATE_NDID_1);
        String elTranDate = TranDate.getText();
        System.err.println("elTranDate : " + elTranDate);
        WebElement StatusHistory = ttbTestContext.findElement(OneAppElementKeys.STATUS_REQUEST_HISTORY_NDID_1);
        String elStatusHistory = StatusHistory.getText();
        System.err.println("elStatusHistory : " + elStatusHistory);
//        Base.appium.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Transaction date\").instance(0))");
        scenario2 = getFeature().createNode(Scenario.class, "Ndid verify request history status successful");
        String NdidVerifyRequestHistory = "images/NdidNoReviewInformation_Ndid_VerifyRequestHistory_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidVerifyRequestHistory);
        scenario2.createNode(Given.class, "After the customer already do ndid request successful, The customer can verify request history status successful.").addScreenCaptureFromPath(NdidVerifyRequestHistory).pass("Pass");

        Assert.assertTrue(elCardHead_History.equals(response.getData().request_history.get(0).provider));
        Assert.assertTrue(elTransaction_Date.equals("Transaction date"));
        Assert.assertTrue(elTranDate.equals(ConvertDate(response.getData().request_history.get(0).datetime,false,"EN")));
        Assert.assertTrue(elStatusHistory.equals(checkStatusNdid(response.getData().request_history.get(0).status)));
        CardHead_History.click();
    }

    @Test(priority = 4, groups = "Customer Service verify authentication history success no request review information")
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00002_2() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement TMBAuthen = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_AUTHENTICATION_SCREEN);
        String elTMBAuthen = TMBAuthen.getText();
        WebElement AuthenDetail = ttbTestContext.findElement(OneAppElementKeys.LABEL_AUTHENTICATION_DETAIL);
        String elAuthenDetail = AuthenDetail.getText();
        WebElement ExpiryDate = ttbTestContext.findElement(OneAppElementKeys.LABEL_EXPIRY_AUTHENTICATION_SCREEN);
        String elExpiryDate = ExpiryDate.getText();
        WebElement ExpiryDateValue = ttbTestContext.findElement(OneAppElementKeys.EXPIRY_AUTHENTICATION_SCREEN);
        String elExpiryDateValue = ExpiryDateValue.getText();
        WebElement Message = ttbTestContext.findElement(OneAppElementKeys.LABEL_MESSASGE);
        String elMessage = Message.getText();
        WebElement MessageDetail = ttbTestContext.findElement(OneAppElementKeys.MESSAGE_AUTHENTICATION);
        String elMessageDetail = MessageDetail.getText();
        System.err.println("1 : " + elTMBAuthen);
        System.err.println("2 : " + elAuthenDetail);
        System.err.println("3 : " + elExpiryDate);
        System.err.println("4 : " + elExpiryDateValue);
        System.err.println("5 : " + elMessage);
        System.err.println("6 : " + elMessageDetail);
        System.err.println("77 : " + response.getData().request_history.get(0).provider + " Authentication");

        String NdidAuthenticationSuccessful = "images/NdidNoReviewInformation_Ndid_AuthenticationSuccessful_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidAuthenticationSuccessful);
        scenario2.createNode(Given.class, "Authentication Detail request history successful").addScreenCaptureFromPath(NdidAuthenticationSuccessful).pass("Pass");

        Assert.assertTrue(elTMBAuthen.equals(response.getData().request_history.get(0).provider + " Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Transaction date"));
        Assert.assertTrue(elExpiryDateValue.equals(DateTimeSuccess.substring(0, 11) + DateTimeSuccess.substring(11, 19).toUpperCase()));
        Assert.assertTrue(elMessage.equals("Message"));
        Assert.assertTrue(elMessageDetail.equals(response.getData().request_history.get(0).request_message));
        getExtent().flush();
    }


}
