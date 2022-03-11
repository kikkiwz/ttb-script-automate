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
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import static com.tmb.automation.api.customerservice.sprint21.NdidEligibile.NdidEligibile;
import static com.tmb.automation.api.customerservice.sprint21.NdidUserData.NdidUserData;
import static com.tmb.automation.api.customerservice.sprint21.BiometricConsent.GetBiometricConsent_ForDEMO;
import static com.tmb.automation.test.customerservice.sprint17.Base.ConfirmPin;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class Demo_NDID_EN extends Base {
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

    @Test(priority = 0)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
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
                
            }else{
                Assert.assertTrue(elStatusHistory.equals("Authentication successful"));
                
            }
            if(i == 0){
                break;
            }
        }
    }

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void TC_ONEAPP_8853_NDIDAUTH_00001() throws Exception {
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

    @Test(priority = 3)
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01001() throws Exception {
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
        MobileElement BtnCancelPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_1']"));
        String elBtnCancelPopup = BtnCancelPopup.getText();
        MobileElement BtnConfirmPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
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

    @Test(priority = 4)
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_biometric_consent_popup_handle_message_label']")));

        
        MobileElement BtnConfirmPopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        BtnConfirmPopup.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_header_pending_request_id']")));
        }

    @Test(priority = 5)
    public void TC_ONEAPP_8855_NDID_BIO_SIT_01002() throws Exception {
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

    @Test(priority = 6)
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
    public void TC_ONEAPP_8855_NDID_BIO_SIT_00001() throws Exception {
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


    @Test(priority = 8)
    public void TC_ONEAPP_8865_NDID_Review_SIT_00001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"));
        BtnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
        MobileElement BtnBack2 = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"));
        BtnBack2.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_0']"));
        PendingRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_personal_infor_name_value_th_id']")));

      
        MobileElement Header = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_navbar_title_id']"));
        String elHeader = Header.getText();
        MobileElement PersonalDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_title_personal_detail_id']"));
        String elPersonalDetail = PersonalDetail.getText();
        MobileElement Edit = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_btn_edit_id']"));
        String elEdit = Edit.getText();
        MobileElement NameTH = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_name_desc_th_id']"));
        String elNameTH = NameTH.getText();
        MobileElement NameTHValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_name_value_th_id']"));
        String elNameTHValue = NameTHValue.getText();
        MobileElement SurnameTH = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_surname_desc_th_id']"));
        String elSurnameTH = SurnameTH.getText();
        MobileElement SurnameTHValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_surname_value_th_id']"));
        String elSurnameTHValue = SurnameTHValue.getText();
        MobileElement NameEN = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_name_desc_en_id']"));
        String elNameEN = NameEN.getText();
        MobileElement NameENValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_name_value_en_id']"));
        String elNameENValue = NameENValue.getText();
        MobileElement SurnameEN = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_surname_desc_en_id']"));
        String elSurnameEN = SurnameEN.getText();
        MobileElement SurnameENValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_surname_value_en_id']"));
        String elSurnameENValue = SurnameENValue.getText();
        MobileElement DateOfBirth = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_date_of_birth_desc_id']"));
        String elDateOfBirth = DateOfBirth.getText();
        MobileElement DateOfBirthValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_date_of_birth_value_id']"));
        String elDateOfBirthValue = DateOfBirthValue.getText();
        MobileElement Nationality = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_nationality_desc_id']"));
        String elNationality = Nationality.getText();
        MobileElement NationalityValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_nationality_value_id']"));
        String elNationalityValue = NationalityValue.getText();
        MobileElement Status_data = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_status_desc_id']"));
        String elStatus = Status_data.getText();
        MobileElement StatusValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_status_value_id']"));
        String elStatusValue = StatusValue.getText();
        MobileElement IDNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_idcard_desc_id']"));
        String elIDNumber = IDNumber.getText();
        MobileElement IDNumberValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_idcard_value_id']"));
        String elIDNumberValue = IDNumberValue.getText().replace("-","");
        MobileElement Email = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_email_desc_id']"));
        String elEmail = Email.getText();
        MobileElement EmailValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_email_value_id']"));
        String elEmailValue = EmailValue.getText();
        MobileElement MobileNumber = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_mobile_desc_id']"));
        String elMobileNumber = MobileNumber.getText();
        MobileElement MobileNumberValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_mobile_value_id']"));
        String elMobileNumberValue = MobileNumberValue.getText().replace("-","");
        MobileElement RegisterAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_registered_address_desc_id']"));
        String elRegisterAddress = RegisterAddress.getText();
        MobileElement ContactAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_contact_address_desc_id']"));
        String elContactAddress = ContactAddress.getText();
        MobileElement ContactAddressValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_contact_address_value_id']"));
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
        System.err.println("elContactAddress : " + elContactAddress + "     " + elContactAddressValue);
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
          MobileElement OccupationDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_title_occupation_detail_id']"));
        String elOccupationDetail = OccupationDetail.getText();
        System.err.println("elOccupationDetail : " + elOccupationDetail);
        MobileElement Occupation = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_occupation_desc_id']"));
        String elOccupation = Occupation.getText();
        System.err.println("elOccupation : " + elOccupation);
        MobileElement OccupationValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_occupation_value_id']"));
        String elOccupationValue = OccupationValue.getText();
        System.err.println("elOccupationValue : " + elOccupationValue);
        MobileElement CompanyName = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_company_name_desc_id']"));
        String elCompanyName = CompanyName.getText();
        System.err.println("elCompanyName : " + elCompanyName);
        MobileElement CompanyNameValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_company_name_value_id']"));
        String elCompanyNameValue = CompanyNameValue.getText();
        System.err.println("elCompanyNameValue : " + elCompanyNameValue);
        MobileElement CompanyAddress = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_company_address_desc_id']"));
        String elCompanyAddress = CompanyAddress.getText();
        System.err.println("elCompanyAddress : " + elCompanyAddress);
        MobileElement TitleIncome = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_title_income_detail_id']"));
        String elTitleIncome = TitleIncome.getText();
        System.err.println("elTitleIncome : " + elTitleIncome);
        MobileElement PersonalIncome = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_personal_income_desc_id']"));
        String elPersonalIncome = PersonalIncome.getText();
        System.err.println("elPersonalIncome : " + elPersonalIncome);
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
        MobileElement SourceIncome = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_source_income_desc_id']"));
        String elSourceIncome = SourceIncome.getText();
        System.err.println("elSourceIncome : " + elSourceIncome);
        MobileElement SourceIncomeValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_aource_income_value_id']"));
        String elSourceIncomeValue = SourceIncomeValue.getText();
        System.err.println("elSourceIncomeValue : " + elSourceIncomeValue);
        MobileElement CountryIncome = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_country_income_desc_id']"));
        String elCountryIncome = CountryIncome.getText();
        System.err.println("elCountryIncome : " + elCountryIncome);
        MobileElement CountryIncomeValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_country_income_value_id']"));
        String elCountryIncomeValue = CountryIncomeValue.getText();
        System.err.println("elCountryIncomeValue : " + elCountryIncomeValue);
        MobileElement CheckboxValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_checkbox_value_id']"));
        String elCheckboxValue = CheckboxValue.getText();
        System.err.println("elCheckboxValue : " + elCheckboxValue);
        MobileElement ReadMoreValue = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_btn_readmore_value_id']"));
        String elReadMoreValue = ReadMoreValue.getText();
        System.err.println("elReadMoreValue : " + elReadMoreValue);
        MobileElement BtnConfirm = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_personal_infor_btn_confirm_value_id']"));
        String elBtnConfirm = BtnConfirm.getText();
        System.err.println("elBtnConfirm : " + elBtnConfirm);

               Assert.assertTrue(elHeader.equals("tmb Authentication"));
        Assert.assertTrue(elPersonalDetail.equals("Personal Detail"));
        Assert.assertTrue(elEdit.equals("Edit"));
        Assert.assertTrue(elNameTH.equals("Name (TH)"));
        Assert.assertTrue(elSurnameTH.equals("Surname (TH)"));
        Assert.assertTrue(elNameEN.equals("Name (EN)"));
        Assert.assertTrue(elSurnameEN.equals("Surname (EN)"));
        Assert.assertTrue(elDateOfBirth.equals("Date of birth"));
        Assert.assertTrue(elNationality.equals("Nationality"));
        Assert.assertTrue(elStatus.equals("Status"));
        Assert.assertTrue(elIDNumber.equals("ID card number"));
        Assert.assertTrue(elEmail.equals("Email"));
        Assert.assertTrue(elMobileNumber.equals("Mobile number"));
        Assert.assertTrue(elRegisterAddress.equals("Registered Address"));
        Assert.assertTrue(elContactAddress.equals("Contact Address"));
        Assert.assertTrue(elOccupationDetail.equals("Occupation Detail"));
        Assert.assertTrue(elOccupation.equals("Occupation"));
        Assert.assertTrue(elCompanyName.equals("Company Name"));
        Assert.assertTrue(elCompanyAddress.equals("Company Address"));
        Assert.assertTrue(elTitleIncome.equals("Income Detail"));
        Assert.assertTrue(elPersonalIncome.equals("Personal Income"));
        Assert.assertTrue(elSourceIncome.equals("Source of Income"));
        Assert.assertTrue(elCountryIncome.equals("Country of Income"));
        Assert.assertTrue(elCheckboxValue.equals("I hereby agree to the Bank to disclose my personal data above to other organizations requesting information for the purpose of identity authentication. You can check the rights of the data subject at the Privacy Policy at http://www.ttbbank.com"));
        Assert.assertTrue(elReadMoreValue.equals("Read More"));
        Assert.assertTrue(elBtnConfirm.equals("Confirm"));
        Assert.assertTrue(elNameTHValue.equals(JsonDataNdidUserData.get("first_name_th")));
        Assert.assertTrue(elSurnameTHValue.equals(JsonDataNdidUserData.get("last_name_th")));
        Assert.assertTrue(elNameENValue.equals(JsonDataNdidUserData.get("first_name_en")));
        Assert.assertTrue(elSurnameENValue.equals(JsonDataNdidUserData.get("last_name_en")));
        System.err.println(ConvertDate(JsonDataNdidUserData.get("date_of_birth").toString(),false, "TH"));
        Assert.assertTrue(elDateOfBirthValue.equals(ConvertDate(JsonDataNdidUserData.get("date_of_birth").toString(),false, "TH")));
        Assert.assertTrue(elNationalityValue.equals(JsonDataNdidUserData.get("nationality")));
        Assert.assertTrue(elStatusValue.equals(JsonDataNdidUserData.get("marital_status")));
        Assert.assertTrue(elIDNumberValue.equals(JsonDataNdidUserData.get("citizen_id")));
        Assert.assertTrue(elEmailValue.equals(JsonDataNdidUserData.get("email")));
        Assert.assertTrue(elMobileNumberValue.equals(JsonDataNdidUserData.get("mobile_no")));
        Assert.assertTrue(elContactAddressValue.equals(JsonDataNdidUserData.get("contact_address")));
        Assert.assertTrue(elOccupationValue.equals(JsonDataNdidUserData.get("occupation")));
        Assert.assertTrue(elCompanyNameValue.equals(JsonDataNdidUserData.get("company_name")));
        Assert.assertTrue(elSourceIncomeValue.equals(JsonDataNdidUserData.get("source_of_income")));
        Assert.assertTrue(elCountryIncomeValue.equals(JsonDataNdidUserData.get("country_of_income")));
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down

       
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down

        TouchAction clickMore = new TouchAction(appiumDriverMobile);
        Thread.sleep(2000);
        clickMore.tap(PointOption.point(500,2060)).perform();
        Thread.sleep(2000);
         ConfirmPin();
    }


    @Test(priority = 9)
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']")));
        MobileElement TitleSuccessful = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']"));
        String elTitleSuccessful = TitleSuccessful.getText();
        MobileElement TitleDescription = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_desc_id']"));
        String elTitleDescription = TitleDescription.getText().replace("\n"," ");
        MobileElement Transaction = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[3]"));
        String elTransaction = Transaction.getText();
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_button_next_id']"));
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elBtnConfirm : " + elTitleSuccessful);
        System.err.println("elBtnConfirm : " + elTitleDescription);
        System.err.println("elBtnConfirm : " + elTransaction);
        System.err.println("elBtnConfirm : " + elBtnBackToMainMenu);

              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elTitleSuccessful.equals("Authentication Successful"));
        Assert.assertTrue(elTitleDescription.equals("ttb already submited your authentication detail, please proceed in requested app. "));
        Assert.assertTrue(elTransaction.substring(0, elTransaction.length() - 8).equals("Transaction Date" + DateTimeNow + "Ref. No"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Main Menu"));
        BtnBackToMainMenu.click();
           }

    @Test(priority = 10)
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00001_1() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // Down
        MobileElement CardHead_History = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_titleId_0']"));
        String elCardHead_History = CardHead_History.getText();
        System.err.println("elCardHead_History : " + elCardHead_History);
        MobileElement Transaction_Date = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_label_0']"));
        String elTransaction_Date = Transaction_Date.getText();
        System.err.println("elTransaction_Date : " + elTransaction_Date);
        MobileElement TranDate = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_Value_0']"));
        String elTranDate = TranDate.getText();
        System.err.println("elTranDate : " + elTranDate);
        MobileElement StatusHistory = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_footerId_0']"));
        String elStatusHistory = StatusHistory.getText();
        System.err.println("elStatusHistory : " + elStatusHistory);
        //appiumDriverMobile.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Transaction date\").instance(0))");

          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elCardHead_History.equals("tmb"));
        Assert.assertTrue(elTransaction_Date.equals("Transaction date"));
        Assert.assertTrue(elTranDate.equals(dtf.format(now)));
        Assert.assertTrue(elStatusHistory.equals("Authentication successful"));
        CardHead_History.click();
    }

    @Test(priority = 11)
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00001_2() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
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
        System.err.println("1 : " + elTMBAuthen);
        System.err.println("2 : " + elAuthenDetail);
        System.err.println("3 : " + elExpiryDate);
        System.err.println("4 : " + elExpiryDateValue);
        System.err.println("5 : " + elMessage);
        System.err.println("6 : " + elMessageDetail);

       
        String AccessToken = ViewVirtualPassbook.GetAccessToken("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
        JSONObject NdidEligibile = (JSONObject) new JSONParser().parse(NdidEligibile(AccessToken));
        JsonDataNdidEligibile =  (JSONObject)NdidEligibile.get("data");
        JSONArray Arr_Pending_Request = (JSONArray)JsonDataNdidEligibile.get("request_history");
        JSONObject Pending_Request = (JSONObject) Arr_Pending_Request.get(0);

        System.err.println("1 : " + ConvertDate(Pending_Request.get("expire_date").toString(),true,"EN"));
        Assert.assertTrue(elTMBAuthen.equals("tmb Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Transaction Date"));
        Assert.assertTrue(elExpiryDateValue.equals(ConvertDate(Pending_Request.get("datetime").toString(),true,"EN")));
        Assert.assertTrue(elMessage.equals("Message"));
        Assert.assertTrue(elMessageDetail.equals(Pending_Request.get("request_message")));
    }

    @Test(priority = 12)
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"));
        BtnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_1']"));
        PendingRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));

        
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        Thread.sleep(2000);
         ConfirmPin();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']")));
        MobileElement TitleSuccessful = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']"));
        String elTitleSuccessful = TitleSuccessful.getText();
        MobileElement TitleDescription = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_desc_id']"));
        String elTitleDescription = TitleDescription.getText().replace("\n"," ");
        MobileElement Transaction = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[3]"));
        String elTransaction = Transaction.getText();
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_button_next_id']"));
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elBtnConfirm : " + elTitleSuccessful);
        System.err.println("elBtnConfirm : " + elTitleDescription);
        System.err.println("elBtnConfirm : " + elTransaction);
        System.err.println("elBtnConfirm : " + elBtnBackToMainMenu);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elTitleSuccessful.equals("Authentication Successful"));
        Assert.assertTrue(elTitleDescription.equals("ttb already submited your authentication detail, please proceed in requested app. "));
        Assert.assertTrue(elTransaction.substring(0, elTransaction.length() - 8).equals("Transaction Date" + DateTimeNow + "Ref. No"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Main Menu"));
        BtnBackToMainMenu.click();
    }

    @Test(priority = 13)
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00002_1() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // Down
        MobileElement CardHead_History = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_titleId_0']"));
        String elCardHead_History = CardHead_History.getText();
        System.err.println("elCardHead_History : " + elCardHead_History);
        MobileElement Transaction_Date = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_label_0']"));
        String elTransaction_Date = Transaction_Date.getText();
        System.err.println("elTransaction_Date : " + elTransaction_Date);
        MobileElement TranDate = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_Value_0']"));
        String elTranDate = TranDate.getText();
        System.err.println("elTranDate : " + elTranDate);
        MobileElement StatusHistory = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_history_footerId_0']"));
        String elStatusHistory = StatusHistory.getText();
        System.err.println("elStatusHistory : " + elStatusHistory);
       // appiumDriverMobile.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Transaction date\").instance(0))");

          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elCardHead_History.equals("tmb"));
        Assert.assertTrue(elTransaction_Date.equals("Transaction date"));
        Assert.assertTrue(elTranDate.equals(dtf.format(now)));
        Assert.assertTrue(elStatusHistory.equals("Authentication successful"));
        CardHead_History.click();
    }

    @Test(priority = 14)
    public void TC_ONEAPP_8871_NDID_SUCCESS_SIT_00002_2() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
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
        System.err.println("1 : " + elTMBAuthen);
        System.err.println("2 : " + elAuthenDetail);
        System.err.println("3 : " + elExpiryDate);
        System.err.println("4 : " + elExpiryDateValue);
        System.err.println("5 : " + elMessage);
        System.err.println("6 : " + elMessageDetail);

        
        String AccessToken = ViewVirtualPassbook.GetAccessToken("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
        JSONObject NdidEligibile = (JSONObject) new JSONParser().parse(NdidEligibile(AccessToken));
        JsonDataNdidEligibile =  (JSONObject)NdidEligibile.get("data");
        JSONArray Arr_Pending_Request = (JSONArray)JsonDataNdidEligibile.get("request_history");
        JSONObject Pending_Request = (JSONObject) Arr_Pending_Request.get(0);

        System.err.println("1 : " + ConvertDate(Pending_Request.get("expire_date").toString(),true,"EN"));
        Assert.assertTrue(elTMBAuthen.equals("tmb Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Transaction Date"));
        Assert.assertTrue(elExpiryDateValue.equals(ConvertDate(Pending_Request.get("datetime").toString(),true,"EN")));
        Assert.assertTrue(elMessage.equals("Message"));
        Assert.assertTrue(elMessageDetail.equals(Pending_Request.get("request_message")));
    }

    @Test(priority = 15)
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"));
        BtnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        MobileElement ViewDetailBtn = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_list_navbar_btn_view_detail_id']"));
        ViewDetailBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_view_detail_header_pending_request_id']")));
        MobileElement BtnDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']"));
        BtnDeregister.click();
        MobileElement TitlePopupDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='popup-title']"));
        String elTitlePopupDeregister = TitlePopupDeregister.getText();
        MobileElement PopupDeregisterDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_popup_handle_message_label']"));
        String elPopupDeregisterDetail = PopupDeregisterDetail.getText();
        MobileElement BtnConfirm = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        String elBtnConfirm = BtnConfirm.getText();
        MobileElement BtnCancel = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_1']"));
        String elBtnCancel = BtnCancel.getText();

        System.err.println("elTitlePopupDeregister : " + elTitlePopupDeregister);
        System.err.println("elPopupDeregisterDetail : " + elPopupDeregisterDetail);
        System.err.println("elBtnConfirm : " + elBtnConfirm);
        System.err.println("elBtnCancel : " + elBtnCancel);

        Assert.assertTrue(elTitlePopupDeregister.equals("Do you want to deregister NDID service?"));
        Assert.assertTrue(elPopupDeregisterDetail.equals("After the deregistration, you would not be able to use ttb as an IdP for authentication anymore."));
        Assert.assertTrue(elBtnConfirm.equals("Confirm"));
        Assert.assertTrue(elBtnCancel.equals("Cancel"));
    }

    @Test(priority = 16)
    @Step("in case click cancel")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnCancel = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_1']"));
        BtnCancel.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']")));

        MobileElement BtnDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']"));
        String elBtnDeregister = BtnDeregister.getText();
        Assert.assertTrue(elBtnDeregister.equals("Deregister NDID Service"));

        BtnDeregister.click();
    }

    @Test(priority = 17)
    @Step("in case click X")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnX = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_popup_handle_button_close']"));
        BtnX.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']")));

     
        MobileElement BtnDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_view_detail_deregister_id']"));
        String elBtnDeregister = BtnDeregister.getText();
        Assert.assertTrue(elBtnDeregister.equals("Deregister NDID Service"));

        BtnDeregister.click();
    }

    @Test(priority = 18)
    @Step("in case click Confirm")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00004() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        MobileElement BtnConfirm = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        BtnConfirm.click();
        Thread.sleep(3000);
         Thread.sleep(3000);
        ConfirmPin();
        }

    @Test(priority = 19)
    @Step("in case click Confirm")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']")));

        MobileElement TitleNDIDDeregister = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']"));
        String elTitleNDIDDeregister = TitleNDIDDeregister.getText();
        MobileElement NDIDDeregisterDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_desc_id']"));
        String elNDIDDeregisterDetail = NDIDDeregisterDetail.getText().replace("\n"," ");
        MobileElement Transaction = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[3]"));
        String elTransaction = Transaction.getText();
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_button_next_id']"));
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elTitleNDIDDeregister : " + elTitleNDIDDeregister);
        System.err.println("elNDIDDeregisterDetail : " + elNDIDDeregisterDetail);
        System.err.println("elTransaction : " + elTransaction);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elTitleNDIDDeregister.equals("NDID Deregistration Successful"));
        Assert.assertTrue(elNDIDDeregisterDetail.equals("You can register NDID service again anytime."));
        Assert.assertTrue(elTransaction.substring(0, elTransaction.length() - 8).equals("Transaction Date" + DateTimeNow + "Ref. No"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Service Page"));


           BtnBackToMainMenu.click();
       
    }

    @Test(priority = 20)
    @Step("in case click Confirm")
    public void TC_ONEAPP_8852_NDID_EN_DEREGISTER_SIT_00006() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_error_ial_label_title_id']")));

        MobileElement TitleNDIDError = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_error_ial_label_title_id']"));
        String elTitleNDIDError = TitleNDIDError.getText();
        MobileElement NDIDErrorDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_error_ial_label_desc_id']"));
        String elNDIDErrorDetail = NDIDErrorDetail.getText();
        MobileElement ContactError = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_error_ial_label_footer_id']"));
        String elContactError = ContactError.getText();
        MobileElement BtnBackToMainMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_error_ial_btn_back_id']"));
        String elBtnBackToMainMenu = BtnBackToMainMenu.getText();
        System.err.println("elTitleNDIDError : " + elTitleNDIDError);
        System.err.println("elNDIDErrorDetail : " + elNDIDErrorDetail);
        System.err.println("elContactError : " + elContactError);
        System.err.println("elBtnBackToMainMenu : " + elBtnBackToMainMenu);


        Assert.assertTrue(elTitleNDIDError.equals("You cannot verify your identity via the National Digital ID Platform (NDID)"));
        Assert.assertTrue(elNDIDErrorDetail.equals("Please bring your ID card to ttb branch and take photo to complete the Know Your Customer (KYC) process and apply NDID service."));
        Assert.assertTrue(elContactError.equals("Contact ttb contact center 1428 for more information"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("Back to Main Menu"));

        BtnBackToMainMenu.click();
    }
    }
