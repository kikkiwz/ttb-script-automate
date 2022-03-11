package com.tmb.automation.test.customerservice.sprint23;

import com.tmb.automation.api.customerservice.ViewVirtualPassbook;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.tmb.automation.api.customerservice.sprint21.BiometricConsent.GetBiometricConsent_ForDEMO;
import static com.tmb.automation.api.customerservice.sprint21.NdidEligibile.NdidEligibile;
import static com.tmb.automation.api.customerservice.sprint21.NdidUserData.NdidUserData;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class NDID_BioConsent_EN extends Base {
    JSONObject JsonDataNdidEligibile = null;
    JSONObject JsonDataNdidUserData = null;
    //    JSONObject JsonDataBiometricConsent = null;
    @Parameters({"DeviceProfile" })
   	@BeforeClass
   	public void BeforeTest(String deviceProfile) {
   		Helper.CONFIG_PROFILE = deviceProfile;		
   		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
   		ExtentListeners.setDriver(appiumDriverMobile);
   	}
    @BeforeTest
    public void servoice() throws Exception {
        String AccessToken = ViewVirtualPassbook.GetAccessToken("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
        JSONObject NdidEligibile = (JSONObject) new JSONParser().parse(NdidEligibile(AccessToken));
        JsonDataNdidEligibile =  (JSONObject)NdidEligibile.get("data");
        JSONObject NdidUserData = (JSONObject) new JSONParser().parse(NdidUserData(AccessToken));
        JsonDataNdidUserData =  (JSONObject)NdidUserData.get("data");
        System.err.println(JsonDataNdidUserData.get("date_of_birth").toString());
        int year = Integer.parseInt(JsonDataNdidUserData.get("date_of_birth").toString().substring(0,4)) + 543;
        System.err.println(year);
        String yearth = year + JsonDataNdidUserData.get("date_of_birth").toString().substring(4,10) + "T00:00";
        System.err.println(yearth);
        System.err.println(ConvertDate(yearth,false, "TH"));
        String body = "{\n" +
                "  \"acceptance\": \"N\",\n" +
                "  \"version\": \"1.00\"\n" +
                "}";
        JSONObject BiometricConsent = (JSONObject) new JSONParser().parse(GetBiometricConsent_ForDEMO(body, AccessToken));
    }


    public static String ConvertDate(String Date_Expiry, Boolean Format, String timezone)  throws IOException {
        DateTimeFormatter newFormatter = null;
        if(Format){
            if(timezone.equals("TH")){
                int year = Integer.parseInt(Date_Expiry.substring(0,4)) + 543;
                Date_Expiry = year + Date_Expiry.substring(4,16);
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy, HH:mm น.", new Locale("th", "TH"));
                System.err.println("Date of th" + newFormatter);
            }else {
                newFormatter = DateTimeFormatter.ofPattern("dd MMM uu, HH:mm a", Locale.ENGLISH);
            }
        }else {
            if(timezone.equals("TH")){
                int year = Integer.parseInt(Date_Expiry.substring(0,4)) + 543;
                Date_Expiry = year + Date_Expiry.substring(4,10) + "T00:00";
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy", new Locale("th", "TH"));
                System.err.println("Date of th" + newFormatter);
            }else {
                newFormatter = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
            }
        }
        LocalDateTime dateTime = LocalDateTime.parse(Date_Expiry);
        String contactDate = dateTime.format(newFormatter);
        return contactDate;
    }

    @org.testng.annotations.Test(priority = 0)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='my_advisor_card_text_title']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']"));
        String elHeader = Header.getText();
        MobileElement Request = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_list_header_pending_request_id']"));
        String elRequest = Request.getText();
        MobileElement History = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_list_header_request_history_id']"));
        String elHistory = History.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elRequest : " + elRequest);
        System.err.println("elHistory : " + elHistory);

        JSONArray Arr_Pending_Request =  (JSONArray)JsonDataNdidEligibile.get("pending_request");
        JSONArray Arr_Request_History =  (JSONArray)JsonDataNdidEligibile.get("request_history");

         Assert.assertTrue(elHeader.equals("NDID Service"));
        Assert.assertTrue(elRequest.equals("Pending Request"));
        for(int i = 0; i < Arr_Pending_Request.size(); i++){
            JSONObject Pending_Request = (JSONObject) Arr_Pending_Request.get(i);
            MobileElement Date = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_value_" + i + "']"));
            String elDate = Date.getText();
            MobileElement CardHead = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_" + i + "']"));
            String elCardHead = CardHead.getText();
            MobileElement ExpiryDate = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_label_" + i + "']"));
            String elExpiryDate = ExpiryDate.getText();
            System.err.println("elCardHead : " + i + " " + elCardHead);
            System.err.println("elExpiryDate : " + i + " " + elExpiryDate);
            System.err.println("elDate : " + i + " "  + elDate);
            Assert.assertTrue(elCardHead.equals(Pending_Request.get("provider")));
            Assert.assertTrue(elExpiryDate.equals("Expiry Date"));
            String Date_Expiry = ConvertDate(Pending_Request.get("expire_date").toString(), true, "EN");
            System.out.println(elDate + " = " + Date_Expiry);
            Assert.assertTrue(elDate.equals(Date_Expiry));
        
        }
        
        for(int i = 0; i < Arr_Pending_Request.size(); i++){
            MobileElement Date = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_value_" + i + "']"));
            String elDate = Date.getText();
           
        }
        
        for(int i = 0; i < Arr_Request_History.size(); i++){
            JSONObject Request_History = (JSONObject) Arr_Request_History.get(i);
            MobileElement CardHead_History = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_titleId_" + i + "']"));
            String elCardHead_History = CardHead_History.getText();
            System.err.println("elCardHead_History : " + i + " " + elCardHead_History);
            MobileElement Transaction_Date = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_label_" + i + "']"));
            String elTransaction_Date = Transaction_Date.getText();
            System.err.println("elTransaction_Date : " + i + " " + elTransaction_Date);
            MobileElement TranDate = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_Value_" + i + "']"));
            String elTranDate = TranDate.getText();
            System.err.println("elTranDate : " + i + " " + elTranDate);
            MobileElement StatusHistory = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_footerId_" + i + "']"));
            String elStatusHistory = StatusHistory.getText();
            System.err.println("elStatusHistory : " + i + " " + elStatusHistory);
            Assert.assertTrue(elCardHead_History.equals(Request_History.get("provider")));
            Assert.assertTrue(elTransaction_Date.equals("Transaction date"));
            String Date_Expiry = ConvertDate(Request_History.get("datetime").toString(),false, "EN");
            System.out.println(elTranDate + " = " + Date_Expiry);
            Assert.assertTrue(elTranDate.equals(Date_Expiry));
            String status = Request_History.get("status").toString();
            System.out.println("status : " + status);
            if(status.equals("timeout")){
                scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
                Assert.assertTrue(elStatusHistory.equals("Authentication expired"));
                     }else if(status.equals("denied")){
                Assert.assertTrue(elStatusHistory.equals("Authentication was rejected"));
                     }else{
                Assert.assertTrue(elStatusHistory.equals("Authentication successful"));
                
            }
            if(i == 2){
                break;
            }
        }
    }

    @org.testng.annotations.Test(priority = 1)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        scrollUPANDDOWN(0.5, 0.2, 0.5, 0.8); // up
        MobileElement ViewDetailBtn = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_list_navbar_btn_view_detail_id']"));
        ViewDetailBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_view_detail_header_pending_request_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_navbar_title_id']"));
        String elHeader = Header.getText();
        MobileElement Information = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_header_pending_request_id']"));
        String elInformation = Information.getText();
        MobileElement FirstName = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_key_firstname_id']"));
        String elFirstName = FirstName.getText();
        MobileElement FirstNameValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_value_firstname_id']"));
        String elFirstNameValue = FirstNameValue.getText();
        MobileElement LastName = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_key_lastname_id']"));
        String elLastName = LastName.getText();
        MobileElement LastnameValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_value_lastname_id']"));
        String elLastnameValue = LastnameValue.getText();
        MobileElement IDNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_key_idnumber_id']"));
        String elIDNumber = IDNumber.getText();
        MobileElement IDNumberValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_value_idnumber_id']"));
        String elIDNumberValue = IDNumberValue.getText().replace("-", "").replace("X","");
        MobileElement MobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_key_mobilenumber_id']"));
        String elMobileNumber = MobileNumber.getText();
        MobileElement MobileNumberValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_value_mobilenumber_id']"));
        String elMobileNumberValue = MobileNumberValue.getText().replace("-", "").replace("X","");
        MobileElement RegisteredDate = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_key_registerdate_id']"));
        String elRegisteredDate = RegisteredDate.getText();
        MobileElement DateValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_value_registerdate_id']"));
        String elDateValue = DateValue.getText();
        MobileElement BtnDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']"));
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
        System.err.println(JsonDataNdidUserData.get("first_name_en"));
        System.err.println(JsonDataNdidUserData.get("last_name_en"));
        System.err.println(JsonDataNdidUserData.get("citizen_id").toString().substring(9,13));
        System.err.println(JsonDataNdidUserData.get("mobile_no").toString().substring(6,10));
        System.err.println(ConvertDate(JsonDataNdidEligibile.get("registered_date").toString().substring(0,16),false, "EN"));
        Assert.assertTrue(elHeader.equals("NDID Service Detail"));
        Assert.assertTrue(elInformation.equals("Your registered Information"));
        Assert.assertTrue(elFirstName.equals("First Name"));
        Assert.assertTrue(elLastName.equals("Last Name"));
        Assert.assertTrue(elIDNumber.equals("ID Number"));
        Assert.assertTrue(elMobileNumber.equals("Mobile Number"));
        Assert.assertTrue(elRegisteredDate.equals("Registered Date"));
        Assert.assertTrue(elFirstNameValue.equals(JsonDataNdidUserData.get("first_name_en")));
        Assert.assertTrue(elLastnameValue.equals(JsonDataNdidUserData.get("last_name_en")));
        Assert.assertTrue(elIDNumberValue.substring(9,13).equals(JsonDataNdidUserData.get("citizen_id").toString().substring(9,13)));
        Assert.assertTrue(elMobileNumberValue.substring(6,10).equals(JsonDataNdidUserData.get("mobile_no").toString().substring(6,10)));
        Assert.assertTrue(elDateValue.equals(ConvertDate(JsonDataNdidEligibile.get("registered_date").toString().substring(0,16),false, "EN")));
        Assert.assertTrue(elBtnDeregister.equals("Deregister NDID Service"));
           }

    @org.testng.annotations.Test(priority = 2)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"));
        BtnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_header_pending_request_id']")));
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_1']"));
        PendingRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
        MobileElement TMBAuthen = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']"));
        String elTMBAuthen = TMBAuthen.getText();
        MobileElement AuthenDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_header_label_id']"));
        String elAuthenDetail = AuthenDetail.getText();
        MobileElement ExpiryDate = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_transaction_title_label_id']"));
        String elExpiryDate = ExpiryDate.getText();
        MobileElement ExpiryDateValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_transaction_value_label_id']"));
        String elExpiryDateValue = ExpiryDateValue.getText();
        MobileElement Message = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_message_title_label_id']"));
        String elMessage = Message.getText();
        MobileElement MessageDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_message_value_label_id']"));
        String elMessageDetail = MessageDetail.getText();
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        String elBtnProceed = BtnProceed.getText();
        MobileElement BtnReject = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_reject_id']"));
        String elBtnReject = BtnReject.getText();
        System.err.println("elTMBAuthen : " + elTMBAuthen);
        System.err.println("elAuthenDetail : " + elAuthenDetail);
        System.err.println("elExpiryDate : " + elExpiryDate);
        System.err.println("elExpiryDateValue : " + elExpiryDateValue);
        System.err.println("elMessage : " + elMessage);
        System.err.println("elMessageDetail : " + elMessageDetail);
        System.err.println("elBtnProceed : " + elBtnProceed);
        System.err.println("elBtnReject : " + elBtnReject);

        JSONArray Arr_Pending_Request =  (JSONArray)JsonDataNdidEligibile.get("pending_request");
        JSONObject Pending_Request = (JSONObject) Arr_Pending_Request.get(1);

        Assert.assertTrue(elTMBAuthen.equals("tmb Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Expiry Date"));
        Assert.assertTrue(elExpiryDateValue.equals(ConvertDate(Pending_Request.get("expire_date").toString(),false,"EN")));
        Assert.assertTrue(elMessage.equals("Message"));
        Assert.assertTrue(elMessageDetail.equals(Pending_Request.get("request_message")));
        Assert.assertTrue(elBtnProceed.equals("Proceed"));
        Assert.assertTrue(elBtnReject.equals("Reject"));

        
    }

    @org.testng.annotations.Test(priority = 3)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_content_id']")));
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
        MobileElement BtnDisagree = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_disagree_id']"));
        BtnDisagree.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_handle_message_label']")));
        MobileElement TitleDisagreePopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='popup-title']"));
        String elTitleDisagreePopup = TitleDisagreePopup.getText();
        MobileElement DisagreePopupContent = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_handle_message_label']"));
        String elDisagreePopupContent = DisagreePopupContent.getText();
        System.err.println("elTitleDisagreePopup : " + elTitleDisagreePopup);
        System.err.println("elDisagreePopupContent : " + elDisagreePopupContent);
        MobileElement BtnCancelPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_cancle_id']"));
        String elBtnCancelPopup = BtnCancelPopup.getText();
        MobileElement BtnConfirmPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_confirm_id']"));
        String elBtnConfirmPopup = BtnConfirmPopup.getText();
        System.err.println("elBtnCanclePopup : " + elBtnCancelPopup);
        System.err.println("elBtnConfirmPopup : " + elBtnConfirmPopup);

        Assert.assertTrue(elTitleDisagreePopup.equals("Disagree Biometric Consent?"));
        Assert.assertTrue(elDisagreePopupContent.equals("If you disagree biometric consent you will not be able to authenticate this request. Please confirm if you would like to reject."));
        Assert.assertTrue(elBtnConfirmPopup.equals("Confirm"));
        Assert.assertTrue(elBtnCancelPopup.equals("Cancel"));
        BtnCancelPopup.click();
        BtnDisagree.click();
    }

    @org.testng.annotations.Test(priority = 4)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01006() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_handle_message_label']")));
        MobileElement BtnConfirmPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_confirm_id']"));
        BtnConfirmPopup.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_header_pending_request_id']")));
    }

    @org.testng.annotations.Test(priority = 5)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01007() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_1']"));
        PendingRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_content_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_navbar_title_id']"));
        String elHeader = Header.getText();
        MobileElement BioConsent = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_header_id']"));
        String elBioConsent = BioConsent.getText();
        MobileElement BioConsentContent = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_content_id']"));
        String elBioConsentContent = BioConsentContent.getText();
        MobileElement BtnAgree = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_agree_id']"));
        String elBtnAgree = BtnAgree.getText();
        MobileElement BtnDisagree = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_biometric_consent_disagree_id']"));
        String elBtnDisagree = BtnDisagree.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elBioConsent : " + elBioConsent);
        System.err.println("elBioConsentContent : " + elBioConsentContent);
        System.err.println("elBtnAgree : " + elBtnAgree);
        System.err.println("elBtnDisagree : " + elBtnDisagree);
        Assert.assertTrue(elHeader.equals("tmb Authentication"));
        Assert.assertTrue(elBioConsent.equals("Biometric Consent"));
        Assert.assertTrue(elBtnAgree.equals("Agree"));
        Assert.assertTrue(elBtnDisagree.equals("Disagree"));
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
        BtnAgree.click();
    }

    @org.testng.annotations.Test(priority = 6)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01008() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_selfie_tip_navigation_icon_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_navigation_icon_id']"));
        String elHeader = Header.getText();
        MobileElement SelfieTip = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_header_label_id']"));
        String elSelfieTip = SelfieTip.getText();
        MobileElement RemoveGlass = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_remove_glass_label_id']"));
        String elRemoveGlass = RemoveGlass.getText();
        MobileElement GoodLight = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_good_light_label_id']"));
        String elGoodLight = GoodLight.getText();
        MobileElement AlignFace = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_align_face_label_id']"));
        String elAlignFace = AlignFace.getText();
        MobileElement BtnContinue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_button_continue_id']"));
        String elBtnContinue = BtnContinue.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elSelfieTip : " + elSelfieTip);
        System.err.println("elRemoveGlass : " + elRemoveGlass);
        System.err.println("elGoodLight : " + elGoodLight);
        System.err.println("elAlignFace : " + elAlignFace);
        System.err.println("elBtnContinue : " + elBtnContinue);

        Assert.assertTrue(elHeader.equals("tmb Authentication"));
        Assert.assertTrue(elSelfieTip.equals("Selfie Tips"));
        Assert.assertTrue(elRemoveGlass.equals("Remove glasses / mask / cap"));
        Assert.assertTrue(elGoodLight.equals("Take a selfie in good lighting"));
        Assert.assertTrue(elAlignFace.equals("Align your face with the frame"));
        Assert.assertTrue(elBtnContinue.equals("Continue"));
    }

    @Test(priority = 7)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01009() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnBack2 = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"));
        BtnBack2.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
       MobileElement BtnProcess = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProcess.click();
 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_selfie_tip_navigation_icon_id']")));
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_navigation_icon_id']"));
        String elHeader = Header.getText();
        MobileElement SelfieTip = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_header_label_id']"));
        String elSelfieTip = SelfieTip.getText();
        MobileElement RemoveGlass = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_remove_glass_label_id']"));
        String elRemoveGlass = RemoveGlass.getText();
        MobileElement GoodLight = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_good_light_label_id']"));
        String elGoodLight = GoodLight.getText();
        MobileElement AlignFace = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_align_face_label_id']"));
        String elAlignFace = AlignFace.getText();
        MobileElement BtnContinue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_selfie_tip_button_continue_id']"));
        String elBtnContinue = BtnContinue.getText();
        System.err.println("elHeader : " + elHeader);
        System.err.println("elSelfieTip : " + elSelfieTip);
        System.err.println("elRemoveGlass : " + elRemoveGlass);
        System.err.println("elGoodLight : " + elGoodLight);
        System.err.println("elAlignFace : " + elAlignFace);
        System.err.println("elBtnContinue : " + elBtnContinue);

        Assert.assertTrue(elHeader.equals("tmb Authentication"));
        Assert.assertTrue(elSelfieTip.equals("Selfie Tips"));
        Assert.assertTrue(elRemoveGlass.equals("Remove glasses / mask / cap"));
        Assert.assertTrue(elGoodLight.equals("Take a selfie in good lighting"));
        Assert.assertTrue(elAlignFace.equals("Align your face with the frame"));
        Assert.assertTrue(elBtnContinue.equals("Continue"));
    }
}
