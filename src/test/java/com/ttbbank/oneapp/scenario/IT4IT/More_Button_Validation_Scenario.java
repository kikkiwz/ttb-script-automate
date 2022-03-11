package com.ttbbank.oneapp.scenario.IT4IT;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.google.gson.Gson;
import com.itextpdf.text.log.SysoCounter;
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

public class More_Button_Validation_Scenario extends BaseScenario {
	TtbTestContext context;
	public static ExtentTest Scenario1;
	public static ExtentTest Scenario2;
	public static ExtentTest Scenario3;
	public String StartTime;
	public String Endtime;
	public static String Environment="VIT";
	public static String ACTIVITY_LOG_URL;
	@Test(groups = "More Button Validation")
	public void More_button_validation() throws InterruptedException, IOException {
		//DateFormat date =new DateFormat();
		
		StartTime =new  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date());	
		System.out.println("The start time is"+StartTime);
		try {
			context = getTtbTestContext();
			context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
			System.out.println("More button visible");
			ExtentTest Scenario = getFeature().createNode(Scenario.class,"Launching of Application "+Environment);
			String Image = "images/IT4IT/MoreButton/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario.createNode(Given.class, "Application launched successfully "+Environment).addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Application Launch");
			String Image = "images/IT4IT/MoreButton/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario.createNode(Given.class, "Unable to launch Application on "+Environment).addScreenCaptureFromPath(Image).fail(t);
		}
		Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
		try {
				context.findElement(OneAppElementKeys.MORE_TAB).click();
				System.out.println("More button Clicked");
				context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
				context.waitUntilVisible(OneAppElementKeys.EXPLORE_NOW);
				context.findElement(OneAppElementKeys.SETTING_TAB).click();
				Registerttb();
				String Image = "images/IT4IT/MoreButton/RegisterTTB_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image);
				Scenario1.createNode(Given.class, "Register ttb successfully using SIM bypass with default OTP 111111").addScreenCaptureFromPath(Image).pass("PASS");	
				}
				catch(Throwable t) {
					String Image = "images/IT4IT/MoreButton/RegisterTTB_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			        takeScreenshot(Image);
					Scenario1.createNode(Given.class, "Register ttb was unsuccessfully using SIM bypass with default OTP 111111").addScreenCaptureFromPath(Image).fail(t);	
				}
			try {
				Thread.sleep(2000);
				
				//context.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();	
				context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);
				String Image ="images/IT4IT/MoreButton/AppTutorail_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image);
				Scenario1.createNode(Given.class, "App Tutorial loaded Successfully").addScreenCaptureFromPath(Image).pass("PASS");	
				}
				catch(Throwable t) {
					String Image = "images/IT4IT/MoreButton/AppTutorail_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			        takeScreenshot(Image);
					Scenario1.createNode(Given.class, "App tutorial not loaded successfully").addScreenCaptureFromPath(Image).fail(t);	
			
				}
		Scenario2 = getFeature().createNode(Scenario.class, "More Button Validation");
				context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
				context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
				context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();		
				context.waitUntilVisible(OneAppElementKeys.QUICK_BALANCE);
				MoreButton_Validation("English");
				ChangeLanguageEngToThai();
				MoreButton_Validation("Thai");
	}
	public void ChangeLanguageEngToThai() throws IOException {
		try {
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
			Scenario2.createNode(Given.class, "Successfully Changed language to Thai").addScreenCaptureFromPath(Image).pass("VERIFIED");
		}
		    
		    catch(Throwable t) {
		    	String Image = "images/IT4IT/MoreButton/languageChangeThai_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image);	
				Scenario2.createNode(Given.class, "Unable to Change language to Thai").addScreenCaptureFromPath(Image).fail(t);
			
		    }
		  
	}
	
	public void MoreButton_Validation(String Language) throws IOException, InterruptedException {
				
				try {
					if(Language.equalsIgnoreCase("English")) {
			context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
			context.findElement(OneAppElementKeys.MORE_TAB).click();
					}
			context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
			context.scrollTillElementIntoDisplay(OneAppElementKeys.LOGGOUT_BUTTON);
			System.out.println("Logout button is visible");
			String Image = "images/IT4IT/MoreButton/Logout_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Naviagted to More Button and Logout button is visible for logged in user").addScreenCaptureFromPath(Image).pass("VERIFIED");			
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/MoreButton/Logout_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Naviagted to More Button was unsuccessfull").addScreenCaptureFromPath(Image).fail(t);			

		}    

		try {
			
			context.waitUntilVisible(OneAppElementKeys.EXPLORE_NOW);
			System.out.println("Explore now is visible");
			context.findElement(OneAppElementKeys.EXPLORE_NOW).click();
			context.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_MORE);
			String Image = "images/IT4IT/MoreButton/Widget_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Successfully Navigated to widget Library").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/MoreButton/Widget"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Unable to navigate to widget library").addScreenCaptureFromPath(Image).fail(t);			
		}
		context.scrollDown();
		Thread.sleep(3000);
		String pagesource=context.getDriver().getPageSource();
		System.out.println("The page source is \n--"+pagesource);
		if(Language.equalsIgnoreCase("English")) {
		try {
			Assert.assertTrue(pagesource.contains("HIGHLIGHT CAMPAIGN") && pagesource.contains("All ttb products") && pagesource.contains("Fund Search")
					, "Widget Library items present");
			
			String Image = "images/IT4IT/MoreButton/Widget_library"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Successfully verified presence of Highlight Camp, TTb product, Fund Search").addScreenCaptureFromPath(Image).pass("PASS");
		
		}
		catch(Throwable t) {
			String Image1 = "images/IT4IT/MoreButton/WidgetLibrary_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image1);
			Scenario2.createNode(Given.class, "Widget Library verification is unsuccessfull ").addScreenCaptureFromPath(Image1).fail(t);		
		}
		scrollToBottom();
		try {
		Assert.assertTrue(pagesource.contains("Application Tracking"),"Application Tracking should present");
		String Image = "images/IT4IT/MoreButton/Widget_library"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		takeScreenshot(Image);
		Scenario2.createNode(Given.class, "Application Tracking presence verified").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/MoreButton/Widget_library"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Application Tracking is missing").addScreenCaptureFromPath(Image).fail("FAIL");	
		}
		}
		if(Language.equalsIgnoreCase("Thai")) {
			try {
				Assert.assertTrue(pagesource.contains("แคมเปญแนะนำ") && pagesource.contains("ผลิตภัณฑ์ของทีทีบี") && pagesource.contains("ค้นหากองทุน"),"Widget Library items present");
				
				String Image = "images/IT4IT/MoreButton/WidgetLibrary_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				takeScreenshot(Image);
				Scenario2.createNode(Given.class, "Successfully verified presence of Highlight Camp, TTb product, Fund Search").addScreenCaptureFromPath(Image).pass("PASS");
			}
			catch(Throwable t) {
				String Image1 = "images/IT4IT/MoreButton/WidgetLibrary_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				takeScreenshot(Image1);
				Scenario2.createNode(Given.class, "Widget Library verification is unsuccessfull on Thai Language ").addScreenCaptureFromPath(Image1).fail(t);		
			}
			scrollToBottom();
			try {
				Assert.assertTrue(pagesource.contains("สถานะการสมัคร"),"Application Tracking should present");
				String Image = "images/IT4IT/MoreButton/Widget_library"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				takeScreenshot(Image);
				Scenario2.createNode(Given.class, "Application Tracking presence verified").addScreenCaptureFromPath(Image).pass("PASS");
				}
				catch(Throwable t) {
					String Image = "images/IT4IT/MoreButton/Widget_library"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
					takeScreenshot(Image);
					Scenario2.createNode(Given.class, "Application Tracking is missing").addScreenCaptureFromPath(Image).fail("FAIL");	
				}
			}
		List<WebElement> Widget_library_list=context.findElements(OneAppElementKeys.WIDGET_LIBRARY_MORE_ID);

		try {
			int j=0;
			int k=0;
			for(int i=0;i<Widget_library_list.size();i++) {	
				Widget_library_list=context.findElements(OneAppElementKeys.WIDGET_LIBRARY_MORE_ID);
				String widgetname=Widget_library_list.get(i).getText();
				Widget_library_list.get(i).click();
				context.waitUntilVisible(OneAppElementKeys.VERIFY_LANDED_WIDGET_PAGE);
				Boolean isEnabled=context.findElement(OneAppElementKeys.ADD_TO_HOME_PAGE).isEnabled();

				if(isEnabled && j==0) {
					context.findElement(OneAppElementKeys.ADD_TO_HOME_PAGE).click();
					Thread.sleep(2000);
					context.waitUntilVisible(OneAppElementKeys.SUCCESSFULLY_ADDED);
					context.waitUntilVisible(OneAppElementKeys.RETURN_HOME);
					context.waitUntilVisible(OneAppElementKeys.EXPLORE_OTHER_WIDGET);
					//Date date1 =new Date();
					Endtime = new  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date());
					System.out.println("The End time is--"+Endtime);

					String Image1 = "images/IT4IT/MoreButton/AddedHomepage_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
					takeScreenshot(Image1);		
					Scenario2.createNode(Given.class, "Widget Added successfully").addScreenCaptureFromPath(Image1).pass("PASS");	
					Activity_log("101800200","Success","Set up Widget");
					j++;
					context.findElement(OneAppElementKeys.EXPLORE_OTHER_WIDGET).click();				
				}
				else if(isEnabled) {
					context.findElement(OneAppElementKeys.WIDGET_BACK).click();
				}
				else if(!isEnabled) {
					String pagesource2=context.getDriver().getPageSource();
					Assert.assertTrue(pagesource2.contains("Installed") || pagesource2.contains("ติดตั้งแล้ว"),"Installed view Display");
					String Image1 ="images/IT4IT/MoreButton/AddedHomePage"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
					takeScreenshot(Image1);		
					Scenario2.createNode(Given.class, "Add to Home page is disabled for " +widgetname+" widget and Installed view tab is present").addScreenCaptureFromPath(Image1).pass("VERIFIED");
					k++;
					context.findElement(OneAppElementKeys.WIDGET_BACK).click();					
				}
				if(j>0 && k>0) {
					break;
				}
			}

			context.findElement(OneAppElementKeys.WIDGET_BACK).click();
		}
		catch(Throwable t) {
			String Image1 = "images/IT4IT/MoreButton/WidgetLibrary_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image1);
			Scenario2.createNode(Given.class, "Widget Library verification is unsuccessfull").addScreenCaptureFromPath(Image1).fail(t);		
		}
     	context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.scrollTillElementIntoDisplay(OneAppElementKeys.LOGGOUT_BUTTON);
		context.findElement(OneAppElementKeys.LOGGOUT_BUTTON).click();
		context.waitUntilVisible(OneAppElementKeys.LOGGOUT_BUTTON_OK);
		context.findElement(OneAppElementKeys.LOGGOUT_BUTTON_OK).click();					

		try {
			context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
			context.findElement(OneAppElementKeys.MORE_TAB).click();
			scrollToBottom();
			String PageSource=context.getDriver().getPageSource();
			Assert.assertTrue(!PageSource.contains("Log out"), "Logout button should not display");
			String Image2 = "images/IT4IT/MoreButton/Logout_notVisible"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image2);			
			Scenario2.createNode(Given.class, "Logout button not visible for not logged in user").addScreenCaptureFromPath(Image2).pass("VERIFIED");	
		}
		catch(Throwable t) {
			String Image2 = "images/IT4IT/MoreButton/LogoutVisible"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image2);			
			Scenario2.createNode(Given.class, "Logout button visible for not logged in user").addScreenCaptureFromPath(Image2).fail(t);	
	
		}
		try {
			context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
			context.findElement(OneAppElementKeys.SETTING_TAB).click();		
			Thread.sleep(2000);
			try {
			context.findElement(OneAppElementKeys.PIN_CANCEL).click();
			context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
			Scenario2.createNode(Given.class, "After Clicking on X button on Enter pin screen It naviagets backs to More Screen").pass("VERIFIED");
			}
			catch(Exception e) {
				Scenario2.createNode(Given.class, "X button not working as expected").fail("VERIFIED");
			}
			context.findElement(OneAppElementKeys.SETTING_TAB).click();	
			enterWrongPin();
	    	Thread.sleep(2000);
	    	String Image ="images/IT4IT/MoreButton/WrongPin_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Successfully Enter wrong Pin").addScreenCaptureFromPath(Image).pass("VERIFIED");
	    	Activity_log("100000100","Failure","Log in - Mobile App");
			enterPin();
	    	Thread.sleep(2000);
	    	context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
	    	String Image1 = "images/IT4IT/MoreButton/CorrectPin_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image1);
	    	Scenario2.createNode(Given.class, "Successfully Enter Correct Pin").addScreenCaptureFromPath(Image1).pass("VERIFIED");
	    	Activity_log("100000100","Success","Log in - Mobile App");
			context.findElement(OneAppElementKeys.SELECT_LANGUAGE_RADIOBUTTON_THAI_SETTING_BACK).click();
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/MoreButton/SettingTab_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Setting Tab verification uncessfull").addScreenCaptureFromPath(Image).fail(t);			

		}

		try {
			context.findElement(OneAppElementKeys.APP_GUIDE).click();
			Thread.sleep(10000);
			if(context.isAndroid()) {
				
				String pagesource1=context.getDriver().getPageSource();
				Assert.assertTrue(pagesource1.contains("ค้นหาตามหมวดหมู่"),"App Guide is loaded");
				

			}
			else {
				context.waitUntilVisible(OneAppElementKeys.APP_GUIDE_TITLE);	
			}
			String Image = "images/IT4IT/MoreButton/AppGuide_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "App Guide loaded successfully").addScreenCaptureFromPath(Image).pass("VERIFIED");
		}
		catch(Throwable t)
		{
			String Image = "images/IT4IT/MoreButton/AppGuide_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Unable to load App Guide").addScreenCaptureFromPath(Image).fail(t);

		}
		context.findElement(OneAppElementKeys.MORE_LINKAGE_CLOSE).click();
		context.waitUntilVisible(OneAppElementKeys.APP_GUIDE);
		try {
			context.findElement(OneAppElementKeys.TERMS_AND_CONDITIONS).click();
			Thread.sleep(3000);
			if(context.isAndroid()) {
				ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CON_TITLE_SCREEN);
			}
			else {
				context.waitUntilVisible(OneAppElementKeys.TERM_AND_CONDITION);
			}
			String Image = "images/IT4IT/MoreButton/TandC_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Terms and Conditions loaded successfully").addScreenCaptureFromPath(Image).pass("VERIFIED");
		}
		catch(Throwable t)
		{
			String Image = "images/IT4IT/MoreButton/TandC_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Unable to load Terms and Conditions").addScreenCaptureFromPath(Image).fail(t);

		}
		context.findElement(OneAppElementKeys.MORE_LINKAGE_BACK).click();
		context.waitUntilVisible(OneAppElementKeys.APP_GUIDE);
		try {
			context.findElement(OneAppElementKeys.PRIVACY_AND_SECURITY).click();
			Thread.sleep(15000);
			if(context.isAndroid()) {
				String pagesource1=context.getDriver().getPageSource();
				Assert.assertTrue(pagesource1.contains("Customer Privacy Policy") || pagesource1.contains("นโยบายความเป็นส่วนตัวของลูกค้า"),"Privacy and Security loaded");
			}
			else {
				context.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_PRIVACY_TITLE);
			}
			String Image = "images/IT4IT/MoreButton/Privacy_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Privacy and security loaded successfully").addScreenCaptureFromPath(Image).pass("VERIFIED");
		}
		catch(Throwable t)
		{
			String Image = "images/IT4IT/MoreButton/Privacy_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Unable to load Privacy and security").addScreenCaptureFromPath(Image).fail(t);

		}
		context.findElement(OneAppElementKeys.MORE_LINKAGE_CLOSE).click();
		context.waitUntilVisible(OneAppElementKeys.APP_GUIDE);
		try {
			context.findElement(OneAppElementKeys.HELP_AND_SUPPPORT).click();
			if(Language.equalsIgnoreCase("English")) {
			context.waitUntilVisible(OneAppElementKeys.HELP_AND_SUPPPORT_NEXT);
			context.findElement(OneAppElementKeys.HELP_AND_SUPPPORT_NEXT).click();
			}
			Thread.sleep(15000);
			String pagesource2=context.getDriver().getPageSource();
			Assert.assertTrue(pagesource2.contains("Services") || pagesource2.contains("บริการ"),"Service page is loaded");	
			String Image = "images/IT4IT/MoreButton/Support_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Help and support loaded successfully").addScreenCaptureFromPath(Image).pass("VERIFIED");
		}
		catch(Throwable t)
		{
			String Image = "images/IT4IT/MoreButton/Support_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario2.createNode(Given.class, "Unable to load Help and Support").addScreenCaptureFromPath(Image).fail(t);
		}
	}
	

	
	

	public void Activity_log(String ActivityID,String activity_status,String activity_type) {


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
		try {
			Assert.assertTrue(logsData.activity_type.equals(activity_type), activity_type+" Verified successfully");
			Assert.assertTrue(logsData.activity_status.equals(activity_status), activity_status+" status action captured in activity log");
			System.out.println("MongoDB connection done sucessfully");
			Scenario2.createNode(Given.class, "Activity Log verified for Activity type  "+activity_type+" with Activity ID "+ActivityID+" and the status is "+activity_status ).pass("VERIFIED");
		}
		catch(Throwable t){
			Scenario2.createNode(Given.class, "Activity Log Verification Failed for  Activity type  "+activity_type+" with Activity ID "+ActivityID+" and the status is "+activity_status).fail(t);
		}
	}


}
