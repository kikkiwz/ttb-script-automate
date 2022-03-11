package com.tmb.automation.test.it4it.sprint28.s14415;




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

public class Check_Notification_list_by_Activated_Customer_EN_Android extends Base {
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
	public void CheckInbox() throws Exception {
		String deviceID="SauceLab";
		scrolldown=new Scrolling();
		wait=new WebDriverWait(appiumDriver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.ttbbank.oneapp.vit:id/btn_skip']"))).isDisplayed();
		if(deviceID.equals("SauceLab")) {				
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
		Thread.sleep(5000);
		appiumDriver.findElement(By.id("com.ttbbank.oneapp.vit:id/skipIntro")).click();
		Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[3]")));
		System.out.println("We Logged in successfully");
		Thread.sleep(5000);
		appiumDriver.findElement(By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/img_inbox']")).click();
		Thread.sleep(5000);
		Enterpin();
		Thread.sleep(6000);
		List<WebElement> messagecount=appiumDriver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/img_read_more']"));
		System.out.println("The total messages are---"+messagecount.size());
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/txt_title']")).isDisplayed(), "We are inside inbox");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/img_is_read']")).isDisplayed(), "Read messages are displayed");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/img_is_read']")).isDisplayed(), "Unread message is displayed");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/tv_date_group']")).isDisplayed(), "Earlier messages are on the top");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/img_delete']")).isDisplayed(), "Delete button is displayed");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/img_read_more']")).isDisplayed(), "Read More is displayed");
		appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/img_delete']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.CheckBox[@resource-id='com.ttbbank.oneapp.vit:id/checkbox_read']")));		
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/tv_cancel']")).isDisplayed(), "Cancel button is visible");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/button_delete_selected']")).isDisplayed(), "Delete Selected is displayed");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/button_delete_all']")).isDisplayed(), "Delete All is displayed");
		Assert.assertTrue(!appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/button_delete_selected']")).isEnabled(), "Delete Selected is in disabled state");
		appiumDriver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id='com.ttbbank.oneapp.vit:id/checkbox_read'])[1]")).click();				
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/button_delete_selected']")).isEnabled(), "Delete Selected is in Enabled state");
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/button_delete_selected']")).click();
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/bottomsheet_title']")).isDisplayed(), "Confirm Delete title is displayed");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/full_width_primary_btn']")).isDisplayed(), "Confirm Delete button is displayed");
		Assert.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/full_width_ghost_btn']")).isDisplayed(), "Close button is displayed");
		appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/full_width_ghost_btn']")).click();
		//appiumDriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ttbbank.oneapp.vit:id/full_width_ghost_btn']")).click();
	
	
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

}