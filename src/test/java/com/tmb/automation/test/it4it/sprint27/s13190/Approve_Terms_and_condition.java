package com.tmb.automation.test.it4it.sprint27.s13190;




import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import com.tmb.automation.pages.web.CCAdmin_ProductTermsandConditions;
import com.tmb.automation.pages.web.CCAdmin_phases;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.pages.web.CCAdmin_productinfo;
import com.tmb.automation.util.Base;

public class Approve_Terms_and_condition extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public String Environment;
	public String MongoDBdate;
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
		}	////////////////////////////////////////////// login///////////////////////////////////////////////////

		mapData = Helper.testData("TestData_it4it_sp11", "IT4IT");
		String username = mapData.get("username");
		String password = mapData.get("password");
		// entering usrer name and passwpord
		page.enter_text(page.getIn_username(), username);
		page.enter_text(page.getIn_password(), password);
		//Thread.sleep(3000);
		page.waitVisible(page.getBtn_submit(), 20);
		//Thread.sleep(1000);
		page.click(page.getBtn_submit());
		Thread.sleep(3000);			
		ExtentTest Scenario = getFeature().createNode(Scenario.class, "Loging validation");
		String Image = "images/logged_in.png";
        takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Logged in successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).pass("pass");
     
		

	}

	@Test(dataProvider="getExcelData",description="CreatePhrases",priority=1)
	public void ApproveTermsandConditions(String login,String password) throws InterruptedException, ParseException, IOException {

		mapData = Helper.testData("TestData_it4it_sp11", "IT4IT");
		CCAdmin_ProductTermsandConditions PTermscondition = new CCAdmin_ProductTermsandConditions(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);	
		CCAdmin_productinfo pinfo = new CCAdmin_productinfo(driver);
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		page.waitVisible(PTermscondition.getBtn_product_TermsandCondition(), 5);
		page.click(PTermscondition.getBtn_product_TermsandCondition());
		System.out.println("The number of approvals are---"+pinfo.getBtn_WaitforApproval().getText());
		if(!pinfo.getBtn_WaitforApproval().getText().contains("( 0 )")) {
		page.waitVisible(pinfo.getBtn_WaitforApproval(),5);
		page.click(pinfo.getBtn_WaitforApproval());
		page.waitVisible(PTermscondition.getbtn_WaitApproveKey(),5);
		String ProductTCID= page.gettextvalue(PTermscondition.getbtn_WaitApproveKey());
		WebElement Approvebutton=pinfo.getBtn_Approve();
		boolean IsEnaabled=Approvebutton.isEnabled();
		System.out.println("-----------------"+IsEnaabled);
		Assert.assertEquals(IsEnaabled, false);
		page.click(pinfo.getBtn_DateButton());
		page.waitVisible(pinfo.getBtn_selectdate(),5);
		page.click(pinfo.getBtn_selectdate());
		Approvebutton.click();		
		// Verify Error Message of Time as well as set current time
		page.waitVisible(pinfo.getBtn_ErrorMessage(),5);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,80)"," ");
		String Errormessage= page.gettextvalue(pinfo.getBtn_ErrorMessage());
		Assert.assertTrue(Errormessage.equalsIgnoreCase("Please select Date & Time greater than Current Date & Time"), "Error message doesn't displayed or might be changes with some other text");
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();
		String hour= dateFormat.format(date);
		System.out.println("time in hour is " +hour);
		DateFormat dateFormat2 = new SimpleDateFormat("mm");
		Date date2 = new Date();
		String min= dateFormat2.format(date2);
		System.out.println("time in minute is " +min);
		int miniute=Integer.parseInt(min);
		int hourvalue=Integer.parseInt(hour);
		if(miniute==58 || miniute==59)
		{
			System.out.println("Inside condition where minute is close to 59");
			miniute=01;			
			hourvalue=hourvalue+1;
			if(hourvalue==24) {
				
				hourvalue=00;
			}
			
		}
		String finalminutestring="";
		int finalminute=miniute+2;
		if(finalminute<10) {
			finalminutestring = String.format("%02d" , finalminute);
		}
		else {
		
		finalminutestring=String.valueOf(finalminute);
		}
		
		// Enter perfect time with 2 min ahead and approve
		
		String finalhourtring=String.valueOf(hourvalue);
		page.select_by_value(pinfo.getBtn_selecthour(), finalhourtring);
		page.select_by_value(pinfo.getBtn_selectminute(), finalminutestring);
		boolean IsEnaablednow=Approvebutton.isEnabled();
		System.out.println("-----------------"+IsEnaablednow);
		Assert.assertEquals(IsEnaablednow, true);
		Approvebutton.click();
		page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
		page.click(pinfo.getbtn_Approvepopup_cancel());
		Thread.sleep(1000);
		Approvebutton=pinfo.getBtn_Approve();
		Approvebutton.click();
		page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
		page.click(pinfo.getBtn_Approvepopup());
		page.waitVisible(PTermscondition.gettext_ApprovepopupTermsandCond(), 10);
		page.click(pinfo.getBtn_Closepopup());
		WebElement BackPhrase=PTermscondition.getbtn_BackTermsandCondition();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BackPhrase);
		BackPhrase.click();
		Thread.sleep(2000);
		page.waitVisible(driver.findElement(By.xpath("//div[text()='" +ProductTCID +"\']/../../td[10]/div")), 10);
		WebElement Approved =driver.findElement(By.xpath("//div[text()='" +ProductTCID +"\']/../../td[10]/div"));		
		String ApprovedText=Approved.getText();
		Assert.assertTrue(ApprovedText.equalsIgnoreCase("Approved") || ApprovedText.equalsIgnoreCase("Published"), "The Status is not in approved state");
		}
		else {
			System.out.println("No Phrases are there to approve");
		}	
	}
	//@Test(priority=2)
	public void CaptureActivityLogs_ApproveProductTermsandConditions() throws InterruptedException {
		Date date =new Date();
		Endtime = date.getTime();
		ActivityLogs_Add();	
	}
	
	
	@AfterClass
	public void closebrowser() {
		
		driver.quit();

	}


	public void ActivityLogs_Add() {
		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		
		query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", "occ_padmin02"));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9003006"));
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
		Assert.assertTrue(logsData.activity_type.equals("Approve for Publish"), "Save action captured in activity log");
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
			System.out.println("The data is----"+logsData.activity_type);
			Assert.assertTrue(logsData.activity_type.equals("Approve for Publish"), "Save action captured in activity log");
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
