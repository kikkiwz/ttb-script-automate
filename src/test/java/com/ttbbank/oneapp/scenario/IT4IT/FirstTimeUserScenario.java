package com.ttbbank.oneapp.scenario.IT4IT;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTimeUserScenario extends BaseScenario {
	TtbTestContext context;
	public static ExtentTest Scenario1;
	public static ExtentTest Scenario2;
	public static ExtentTest Scenario3;
	@Test(groups = "First Time User validation")
	public void FirstTimeUser() throws InterruptedException, IOException {		
		try {
		context = getTtbTestContext();		
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		Scenario1 = getFeature().createNode(Scenario.class,"Application Launch");
		String Image = "images/IT4IT/FirstTime/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario1.createNode(Given.class, "Application launched successfully").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Application Launch");
			String Image = "images/IT4IT/FirstTime/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario.createNode(Given.class, "Application unable to launch").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();
		Scenario2 = getFeature().createNode(Scenario.class, "Register ttb");
		ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_TTB);
		String Image1 = "images/IT4IT/FirstTime/Proscept_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image1);
		Scenario2.createNode(Given.class, "App Tutorial is not present for Prospect Customer").addScreenCaptureFromPath(Image1).pass("VERIFIED");
		Registerttb();		
		String Image = "images/IT4IT/FirstTime/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario2.createNode(Given.class, "Register ttb successfully using SIM bypass with default OTP 111111").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			Scenario2 = getFeature().createNode(Scenario.class, "Register ttb");
			String Image = "images/IT4IT/FirstTime/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Register ttb was unsuccessfully using SIM bypass with default OTP 111111").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
		Scenario3 = getFeature().createNode(Scenario.class, "App Tutorial Validation");
		if(context.isIos()) {
		context.waitUntilVisible(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON);
		context.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
		}
		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);
		String Image ="images/IT4IT/FirstTime/APPTutorial_1_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario3.createNode(Given.class, " First App Tutorial loaded Successfully on home screen").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/FirstTime/APPTutorial_1_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario3.createNode(Given.class, "First App tutorial not loaded successfully").addScreenCaptureFromPath(Image).fail(t);	
		
		}
		try {
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);		
		String Image ="images/IT4IT/FirstTime/APPTutorial_2_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario3.createNode(Given.class, " Second App Tutorial loaded Successfully on home screen").addScreenCaptureFromPath(Image).pass("PASS");	
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);		
		String Image2 ="images/IT4IT/FirstTime/APPTutorial_3_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image2);
		Scenario3.createNode(Given.class, "Third App Tutorial loaded Successfully on home screen").addScreenCaptureFromPath(Image2).pass("PASS");	
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);		
		String Image3 ="images/IT4IT/FirstTime/APPTutorial_ACCOUNT_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image3);
		Scenario3.createNode(Given.class, "ACCOUNT tab  App Tutorial loaded Successfully").addScreenCaptureFromPath(Image3).pass("PASS");	
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.SERVICE_BUTTON);
		context.findElement(OneAppElementKeys.SERVICE_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);		
		String Image4 ="images/IT4IT/FirstTime/APPTutorial_SERVICE_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image4);
		Scenario3.createNode(Given.class, " Service tab App Tutorial loaded Successfully").addScreenCaptureFromPath(Image4).pass("PASS");	
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/FirstTime/APPTutorialnotloaded"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario1.createNode(Given.class, "App tutorial not loaded successfully").addScreenCaptureFromPath(Image).fail(t);	
		
		}
		
		try {
		context.getDriver().closeApp();
		Thread.sleep(2000);
		context.getDriver().launchApp();
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		String Image = "images/IT4IT/FirstTime/LaunchApp_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario3.createNode(Given.class, "App launch successfully again").addScreenCaptureFromPath(Image).pass("PASS");	
	
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/FirstTime/LaunchApp_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario3.createNode(Given.class, "App launch failed ").addScreenCaptureFromPath(Image).fail(t);	
		
		}
		try {		
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		String Image5 ="images/IT4IT/FirstTime/APPTutorial_EXISTING_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image5);
		Scenario3.createNode(Given.class, "App tutorial not present for Existing customer").addScreenCaptureFromPath(Image5).pass("PASS");	
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/FirstTime/APPTutorial_EXISTING_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario3.createNode(Given.class, "App tutorial present for Existing customer").addScreenCaptureFromPath(Image).fail(t);	
		
		}
		
		}
		
}
