package com.tmb.automation.test.it4it.sprint29.s18767;




import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.itextpdf.text.log.SysoCounter;
import com.mongodb.BasicDBObject;
import com.tmb.automation.common.MongoDB;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.LoginLogsModel;
import com.tmb.automation.pages.web.CCAdmin_CreateProductShortcut;
import com.tmb.automation.pages.web.CCAdmin_Editproductinfo;
import com.tmb.automation.pages.web.CCAdmin_GetAllPhrasesDashboard;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_ProductTermsandConditions;
import com.tmb.automation.pages.web.CCAdmin_phases;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.pages.web.CCAdmin_productinfo;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.Scrolling;

public class Link_KYC_review_web_address_mobile_number_ios_15969 extends Base {
	public static Scrolling scrolldown;
	public static WebDriverWait	wait;
	@Parameters({"DeviceProfile" })
	@BeforeMethod
	public void BeforeTest(String deviceProfile) throws MalformedURLException {
		Helper.CONFIG_PROFILE =deviceProfile;
		if(deviceProfile.contains("Saucelab")) {
		appiumDriver=Base.SaucelabandroidCapabilities();
		}
		else {		
		Base.startServer();
		Base.startEmulator();		
		appiumDriver=Base.appiumCapabilities();
		}
		ExtentListeners.setDriver(appiumDriver);
		
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		Base.driverQuit();
		Thread.sleep(2000);
		if(!Helper.CONFIG_PROFILE.contains("Saucelab")) {
		Base.stopEmulator();
		Base.stopServer();
		
		}
	}
	
	@Test
	public void Link_KYC_review_web_address_mobile_number_iOS() throws Exception {
		String deviceID="SauceLabios";
		scrolldown=new Scrolling();
		wait=new WebDriverWait(appiumDriver, 100);
		if(deviceID.equals("SauceLabAndroid")) {
	    System.out.println("SauceLab execution started on Android");	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip']"))).isDisplayed();				
		WebElement skipid=appiumDriver.findElement(By.xpath("(//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip'])"));
		skipid.click();
		System.out.println("Skip ID is clicked");
      	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='com.ttbbank.oneapp.vit:id/appCompatEditText']")));
		WebElement Enterid=appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.ttbbank.oneapp.vit:id/appCompatEditText']"));
		Enterid.sendKeys(Helper.getProperties(Helper.CONFIG_PROFILE+".DeviceID"));
		System.out.println("Device ID is entered");
		WebElement savedeviceID=appiumDriver.findElement(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/button_ok']"));
		savedeviceID.click();
		}
		else if(deviceID.equals("SauceLabios")) {
			System.out.println("SauceLab execution started on iOS");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Saucelabs\"]"))).isDisplayed();			
			WebElement SauceLabButton=appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Saucelabs\"]"));
			SauceLabButton.click();
			System.out.println("SauceLabButton is clicked");
			Thread.sleep(2000);
			WebElement Enterid=appiumDriver.findElement(By.xpath("//XCUIElementTypeAlert[@name=\"Designed for Saucelabs\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther"));
			System.out.println("The device id is---"+Helper.getProperties(Helper.CONFIG_PROFILE+".DeviceID"));
			Enterid.sendKeys(Helper.getProperties(Helper.CONFIG_PROFILE+".DeviceID"));
			WebElement savedeviceID=appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]"));
			savedeviceID.click();
			Thread.sleep(2000);
			appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Don’t Allow\"]")).click();
			skip_app_tutorial();
			
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"More\"]")));
		System.out.println("We Logged in successfully");
		WebElement more_button=appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"More\"]"));
		more_button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeOther[@name=\"Settings, Double tabs to see more details\"]")));
		WebElement Setting_button=appiumDriver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Settings, Double tabs to see more details\"]"));
		Setting_button.click();
		System.out.println("Pin tab is clicked");
		Enterpin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"094-846-0754\"]")));
		String ExistingMobileNumber=appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"094-846-0754\"]")).getText();
		System.out.println("The Existing mobile number is----"+ExistingMobileNumber);
		appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"094-846-0754\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"ตรวจสอบภายหลัง\"]")));
		Thread.sleep(2000);
		//appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"ตรวจสอบภายหลัง\"]")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"094-846-0754\"]")));
		//appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"094-846-0754\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"ตรวจสอบข้อมูลส่วนตัวของคุณ\"]")));
		WebElement confirmbutton=appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"ตรวจสอบข้อมูลส่วนตัวของคุณ\"]"));
		confirmbutton.click();
		//confirmbutton.click();
		System.out.println("Pin tab is clicked");
		Enterpin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"รายละเอียดทั้งหมด\"]")));
		scrolldown.ScrolltillElementintoDisplay("//XCUIElementTypeButton[@name=\"ยืนยันข้อมูลทั้งหมดถูกต้อง\"]");
		appiumDriver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"แก้ไข\"])[8]")).click();;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"แก้ไขรายละเอียด\"]")));
		appiumDriver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"เบอร์โทรศัพท์มือถือ\"]")).click();
		Thread.sleep(2000);
		appiumDriver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"เบอร์โทรศัพท์มือถือ\"]")).sendKeys("099-371-4030");
		Thread.sleep(1000);
		appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"แก้ไขรายละเอียด\"]")).click();
		Thread.sleep(1000);
		appiumDriver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"ปรับปรุงข้อมูล\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"ติดตามสถานะการสมัคร\"]")));
		appiumDriver.findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"One time password input\"])[1]")).sendKeys("1");
		appiumDriver.findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"One time password input\"])[2]")).sendKeys("2");
		appiumDriver.findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"One time password input\"])[3]")).sendKeys("3");
		appiumDriver.findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"One time password input\"])[4]")).sendKeys("4");
		appiumDriver.findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"One time password input\"])[5]")).sendKeys("5");
		appiumDriver.findElement(By.xpath("(//XCUIElementTypeTextField[@name=\"One time password input\"])[6]")).sendKeys("6");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"รหัส OTP ไม่ถูกต้อง ลองใหม่ได้อีก 2 ครั้ง\"]")));	
			
		
	}
public void Enterpin() {
	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Enter PIN\"]")));
		String Pin=appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Enter PIN\"]")).getText();
		System.out.println("The Text is " +Pin);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"0\"]")));
		appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"0\"]")).click();
		appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"1\"]")).click();
		appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"0\"]")).click();
		appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"2\"]")).click();
		appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"0\"]")).click();
		appiumDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"3\"]")).click();

	}

public void skip_app_tutorial() throws InterruptedException {

	Thread.sleep(2000);
	WebElement skip=appiumDriver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Dev_1.5.0.406-dev.453.Dev\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton"));
	Thread.sleep(2000);
	skip.click();
	Thread.sleep(2000);
	skip.click();
	Thread.sleep(2000);
	skip.click();
}

}