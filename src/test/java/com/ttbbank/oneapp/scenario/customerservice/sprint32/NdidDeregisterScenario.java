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

public class NdidDeregisterScenario extends BaseScenario {
    TmbServiceResponse<ndidEligibleResponse> response = null;
    ExtentTest scenario = null;
    @Test(priority = 0, groups = "Customer Service NDID list Deregister", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.35);
        scenario = getFeature().createNode(Scenario.class, "Ndid no request personal detail");
        if(ttbTestContext.isAndroid()){
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
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
        NDID.click();
        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_NDID_LIST_SCREEN);
        String elHeader = Header.getText();
//        WebElement Request = ttbTestContext.findElement(OneAppElementKeys.LABEL_PENDING_REQUEST_NDID);
//        String elRequest = Request.getText();
        WebElement History = ttbTestContext.findElement(OneAppElementKeys.LABEL_REQUEST_HISTORY_NDID);
        String elHistory = History.getText();
////        WebElement PendingRequestList1 = ttbTestContext.findElement(OneAppElementKeys.PENDING_REQUEST_LIST_1);
////        String elPendingRequestList1 = PendingRequestList1.getText();
////        WebElement LabelExpiryDate1 = ttbTestContext.findElement(OneAppElementKeys.LABEL_EXPIRY_DATE_NDID_1);
////        String elLabelExpiryDate1 = LabelExpiryDate1.getText();
////        WebElement ExpiryDate1 = ttbTestContext.findElement(OneAppElementKeys.EXPIRY_DATE_NDID_1);
////        String elExpiryDate1 = ExpiryDate1.getText();
//        WebElement PendingRequestList2 = ttbTestContext.findElement(OneAppElementKeys.PENDING_REQUEST_LIST_2);
//        String elPendingRequestList2 = PendingRequestList2.getText();
//        WebElement LabelExpiryDate2 = ttbTestContext.findElement(OneAppElementKeys.LABEL_EXPIRY_DATE_NDID_2);
//        String elLabelExpiryDate2 = LabelExpiryDate2.getText();
//        WebElement ExpiryDate2 = ttbTestContext.findElement(OneAppElementKeys.EXPIRY_DATE_NDID_2);
//        String elExpiryDate2 = ExpiryDate2.getText();
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
//        System.err.println("elRequest : " + elRequest);
        System.err.println("elHistory : " + elHistory);
//        System.err.println("elPendingRequestList1 : " + elPendingRequestList1);
//        System.err.println("elLabelExpiryDate1 : " + elLabelExpiryDate1);
//        System.err.println("elExpiryDate1 : " + elExpiryDate1);
//        System.err.println("elPendingRequestList2 : " + elPendingRequestList2);
//        System.err.println("elLabelExpiryDate2 : " + elLabelExpiryDate2);
//        System.err.println("elExpiryDate2 : " + elExpiryDate2);
        System.err.println("elRequestHistoryList1 : " + elRequestHistoryList1);
        System.err.println("elLabelTransactionDate1 : " + elLabelTransactionDate1);
        System.err.println("elTransactionDate1 : " + elTransactionDate1);
        System.err.println("elStatusRequestHistory1 : " + elStatusRequestHistory1);
        System.err.println("elRequestHistoryList2 : " + elRequestHistoryList2);
        System.err.println("elLabelTransactionDate2 : " + elLabelTransactionDate2);
        System.err.println("elTransactionDate2 : " + elTransactionDate2);
        System.err.println("elStatusRequestHistory2 : " + elStatusRequestHistory2);

        String NdidPendingRPRequestList = "images/NdidDeregister_Ndid_Pending_List_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPendingRPRequestList);
        scenario.createNode(Given.class, "NDID Pending RP Request List").addScreenCaptureFromPath(NdidPendingRPRequestList).pass("Pass");

        Assert.assertTrue(elHeader.equals("NDID Service"));
//        Assert.assertTrue(elRequest.equals("Pending Request"));
//        Assert.assertTrue(elPendingRequestList1.equals(response.getData().pending_request.get(0).provider));
//        Assert.assertTrue(elLabelExpiryDate1.equals("Expiry date"));
//        Assert.assertTrue(elExpiryDate1.equals(ConvertDate(response.getData().pending_request.get(0).expire_date, true, "EN")));
    }

    @Test(priority = 1, groups = "Customer Service NDID Service Detail")
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement ViewDetailBtn = ttbTestContext.findElement(OneAppElementKeys.VIEW_DETAIL_BUTTON);
        ViewDetailBtn.click();
        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_NDID_SERVICE_DETAIL_SCREEN);
        String elHeader = Header.getText();
        WebElement Information = ttbTestContext.findElement(OneAppElementKeys.LABEL_INFORMATION_NDID_SERVICE_DETAIL_SCREEN);
        String elInformation = Information.getText();
        WebElement FirstName = ttbTestContext.findElement(OneAppElementKeys.LABEL_FIRST_NAME_NDID_SERVICE_DETAIL_SCREEN);
        String elFirstName = FirstName.getText();
        WebElement FirstNameValue = ttbTestContext.findElement(OneAppElementKeys.FIRST_NAME_VALUE_NDID_SERVICE_DETAIL_SCREEN);
        String elFirstNameValue = FirstNameValue.getText();
        WebElement LastName = ttbTestContext.findElement(OneAppElementKeys.LABEL_LAST_NAME_NDID_SERVICE_DETAIL_SCREEN);
        String elLastName = LastName.getText();
        WebElement LastnameValue = ttbTestContext.findElement(OneAppElementKeys.LAST_NAME_VALUE_NDID_SERVICE_DETAIL_SCREEN);
        String elLastnameValue = LastnameValue.getText();
        WebElement IDNumber = ttbTestContext.findElement(OneAppElementKeys.LABEL_ID_NUMBER_NDID_SERVICE_DETAIL_SCREEN);
        String elIDNumber = IDNumber.getText();
        WebElement IDNumberValue = ttbTestContext.findElement(OneAppElementKeys.ID_NUMBER_VALUE_NDID_SERVICE_DETAIL_SCREEN);
        String elIDNumberValue = IDNumberValue.getText().replace("-", "").replace("X","");
        WebElement MobileNumber = ttbTestContext.findElement(OneAppElementKeys.LABEL_MOBILE_NUMBER_NDID_SERVICE_DETAIL_SCREEN);
        String elMobileNumber = MobileNumber.getText();
        WebElement MobileNumberValue = ttbTestContext.findElement(OneAppElementKeys.MOBILE_NUMBER_VALUE_NDID_SERVICE_DETAIL_SCREEN);
        String elMobileNumberValue = MobileNumberValue.getText().replace("-", "").replace("X","");
        WebElement RegisteredDate = ttbTestContext.findElement(OneAppElementKeys.LABEL_REGISTER_DATE_NDID_SERVICE_DETAIL_SCREEN);
        String elRegisteredDate = RegisteredDate.getText();
        WebElement DateValue = ttbTestContext.findElement(OneAppElementKeys.REGISTER_DATE_VALUE_NDID_SERVICE_DETAIL_SCREEN);
        String elDateValue = DateValue.getText();
        WebElement BtnDeregister = ttbTestContext.findElement(OneAppElementKeys.DEREGISTER_NDID_SERVICE_DETAIL_SCREEN);
        String elBtnDeregister = BtnDeregister.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elInformation : " + elInformation);
        System.err.println("elFirstName : " + elFirstName + " : " + elFirstNameValue);
        System.err.println("elFirstNameValue : " + elFirstNameValue);
        System.err.println("elLastName : " + elLastName + " : " + elLastnameValue);
        System.err.println("elLastnameValue : " + elLastnameValue);
        System.err.println("elIDNumber : " + elIDNumber + " : " + elIDNumberValue);
        System.err.println("elIDNumberValue : " + elIDNumberValue);
        System.err.println("elMobileNumber : " + elMobileNumber + " : " + elMobileNumberValue);
        System.err.println("elMobileNumberValue : " + elMobileNumberValue);
        System.err.println("elRegisteredDate : " + elRegisteredDate + " : " + elDateValue);
        System.err.println("elDateValue : " + elDateValue);
        System.err.println("elBtnDeregister : " + elBtnDeregister);

        String NdidServiceDetail = "images/NdidDeregister_NdidServiceDetail_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidServiceDetail);
        scenario.createNode(Given.class, "NDID Service Detail Screen").addScreenCaptureFromPath(NdidServiceDetail).pass("Pass");

        Assert.assertTrue(elHeader.equals("NDID Service Detail"));
        Assert.assertTrue(elInformation.equals("Your registered information"));
        Assert.assertTrue(elFirstName.equals("First Name"));
        Assert.assertTrue(elLastName.equals("Last Name"));
        Assert.assertTrue(elIDNumber.equals("ID number"));
        Assert.assertTrue(elMobileNumber.equals("Mobile number"));
        Assert.assertTrue(elRegisteredDate.equals("Registered date"));
        Assert.assertTrue(elFirstNameValue.equals(response.getData().first_name_en));
        Assert.assertTrue(elLastnameValue.equals(response.getData().last_name_en));
        Assert.assertTrue(elIDNumberValue.substring(9,13).equals(response.getData().citizen_id.substring(9,13)));
        Assert.assertTrue(elMobileNumberValue.substring(6,10).equals(response.getData().mobile_no.substring(6,10)));
        Assert.assertTrue(elDateValue.equals(ConvertDate(response.getData().registered_date.substring(0,16), false, "EN")));
        Assert.assertTrue(elBtnDeregister.equals("Cancel NDID Service"));
//        childReport = parentReport.createNode("TC_ONEAPP-8852_NDID-REQ_SIT_00006");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. The system displays Your registered Information screen.</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : Display Text title  : " + TextColor.blueColor(elHeader)
//                + "</br>Display First Name : " + TextColor.blueColor(elFirstName + " : " + elFirstNameValue)
//                + "</br>Display Last Name : " + TextColor.blueColor(elLastName + " : " + elLastnameValue)
//                + "</br>Display Citizen id : " + TextColor.blueColor(elIDNumber + " : " + elIDNumberValue)
//                + "</br>Display Mobile number : " + TextColor.blueColor(elMobileNumber + " : " + elMobileNumberValue)
//                + "</br>Display button Deregister : " + TextColor.blueColor(elBtnDeregister)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>The system should display Status is Authentication successful with Green icon</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
    }

    @Test(priority = 2, groups = "Customer Service deregister biometric consent in case click discard")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement BtnDeregister = ttbTestContext.findElement(OneAppElementKeys.DEREGISTER_NDID_SERVICE_DETAIL_SCREEN);
        BtnDeregister.click();
        WebElement TitleNdidDeregister = ttbTestContext.findElement(OneAppElementKeys.TITLE_NDID_DEREGISTER);
        String elTitleNdidDeregister = TitleNdidDeregister.getText();
        WebElement Label_T_C_BioConsentNdidDeregister = ttbTestContext.findElement(OneAppElementKeys.LABEL_T_C_BIO_CONSENT_NDID_DEREGISTER);
        String elLabel_T_C_BioConsentNdidDeregister = Label_T_C_BioConsentNdidDeregister.getText();
        WebElement T_C_BioConsentNdidDeregister = ttbTestContext.findElement(OneAppElementKeys.T_C_BIO_CONSENT_NDID_DEREGISTER);
        String elT_C_BioConsentNdidDeregister = T_C_BioConsentNdidDeregister.getText().replaceAll("<br>", "");
        for(int i = 0; i < 7; i++){
            ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        }
        ttbTestContext.setContextToWebView(OneAppElementKeys.AGREE_BUTTON_DEREGISTER, true);
        WebElement BtnAgree = ttbTestContext.findElement(OneAppElementKeys.AGREE_BUTTON_DEREGISTER);
        String elBtnAgree = BtnAgree.getText();
        WebElement BtnDisCard = ttbTestContext.findElement(OneAppElementKeys.DISAGREE_BUTTON_DEREGISTER);
        String elBtnDisCard= BtnDisCard.getText();

        String NdidDeregister = "images/NdidDeregister_NdidDeregister_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidDeregister);
        scenario.createNode(Given.class, "When customer click deregister button, The system navigate to NDID Deregister screen").addScreenCaptureFromPath(NdidDeregister).pass("Pass");

        System.err.println("elTitleNdidDeregister : " + elTitleNdidDeregister);
        System.err.println("elT_C_BioConsentNdidDeregister : " + elT_C_BioConsentNdidDeregister);
        System.err.println("elLabel_T_C_BioConsentNdidDeregister : " + elLabel_T_C_BioConsentNdidDeregister);
        System.err.println("elBtnAgree : " + elBtnAgree);
        System.err.println("elBtnDisCard : " + elBtnDisCard);
        BtnDisCard.click();

        String NdidServiceDetail = "images/NdidDeregister_NdidServiceDetail_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidServiceDetail);
        scenario.createNode(Given.class, "When customer click discard button, The system navigate to NDID Deregister screen").addScreenCaptureFromPath(NdidServiceDetail).pass("Pass");

//        if(true){
//            parentReport = extent.createTest("TC_ONEAPP-9805 Deregister NDID", "TC_ONEAPP-9805_NDID-DEREG_SIT");
//        }
//        childReport = parentReport.createNode("TC_ONEAPP-9805_NDID-DEREG_SIT_00001");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Verify Deregister NDID Service from NDID Service Detail screen\n" +
//                "- Android\n" +
//                "- Cancel or X</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. On NDID Service Detail screen, the system display  Deregister NDID Service button.\n" +
//                "2. After the customer press on the Deregister NDID Service button, The system will display the Confirm Deregister pop-up.\n" +
//                "- If the customer press on Cancel or 'x' , the system will close the pop-up ‘Deregister NDID Message’.</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : the system will display Disagree Biometric Consent pop-up. : " + TextColor.blueColor(elTitlePopupDeregister)
//                + "</br>Display Disagree Biometric Consent pop-up : " + TextColor.blueColor(elPopupDeregisterDetail)
//                + "</br>Display button Confirm : " + TextColor.blueColor(elBtnConfirm)
//                + "</br>Display button Cancel : " + TextColor.blueColor(elBtnCancel)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>the system will display Disagree Biometric Consent pop-up.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        Assert.assertTrue(elTitleNdidDeregister.equals("Cancel NDID Service"));
//        Assert.assertTrue(elT_C_BioConsentNdidDeregister.equals("After the deregistration, you would not be able to use ttb as an IdP for authentication anymore."));
        Assert.assertTrue(elLabel_T_C_BioConsentNdidDeregister.equals("Terms and Conditions"));
        Assert.assertTrue(elBtnAgree.equals("Agree"));
        Assert.assertTrue(elBtnDisCard.equals("Disagree"));
    }

    @Test(priority = 3, groups = "Customer Service deregister biometric consent in case click deregister")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement BtnDeregister = ttbTestContext.findElement(OneAppElementKeys.DEREGISTER_NDID_SERVICE_DETAIL_SCREEN);
        BtnDeregister.click();
        WebElement BtnAgree = ttbTestContext.findElement(OneAppElementKeys.AGREE_BUTTON_DEREGISTER);

        String NdidDeregister = "images/NdidDeregister_NdidDeregister2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidDeregister);
        scenario.createNode(Given.class, "NDID Deregister screen").addScreenCaptureFromPath(NdidDeregister).pass("Pass");

        for(int i = 0; i < 7; i++){
            ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        }
        ttbTestContext.setContextToWebView(OneAppElementKeys.AGREE_BUTTON_DEREGISTER, true);
        BtnAgree.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, false);

        String NdidConfirmPin = "images/NdidDeregister_NdidConfirmPin_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidConfirmPin);
        scenario.createNode(Given.class, "After click deregister button on NDID Deregister screen, The system navigate to confirm pin screen").addScreenCaptureFromPath(NdidConfirmPin).pass("Pass");

        confirmPin();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']")));
//
//        childReport.log(Status.INFO, "<pre>the customer press on Cancel, the system will close the pop-up ‘Deregister NDID Message’.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

    }
    @Test(priority = 4, groups = "Customer Service deregister successful")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00005() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.TITLE_NDID_DEREGISTER_SUCCESSFUL, true);
        WebElement TitleNDIDDeregister = ttbTestContext.findElement(OneAppElementKeys.TITLE_NDID_DEREGISTER_SUCCESSFUL);
        String elTitleNDIDDeregister = TitleNDIDDeregister.getText();
        WebElement NDIDDeregisterDetail = ttbTestContext.findElement(OneAppElementKeys.DETAIL_NDID_DEREGISTER_SUCCESSFUL);
        String elNDIDDeregisterDetail = NDIDDeregisterDetail.getText().replace("\n"," ");
        WebElement Transaction = ttbTestContext.findElement(OneAppElementKeys.LABEL_TRANSACTION_DATE_NDID_DEREGISTER_SUCCESSFUL);
        String elTransaction = Transaction.getText();
        WebElement TransactionValue = ttbTestContext.findElement(OneAppElementKeys.TRANSACTION_DATE_NDID_DEREGISTER_SUCCESSFUL);
        String elTransactionValue = TransactionValue.getText();
        WebElement RefNo = ttbTestContext.findElement(OneAppElementKeys.LABEL_REF_NO_NDID_DEREGISTER_SUCCESSFUL);
        String elRefNo = RefNo.getText();
        WebElement RefNoValue = ttbTestContext.findElement(OneAppElementKeys.REF_NO_VALUE_NDID_DEREGISTER_SUCCESSFUL);
        String elRefNoValue = RefNoValue.getText();
        WebElement BtnBackToMainMenu = ttbTestContext.findElement(OneAppElementKeys.BACK_TO_MAIN_MENU_NDID_DEREGISTER_SUCCESSFUL);
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elTitleNDIDDeregister : " + elTitleNDIDDeregister);
        System.err.println("elNDIDDeregisterDetail : " + elNDIDDeregisterDetail);
        System.err.println("elTransaction : " + elTransaction);
        System.err.println("elTransactionValue : " + elTransactionValue);
        System.err.println("elRefNo : " + elRefNo);
        System.err.println("elRefNoValue : " + elRefNoValue);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);

        String NdidSuccessfulDeregister = "images/NdidDeregister_NdidSuccessfulDeregister_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidSuccessfulDeregister);
        scenario.createNode(Given.class, "NDID Deregister Successful screen").addScreenCaptureFromPath(NdidSuccessfulDeregister).pass("Pass");

//        childReport = parentReport.createNode("TC_ONEAPP-9805_NDID-DEREG_SIT_00003");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Verify Deregister NDID Service from NDID Service Detail screen\n" +
//                "- Android\n" +
//                "- Enter PIN</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. System displays “Enter Access PIN” popup.\n" +
//                "- If the customer enter correct “Access PIN”, the system navigates to “NDID Deregistration Successful” screen\n" +
//                "2. The system will update request status to be ‘Deregister’</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : Display Deregister successful : " + TextColor.blueColor(elTitleNDIDDeregister)
//                + "</br>Display Deregister successful detail : " + TextColor.blueColor(elNDIDDeregisterDetail)
//                + "</br>Display Display Deregister Date and Reference No : " + TextColor.blueColor(elTransaction)
//                + "</br>Display button back ot main menu : " + TextColor.blueColor(elBtnBackToMainMenu)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>the customer enter correct “Access PIN”, the system navigates to “NDID Deregistration Successful” screen</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elTitleNDIDDeregister.equals("Successfully Canceled Request"));
        Assert.assertTrue(elNDIDDeregisterDetail.equals("You can register NDID service again anytime."));
        Assert.assertTrue(elTransaction.equals("Transaction date"));
        Assert.assertTrue(elTransactionValue.equals(DateTimeNow));
        Assert.assertTrue(elRefNo.equals("Ref. no."));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Service Page"));


//        childReport = parentReport.createNode("TC_ONEAPP-9805_NDID-DEREG_SIT_00004");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Validate a display of NDID Deregistration Success screen\n" +
//                "- Android\n" +
//                "- Back to Service Page</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. The system display NDID Deregistration Success screen.\n" +
//                "- Display Deregister Date.\n" +
//                "- Display Reference No\n" +
//                "2. The customer press on Back to Service Page button, the system will navigate to Service page.</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : Display Deregister successful : " + TextColor.blueColor(elTitleNDIDDeregister)
//                + "</br>Display Deregister successful detail : " + TextColor.blueColor(elNDIDDeregisterDetail)
//                + "</br>Display Display Deregister Date and Reference No : " + TextColor.blueColor(elTransaction)
//                + "</br>Display button back ot main menu : " + TextColor.blueColor(elBtnBackToMainMenu)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>The customer press on Back to Service Page button, the system will navigate to Service page.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
        BtnBackToMainMenu.click();
//        childReport.log(Status.INFO, "<pre>The customer press on Back to Service Page button, the system will navigate to Service page.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

    }

    @Test(priority = 5, groups = "Customer Service is not register NDID")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00006() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement NDID = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        String NdidServiceScreen = "images/NdidReviewInformation_Ndid_ServiceScreen_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidServiceScreen);
        scenario.createNode(Given.class, "Back to service screen").addScreenCaptureFromPath(NdidServiceScreen).pass("Pass");
        NDID.click();
        WebElement TitleNDIDError = ttbTestContext.findElement(OneAppElementKeys.TITLE_CANNOT_REGISTER_NDID);
        String elTitleNDIDError = TitleNDIDError.getText();
        WebElement NDIDErrorDetail = ttbTestContext.findElement(OneAppElementKeys.DETAIL_CANNOT_REGISTER_NDID);
        String elNDIDErrorDetail = NDIDErrorDetail.getText();
        WebElement BtnBackToMainMenu = ttbTestContext.findElement(OneAppElementKeys.BACK_TO_MAIN_MENU_CANNOT_REGISTER_NDID);
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();

        String NdidnNotRegister = "images/NdidDeregister_NdidnNotRegister_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidnNotRegister);
        scenario.createNode(Given.class, "After the customer already do ndid deregister successful, The system display NDID isn't register screen").addScreenCaptureFromPath(NdidnNotRegister).pass("Pass");
        System.err.println("elTitleNDIDError : " + elTitleNDIDError);
        System.err.println("elNDIDErrorDetail : " + elNDIDErrorDetail);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);

//        if(true){
//            parentReport = extent.createTest("TC_ONEAPP-8855", "TC_ONEAPP-8855");
//        }
//        childReport = parentReport.createNode("TC_ONEAPP-8855_NDID-BIO_SIT_01002");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Validate a display of NDID Deregistration Success screen\n" +
//                "- Android\n" +
//                "- Back to Service Page</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. The system display NDID Deregistration Success screen.\n" +
//                "- Display Deregister Date.\n" +
//                "- Display Reference No\n" +
//                "2. The customer press on Back to Service Page button, the system will navigate to Service page.</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : the system will display Disagree Biometric Consent pop-up. : " + TextColor.blueColor(elTitleNDIDError)
//                + "</br>Display Disagree Biometric Consent pop-up : " + TextColor.blueColor(elNDIDErrorDetail)
//                + "</br>Display button Confirm : " + TextColor.blueColor(elContactError)
//                + "</br>Display button Cancel : " + TextColor.blueColor(elBtnBackToMainMenu)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>the system will display Disagree Biometric Consent pop-up.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());


        Assert.assertTrue(elTitleNDIDError.equals("Cannot Verify Your Identity Digitally"));
        Assert.assertTrue(elNDIDErrorDetail.equals("Please bring your ID card to a ttb branch to apply identification and authentication service."));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Main Page"));

        BtnBackToMainMenu.click();
        getExtent().flush();
    }
}
