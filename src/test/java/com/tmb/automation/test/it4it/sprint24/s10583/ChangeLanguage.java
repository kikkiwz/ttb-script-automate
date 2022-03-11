package com.tmb.automation.test.it4it.sprint24.s10583;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.Scrolling;

public class ChangeLanguage extends Base {
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
		//Base.stopEmulator();
		//Base.stopServer();
		
		
	}
	
	@Test
	public void ChangeLanguages() throws Exception {
		String deviceID="true";
		scrolldown=new Scrolling();
		wait=new WebDriverWait(appiumDriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip']"))).isDisplayed();
		if(deviceID.equals("true")) {				
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
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[3]")));
		System.out.println("We Logged in successfully");
		String titletext=appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/subTitleTextView']")).getText();
		if(titletext.contains("ยินดีต้อนรับเข้าสู่ TTB Touch")) {
			System.out.println("Changing Thai to English language");
			ThaitoEng();
			Thread.sleep(5000);
			System.out.println("Changing back from English to thai language");
			EngToThai();
			
		}
		else {
			System.out.println("Changing English to thai change language");
			EngToThai();
			Thread.sleep(5000);
			System.out.println("Changing back from Thai to English language");
			ThaitoEng();
			
		}
		
	}
		
		
		
		
		
	
	
	
	public void EngToThai() {
		
		WebElement more_button=appiumDriver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[3]"));
		more_button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']")));
		WebElement Setting_button=appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']"));
		Setting_button.click();
		System.out.println("Pin tab is clicked");
		Enterpin("English");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Settings']")));
		scrolldown.ScrolltillElementintoDisplay("//android.widget.TextView[@text='Language']");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='English']")).isDisplayed(),"The default language selected is english");
		WebElement Language_button=appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Language']"));
		Language_button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Select your application language']")));	
		WebElement Language_English=appiumDriver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.ttbbank.oneapp.vit:id/radio_english']"));
		String checked=Language_English.getAttribute("checked");
		Assert.assertEquals(checked, "true");
		WebElement Language_thai=appiumDriver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.ttbbank.oneapp.vit:id/radio_thai']"));
		Language_thai.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ภาษา']")));
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='กรุณาเลือกภาษาสำหรับแอปพลิเคชัน']")));
		appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.ttbbank.oneapp.vit:id/change_language_back_button']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ภาษาไทย']")));
		appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingIconBack']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']")));
		scrolldown.ScrolltillElementintoDisplay("//android.widget.LinearLayout[@resource-id='com.ttbbank.oneapp.vit:id/logoutMenu']");	
		appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.ttbbank.oneapp.vit:id/logoutMenu']")).click();
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/full_width_primary_btn']")).click();
		System.out.println("logged out successfully--");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/subTitleTextView']")));
		String titletext=appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/subTitleTextView']")).getText();
		Assert.assertTrue(titletext.contains("ยินดีต้อนรับเข้าสู่ TTB Touch"),"Language changed to thai");
	}
public void ThaitoEng() {
	WebElement more_button=appiumDriver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[3]"));
	more_button.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']")));
	WebElement Setting_button=appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']"));
	Setting_button.click();
	System.out.println("Pin tab is clicked");
	Enterpin("Thai");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ตั้งค่า']")));
	scrolldown.ScrolltillElementintoDisplay("//android.widget.TextView[@text='ภาษา']");
	Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='ภาษาไทย']")).isDisplayed(),"The default language selected is Thai");
	WebElement Language_button=appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='ภาษา']"));
	Language_button.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='กรุณาเลือกภาษาสำหรับแอปพลิเคชัน']")));		
	WebElement Language_Thai=appiumDriver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.ttbbank.oneapp.vit:id/radio_thai']"));
	String checked=Language_Thai.getAttribute("checked");
	Assert.assertEquals(checked, "true");
	WebElement Language_English=appiumDriver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.ttbbank.oneapp.vit:id/radio_english']"));
	Language_English.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Language']")));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Select your application language']")));
	appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.ttbbank.oneapp.vit:id/change_language_back_button']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='English']")));
	appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingIconBack']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/settingMenuSuffixIcon']")));
	scrolldown.ScrolltillElementintoDisplay("//android.widget.LinearLayout[@resource-id='com.ttbbank.oneapp.vit:id/logoutMenu']");	
	appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.ttbbank.oneapp.vit:id/logoutMenu']")).click();
	appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/full_width_primary_btn']")).click();
	System.out.println("logged out successfully--");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/subTitleTextView']")));
	String titletext=appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/subTitleTextView']")).getText();
	Assert.assertTrue(titletext.contains("Welcome to TTB Touch"),"Language changed to English");

		
	}
	
	
	
	public void Enterpin(String language) {
	
		
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


		
	
	}	

