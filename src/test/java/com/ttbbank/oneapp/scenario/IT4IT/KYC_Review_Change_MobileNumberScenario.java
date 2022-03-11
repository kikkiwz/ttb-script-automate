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

public class KYC_Review_Change_MobileNumberScenario extends BaseScenario {
	TtbTestContext context;
	public static ExtentTest Scenario1;
	public static ExtentTest Scenario2;
	public static ExtentTest Scenario3;
	public static ExtentTest Scenario4;
	public static String Environment="DEV";
	public static String ACTIVITY_LOG_URL;

	@Test(groups = "KYC verify with change mobile number")
	public void KYC_Review_Change_Mobile_Number() throws InterruptedException, IOException {
		context = getTtbTestContext();	
				    	try {
				    		context = getTtbTestContext();		
				    		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
				    		ExtentTest Scenario = getFeature().createNode(Scenario.class,"Application Launch");
				    		String Image = "images/IT4IT/Mobile/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				            takeScreenshot(Image);
				    		Scenario.createNode(Given.class, "Application launched successfully").addScreenCaptureFromPath(Image).pass("PASS");
				    		}
				    		catch(Throwable t) {
				    			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Application Launch");
				    			String Image = "images/IT4IT/Mobile/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				    	        takeScreenshot(Image);
				    			Scenario.createNode(Given.class, "Application unable to launch").addScreenCaptureFromPath(Image).fail(t);
				    		}
				    		try {
				    		context.findElement(OneAppElementKeys.MORE_TAB).click();
				    		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
				    		context.findElement(OneAppElementKeys.SETTING_TAB).click();
				    		Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
				    		ttbTestContext.waitUntilVisible(OneAppElementKeys.REGISTER_TTB);
				    		String Image1 = "images/IT4IT/Mobile/Proscept_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				            takeScreenshot(Image1);
				    		Scenario1.createNode(Given.class, "Prospect Customer unable to change language").addScreenCaptureFromPath(Image1).pass("VERIFIED");
				    		Registerttb();		
				    		String Image = "images/IT4IT/Mobile/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				            takeScreenshot(Image);
				    		Scenario1.createNode(Given.class, "Register ttb successfully using SIM bypass with default OTP 111111").addScreenCaptureFromPath(Image).pass("PASS");	
				    		}
				    		catch(Throwable t) {
				    			Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
				    			String Image = "images/IT4IT/Mobile/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				    	        takeScreenshot(Image);
				    			Scenario1.createNode(Given.class, "Register ttb was unsuccessfully using SIM bypass with default OTP 111111").addScreenCaptureFromPath(Image).fail(t);	
				    		}
				    		try {		
				    		context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);
				    		String Image ="images/IT4IT/Mobile/APPTutorial_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				            takeScreenshot(Image);
				    		Scenario1.createNode(Given.class, "App Tutorial loaded Successfully").addScreenCaptureFromPath(Image).pass("PASS");	
				    		}
				    		catch(Throwable t) {
				    			String Image = "images/IT4IT/Mobile/APPTutorial_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
				    	        takeScreenshot(Image);
				    			Scenario1.createNode(Given.class, "App tutorial not loaded successfully").addScreenCaptureFromPath(Image).fail(t);	
				    		
				    		}
				    		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
				    		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
				      		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		ChangeMobilenumber("English",Scenario2);
		ChangeLanguageEngToThai(Scenario4);
		ChangeMobilenumber("Thai",Scenario3);

	}
	public void ChangeMobilenumber(String Language,ExtentTest Scenario2) throws IOException, InterruptedException {
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		if(Language.equalsIgnoreCase("English")) {
			Scenario2 = getFeature().createNode(Scenario.class, "Verify Change mobile number in English");
			String Image ="images/IT4IT/Mobile/Applicationloaded_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);		
			Scenario2.createNode(Given.class, "Your Application loaded is in English").addScreenCaptureFromPath(Image).pass("VERIFIED");	
		}
		else {
			Scenario2 = getFeature().createNode(Scenario.class, "Verify Change Mobile Number in Thai");
			String Image ="images/IT4IT/Mobile/Applicationloaded_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);			
			Scenario2.createNode(Given.class, "Your Application loaded is in Thai").addScreenCaptureFromPath(Image).pass("VERIFIED");	

		}
		try {
			
			context.findElement(OneAppElementKeys.MORE_TAB).click();
			context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
			context.findElement(OneAppElementKeys.SETTING_TAB).click();			
			context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
			String Image = "images/IT4IT/Mobile/Setting_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Successfully Navigated to Setting Menu").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Mobile/Setting_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);		
			Scenario2.createNode(Given.class, "Unable to load setting menu").addScreenCaptureFromPath(Image).fail(t);
		}

				String[] MobileKeyword= {"Mobile No.","Telephone", "Change mobile", "Mobile", "Personal Information","โทรศัพท์", "เบอร์โทรศัพท์" ,"เปลี่ยนเบอร์" , "เปลี่ยน" , "เบอร์มือถือ"};   	   
				for(int i=0;i<MobileKeyword.length;i++)
				{
					try { 
						Thread.sleep(2000);
						context.findElement(OneAppElementKeys.SEARCH_BAR).click();
						Thread.sleep(2000);
						context.findElement(OneAppElementKeys.SEARCH_BAR).sendKeys(MobileKeyword[i]);
						context.waitUntilVisible(OneAppElementKeys.LANGUAGE_RESULT_VERIFY);
						List<WebElement> settingmenu=context.findElements(OneAppElementKeys.LANGUAGE_RESULT_VERIFY);
						System.out.println("The Size is ---"+settingmenu.size());
						for(int j=0;j<settingmenu.size(); j++) {   	    	   	    	
							String Mobile_search=context.findElement(OneAppElementKeys.LANGUAGE_RESULT_VERIFY).getText();
							System.out.println("The Text is---"+Mobile_search);
							Thread.sleep(1000);
							if(Mobile_search.equalsIgnoreCase("Mobile No."));
							{
								System.out.println("Mobile search found");	
								break;
							}
						}
						String Image = "images/IT4IT/Mobile/Search_"+i+new SimpleDateFormat("HHmmss").format(new Date())+".png";
						takeScreenshot(Image);	
						Scenario2.createNode(Given.class, "Mobile No. on search result loaded after searching "+MobileKeyword[i]).addScreenCaptureFromPath(Image).pass("VERIFIED");
						Thread.sleep(1000);
						context.findElement(OneAppElementKeys.SEARCH_BAR).clear();
						System.out.println("Verified for "+MobileKeyword[i]);  	    	
					}	
		
					catch(Throwable t) {
						String Image = "images/IT4IT/Mobile/ChangeMobile"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
						takeScreenshot(Image);		
						Scenario2.createNode(Given.class, "Unable to Search Mobile No. on search bar for "+MobileKeyword[i]).addScreenCaptureFromPath(Image).fail(t);
					}	
		
				}
		try {
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
			String Image = "images/IT4IT/Mobile/NoResult"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);		
			Scenario2.createNode(Given.class, "No result found message is displayed for searching any random text").addScreenCaptureFromPath(Image).pass("PASS");
			Thread.sleep(1000);
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Mobile/NoResult"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);		
			Scenario2.createNode(Given.class, "No result found message is not displayed for searching any random text").addScreenCaptureFromPath(Image).fail("t");
		}	
		context.findElement(OneAppElementKeys.SEARCH_BAR).clear();
		try {
			context.findElement(OneAppElementKeys.SEARCH_BAR).click();
			Thread.sleep(2000);
			if(Language.equalsIgnoreCase("English")) {
				context.findElement(OneAppElementKeys.SEARCH_BAR).sendKeys("Mobile No.");
			}
			else {
				context.findElement(OneAppElementKeys.SEARCH_BAR).sendKeys("เบอร์มือถือ");
			}
			Thread.sleep(2000);
			String Mobile_search=context.findElement(OneAppElementKeys.LANGUAGE_RESULT_VERIFY).getText();
			Assert.assertTrue(Mobile_search.equalsIgnoreCase("Mobile No.") || Mobile_search.equalsIgnoreCase("เบอร์มือถือ"), "Mobile tab is view");
			context.findElement(OneAppElementKeys.SEARCH_BAR_X_BUTTON).click();
			context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
			Thread.sleep(1000);
			String Image = "images/IT4IT/Mobile/X_button"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);		
			Scenario2.createNode(Given.class, "X(Clear) button verified Successfully, Setting page loaded after clicking on X button").addScreenCaptureFromPath(Image).pass("PASS");
			Thread.sleep(1000);
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Mobile/X_button"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);		
			Scenario2.createNode(Given.class, "X(Clear) failed to verify").addScreenCaptureFromPath(Image).fail("t");
		}	

		try {	
			context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
			context.findElement(OneAppElementKeys.EXISTING_NUMBER).click();
			context.waitUntilVisible(OneAppElementKeys.KYC_PAGE);			
			String Image = "images/IT4IT/Mobile/Mobile_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Successfully Navigated to KYC Page").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Mobile/Mobile_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Unable to load KYC page").addScreenCaptureFromPath(Image).fail(t);

		}
		try {
			context.getDriver().navigate().back();
			context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
			Scenario2.createNode(Given.class, "After clicking on back button on KYC Page it navigates to setting menu page").pass("PASS");
			context.findElement(OneAppElementKeys.EXISTING_NUMBER).click();
			context.waitUntilVisible(OneAppElementKeys.KYC_PAGE);	
		}
		catch(Throwable t) {
			
			Scenario2.createNode(Given.class, "Back Button validation failed").fail(t);

		}
		
		try {
			Thread.sleep(2000);
			context.findElement(OneAppElementKeys.KYC_PAGE).click();
			if(context.isAndroid()) {
				confirmPin();
				Thread.sleep(10000);
				Activity_log("100000100","Log in - Mobile App","Success"," KYC_VERIFY_PIN_STATUS",0,Scenario2);
			}
			else {
				enterPin();
			}
			context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS);
			Thread.sleep(2000);
			System.out.println("KYC page is visible");
			context.scrollTillElementIntoDisplay(OneAppElementKeys.KYC_PAGE_DETAILS_BOTTOM);
			Thread.sleep(10000);
			System.out.println("Scrolled till bottom");
			context.findElement(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE).click();
			System.out.println("Clicked on edit button");
			String Image = "images/IT4IT/Mobile/KYC_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Successfully Navigated to KYC Page").addScreenCaptureFromPath(Image).pass("PASS");


		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Mobile/KYC_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Unable to load KYC page").addScreenCaptureFromPath(Image).fail(t);

		}
		try {
		context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER);
		WebElement OTP= context.findElement(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_INPUT);
		OTP.click();
		Thread.sleep(2000);
		ttbTestContext.getDriver().getKeyboard().sendKeys("099-371-4030");
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER).click();
		context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM);
		context.findElement(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM).click();
		context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_CONFIRM);
		ttbTestContext.getDriver().getKeyboard().sendKeys("111111");
		context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_WRONGMSG);
		String Image = "images/IT4IT/Mobile/KYC_OTP_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		takeScreenshot(Image);	
		Scenario2.createNode(Given.class, "Successfully Entered the wrong OTP and Error msg is viewed").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/Mobile/KYC_OTP_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);	
			Scenario2.createNode(Given.class, "Unable to view the error message for entering wrong message").addScreenCaptureFromPath(Image).fail(t);

		}
		try {
			context.getDriver().navigate().back();
			Thread.sleep(1000);
			context.getDriver().navigate().back();
			context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS);
			Thread.sleep(2000);
			System.out.println("KYC page is visible");
			context.scrollTillElementIntoDisplay(OneAppElementKeys.KYC_PAGE_CANCEL);
			Thread.sleep(10000);
			System.out.println("Scrolled till bottom");
			context.findElement(OneAppElementKeys.KYC_PAGE_CANCEL).click();
			context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_CANCEL_CONFIRM);
			context.findElement(OneAppElementKeys.KYC_PAGE_CANCEL_CONFIRM).click();
			context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
			String Image = "images/IT4IT/Mobile/KYC_BACK_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);	
	        Scenario2.createNode(Given.class, "Successfully verified back button on each page and successfuly navigated to setting menu").addScreenCaptureFromPath(Image).pass("PASS");
			
			
		}
		 catch(Throwable t) {
		    	String Image = "images/IT4IT/Mobile/KYC_BACK_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image);	
		        Scenario2.createNode(Given.class, "Verification of back button is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);
			
		    }


	} 
	public void ChangeLanguageEngToThai(ExtentTest Scenario) throws IOException {
				try {
			
		Scenario = getFeature().createNode(Scenario.class, "Change Language");
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
			String Image = "images/IT4IT/Mobile/languageChangeThai_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	        takeScreenshot(Image);	
	        Scenario.createNode(Given.class, "Successfully Changed language to Thai").addScreenCaptureFromPath(Image).pass("VERIFIED");
		}
		    
		    catch(Throwable t) {
		    	String Image = "images/IT4IT/Mobile/languageChangeThai_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		        takeScreenshot(Image);	
		        Scenario.createNode(Given.class, "Unable to Change language to Thai").addScreenCaptureFromPath(Image).fail(t);
			
		    }
		
	}


	public void Activity_log(String ActivityID,String activity_type,String activity_status, String value,int index,ExtentTest Scenario) {


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
			Assert.assertTrue(logsData.activitydescription[index].getValue().equalsIgnoreCase(value), value+ " activity log verified ");
			System.out.println("MongoDB connection done sucessfully");
			Scenario.createNode(Given.class, "Activity Log verified for Activity type  "+activity_type+" with Activity ID "+ActivityID+" and the status is "+activity_status+ " and value is "+logsData.activitydescription[index].getValue() ).pass("VERIFIED");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Activity Log Verification Failed for  Activity type  "+activity_type+" with Activity ID "+ActivityID+" and the status is "+activity_status+ " and value is "+logsData.activitydescription[index].getValue() + "but the value should be "+value).fail(t);
		}
	}



























	/*TtbTestContext context = getTtbTestContext();
        //context.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        Registerttb();
        Thread.sleep(2000);
        context.getDriver().closeApp();
        Thread.sleep(2000);
        context.getDriver().launchApp();
        Thread.sleep(2000);
        context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);
        context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
        context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
        context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
        context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
        context.findElement(OneAppElementKeys.SETTING_TAB).click();
        enterPin();
        context.waitUntilVisible(OneAppElementKeys.EXISTING_NUMBER);
        context.findElement(OneAppElementKeys.EXISTING_NUMBER).click();
        context.waitUntilVisible(OneAppElementKeys.KYC_PAGE);
        context.findElement(OneAppElementKeys.KYC_PAGE).click();
        if(context.isAndroid()) {
        	confirmPin();
        }
        else {
        	enterPin();
        }
        context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS);
        context.scrollTillElementIntoDisplay(OneAppElementKeys.KYC_PAGE_DETAILS_BOTTOM);
        //context.findElement(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE).click();
//        context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER);
//        WebElement OTP= context.findElement(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_INPUT);
//        OTP.sendKeys("099-371-4030");
//        context.findElement(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER).click();
//        context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM);
//        context.findElement(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_MOBILENUMBER_CONFIRM).click();
//        context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_CONFIRM);
//        List<WebElement> inputOTP=context.findElements(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_INPUT);
//        for(int i=0;i<=5;i++) { 
//        	inputOTP.get(i).sendKeys("9");	
//        }
//        context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_DETAILS_EDIT_MOBILE_OTP_WRONGMSG);
//        



	 */      





}
