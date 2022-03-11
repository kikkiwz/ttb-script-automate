package com.tmb.automation.test.customerservice.sprint18;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class TC_ONEAPP_4521_EN extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		 ExtentListeners.setDriver(appiumDriverMobile);
	}

    @Test(priority = 0)
    public static void TC_ONEAPP_4521_EN_CSTTutorial_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));
        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
        btnCST.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='label_customerservice_case_tracking_title_tutorial']")));

        MobileElement TutorialTitle = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='label_customerservice_case_tracking_title_tutorial']");
        String elTutorialTitle = TutorialTitle.getText();
        MobileElement TutorialDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='label_customerservice_case_tracking_desc_tutorial']");
        String elTutorialDetail = TutorialDetail.getText();
        System.err.println("get TutorialTitle : " + elTutorialTitle);
        System.err.println("get element : " + elTutorialDetail);

        Assert.assertTrue(elTutorialTitle.equals("Complaint/Request Tracking"));
        Assert.assertTrue(elTutorialDetail.equals("Enable you to track status of your request and complaint anywhere anytime."));
    }

    @Test(priority = 1)
    public static void TC_ONEAPP_4521_EN_CSTTutorial_SIT_00002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        MobileElement btnStart = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='button_customerservice_case_tracking_start_tutorial']"));
        btnStart.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));

//        Assert.assertTrue(elTutorialTitle.equals("Complaint / Request Tracking"));
//        Assert.assertTrue(elTutorialDetail.equals("Enable you to track status of your request and complaint anywhere anytime."));
    }

    @Test(priority = 2)
    public static void TC_ONEAPP_4521_EN_CSTTutorial_SIT_00005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']")));


        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
        btnCST.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
//        childReport.pass("Actual result : The system should display Case Status Tracking screen." + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        Assert.assertTrue(elTutorialTitle.equals("Complaint / Request Tracking"));
//        Assert.assertTrue(elTutorialDetail.equals("Enable you to track status of your request and complaint anywhere anytime."));

    }
}
