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
import com.ttbbank.oneapp.framework.model.customerservice.ndidUserData.ndidUserDataResponse;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class NdidReviewInformationScenario extends BaseScenario {
    ExtentTest scenario = null;
    ExtentTest scenario2 = null;
    String DateTimePresent = null;
    String DateTimeSuccess = null;
    TmbServiceResponse<ndidEligibleResponse> response = null;
    TmbServiceResponse<ndidUserDataResponse> responseUserData = null;
    @Test(priority = 0, groups = "Customer Service NDID list request data", dependsOnGroups = {"Activate new flow", "Enter Service Screen Dev Latest"})
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.horizontalSwipeByPercentage(0.9, 0.1, 0.30);

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
        Thread.sleep(10000);
        WebElement NDID = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        NDID.click();
        (new WebDriverWait(ttbTestContext.getDriver(), 30)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"loading_loadingBox__2m_2X\")]")));
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

        scenario = getFeature().createNode(Scenario.class, "Ndid request personal detail");
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

        String NdidPendingRPRequestList = "images/NdidReviewInformation_Ndid_Authentication_aal2.1_" + ttbTestContext.getPlateFormName() + ".png";
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

    @Test(priority = 2, groups = "Customer Service review information for ndid")
    public void TC_ONEAPP_8865_NDID_Review_SIT_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("", "");
        responseUserData = client.get("/apis/customer/ekyc/ndidUserData", eqParams, ndidUserDataResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(responseUserData));
        WebElement Header = ttbTestContext.findElement(OneAppElementKeys.TITLE_HEADER_INFORMATION_NDID_SCREEN);
        String elHeader = Header.getText();
        WebElement PersonalDetail = ttbTestContext.findElement(OneAppElementKeys.LABEL_PERSONAL_DETAIL_NDID);
        String elPersonalDetail = PersonalDetail.getText();
        WebElement Edit = ttbTestContext.findElement(OneAppElementKeys.EDIT_BUTTON_NDID);
        String elEdit = Edit.getText();
        WebElement NameTH = ttbTestContext.findElement(OneAppElementKeys.NAME_TH_LABEL_NDID);
        String elNameTH = NameTH.getText();
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ndid_personal_infor_name_value_th_id")));
        WebElement NameTHValue = ttbTestContext.findElement(OneAppElementKeys.NAME_TH_VALUE_NDID);
        String elNameTHValue = NameTHValue.getText();
        WebElement SurnameTH = ttbTestContext.findElement(OneAppElementKeys.SURNAME_TH_LABEL_NDID);
        String elSurnameTH = SurnameTH.getText();
        WebElement SurnameTHValue = ttbTestContext.findElement(OneAppElementKeys.SURNAME_TH_VALUE_NDID);
        String elSurnameTHValue = SurnameTHValue.getText();
        WebElement NameEN = ttbTestContext.findElement(OneAppElementKeys.NAME_EN_LABEL_NDID);
        String elNameEN = NameEN.getText();
        WebElement NameENValue = ttbTestContext.findElement(OneAppElementKeys.NAME_EN_VALUE_NDID);
        String elNameENValue = NameENValue.getText();
        WebElement SurnameEN = ttbTestContext.findElement(OneAppElementKeys.SURNAME_EN_LABEL_NDID);
        String elSurnameEN = SurnameEN.getText();
        WebElement SurnameENValue = ttbTestContext.findElement(OneAppElementKeys.SURNAME_EN_VALUE_NDID);
        String elSurnameENValue = SurnameENValue.getText();
        WebElement DateOfBirth = ttbTestContext.findElement(OneAppElementKeys.DATE_BIRTH_LABEL_NDID);
        String elDateOfBirth = DateOfBirth.getText();
        WebElement DateOfBirthValue = ttbTestContext.findElement(OneAppElementKeys.DATE_BIRTH_VALUE_NDID);
        String elDateOfBirthValue = DateOfBirthValue.getText();
        WebElement Nationality = ttbTestContext.findElement(OneAppElementKeys.NATIONALITY_LABEL_NDID);
        String elNationality = Nationality.getText();
        WebElement NationalityValue = ttbTestContext.findElement(OneAppElementKeys.NATIONALITY_VALUE_NDID);
        String elNationalityValue = NationalityValue.getText();
        WebElement Status_data = ttbTestContext.findElement(OneAppElementKeys.STATUS_LABEL_NDID);
        String elStatus = Status_data.getText();
        WebElement StatusValue = ttbTestContext.findElement(OneAppElementKeys.STATUS_VALUE_NDID);
        String elStatusValue = StatusValue.getText();
        WebElement IDNumber = ttbTestContext.findElement(OneAppElementKeys.ID_CARD_NUMBER_LABEL_NDID);
        String elIDNumber = IDNumber.getText();
        WebElement IDNumberValue = ttbTestContext.findElement(OneAppElementKeys.ID_CARD_NUMBER_VALUE_NDID);
        String elIDNumberValue = IDNumberValue.getText().replace("-", "");
        WebElement Email = ttbTestContext.findElement(OneAppElementKeys.EMAIL_LABEL_NDID);
        String elEmail = Email.getText();
        WebElement EmailValue = ttbTestContext.findElement(OneAppElementKeys.EMAIL_VALUE_NDID);
        String elEmailValue = EmailValue.getText();
        WebElement MobileNumber = ttbTestContext.findElement(OneAppElementKeys.MOBILE_NUMBER_LABEL_NDID);
        String elMobileNumber = MobileNumber.getText();
        WebElement MobileNumberValue = ttbTestContext.findElement(OneAppElementKeys.MOBILE_NUMBER_VALUE_NDID);
        String elMobileNumberValue = MobileNumberValue.getText().replace("-", "");
        WebElement RegisterAddress = ttbTestContext.findElement(OneAppElementKeys.REGISTERED_ADDRESS_LABEL_NDID);
        String elRegisterAddress = RegisterAddress.getText();
        WebElement RegisterAddressValue = ttbTestContext.findElement(OneAppElementKeys.REGISTERED_ADDRESS_VALUE_NDID);
        String elRegisterAddressValue = RegisterAddressValue.getText();
        WebElement ContactAddress = ttbTestContext.findElement(OneAppElementKeys.CONTACT_ADDRESS_LABEL_NDID);
        String elContactAddress = ContactAddress.getText();
        WebElement ContactAddressValue = ttbTestContext.findElement(OneAppElementKeys.CONTACT_ADDRESS_VALUE_NDID);
        String elContactAddressValue = ContactAddressValue.getText();
        System.err.println("elBtnReject : " + elHeader);
        System.err.println("elelPersonalDetail : " + elPersonalDetail);
        System.err.println("elEdit : " + elEdit);
        System.err.println("elNameTH : " + elNameTH + "     " + elNameTHValue);
        System.err.println("elSurnameTH : " + elSurnameTH + "     " + elSurnameTHValue);
        System.err.println("elNameEN : " + elNameEN + "     " + elNameENValue);
        System.err.println("elSurnameTH : " + elSurnameEN + "     " + elSurnameENValue);
        System.err.println("elDateOfBirth : " + elDateOfBirth + "     " + elDateOfBirthValue);
        System.err.println("elNationality : " + elNationality + "     " + elNationalityValue);
        System.err.println("elStatus : " + elStatus + "     " + elStatusValue);
        System.err.println("elIDNumber : " + elIDNumber + "     " + elIDNumberValue);
        System.err.println("elEmail : " + elEmail + "     " + elEmailValue);
        System.err.println("elMobileNumber : " + elMobileNumber + "     " + elMobileNumberValue);
        System.err.println("elMobileNumber : " + elRegisterAddress + "     " + elRegisterAddressValue);
        System.err.println("elContactAddress : " + elContactAddress + "     " + elContactAddressValue);

        String NdidPersonal = "images/NdidReviewInformation_Ndid_Review_Personal_detail_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPersonal);
        scenario.createNode(Given.class, "NDID Personal detail").addScreenCaptureFromPath(NdidPersonal).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LABEL_OCCUPATION_DETAIL_NDID, true);
//        childReport.log(Status.INFO, "<pre>The System display a Review Information screen correctly.</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        WebElement OccupationDetail = ttbTestContext.findElement(OneAppElementKeys.LABEL_OCCUPATION_DETAIL_NDID);
        String elOccupationDetail = OccupationDetail.getText();
        System.err.println("elOccupationDetail : " + elOccupationDetail);
        WebElement Occupation = ttbTestContext.findElement(OneAppElementKeys.OCCUPATION_LABEL_NDID);
        String elOccupation = Occupation.getText();
        System.err.println("elOccupation : " + elOccupation);
        WebElement OccupationValue = ttbTestContext.findElement(OneAppElementKeys.OCCUPATION_VALUE_NDID);
        String elOccupationValue = OccupationValue.getText();
        System.err.println("elOccupationValue : " + elOccupationValue);
        WebElement CompanyName = ttbTestContext.findElement(OneAppElementKeys.COMPANY_NAME_LABEL_NDID);
        String elCompanyName = CompanyName.getText();
        System.err.println("elCompanyName : " + elCompanyName);
        WebElement CompanyNameValue = ttbTestContext.findElement(OneAppElementKeys.COMPANY_NAME_VALUE_NDID);
        String elCompanyNameValue = CompanyNameValue.getText();
        System.err.println("elCompanyNameValue : " + elCompanyNameValue);
        WebElement CompanyAddress = ttbTestContext.findElement(OneAppElementKeys.COMPANY_ADDRESS_LABEL_NDID);
        String elCompanyAddress = CompanyAddress.getText();
        System.err.println("elCompanyAddress : " + elCompanyAddress);
        WebElement CompanyAddressValue = ttbTestContext.findElement(OneAppElementKeys.COMPANY_ADDRESS_VALUE_NDID);
        String elCompanyAddressValue = CompanyAddressValue.getText();
        System.err.println("elCompanyAddressValue : " + elCompanyAddressValue);
        WebElement TitleIncome = ttbTestContext.findElement(OneAppElementKeys.LABLE_INCOME_DETAIL_NDID);
        String elTitleIncome = TitleIncome.getText();
        System.err.println("elTitleIncome : " + elTitleIncome);
        WebElement PersonalIncome = ttbTestContext.findElement(OneAppElementKeys.PERSONAL_INCOME_LABEL_NDID);
        String elPersonalIncome = PersonalIncome.getText();
        System.err.println("elPersonalIncome : " + elPersonalIncome);
        WebElement PersonalIncomeValue = ttbTestContext.findElement(OneAppElementKeys.PERSONAL_INCOME_VALUE_NDID);
        String elPersonalIncomeValue = PersonalIncomeValue.getText();
        System.err.println("elPersonalIncomeValue : " + elPersonalIncomeValue);

        String NdidPersonal2 = "images/NdidReviewInformation_Ndid_Review_Personal_detail2_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPersonal2);
        scenario.createNode(Given.class, "NDID Personal detail").addScreenCaptureFromPath(NdidPersonal2).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.SOURCE_INCOME_LABEL_NDID, true);
        WebElement SourceIncome = ttbTestContext.findElement(OneAppElementKeys.SOURCE_INCOME_LABEL_NDID);
        String elSourceIncome = SourceIncome.getText();
        System.err.println("elSourceIncome : " + elSourceIncome);
        WebElement SourceIncomeValue = ttbTestContext.findElement(OneAppElementKeys.SOURCE_INCOME_VALUE_NDID);
        String elSourceIncomeValue = SourceIncomeValue.getText();
        System.err.println("elSourceIncomeValue : " + elSourceIncomeValue);
        WebElement CountryIncome = ttbTestContext.findElement(OneAppElementKeys.COUNTRY_INCOME_LABEL_NDID);
        String elCountryIncome = CountryIncome.getText();
        System.err.println("elCountryIncome : " + elCountryIncome);
        WebElement CountryIncomeValue = ttbTestContext.findElement(OneAppElementKeys.COUNTRY_INCOME_VALUE_NDID);
        String elCountryIncomeValue = CountryIncomeValue.getText();
        System.err.println("elCountryIncomeValue : " + elCountryIncomeValue);
        WebElement MessageInformationNDIDScreen = ttbTestContext.findElement(OneAppElementKeys.MESSAGE_INFORMATION_NDID_SCREEN);
        String elMessageInformationNDIDScreen = MessageInformationNDIDScreen.getText();
        System.err.println("elMessageInformationNDIDScreen : " + elMessageInformationNDIDScreen);
        WebElement ReadMoreValue = ttbTestContext.findElement(OneAppElementKeys.READ_MORE_BUTTON_INFORMATION_NDID_SCREEN);
        String elReadMoreValue = ReadMoreValue.getText();
        System.err.println("elReadMoreValue : " + elReadMoreValue);
        WebElement BtnConfirm = ttbTestContext.findElement(OneAppElementKeys.CONFIRM_BUTTON_INFORMATION_NDID_SCREEN);
        String elBtnConfirm = BtnConfirm.getText();
        System.err.println("elBtnConfirm : " + elBtnConfirm);

        String NdidPersonal3 = "images/NdidReviewInformation_Ndid_Review_Personal_detail3_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPersonal3);
        scenario.createNode(Given.class, "NDID Personal detail").addScreenCaptureFromPath(NdidPersonal3).pass("Pass");

        ttbTestContext.verticalSwipeByPercentages(0.8, 0.1, 0.5);
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_BUTTON_INFORMATION_NDID_SCREEN, true);

        String NdidPersonal4 = "images/NdidReviewInformation_Ndid_Review_Personal_detail4_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidPersonal4);
        scenario.createNode(Given.class, "NDID Personal detail").addScreenCaptureFromPath(NdidPersonal4).pass("Pass");

        BtnConfirm.click();

        String NdidConfirmPin = "images/NdidReviewInformation_Ndid_ConfirmPin_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidConfirmPin);
        scenario.createNode(Given.class, "After click confirm. The system navigate to pin screen").addScreenCaptureFromPath(NdidConfirmPin).pass("Pass");

        Assert.assertTrue(elHeader.equals("ธนาคารทหารไทยธนชาต Authentication"));
        Assert.assertTrue(elPersonalDetail.equals("Personal Detail"));
        Assert.assertTrue(elEdit.equals("Edit"));
        Assert.assertTrue(elNameTH.equals("First name (TH)"));
        Assert.assertTrue(elSurnameTH.equals("Last name (TH)"));
        Assert.assertTrue(elNameEN.equals("First name (EN)"));
        Assert.assertTrue(elSurnameEN.equals("Last name (EN)"));
        Assert.assertTrue(elDateOfBirth.equals("Date of birth"));
        Assert.assertTrue(elNationality.equals("Nationality"));
        Assert.assertTrue(elStatus.equals("Status"));
        Assert.assertTrue(elIDNumber.equals("ID card number"));
        Assert.assertTrue(elEmail.equals("E-mail"));
        Assert.assertTrue(elMobileNumber.equals("Mobile number"));
        Assert.assertTrue(elRegisterAddress.equals("Registered address"));
        Assert.assertTrue(elContactAddress.equals("Contact address"));
        Assert.assertTrue(elOccupationDetail.equals("Occupation Detail"));
        Assert.assertTrue(elOccupation.equals("Occupation"));
        Assert.assertTrue(elCompanyName.equals("Company name"));
        Assert.assertTrue(elCompanyAddress.equals("Company address"));
        Assert.assertTrue(elTitleIncome.equals("Income Detail"));
        Assert.assertTrue(elPersonalIncome.equals("Personal income"));
        Assert.assertTrue(elSourceIncome.equals("Source of income"));
        Assert.assertTrue(elCountryIncome.equals("Country of income"));
        Assert.assertTrue(elMessageInformationNDIDScreen.equals("I hereby agree to the Bank to disclose my personal data above to other organizations requesting information for the purpose of identity authentication. You can check the rights of the data subject at the Privacy Policy."));
        Assert.assertTrue(elReadMoreValue.equals("Read More"));
        Assert.assertTrue(elBtnConfirm.equals("Confirm"));
        Assert.assertTrue(elNameTHValue.equals(responseUserData.getData().first_name_th));
        Assert.assertTrue(elSurnameTHValue.equals(responseUserData.getData().last_name_th));
        Assert.assertTrue(elNameENValue.equals(responseUserData.getData().first_name_en));
        Assert.assertTrue(elSurnameENValue.equals(responseUserData.getData().last_name_en));
        System.err.println(ConvertDate(responseUserData.getData().date_of_birth,false, "TH"));
        String dateOfBirth = ConvertDate(responseUserData.getData().date_of_birth,false, "TH");
        int day = Integer.parseInt(dateOfBirth.substring(0,2));
        System.err.println(dateOfBirth.length());
        dateOfBirth = day + dateOfBirth.substring(2,10);
        Assert.assertTrue(elDateOfBirthValue.equals(dateOfBirth));
        Assert.assertTrue(elNationalityValue.equals(responseUserData.getData().nationality));
        Assert.assertTrue(elStatusValue.equals(responseUserData.getData().marital_status));
        Assert.assertTrue(elIDNumberValue.equals(responseUserData.getData().citizen_id));
        Assert.assertTrue(elEmailValue.equals(responseUserData.getData().email));
        Assert.assertTrue(elMobileNumberValue.equals(responseUserData.getData().mobile_no));
        Assert.assertTrue(elContactAddressValue.equals(responseUserData.getData().contact_address));
        Assert.assertTrue(elOccupationValue.equals(responseUserData.getData().occupation));
        Assert.assertTrue(elCompanyNameValue.equals(responseUserData.getData().company_name));
        Assert.assertTrue(elSourceIncomeValue.equals(responseUserData.getData().source_of_income));
        Assert.assertTrue(elCountryIncomeValue.equals(responseUserData.getData().country_of_income));
        Assert.assertTrue(elRegisterAddressValue.equals(responseUserData.getData().registered_address));
    }


    @Test(priority = 3, groups = "Customer Service Successful authentication NDID")
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00001() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        ttbTestContext.setContextToWebView(OneAppElementKeys.CONFIRM_PIN_0_BUTTON, false);
        confirmPin();
        ttbTestContext.setContextToWebView(OneAppElementKeys.TITLE_AUTHEN_SUCCESS, true);
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
        System.err.println("elTitleSuccessful : " + elTitleSuccessful);
        System.err.println("elTitleDescription : " + elTitleDescription);
        System.err.println("elTransaction : " + elTransaction);
        System.err.println("DateTimeSuccess : " + DateTimeSuccess);
        System.err.println("elRefNo : " + elRefNo);
        System.err.println("elRefNoValue : " + elRefNoValue);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);

        String NdidSuccessful = "images/NdidReviewInformation_Ndid_Successful_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidSuccessful);
        scenario.createNode(Given.class, "NDID Successful screen").addScreenCaptureFromPath(NdidSuccessful).pass("Pass");

//        if(true){
//            parentReport = extent.createTest("TS_ONEAPP_8871_EN Display Successful Screen", "TS_ONEAPP_8871_EN");
//        }
//        childReport = parentReport.createNode("TC_ONEAPP_8871_NDID_SUCCESS_SIT_00001");
//        childReport.log(Status.INFO, "<pre>Test Step Description : Validate a display of NDID Authentication Successful screen if \n" +
//                "1. Request Level = AAL = 2.1 and Sufficent Customer's IAL\n" +
//                "2. Personal info Req = Yes\n" +
//                "Device Android</pre>");
//        childReport.log(Status.INFO, "<pre>Expected Result : 1. After Enter PIN correct, Display Authentication Successful screen.\n" +
//                "2. The system should display transaction date time success and reference no.\n" +
//                "3. If Customer press on a Back to Main Menu, The system will go to the Service page (if entry from Service page)</pre>");
//        childReport.log(Status.INFO, "<pre>Actual result : Display Text Authentication Success : " + TextColor.blueColor(elTitleSuccessful)
//                + "</br>Display Text Detail : " + TextColor.blueColor(elTitleDescription)
//                + "</br>Display transaction date time success and reference no. : " + TextColor.blueColor(elTransaction)
//                + "</br>Display label button Back to Main Menu : " + TextColor.blueColor(elBtnBackToMainMenu)
//                + "</pre>");
//        childReport.log(Status.INFO, "<pre>Display Authentication Successful screen</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

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
//        childReport.log(Status.INFO, "<pre>If Customer press on a Back to Main Menu, The system will go to the Service page (if entry from Service page)</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
    }

    @Test(priority = 5, groups = "Customer Service verify history success")
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00001_1() throws Exception {
        TtbTestContext ttbTestContext = getTtbTestContext();
        WebElement NDID = ttbTestContext.findElement(OneAppElementKeys.NDID_SERVICE_BUTTON);
        String NdidPersonal4 = "images/NdidReviewInformation_Ndid_ServiceScreen_" + ttbTestContext.getPlateFormName() + ".png";
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

        scenario2 = getFeature().createNode(Scenario.class, "Ndid verify request history status successful");
        String NdidVerifyRequestHistory = "images/NdidReviewInformation_Ndid_VerifyRequestHistory_" + ttbTestContext.getPlateFormName() + ".png";
        takeScreenshot(NdidVerifyRequestHistory);
        scenario2.createNode(Given.class, "After the customer already do ndid request successful, The customer can verify request history status successful.").addScreenCaptureFromPath(NdidVerifyRequestHistory).pass("Pass");

        Assert.assertTrue(elCardHead_History.equals(response.getData().request_history.get(0).provider));
        Assert.assertTrue(elTransaction_Date.equals("Transaction date"));
        Assert.assertTrue(elTranDate.equals(ConvertDate(response.getData().request_history.get(0).datetime,false,"EN")));
        Assert.assertTrue(elStatusHistory.equals(checkStatusNdid(response.getData().request_history.get(0).status)));
        CardHead_History.click();
    }

    @Test(priority = 6, groups = "Customer Service verify authentication history success")
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

        String NdidAuthenticationSuccessful = "images/NdidReviewInformationt_Ndid_AuthenticationSuccessful_" + ttbTestContext.getPlateFormName() + ".png";
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
