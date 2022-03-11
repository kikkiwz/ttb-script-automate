package com.tmb.automation.pages.pb1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;

/* Android Automation
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class PB1LoginAndroid_PO extends AppiumLibrary {
public AppiumDriver<WebElement> appiumDriver;

		public PB1LoginAndroid_PO (AppiumDriver<WebElement> appiumDriver) {
			super((AppiumDriver<WebElement>) appiumDriver);
			this.appiumDriver=appiumDriver;
		}
		
//Home Page
		By Home =By.xpath("//*[@class='android.widget.RelativeLayout'][1]");
		By Accounts =By.xpath("//*[@class='android.widget.RelativeLayout'][2]");
		By Service = By.xpath("//*[@class='android.widget.RelativeLayout'][3]");
		
//Pin HomeScreen
		By Pin0 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_00']");
		By Pin1 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_01']");
		By Pin2 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_02']");
		By Pin3 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_03']");
		By Pin4 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_04']");
		By Pin5 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_05']");
		By Pin6 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_06']");
		By Pin7 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_07']");
		By Pin8 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_08']");
		By Pin9 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/key_09']");	
	
		
		public WebElement Home() {
			return appiumDriver.findElement(Home);
		}
		public WebElement Accounts() {
			return appiumDriver.findElement(Accounts);
		}
		public WebElement Service() {
			return appiumDriver.findElement(Service);
		}
		
		public WebElement Pin0() {
			return appiumDriver.findElement(Pin0);
		}
		public WebElement Pin1() {
			return appiumDriver.findElement(Pin1);
		}
		public WebElement Pin2() {
			return appiumDriver.findElement(Pin2);
		}
		public WebElement Pin3() {
			return appiumDriver.findElement(Pin3);
		}
		public WebElement Pin4() {
			return appiumDriver.findElement(Pin4);
		}
		public WebElement Pin5() {
			return appiumDriver.findElement(Pin5);
		}
		public WebElement Pin6() {
			return appiumDriver.findElement(Pin6);
		}
		public WebElement Pin7() {
			return appiumDriver.findElement(Pin7);
		}
		public WebElement Pin8() {
			return appiumDriver.findElement(Pin8);
		}
		public WebElement Pin9() {
			return appiumDriver.findElement(Pin9);
		}	

//Pin TransferScreen		
		By TPin0 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_0']");
		By TPin1 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_1']");
		By TPin2 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_2']");
		By TPin3 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_3']");
		By TPin4 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_4']");
		By TPin5 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_5']");
		By TPin6 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_6']");
		By TPin7 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_7']");
		By TPin8 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_8']");
		By TPin9 =By.xpath("//*[@resource-id='com.ttbbank.oneapp.vit:id/pin_key_9']");
	
		public WebElement TPin0() {
			return appiumDriver.findElement(TPin0);
		}
		public WebElement TPin1() {
			return appiumDriver.findElement(TPin1);
		}
		public WebElement TPin2() {
			return appiumDriver.findElement(TPin2);
		}
		public WebElement TPin3() {
			return appiumDriver.findElement(TPin3);
		}
		public WebElement TPin4() {
			return appiumDriver.findElement(TPin4);
		}
		public WebElement TPin5() {
			return appiumDriver.findElement(TPin5);
		}
		public WebElement TPin6() {
			return appiumDriver.findElement(TPin6);
		}
		public WebElement TPin7() {
			return appiumDriver.findElement(TPin7);
		}
		public WebElement TPin8() {
			return appiumDriver.findElement(TPin8);
		}
		public WebElement TPin9() {
			return appiumDriver.findElement(TPin9);
		}
} 

