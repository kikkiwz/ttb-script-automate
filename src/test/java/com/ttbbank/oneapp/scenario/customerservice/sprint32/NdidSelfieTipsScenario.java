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
import com.ttbbank.oneapp.framework.model.customerservice.biometricConsent.biometricConsentResponse;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class NdidSelfieTipsScenario extends BaseScenario {
    ExtentTest scenario = null;
    @Test(priority = 0, groups = "Customer Service NDID list Selfie Tips", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
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
        eqParams.put("acceptance", "N");
        eqParams.put("version", "1.00");
        TmbServiceResponse<biometricConsentResponse> response = client.post("/apis/customers/ekyc/biometricConsent", eqParams, biometricConsentResponse.class);
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
        WebElement History = ttbTestContext.findElement(OneAppElementKeys.LABEL_PENDING_REQUEST_NDID);
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

        scenario = getFeature().createNode(Scenario.class, "Ndid verify selfie tips");
        String NdidPendingRPRequestList = "images/NdidSelfieTips_Ndid_Pending_List_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPendingRPRequestList);
        scenario.createNode(Given.class, "NDID Pending RP Request List").addScreenCaptureFromPath(NdidPendingRPRequestList).pass("Pass");

//        Assert.assertTrue(elHeader.equals("NDID Service"));
//        Assert.assertTrue(elRequest.equals("Pending Request"));
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

        String NdidAuthenticationDetail = "images/NdidSelfieTips_Ndid_Authentication_Request_AAL2.2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidAuthenticationDetail);
        scenario.createNode(Given.class, "NDID Authtication Detail AAL2.2").addScreenCaptureFromPath(NdidAuthenticationDetail).pass("Pass");
        BtnProceed.click();
//
//        JSONArray Arr_Pending_Request =  (JSONArray)JsonDataNdidEligibile.get("pending_request");
//        JSONObject Pending_Request = (JSONObject) Arr_Pending_Request.get(1);
//
//        if(true){
//            parentReport = extent.createTest("TC_ONEAPP-8853 Display Pending Request Detail", "TC_ONEAPP-8853");
//        }
//        childReport = parentReport.createNode("TC_ONEAPP-8853_NDIDAUTH_00001");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. After a Customer select the pending request card on NDID Service List screen, System will display Authentication Detail screen as below:\n" +
//                "- Display < icon, if click < the  system will display the previous screen\n" +
//                "- Display Text Screen\n" +
//                "- Display Text Title\n" +
//                "- Display Text Expiry Date\n" +
//                "- Display Text Expiry Date Value\n" +
//                "- Display Text Message\n" +
//                "- Display Text Message Value\n" +
//                "- Display Proceed Button\n" +
//                "- Display Reject Button</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : Display Text Screen : " + TextColor.blueColor(elTMBAuthen)
//                + "</br>Display Text Title : " + TextColor.blueColor(elAuthenDetail)
//                + "</br>Display Text Expiry Date : " + TextColor.blueColor(elExpiryDate)
//                + "</br>Display Text Expiry Date Value : " + TextColor.blueColor(elExpiryDateValue)
//                + "</br>Display Text Message : " + TextColor.blueColor(elMessage)
//                + "</br>Display Text Message Value : " + TextColor.blueColor(elMessageDetail)
//                + "</br>Display Proceed Button : " + TextColor.blueColor(elBtnProceed)
//                + "</br>Display Reject Button : " + TextColor.blueColor(elBtnReject)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>The system should display Status is Authentication successful with Green icon</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        Assert.assertTrue(elTMBAuthen.equals("ธนาคารทหารไทยธนชาต Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Expiry date"));
//        Assert.assertTrue(elExpiryDateValue.equals(ConvertDate(Pending_Request.get("expire_date").toString(),false,"EN")));
        Assert.assertTrue(elMessage.equals("Message"));
//        Assert.assertTrue(elMessageDetail.equals(Pending_Request.get("request_message")));
        Assert.assertTrue(elBtnProceed.equals("Proceed"));
        Assert.assertTrue(elBtnReject.equals("Cancel"));
    }

    @Test(priority = 2, groups = "Customer Service DisAgree Bioconsent")
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement BtnDisagree = ttbTestContext.findElement(OneAppElementKeys.DISAGREE_BUTTON_BIO_CONSENT);
        String NdidBiometricConsent = "images/NdidSelfieTips_Ndid_Biometric_Consent_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsent);
        scenario.createNode(Given.class, "NDID Authtication Detail AAL2.2").addScreenCaptureFromPath(NdidBiometricConsent).pass("Pass");
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        String NdidBiometricConsentBtnEnable = "images/NdidSelfieTips_Ndid_Biometric_Consent_Button_Enable_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsentBtnEnable);
        scenario.createNode(Given.class, "When customer read and scroll down end of screen, The button will be display enable").addScreenCaptureFromPath(NdidBiometricConsentBtnEnable).pass("Pass");
        ttbTestContext.setContextToWebView(OneAppElementKeys.DISAGREE_BUTTON_BIO_CONSENT, true);
        BtnDisagree.click();
        String NdidBiometricConsentClickDisagree = "images/NdidSelfieTips_Ndid_Biometric_Consent_ClickDisagree_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsentClickDisagree);
        scenario.createNode(Given.class, "When customer click disagree, The system display popup disagree biometric consent").addScreenCaptureFromPath(NdidBiometricConsentClickDisagree).pass("Pass");
        WebElement TitleDisagreePopup = ttbTestContext.findElement(OneAppElementKeys.TITLE_POPUP_DISAGREE_BIO_CONSENT);
        String elTitleDisagreePopup = TitleDisagreePopup.getText();
        WebElement DisagreePopupContent = ttbTestContext.findElement(OneAppElementKeys.DETAIL_POPUP_DISAGREE_BIO_CONSENT);
        String elDisagreePopupContent = DisagreePopupContent.getText();
        System.err.println("elTitleDisagreePopup : " + elTitleDisagreePopup);
        System.err.println("elDisagreePopupContent : " + elDisagreePopupContent);
        WebElement BtnCancelPopup = ttbTestContext.findElement(OneAppElementKeys.CANCEL_BUTTON_DISAGREE_BIO_CONSENT);
        String elBtnCancelPopup = BtnCancelPopup.getText();
        WebElement BtnConfirmPopup = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_BUTTON_DISAGREE_BIO_CONSENT);
        String elBtnConfirmPopup = BtnConfirmPopup.getText();
        System.err.println("elBtnCanclePopup : " + elBtnCancelPopup);
        System.err.println("elBtnConfirmPopup : " + elBtnConfirmPopup);
//
//        if(true){
//            parentReport = extent.createTest("TC_ONEAPP-8855 Display Biometric Consent", "TC_ONEAPP-8855");
//        }
//        childReport = parentReport.createNode("TC_ONEAPP-8855_NDID-BIO_SIT_01001");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Validate a display of Biometric Consent screen, if acceptance flag is N.\n" +
//                "Click at Disagree and Cancel\n" +
//                "Device: Android</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. After a Customer press on the Proceed button on the Authentication Detail screen, System display a Biometric Consent screen. Check condition If the customer not accept Biometric Consent yet.\n" +
//                "- Freeze footer, the footer enable when the customer scroll to last line.\n" +
//                "2. If Customer click at Disagree button, the system will display Disagree Biometric Consent pop-up.\n" +
//                "On Disagree Biometric Consent pop-up.\n" +
//                "-  If Customer press on X button or Cancel button, the system will close the pop-up</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : the system will display Disagree Biometric Consent pop-up. : " + TextColor.blueColor(elTitleDisagreePopup)
//                + "</br>Display Disagree Biometric Consent pop-up : " + TextColor.blueColor(elDisagreePopupContent)
//                + "</br>Display button Confirm : " + TextColor.blueColor(elBtnConfirmPopup)
//                + "</br>Display button Cancel : " + TextColor.blueColor(elBtnCancelPopup)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>the system will display Disagree Biometric Consent pop-up.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

//        Assert.assertTrue(elTitleDisagreePopup.equals("Disagree Biometric Consent?"));
//        Assert.assertTrue(elDisagreePopupContent.equals("If you disagree biometric consent you will not be able to authenticate this request. Please confirm if you would like to reject."));
//        Assert.assertTrue(elBtnConfirmPopup.equals("Confirm"));
//        Assert.assertTrue(elBtnCancelPopup.equals("Cancel"));
        BtnCancelPopup.click();
        String NdidBiometricConsentClickCancel = "images/NdidSelfieTips_Ndid_Biometric_Consent_ClickCancel_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsentClickCancel);
        scenario.createNode(Given.class, "When customer click cancel button, The system will be close popup disagree").addScreenCaptureFromPath(NdidBiometricConsentClickCancel).pass("Pass");

//        childReport.log(Status.INFO, "<pre>System display a Biometric Consent screen. Check condition If the customer not accept Biometric Consent yet</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        BtnDisagree.click();
        String NdidBiometricConsentClickDisagreeAgain = "images/NdidSelfieTips_Ndid_Biometric_Consent_DisagreeAgain_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsentClickDisagreeAgain);
        scenario.createNode(Given.class, "When customer click disagree again, The system display popup disagree biometric consent").addScreenCaptureFromPath(NdidBiometricConsentClickDisagreeAgain).pass("Pass");
    }

    @Test(priority = 3, groups = "Customer Service DisAgree Bioconsent click popup close")
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01003() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement BtnClosePopup = ttbTestContext.findElement(OneAppElementKeys.BUTTON_CLOSE_POPUP_DISAGREE_BIO_CONSENT);
        BtnClosePopup.click();

        String NdidBiometricConsentClickX = "images/NdidSelfieTips_Ndid_Biometric_Consent_Click_X_btn_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsentClickX);
        scenario.createNode(Given.class, "When customer click X button, The system will be close popup disagree").addScreenCaptureFromPath(NdidBiometricConsentClickX).pass("Pass");

        ttbTestContext.findElement(OneAppElementKeys.DISAGREE_BUTTON_BIO_CONSENT).click();

        String NdidBiometricConsentClickDisagreeAgain2 = "images/NdidSelfieTips_Ndid_Biometric_Consent_DisagreeAgain_2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsentClickDisagreeAgain2);
        scenario.createNode(Given.class, "When customer click disagree again, The system display popup disagree biometric consent").addScreenCaptureFromPath(NdidBiometricConsentClickDisagreeAgain2).pass("Pass");

        WebElement BtnConfirm = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_BUTTON_DISAGREE_BIO_CONSENT);
        BtnConfirm.click();

        String NdidBiometricConsentClickConfirmDisagree = "images/NdidSelfieTips_Ndid_Biometric_Consent_ClickConfirmDisagree_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsentClickConfirmDisagree);
        scenario.createNode(Given.class, "When customer click confirm button, The system navigate to pending RP request list screen").addScreenCaptureFromPath(NdidBiometricConsentClickConfirmDisagree).pass("Pass");

//        childReport.log(Status.INFO, "If Customer press on a Confirm button, the system will go back to the NDID Service List screen.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
    }

    @Test(priority = 4, groups = "Customer Service Bioconsent")
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement PendingRequest = ttbTestContext.findElement(OneAppElementKeys.PENDING_REQUEST_LIST_1);
        PendingRequest.click();

        String NdidAuthenticationDetail2 = "images/NdidSelfieTips_Ndid_AuthenticationDetail2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidAuthenticationDetail2);
        scenario.createNode(Given.class, "NDID Authentication Detail screen").addScreenCaptureFromPath(NdidAuthenticationDetail2).pass("Pass");

        WebElement BtnProceed = ttbTestContext.findElement(OneAppElementKeys.PROCEED_BUTTON_AUTHENTICATION_SCREEN);
        BtnProceed.click();

        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_BIO_CONSENT_SCREEN);
        String elHeader = Header.getText();
        WebElement BioConsent = ttbTestContext.findElement(OneAppElementKeys.LABEL_T_C_BIO_CONSENT);
        String elBioConsent = BioConsent.getText();
        WebElement BioConsentContent = ttbTestContext.findElement(OneAppElementKeys.T_C_BIO_CONSENT);
        String elBioConsentContent = BioConsentContent.getText();
        WebElement BtnAgree = ttbTestContext.findElement(OneAppElementKeys.AGREE_BUTTON_BIO_CONSENT);
        String elBtnAgree = BtnAgree.getText();
        WebElement BtnDisagree = ttbTestContext.findElement(OneAppElementKeys.DISAGREE_BUTTON_BIO_CONSENT);
        String elBtnDisagree = BtnDisagree.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elBioConsent : " + elBioConsent);
        System.err.println("elBioConsentContent : " + elBioConsentContent);
        System.err.println("elBtnAgree : " + elBtnAgree);
        System.err.println("elBtnDisagree : " + elBtnDisagree);
        Assert.assertTrue(elHeader.equals("ธนาคารทหารไทยธนชาต Authentication"));
        Assert.assertTrue(elBioConsent.equals("Biometric Consent"));
        Assert.assertTrue(elBtnAgree.equals("Agree"));
        Assert.assertTrue(elBtnDisagree.equals("Disagree"));
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.DISAGREE_BUTTON_BIO_CONSENT, true);

        String NdidBiometricConsent2 = "images/NdidSelfieTips_Ndid_BiometricConsent2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidBiometricConsent2);
        scenario.createNode(Given.class, "Authentication screen").addScreenCaptureFromPath(NdidBiometricConsent2).pass("Pass");

        BtnAgree.click();
    }

    @Test(priority = 5, groups = "Customer Service Selfie tips")
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01008() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
//        childReport.log(Status.INFO, "<pre>2. If customer click at agree button, the system will display Selfie Tips screen</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_SELFIE_TIPS_SCREEN);
        String elHeader = Header.getText();
        WebElement SelfieTip = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELFIE_TIPS);
        String elSelfieTip = SelfieTip.getText();
        WebElement RemoveGlass = ttbTestContext.findElement(OneAppElementKeys.TEXT_SELFIE_TIPS_1);
        String elRemoveGlass = RemoveGlass.getText();
        WebElement GoodLight = ttbTestContext.findElement(OneAppElementKeys.TEXT_SELFIE_TIPS_2);
        String elGoodLight = GoodLight.getText();
        WebElement AlignFace = ttbTestContext.findElement(OneAppElementKeys.TEXT_SELFIE_TIPS_3);
        String elAlignFace = AlignFace.getText();
        WebElement BtnContinue = ttbTestContext.findElement(OneAppElementKeys.CONTINUE_BUTTON_SELFIE_TIPS_SCREEN);
        String elBtnContinue = BtnContinue.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elSelfieTip : " + elSelfieTip);
        System.err.println("elRemoveGlass : " + elRemoveGlass);
        System.err.println("elGoodLight : " + elGoodLight);
        System.err.println("elAlignFace : " + elAlignFace);
        System.err.println("elBtnContinue : " + elBtnContinue);
        String NdidSelfieTips = "images/NdidSelfieTips_Ndid_SelfieTips_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidSelfieTips);
        scenario.createNode(Given.class, "Ndid Selfie Tips screen").addScreenCaptureFromPath(NdidSelfieTips).pass("Pass");

        Assert.assertTrue(elHeader.equals("ธนาคารทหารไทยธนชาต Authentication"));
        Assert.assertTrue(elSelfieTip.equals("Selfie Tips"));
        Assert.assertTrue(elRemoveGlass.equals("Remove glassess, mask, cap"));
        Assert.assertTrue(elGoodLight.equals("Take a selfie in good lighting"));
        Assert.assertTrue(elAlignFace.equals("Align your face with the frame"));
        Assert.assertTrue(elBtnContinue.equals("Continue"));
    }

    @Test(priority = 6, groups = "Customer Service Selfie tips again")
    public void TC_ONEAPP_8855_NDID_BIO_SIT_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement BtnBack2 = ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_BUTTON_SELFIE_TIPS_SCREEN);
        BtnBack2.click();
        WebElement BtnProceed = ttbTestContext.findElement(OneAppElementKeys.PROCEED_BUTTON_AUTHENTICATION_SCREEN);
        BtnProceed.click();
        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_SELFIE_TIPS_SCREEN);
        String elHeader = Header.getText();
        WebElement SelfieTip = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELFIE_TIPS);
        String elSelfieTip = SelfieTip.getText();
        WebElement RemoveGlass = ttbTestContext.findElement(OneAppElementKeys.TEXT_SELFIE_TIPS_1);
        String elRemoveGlass = RemoveGlass.getText();
        WebElement GoodLight = ttbTestContext.findElement(OneAppElementKeys.TEXT_SELFIE_TIPS_2);
        String elGoodLight = GoodLight.getText();
        WebElement AlignFace = ttbTestContext.findElement(OneAppElementKeys.TEXT_SELFIE_TIPS_3);
        String elAlignFace = AlignFace.getText();
        WebElement BtnContinue = ttbTestContext.findElement(OneAppElementKeys.CONTINUE_BUTTON_SELFIE_TIPS_SCREEN);
        String elBtnContinue = BtnContinue.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elSelfieTip : " + elSelfieTip);
        System.err.println("elRemoveGlass : " + elRemoveGlass);
        System.err.println("elGoodLight : " + elGoodLight);
        System.err.println("elAlignFace : " + elAlignFace);
        System.err.println("elBtnContinue : " + elBtnContinue);

        Assert.assertTrue(elHeader.equals("ธนาคารทหารไทยธนชาต Authentication"));
        Assert.assertTrue(elSelfieTip.equals("Selfie Tips"));
        Assert.assertTrue(elRemoveGlass.equals("Remove glassess, mask, cap"));
        Assert.assertTrue(elGoodLight.equals("Take a selfie in good lighting"));
        Assert.assertTrue(elAlignFace.equals("Align your face with the frame"));
        Assert.assertTrue(elBtnContinue.equals("Continue"));

        String NdidAuthentication3 = "images/NdidSelfieTips_Ndid_Authentication3_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidAuthentication3);
        scenario.createNode(Given.class, "If customer already accept BiometricConsent and click proceed Then system will navigate to selfie tips screen directly").addScreenCaptureFromPath(NdidAuthentication3).pass("Pass");

        getExtent().flush();
    }
}
