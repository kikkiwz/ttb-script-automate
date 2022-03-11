package com.tmb.automation.test.customerservice.sprint21;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class TC_ONEAPP_7016_EN extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			ExtentListeners.setDriver(appiumDriverMobile);
		}


    @Test(priority = 0)
    public void TS_ONEAPP_4514_EN_ASTTutorial_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']")));
        MobileElement btnNCB = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service_screen_button_request_ncb_report']"));
        btnNCB.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_title_tutorial_id']")));
        MobileElement BtnStart = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_btn_start_tutorail_id']");
        BtnStart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='request_ncb_report_select_send_title_label']")));
        MobileElement SelectByPost = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View"));
        SelectByPost.click();
        Thread.sleep(5000);
        MobileElement Next = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='request_ncb_report_selected_send_button_next']"));
        Next.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='popup-title'']")));
        MobileElement popupTitle = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='popup-title']");
        String elpopupTitle = popupTitle.getText();
        MobileElement popup_handle_message_label = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_selected_send_popup_handle_message_label']");
        String elpopup_handle_message_label = popup_handle_message_label.getText();
        MobileElement email = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]");
        String elemail = email.getText();
        MobileElement BtnVerifyEmail = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.Button[1]");
        String elBtnVerifyEmail = BtnVerifyEmail.getText();
        MobileElement BtnEditEmail = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.Button[2]");
        String elBtnEditEmail = BtnEditEmail.getText();
        System.err.println("elpopupTitle : " + elpopupTitle);
        System.err.println("elpopup_handle_message_label : " + elpopup_handle_message_label);
        System.err.println("elemail : " + elemail);
        System.err.println("elBtnVerifyEmail : " + elBtnVerifyEmail);
        System.err.println("elBtnEditEmail : " + elBtnEditEmail);


       
        Assert.assertTrue(elpopupTitle.equals("You haven’t verified e-mail"));
        Assert.assertTrue(elpopup_handle_message_label.equals("Your e-mail"));
        Assert.assertTrue(elemail.equals("522300@TMBBANK.COM"));
        Assert.assertTrue(elBtnVerifyEmail.equals("Verify e-mail"));
        Assert.assertTrue(elBtnEditEmail.equals("Edit e-mail"));


    }
}
