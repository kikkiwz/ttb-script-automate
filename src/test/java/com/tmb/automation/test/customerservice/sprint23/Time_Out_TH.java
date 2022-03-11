package com.tmb.automation.test.customerservice.sprint23;

import com.tmb.automation.api.customerservice.ViewVirtualPassbook;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.util.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static com.tmb.automation.api.customerservice.sprint21.NdidEligibile.NdidEligibile;
import static com.tmb.automation.api.customerservice.sprint21.NdidUserData.NdidUserData;
import static com.tmb.automation.test.customerservice.sprint17.Base.ConfirmPin;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class Time_Out_TH extends Base{
    JSONObject JsonDataNdidEligibile = null;
    JSONObject JsonDataNdidUserData = null;
    @Parameters({"DeviceProfile" })
   	@BeforeClass
   	public void BeforeTest(String deviceProfile) {
   		Helper.CONFIG_PROFILE = deviceProfile;		
   		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
   		ExtentListeners.setDriver(appiumDriverMobile);
   	}
    //    JSONObject JsonDataBiometricConsent = null;
    @BeforeTest
    public void servoice() throws Exception {
        String AccessToken = ViewVirtualPassbook.GetAccessToken("DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
        JSONObject NdidEligibile = (JSONObject) new JSONParser().parse(NdidEligibile(AccessToken));
        JsonDataNdidEligibile =  (JSONObject)NdidEligibile.get("data");
        JSONObject NdidUserData = (JSONObject) new JSONParser().parse(NdidUserData(AccessToken));
        JsonDataNdidUserData =  (JSONObject)NdidUserData.get("data");
    }

    @org.testng.annotations.Test(priority = 1)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01004() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']")));
        MobileElement NDID = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ndid_service']"));
        NDID.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_list_navbar_title_id']")));
        MobileElement PendingRequest = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='pending_request_title_0']"));
        PendingRequest.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_navigation_pending_detail_icon_id']")));
        MobileElement BtnProceed = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_detail_button_process_id']"));
        BtnProceed.click();
        JSONArray Arr_Pending_Request =  (JSONArray)JsonDataNdidEligibile.get("pending_request");
        JSONObject Pending_Request = (JSONObject) Arr_Pending_Request.get(0);
        String Expiry_date = Pending_Request.get("expire_date").toString();
        String date_format = Expiry_date + ":00Z";
        Instant expectedValue = Instant.parse(date_format);
        String Expected_date = expectedValue.plus(1, ChronoUnit.MINUTES).toString();
        System.err.println("time : " + Expected_date);

        for (int i = 0; i < 100000;i++){
            Thread.sleep(1000);
            DateTimeFormatter date_nows = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            DateTimeFormatter Time_nows = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
            LocalDateTime nows = LocalDateTime.now();
            String Date_times = date_nows.format(nows) + "T" + Time_nows.format(nows) + "Z";
            System.err.println(Date_times);
            if(Expected_date.equals(Date_times)){
                scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
                scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // Down
                TouchAction clickMore = new TouchAction(appiumDriverMobile);
                Thread.sleep(2000);
                clickMore.tap(PointOption.point(500,2060)).perform();
                ConfirmPin();
                break;
            }
        }
    }

    @Test(priority = 2)
    public void TC_ONEAPP_8852_NDID_EN_REQ_SIT_01005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']")));
        MobileElement TitleTimeout = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_title_id']"));
        String elTitleTimeout =  TitleTimeout.getText();
        MobileElement TimeoutDetail = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_label_desc_id']"));
        String elTimeoutDetail =  TimeoutDetail.getText().replace("\n"," ");
        MobileElement TransactionTimeout = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[3]"));
        String elTransactionTimeout =  TransactionTimeout.getText();
        MobileElement BtnBackToMianMenu = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='ndid_pending_result_button_next_id']"));
        String elBtnBackToMianMenu =  BtnBackToMianMenu.getText();
        System.err.println("elTitleTimeout : " + elTitleTimeout);
        System.err.println("elTimeoutDetail : " + elTimeoutDetail);
        System.err.println("elTransactionTimeout : " + elTransactionTimeout);
        System.err.println("elBtnBackToMianMenu : " + elBtnBackToMianMenu);

        DateTimeFormatter year_en = DateTimeFormatter.ofPattern("yyyy", new Locale("th", "TH"));
        DateTimeFormatter date_th = DateTimeFormatter.ofPattern("dd MMM ", new Locale("th", "TH"));
        LocalDateTime now = LocalDateTime.now();
        int YearTH = Integer.parseInt(year_en.format(now)) + 543;
        String strYear = String.valueOf(YearTH).substring(2,4);
        String DateTH = date_th.format(now) + strYear;
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm น.");
        Assert.assertTrue(elTitleTimeout.equals("คำขอยืนยันตัวตนหมดอายุ"));
        Assert.assertTrue(elTimeoutDetail.equals("คุณไม่ได้ทำรายการภายในเวลาที่กำหนด กรุณาทำรายการขอยืนยันตัวตนใหม่ กับธนาคารต้นทาง"));
        Assert.assertTrue(elTransactionTimeout.substring(0, elTransactionTimeout.length() - 8).equals("วันที่ดำเนินการ" + DateTH + ", " + time.format(now) + "หมายเลขอ้างอิง"));
        Assert.assertTrue(elBtnBackToMianMenu.equals("กลับหน้าหลัก"));
    }
}
