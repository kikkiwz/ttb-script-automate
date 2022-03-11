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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.tmb.automation.api.customerservice.sprint21.NdidEligibile.NdidEligibile;
import static com.tmb.automation.test.customerservice.sprint17.Base.ConfirmPin;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class No_DataRequest_TH extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			ExtentListeners.setDriver(appiumDriverMobile);
		}
    JSONObject JsonDataNdidEligibile = null;
    JSONObject Pending_Request = null;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_header_pending_request_id']")));
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_3']"));
        PendingRequest.click();

       
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        Thread.sleep(1000);
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


        DateTimeFormatter year_en = DateTimeFormatter.ofPattern("yyyy", new Locale("th", "TH"));
        DateTimeFormatter date_th = DateTimeFormatter.ofPattern("dd MMM ", new Locale("th", "TH"));
        LocalDateTime now = LocalDateTime.now();
        int YearTH = Integer.parseInt(year_en.format(now)) + 543;
        String strYear = String.valueOf(YearTH).substring(2,4);
        String DateTH = date_th.format(now) + strYear;
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm น.");
        System.err.println("DateTimeNow : " + "วันที่ดำเนินการ" + DateTH + ", " + time.format(now) + "หมายเลขอ้างอิง");
        System.err.println("asd " + elTransaction.substring(0, elTransaction.length() - 8));
        Assert.assertTrue(elTitleSuccessful.equals("ยืนยันตัวตนสำเร็จ"));
        Assert.assertTrue(elTitleDescription.equals("ttb ได้ส่งรายละเอียดการยืนยันตัวตน ของคุณเรียบร้อยแล้วกรุณาดำเนินการต่อ ที่ธนาคารต้นทาง ที่คุณยื่นคำขอ"));
        Assert.assertTrue(elTransaction.substring(0, elTransaction.length() - 8).equals("วันที่ดำเนินการ" + DateTH + ", " + time.format(now) + "หมายเลขอ้างอิง"));
        Assert.assertTrue(elBtnBackToMainMenu.equals("กลับหน้าหลัก"));
        BtnBackToMainMenu.click();
    }


    @org.testng.annotations.Test(priority = 10)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01011() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
//        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // Down
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
//        appiumDriverMobile.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Transaction date\").instance(0))");

        String AccessToken = ViewVirtualPassbook.GetAccessToken("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
        JSONObject NdidEligibile = (JSONObject) new JSONParser().parse(NdidEligibile(AccessToken));
        JsonDataNdidEligibile = (JSONObject)NdidEligibile.get("data");
        JSONArray Arr_Pending_Request = (JSONArray)JsonDataNdidEligibile.get("request_history");
        Pending_Request = (JSONObject) Arr_Pending_Request.get(0);

        DateTimeFormatter year_en = DateTimeFormatter.ofPattern("yyyy", new Locale("th", "TH"));
        DateTimeFormatter date_th = DateTimeFormatter.ofPattern("dd MMM ", new Locale("th", "TH"));
        LocalDateTime now = LocalDateTime.now();
        int YearTH = Integer.parseInt(year_en.format(now)) + 543;
        String strYear = String.valueOf(YearTH).substring(2,4);
        String DateTH = date_th.format(now) + strYear;
        Assert.assertTrue(elCardHead_History.equals(Pending_Request.get("provider")));
        Assert.assertTrue(elTransaction_Date.equals("วันดำเนินการ"));
        Assert.assertTrue(elTranDate.equals(DateTH));
        Assert.assertTrue(elStatusHistory.equals("ยืนยันตัวตนสำเร็จ"));
        CardHead_History.click();
        TC_ONEAPP_8852_NDID_EN_REQ_SIT_01012();
    }

    @Test(priority = 11)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01012() throws Exception {
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


    
       
        System.err.println("1 : " + ConvertDate(Pending_Request.get("datetime").toString(),true,"TH"));

        Assert.assertTrue(elTMBAuthen.equals("คำขอยืนยันตัวตน tmb"));
        Assert.assertTrue(elAuthenDetail.equals("รายละเอียดคำขอยืนยันตัวตน"));
        Assert.assertTrue(elExpiryDate.equals("วันดำเนินการ"));
        Assert.assertTrue(elExpiryDateValue.equals(ConvertDate(Pending_Request.get("datetime").toString(),true,"TH")));
        Assert.assertTrue(elMessage.equals("ข้อความ"));
        Assert.assertTrue(elMessageDetail.equals(Pending_Request.get("request_message")));
    }
}
