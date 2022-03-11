package com.tmb.automation.test.it4it.sprint22.s8275;


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

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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

public class CreateProductShortcut extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public ExtentReports extentReports;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		Date date =new Date();
		StartTime = date.getTime();
		driver = initializeDriver();
		Thread.sleep(3000);
		Extentreportfeature();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
		String Environment=prop.getProperty("Environment");
		//String Environment="uat";
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
		}

			////////////////////////////////////////////// login///////////////////////////////////////////////////

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
			
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Loging validation");
			String Image = "images/logged_in.png";
	        takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Logged in successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).pass("pass");
	      

		}

		@Test(dataProvider="getExcelData",description="Create Product Shortcut",priority=1)
		public void CreateProductShortcut(String login,String password) throws InterruptedException, IOException {

			// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
			mapData = Helper.testData("TestData_it4it_sp11", this.getClass().getSimpleName());
			CCAdmin_CreateProductShortcut CreateProdshort = new CCAdmin_CreateProductShortcut(driver);
			CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
			String dirpath = System.getProperty("user.dir");

			// GotoProduct Info
			page.waitVisible(page.getBtn_Admin(), 20);
			page.click(page.getBtn_Admin());
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Navigating to create product shortcut page");
			Scenario.createNode(Given.class, "clicked on Admin Tab").pass("pass");
			page.click(CreateProdshort.getBtn_product());
			page.click(CreateProdshort.getBtn_CreateProductShortcut());
			page.waitVisible(CreateProdshort.getBtn_newproductshortcut(), 5);
			Thread.sleep(2000);
			page.click(CreateProdshort.getBtn_newproductshortcut());
			Scenario.createNode(Given.class, "clicked on Product Shortcut").pass("pass");
			page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);
			page.click(CreateProdshort.getBtn_CreateShrortcutCancelbutton());
			page.waitVisible(CreateProdshort.getBtn_newproductshortcut(), 5);
			page.click(CreateProdshort.getBtn_newproductshortcut());
			String Image3 = "images/Product_Shortcut_page.png";
	        takeScreenshot(Image3, driver);
			Scenario.createNode(Given.class, "clicked on New Product Shortcut").addScreenCaptureFromPath(Image3).pass("pass");
			page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);		
			WebElement ShortcutID=CreateProdshort.getBtn_ShortcutID();
			WebElement ShortcutNameTH=CreateProdshort.getBtn_ShortcutThaiName();
			WebElement ShortcutNameEN=CreateProdshort.getBtn_ShortcutENGName();
			WebElement ShortcutDescription=CreateProdshort.getBtn_ShortcutDescription();
			Assert.assertFalse(ShortcutID.getAttribute("value").equals(""));
			Assert.assertTrue(ShortcutNameTH.getAttribute("value").equals(""));
			Assert.assertTrue(ShortcutNameEN.getAttribute("value").equals(""));
			Assert.assertTrue(ShortcutDescription.getAttribute("value").equals(""));
			page.enter_text(CreateProdshort.getBtn_ShortcutThaiName(), "TMB Shortcut in Thai");
			page.enter_text(CreateProdshort.getBtn_ShortcutENGName(), "TMB Shortcut in Eng");
			page.enter_text(CreateProdshort.getBtn_ShortcutDescription(), "This shortcut icon is created for testing purpose through automation");
			WebElement redMandatorymark=CreateProdshort.getBtn_CreateShrortcutRedMandatorymark();
			WebElement Addbutton=CreateProdshort.getBtn_CreateShrortcutAddbutton();
			String Colour=redMandatorymark.getCssValue("color");	    
			Assert.assertEquals(Colour, "rgba(255, 0, 0, 1)");
			boolean IsEnaabled=Addbutton.isEnabled();
			Assert.assertEquals(IsEnaabled, false);
			Thread.sleep(3000);
			ExtentTest Scenario2 = getFeature().createNode(Scenario.class, "Filling and verifying the details");
			Scenario2.createNode(Given.class, "Filled all The required details").pass("pass");
			WebElement uploadfile=CreateProdshort.getBtn_CreateShrortcutBrowsebutton();
			uploadfile.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Story_8275_wrong.png");
			page.waitVisible(CreateProdshort.getBtn_CreateShrortcutBrowsebuttonWrongformat(), 5);
			String Image1 = "images/Wrong_image.png";
	        takeScreenshot(Image1, driver);
			Scenario2.createNode(Given.class, "Verified Error Message for uploading wrong image").addScreenCaptureFromPath(Image1).pass("pass");
			WebElement uploadfile2=CreateProdshort.getBtn_CreateShrortcutBrowsebutton();
			uploadfile2.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Shortcut_img1.png");
			Thread.sleep(3000);
			WebElement Addbutton2=CreateProdshort.getBtn_CreateShrortcutAddbutton();
			Assert.assertTrue(CreateProdshort.getBtn_CreateShrortcutAddbutton().isEnabled(),"The add button is enabled successfully");
			String Image2 = "images/Filled_Data.png";
	        takeScreenshot(Image2, driver);
			Scenario2.createNode(Given.class, "Verified the successfull upload of image").addScreenCaptureFromPath(Image2).pass("pass");
			page.waitclickable(Addbutton2, 60);
			page.click(CreateProdshort.getBtn_CreateShrortcutAddbutton());	
			Thread.sleep(3000);
			ExtentTest Scenario3 = getFeature().createNode(Scenario.class, "Adding product shortcut");
			String Image = "images/Create_Product_Shortcut.png";
	        takeScreenshot(Image, driver);
			Scenario3.createNode(Given.class, "Successfuly Added New product Shortcut").addScreenCaptureFromPath(Image).pass("pass");
		}


		//@Test(priority=2)
		public void CaptureActivityLogs_CreateShortcut() throws InterruptedException {
			Date date =new Date();
			Endtime = date.getTime();
			ActivityLogs_cancel();
			ActivityLogs_Add();

			Thread.sleep(5000);

		}

		@AfterClass
		public void closebrowser() {
			driver.quit();
			if (getExtent() != null)
	           getExtent().flush();
			


		}

		public void ActivityLogs_Add() {
			String username = mapData.get("username");
			MongoDB mongoDB = new MongoDB();
			BasicDBObject query = new BasicDBObject();
			query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", username));
			query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9003013"));
			query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
			System.out.println("The query is-----"+query);
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_UAT,
					Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+"202110", query,
					Setting.MONGO_SORTS_BY_COLUMN_VIT, Setting.MONGO_LIMIT);
			System.out.println("The size for add  is ----"+listData.size());
			for(int i=0;i<listData.size();i++) {
				System.out.println("The data is----"+listData.get(i));
			}
			Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
			LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
			Assert.assertTrue(logsData.activity_type.equals("Create Product Shortcut"), "Save action captured in activity log");
			Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
			System.out.println("MongoDB connection done sucessfully");



		}
		public void ActivityLogs_cancel() {
			String username = mapData.get("username");
			MongoDB mongoDB = new MongoDB();
			BasicDBObject query = new BasicDBObject();
			query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", username));
			query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9000002"));
			query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
			System.out.println("The query is-----"+query);
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_UAT,
					Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+"202110", query,
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




		@DataProvider
		public  Object[][] getExcelData() throws IOException
		{
			Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "CreateProductShortcut");
			return Data;


		}



	}
