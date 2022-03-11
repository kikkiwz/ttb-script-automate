package com.tmb.automation.test.it4it.sprint24.s9640;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
import com.tmb.automation.pages.web.CCAdmin_GetAllPhrasesDashboard;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_phases;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.util.Base;

public class CreateandEditPhrases extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public String Environment;
	public String MongoDBdate;
	public Set<Cookie> cookies;
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
		}////////////////////////////////////////////// login///////////////////////////////////////////////////

		mapData = Helper.testData("TestData_it4it_sp11", "IT4IT");
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

	@Test(dataProvider="getExcelData",description="CreatePhrases",priority=1)
	public void CreateAndEditPhrase(String login,String password) throws InterruptedException, ParseException, IOException {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		mapData = Helper.testData("TestData_it4it_sp11", "IT4IT");
		CCAdmin_GetAllPhrasesDashboard getallphrases = new CCAdmin_GetAllPhrasesDashboard(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
		// GotoProduct Info
		String Key1="abcdef_";
		int character = (int)Math.floor(Math.random() * 899999999 + 123456789);
		System.out.println("The product shortcut id integeris--"+character);
		String randomnumberString=String.valueOf(character);
		String finalkey=Key1+randomnumberString;			
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		page.waitVisible(getallphrases.getBtn_newphrases(), 5);
		page.click(getallphrases.getBtn_newphrases());
		page.waitVisible(getallphrases.getBtn_Selectmoduledropdown(), 5);
		Thread.sleep(5000);
		Select modulename=new Select(getallphrases.getBtn_Selectmoduledropdown());
		modulename.selectByIndex(3);
		page.waitVisible(getallphrases.getBtn_Module(), 5);
		page.click(getallphrases.getbtn_NewPhrase());
		page.waitVisible(getallphrases.getNew_Phrase_ModuleNames(), 5);
		Assert.assertTrue(!getallphrases.getNew_Phrase_ModuleNames().isEnabled(), "Module name other than All is not enabled");
		page.click(getallphrases.getbtn_cancelPhrase());
		page.waitVisible(getallphrases.getBtn_Selectmoduledropdown(), 5);
		modulename.selectByIndex(1);
		page.waitVisible(getallphrases.getBtn_Module(), 5);
		Thread.sleep(5000);
		String KeyName=getallphrases.getbtn_ExistingKey().getText();
		System.out.println("The Key name is---"+KeyName);
		page.click(getallphrases.getbtn_NewPhrase());
		page.waitVisible(getallphrases.getNew_Phrase_ModuleNames(), 5);
		Assert.assertTrue(getallphrases.getNew_Phrase_ModuleNames().isEnabled(), "Module name  All is  enabled");
		Assert.assertTrue(!getallphrases.getbtn_AddPhrase().isEnabled(), "Add button is not enabled");
		Assert.assertTrue(getallphrases.getbtn_PhraseKey().isDisplayed(), "Key Phrase is displayed");
		Assert.assertTrue(getallphrases.getbtn_EnglishPhrase().isDisplayed(), "English Phrase is displayed");
		Assert.assertTrue(getallphrases.getbtn_ThaiPhrase().isDisplayed(), "Thai Phrase is displayed");
		Select modulename_newphrase=new Select(getallphrases.getNew_Phrase_ModuleNames());
		modulename_newphrase.selectByIndex(3);		
		getallphrases.getbtn_InputKey().sendKeys("Automation_Error*");
		page.waitVisible(getallphrases.getbtn_Err_MSG_01(), 5);
		page.clearvalue(getallphrases.getbtn_InputKey());
		getallphrases.getbtn_InputKey().sendKeys(KeyName);
		page.click(getallphrases.getbtn_textthPhrase());
		page.waitVisible(getallphrases.getbtn_Err_MSG_02(), 5);
		page.clearvalue(getallphrases.getbtn_InputKey());
		getallphrases.getbtn_InputKey().sendKeys(finalkey);
		getallphrases.getbtn_textthPhrase().sendKeys("โปรดใช้เบอร์มือถือที่คุณลงทะเบียนไว้กับทางธนาคาร หากต้องการเปลี่ยนเบอร์มือถือ คุณสามารถเปลี่ยนได้ที่ตู้เอทีเอ็มหรือที่สาขาของทีทีบี");
        getallphrases.getbtn_textengPhrase().sendKeys("Please enter the name in english");       
        Assert.assertTrue(getallphrases.getbtn_AddPhrase().isEnabled(), "Add button is enabled");
		page.click(getallphrases.getbtn_AddPhrase());
		//page.waitVisible(getallphrases.getBtn_Module(), 5);
		Thread.sleep(2000);
		String NewKeyName=getallphrases.getbtn_ExistingKey().getText();
		Assert.assertEquals(NewKeyName, finalkey);
		Thread.sleep(2000);
		Select modulename2=new Select(getallphrases.getBtn_Selectmoduledropdown());
		modulename2.selectByIndex(2);
		//page.waitVisible(getallphrases.getBtn_Module(), 5);
		Thread.sleep(2000);
		page.click(getallphrases.getbtn_EditPhrase());
		page.waitVisible(getallphrases.getNew_Phrase_ModuleNames(), 5);
		Assert.assertTrue(!getallphrases.getNew_Phrase_ModuleNames().isEnabled(), "Module name other than All is not enabled");
		page.click(getallphrases.getbtn_cancelPhrase());
		page.waitVisible(getallphrases.getBtn_Selectmoduledropdown(), 5);
		Thread.sleep(2000);
		page.click(getallphrases.getbtn_EditPhrase());
		page.waitVisible(getallphrases.getNew_Phrase_ModuleNames(), 5);
		Assert.assertTrue(!getallphrases.getbtn_InputKey().getAttribute("value").equals(""), "Key Value is disabled");
		Assert.assertTrue(!getallphrases.getNew_Phrase_ModuleNames().isEnabled(), "ModuleName is disabled");
		Assert.assertTrue(getallphrases.getbtn_SavePhrase().isEnabled(), "Save button is enabled");
		Assert.assertTrue(getallphrases.getbtn_PhraseKey().isDisplayed(), "Key Phrase is displayed");
		Assert.assertTrue(getallphrases.getbtn_EnglishPhrase().isDisplayed(), "English Phrase is displayed");
		Assert.assertTrue(getallphrases.getbtn_ThaiPhrase().isDisplayed(), "Thai Phrase is displayed");
		getallphrases.getbtn_textthPhrase().sendKeys("abc1234");
        getallphrases.getbtn_textengPhrase().sendKeys("englishEdited");       
        Assert.assertTrue(getallphrases.getbtn_SavePhrase().isEnabled(), "Save button is enabled");
        String Key=getallphrases.getbtn_InputKey().getAttribute("value");
		page.click(getallphrases.getbtn_SavePhrase());
		Thread.sleep(2000);
		page.waitVisible(getallphrases.getBtn_Module(), 5);
		Thread.sleep(5000);
		String EngText=driver.findElement(By.xpath("//div[text()='" +Key +"\']/../../td[3]")).getText();
		String ThText=driver.findElement(By.xpath("//div[text()='" +Key +"\']/../../td[4]")).getText();
		Assert.assertTrue(EngText.contains("englishEdited") && ThText.contains("abc1234"),"The Phrases are edited");
		
	}	
	
	//@Test(priority=2)
	public void CaptureActivityLogs_CreateandEditPhrases() throws InterruptedException {
		Date date =new Date();
		Endtime = date.getTime();
		ActivityLogs_Add();
		ActivityLogs_Add_Edited();
		ActivityLogs_cancel();	
	}
	
	
	@AfterClass
	public void closebrowser() {
		driver.quit();
		

	}
	public void ActivityLogs_Add_Edited() {
		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", "occ_padmin02"));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9003008"));
		query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
		System.out.println("The query is-----"+query);
		if(Environment.equalsIgnoreCase("dev")) {
		List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_DEV,
				Setting.MONGO_DATABASE_NAME_DEV, Setting.MONGO_COLLECTION_NAME_DEV+MongoDBdate, query,
				Setting.MONGO_SORTS_BY_COLUMN_DEV, Setting.MONGO_LIMIT);
		System.out.println("The size for add  is ----"+listData.size());
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
			}
		
		//Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
		Assert.assertTrue(logsData.activity_type.equals("Edit Phrase"), "Save action captured in activity log");
		Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
		System.out.println("MongoDB connection done sucessfully");
		}
		else if(Environment.equalsIgnoreCase("vit")) {
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_VIT,
					Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+MongoDBdate, query,
					Setting.MONGO_SORTS_BY_COLUMN_VIT, Setting.MONGO_LIMIT);
			System.out.println("The size for add  is ----"+listData.size());
			for(int i=0;i<listData.size();i++) {
				System.out.println("The data is----"+listData.get(i));
				}
			
			//Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
			LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
			Assert.assertTrue(logsData.activity_type.equals("Edit Phrase"), "Save action captured in activity log");
			Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
			System.out.println("MongoDB connection done sucessfully");
			}
		

	}
	public void ActivityLogs_Add() {
		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		
		query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", "occ_padmin02"));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9003007"));
		query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
		System.out.println("The query is-----"+query);
		if(Environment.equalsIgnoreCase("dev")) {
		List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_DEV,
				Setting.MONGO_DATABASE_NAME_DEV, Setting.MONGO_COLLECTION_NAME_DEV+MongoDBdate, query,
				Setting.MONGO_SORTS_BY_COLUMN_DEV, Setting.MONGO_LIMIT);
		System.out.println("The size for add  is ----"+listData.size());
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
			}
		//Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
		Assert.assertTrue(logsData.activity_type.equals("Create Phrase"), "Save action captured in activity log");
		Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
		System.out.println("MongoDB connection done sucessfully");
		}
		else if(Environment.equalsIgnoreCase("dev")) {
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_VIT,
					Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+MongoDBdate, query,
					Setting.MONGO_SORTS_BY_COLUMN_VIT, Setting.MONGO_LIMIT);
			System.out.println("The size for add  is ----"+listData.size());
			for(int i=0;i<listData.size();i++) {
				System.out.println("The data is----"+listData.get(i));
				}
			
			//Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
			LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
			Assert.assertTrue(logsData.activity_type.equals("Edit Phrase"), "Save action captured in activity log");
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
		if(Environment.equalsIgnoreCase("dev")) {
		List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_DEV,
				Setting.MONGO_DATABASE_NAME_DEV, Setting.MONGO_COLLECTION_NAME_DEV+"202107", query,
				Setting.MONGO_SORTS_BY_COLUMN_DEV, Setting.MONGO_LIMIT);
		
		System.out.println("The size is ----"+listData.size());
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
			}
		Assert.assertEquals(listData.size(), 2,"The action stored in activity log is more than two");
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);

		Assert.assertTrue(logsData.activity_type.equals("Close Pop-up"), "Cancel action captured in activity log");
		Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
		System.out.println("MongoDB connection done sucessfully");
		}
		else if(Environment.equalsIgnoreCase("VIT")) {
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_VIT,
					Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+MongoDBdate, query,
					Setting.MONGO_SORTS_BY_COLUMN_VIT, Setting.MONGO_LIMIT);
			System.out.println("The size for add  is ----"+listData.size());
			for(int i=0;i<listData.size();i++) {
				System.out.println("The data is----"+listData.get(i));
				}
			
			//Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
			LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
			//Assert.assertTrue(logsData.activity_type.equals("Edit Phrase"), "Save action captured in activity log");
			Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
			System.out.println("MongoDB connection done sucessfully");
			}
		

	}
	
	@DataProvider
	public  Object[][] getExcelData() throws IOException
	{
		Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "IT4IT");
		return Data;
		
		
		}
	
	

}
