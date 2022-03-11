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

public class GenericError_CommonScreen_Scenario extends BaseScenario {

	@Test(groups = "Generic Error Common Screen on both Android and iOS")
	public void GenericError_CommonScreen_Verification_on_both_Android_and_ios() throws InterruptedException {

		TtbTestContext context = getTtbTestContext();
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();
		Registerttb();
		Thread.sleep(30000);
		context.getDriver().closeApp();
		Thread.sleep(5000);
		context.getDriver().launchApp();		
		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();		 
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();	
		enterPin();
		context.waitUntilVisible(OneAppElementKeys.GENERIC_ERROR_TITLE);
		context.waitUntilVisible(OneAppElementKeys.GENERIC_ERROR_BODY);
		context.waitUntilVisible(OneAppElementKeys.GENERIC_ERROR_OK);
		

	}

}
