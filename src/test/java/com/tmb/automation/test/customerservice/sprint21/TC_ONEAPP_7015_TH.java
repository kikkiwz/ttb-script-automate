package com.tmb.automation.test.customerservice.sprint21;


import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.util.Base;

public class TC_ONEAPP_7015_TH extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			ExtentListeners.setDriver(appiumDriverMobile);
		}

    @Test(priority = 1)
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']")));
        MobileElement btnNCB = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']"));
        btnNCB.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_title_tutorial_id']")));
        MobileElement BtnStart = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_btn_start_tutorail_id']");
        BtnStart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_select_send_title_label']")));
        MobileElement HeaderDeliveryScreen = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_select_send_title_label']"));
        String elHeaderDeliveryScreen = HeaderDeliveryScreen.getText();
        MobileElement ProcessRunning = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[1]"));
        String elProcessRunning = ProcessRunning.getText();

        MobileElement SelectDelivery = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView[2]");
        String elSelectDelivery = SelectDelivery.getText();
        MobileElement ByEmail = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView[1]");
        String elByEmail = ByEmail.getText();
        MobileElement PeriodByEmail = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView[2]");
        String elPeriodByEmail = PeriodByEmail.getText();
        MobileElement ByPost = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[1]");
        String elByPost = ByPost.getText();
        MobileElement PeriodByPost = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.TextView[2]");
        String elPeriodByPost = PeriodByPost.getText();
        MobileElement Note1 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.widget.ListView/android.view.View[1]/android.view.View[2]");
        String elNote1 = Note1.getText();
        MobileElement Note2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[5]/android.widget.ListView/android.view.View[2]/android.view.View[2]");
        String elNote2 = Note2.getText();
        System.err.println("get element : " + elHeaderDeliveryScreen);
        System.err.println("get element : " + elSelectDelivery);
        System.err.println("get element : " + elProcessRunning);
        System.err.println("get element : " + elByEmail);
        System.err.println("get element : " + elPeriodByEmail);
        System.err.println("get element : " + elByPost);
        System.err.println("get element : " + elPeriodByPost);
        System.err.println("get Note1 : " + Note1);
        System.err.println("get elNote2 : " + elNote2);

        Assert.assertTrue(elHeaderDeliveryScreen.equals("ขอรายงานข้อมูลเครติดบูโร"));
        Assert.assertTrue(elProcessRunning.equals("1 / 4"));
        Assert.assertTrue(elSelectDelivery.equals("เลือกวิธีรับเอกสาร"));
        Assert.assertTrue(elByEmail.equals("ทางอีเมล"));
        Assert.assertTrue(elPeriodByEmail.equals("ภายใน 24 ชม."));
        Assert.assertTrue(elByPost.equals("ทางไปรษณีย์"));
        Assert.assertTrue(elPeriodByPost.equals("7 วันทำการ"));
        Assert.assertTrue(elNote1.equals("มีค่าบริการ 150 บาท"));
        Assert.assertTrue(elNote2.equals("รายการคำขอหลัง 22:45 น. จะมีผลในวันทำการถัดไป"));

    }
}
