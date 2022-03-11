package com.ttbbank.oneapp.pb1.UIe11750;

import com.tmb.automation.pages.pb1.OpenReport;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC01_eKYC_WiFiOnAndroid extends BaseScenario {

	@Parameters("DeviceProfile")
	@BeforeTest(alwaysRun = true)
	public void BeforeTest(String deviceProfile) {
		testWithDeviceProfile(deviceProfile);
	}

	@Test (groups = {"android", "PB1"}, description="eKYCWiFiOnAndroid")
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
        ((HasNetworkConnection) ttbTestContext.getDriver()).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
        System.out.println("WIFI Disable-- " );
        Thread.sleep(2000);
        ttbTestContext.findElement(OneAppElementKeys.PB1_ENTER_CID_NEXT).click();
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

		((HasNetworkConnection) ttbTestContext.getDriver()).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		System.out.println("WIFI Enable-- " );
		
		Thread.sleep(2000);
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_EKYC_PRODUCT_IMG_NEXT);
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_PRODUCT_IMG_NEXT).click();

		System.out.println("Step1 WiFi-- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_STEP_TITLE).getText());
		System.out.println("WIFI Off message1 -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_WIFIOFF_MESSAGE1).getText());
		ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_CHECKMOBILE_NEXT).click();
		
		System.out.println("WIFI Off title -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_WIFIOFF_TITLE).getText());
		System.out.println("WIFI Off message2 -- " +ttbTestContext.findElement(OneAppElementKeys.PB1_EKYC_WIFIOFF_MESSAGE2).getText());
		OpenReport.ReportBase("Disable WiFI Message");
    	
		System.out.println("Done-- ");
		Thread.sleep(2000);
	}

}
