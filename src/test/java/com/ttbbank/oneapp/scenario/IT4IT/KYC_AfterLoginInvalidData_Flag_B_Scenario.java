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
import org.testng.Assert;
import org.testng.annotations.Test;


public class KYC_AfterLoginInvalidData_Flag_B_Scenario extends BaseScenario {
	TtbTestContext context;
	public static ExtentTest Scenario1;
	public static String Environment="DEV";
	public static String ACTIVITY_LOG_URL;

    @Test(groups = "KYC Verify after login with invalid data with flag B")
    public void KYC_Review_AfterLogin_InvalidData_Flag_B() throws InterruptedException, IOException {

    	context = getTtbTestContext();


		try {

			context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
			ExtentTest Scenario = getFeature().createNode(Scenario.class,"Application Launch");
			String Image = "images/IT4IT/KYCBID/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario.createNode(Given.class, "Application launched successfully").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t) {
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Application Launch");
			String Image = "images/IT4IT/KYCBID/logged_in_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario.createNode(Given.class, "Application unable to launch").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			context.findElement(OneAppElementKeys.MORE_TAB).click();
			context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
			context.findElement(OneAppElementKeys.SETTING_TAB).click();
			Registerttb();
			Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
			String Image = "images/IT4IT/KYCBID/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario1.createNode(Given.class, "Register ttb successfully").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			Scenario1 = getFeature().createNode(Scenario.class, "Register ttb");
			String Image = "images/IT4IT/KYCBID/Register_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario1.createNode(Given.class, "Register ttb was unsuccessfully").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			//context.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();	
			context.waitUntilVisible(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON);
			String Image = "images/IT4IT/KYCBID/App_Tutorial"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario1.createNode(Given.class, "App Tutorial loaded Successfully").addScreenCaptureFromPath(Image).pass("PASS");	
		}
		catch(Throwable t) {
			String Image = "images/IT4IT/KYCBID/App_Tutorial"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
			takeScreenshot(Image);
			Scenario1.createNode(Given.class, "App tutorial not loaded successfully").addScreenCaptureFromPath(Image).fail(t);			
		}
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();
		Thread.sleep(2000);
		context.findElement(OneAppElementKeys.NEXT_INTRO_HOME_BUTTON).click();	
		Thread.sleep(2000);
		context.getDriver().closeApp();
		Thread.sleep(3000);
		context.getDriver().launchApp();
	
		// context.findElement(OneAppElementKeys.ALLOW_NOTIFICATION_HOME_BUTTON).click();
try {
		context.waitUntilVisible(OneAppElementKeys.MORE_TAB);
		context.findElement(OneAppElementKeys.MORE_TAB).click();
		context.waitUntilVisible(OneAppElementKeys.SETTING_TAB);
		context.findElement(OneAppElementKeys.SETTING_TAB).click();
		enterPin();
		context.waitUntilVisible(OneAppElementKeys.KYC_PAGE);
		String Image = "images/IT4IT/KYCBID/KYC_I_PAGE"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		takeScreenshot(Image);
		Scenario1.createNode(Given.class, "After Clicking on setting tab KYC page loaded successfully").addScreenCaptureFromPath(Image).pass("PASS");			
}
catch(Throwable t) {
	String Image = "images/IT4IT/KYCBID/KYC_I_PAGE"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	takeScreenshot(Image);
	Scenario1.createNode(Given.class, "After Clicking on setting tab KYC page not loaded").addScreenCaptureFromPath(Image).fail(t);			
}

		try {
		context.findElement(OneAppElementKeys.KYC_PAGE).click();
		confirmPin();
		Thread.sleep(2000);
		Activity_log("001100000000000000000012189007","100000100","Verify Current PIN","Success"," KYC_VERIFY_PIN_STATUS",0,Scenario1);
		context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_MISSING_DETAILS);
	    context.waitUntilVisible(OneAppElementKeys.KYC_PAGE_REQUIRED_FILED);
		String Image = "images/IT4IT/KYCBID/KYC_I_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
		takeScreenshot(Image);
		Scenario1.createNode(Given.class, "Personal Information page inside KYC page successfully loaded for CRM ID set to flag B with invalid data").addScreenCaptureFromPath(Image).pass("PASS");			

	}
catch(Throwable t) {
	String Image = "images/IT4IT/KYCBID/KYC_B_"+new SimpleDateFormat("HHmmss").format(new Date())+".png";
	takeScreenshot(Image);
	Scenario1.createNode(Given.class, "Unable to load Personal Information page for CRM ID set to flag B with invalid data").addScreenCaptureFromPath(Image).fail(t);			
}
		System.out.println("App Removing");
		context.getDriver().closeApp();
		context.getDriver().removeApp("com.ttbbank.oneapp.vit");
		System.out.println("App Removed");
	}
	public void Activity_log(String crm_id,String ActivityID,String activity_type,String activity_status, String value,int index,ExtentTest Scenario) {


		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		query.put(Setting.MongoDbLogsKey.KEY_CRM_ID, new BasicDBObject("$eq", crm_id));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq",ActivityID));		
		System.out.println("The query is-----"+query);
		if(Environment.equalsIgnoreCase("DEV")) {
			ACTIVITY_LOG_URL=Setting.MONGO_CLIENT_URL_ONEAPP_DEV;
		}
		if(Environment.equalsIgnoreCase("VIT")) {
			ACTIVITY_LOG_URL=Setting.MONGO_CLIENT_URL_ONEAPP_VIT;
		}
		List<?> listData = mongoDB.connectDB(ACTIVITY_LOG_URL,
				Setting.MONGO_DATABASE_NAME, Setting.MONGO_COLLECTION_NAME+"202112", query,
				Setting.MONGO_SORTS_BY_COLUMN, Setting.MONGO_LIMIT);
		System.out.println("The size is ----"+listData.size());
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
		}
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(1)), LoginLogsModel.class);
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
 	
      
     
        
    }



