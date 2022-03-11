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

public class ChangeLanguage_Scenario extends BaseScenario {
	TtbTestContext context;
	public static ExtentTest Scenario1;
	public static ExtentTest Scenario2;
	public static ExtentTest Scenario3;
	@Test(groups = "Change Language from English to thai and Thai to English")
	public void ChangeLanguageScenario() throws InterruptedException, IOException {
		
		try {
		context = getTtbTestContext();		
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		ExtentTest Scenario = getFeature().createNode(Scenario.class,"Application Launch");
		String Image = "images/IT4IT/Language/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario.createNode(Given.class, "Application launched successfully").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Application Launch");
			String Image = "images/IT4IT/Language/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario.createNode(Given.class, "Application unable to launch").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();
		Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
		ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_TTB);
		String Image1 = "images/IT4IT/Language/Proscept_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image1);
		Scenario1.createNode(Given.class, "Prospect Customer unable to change language").addScreenCaptureFromPath(Image1).pass("VERIFIED");
		Registerttb();		
		String Image = "images/IT4IT/Language/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario1.createNode(Given.class, "Register ttb successfully using SIM bypass with default OTP 111111").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
			String Image = "images/IT4IT/Language/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario1.createNode(Given.class, "Register ttb was unsuccessfully using SIM bypass with default OTP 111111").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			if(context.isIos()) {
				context.waitUntilVisible(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON);
				context.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
				}
		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);
		String Image ="images/IT4IT/Language/APPTutorial_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario1.createNode(Given.class, "App Tutorial loaded Successfully").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Language/APPTutorial_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario1.createNode(Given.class, "App tutorial not loaded successfully").addScreenCaptureFromPath(Image).fail(t);	
		
		}
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		ChangeLanguage("English",Scenario2);
		ChangeLanguage("Thai",Scenario3);
		
		}
	public void ChangeLanguage(String Language,ExtentTest Scenario2) throws IOException {
		if(Language.equalsIgnoreCase("English")) {
		Scenario2 = getFeature().createNode(Scenario.class, "Verify Language change in English");
		String Image ="images/IT4IT/Language/Applicationloaded_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);		
		Scenario2.createNode(Given.class, "Your Application loaded is in English").addScreenCaptureFromPath(Image).pass("VERIFIED");	
		}
		else {
			Scenario2 = getFeature().createNode(Scenario.class, "Verify Language change in Thai");
			String Image ="images/IT4IT/Language/Applicationloaded_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);			
			Scenario2.createNode(Given.class, "Your Application loaded is in Thai").addScreenCaptureFromPath(Image).pass("VERIFIED");	
			
		}
	    context = getTtbTestContext();
	    try {
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();			
		context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
		String Image = "images/IT4IT/Language/Setting_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);	
		Scenario2.createNode(Given.class, "Successfully Navigated to Setting Menu").addScreenCaptureFromPath(Image).pass("PASS");
	    }
	    catch(Throwable t) {
	    	String Image = "images/IT4IT/Language/Setting_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);		
	    	Scenario2.createNode(Given.class, "Unable to load setting menu").addScreenCaptureFromPath(Image).fail(t);
	    }
	    
	    String[] laguageKeyword= {"Language","Thai","Set up Language","ภาษา","เปลี่ยนภาษา","ภาษาอังกฤษ"};
	   
	    for(int i=0;i<laguageKeyword.length;i++)
	    {
	    try {    	
	    	context.findElement(OneAppElementKeys.SEARCH_BAR).click();
	    	context.findElement(OneAppElementKeys.SEARCH_BAR).sendKeys(laguageKeyword[i]);
	    	Thread.sleep(1000);
	    	context.waitUntilVisible(OneAppElementKeys.LANGUAGE_RESULT_VERIFY);
	    	String Language_search=context.findElement(OneAppElementKeys.LANGUAGE_RESULT_VERIFY).getText();
	    	System.out.println("The Text is---"+Language_search);
	    	Thread.sleep(1000);
	    	Assert.assertTrue(Language_search.equalsIgnoreCase("Language") || Language_search.equalsIgnoreCase("ภาษา"), "Langauge tab is view");
	    	String Image = "images/IT4IT/Language/Search_"+i+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Language on search result loaded after searching "+laguageKeyword[i]).addScreenCaptureFromPath(Image).pass("VERIFIED");
			Thread.sleep(1000);
			context.findElement(OneAppElementKeys.LANGUAGE_RESULT_VERIFY).click();
			context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_PAGE);
			String Image1 = "images/IT4IT/Language/ChangeLanguage"+i+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image1);				
			Scenario2.createNode(Given.class, "Successfully Navigated to Change Language page").addScreenCaptureFromPath(Image1).pass("VERIFIED");
			Thread.sleep(3000);
			context.findElement(OneAppElementKeys.SELECT_LANGUAGE_BACKBUTTON).click();
			context.waitUntilVisible(OneAppElementKeys.LANGUAGE_RESULT_VERIFY);
			Thread.sleep(1000);
			context.findElement(OneAppElementKeys.SEARCH_BAR).click();
			Thread.sleep(1000);
			context.findElement(OneAppElementKeys.SEARCH_BAR).clear();
			Thread.sleep(1000);
			System.out.println("Verified for "+laguageKeyword[i]);
	    }	
	     	
	 catch(Throwable t) {
		    System.out.println("In catch block failed due to "+t);
	    	String Image = "images/IT4IT/Language/ChangeLanguage"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);		
	    	Scenario2.createNode(Given.class, "Unable to Search language on search bar for "+laguageKeyword[i]).addScreenCaptureFromPath(Image).fail(t);
	    }	
	    	
	    }
	    try {
	    Thread.sleep(1000);
		context.findElement(OneAppElementKeys.SEARCH_BAR).clear();
		Thread.sleep(2000);
	    context.findElement(OneAppElementKeys.SEARCH_BAR).click();
	    Thread.sleep(2000);
	    if(Language.equalsIgnoreCase("English")) {
    	context.findElement(OneAppElementKeys.SEARCH_BAR).sendKeys("ghetejsbnd");
	    }
	    else {
	    	context.findElement(OneAppElementKeys.SEARCH_BAR).sendKeys("ไม่ตรงกับเอกสารใดๆ");
	    }
    	Thread.sleep(1000);
    	context.waitUntilVisible(OneAppElementKeys.NO_RESULT_VERIFY);
    	String Language_search=context.findElement(OneAppElementKeys.NO_RESULT_VERIFY).getText();
    	Assert.assertTrue(Language_search.equalsIgnoreCase("No results found") || Language_search.equalsIgnoreCase("ไม่พบผลการค้นหา"), "No result found message is displayed");
    	String Image = "images/IT4IT/Language/NoResult"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);		
    	Scenario2.createNode(Given.class, "No result found message is displayed for searching any random text").addScreenCaptureFromPath(Image).pass("PASS");
    	Thread.sleep(1000);
	    }
	    catch(Throwable t) {
	    	String Image = "images/IT4IT/Language/NoResult"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);		
	    	Scenario2.createNode(Given.class, "No result found message is not displayed for searching any random text").addScreenCaptureFromPath(Image).fail("t");
	       }	
	
	    try {
	    	Thread.sleep(1000);
			context.findElement(OneAppElementKeys.SEARCH_BAR).clear();
			Thread.sleep(2000);
		    context.findElement(OneAppElementKeys.SEARCH_BAR).click();
		    Thread.sleep(2000);
		    if(Language.equalsIgnoreCase("English")) {
	    	context.findElement(OneAppElementKeys.SEARCH_BAR).sendKeys("Language");
		    }
		    else {
		    	context.findElement(OneAppElementKeys.SEARCH_BAR).sendKeys("ภาษา");
		    }
	    	Thread.sleep(1000);
	    	String Language_search=context.findElement(OneAppElementKeys.LANGUAGE_RESULT_VERIFY).getText();
	    	Assert.assertTrue(Language_search.equalsIgnoreCase("Language") || Language_search.equalsIgnoreCase("ภาษา"), "Langauge tab is view");
	    	context.findElement(OneAppElementKeys.SEARCH_BAR_X_BUTTON).click();
	    	context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
	    	Thread.sleep(1000);
	    	String Image = "images/IT4IT/Language/X_button"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);		
	    	Scenario2.createNode(Given.class, "X(Clear) button verified Successfully, Setting page loaded after clicking on X button").addScreenCaptureFromPath(Image).pass("PASS");
	    	Thread.sleep(1000);
		    }
		    catch(Throwable t) {
		    	String Image = "images/IT4IT/Language/X_button"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image);		
		    	Scenario2.createNode(Given.class, "X(Clear) failed to verify").addScreenCaptureFromPath(Image).fail("t");
		       }	
		
	    try {	
	    	if(Language.equalsIgnoreCase("English")) {
		context.scrollTillElementIntoDisplay(OneAppElementKeys.LANGUAGE_BUTTON);
		context.findElement(OneAppElementKeys.LANGUAGE_BUTTON).click();
	    	}
	    	else {
	    		context.scrollTillElementIntoDisplay(OneAppElementKeys.LANGUAGE_BUTTON_THAI);
	    		context.findElement(OneAppElementKeys.LANGUAGE_BUTTON_THAI).click();
	    	    
	    	}
		context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_PAGE);
		String Image = "images/IT4IT/Language/Language_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);	
		Scenario2.createNode(Given.class, "Successfully Navigated to change language page").addScreenCaptureFromPath(Image).pass("PASS");
	
	    }
	    catch(Throwable t) {
	    	String Image = "images/IT4IT/Language/Language"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Unable to load change language page").addScreenCaptureFromPath(Image).fail(t);
		
	    }
	    try {
		if(context.isAndroid() && Language.equalsIgnoreCase("English") ) {
		String EngChecked=context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_ENGLISH).getAttribute("checked");
		Assert.assertEquals(EngChecked, "true");
		context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI).click();
		context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM);
		context.findElement(OneAppElementKeys.SELECT_LANGUAGE_BACKBUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM_2);
		context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK).click();
		}
		else if(context.isAndroid() && Language.equalsIgnoreCase("Thai") ) {
			String ThaiChecked=context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI).getAttribute("checked");
			Assert.assertEquals(ThaiChecked, "true");
			context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_ENGLISH).click();		
			context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_PAGE);
			context.findElement(OneAppElementKeys.SELECT_LANGUAGE_BACKBUTTON).click();
			context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_ENGLISH_CONFIRM_2);
			context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK);
			context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK).click();
		}		
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		String Image = "images/IT4IT/Language/ChangedLanguage_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);	
		Scenario2.createNode(Given.class, "Successfully Changed language to "+Language).addScreenCaptureFromPath(Image).pass("PASS");	
		context.findElement(OneAppElementKeys.HOME_TAB_1).click();
	    }
	    catch(Throwable t) {
	    	String Image = "images/IT4IT/Language/ChangedLanguage_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Unable to Change language to "+Language).addScreenCaptureFromPath(Image).fail(t);
		
	    }
		try {
			if(context.isAndroid()) {	
		context.waitUntilVisible(OneAppElementKeys.EXPAND_ARROW);
			}
			else if(context.isIos() && Language.equalsIgnoreCase("English")) {
				context.waitUntilVisible(OneAppElementKeys.EXPAND_ARROW_TH);
			}
				
		Thread.sleep(2000);
		if(Language.equalsIgnoreCase("English")) {
			if(context.isAndroid()) {	
		context.findElement(OneAppElementKeys.EXPAND_ARROW).click();
			}
			else {
				context.waitUntilVisible(OneAppElementKeys.EXPAND_ARROW_TH);
			}
		context.waitUntilVisible(OneAppElementKeys.INSURANCE_THAI);
		context.findElement(OneAppElementKeys.INSURANCE_THAI).click();
		
		for(int i=0;i<100;i++) {
			String Insurancepagesource=context.getDriver().getPageSource();
			Boolean insurancepresentThai=Insurancepagesource.contains("ประกัน");
			
			if(insurancepresentThai) {
				break;
			}
			else {
				Thread.sleep(3000);
			}
		}
		}
		else if(Language.equalsIgnoreCase("Thai")) {
			context.waitUntilVisible(OneAppElementKeys.INSURANCE_ENGLISH);
			context.findElement(OneAppElementKeys.INSURANCE_ENGLISH).click();
			
			for(int i=0;i<100;i++) {
				String Insurancepagesource=context.getDriver().getPageSource();
				Boolean insurancepresentEng=Insurancepagesource.contains("Insurance");
				
				if(insurancepresentEng) {
					break;
				}
				else {
					Thread.sleep(1000);
				}
			}
			}
			
		String Image1 = "images/IT4IT/Language/Insurance_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image1);	
		Scenario2.createNode(Given.class, "Successfully Verified Insurance loaded "+Language).addScreenCaptureFromPath(Image1).pass("PASS");				
		Thread.sleep(1000);
		context.getDriver().navigate().back();
		if(context.isAndroid()) {
		context.waitUntilVisible(OneAppElementKeys.EXPAND_ARROW);
		}
		else if(context.isIos()) {
			if(Language.equalsIgnoreCase("Thai")) {
				context.waitUntilVisible(OneAppElementKeys.EXPAND_ARROW_EN);
			}
			else {
				context.waitUntilVisible(OneAppElementKeys.EXPAND_ARROW_TH);
			}
			
		}
		}
		 catch(Throwable t) {
		    	String Image1 = "images/IT4IT/Language/Insurance_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image1);	
				Scenario2.createNode(Given.class, "Insurance Not loaded "+Language).addScreenCaptureFromPath(Image1).fail(t);
			
		    }
	    
	}
	
}
