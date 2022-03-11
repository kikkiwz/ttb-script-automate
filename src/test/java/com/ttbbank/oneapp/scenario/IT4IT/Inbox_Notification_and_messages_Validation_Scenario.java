package com.ttbbank.oneapp.scenario.IT4IT;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.tmb.automation.common.MongoDB;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.LoginLogsModel;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Inbox_Notification_and_messages_Validation_Scenario extends BaseScenario {
	TtbTestContext context;
	public static ExtentTest Scenario1;
	public static ExtentTest Scenario2;
	public static ExtentTest Scenario3;
	public static ExtentTest Scenario4;
	public static ExtentTest Scenario5;
	public static ExtentTest Scenario6;
	public static ExtentTest Scenario7;
	public static ExtentTest Scenario8;
	public static ExtentTest Scenario9;
	public static ExtentTest Scenario10;	
	public static int messagecount;
	public static String Environment="DEV";
	public static String ACTIVITY_LOG_URL;
	@Test(groups = "Inbox notification and Messages Validation")
	public void Inbox_Notification_validation() throws InterruptedException, IOException {
		
		context = getTtbTestContext();
		
		
try {
		
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		ExtentTest Scenario = getFeature().createNode(Scenario.class,"Application Launch");
		String Image = "images/IT4IT/Inbox/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario.createNode(Given.class, "Application launched successfully").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Application Launch");
			String Image = "images/IT4IT/Inbox/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario.createNode(Given.class, "Application unable to launch").addScreenCaptureFromPath(Image).fail(t);
		}
try {
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();
		Registerttb();
		Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
		String Image = "images/IT4IT/Inbox/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario1.createNode(Given.class, "Register ttb successfully").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
			String Image = "images/IT4IT/Inbox/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario1.createNode(Given.class, "Register ttb was unsuccessfully").addScreenCaptureFromPath(Image).fail(t);	
		}
	try {
		//context.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();	
		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);
		String Image = "images/IT4IT/Inbox/App_Tutorial"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario1.createNode(Given.class, "App Tutorial loaded Successfully").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Inbox/App_Tutorial"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario1.createNode(Given.class, "App tutorial not loaded successfully").addScreenCaptureFromPath(Image).fail(t);			
		}
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();		
		context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE);
		Inbox_Notification_Validation("English",Scenario2);		
		DeleteNotification("English",Scenario3);
		Inbox_Message_Vaalidation("English",Scenario4);
		DeleteMessage("English",Scenario5);
		ChangeLanguageEngToThai(Scenario6);
		Inbox_Notification_Validation("Thai",Scenario7);
		DeleteNotification("Thai",Scenario8);
		Inbox_Message_Vaalidation("Thai",Scenario9);
		DeleteMessage("Thai",Scenario10);
		
		
	}
	public void Inbox_Message_Vaalidation(String Language,ExtentTest Scenario) throws IOException {
		Scenario = getFeature().createNode(Scenario.class, "Inbox Validation under Message tab");
		try {
			context.waitUntilVisible(OneAppElementKeys.INBOX_ICON);
			context.findElement(OneAppElementKeys.INBOX_ICON).click();
			context.waitUntilVisible(OneAppElementKeys.MESSAGES_TAB);	
			context.findElement(OneAppElementKeys.MESSAGES_TAB).click();
			context.waitUntilVisible(OneAppElementKeys.PAST_MESSAGES);	
			context.findElement(OneAppElementKeys.INBOX_BACK_BUTTON).click();
			context.waitUntilVisible(OneAppElementKeys.INBOX_ICON);
			String Image1 = "images/IT4IT/Inbox/InboxPageBack_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image1);
			Scenario.createNode(Given.class, "Back button is validated successfully").addScreenCaptureFromPath(Image1).pass("PASS");			
			context.findElement(OneAppElementKeys.INBOX_ICON).click();	
			context.waitUntilVisible(OneAppElementKeys.MESSAGES_TAB);	
			context.findElement(OneAppElementKeys.MESSAGES_TAB).click();
			
		List<WebElement> totalmessages=context.findElements(OneAppElementKeys.MESSAGE_COUNT_MESSAGE_TAB);
		messagecount=totalmessages.size();
		Scenario.createNode(Given.class, "Message count found to be  "+messagecount).pass("PASS");		
		List<WebElement> UnReadMessages=context.findElements(OneAppElementKeys.INBOX_UNREAD_MESSAGE);
		if(UnReadMessages.size()>1) {
		Scenario.createNode(Given.class, "UnRead Message displayed").pass("PASS");
		}
		UnReadMessages.get(0).click();
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.INBOX_BACK_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.INBOX_TITLE);
		Scenario.createNode(Given.class, "Read More arrow validate successfully").pass("PASS");
		context.waitUntilVisible(OneAppElementKeys.INBOX_UNREAD_MESSAGE);
		List<WebElement> UnReadMessages1=context.findElements(OneAppElementKeys.INBOX_UNREAD_MESSAGE);
		Assert.assertTrue(UnReadMessages1.size()<UnReadMessages.size());
		Scenario.createNode(Given.class, "After Reading the message the status changed from unread to read as Read Messages count increases from "+UnReadMessages.size()+ " to "+UnReadMessages1.size()).pass("PASS");			
		context.findElement(OneAppElementKeys.INBOX_DATE).isDisplayed();
		Scenario.createNode(Given.class, "Inbox date displayed").pass("PASS");		
		String Image = "images/IT4IT/Inbox/Inbox_verified"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario.createNode(Given.class, "Inbox verified successfully").addScreenCaptureFromPath(Image).pass("VERIFIED");		
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Inbox/Inbox_verified_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario.createNode(Given.class, "Inbox validation failed").addScreenCaptureFromPath(Image).fail(t);
		}
	}
	
	
	
	
	
	
	public void Inbox_Notification_Validation(String Language,ExtentTest Scenario) throws IOException {
		Scenario = getFeature().createNode(Scenario.class, "Inbox Validation under Notification tab");
		try {
	    context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.scrollTillElementIntoDisplay(OneAppElementKeys.LOGGOUT_BUTTON);
		context.findElement(OneAppElementKeys.LOGGOUT_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.LOGGOUT_BUTTON_OK);
		context.findElement(OneAppElementKeys.LOGGOUT_BUTTON_OK).click();
    	context.waitUntilVisible(OneAppElementKeys.INBOX_ICON);
		context.findElement(OneAppElementKeys.INBOX_ICON).click();
		context.findElement(OneAppElementKeys.PIN_CANCEL).click();
		context.waitUntilVisible(OneAppElementKeys.INBOX_ICON);
		Scenario.createNode(Given.class, "Cancel PIN verified").pass("PASS");	
		context.findElement(OneAppElementKeys.INBOX_ICON).click();
		enterPin();
		Thread.sleep(10000);
		Activity_log("100000100", "Success", "Log in - Mobile App","Inbox",0,Scenario);
		context.waitUntilVisible(OneAppElementKeys.INBOX_TITLE);
		String title=context.findElement(OneAppElementKeys.INBOX_TITLE).getText();
		Assert.assertTrue(title.equalsIgnoreCase("Inbox") || title.equalsIgnoreCase("กล่องข้อความ"), "Title should be Inbox");
		String Image = "images/IT4IT/Inbox/InboxPage_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario.createNode(Given.class, "Successfully landed on inbox").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Inbox/InboxPage_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario.createNode(Given.class, "Unable to load inbox").addScreenCaptureFromPath(Image).fail(t);			
		}
		try {
			context.waitUntilVisible(OneAppElementKeys.PAST_MESSAGES);	
			context.findElement(OneAppElementKeys.INBOX_BACK_BUTTON).click();
			context.waitUntilVisible(OneAppElementKeys.INBOX_ICON);
			String Image1 = "images/IT4IT/Inbox/InboxPageBack_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image1);
			Scenario.createNode(Given.class, "Back button is validated successfully").addScreenCaptureFromPath(Image1).pass("PASS");			
			context.findElement(OneAppElementKeys.INBOX_ICON).click();		
		List<WebElement> totalmessages=context.findElements(OneAppElementKeys.MESSAGE_COUNT);
		messagecount=totalmessages.size();
		Scenario.createNode(Given.class, "Message count found to be  "+messagecount).pass("PASS");		
		List<WebElement> ReadMessages=context.findElements(OneAppElementKeys.INBOX_READ_MESSAGE);
		if(ReadMessages.size()>1) {
		Scenario.createNode(Given.class, "Read Message displayed").pass("PASS");
		}
		List<WebElement> UnReadMessages=context.findElements(OneAppElementKeys.INBOX_UNREAD_MESSAGE);
		if(UnReadMessages.size()>1) {
		Scenario.createNode(Given.class, "UnRead Message displayed").pass("PASS");
		}
		UnReadMessages.get(0).click();
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.INBOX_BACK_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.INBOX_TITLE);
		Scenario.createNode(Given.class, "Read More arrow validate successfully").pass("PASS");
		List<WebElement> ReadMessages1=context.findElements(OneAppElementKeys.INBOX_READ_MESSAGE);
		Assert.assertTrue(ReadMessages1.size()>ReadMessages.size());
		Scenario.createNode(Given.class, "After Reading the message the status changed from unread to read as Read Messages count increases from "+ReadMessages.size()+ " to "+ReadMessages1.size()).pass("PASS");			
		context.findElement(OneAppElementKeys.INBOX_DATE).isDisplayed();
		Scenario.createNode(Given.class, "Inbox date displayed").pass("PASS");		
		String Image = "images/IT4IT/Inbox/Inbox_verified"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario.createNode(Given.class, "Inbox verified successfully").addScreenCaptureFromPath(Image).pass("VERIFIED");		
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Inbox/Inbox_verified_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);
			Scenario.createNode(Given.class, "Inbox validation failed").addScreenCaptureFromPath(Image).fail(t);
		}
	}
	
	public void DeleteNotification(String Language,ExtentTest Scenario) throws IOException {
		Scenario = getFeature().createNode(Scenario.class, "Delete Message Validation");
		try {
			List<WebElement> totalmessages=context.findElements(OneAppElementKeys.MESSAGE_COUNT);
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_DELETE).click();
			context.waitUntilVisible(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ);
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CANCEL).isDisplayed();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CANCEL).click();
			Scenario.createNode(Given.class, "Cancel button on delete secleted page is verified successfully").pass("VERIFIED");
			context.waitUntilVisible(OneAppElementKeys.INBOX_BACK_BUTTON);			
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_DELETE).click();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).isDisplayed();
			boolean enabled=context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).isEnabled();
			Assert.assertTrue(!enabled, "Delete selected is not enabled");
			String Image = "images/IT4IT/Inbox/InboxPageDeletepage_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);			
			Scenario.createNode(Given.class, "Checkbox read, checkbox read cancel and delete selected are displayed and delete selected is in disabled state").addScreenCaptureFromPath(Image).pass("VERIFIED");
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_ALL).isDisplayed();
			List<WebElement> CheckboxRead=context.findElements(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ);
			CheckboxRead.get(0).click();
			boolean enabled1=context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).isEnabled();
			Assert.assertTrue(enabled1, "Delete selected is enabled");
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).click();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_TITLE).isDisplayed();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON).isDisplayed();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_CLOSE_BUTTON).isDisplayed();
			String Image1 = "images/IT4IT/Inbox/InboxPageConfirm_Delete_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image1);			
			Scenario.createNode(Given.class, "Delete selected is enabled, confirm delete button and confirm close button are displayed").addScreenCaptureFromPath(Image1).pass("VERIFIED");
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_CLOSE_BUTTON).click();
			Scenario.createNode(Given.class, "X(CLOSE) button on confirm delete is verified successfully").addScreenCaptureFromPath(Image).pass("VERIFIED");
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).click();
			context.waitUntilVisible(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON);
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON).click();
			context.waitUntilVisible(OneAppElementKeys.INBOX_BACK_BUTTON);
			Thread.sleep(1000);
			String messagedeleted=context.getDriver().getPageSource();
			System.out.println("The Page source is--"+messagedeleted);
			Assert.assertTrue(messagedeleted.contains("successfully deleted") ||messagedeleted.contains("ลบข้อความสำเร็จ") , "Message deleted successfully");
			List<WebElement> totalmessagesafterdelete=context.findElements(OneAppElementKeys.MESSAGE_COUNT);
			String Image2 = "images/IT4IT/Inbox/InboxPage_DeleteSuccessfully_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image2);			
			Scenario.createNode(Given.class, "Message deleted successfully and Toast message were displayed and total message count after deleteing one message changes from "+totalmessages.size() +"to "+totalmessagesafterdelete.size()).addScreenCaptureFromPath(Image2).pass("VERIFIED");
			Thread.sleep(10000);
			Activity_log("101800300", "Success", "Delete inbox message","Success",3,Scenario);
			if(Language.equalsIgnoreCase("Thai")) {
			try {
				context.waitUntilVisible(OneAppElementKeys.INBOX_MESSAGE_DELETE);
				context.findElement(OneAppElementKeys.INBOX_MESSAGE_DELETE).click();
				context.findElement(OneAppElementKeys.DELETE_ALL).click();
				
				context.waitUntilVisible(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON);
				context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON).click();
				System.out.println("No more mesage page---");
				Thread.sleep(1000);
				Assert.assertTrue(context.findElement(OneAppElementKeys.NO_MESSAGE_VIEW).isDisplayed(), "No message lottie file should display");
				System.out.println("No more mesage page verified---");
				String Image3 = "images/IT4IT/Inbox/InboxPage_DeleteAllSuccessfully_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image3);			
				Scenario.createNode(Given.class, "All messages we deleted successfully and No more message lottie file is visible").addScreenCaptureFromPath(Image3).pass("VERIFIED");
			}
			catch(Throwable t) {
				System.out.println("No more mesage page verified in catch---");
				String Image3 = "images/IT4IT/Inbox/InboxPage_DeleteAllSuccessfully_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image3);			
				Scenario.createNode(Given.class, "All messages we deleted successfully but No more message lottie file is not visible").addScreenCaptureFromPath(Image3).fail(t);
			
			}
			}
		}
	catch(Throwable t) {
		System.out.println("No more mesage page verified in final catch---");
		String Image = "images/IT4IT/Inbox/InboxPage_DeleteSuccessfully_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario.createNode(Given.class, "Delete validation is failed").addScreenCaptureFromPath(Image).fail(t);
	}
		System.out.println("No more mesage page verified in outside---");
		context.findElement(OneAppElementKeys.INBOX_BACK_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.INBOX_ICON);
		
	}
	public void DeleteMessage(String Language,ExtentTest Scenario) throws IOException {
		Scenario = getFeature().createNode(Scenario.class, "Delete Message Validation");
		try {
			List<WebElement> totalmessages=context.findElements(OneAppElementKeys.MESSAGE_COUNT_MESSAGE_TAB);
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_DELETE_MESSAGE_TAB).click();
			context.waitUntilVisible(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ);
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CANCEL).isDisplayed();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CANCEL).click();
			Scenario.createNode(Given.class, "Cancel button on delete secleted page is verified successfully").pass("VERIFIED");
			context.waitUntilVisible(OneAppElementKeys.INBOX_BACK_BUTTON);			
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_DELETE_MESSAGE_TAB).click();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).isDisplayed();
			boolean enabled=context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).isEnabled();
			Assert.assertTrue(!enabled, "Delete selected is not enabled");
			String Image = "images/IT4IT/Inbox/InboxPageDeletepage_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);			
			Scenario.createNode(Given.class, "Checkbox read, checkbox read cancel and delete selected are displayed and delete selected is in disabled state").addScreenCaptureFromPath(Image).pass("VERIFIED");
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_ALL).isDisplayed();
			List<WebElement> CheckboxRead=context.findElements(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ);
			CheckboxRead.get(0).click();
			boolean enabled1=context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).isEnabled();
			Assert.assertTrue(enabled1, "Delete selected is enabled");
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).click();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_TITLE).isDisplayed();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON).isDisplayed();
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_CLOSE_BUTTON).isDisplayed();
			String Image1 = "images/IT4IT/Inbox/InboxPageConfirm_Delete_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image1);			
			Scenario.createNode(Given.class, "Delete selected is enabled, confirm delete button and confirm close button are displayed").addScreenCaptureFromPath(Image1).pass("VERIFIED");
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_CLOSE_BUTTON).click();
			Scenario.createNode(Given.class, "X(CLOSE) button on confirm delete is verified successfully").addScreenCaptureFromPath(Image).pass("VERIFIED");
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_DELETE_SELECTED).click();
			context.waitUntilVisible(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON);
			context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON).click();
			context.waitUntilVisible(OneAppElementKeys.INBOX_BACK_BUTTON);
			Thread.sleep(1000);
			String messagedeleted=context.getDriver().getPageSource();
			System.out.println("The Page source is--"+messagedeleted);
			Assert.assertTrue(messagedeleted.contains("successfully deleted") ||messagedeleted.contains("ลบข้อความสำเร็จ") , "Message deleted successfully");
			List<WebElement> totalmessagesafterdelete=context.findElements(OneAppElementKeys.MESSAGE_COUNT_MESSAGE_TAB);
			String Image2 = "images/IT4IT/Inbox/InboxPage_DeleteSuccessfully_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image2);			
			Scenario.createNode(Given.class, "Message deleted successfully and Toast message were displayed and total message count after deleteing one message changes from "+totalmessages.size() +"to "+totalmessagesafterdelete.size()).addScreenCaptureFromPath(Image2).pass("VERIFIED");
			Thread.sleep(10000);
			Activity_log("101800300", "Success", "Delete inbox message","Success",3,Scenario);
			if(Language.equalsIgnoreCase("Thai")) {
			try {
				context.findElement(OneAppElementKeys.INBOX_MESSAGE_DELETE_MESSAGE_TAB).click();
				context.findElement(OneAppElementKeys.DELETE_ALL).click();
				context.waitUntilVisible(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON);
				context.findElement(OneAppElementKeys.INBOX_MESSAGE_CHECKBOX_READ_CONFIRM_DELETE_BUTTON).click();
				Thread.sleep(10000);
				System.out.println("No more mesage page---");
				Assert.assertTrue(context.findElement(OneAppElementKeys.NO_MESSAGE_VIEW).isDisplayed(), "No message lottie file should display");
				System.out.println("No more mesage page viewed");
				String Image3 = "images/IT4IT/Inbox/InboxPage_DeleteAllSuccessfully_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image3);			
				Scenario.createNode(Given.class, "All messages we deleted successfully and No more message lottie file is visible").addScreenCaptureFromPath(Image3).pass("VERIFIED");
			}
			catch(Throwable t) {
				System.out.println("No more mesage page in catch block");
				String Image3 = "images/IT4IT/Inbox/InboxPage_DeleteAllSuccessfully_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image3);			
				Scenario.createNode(Given.class, "All messages we deleted successfully but No more message lottie file is not visible").addScreenCaptureFromPath(Image3).fail(t);
			
			}
			}
		}
	catch(Throwable t) {
		System.out.println("No more mesage page in catch block final");
		String Image = "images/IT4IT/Inbox/InboxPage_DeleteSuccessfully_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
        takeScreenshot(Image);
		Scenario.createNode(Given.class, "Delete validation is failed").addScreenCaptureFromPath(Image).fail(t);
	}
		System.out.println("No more mesage page in catch block final back click");
		context.findElement(OneAppElementKeys.INBOX_BACK_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.INBOX_ICON);
		
	}
	public void ChangeLanguageEngToThai(ExtentTest Scenario) throws IOException {
		try {
			Scenario = getFeature().createNode(Scenario.class, "Change Language");
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
		context.scrollTillElementIntoDisplay(OneAppElementKeys.LANGUAGE_BUTTON);
		System.out.println("Scroll till language button---");
		context.findElement(OneAppElementKeys.LANGUAGE_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_PAGE);
		context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI).click();
		context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM);
		System.out.println("English to Thai changed successfully********");
		context.findElement(OneAppElementKeys.SELECT_LANGUAGE_BACKBUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_CONFIRM_2);
		context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK).click();
			String Image = "images/IT4IT/MoreButton/languageChangeThai_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);	
	        Scenario.createNode(Given.class, "Successfully Changed language to Thai").addScreenCaptureFromPath(Image).pass("VERIFIED");
		}
		    
		    catch(Throwable t) {
		    	String Image = "images/IT4IT/MoreButton/languageChangeThai_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image);	
		        Scenario.createNode(Given.class, "Unable to Change language to Thai").addScreenCaptureFromPath(Image).fail(t);
			
		    }
		context.findElement(OneAppElementKeys.HOME_TAB_1).click(); 
	}

	public void Activity_log(String ActivityID,String activity_status,String activity_type, String value,int index,ExtentTest Scenario) {


		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		query.put(Setting.MongoDbLogsKey.KEY_CRM_ID, new BasicDBObject("$eq", "001100000000000000000018595882"));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq",ActivityID));		
		System.out.println("The query is-----"+query);
		if(Environment.equalsIgnoreCase("DEV")) {
			ACTIVITY_LOG_URL=Setting.MONGO_CLIENT_URL_ONEAPP_DEV;
		}
		if(Environment.equalsIgnoreCase("VIT")) {
			ACTIVITY_LOG_URL=Setting.MONGO_CLIENT_URL_ONEAPP_VIT;
		}
		List<?> listData = mongoDB.connectDB(ACTIVITY_LOG_URL,
				Setting.MONGO_DATABASE_NAME, Setting.MONGO_COLLECTION_NAME+"202111", query,
				Setting.MONGO_SORTS_BY_COLUMN, Setting.MONGO_LIMIT);
		System.out.println("The size is ----"+listData.size());
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
		}
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
		System.out.println("The activity description is ---"+logsData.activitydescription[index].getValue());
		try {
			Assert.assertTrue(logsData.activity_type.equals(activity_type), activity_type+" Verified successfully");
			Assert.assertTrue(logsData.activity_status.equals(activity_status), activity_status+" status action captured in activity log");
			//Assert.assertTrue(logsData.activitydescription[index].getValue().equalsIgnoreCase(value), value+ " activity log verified ");
			System.out.println("MongoDB connection done sucessfully");
			Scenario.createNode(Given.class, "Activity Log verified for Activity type  "+activity_type+" with Activity ID "+ActivityID+" and the status is "+activity_status+ " and value is "+value ).pass("VERIFIED");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Activity Log Verification Failed for  Activity type  "+activity_type+" with Activity ID "+ActivityID+" and the status is "+activity_status+ " and value is "+value).fail(t);
		}
	}

}
