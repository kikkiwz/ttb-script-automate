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
import com.ttbbank.oneapp.framework.model.customerservice.NCB_custInfoValidation.custInfoValidationResponse;
import com.ttbbank.oneapp.framework.model.customerservice.NCB_eligibility.eligibilityResponse;
import com.ttbbank.oneapp.framework.model.customerservice.NCB_termNCondition.termNConditionResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResults;
import static com.ttbbank.oneapp.framework.utils.customerservice.CheckResult.CheckResultsReport;
import static com.ttbbank.oneapp.framework.utils.customerservice.FormatNumber.*;

public class NcbByPostScenario extends BaseScenario {
    String balanceBeforePayment = null;
    String accountBeforePayment = null;
    String datePayment = null;
    String RefNumber = null;
    String AccountNumberPayment = null;
    String CIDPayment = null;
    ArrayList<String> currentContext = new ArrayList<String>();
    TmbServiceResponse<eligibilityResponse> response = null;
    TmbServiceResponse<custInfoValidationResponse> responseCustInfoValidation = null;
    ExtentTest scenario = null;

    @Test(priority = 0, groups = "Customer Service NCB Report", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_10580_PBMFList_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON_NATIVE);

        scenario = getFeature().createNode(Scenario.class, "Ncb Payment by email");
        String ServiceScreenFirst = "images/NcbByPost_ServiceScreenFirst_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(ServiceScreenFirst);
        scenario.createNode(Given.class, "Service screen").addScreenCaptureFromPath(ServiceScreenFirst).pass("Pass");

        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        Thread.sleep(10000);
        ttbTestContext.tapCenter();
        String AccountSummary = "images/NcbByPost_AccountSummary_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(AccountSummary);
        scenario.createNode(Given.class, "Account summary screen").addScreenCaptureFromPath(AccountSummary).pass("Pass");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT1_ACCOUNT_SUMMARY);
        WebElement accountSummary = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT1_ACCOUNT_SUMMARY);
        accountSummary.click();
        Thread.sleep(10000);
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN, true);
            System.out.println("context : " + context);
            Set<String> webNames = context.getWindowHandles();
            System.out.println("webNames : " + webNames.toString());
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        } else {
            currentContext.add("aaaa");
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN, true, currentContext));
        }
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        WebElement accountNumber = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_ACCOUNT_DETAIL_SCREEN);
        accountBeforePayment = accountNumber.getText();
        WebElement balance = ttbTestContext.findElement(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN);
        balanceBeforePayment = balance.getText();
        System.out.println("balanceBeforePayment : " + balanceBeforePayment);

        String AccountDetail_validateBalance = "images/NcbByPost_AccountDetail_validateBalance_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(AccountDetail_validateBalance);
        scenario.createNode(Given.class, "Validate balance before NCB payment on account detail screen").addScreenCaptureFromPath(AccountDetail_validateBalance).pass("Pass");

        ttbTestContext.findElement(OneAppElementKeys.BTN_BACK_ACCOUNT_DETAIL_SCREEN).click();
        Thread.sleep(7000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.ACCOUNT_BUTTON, false);
        WebElement serviceButton = ttbTestContext.findElement(OneAppElementKeys.SERVICE_BUTTON);
        serviceButton.click();
        Thread.sleep(7000);

        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true);
            System.out.println("context : " + context);
            Set<String> webNames = context.getWindowHandles();
            System.out.println("webNames : " + webNames.toString());
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
            currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON, true, currentContext));
        }
        initToken();
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("serviceTypeId", "NCBR");
        Map<String, String> eqParamsHeader = new HashMap<>();
        eqParamsHeader.put("device-id", "FUzgnbIP/aegKo+se+1gkXhF9R3bWuIut4LF/TQyZUk1OvBUOeGZn0caYN3Lznn07USdt9JMmVyv1whHNTe40fHUBR5E8k+o7rh3byBLDJY9MY21UFv3p4iTLLSveC8WoavayzQvzSW2/i2AIpAEqhbm2N/8noU522mx7Rr6hnd8PQ0doeVvS2vBkeK9fJRuUVPUjd4CEdUDVAscz15fCuDFmIS6Gp3gAZ+gt2uLZIMtuiayQvVm9CuX+rKskZZOJCftpG3V6J7SYG1Y5mxKUbp+pZvEt1BxAlknGS/WoyyHl3COFALHlOD0rhb8k0RsnAwBljai7kADM+WaMgj4hg==");
        response = client.get("/apis/customer/NCB/eligibility", eqParams, eligibilityResponse.class, eqParamsHeader);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        Map<String, String> eqParamsInfoValidation = new HashMap<>();
        eqParamsInfoValidation.put("", "");
        responseCustInfoValidation = client.get("/apis/customer/NCB/custInfoValidation", eqParamsInfoValidation, custInfoValidationResponse.class);
        System.out.println("responseCustInfoValidation : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(responseCustInfoValidation));

        String AccountDetail_BackToService = "images/NcbByPost_AccountDetail_BackToService_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(AccountDetail_BackToService);
        scenario.createNode(Given.class, "Back to service screen").addScreenCaptureFromPath(AccountDetail_BackToService).pass("Pass");

        WebElement NCB = ttbTestContext.findElement(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON);
        NCB.click();
        try {
            WebElement titleTutorial = ttbTestContext.findElement(OneAppElementKeys.TITLE_TUTORIAL_SCREEN_NCB);
            String elTitleTutorial = titleTutorial.getText();
            WebElement tutorialDetail = ttbTestContext.findElement(OneAppElementKeys.DETAIL_TUTORIAL_NCB);
            String elTutorialDetail = tutorialDetail.getText();
            WebElement btnStart = ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_NCB);
            String elBtnStart = btnStart.getText();

            String result = "";
            result = CheckResults(elTitleTutorial, "NCB Report", result);
            result = CheckResults(elTutorialDetail, "Request for NCB Report while watching series. Just 150 THB for service fee.", result);
            result = CheckResults(elBtnStart, "Start", result);

            System.out.println("elTitleTutorial : " + elTitleTutorial);
            System.out.println("elTutorialDetail : " + elTutorialDetail);
            System.out.println("elBtnStart : " + elBtnStart);
            Thread.sleep(5000);

            String TutorialScreen = "images/NcbByPost_TutorialScreen_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(TutorialScreen);
            CheckResultsReport(scenario.createNode(Given.class, "If the customer first time usage, The system navigate to TutorialScreen").addScreenCaptureFromPath(TutorialScreen), result);

            Assert.assertTrue(elTitleTutorial.equals("NCB Report"));
            Assert.assertTrue(elTutorialDetail.equals("Request for NCB Report while watching series. Just 150 THB for service fee."));
            Assert.assertTrue(elBtnStart.equals("Start"));
            btnStart.click();
        } catch (Exception e) {
            String WithoutGoTutorial = "images/NcbByPost_WithoutGoTutorial_" + ttbTestContext.getPlateFormName() + ".png";
            takeScreenshot(WithoutGoTutorial);
            scenario.createNode(Given.class, "If the customer has already logged in for the first time, the system navigate to select the account screen without going through tutorial screen.").addScreenCaptureFromPath(WithoutGoTutorial).pass("Pass");
        }

    }

    @Test(priority = 1, groups = "Customer Service NCB Report select delivery method")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00002() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement HeaderDeliveryScreen = ttbTestContext.findElement(OneAppElementKeys.TITLE_NCB_SCREEN_1);
        String elHeaderDeliveryScreen = HeaderDeliveryScreen.getText();
        WebElement ProcessRunning = ttbTestContext.findElement(OneAppElementKeys.NUMBER_PROCESS_1_NCB);
        String elProcessRunning = ProcessRunning.getText();
        WebElement labelProcess = ttbTestContext.findElement(OneAppElementKeys.LABEL_PROCESS_1_NCB);
        String elLabelProcess = labelProcess.getText();
        WebElement ByEmail = ttbTestContext.findElement(OneAppElementKeys.LABEL_BY_EMAIL);
        String elByEmail = ByEmail.getText();
        WebElement PeriodByEmail = ttbTestContext.findElement(OneAppElementKeys.LABEL_PERIOD_EMAIL);
        String elPeriodByEmail = PeriodByEmail.getText();
        WebElement ByPost = ttbTestContext.findElement(OneAppElementKeys.LABEL_BY_POST);
        String elByPost = ByPost.getText();
        WebElement PeriodByPost = ttbTestContext.findElement(OneAppElementKeys.LABEL_PERIOD_POST);
        String elPeriodByPost = PeriodByPost.getText();
        WebElement Note1 = ttbTestContext.findElement(OneAppElementKeys.MESSAGE_BOX_1_NCB);
        String elNote1 = Note1.getText();
        WebElement Note2 = ttbTestContext.findElement(OneAppElementKeys.MESSAGE_BOX_2_NCB);
        String elNote2 = Note2.getText();
        WebElement Next = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_1_NCB);
        String elNext = Next.getText();
        System.err.println("get element : " + elHeaderDeliveryScreen);
        System.err.println("get element : " + elProcessRunning);
        System.err.println("get elLabelProcess : " + elLabelProcess);
        System.err.println("get element : " + elByEmail);
        System.err.println("get element : " + elPeriodByEmail);
        System.err.println("get element : " + elByPost);
        System.err.println("get element : " + elPeriodByPost);
        System.err.println("get Note1 : " + elNote1);
        System.err.println("get elNote2 : " + elNote2);
        System.err.println("get elNext : " + elNext);

        String result = "";
        result = CheckResults(elHeaderDeliveryScreen, "NCB Report", result);
        result = CheckResults(elProcessRunning, "1 / 4", result);
        result = CheckResults(elLabelProcess, "Select Delivery Method", result);
        result = CheckResults(elByEmail, "By E-mail", result);
        result = CheckResults(elPeriodByEmail, "within 3 business days", result);
        result = CheckResults(elByPost, "By Post", result);
        result = CheckResults(elPeriodByPost, "within 7 business days", result);
        result = CheckResults(elNote1, "Service fee 150 baht.", result);
        result = CheckResults(elNote2, "Requests after 11.00 p.m. will take effect on a next business day.", result);
        result = CheckResults(elNext, "Next", result);

        String isNotSelectDelivery = "images/NcbByPost_isNotSelectDelivery_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(isNotSelectDelivery);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer isn't select delivery method, Button next is disable").addScreenCaptureFromPath(isNotSelectDelivery), result);

        ByPost.click();

        String SelectDelivery = "images/NcbByPost_SelectDelivery_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(SelectDelivery);
        CheckResultsReport(scenario.createNode(Given.class, "(In case select by post) If the customer has already selected delivery method The button next will be enable.").addScreenCaptureFromPath(SelectDelivery), result);

        Next.click();

        Assert.assertTrue(elHeaderDeliveryScreen.equals("NCB Report"));
        Assert.assertTrue(elProcessRunning.equals("1 / 4"));
        Assert.assertTrue(elLabelProcess.equals("Select Delivery Method"));
        Assert.assertTrue(elByEmail.equals("By E-mail"));
        Assert.assertTrue(elPeriodByEmail.equals("within 3 business days"));
        Assert.assertTrue(elByPost.equals("By Post"));
        Assert.assertTrue(elPeriodByPost.equals("within 7 business days"));
        Assert.assertTrue(elNote1.equals("Service fee 150 baht."));
        Assert.assertTrue(elNote2.equals("Requests after 11.00 p.m. will take effect on a next business day."));
        Assert.assertTrue(elNext.equals("Next"));
    }

    @Test(priority = 2, groups = "Customer Service NCB Report information")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00003() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\"]")));
        (new WebDriverWait(ttbTestContext.getDriver(), 40)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id=\"request_ncb_report_edit_post_profile_id_number_desc\"]")));
        WebElement HeaderDeliveryScreen = ttbTestContext.findElement(OneAppElementKeys.TITLE_NCB_SCREEN_2);
        String elHeaderDeliveryScreen = HeaderDeliveryScreen.getText();
        WebElement ProcessRunning = ttbTestContext.findElement(OneAppElementKeys.NUMBER_PROCESS_1_NCB);
        String elProcessRunning = ProcessRunning.getText();
        WebElement LabelProcess = ttbTestContext.findElement(OneAppElementKeys.LABEL_PROCESS_1_NCB);
        String elLabelProcess = LabelProcess.getText();
        WebElement Information = ttbTestContext.findElement(OneAppElementKeys.LABEL_CHECK_INFORMATION_PROCESS_2_NCB);
        String elInformation = Information.getText();
        WebElement LabelName = ttbTestContext.findElement(OneAppElementKeys.LABEL_NAME_LASTNAME_PROCESS_2_NCB);
        String elLabelName = LabelName.getText();
        String elName_Surname = "";
        while (true){
            if(!ttbTestContext.findElement(OneAppElementKeys.NAME_LASTNAME_VALUE_PROCESS_2_NCB).getText().toLowerCase().equals("undefined") && !ttbTestContext.findElement(OneAppElementKeys.NAME_LASTNAME_VALUE_PROCESS_2_NCB).getText().equals("")){
                WebElement Name_Surname = ttbTestContext.findElement(OneAppElementKeys.NAME_LASTNAME_VALUE_PROCESS_2_NCB);
                elName_Surname = Name_Surname.getText();
                System.err.println("elName_Surname : " + elName_Surname);
                break;
            }
        }
        WebElement IDNumber = ttbTestContext.findElement(OneAppElementKeys.LABEL_CID_PROCESS_2_NCB);
        String elIDNumber = IDNumber.getText();
        WebElement IDNumberValue = ttbTestContext.findElement(OneAppElementKeys.CID_VALUE_PROCESS_2_NCB);
        String elIDNumberValue = IDNumberValue.getText();
        WebElement LabelMobileNumber = ttbTestContext.findElement(OneAppElementKeys.LABEL_MOBILE_NUMBER_PROCESS_2_NCB);
        String elLabelMobileNumber = LabelMobileNumber.getText();
        WebElement MobileNumber = ttbTestContext.findElement(OneAppElementKeys.MOBILE_NUMBER_VALUE_PROCESS_2_NCB);
        String elMobileNumber = MobileNumber.getText();
        WebElement btnEditMobile = ttbTestContext.findElement(OneAppElementKeys.EDIT_BTN_MOBILE_NUMBER_PROCESS_2_NCB);
        String elBtnEditMobile = btnEditMobile.getText();
        WebElement LabelDeliveryMethod = ttbTestContext.findElement(OneAppElementKeys.LABEL_DELIVERY_METHOD_PROCESS_2_NCB);
        String elLabelDeliveryMethod = LabelDeliveryMethod.getText();
        WebElement DeliveryMethod = ttbTestContext.findElement(OneAppElementKeys.DELIVERY_METHOD_VALUE_PROCESS_2_NCB);
        String elDeliveryMethod = DeliveryMethod.getText();
        WebElement LabelAddress = ttbTestContext.findElement(OneAppElementKeys.LABEL_ADDRESS_PROCESS_2_NCB);
        String elLabelAddress = LabelAddress.getText();
        WebElement Address = ttbTestContext.findElement(OneAppElementKeys.ADDRESS_VALUE_PROCESS_2_NCB);
        String elAddress = Address.getText();
        WebElement btnEditAddress = ttbTestContext.findElement(OneAppElementKeys.EDIT_BTN_ADDRESS_PROCESS_2_NCB);
        String elBtnEditAddress = btnEditAddress.getText();

        String checkTheAccuracyOfInformation = "images/NcbByPost_checkTheAccuracyOfInformation_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(checkTheAccuracyOfInformation);
        scenario.createNode(Given.class, "If the customer can check the accuracy of information").addScreenCaptureFromPath(checkTheAccuracyOfInformation).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.ADDRESS_VALUE_PROCESS_2_NCB, true);
        WebElement btnNext = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_2_NCB);
        String elBtnNext = btnNext.getText();
        System.err.println("elHeaderDeliveryScreen : " + elHeaderDeliveryScreen);
        System.err.println("elProcessRunning : " + elProcessRunning);
        System.err.println("elLabelProcess : " + elLabelProcess);
        System.err.println("elInformation : " + elInformation);
        System.err.println("elLabelName : " + elLabelName);
        System.err.println("elName_Surname : " + elName_Surname);
        System.err.println("elIDNumber : " + elIDNumber);
        System.err.println("elIDNumberValue : " + elIDNumberValue);
        System.err.println("elLabelMobileNumber : " + elLabelMobileNumber);
        System.err.println("elMobileNumber : " + elMobileNumber);
        System.err.println("elLabelDeliveryMethod : " + elLabelDeliveryMethod);
        System.err.println("elDeliveryMethod : " + elDeliveryMethod);
        System.err.println("elLabelAddress : " + elLabelAddress);
        System.err.println("elAddress : " + elAddress);
        System.err.println("elBtnEditMobile : " + elBtnEditMobile);
        System.err.println("elBtnEditAddress : " + elBtnEditAddress);
        System.err.println("elBtnNext : " + elBtnNext);

        String result = "";
        result = CheckResults(elHeaderDeliveryScreen, "NCB Report", result);
        result = CheckResults(elProcessRunning, "2 / 4", result);
        result = CheckResults(elLabelProcess, "Delivery Details", result);
        result = CheckResults(elInformation, "Please check the accuracy of information", result);
        result = CheckResults(elLabelName, "First name - Last name", result);
        result = CheckResults(elIDNumber, "Citizen ID number", result);
        result = CheckResults(elLabelMobileNumber, "Mobile number", result);
        result = CheckResults(elLabelDeliveryMethod, "Delivery method", result);
        result = CheckResults(elLabelAddress, "Delivery address", result);
        result = CheckResults(elName_Surname, responseCustInfoValidation.getData().first_name_en + " " + responseCustInfoValidation.getData().last_name_en, result);
        System.err.println("national_id : " + formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#"));
        result = CheckResults(elIDNumberValue, formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#"), result);
        System.err.println("mobile_no : " + formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####"));
        result = CheckResults(elMobileNumber, formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####"), result);
        result = CheckResults(elAddress, responseCustInfoValidation.getData().delivery_address, result);
        result = CheckResults(elDeliveryMethod, "By post", result);
        result = CheckResults(elBtnEditMobile, "Edit", result);
        result = CheckResults(elBtnEditAddress, "Edit", result);
        result = CheckResults(elBtnNext, "Next", result);

        String checkTheAccuracyOfInformation2 = "images/NcbByPost_checkTheAccuracyOfInformation2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(checkTheAccuracyOfInformation2);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer can check the accuracy of information").addScreenCaptureFromPath(checkTheAccuracyOfInformation2), result);

        btnNext.click();

        Assert.assertTrue(elHeaderDeliveryScreen.equals("NCB Report"));
        Assert.assertTrue(elProcessRunning.equals("2 / 4"));
        Assert.assertTrue(elLabelProcess.equals("Delivery Details"));
        Assert.assertTrue(elInformation.equals("Please check the accuracy of information"));
        Assert.assertTrue(elLabelName.equals("First name - Last name"));
        Assert.assertTrue(elIDNumber.equals("Citizen ID number"));
        Assert.assertTrue(elLabelMobileNumber.equals("Mobile number"));
        Assert.assertTrue(elLabelDeliveryMethod.equals("Delivery method"));
        Assert.assertTrue(elLabelAddress.equals("Delivery address"));
        Assert.assertTrue(elName_Surname.equals(responseCustInfoValidation.getData().first_name_en + " " + responseCustInfoValidation.getData().last_name_en));
        System.err.println("national_id : " + formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#"));
        Assert.assertTrue(elIDNumberValue.equals(formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#")));
        System.err.println("mobile_no : " + formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####"));
        Assert.assertTrue(elMobileNumber.equals(formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####")));
        Assert.assertTrue(elAddress.equals(responseCustInfoValidation.getData().delivery_address));
        Assert.assertTrue(elDeliveryMethod.equals("By post"));
        Assert.assertTrue(elBtnEditMobile.equals("Edit"));
        Assert.assertTrue(elBtnEditAddress.equals("Edit"));
        Assert.assertTrue(elBtnNext.equals("Next"));
    }

    @Test(priority = 3, groups = "Customer Service NCB Report term and condition")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00004() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParamsTermNCondition = new HashMap<>();
        eqParamsTermNCondition.put("", "");
        TmbServiceResponse<termNConditionResponse> responseTermNCondition = client.get("/apis/customer/termNCondition/NCB_POST", eqParamsTermNCondition, termNConditionResponse.class);
        System.out.println("responseCustInfoValidation : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(responseTermNCondition));
        WebElement HeaderT_C = ttbTestContext.findElement(OneAppElementKeys.TITLE_NCB_T_C_SCREEN);
        String elHeaderT_C = HeaderT_C.getText();
        WebElement T_C_detail = ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CONDITIONS_POST_NCB);
        String elT_C_detail = T_C_detail.getText().replaceAll("\n","");

        String TermAndCondition_beforeAccept = "images/NcbByPost_TermAndCondition_beforeAccept_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(TermAndCondition_beforeAccept);
        scenario.createNode(Given.class, "If the customer isn't a checkbox, accept the terms and conditions. Next button is enable.").addScreenCaptureFromPath(TermAndCondition_beforeAccept).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.CHECKBOX_TERM_AND_CONDITIONS_NCB, true);
        WebElement AcceptT_C = ttbTestContext.findElement(OneAppElementKeys.CHECKBOX_TERM_AND_CONDITIONS_NCB);
        String elAcceptT_C = AcceptT_C.getText();
        WebElement BtnNextT_C = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_T_C_NCB);
        String elBtnNextT_C = BtnNextT_C.getText();
        System.err.println("elHeaderT_C : " + elHeaderT_C);
        System.err.println("elAcceptT_C : " + elAcceptT_C);
        System.err.println("elT_C_detail : " + elT_C_detail);
        System.err.println("elBtnNextT_C : " + elBtnNextT_C);

        String term_n_condition_en = responseTermNCondition.getData().term_n_condition_en.replaceAll("<br>", "").replaceAll("<b>","").replaceAll("</b>","");

        String result = "";
        result = CheckResults(elHeaderT_C, "Terms and Conditions", result);
        result = CheckResults(elT_C_detail, term_n_condition_en, result);
        result = CheckResults(elAcceptT_C, "I have read and agree to terms and conditions", result);
        result = CheckResults(elBtnNextT_C, "Next", result);

        String TermAndCondition_beforeAccept2 = "images/NcbByPost_TermAndCondition_beforeAccept2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(TermAndCondition_beforeAccept2);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer isn't a checkbox, accept the terms and conditions. Next button is enable.").addScreenCaptureFromPath(TermAndCondition_beforeAccept2), result);

        AcceptT_C.click();

        String TermAndCondition_AfterAccept = "images/NcbByPost_TermAndCondition_AfterAccept_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(TermAndCondition_AfterAccept);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer is Tmb@12345a checkbox, accept the terms and conditions. Next button is enable.").addScreenCaptureFromPath(TermAndCondition_AfterAccept), result);

        BtnNextT_C.click();

        Assert.assertTrue(elHeaderT_C.equals("Terms and Conditions"));
        Assert.assertTrue(elT_C_detail.equals(term_n_condition_en));
        Assert.assertTrue(elAcceptT_C.equals("I have read and agree to terms and conditions"));
        Assert.assertTrue(elBtnNextT_C.equals("Next"));
    }

    @Test(priority = 4, groups = "Customer Service NCB Report select account")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00005() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        WebElement HeaderNcb = ttbTestContext.findElement(OneAppElementKeys.TITLE_NCB_SCREEN_3);
        String elHeaderNcb = HeaderNcb.getText();
        WebElement labelSelectAccount = ttbTestContext.findElement(OneAppElementKeys.LABEL_SELECT_ACCOUNT_NCB);
        String elLabelSelectAccount = labelSelectAccount.getText();
        WebElement accountName1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_1_NCB_SELECT_ACCOUNT);
        String elAccountName1 = accountName1.getText();
        WebElement accountNumber1 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_1_NCB_SELECT_ACCOUNT);
        String elAccountNumber1 = accountNumber1.getText();
        WebElement balance1 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_1_NCB_SELECT_ACCOUNT);
        String elBalance1 = balance1.getText();
//        WebElement accountName2 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NAME_2_NCB_SELECT_ACCOUNT);
//        String elAccountName2 = accountName2.getText();
//        WebElement accountNumber2 = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_2_NCB_SELECT_ACCOUNT);
//        String elAccountNumber2 = accountNumber2.getText();
//        WebElement balance2 = ttbTestContext.findElement(OneAppElementKeys.BALANCE_2_NCB_SELECT_ACCOUNT);
//        String elBalance2 = balance2.getText();
        WebElement btnNext = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_3_NCB);
        String elBtnNext = btnNext.getText();

        System.err.println("elHeaderNcb : " + elHeaderNcb);
        System.err.println("elLabelSelectAccount : " + elLabelSelectAccount);
        System.err.println("elAccountName1 : " + elAccountName1);
        System.err.println("elAccountNumber1 : " + elAccountNumber1);
        System.err.println("elBalance1 : " + elBalance1);
//        System.err.println("elAccountName2 : " + elAccountName2);
//        System.err.println("elAccountNumber2 : " + elAccountNumber2);
//        System.err.println("elBalance2 : " + elBalance2);
        System.err.println("elBtnNext : " + elBtnNext);

        String result = "";
        result = CheckResults(elHeaderNcb, "NCB Report", result);
        result = CheckResults(elLabelSelectAccount, "Select account to pay 150 baht fee", result);
        String accountNameEn1 = (response.getData().account_list.get(0).accountNickName == null) ? response.getData().account_list.get(0).productNameEn : response.getData().account_list.get(0).accountNickName;
        result = CheckResults(elAccountName1, accountNameEn1, result);
        System.err.println("formatAccount : " + formatAccount(response.getData().account_list.get(0).accountNumber, "XXX-X-XX###-#"));
        result = CheckResults(elAccountNumber1, formatAccount(response.getData().account_list.get(0).accountNumber, "XXX-X-XX###-#"), result);
        double balanceApi1 = Double.parseDouble(response.getData().account_list.get(0).currentBalance);
        System.err.println("formatBalance : " + formatBalance(balanceApi1));
        result = CheckResults(elBalance1, formatBalance(balanceApi1), result);
        result = CheckResults(elBtnNext, "Next", result);

        String BeforeSelectAccount = "images/NcbByPost_BeforeSelectAccount_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(BeforeSelectAccount);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer isn't select account. Next button is enable.").addScreenCaptureFromPath(BeforeSelectAccount), result);

        accountName1.click();

        String AfterSelectAccount = "images/NcbByPost_AfterSelectAccount_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(AfterSelectAccount);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer is select account. Next button is enable.").addScreenCaptureFromPath(AfterSelectAccount), result);

        btnNext.click();

        Assert.assertTrue(elHeaderNcb.equals("NCB Report"));
        Assert.assertTrue(elLabelSelectAccount.equals("Select account to pay 150 baht fee"));
        Assert.assertTrue(elAccountName1.equals(accountNameEn1));
        System.err.println("formatAccount : " + formatAccount(response.getData().account_list.get(0).accountNumber, "XXX-X-XX###-#"));
        Assert.assertTrue(elAccountNumber1.equals(formatAccount(response.getData().account_list.get(0).accountNumber, "XXX-X-XX###-#")));
        System.err.println("formatBalance : " + formatBalance(balanceApi1));
        Assert.assertTrue(elBalance1.equals(formatBalance(balanceApi1)));
        Assert.assertTrue(elBtnNext.equals("Next"));
    }

    @Test(priority = 5, groups = "Customer Service NCB Report review information")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00006() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_NCB_SCREEN_4);
        String elHeader = Header.getText();
        WebElement ProcessRunning = ttbTestContext.findElement(OneAppElementKeys.NUMBER_PROCESS_1_NCB);
        String elProcessRunning = ProcessRunning.getText();
        WebElement labelProcess = ttbTestContext.findElement(OneAppElementKeys.LABEL_PROCESS_1_NCB);
        String elLabelProcess = labelProcess.getText();
        WebElement Item = ttbTestContext.findElement(OneAppElementKeys.LABEL_ITEM_VALUE_PROCESS_4_NCB);
        String elItem = Item.getText();
        WebElement ItemDetail = ttbTestContext.findElement(OneAppElementKeys.ITEM_VALUE_PROCESS_4_NCB);
        String elItemDetail = ItemDetail.getText();
        WebElement LabelDelivery = ttbTestContext.findElement(OneAppElementKeys.LABEL_DELIVERY_METHOD_PROCESS_4_NCB);
        String elLabelDelivery = LabelDelivery.getText();
        WebElement DeliveryDetail = ttbTestContext.findElement(OneAppElementKeys.DELIVERY_METHOD_PROCESS_4_NCB);
        String elDeliveryDetail = DeliveryDetail.getText();
        WebElement LabelEmail = ttbTestContext.findElement(OneAppElementKeys.LABEL_EMAIL_PROCESS_4_NCB);
        String elLabelEmail = LabelEmail.getText();
        WebElement Email = ttbTestContext.findElement(OneAppElementKeys.EMAIL_VALUE_PROCESS_4_NCB);
        String elEmail = Email.getText();
        WebElement LabelFrom = ttbTestContext.findElement(OneAppElementKeys.LABEL_PAID_FROM_PROCESS_4_NCB);
        String elLabelFrom = LabelFrom.getText();
        WebElement FromDetail = ttbTestContext.findElement(OneAppElementKeys.PAID_FROM_VALUE_PROCESS_4_NCB);
        String elFromDetail = FromDetail.getText();
        WebElement LabelFee = ttbTestContext.findElement(OneAppElementKeys.LABEL_SERVICE_FEE_PROCESS_4_NCB);
        String elLabelFee = LabelFee.getText();
        WebElement Fee_Amount = ttbTestContext.findElement(OneAppElementKeys.SERVICE_FEE_VALUE_PROCESS_4_NCB);
        String elFee_Amount = Fee_Amount.getText();
        WebElement LabelName = ttbTestContext.findElement(OneAppElementKeys.LABEL_NAME_LASTNAME_PROCESS_4_NCB);
        String elLabelName = LabelName.getText();
        WebElement Name_Surname = ttbTestContext.findElement(OneAppElementKeys.NAME_LASTNAME_VALUE_PROCESS_4_NCB);
        String elName_Surname = Name_Surname.getText();
        WebElement LabelIDNumber = ttbTestContext.findElement(OneAppElementKeys.LABEL_CID_PROCESS_4_NCB);
        String elLabelIDNumber = LabelIDNumber.getText();
        WebElement IDNumber = ttbTestContext.findElement(OneAppElementKeys.CID_VALUE_PROCESS_4_NCB);
        String elIDNumber = IDNumber.getText();

        String accountNameEn1 = (response.getData().account_list.get(0).accountNickName == null) ? response.getData().account_list.get(0).productNameEn : response.getData().account_list.get(0).accountNickName;
        String result = "";
        result = CheckResults(elHeader, "NCB Report", result);
        result = CheckResults(elProcessRunning, "4 / 4", result);
        result = CheckResults(elLabelProcess, "View and Confirm", result);
        result = CheckResults(elItem, "Item", result);
        result = CheckResults(elItemDetail, "1 credit report", result);
        result = CheckResults(elLabelDelivery, "Delivery method", result);
        result = CheckResults(elDeliveryDetail, "By post", result);
        result = CheckResults(elLabelEmail, "E-mail", result);
        result = CheckResults(elEmail, responseCustInfoValidation.getData().email, result);
        result = CheckResults(elLabelFrom, "Service fee paid from", result);
        result = CheckResults(elFromDetail, accountNameEn1 + " " + response.getData().account_list.get(0).accountNumber, result);
        result = CheckResults(elLabelFee, "Service fee", result);
        result = CheckResults(elFee_Amount, "150.00", result);
        result = CheckResults(elLabelName, "First name - Last name", result);
        result = CheckResults(elName_Surname, responseCustInfoValidation.getData().first_name_en + " " + responseCustInfoValidation.getData().last_name_en, result);
        result = CheckResults(elLabelIDNumber, "Citizen ID number", result);
        System.out.println("national_id : " + formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#"));
        result = CheckResults(elIDNumber, formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#"), result);

        String reviewInformation = "images/NcbByPost_reviewInformation_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(reviewInformation);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer can check the accuracy of information on review screen").addScreenCaptureFromPath(reviewInformation), result);

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_MOBILE_PROCESS_4_NCB, true);
        WebElement LabelMobileNo = ttbTestContext.findElement(OneAppElementKeys.LABEL_MOBILE_PROCESS_4_NCB);
        String elLabelMobileNo = LabelMobileNo.getText();
        WebElement MobileNo = ttbTestContext.findElement(OneAppElementKeys.MOBILE_VALUE_PROCESS_4_NCB);
        String elMobileNo = MobileNo.getText();
        WebElement LabelAddress = ttbTestContext.findElement(OneAppElementKeys.LABEL_ADDRESS_PROCESS_4_NCB);
        String elLabelAddress = LabelAddress.getText();
        WebElement Address = ttbTestContext.findElement(OneAppElementKeys.ADDRESS_VALUE_PROCESS_4_NCB);
        String elAddress = Address.getText();
        WebElement Note = ttbTestContext.findElement(OneAppElementKeys.REMARK_PROCESS_4_NCB);
        String elNote = Note.getText();
        WebElement btnNext = ttbTestContext.findElement(OneAppElementKeys.BTN_NEXT_4_NCB);
        String elBtnNext = btnNext.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elProcessRunning : " + elProcessRunning);
        System.err.println("elLabelProcess : " + elLabelProcess);
        System.err.println("elItem : " + elItem);
        System.err.println("elItemDetail : " + elItemDetail);
        System.err.println("elLabelDelivery : " + elLabelDelivery);
        System.err.println("elDeliveryDetail : " + elDeliveryDetail);
        System.err.println("elLabelFrom : " + elLabelFrom);
        System.err.println("elFromDetail : " + elFromDetail);
        System.err.println("elLabelFee : " + elLabelFee);
        System.err.println("elFee_Amount : " + elFee_Amount);
        System.err.println("elLabelName : " + elLabelName);
        System.err.println("elName_Surname : " + elName_Surname);
        System.err.println("elLabelIDNumber : " + elLabelIDNumber);
        System.err.println("elIDNumber : " + elIDNumber);
        System.err.println("elLabelMobileNo : " + elLabelMobileNo);
        System.err.println("elMobileNo : " + elMobileNo);
        System.err.println("elLabelEmail : " + elLabelEmail);
        System.err.println("elEmail : " + elEmail);
        System.err.println("elLabelAddress : " + elLabelAddress);
        System.err.println("elEmail : " + elAddress);
        System.err.println("elNote : " + elNote);
        System.err.println("elNote : " + elBtnNext);

        result = "";
        result = CheckResults(elLabelMobileNo, "Mobile number", result);
        System.out.println("MoNo : " + formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####"));
        result = CheckResults(elMobileNo, formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####"), result);
        result = CheckResults(elLabelAddress, "Delivery address", result);
        result = CheckResults(elAddress, responseCustInfoValidation.getData().delivery_address, result);
        result = CheckResults(elNote, "Credit report will be sent by post within 7 business days.", result);
        result = CheckResults(elBtnNext, "Confirm", result);

        String reviewInformation2 = "images/NcbByPost_reviewInformation2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(reviewInformation2);
        CheckResultsReport(scenario.createNode(Given.class, "If the customer can check the accuracy of information on review screen").addScreenCaptureFromPath(reviewInformation2), result);

        btnNext.click();
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, false);

        String ConfirmPin = "images/NcbByPost_ConfirmPin_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(ConfirmPin);
        CheckResultsReport(scenario.createNode(Given.class, "After click Confirm button. The system navigate to pin screen").addScreenCaptureFromPath(ConfirmPin), result);
        confirmPin();

        Assert.assertTrue(elHeader.equals("NCB Report"));
        Assert.assertTrue(elProcessRunning.equals("4 / 4"));
        Assert.assertTrue(elLabelProcess.equals("View and Confirm"));
        Assert.assertTrue(elItem.equals("Item"));
        Assert.assertTrue(elItemDetail.equals("1 credit report"));
        Assert.assertTrue(elLabelDelivery.equals("Delivery method"));
        Assert.assertTrue(elDeliveryDetail.equals("By post"));
        Assert.assertTrue(elLabelEmail.equals("E-mail"));
        Assert.assertTrue(elEmail.equals(responseCustInfoValidation.getData().email));
        Assert.assertTrue(elLabelFrom.equals("Service fee paid from"));
        Assert.assertTrue(elFromDetail.equals(accountNameEn1 + " " + response.getData().account_list.get(0).accountNumber));
        Assert.assertTrue(elLabelFee.equals("Service fee"));
        Assert.assertTrue(elFee_Amount.equals("150.00"));
        Assert.assertTrue(elLabelName.equals("First name - Last name"));
        Assert.assertTrue(elName_Surname.equals(responseCustInfoValidation.getData().first_name_en + " " + responseCustInfoValidation.getData().last_name_en));
        Assert.assertTrue(elLabelIDNumber.equals("Citizen ID number"));
        System.out.println("national_id : " + formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#"));
        Assert.assertTrue(elIDNumber.equals(formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#")));
        Assert.assertTrue(elLabelMobileNo.equals("Mobile number"));
        System.out.println("MoNo : " + formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####"));
        Assert.assertTrue(elMobileNo.equals(formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####")));
        Assert.assertTrue(elLabelAddress.equals("Delivery address"));
        Assert.assertTrue(elAddress.equals(responseCustInfoValidation.getData().delivery_address));
        Assert.assertTrue(elNote.equals("Credit report will be sent by post within 7 business days."));
        Assert.assertTrue(elBtnNext.equals("Confirm"));
    }


    @Test(priority = 6, groups = "Customer Service NCB Report confirm pin and success payment")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00007() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        ttbTestContext.setContextToWebView(OneAppElementKeys.BTN_NEXT_4_NCB, true);
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        WebElement Success = ttbTestContext.findElement(OneAppElementKeys.LABEL_SUCCESS_NCB);
        String elSuccess = Success.getText();
        WebElement SuccessDetail = ttbTestContext.findElement(OneAppElementKeys.DETAIL_SUCCESS_NCB);
        String elSuccessDetail = SuccessDetail.getText();
        WebElement Request = ttbTestContext.findElement(OneAppElementKeys.REQUEST_DETAIL_SUCCESS_NCB);
        String elRequest = Request.getText();
        WebElement Item = ttbTestContext.findElement(OneAppElementKeys.LABEL_ITEM_SUCCESS_NCB);
        String elItem = Item.getText();
        WebElement ItemDetail = ttbTestContext.findElement(OneAppElementKeys.ITEM_VALUE_SUCCESS_NCB);
        String elItemDetail = ItemDetail.getText();
        WebElement LabelDelivery = ttbTestContext.findElement(OneAppElementKeys.LABEL_DELIVERY_METHOD_SUCCESS_NCB);
        String elLabelDelivery = LabelDelivery.getText();
        WebElement DeliveryDetail = ttbTestContext.findElement(OneAppElementKeys.DELIVERY_METHOD_SUCCESS_NCB);
        String elDeliveryDetail = DeliveryDetail.getText();
        WebElement LabelFee = ttbTestContext.findElement(OneAppElementKeys.LABEL_SERVICE_FEE_SUCCESS_NCB);
        String elLabelFee = LabelFee.getText();
        WebElement Fee_Amount = ttbTestContext.findElement(OneAppElementKeys.SERVICE_FEE_VALUE_SUCCESS_NCB);
        String elFee_Amount = Fee_Amount.getText();
        WebElement PayFrom = ttbTestContext.findElement(OneAppElementKeys.LABEL_PAID_FROM_SUCCESS_NCB);
        String elPayFrom = PayFrom.getText();
        WebElement AccNo = ttbTestContext.findElement(OneAppElementKeys.PAID_FROM_VALUE_SUCCESS_NCB);
        String elAccNo = AccNo.getText();
        AccountNumberPayment = elAccNo;
        WebElement Requester = ttbTestContext.findElement(OneAppElementKeys.LABEL_REQUEST_DETAIL_SUCCESS_NCB);
        String elRequester = Requester.getText();
        WebElement LabelName = ttbTestContext.findElement(OneAppElementKeys.LABEL_NAME_LASTNAME_SUCCESS_NCB);
        String elLabelName = LabelName.getText();
        WebElement Name_Surname = ttbTestContext.findElement(OneAppElementKeys.NAME_LASTNAME_SUCCESS_NCB);
        String elName_Surname = Name_Surname.getText();
        WebElement LabelIDNumber = ttbTestContext.findElement(OneAppElementKeys.LABEL_CID_SUCCESS_NCB);
        String elLabelIDNumber = LabelIDNumber.getText();
        WebElement IDNumber = ttbTestContext.findElement(OneAppElementKeys.CID_VALUE_SUCCESS_NCB);
        String elIDNumber = IDNumber.getText();
        CIDPayment = elIDNumber.replaceAll("-","");
        WebElement LabelMobileNumber = ttbTestContext.findElement(OneAppElementKeys.LABEL_MOBILE_SUCCESS_NCB);
        String elLabelMobileNumber = LabelMobileNumber.getText();
        WebElement MobileNumber = ttbTestContext.findElement(OneAppElementKeys.MOBILE_VALUE_SUCCESS_NCB);
        String elMobileNumber = MobileNumber.getText();

        String SuccessScreen1 = "images/NcbByPost_SuccessScreen1_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(SuccessScreen1);
        scenario.createNode(Given.class, "After confirm pin, The system navigate to success payment screen").addScreenCaptureFromPath(SuccessScreen1).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_ADDRESS_SUCCESS_NCB, true);
        WebElement LabelAddress = ttbTestContext.findElement(OneAppElementKeys.LABEL_ADDRESS_SUCCESS_NCB);
        String elLabelAddress = LabelAddress.getText();
        WebElement addressValue = ttbTestContext.findElement(OneAppElementKeys.ADDRESS_VALUE_SUCCESS_NCB);
        String elAddressValue = addressValue.getText();
        WebElement labelEmail = ttbTestContext.findElement(OneAppElementKeys.LABEL_EMAIL_POST_SUCCESS_NCB);
        String elLabelEmail = labelEmail.getText();
        WebElement emailValue = ttbTestContext.findElement(OneAppElementKeys.EMAIL_VALUE_POST_SUCCESS_NCB);
        String elEmailValue = emailValue.getText();
        WebElement labelRequestDate = ttbTestContext.findElement(OneAppElementKeys.LABEL_REQUEST_DATE_SUCCESS_NCB);
        String elLabelRequestDate = labelRequestDate.getText();
        WebElement requestDateValue = ttbTestContext.findElement(OneAppElementKeys.REQUEST_DATE_VALUE_SUCCESS_NCB);
        String elRequestDateValue = requestDateValue.getText();
        datePayment = elRequestDateValue;
        WebElement labelRefNo = ttbTestContext.findElement(OneAppElementKeys.LABEL_REF_NO_SUCCESS_NCB);
        String elLabelRefNo = labelRefNo.getText();
        WebElement refNo = ttbTestContext.findElement(OneAppElementKeys.REF_NO_VALUE_SUCCESS_NCB);
        String elRefNo = refNo.getText();
        RefNumber = elRefNo;
        WebElement contact = ttbTestContext.findElement(OneAppElementKeys.CONTACT_TTB_SUCCESS_NCB);
        String elContact = contact.getText();
        WebElement btnBackToServicePage = ttbTestContext.findElement(OneAppElementKeys.BTN_BACK_TO_SERVICE_PAGE_SUCCESS_NCB);
        String elBtnBackToServicePage = btnBackToServicePage.getText();
        System.err.println("elSuccess : " + elSuccess);
        System.err.println("elSuccessDetail : " + elSuccessDetail);
        System.err.println("elRequest : " + elRequest);
        System.err.println("elItem : " + elItem);
        System.err.println("elItemDetail : " + elItemDetail);
        System.err.println("elLabelDelivery : " + elLabelDelivery);
        System.err.println("elDeliveryDetail : " + elDeliveryDetail);
        System.err.println("elLabelEmail : " + elLabelEmail);
        System.err.println("elEmailValue : " + elEmailValue);
        System.err.println("elLabelFee : " + elLabelFee);
        System.err.println("elFee_Amount : " + elFee_Amount);
        System.err.println("elPayFrom : " + elPayFrom);
        System.err.println("elAccNo : " + elAccNo);
        System.err.println("elRequester : " + elRequester);
        System.err.println("elLabelName : " + elLabelName);
        System.err.println("elName_Surname : " + elName_Surname);
        System.err.println("elLabelIDNumber : " + elLabelIDNumber);
        System.err.println("elIDNumber : " + elIDNumber);
        System.err.println("elLabelMobileNumber : " + elLabelMobileNumber);
        System.err.println("elMobileNumber : " + elMobileNumber);
        System.err.println("elLabelAddress : " + elLabelAddress);
        System.err.println("elAddressValue : " + elAddressValue);
        System.err.println("elLabelRequestDate : " + elLabelRequestDate);
        System.err.println("elRequestDateValue : " + elRequestDateValue);
        System.err.println("elLabelRefNo : " + elLabelRefNo);
        System.err.println("elRefNo : " + elRefNo);
        System.err.println("elContact : " + elContact);
        System.err.println("elBtnBackToServicePage : " + elBtnBackToServicePage);

        String result = "";
        result = CheckResults(elSuccess, "Success", result);
        result = CheckResults(elSuccessDetail, "Credit report will be sent by e-mail within 3 business form e-report@ncb.co.th. If you don't find e-mail in you inbox, please\n" +
                "check your junk mail.", result);
        result = CheckResults(elRequest, "Request Detail", result);
        result = CheckResults(elItem, "Item", result);
        result = CheckResults(elItemDetail, "1 credit report", result);
        result = CheckResults(elLabelDelivery, "Delivery method", result);
        result = CheckResults(elLabelEmail, "E-mail", result);
        result = CheckResults(elLabelAddress, "Delivery address", result);
        result = CheckResults(elLabelFee, "Service fee", result);
        result = CheckResults(elFee_Amount, "150.00", result);
        result = CheckResults(elPayFrom, "Paid From", result);
        result = CheckResults(elRequester, "Request Detail", result);
        result = CheckResults(elLabelName, "First name - Last name", result);
        result = CheckResults(elLabelIDNumber, "Citizen ID number", result);
        result = CheckResults(elLabelMobileNumber, "Mobile number", result);
        result = CheckResults(elLabelRequestDate, "Request date", result);
        result = CheckResults(elLabelRefNo, "Ref. No.", result);
        result = CheckResults(elContact, "For further infomation,\n" +
                "please contact NCB Call Center Tel. 0 2643 1250 or e-mail consumer@ncb.co.th", result);
        result = CheckResults(elDeliveryDetail, "by e-mail", result);
        result = CheckResults(elEmailValue, responseCustInfoValidation.getData().email, result);
        result = CheckResults(elAccNo, formatAccount(response.getData().account_list.get(0).accountNumber, "XXX-X-XX###-#"), result);
        result = CheckResults(elName_Surname, responseCustInfoValidation.getData().first_name_en + " " + responseCustInfoValidation.getData().last_name_en, result);
        result = CheckResults(elIDNumber, formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#"), result);
        result = CheckResults(elMobileNumber, formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####"), result);
        result = CheckResults(elAddressValue, responseCustInfoValidation.getData().delivery_address, result);
        result = CheckResults(elRequestDateValue, DateTimeNow, result);

        String SuccessScreen2 = "images/NcbByPost_SuccessScreen2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(SuccessScreen2);
        CheckResultsReport(scenario.createNode(Given.class, "After confirm pin, The system navigate to success payment screen").addScreenCaptureFromPath(SuccessScreen2), result);

        btnBackToServicePage.click();

        Assert.assertTrue(elSuccess.equals("Success"));
        Assert.assertTrue(elSuccessDetail.equals("Credit report will be sent by e-mail within 3 business form e-report@ncb.co.th. If you don't find e-mail in you inbox, please\n" +
                "check your junk mail."));
        Assert.assertTrue(elRequest.equals("Request Detail"));
        Assert.assertTrue(elItem.equals("Item"));
        Assert.assertTrue(elItemDetail.equals("1 credit report"));
        Assert.assertTrue(elLabelDelivery.equals("Delivery method"));
        Assert.assertTrue(elLabelEmail.equals("E-mail"));
        Assert.assertTrue(elLabelAddress.equals("Delivery address"));
        Assert.assertTrue(elLabelFee.equals("Service fee"));
        Assert.assertTrue(elFee_Amount.equals("150.00"));
        Assert.assertTrue(elPayFrom.equals("Paid From"));
        Assert.assertTrue(elRequester.equals("Request Detail"));
        Assert.assertTrue(elLabelName.equals("First name - Last name"));
        Assert.assertTrue(elLabelIDNumber.equals("Citizen ID number"));
        Assert.assertTrue(elLabelMobileNumber.equals("Mobile number"));
        Assert.assertTrue(elLabelRequestDate.equals("Request date"));
        Assert.assertTrue(elLabelRefNo.equals("Ref. No."));
        Assert.assertTrue(elContact.equals("For further infomation,\n" +
                "please contact NCB Call Center Tel. 0 2643 1250 or e-mail consumer@ncb.co.th"));
        Assert.assertTrue(elDeliveryDetail.equals("by post"));
        Assert.assertTrue(elEmailValue.equals(responseCustInfoValidation.getData().email));
        Assert.assertTrue(elAccNo.equals(formatAccount(response.getData().account_list.get(0).accountNumber, "XXX-X-XX###-#")));
        Assert.assertTrue(elName_Surname.equals(responseCustInfoValidation.getData().first_name_en + " " + responseCustInfoValidation.getData().last_name_en));
        Assert.assertTrue(elIDNumber.equals(formatAccount(responseCustInfoValidation.getData().national_id, "#-####-#####-##-#")));
        Assert.assertTrue(elMobileNumber.equals(formatAccount(responseCustInfoValidation.getData().mobile_no, "###-###-####")));
        Assert.assertTrue(elAddressValue.equals(responseCustInfoValidation.getData().delivery_address));
        Assert.assertTrue(elRequestDateValue.equals(DateTimeNow));
        Assert.assertTrue(elBtnBackToServicePage.equals("Back to Service Page"));
    }


    @Test(priority = 7, groups = "Customer Service NCB Report check one time per day")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00009() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement NCB_REPORT_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.NCB_REPORT_SERVICE_BUTTON);
        String elNcbReport = NCB_REPORT_SERVICE_BUTTON.getText();
        String result = "";
        result = CheckResults(elNcbReport, "NCB Report", result);

        String ServicePage = "images/NcbByPost_ServicePage_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(ServicePage);
        CheckResultsReport(scenario.createNode(Given.class, "After click back to service page, The system navigate to service screen").addScreenCaptureFromPath(ServicePage), result);

        NCB_REPORT_SERVICE_BUTTON.click();
        WebElement titlePopup = ttbTestContext.findElement(OneAppElementKeys.TITLE_POPUP_ERROR_NCB_PAYMENT_ONE_PER_DAY);
        String elTitlePopup = titlePopup.getText();
        WebElement detailPopupErrorOneTimePerDay = ttbTestContext.findElement(OneAppElementKeys.DETAIL_POPUP_ERROR_NCB_PAYMENT_ONE_PER_DAY);
        String elDetailPopupErrorOneTimePerDay = detailPopupErrorOneTimePerDay.getText();
        WebElement btnOk = ttbTestContext.findElement(OneAppElementKeys.BTN_OK_POPUP_ERROR_NCB_PAYMENT_ONE_PER_DAY);
        String elBtnOk = btnOk.getText();

        System.err.println("elTitlePopup : " + elTitlePopup);
        System.err.println("elDetailPopupErrorOneTimePerDay : " + elDetailPopupErrorOneTimePerDay);
        System.err.println("elBtnOk : " + elBtnOk);

        result = "";
        result = CheckResults(elTitlePopup, "Cannot proceed", result);
        result = CheckResults(elDetailPopupErrorOneTimePerDay, "Credit report can be requested via digital channel only once per day.", result);
        result = CheckResults(elBtnOk, "OK", result);

        String LimitPerDay = "images/NcbByPost_LimitPerDay_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(LimitPerDay);
        CheckResultsReport(scenario.createNode(Given.class, "If customer click NCB Report again, The system pop up error message limit per day").addScreenCaptureFromPath(LimitPerDay), result);

        btnOk.click();

        String AfterClickOk = "images/NcbByPost_AfterClickOk_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(AfterClickOk);
        scenario.createNode(Given.class, "After click ok button, The system close pop up").addScreenCaptureFromPath(AfterClickOk).pass("Pass");

        Assert.assertTrue(elTitlePopup.equals("Cannot proceed"));
        Assert.assertTrue(elDetailPopupErrorOneTimePerDay.equals("Credit report can be requested via digital channel only once per day."));
        Assert.assertTrue(elBtnOk.equals("OK"));
    }


    @Test(priority = 8, groups = "Customer Service NCB Report check create case tracking list")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00010() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement TAB_STATUS_TRACKING = ttbTestContext.findElement(OneAppElementKeys.TAB_STATUS_TRACKING);
        TAB_STATUS_TRACKING.click();

        String TabStatusTracking = "images/NcbByPost_TabStatusTracking_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(TabStatusTracking);
        scenario.createNode(Given.class, "After click ok button, The system close pop up").addScreenCaptureFromPath(TabStatusTracking).pass("Pass");

        ttbTestContext.setContextToWebView(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON, true);
        WebElement STATUS_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
        STATUS_TRACKING_SERVICE_BUTTON.click();
        try {
            ttbTestContext.findElement(OneAppElementKeys.START_BUTTON_TUTORIAL_SCREEN_CASE_TRACKING).click();
        } catch (Exception e) {}

        WebElement titleCase1 = ttbTestContext.findElement(OneAppElementKeys.TITLE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elTitleCase1 = titleCase1.getText();
        WebElement caseID = ttbTestContext.findElement(OneAppElementKeys.REF_NO_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elCaseID = caseID.getText();
        WebElement labelDocumentType = ttbTestContext.findElement(OneAppElementKeys.LABEL_DOCUMENT_TYPE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elLabelDocumentType = labelDocumentType.getText();
        WebElement documentTypeValue = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_TYPE_VALUE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elDocumentTypeValue = documentTypeValue.getText();
        WebElement status = ttbTestContext.findElement(OneAppElementKeys.STATUS_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
        String elStatus = status.getText();

        String result = "";
        result = CheckResults(elTitleCase1, "Document request", result);
//        result = CheckResults(elCaseID, "", result);
        result = CheckResults(elLabelDocumentType, "Document type", result);
        result = CheckResults(elDocumentTypeValue, "Request NCB", result);
        result = CheckResults(elStatus, "Done", result);
//        result = CheckResults(elCaseIdDetail, "", result);

        String CheckCreateCaseTracking = "images/NcbByPost_CheckCreateCaseTracking_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(CheckCreateCaseTracking);
        CheckResultsReport(scenario.createNode(Given.class, "After customer NCB Report Success, The system should be create case tracking for NCB Report. The customer can check case tracking in case tracking menu").addScreenCaptureFromPath(CheckCreateCaseTracking), result);

        System.err.println("elTitleCase1 : " + elTitleCase1);
        System.err.println("elCaseID : " + elCaseID);
        System.err.println("elLabelDocumentType : " + elLabelDocumentType);
        System.err.println("elDocumentTypeValue : " + elDocumentTypeValue);
        System.err.println("elStatus : " + elStatus);

        titleCase1.click();

        Assert.assertTrue(elTitleCase1.equals("Document request"));
//        Assert.assertTrue(elCaseID.equals(""));
        Assert.assertTrue(elLabelDocumentType.equals("Document type"));
        Assert.assertTrue(elDocumentTypeValue.equals("Request NCB"));
        Assert.assertTrue(elStatus.equals("Done"));
//        Assert.assertTrue(elCaseIdDetail.equals(""));
    }


    @Test(priority = 9, groups = "Customer Service NCB Report check create case tracking")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00011() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        while (true) {
            System.err.println("datePayment : " + datePayment);
            System.err.println("date : " + ttbTestContext.findElement(OneAppElementKeys.DATE_FINISH_TRACKING_DETAIL_SCREEN).getText() + " = " + datePayment.substring(0, 9));
            if (ttbTestContext.findElement(OneAppElementKeys.DATE_FINISH_TRACKING_DETAIL_SCREEN).getText().equals(datePayment.substring(0, 9))) {
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

                String result = "";
                result = CheckResults(elLabelDocumentTypeDetail, "Document type", result);
                result = CheckResults(elDocumentTypeValueDetail, "Credit Report (NCB)", result);
                result = CheckResults(elStatusDetail, "TTB has already submit your document request", result);
                result = CheckResults(elDateFinish, datePayment.substring(0, 9), result);
                result = CheckResults(elMessageBox, "Credit Report (NCB) will be sent to you by post within 7 business days.", result);
                result = CheckResults(elContactNCB, "For any further information please contact NCB Call\n" +
                        "Center 0 2643 1250\n" +
                        "or email consumer@ncb.co.th", result);

                String CaseTrackingDetailNCB = "images/NcbByPost_CaseTrackingDetailNCB_" + ttbTestContext.getPlateFormName() + ".png";
                takeScreenshot(CaseTrackingDetailNCB);
                CheckResultsReport(scenario.createNode(Given.class, "Case tracking detail for NCB Report").addScreenCaptureFromPath(CaseTrackingDetailNCB), result);

                System.err.println("elCaseIdDetail : " + elCaseIdDetail);
                System.err.println("elLabelDocumentTypeDetail : " + elLabelDocumentTypeDetail);
                System.err.println("elDocumentTypeValueDetail : " + elDocumentTypeValueDetail);
                System.err.println("elStatusDetail : " + elStatusDetail);
                System.err.println("elDateFinish : " + elDateFinish);
                System.err.println("elMessageBox : " + elMessageBox);
                System.err.println("elDateFinish : " + elContactNCB);

                ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_SCREEN_CASE_TRACKING_DETAIL_SCREEN).click();
                ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_SCREEN_CASE_TRACKING_DETAIL_SCREEN).click();

                WebElement caseTracking = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
                String elCaseTracking = caseTracking.getText();
                result = "";
                result = CheckResults(elCaseTracking, "Request/Complaint", result);

                String ServiceScreenAfterCheckCaseTracking = "images/NcbByPost_ServiceScreenAfterCheckCaseTracking_" + ttbTestContext.getPlateFormName() + ".png";
                takeScreenshot(ServiceScreenAfterCheckCaseTracking);
                CheckResultsReport(scenario.createNode(Given.class, "Back to Service Screen").addScreenCaptureFromPath(ServiceScreenAfterCheckCaseTracking), result);

//                Assert.assertTrue(elCaseIdDetail.equals(""));
                Assert.assertTrue(elLabelDocumentTypeDetail.equals("Document type"));
                Assert.assertTrue(elDocumentTypeValueDetail.equals("Credit Report (NCB)"));
                Assert.assertTrue(elStatusDetail.equals("TTB has already submit your document request"));
                Assert.assertTrue(elDateFinish.equals(datePayment.substring(0, 9)));
                Assert.assertTrue(elMessageBox.equals("Credit Report (NCB) will be sent to you by post within 7 business days."));
                Assert.assertTrue(elContactNCB.equals("For any further information please contact NCB Call\n" +
                        "Center 0 2643 1250\n" +
                        "or email consumer@ncb.co.th"));
                break;
            } else {
                ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_SCREEN_CASE_TRACKING_DETAIL_SCREEN).click();
                ttbTestContext.findElement(OneAppElementKeys.ARROW_BACK_SCREEN_CASE_TRACKING_DETAIL_SCREEN).click();
                WebElement STATUS_TRACKING_SERVICE_BUTTON = ttbTestContext.findElement(OneAppElementKeys.STATUS_TRACKING_SERVICE_BUTTON);
                STATUS_TRACKING_SERVICE_BUTTON.click();
                WebElement titleCase1 = ttbTestContext.findElement(OneAppElementKeys.TITLE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
                String elTitleCase1 = titleCase1.getText();
                WebElement caseID = ttbTestContext.findElement(OneAppElementKeys.REF_NO_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
                String elCaseID = caseID.getText();
                WebElement labelDocumentType = ttbTestContext.findElement(OneAppElementKeys.LABEL_DOCUMENT_TYPE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
                String elLabelDocumentType = labelDocumentType.getText();
                WebElement documentTypeValue = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_TYPE_VALUE_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
                String elDocumentTypeValue = documentTypeValue.getText();
                WebElement status = ttbTestContext.findElement(OneAppElementKeys.STATUS_COMPLETE_CASE_TRACKING_LIST_SCREEN_1);
                String elStatus = status.getText();
                titleCase1.click();

                System.err.println("elTitleCase1 : " + elTitleCase1);
                System.err.println("elCaseID : " + elCaseID);
                System.err.println("elLabelDocumentType : " + elLabelDocumentType);
                System.err.println("elDocumentTypeValue : " + elDocumentTypeValue);
                System.err.println("elStatus : " + elStatus);

                Assert.assertTrue(elTitleCase1.equals("Document request"));
//                Assert.assertTrue(elCaseID.equals(""));
                Assert.assertTrue(elLabelDocumentType.equals("Document type"));
                Assert.assertTrue(elDocumentTypeValue.equals("Request NCB"));
                Assert.assertTrue(elStatus.equals("Done"));
            }
        }
    }


    @Test(priority = 10, groups = "Customer Service NCB Report go to account summary")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00008() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.ACCOUNT_BUTTON, false);
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

        String AccountSummaryAfterNCBPayment = "images/NcbByPost_AccountSummaryAfterNCBPayment_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(AccountSummaryAfterNCBPayment);
        scenario.createNode(Given.class, "Account summary screen").addScreenCaptureFromPath(AccountSummaryAfterNCBPayment).pass("Pass");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT1_ACCOUNT_SUMMARY);
        WebElement accountSummary = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT1_ACCOUNT_SUMMARY);
        accountSummary.click();
        Thread.sleep(15000);
        if(ttbTestContext.isIos()){
            ttbTestContext.setContextToWebView(OneAppElementKeys.ACCOUNT_NUMBER_IN_TSN_ACCOUNT_DETAIL_SCREEN, true);
        }else{
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN, true);
            System.out.println("context : " + context);
            Set<String> webNames = context.getWindowHandles();
            System.out.println("webNames : " + webNames.toString());
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
        WebElement accountNumber = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_ACCOUNT_DETAIL_SCREEN);
        String elAccountNumber = accountNumber.getText();

        System.err.println("elAccountNumber : " + elAccountNumber);
    }

    @Test(priority = 10, groups = "Customer Service NCB Report check balance after payment")
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00012() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        while (true) {
            System.err.println("elAccountNumber : " + balanceBeforePayment + " : " + ttbTestContext.findElement(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN).getText());
            if (!balanceBeforePayment.equals(ttbTestContext.findElement(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN).getText())) {
                WebElement accountNumber = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_ACCOUNT_DETAIL_SCREEN);
                String elAccountNumber = accountNumber.getText();
                WebElement balance = ttbTestContext.findElement(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN);
                String balanceAfterPayment = balance.getText();
                WebElement activityList = ttbTestContext.findElement(OneAppElementKeys.ACTIVITY_LIST_ACCOUNT_DETAIL_SCREEN);
                String elActivityList = activityList.getText();
                WebElement tsnAmount = ttbTestContext.findElement(OneAppElementKeys.TSN_AMOUNT_ACCOUNT_DETAIL_SCREEN);
                String elTsnAmount = tsnAmount.getText();
                WebElement dateTsn = ttbTestContext.findElement(OneAppElementKeys.DATE_TSN_ACCOUNT_DETAIL_SCREEN);
                String elDateTsn = dateTsn.getText();
                ttbTestContext.findElement(OneAppElementKeys.TSN_AMOUNT_ACCOUNT_DETAIL_SCREEN).click();
                Thread.sleep(3000);
                WebElement tabDetail = ttbTestContext.findElement(OneAppElementKeys.TAB_DETAIL_ACCOUNT_DETAIL_SCREEN);
                tabDetail.click();
                tabDetail.click();
                ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
                if(ttbTestContext.isIos()){
                    ttbTestContext.setContextToWebView(OneAppElementKeys.ACCOUNT_NUMBER_IN_TSN_ACCOUNT_DETAIL_SCREEN, true);
                }else{
                    WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN, true);
                    System.out.println("context : " + context);
                    Set<String> webNames = context.getWindowHandles();
                    System.out.println("webNames : " + webNames.toString());
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN);
                            break;
                        } catch (Exception e) {
                            System.out.println("This webview is't to use");
                        }
                    }
                }
                WebElement accountNumberTsn = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_IN_TSN_ACCOUNT_DETAIL_SCREEN);
                String elAccountNumberTsn = accountNumberTsn.getText();
                WebElement toDetailAccount = ttbTestContext.findElement(OneAppElementKeys.TO_DETAIL_ACCOUNT_DETAIL_SCREEN);
                String elToDetailAccount = toDetailAccount.getText();
                WebElement cid = ttbTestContext.findElement(OneAppElementKeys.CID_ACCOUNT_DETAIL_SCREEN);
                String elCid = cid.getText();
                WebElement refNumber = ttbTestContext.findElement(OneAppElementKeys.REF_NO_ACCOUNT_DETAIL_SCREEN);
                String elRefNumber = refNumber.getText();

                double balanceBefore = Double.parseDouble(balanceBeforePayment.replace(",", ""));
                double balanceAfter = Double.parseDouble(balanceAfterPayment.replace(",", ""));
                double resultBalance = balanceBefore - balanceAfter;
                double difference = balanceBefore - 150;
                String differences = formatBalance(difference);
                String results = formatBalance(resultBalance);

                String result = "";
                result = CheckResults(results, "150.00", result);
                result = CheckResults(balanceAfterPayment, differences, result);
                result = CheckResults(elDateTsn, datePayment.substring(0, 11) + convertTimes(datePayment.substring(11, 19).toUpperCase()), result);
                result = CheckResults(elAccountNumberTsn, AccountNumberPayment, result);
                result = CheckResults(elToDetailAccount, "National Credit Bureau Co.,Ltd", result);
                result = CheckResults(elCid, CIDPayment, result);
                result = CheckResults(elRefNumber, RefNumber, result);

                String CheckBalanceAfterPayment = "images/NcbByPost_CheckBalanceAfterPayment_" + ttbTestContext.getPlateFormName() + ".png";
                takeScreenshot(CheckBalanceAfterPayment);
                CheckResultsReport(scenario.createNode(Given.class, "Back to Service Screen").addScreenCaptureFromPath(CheckBalanceAfterPayment), result);

                System.err.println("elAccountNumber : " + elAccountNumber);
                System.err.println("balanceBeforePayment : " + balanceBeforePayment);

                System.err.println("balanceAfterPayment : " + balanceAfterPayment);
                System.err.println("elActivityList : " + elActivityList);
                System.err.println("elTsnAmount : " + elTsnAmount);
                System.err.println("elAccountNumberTsn : " + elAccountNumberTsn);
                System.err.println("elToDetailAccount : " + elToDetailAccount);
                System.err.println("elCid : " + elCid);
                System.err.println("elRefNumber : " + elRefNumber);
                System.err.println("elDateTsn : " + elDateTsn);
                System.err.println("datePayment : " + datePayment.substring(0, 11) + convertTimes(datePayment.substring(11, 19).toUpperCase()));

                System.err.println("results : " + results);
                System.err.println("differences : " + differences);
                Assert.assertTrue(results.equals("150.00"));
                Assert.assertTrue(balanceAfterPayment.equals(differences));
                Assert.assertTrue(elDateTsn.equals(datePayment.substring(0, 11) + convertTimes(datePayment.substring(11, 19).toUpperCase())));
                Assert.assertTrue(elAccountNumberTsn.equals(AccountNumberPayment));
                Assert.assertTrue(elToDetailAccount.equals("National Credit Bureau Co.,Ltd"));
                Assert.assertTrue(elCid.equals(CIDPayment));
                Assert.assertTrue(elRefNumber.equals(RefNumber));
                break;
            } else {
                System.err.println("aaaaaa : " + balanceBeforePayment + " : " + ttbTestContext.findElement(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN).getText());
                ttbTestContext.findElement(OneAppElementKeys.BTN_BACK_ACCOUNT_DETAIL_SCREEN).click();
                ttbTestContext.setContextToWebView(OneAppElementKeys.ACCOUNT_BUTTON, false);
                WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
                accountButton.click();
                ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT1_ACCOUNT_SUMMARY);
                WebElement accountSummary = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT1_ACCOUNT_SUMMARY);
                accountSummary.click();
                Thread.sleep(10000);
                if(ttbTestContext.isIos()){
                    currentContext.add(ttbTestContext.setContextToWebView(OneAppElementKeys.ACCOUNT_NUMBER_IN_TSN_ACCOUNT_DETAIL_SCREEN, true, currentContext));
                }else{
                    WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN, true);
                    System.out.println("context : " + context);
                    Set<String> webNames = context.getWindowHandles();
                    System.out.println("webNames : " + webNames.toString());
                    for (String s : webNames) {
                        ttbTestContext.getDriver().switchTo().window(s);
                        System.out.println("test : " + s);
                        try {
                            ttbTestContext.waitUntilVisible(OneAppElementKeys.BALANCE_ACCOUNT_DETAIL_SCREEN);
                            break;
                        } catch (Exception e) {
                            System.out.println("This webview is't to use");
                        }
                    }
                }
                (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
                WebElement accountNumber = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_NUMBER_ACCOUNT_DETAIL_SCREEN);
                String elAccountNumber = accountNumber.getText();

                System.err.println("elAccountNumber : " + elAccountNumber);
            }
        }
        getExtent().flush();
    }
}
