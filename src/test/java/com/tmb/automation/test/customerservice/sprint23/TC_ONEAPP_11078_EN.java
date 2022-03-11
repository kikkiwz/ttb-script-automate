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

public class TC_ONEAPP_11078_EN extends Base {
    JSONObject JsonDataNdidEligibile = null;
    JSONObject JsonDataNdidUserData = null;
    @Parameters({"DeviceProfile" })
   	@BeforeClass
   	public void BeforeTest(String deviceProfile) {
   		Helper.CONFIG_PROFILE = deviceProfile;		
   		appiumDriverMobile=appiumCapabilitiesMobileElement();
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

    @Test(priority = 12)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01013() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_0']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_detail_button_reject_id']")));
        appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_reject_id']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='popup-title']")));
        MobileElement TitlePopup = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='popup-title']"));
        String elTitlePopup = TitlePopup.getText();
        System.err.println("elTransaction_Date : " + elTitlePopup);
        MobileElement PopupDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_popup_handle_message_label']"));
        String elPopupDetail = PopupDetail.getText();
        System.err.println("elTranDate : " + elPopupDetail);
        MobileElement BtnConfirm = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_0']"));
        String elBtnConfirm = BtnConfirm.getText();
        System.err.println("elStatusHistory : " + elBtnConfirm);
        MobileElement BtnCancle = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='BTN_ID_1']"));
        String elBtnCancle = BtnCancle.getText();
        System.err.println("elStatusHistory : " + elBtnCancle);


       
        Assert.assertTrue(elTitlePopup.equals("Reject this request"));
        Assert.assertTrue(elPopupDetail.equals("If you reject this request you will need to request again should you want to use ttb app as identity authentication channel. Do you want to reject this request?"));
        Assert.assertTrue(elBtnConfirm.equals("Confirm"));
        Assert.assertTrue(elBtnCancle.equals("Cancel"));

        BtnCancle.click();
    }

    @Test(priority = 13)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01014() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_detail_button_reject_id']")));

       }

    @Test(priority = 14)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01015() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_detail_button_reject_id']")));
        appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_reject_id']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='popup-title']")));
        MobileElement BtnConfirm = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.widget.Button[1]"));
        BtnConfirm.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']")));
        MobileElement TitleRejectSuccess = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']"));
        String elTitleRejectSuccess = TitleRejectSuccess.getText();
        MobileElement RejectDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_desc_id']"));
        String elRejectDetail = RejectDetail.getText().replace("\n"," ");
        MobileElement TransactionReject = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[3]"));
        String elTransactionReject = TransactionReject.getText();
        MobileElement BtnBackMainMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_button_next_id']"));
        String elBtnBackMainMenu = BtnBackMainMenu.getText();
        System.err.println("elBtnConfirm : " + elTitleRejectSuccess);
        System.err.println("elBtnConfirm : " + elRejectDetail);
        System.err.println("elBtnConfirm : " + elTransactionReject);
        System.err.println("elBtnConfirm : " + elBtnBackMainMenu);


   

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elTitleRejectSuccess.equals("Request Rejection Successful"));
        Assert.assertTrue(elRejectDetail.equals("Please contact the source bank, If you did not request for this authentication."));
        Assert.assertTrue(elTransactionReject.substring(0, elTransactionReject.length() - 8).equals("Transaction Date" + DateTimeNow + "Ref. No"));
        Assert.assertTrue(elBtnBackMainMenu.equals("Back to Main Menu"));
        BtnBackMainMenu.click();
    }

    @Test(priority = 15)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01016() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
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

      
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm a");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + ", " + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
        System.err.println("Transaction Date" + DateTimeNow + "Ref. No");
        Assert.assertTrue(elCardHead_History.equals("tmb"));
        Assert.assertTrue(elTransaction_Date.equals("Transaction date"));
        Assert.assertTrue(elTranDate.equals(dtf.format(now)));
        Assert.assertTrue(elStatusHistory.equals("Authentication expired"));
        CardHead_History.click();
    }

    @Test(priority = 16)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01017() throws Exception {
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


        String AccessToken = ViewVirtualPassbook.GetAccessToken("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
        JSONObject NdidEligibile = (JSONObject) new JSONParser().parse(NdidEligibile(AccessToken));
        JsonDataNdidEligibile =  (JSONObject)NdidEligibile.get("data");
        JSONArray Arr_Pending_Request = (JSONArray)JsonDataNdidEligibile.get("request_history");
        JSONObject Pending_Request = (JSONObject) Arr_Pending_Request.get(0);

        Assert.assertTrue(elTMBAuthen.equals("tmb Authentication"));
        Assert.assertTrue(elAuthenDetail.equals("Authentication Detail"));
        Assert.assertTrue(elExpiryDate.equals("Transaction Date"));
        Assert.assertTrue(elExpiryDateValue.equals(ConvertDate(Pending_Request.get("datetime").toString(),true,"EN")));
        Assert.assertTrue(elMessage.equals("Message"));
        Assert.assertTrue(elMessageDetail.equals(Pending_Request.get("request_message")));
    }
}
