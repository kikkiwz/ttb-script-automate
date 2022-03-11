package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestPassbook2 {
    public AppiumDriver<WebElement> driver;
    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.1.48:5555");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\Aniwat\\Documents\\Lending\\1.0.0.402-dev.633.dev.apk");
        dc.setCapability(MobileCapabilityType.FULL_RESET, false);
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
//        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
//        dc.setCapability("browserName", "Chrome");
        dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE
                , System.getProperty("user.dir")+"/src/main/resources/chromedriver_92");

        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.ttbbank.oneapp.vit");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.ttbbank.oneapp.presentation.splash.SplashActivity");
        dc.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        dc.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);

        dc.setCapability(MobileCapabilityType.UDID, "192.168.1.48:5555");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.hideKeyboard();
    }
    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.ttbbank.oneapp.vit:id/ll_tap\"])[3]")).click();
        Thread.sleep(10000);
        System.out.println(driver.getContextHandles());
        driver.context("WEBVIEW_com.ttbbank.oneapp.vit");
        System.out.println(driver.getPageSource());
        System.out.println(driver.getTitle().toString());
        System.out.println(driver.findElement(By.xpath("//h3[text()=\"Passbook\"]")).getText());
        driver.findElement(By.xpath("//h3[text()=\"Passbook\"]")).click();
        Thread.sleep(1000);
        System.out.println(driver.getContextHandles());
        System.out.println(driver.getPageSource());
    }
}
