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

import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.ConvertDate;
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.checkStatusNdid;

public class NdidRejectScenario extends BaseScenario {
    ExtentTest scenario2 = null;
    ExtentTest scenario3 = null;
    String DateTimeSuccess = null;
    String DateTimePresent = null;
    TmbServiceResponse<ndidEligibleResponse> response = null;
    @Test(priority = 0, groups = "Customer Service NDID pending RP Request list Reject", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.35);
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            Thread.sleep(3000);
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
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("", "");
        response = client.get("/apis/customer/ekyc/ndidEligibile", eqParams, ndidEligibleResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cs_service_tab_other_service_label_id']")));
        WebElement TAB_OTHER_SERVICE = ttbTestContext.findElement(OneAppElementKeys.TAB_OTHER_SERVICE);
        TAB_OTHER_SERVICE.click();
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cs_other_service_ndid_id")));
        WebElement NDID = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ndid_list_navbar_title_id")));
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

        scenario2 = getFeature().createNode(Scenario.class, "Ndid Reject request");
        String NdidPendingRPRequestList = "images/NdidReject_Ndid_Pending_List_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPendingRPRequestList);
        scenario2.createNode(Given.class, "NDID Pending RP Request List").addScreenCaptureFromPath(NdidPendingRPRequestList).pass("Pass");

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

    @Test(priority = 1, groups = "Customer Service select request aal 2.2")
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

        String NdidAuthenticationDetail = "images/NdidReject_Ndid_Authentication_Request_AAL2.2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidAuthenticationDetail);
        scenario2.createNode(Given.class, "NDID Authtication Detail AAL2.2").addScreenCaptureFromPath(NdidAuthenticationDetail).pass("Pass");

        Assert.assertTrue(elTMBAuthen.equals(response.getData().pending_request.get(0).provider + " Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Expiry date"));
        Assert.assertTrue(elExpiryDateValue.equals(ConvertDate(response.getData().pending_request.get(0).expire_date,true,"EN")));
        Assert.assertTrue(elMessage.equals("Message"));
        Assert.assertTrue(elMessageDetail.equals(response.getData().pending_request.get(0).request_message));
        Assert.assertTrue(elBtnProceed.equals("Proceed"));
        Assert.assertTrue(elBtnReject.equals("Cancel"));
    }

    @Test(priority = 2, groups = "Customer Service Reject Request NDID")
    public void TC_ONEAPP_11078_NDID_REJECT_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement btnReject = ttbTestContext.findElement(OneAppElementKeys.REJECT_BUTTON_AUTHENTICATION_SCREEN);
        btnReject.click();

        String NdidRejectPopup = "images/NdidReject_Ndid_RejectPopup_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidRejectPopup);
        scenario2.createNode(Given.class, "When customer Reject button, The system display reject this request pop-up").addScreenCaptureFromPath(NdidRejectPopup).pass("Pass");

        WebElement titlePopupReject = ttbTestContext.findElement(OneAppElementKeys.TITLE_POPUP_REJECT_NDID);
        String elTitlePopupReject = titlePopupReject.getText();
        WebElement detailPopupReject = ttbTestContext.findElement(OneAppElementKeys.DETAIL_POPUP_REJECT_NDID);
        String elDetailPopupReject = detailPopupReject.getText();
        WebElement confirmBtn = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_BUTTON_REJECT_NDID);
        String elConfirmBtn = confirmBtn.getText();
        WebElement backToNdidRequest = ttbTestContext.findElement(OneAppElementKeys.BACK_BUTTON_NDID_REQUEST);
        String elBackToNdidRequest = backToNdidRequest.getText();

        System.err.println("elTitlePopupReject : " + elTitlePopupReject);
        System.err.println("elDetailPopupReject : " + elDetailPopupReject);
        System.err.println("elConfirmBtn : " + elConfirmBtn);
        System.err.println("elBackToNdidRequest : " + elBackToNdidRequest);

        Assert.assertTrue(elTitlePopupReject.equals("Request Cancellation"));
        Assert.assertTrue(elDetailPopupReject.equals("If you cancel this request, you will no longer be able to authenticate this request again. Please contact the source bank."));
        Assert.assertTrue(elConfirmBtn.equals("Confirm"));
        Assert.assertTrue(elBackToNdidRequest.equals("Back to NDID Request"));
        backToNdidRequest.click();

        String NdidRejectPopupClickBack = "images/NdidReject_Ndid_RejectPopupClickBack_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidRejectPopupClickBack);
        scenario2.createNode(Given.class, "When customer Back To NDID Request button, The system will be close pop-up").addScreenCaptureFromPath(NdidRejectPopupClickBack).pass("Pass");

        btnReject.click();

        String NdidRejectPopupAgain = "images/NdidReject_Ndid_RejectPopup2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidRejectPopupAgain);
        scenario2.createNode(Given.class, "Customer Reject button again, The system display reject this request pop-up").addScreenCaptureFromPath(NdidRejectPopupAgain).pass("Pass");

        WebElement closeBtnPopupReject = ttbTestContext.findElement(OneAppElementKeys.BACK_BUTTON_NDID_REQUEST);
        closeBtnPopupReject.click();

        String NdidRejectPopupClickX = "images/NdidReject_Ndid_RejectPopupClickX_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidRejectPopupClickX);
        scenario2.createNode(Given.class, "When customer X button, The system will be close pop-up").addScreenCaptureFromPath(NdidRejectPopupClickX).pass("Pass");

        btnReject.click();

        String NdidRejectPopupAgain2 = "images/NdidReject_Ndid_RejectPopup3_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidRejectPopupAgain2);
        scenario2.createNode(Given.class, "Customer Reject button again, The system display reject this request pop-up").addScreenCaptureFromPath(NdidRejectPopupAgain2).pass("Pass");

        ttbTestContext.findElement(OneAppElementKeys.CONFIRM_BUTTON_REJECT_NDID).click();
    }


    @Test(priority = 3, groups = "Customer Service Successful Reject authentication NDID")
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.TITLE_AUTHEN_SUCCESS, true);
        WebElement TitleSuccessful = ttbTestContext.findElement(OneAppElementKeys.TITLE_AUTHEN_SUCCESS);
        String elTitleSuccessful = TitleSuccessful.getText();
        WebElement TitleDescription = ttbTestContext.findElement(OneAppElementKeys.AUTHEN_SUCCESS_DETAIL);
        String elTitleDescription = TitleDescription.getText().replaceAll("/n","");
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
        System.err.println("elTitleSuccessful : " + elTitleSuccessful);
        System.err.println("elTitleDescription : " + elTitleDescription);
        System.err.println("elTransaction : " + elTransaction);
        System.err.println("DateTimeSuccess : " + DateTimeSuccess);
        System.err.println("elRefNo : " + elRefNo);
        System.err.println("elRefNoValue : " + elRefNoValue);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);

        String NdidRejectPopupClickConfirm = "images/NdidReject_Ndid_RejectPopupClickConfirm_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidRejectPopupClickConfirm);
        scenario2.createNode(Given.class, "When customer click confirm button, The system display request reject successful screen").addScreenCaptureFromPath(NdidRejectPopupClickConfirm).pass("Pass");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        DateTimeFormatter time2 = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        DateTimePresent = dtf2.format(now) + "T" + time2.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow);
        Assert.assertTrue(elTitleSuccessful.equals("Request Cancellation Successful"));
        Assert.assertTrue(elTitleDescription.equals("Please contact the source bank,\n" +
                "if you did not request for this authentication."));
        Assert.assertTrue(elTransaction.equals("Transaction date"));
        Assert.assertTrue(DateTimeSuccess.equals(DateTimeNow));
        Assert.assertTrue(elRefNo.equals("Ref. no."));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Service Page"));
        BtnBackToMainMenu.click();
    }

    @Test(priority = 4, groups = "Customer Service verify card history reject")
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement NDID = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);

        String NdidBackToServiceScreen = "images/NdidReject_Ndid_ServiceScreen_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBackToServiceScreen);
        scenario2.createNode(Given.class, "When customer click Back to service page button, The system navigate to service screen").addScreenCaptureFromPath(NdidBackToServiceScreen).pass("Pass");

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

        scenario3 = getFeature().createNode(Scenario.class, "Ndid verify history reject request");
        String NdidVerifyHistoryStatusCancel = "images/NdidReject_Ndid_VerifyHistoryStatusCancel_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidVerifyHistoryStatusCancel);
        scenario3.createNode(Given.class, "After the customer already reject request, The customer can verify reject request history.").addScreenCaptureFromPath(NdidVerifyHistoryStatusCancel).pass("Pass");

        Assert.assertTrue(elCardHead_History.equals(response.getData().request_history.get(0).provider));
        Assert.assertTrue(elTransaction_Date.equals("Transaction date"));
        Assert.assertTrue(elTranDate.equals(ConvertDate(response.getData().request_history.get(0).datetime,false,"EN")));
        Assert.assertTrue(elStatusHistory.equals("Authentication canceled"));
        CardHead_History.click();
    }

    @Test(priority = 5, groups = "Customer Service verify authentication history reject")
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00001_2() throws Exception {
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

        String NdidAuthenticationReject = "images/NdidReject_Ndid_AuthenticationReject_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidAuthenticationReject);
        scenario3.createNode(Given.class, "Authentication Detail reject request history").addScreenCaptureFromPath(NdidAuthenticationReject).pass("Pass");

        Assert.assertTrue(elTMBAuthen.equals(response.getData().request_history.get(0).provider + " Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Transaction date"));
        Assert.assertTrue(elExpiryDateValue.equals(DateTimeSuccess.substring(0, 11) + DateTimeSuccess.substring(11, 19).toUpperCase()));
        Assert.assertTrue(elMessage.equals("Message"));
        Assert.assertTrue(elMessageDetail.equals(response.getData().request_history.get(0).request_message));
        getExtent().flush();
    }
}
