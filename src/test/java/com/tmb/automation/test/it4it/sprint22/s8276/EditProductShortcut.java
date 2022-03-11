package com.tmb.automation.test.it4it.sprint22.s8276;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.google.gson.Gson;
import com.itextpdf.text.log.SysoCounter;
import com.mongodb.BasicDBObject;
import com.tmb.automation.common.MongoDB;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.LoginLogsModel;
import com.tmb.automation.pages.web.CCAdmin_CreateProductShortcut;
import com.tmb.automation.pages.web.CCAdmin_Editproductinfo;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_phases;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.util.Base;

public class EditProductShortcut extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public String Environment;
	public String MongoDBdate;
	private static ExtentTest Scenario1;
	private static ExtentTest Scenario2;
	private static ExtentTest Scenario3;
	private static ExtentTest Scenario4;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
			Date date =new Date();
			StartTime = date.getTime();
			SimpleDateFormat MongoDBdate1 = new SimpleDateFormat("yyyyMM");  
			Date date1 = new Date();  
			MongoDBdate=MongoDBdate1.format(date1);
			System.out.println("MongoDBdate is --"+MongoDBdate);
		driver = initializeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Extentreportfeature();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
		String Environment=prop.getProperty("Environment");
	//	String Environment="uat";
		try {
		if(Environment.equalsIgnoreCase("vit")) {
			String url = prop.getProperty("url_vit");
			driver.get(url);		
			driver.findElement(By.xpath("//button[contains(text(),'     ')]")).click();		
			driver.findElement(By.xpath("//a[contains(text(),'Proceed to cc-vit1.oneapp.tmbbank.local (unsafe)')]"))
			.click();
		}
		else if(Environment.equalsIgnoreCase("dev")) {
			String url = prop.getProperty("url_dev");
			driver.get(url);		
			driver.findElement(By.xpath("//button[contains(text(),'     ')]")).click();		
			driver.findElement(By.xpath("//a[contains(text(),'Proceed to cc-dev1.oneapp.tmbbank.local (unsafe)')]"))
			.click();
		}
		else if(Environment.equalsIgnoreCase("uat")) {
			String url = prop.getProperty("url_uat");
			driver.get(url);		
			driver.findElement(By.xpath("//button[contains(text(),'     ')]")).click();		
			driver.findElement(By.xpath("//a[contains(text(),'Proceed to cc-uat2.oneapp.tmbbank.local (unsafe)')]"))
			.click();
		}		////////////////////////////////////////////// login///////////////////////////////////////////////////

		mapData = Helper.testData("TestData_it4it_sp11", this.getClass().getSimpleName());
		String username = mapData.get("username");
		String password = mapData.get("password");

		// entering usrer name and passwpord
		page.enter_text(page.getIn_username(), username);
		page.enter_text(page.getIn_password(), password);
		Thread.sleep(3000);
		page.waitVisible(page.getBtn_submit(), 20);
		Thread.sleep(1000);
		page.click(page.getBtn_submit());
		Thread.sleep(3000);
		Scenario1 = getFeature().createNode(Scenario.class, "Loging validation");
		String Image = "images/logged_in.png";
        takeScreenshot(Image, driver);
		Scenario1.createNode(Given.class, "Logged in successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Exception e) {
			Scenario1 = getFeature().createNode(Scenario.class, "Loging validation");
			String Image = "images/logged_in.png";
	        takeScreenshot(Image, driver);
			Scenario1.createNode(Given.class, "Login is not  successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).fail("FAIL");
		
		}


	}

	@Test(dataProvider="getExcelData",description="Edit Product Shortcut",priority=1)
	public void EditProductShortcut(String login,String password) throws InterruptedException, IOException {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		mapData = Helper.testData("TestData_it4it_sp11", this.getClass().getSimpleName());
		CCAdmin_CreateProductShortcut CreateProdshort = new CCAdmin_CreateProductShortcut(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);

try {
		// GotoProduct Info
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		page.click(CreateProdshort.getBtn_product());
		page.waitVisible(CreateProdshort.getBtn_CreateProductShortcut(), 5);
		page.click(CreateProdshort.getBtn_CreateProductShortcut());
		page.waitVisible(CreateProdshort.getBtn_EditProductShortcut(), 5);
		Thread.sleep(2000);
		page.click(CreateProdshort.getBtn_EditProductShortcut());
		Scenario2 = getFeature().createNode(Scenario.class, "Navigating to Edit product shortcut page");
		Scenario2.createNode(Given.class, "clicked on Admin Tab").pass("PASS");
}
catch(Exception e) {
	Scenario2 = getFeature().createNode(Scenario.class, "Navigating to Edit product shortcut page");
	Scenario2.createNode(Given.class, "unable to click on Admin Tab").fail("FAIL");
	
}
try {
		page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);
		page.click(CreateProdshort.getBtn_CreateShrortcutCancelbutton());
		Scenario2.createNode(Given.class, "clicked on Product Shortcut").pass("PASS");
}
catch(Exception e) {
	Scenario2.createNode(Given.class, "unable to click on Product Shortcut").fail("FAIL");
}
try {

		page.waitVisible(CreateProdshort.getBtn_EditProductShortcut(), 5);
		page.click(CreateProdshort.getBtn_EditProductShortcut());		
		String Image3 = "images/Edit_Product_Shortcut_page.png";
        takeScreenshot(Image3, driver);
		Scenario2.createNode(Given.class, "clicked on Edit Product Shortcut").addScreenCaptureFromPath(Image3).pass("PASS");		
}
catch(Exception e) {
	String Image3 = "images/Edit_Product_Shortcut_page.png";
    takeScreenshot(Image3, driver);
	Scenario2.createNode(Given.class, "unable to click on Edit Product Shortcut").addScreenCaptureFromPath(Image3).fail("FAIL");		

}
try {
		page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);		
		WebElement ShortcutID=CreateProdshort.getBtn_ShortcutID();
		WebElement ShortcutNameTH=CreateProdshort.getBtn_ShortcutThaiName();
		WebElement ShortcutNameEN=CreateProdshort.getBtn_ShortcutENGName();
		WebElement ShortcutDescription=CreateProdshort.getBtn_ShortcutDescription();
		Assert.assertFalse(ShortcutID.getAttribute("value").equals(""));
		Assert.assertFalse(ShortcutNameTH.getAttribute("value").equals(""));
		Assert.assertFalse(ShortcutNameEN.getAttribute("value").equals(""));
		Assert.assertFalse(ShortcutDescription.getAttribute("value").equals(""));
		page.enter_text(CreateProdshort.getBtn_ShortcutThaiName(), "TMB Shortcut in Thai Edited");
		page.enter_text(CreateProdshort.getBtn_ShortcutENGName(), "TMB Shortcut in Eng Edited");
		page.enter_text(CreateProdshort.getBtn_ShortcutDescription(), "This product shortcut  is edited for testing purpose through automation");
		Scenario3 = getFeature().createNode(Scenario.class, "Editing the details");
		String Image1 = "images/Edit_Details.png";
        takeScreenshot(Image1, driver);	
		Scenario3.createNode(Given.class, "Editing the details").addScreenCaptureFromPath(Image1).pass("PASS");	
}
catch(Exception e) {
	Scenario3 = getFeature().createNode(Scenario.class, "Editing the details");
	String Image1 = "images/Edit_Details.png";
    takeScreenshot(Image1, driver);	
	Scenario3.createNode(Given.class, "unable to Edit the details").addScreenCaptureFromPath(Image1).fail("FAIL");	
}
try {

		WebElement Savebutton=CreateProdshort.getBtn_EditShrortcutsavebutton();
		boolean IsEnaabled=Savebutton.isEnabled();
		Assert.assertEquals(IsEnaabled, true);
		WebElement Binbutton=CreateProdshort.getBtn_EditShrortcutbinbutton();
		Assert.assertTrue(Binbutton.isDisplayed(), "Bin button is missing");
		page.click(CreateProdshort.getBtn_EditShrortcutsavebutton());
		Thread.sleep(2000);
		Scenario4 = getFeature().createNode(Scenario.class, "Details saved successfully");
		String Image = "images/Deatils_saved.png";
        takeScreenshot(Image, driver);	
		Scenario4.createNode(Given.class, "Save button enabled after Editing the details").addScreenCaptureFromPath(Image).pass("PASS");		
}
catch(Throwable t) {
	System.out.println("In catch block");
	Scenario4 = getFeature().createNode(Scenario.class, "Details saved successfully");
	String Image = "images/Deatils_saved.png";
    takeScreenshot(Image, driver);	
	Scenario4.createNode(Given.class, "Save button is not enabled after Editing unable to Edit the details").addScreenCaptureFromPath(Image).fail("FAIL");
	
}

		}
	
	
	//@Test(priority=2)
	public void CaptureActivityLogs_EditProductShortcut() throws InterruptedException {
		Date date =new Date();
		Endtime = date.getTime();
		ActivityLogs_Add();
		ActivityLogs_cancel();	
	}
	
	@AfterClass
	public void closebrowser() {
		driver.quit();
		if (getExtent() != null)
            getExtent().flush();
		

	}
	
	public void ActivityLogs_Add() {
		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", "occ_padmin02"));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9003014"));
		query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
		System.out.println("The query is-----"+query);
		if(Environment.equalsIgnoreCase("vit")) {
		List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_VIT,
				Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+MongoDBdate, query,
				Setting.MONGO_SORTS_BY_COLUMN_VIT, Setting.MONGO_LIMIT);
		System.out.println("The size for add  is ----"+listData.size());
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
			}
		Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
		Assert.assertTrue(logsData.activity_type.equals("Edit Product Shortcut"), "Save action captured in activity log");
		Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
		System.out.println("MongoDB connection done sucessfully");
		}
		else if(Environment.equalsIgnoreCase("dev")) {
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_DEV,
					Setting.MONGO_DATABASE_NAME_DEV, Setting.MONGO_COLLECTION_NAME_DEV+MongoDBdate, query,
					Setting.MONGO_SORTS_BY_COLUMN_DEV, Setting.MONGO_LIMIT);
			System.out.println("The size for add  is ----"+listData.size());
			for(int i=0;i<listData.size();i++) {
				System.out.println("The data is----"+listData.get(i));
				}
			Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
			LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
			Assert.assertTrue(logsData.activity_type.equals("Edit Product Shortcut"), "Save action captured in activity log");
			Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
			System.out.println("MongoDB connection done sucessfully");
			}
		

	}
	public void ActivityLogs_cancel() {
		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", "occ_padmin02"));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9000002"));
		query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
		System.out.println("The query is-----"+query);
		if(Environment.equalsIgnoreCase("vit")) {
		List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_VIT,
				Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+MongoDBdate, query,
				Setting.MONGO_SORTS_BY_COLUMN_VIT, Setting.MONGO_LIMIT);
		
		System.out.println("The size is ----"+listData.size());
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
			}
		Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);

		Assert.assertTrue(logsData.activity_type.equals("Close Pop-up"), "Cancel action captured in activity log");
		Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
		System.out.println("MongoDB connection done sucessfully");
		}
		else if(Environment.equalsIgnoreCase("dev")) {
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_DEV,
					Setting.MONGO_DATABASE_NAME_DEV, Setting.MONGO_COLLECTION_NAME_DEV+MongoDBdate, query,
					Setting.MONGO_SORTS_BY_COLUMN_DEV, Setting.MONGO_LIMIT);
			
			System.out.println("The size is ----"+listData.size());
			for(int i=0;i<listData.size();i++) {
				System.out.println("The data is----"+listData.get(i));
				}
			Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
			LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);

			Assert.assertTrue(logsData.activity_type.equals("Close Pop-up"), "Cancel action captured in activity log");
			Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
			System.out.println("MongoDB connection done sucessfully");
			}
		

	}

	
	
	
	@DataProvider
	public  Object[][] getExcelData() throws IOException
	{
		Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "EditProductShortcut");
		return Data;
		
		
		}
	
	

}
