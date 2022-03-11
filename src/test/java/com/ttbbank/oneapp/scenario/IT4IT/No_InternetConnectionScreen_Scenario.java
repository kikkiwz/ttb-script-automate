package com.ttbbank.oneapp.scenario.IT4IT;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;

import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class No_InternetConnectionScreen_Scenario extends BaseScenario {

	@Test(groups = "No Internet Connection Screen on both Android and iOS")
	public void No_InternetConnection_Verification_on_both_Android_and_ios() throws InterruptedException {

		TtbTestContext context = getTtbTestContext();
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		if(context.isIos()) {
		context.getDriver().runAppInBackground(Duration.ofSeconds(-1));
	    Map<String, Object> params = new HashMap<>();
	    JavascriptExecutor js = (JavascriptExecutor) context.getDriver();
	    params.put("bundleId", "com.apple.Preferences");
	    js.executeScript("mobile: launchApp", params);
	    context.getDriver().findElement(By.id("Wi-Fi")).click();
	    Thread.sleep(5000);
	    context.getDriver().findElement(By.xpath("//XCUIElementTypeSwitch")).click();
	    Thread.sleep(5000);
	    context.getDriver().activateApp("com.ttbbank.oneapp.vit");
		}
	    if(context.isAndroid()) {
		((HasNetworkConnection) context.getDriver()).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
	    }
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.REGISTER_TTB);
		context.findElement(OneAppElementKeys.REGISTER_TTB).click();
		context.waitUntilVisible(OneAppElementKeys.NO_INTERNET_CONNECTION);
		context.findElement(OneAppElementKeys.NO_INTERNET_CONNECTION_OK_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.getDriver().closeApp();
		Thread.sleep(5000);
		context.getDriver().launchApp();
		context.waitUntilVisible(OneAppElementKeys.NO_INTERNET_CONNECTION);
		
	}

}
