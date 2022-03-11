package com.tmb.automation.test.customerservice.sprint17;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.pages.customerservice.VirtualPassbook;
import com.tmb.automation.pages.platform2.LoginPage;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class Base {

    static public AndroidDriver<MobileElement> driver;

    public static String TakeScreen() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    public static void EnterPin() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_00']")));
        MobileElement pin01 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        pin01.click();
        MobileElement pin02 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_01"));
        pin02.click();
        MobileElement pin03 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        pin03.click();
        MobileElement pin04 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_02"));
        pin04.click();
        MobileElement pin05 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_00"));
        pin05.click();
        MobileElement pin06 = driver.findElement(By.id("com.ttbbank.oneapp.vit:id/key_03"));
        pin06.click();
    }

    public static void ConfirmPin() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 600);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_0']")));
        MobileElement pin01 = Base.driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        pin01.click();
        MobileElement pin02 = Base.driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_1"));
        pin02.click();
        MobileElement pin03 = Base.driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        pin03.click();
        MobileElement pin04 = Base.driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_2"));
        pin04.click();
        MobileElement pin05 = Base.driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_0"));
        pin05.click();
        MobileElement pin06 = Base.driver.findElement(By.id("com.ttbbank.oneapp.vit:id/pin_key_3"));
        pin06.click();
    }

    @Test(priority = 0)
    public static void OpenOneApp() throws Exception {
    	String profile="SaucelabAndroid2.";
    	
//    	DesiredCapabilities caps=new DesiredCapabilities();
//   		caps.setCapability("username",Helper.getProperties(profile + "username"));
//   		caps.setCapability("accessKey", Helper.getProperties(profile + "accessKey"));
//   		caps.setCapability("platformName", Helper.getProperties(profile + "platformName"));
//   		caps.setCapability("deviceName",Helper.getProperties(profile + "deviceName"));
//   		//caps.setCapability("name",Helper.getProperties(profile + "name"));
//   		caps.setCapability("name","");
//   		caps.setCapability("Record", true);
//   		caps.setCapability("platformVersion", Helper.getProperties(profile + "platformVersion"));
//   		caps.setCapability(CapabilityType.BROWSER_NAME, "");
//   		caps.setCapability("app",Helper.getProperties(profile + "app"));
//   		caps.setCapability("deviceOrientation", Helper.getProperties(profile + "deviceOrientation"));
//   		caps.setCapability("appiumVersion",Helper.getProperties(profile + "appiumVersion"));
//   		try {
//   			driver=new AndroidDriver<MobileElement>(new URL("http://ondemand.us-west-1.saucelabs.com/wd/hub"),caps);
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        WebDriverWait wait = new WebDriverWait(driver, 90);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip']"))).isDisplayed();			
//		WebElement skipid=driver.findElement(By.xpath("(//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip'])"));
//		skipid.click();
//		System.out.println("Skip ID is clicked");
//      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='com.ttbbank.oneapp.vit:id/appCompatEditText']")));
//		WebElement Enterid=driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.ttbbank.oneapp.vit:id/appCompatEditText']"));
//		Enterid.sendKeys(Helper.getProperties(profile+"DeviceID"));
//		System.out.println("Device ID is entered");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		WebElement savedeviceID=driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/button_ok']"));
//		savedeviceID.click();
		
        Thread.sleep(20000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/skipIntro']")));
//        driver.findElement(By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/skipIntro']")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/quick_action_button_ic']")));
       MobileElement discover = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout"));
        discover.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/skipIntro']")));
//        driver.findElement(By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/skipIntro']")).click();
       // EnterPin();
    }

    @Test
    public static void OpenService() throws Exception {
        OpenOneApp();
        WebDriverWait wait = new WebDriverWait(Base.driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='00']")));
        System.err.println("pass");
        Thread.sleep(2000);
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        scrollUPANDDOWN(0.5, 0.4, 0.5, 0.1); // down
        MobileElement service = driver.findElement(By.xpath("//*[@resource-id='2020']"));
        service.click();
    }


    public static void OpenOtherASTEntryPoint() throws Exception {
        OpenOneApp();
        Thread.sleep(7000);
        scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        MobileElement ApplicationTrackingFlowTutorial = driver.findElement(By.xpath("//*[@resource-id='1616']"));
        ApplicationTrackingFlowTutorial.click();
    }

//    @Test(priority = 1)
//    public void TS_ONEAPP_2711_VPOneAcct_SIT_00005() throws Exception, ParseException {
//        OpenOneApp();
//        MobileElement selectAccount = driver.findElement(By.xpath("//*[@resource-id='0']"));
//        selectAccount.click();
//        Thread.sleep(1000);
//        MobileElement View = driver.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
//        View.click();
//        Thread.sleep(50000);
//        MobileElement AccountName = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]");
//        String elAccountName = AccountName.getText();
//        System.err.println("get element : " + elAccountName);
////        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        MobileElement AccountNumber = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[7]");
//        String elAccountNumber = AccountNumber.getText();
//        System.err.println("get element : " + elAccountNumber);
//        MobileElement BranchName = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[10]");
//        String elBranchName = BranchName.getText();
//        System.err.println("get element : " + elBranchName);
//        MobileElement ProductName = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]");
//        String elProductName = ProductName.getText();
//        System.err.println("get element : " + elProductName);
//        MobileElement Note = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[12]");
//        String elNote = Note.getText();
//        System.err.println("get element : " + elNote);
//        MobileElement textInNote = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[13]");
//        String eltextInNote = textInNote.getText();
//        System.err.println("get element : " + eltextInNote);
//        MobileElement textInNote2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[14]");
//        String eltextInNote2 = textInNote2.getText();
//        System.err.println("get element : " + eltextInNote2);
//        System.err.println("Application Started....");
//        if(true){
//            parentReport = extent.createTest("test case1", "test case1");
//        }
//        childReport = parentReport.createNode("test case1");
//        childReport.log(Status.INFO, "<pre> actual result :" + TextColor.blueColor(elAccountName) + "</br>" + TextColor.blueColor(elAccountNumber) + TextColor.blueColor(elBranchName) + "</pre>");
//        childReport.log(Status.INFO, "<pre> Expected Result : The system should display Virtual Passbook Screen Details as below:\n" +
//                "1. Display Back icon\n" +
//                "2. Display Title: \"E-Passbook\" (EN), \"หน้าสมุดบัญชี\" (TH)\n" +
//                "3. Display Picture book bank\n" +
//                "4. Display Product name correctly\n" +
//                "5. Display Account Name correctly\n" +
//                "6. Display Account Number in format 123-1-12345-1\n" +
//                "7. Display Branch Name in Thai only\n" +
//                "8. Display Text Description correctly\n" +
//                "9. Display PDF Button: \"PDF File\" (EN),  \"ไฟล์ PDF\" (TH)\n" +
//                "10. Display Image Button: \"Image\" (EN), \"ไฟล์ภาพ\" (TH)\n" +
//                "11. Display Home Button</pre>");
//
//        childReport.pass(Setting.KEY_REPORT_VISIT_PAGE+ TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(TakeScreen()).build());
//
//        Assert.assertTrue(elAccountNumber.equals("001-3-64385-3"));
//        Assert.assertTrue(elAccountName.equals("นาย ฟาติเมาะห์ เซาะตีงู"));
//        Assert.assertTrue(elBranchName.equals("พหลโยธิน"));
//        Assert.assertTrue(elProductName.equals("บัญชีฝากประจำทั่วไป 6 เดือน"));
//        Assert.assertTrue(elNote.equals("หมายเหตุ:"));
//        Assert.assertTrue(eltextInNote.equals("- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์ (E-Passbook)นี้ ใช้เพื่อแสดงหมายเลขบัญชี สาขา และ ชื่อเจ้าของบัญชีเงินฝาก จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
//        Assert.assertTrue(eltextInNote2.equals("- เพื่อความถูกต้องของการทำรายการ โปรดตรวจสอบชื่อเจ้าของบัญชีที่แสดงในระบบระหว่างการทำธุรกรรมทางการเงินทุกครั้ง"));
//
//    }


    public static void scrollLeftAndRight(int start_x, int start_y, int end_x, int end_y) throws Exception {
        Dimension dim = Base.driver.manage().window().getSize();

        TouchAction ts = new TouchAction(Base.driver);
        ts.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x, end_y)).release().perform();
//        ts.press(PointOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, bottom_y)).release().perform();
        Thread.sleep(3000);
    }
}
