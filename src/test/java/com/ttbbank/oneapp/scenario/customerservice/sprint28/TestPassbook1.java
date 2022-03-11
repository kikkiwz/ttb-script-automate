package com.ttbbank.oneapp.scenario.customerservice.sprint28;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestPassbook1 {
    public AppiumDriver<WebElement> driver;
    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.1.48:5555");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        dc.setCapability(MobileCapabilityType.APP, "/Users/oneapp-qa/Documents/TcsDrive/oneapp_build_simulator/ios/OneApp.app");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ttbbank.oneapp.vit");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ttbbank.oneapp.presentation.splash.SplashActivity");
        dc.setCapability(MobileCapabilityType.FULL_RESET, false);
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
//        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.ttbbank.oneapp.vit");
        dc.setCapability(MobileCapabilityType.UDID, "192.168.1.48:5555");
        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(35000);
        driver.findElement(By.id("com.ttbbank.oneapp.vit:id/ll_tap")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("0")).click();
        driver.findElement(By.id("1")).click();
        driver.findElement(By.id("0")).click();
        driver.findElement(By.id("2")).click();
        driver.findElement(By.id("0")).click();
        driver.findElement(By.id("3")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@text=\"Service\"]")).click();
        Thread.sleep(10000);
        driver.findElement(MobileBy.AccessibilityId("Passbook")).click();
        Thread.sleep(3000);
        System.out.println(driver.getContextHandles().size());
        Thread.sleep(2000);
        System.out.println(driver.getContextHandles().size());
//        Thread.sleep(2000);
//        System.out.println(driver.getContextHandles().size());
        System.out.println(driver.getContextHandles());
        System.out.println(driver.getPageSource());
        driver.context(new ArrayList<>(driver.getContextHandles()).get(1));
        System.out.println(driver.getPageSource());
        Thread.sleep(2000);
        driver.findElement(By.id("passbook-detail-button-gen-image")).click();
        System.out.println("==========="+driver.findElement(By.id("passbook-detail-button-gen-image")).getText());
        Thread.sleep(2000);
        System.out.println(driver.getPageSource());

    }
}
