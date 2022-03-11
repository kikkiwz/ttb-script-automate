package com.ttbbank.oneapp.pb1.UIe11750;

import com.tmb.automation.pages.pb1.OpenReport;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC11_eKYC_WiFiOnIOS extends BaseScenario {

	@Parameters("DeviceProfile")
	@BeforeTest(alwaysRun = true)
	public void BeforeTest(String deviceProfile) {
		testWithDeviceProfile(deviceProfile);
	}

	@Test (groups = {"ios", "PB1"}, description="eKYCWiFiOnIOS")
	public void Test01() throws InterruptedException, IOException {
		log("------------Start--- : " + this.getClass().getSimpleName());
		System.out.println("Test Start--");
		TtbTestContext ttbTestContext = getTtbTestContext();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_WITHDRAW);
		ttbTestContext.findElement(OneAppElementKeys.PB1_WITHDRAW).click();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_REGISTER_TTB);
		ttbTestContext.findElement(OneAppElementKeys.PB1_REGISTER_TTB).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_ACCEPT_T_AND_C).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_T_AND_C_NEXT).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_INPUT_CID).click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_INPUT_CID).sendKeys("5151086373286");
        ttbTestContext.findElement(OneAppElementKeys.PB1_ENTER_CID_NEXT).click();
        
        try {
        String DisableWiFi= ttbTestContext.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name='Bottom sheet title']").getText();
        System.out.println("Message-- " +DisableWiFi);
        ttbTestContext.getDriver().runAppInBackground(Duration.ofSeconds(-1));
        HashMap<String, Object> params = new HashMap<>();
		JavascriptExecutor js = (JavascriptExecutor) ttbTestContext.getDriver();
		params.put("bundleId", "com.apple.Preferences");
		js.executeScript("mobile: launchApp", params);
		ttbTestContext.getDriver().findElementById("Wi-Fi").click();
		Thread.sleep(4000);
		ttbTestContext.getDriver().findElementByXPath("//XCUIElementTypeSwitch").click();
		Thread.sleep(4000);
		ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
        System.out.println("WIFI Disable-- " );
        Thread.sleep(2000);
        ttbTestContext.getDriver().findElementByXPath("//XCUIElementTypeButton[@name='Close.']").click();
        ttbTestContext.findElement(OneAppElementKeys.PB1_ENTER_CID_NEXT).click();
        } catch (Exception e) { 
        	System.out.println("WIFI Disable Bypass-- " );
        }
        
        Thread.sleep(2000);
		System.out.println("Register Title -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_REGISTER_TITLE).getText());
		System.out.println("Register Method -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_REGISTER_METHOD).getText());
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_OPEN_AC).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_OPEN_AC_NEXT).click();
		
		System.out.println("Open Ac title -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_OPEN_AC_TITLE).getText());
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_ALLFREE).click();
		Thread.sleep(1000);
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_NOFIX).click();
		Thread.sleep(1000);
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_SELECTAC_NEXT).click();

		ttbTestContext.getDriver().runAppInBackground(Duration.ofSeconds(-1));
		HashMap<String, Object> params = new HashMap<>();
		JavascriptExecutor js = (JavascriptExecutor) ttbTestContext.getDriver();
		params.put("bundleId", "com.apple.Preferences");
		js.executeScript("mobile: launchApp", params);
		ttbTestContext.getDriver().findElement(By.id("Wi-Fi")).click();
		Thread.sleep(4000);
		ttbTestContext.getDriver().findElement(By.xpath("//XCUIElementTypeSwitch")).click();
		Thread.sleep(4000);
		ttbTestContext.getDriver().activateApp("com.ttbbank.oneapp.vit");
		System.out.println("WIFI Enable-- " );
		
		Thread.sleep(2000);
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_EKYC_PRODUCT_IMG_NEXT);
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_PRODUCT_IMG_NEXT).click();

		System.out.println("Step1 WiFi-- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_STEP_TITLE).getText());
		System.out.println("WIFI Off message1 -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_WIFIOFF_MESSAGE1).getText());
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_CHECKMOBILE_NEXT).click();
		
		System.out.println("WIFI Off title -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_WIFIOFF_TITLE).getText());
		System.out.println("WIFI Off message2 -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_WIFIOFF_MESSAGE2).getText());
		OpenReport.ReportBase("Disable WiFi Message");
		
		
		System.out.println("Done-- ");
		Thread.sleep(2000);
	}

}
