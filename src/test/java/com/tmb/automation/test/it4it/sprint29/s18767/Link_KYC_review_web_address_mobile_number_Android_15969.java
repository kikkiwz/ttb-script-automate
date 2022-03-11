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
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
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

import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class Link_KYC_review_web_address_mobile_number_Android_15969 extends Base {
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
		Base.driverWebElementQuit();
		Thread.sleep(2000);
		
		if(!Helper.CONFIG_PROFILE.contains("Saucelab")) {
			Base.stopEmulator();
			Base.stopServer();
			
			}
		
		
	}
	
	@Test
	public void Link_KYC_review_web_address_mobile_number_Android() throws Exception {
		String deviceID="SauceLab1";
		scrolldown=new Scrolling();
		wait=new WebDriverWait(appiumDriver, 100);
		if(deviceID.equals("SauceLab")) {
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
		skip_app_tutorial();
		}
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[3]")));
		System.out.println("We Logged in successfully");
		Thread.sleep(5000);
		WebElement more_button=appiumDriver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[3]"));
		more_button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']")));
		WebElement Setting_button=appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']"));
		Setting_button.click();
		appiumDriver.closeApp();
		appiumDriver.launchApp();
		System.out.println("Pin tab is clicked");
		Enterpin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuDetail'])[1]")));
		String ExistingMobileNumber=appiumDriver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuDetail'])[1]")).getText();
		System.out.println("The Existing mobile number is----"+ExistingMobileNumber);
		appiumDriver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='ตรวจสอบข้อมูลส่วนตัวของคุณ']")));
		Thread.sleep(2000);
		appiumDriver.findElement(By.xpath("//android.widget.Button[@text='ตรวจสอบภายหลัง']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuDetail'])[1]")));
		appiumDriver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon'])[1]")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='ตรวจสอบข้อมูลส่วนตัวของคุณ']")));
		WebElement confirmbutton=appiumDriver.findElement(By.xpath("//android.widget.Button[@text='ตรวจสอบข้อมูลส่วนตัวของคุณ']"));
		confirmbutton.click();
		System.out.println("Pin tab is clicked");
		Enterpin_Kyc();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='รายละเอียดทั้งหมด']")));
		scrolldown.ScrolltillElementintoDisplay("//android.widget.Button[@text='ยืนยันข้อมูลทั้งหมดถูกต้อง']");
		List<WebElement> Editbuttons=appiumDriver.findElements(By.xpath("(//android.widget.Button[@text='แก้ไข'])[3]"));
		int size=Editbuttons.size();
		System.out.println("The size is ---"+size);
		Editbuttons.get(size-1).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='phone']")));
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='phone']")).click();
		Thread.sleep(2000);
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='phone']")).sendKeys("099-371-4030");
		Thread.sleep(3000);
		appiumDriver.findElement(By.xpath("//android.widget.Button[@text='ปรับปรุงข้อมูล']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='ติดตามสถานะการสมัคร']")));
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='ngx-otp-input-0']")).sendKeys("1");
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='ngx-otp-input-1']")).sendKeys("2");
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='ngx-otp-input-2']")).sendKeys("3");
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='ngx-otp-input-3']")).sendKeys("4");
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='ngx-otp-input-4']")).sendKeys("5");
		appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='ngx-otp-input-5']")).sendKeys("6");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='รหัส OTP ไม่ถูกต้อง ลองใหม่ได้อีก 2 ครั้ง']")));
//		appiumDriver.navigate().back();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuDetail'])[1]")));
//		String FinalMobileNumber=appiumDriver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuDetail'])[1]")).getText();
//		System.out.println("The Final mobile number is----"+FinalMobileNumber);
//		Assert.assertEquals(ExistingMobileNumber, FinalMobileNumber);
		
	
	}
public void Enterpin() {
	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/title_pin")));
		String Pin=appiumDriver.findElement(By.id("com.ttbbank.oneapp.vit:id/title_pin")).getText();
		System.out.println("The Text is " +Pin);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/key_00']")));
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/key_00']")).click();
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/key_01']")).click();
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/key_00']")).click();
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/key_02']")).click();
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/key_00']")).click();
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/key_03']")).click();

	}

public void Enterpin_Kyc() {
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/title_pin")));
	String Pin=appiumDriver.findElement(By.id("com.ttbbank.oneapp.vit:id/title_pin")).getText();
	System.out.println("The Text is " +Pin);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_0']")));
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_0']")).click();
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_1']")).click();
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_0']")).click();
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_2']")).click();
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_0']")).click();
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_3']")).click();

}

public void skip_app_tutorial() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Next']")));
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Next']")));
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Done']")));
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
}

}