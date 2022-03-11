package com.tmb.automation.test.customerservice.sprint21;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.platform1.WelcomeScreenPage;
import com.tmb.automation.util.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.util.Base.appiumDriver;

public class TC_ONEAPP_7014_EN extends Base {
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


        MobileElement TutorialNCB = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_title_tutorial_id']");
        String elTutorialNCB = TutorialNCB.getText();
        MobileElement DetailTutorial = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_desc_tutorial_id']");
        String elDetailTutorial = DetailTutorial.getText();
        MobileElement BtnStart = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='request_ncb_report_btn_start_tutorail_id']");
        String elBtnStart = BtnStart.getText();
        System.err.println("get element : " + elTutorialNCB);
        System.err.println("get element : " + elDetailTutorial);
        System.err.println("get element : " + elBtnStart);

        Assert.assertTrue(elTutorialNCB.equals("Request Credit Report"));
        Assert.assertTrue(elDetailTutorial.equals("Credit Report request you can easily do it yourself on ttb app.This is a service from ttb to give you convenient,has service fee 150 baht."));
        BtnStart.click();

    }
}
