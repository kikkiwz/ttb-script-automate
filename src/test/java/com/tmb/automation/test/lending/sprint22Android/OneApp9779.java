package com.tmb.automation.test.lending.sprint22Android;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.parser.ParseException;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import com.tmb.automation.helper.Setting;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.util.TextColor;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.charset.StandardCharsets;

import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.aventstack.extentreports.MediaEntityBuilder;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class OneApp9779 extends Base {
    static AppiumDriver<MobileElement> driver;
    
    @Parameters({"DeviceProfile" })
    @BeforeMethod 
    public void BeforeTest(String deviceProfile) {
        Helper.CONFIG_PROFILE = deviceProfile;
        driver= Base.appiumCapabilitiesMobileElement();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ExtentListeners.setDriver(driver);
    }

    @AfterMethod
    public void teardown() {
        Base.driverQuit();
    }
 

  
    @Test
    public static void CreditCard() throws Exception, ParseException {
       

        System.err.println("Application Started....");

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[2]")));

        // Click to Account page
        MobileElement discover = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id=\'com.ttbbank.oneapp.vit:id/ll_tap\'])[2]"));
        discover.click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

     // Click via PIN
        MobileElement pin01 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        Log.logger.debug(pin01);
        pin01.click();
        Thread.sleep(500);
        MobileElement pin02 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_01"));
        Log.logger.debug(pin02);
        pin02.click();
        Thread.sleep(500);
        MobileElement pin03 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        Log.logger.debug(pin03);
        pin03.click();
        Thread.sleep(500);
        MobileElement pin04 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_02"));
        Log.logger.debug(pin04);
        pin04.click();
        Thread.sleep(500);
        MobileElement pin05 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        Log.logger.debug(pin05);
        pin05.click();
        Thread.sleep(500);
        MobileElement pin06 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_03"));
        Log.logger.debug(pin06);
        pin06.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/appCompatTextView")));
        // Click on Card Account Summary
        System.err.println("Click Card on My Account Summary");
        MobileElement as = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Card\"]"));
        Log.logger.debug(as);
        as.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"ABSOLUTE Visa Infinite Credit Card\"]/android.view.ViewGroup")));

        // get text
        System.out.println("Get Account ID");
        MobileElement accID = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"470680XXXXXX0960\"]"));
        String getAccID = accID.getText();


        // Click Card image
        System.out.println("Click on Card image");
        MobileElement bl = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"ABSOLUTE Visa Infinite Credit Card\"]/android.view.ViewGroup"));
        Log.logger.debug(bl);
        bl.click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]")));

        // Get API Service to check Product ID and Account Status
        String[] result = getProductLanding.getProductLandingList(getAccID.substring(getAccID.length() - 4));
        System.out.println(result[0] + " : " + result[1] + " : " + result[2]);

        // Click More
        System.out.println("Click More Action");
        TouchAction clickMore = new TouchAction(driver);
        Thread.sleep(2000);
        clickMore.tap(PointOption.point(798, 1143)).perform();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[1]/android.view.View[2]")));

        MobileElement mainFeature = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[1]"));
        String getMainFeature = mainFeature.getText();
        System.out.println(getMainFeature);

        MobileElement manageCard = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]"));
        String getManage = manageCard.getText();
        System.out.println(getManage);

        MobileElement redem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[1]/android.view.View[2]"));
        String getRedem = redem.getText();
        System.out.println(getRedem);

        MobileElement cash = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[2]/android.view.View[2]"));
        String getCash = cash.getText();
        System.out.println(getCash);

        MobileElement applyS = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[3]/android.view.View[2]"));
        String getApply = applyS.getText();
        System.out.println(getApply);

        MobileElement cardDetail = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[1]/android.view.View[4]/android.view.View[2]"));
        String getCardDetail = cardDetail.getText();
        System.out.println(getCardDetail);

        MobileElement billP = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[2]/android.view.View[1]/android.view.View[2]"));
        String getBillPay = billP.getText();
        System.out.println(getBillPay);

        MobileElement topUp = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[2]/android.view.View[2]/android.view.View[2]"));
        String getTopUp = topUp.getText();
        System.out.println(getTopUp);

        MobileElement payBill = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[2]/android.view.View[3]/android.view.View[2]"));
        String getPayBill = payBill.getText();
        System.out.println(getPayBill);

        MobileElement adjust = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[3]/android.view.View[1]/android.view.View"));
        String getAdjust = adjust.getText();
        System.out.println(getAdjust);

        MobileElement eState = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[3]/android.view.View[2]/android.view.View"));
        String geteState = eState.getText();
        System.out.println(geteState);

        MobileElement setPin = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[3]/android.view.View[3]/android.view.View"));
        String getSetPin = setPin.getText();
        System.out.println(getSetPin);

        MobileElement blockCard = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.ListView[3]/android.view.View[4]/android.view.View"));
        String getBlockCard = blockCard.getText();
        System.out.println(getBlockCard);

        // Validate the button based on product

       
        Assert.assertTrue(getMainFeature.equals("Main Features"));
        Assert.assertTrue(getRedem.equals("Redeem point"));
        Assert.assertTrue(getCash.equals("Cash for you"));
        Assert.assertTrue(getApply.equals("Apply So GooOD"));
        Assert.assertTrue(getCardDetail.equals("Card details"));
        Assert.assertTrue(getBillPay.equals("Bill payment"));
        Assert.assertTrue(getTopUp.equals("Top-up"));
        Assert.assertTrue(getPayBill.equals("Pay bill"));
        Assert.assertTrue(getManage.equals("Manage Card"));
        Assert.assertTrue(getAdjust.equals("Adjust usage limit"));
        Assert.assertTrue(geteState.equals("Apply e-statement"));
        Assert.assertTrue(getSetPin.equals("Set pin"));
        Assert.assertTrue(getBlockCard.equals("Block card"));


        System.err.println("Application End.");
    }
}