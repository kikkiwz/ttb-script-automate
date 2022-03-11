package com.tmb.automation.investment;


import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.investment.HomePage;
import com.tmb.automation.pages.investment.PinPage;
import com.tmb.automation.util.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import scala.App;

import java.io.IOException;
import java.util.Properties;

public class HomeTest extends Base  {
//static AppiumDriver<MobileElement> appiumDriverMobile;
public static WebDriverWait wait; 
    
    @Parameters({"DeviceProfile" })
    @BeforeTest
    public void Setup(String deviceProfile) {
        Helper.CONFIG_PROFILE = deviceProfile;
        appiumDriverMobile= Base.appiumCapabilitiesMobileElement();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ExtentListeners.setDriver(appiumDriverMobile);
        wait = new WebDriverWait(appiumDriverMobile, 60);
//       
    }

    @AfterTest
    public void teardown() {
        Base.driverQuit();
    }
 

    @Test(priority = 1)
    public void validateHomePage() throws InterruptedException, IOException {
        HomePage page = new HomePage(appiumDriverMobile);
        if (Helper.CONFIG_PROFILE.contains("Android")) {
            wait.until(ExpectedConditions.visibilityOf(page.tutorial));
            page.tutorial.click();
        }
        
        page.serviceTab.click();

        if (Helper.CONFIG_PROFILE.contains("Android")) {
            wait.until(ExpectedConditions.visibilityOf(page.tutorial));
            page.tutorial.click();
        }


//        PinPage pinPage = new PinPage(appiumDriverMobile);
//        wait.until(ExpectedConditions.visibilityOfAllElements(pinPage.number0Btn));
//        pinPage.number0Btn.click();
//        pinPage.number1Btn.click();
//        pinPage.number0Btn.click();
//        pinPage.number2Btn.click();
//        pinPage.number0Btn.click();
//        pinPage.number3Btn.click();

       
    }
}
