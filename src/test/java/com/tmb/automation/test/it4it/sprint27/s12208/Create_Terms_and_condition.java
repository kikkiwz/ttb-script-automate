package com.tmb.automation.test.it4it.sprint27.s12208;




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
import com.tmb.automation.util.Base;

public class Create_Terms_and_condition extends Base {
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
		}		////////////////////////////////////////////// login///////////////////////////////////////////////////

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
	public void CreateTermsandConditions(String login,String password) throws InterruptedException, ParseException, IOException {

		mapData = Helper.testData("TestData_it4it_sp11", "IT4IT");
		CCAdmin_ProductTermsandConditions PTermscondition = new CCAdmin_ProductTermsandConditions(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);			
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		//Thread.sleep(5000);
		page.waitVisible(PTermscondition.getBtn_product_TermsandCondition(), 5);
		page.click(PTermscondition.getBtn_product_TermsandCondition());
		page.waitVisible(PTermscondition.getBtn_newproduct_TermsandCondition(), 5);
		page.click(PTermscondition.getBtn_newproduct_TermsandCondition());
		page.waitVisible(PTermscondition.gettext_productcode(),5);
		page.click(PTermscondition.gettext_productcode());
		Robot robot=null;
		try {
			robot = new Robot();
			StringSelection stringSelection = new StringSelection("abcdegghi");
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			
		} catch (AWTException e) {
			System.out.println("unable to enter text");
		}
		String noresultfound=driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(noresultfound.contains("No result found"), "No result found is present");
		System.out.println("the text is---"+noresultfound);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_DELETE);
		StringSelection stringSelection = new StringSelection("home");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);		
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);		
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		assertTrue(!PTermscondition.gettextproduct_Name().getAttribute("value").equals(""), "Product name is not null");
		assertTrue(!PTermscondition.gettextproduct_Name().isEnabled(), "Product name is Disable");
		assertTrue(!PTermscondition.gettextproduct_TCID().getAttribute("value").equals(""), "Product name is not null");
		assertTrue(!PTermscondition.gettextproduct_TCID().isEnabled(), "Product TCID is Disable");
		String ProductTCID=PTermscondition.gettextproduct_TCID().getAttribute("value");
		assertTrue(PTermscondition.gettextproduct_Description().getAttribute("maxlength").equals("255"), "Product Description maximum length is 255");
		page.enter_text(PTermscondition.gettextproduct_Description(),"Automation Testing for Create Terms and Conditions");
	    page.select_by_id(PTermscondition.getProductChannel(), 1);
	    page.click(PTermscondition.getContent_Thai());
	    page.scrollIntoView(PTermscondition.getProductChannel());
	    page.click(PTermscondition.getBrowse_button());
	    Thread.sleep(2000);
	    StringSelection str = new StringSelection(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\Sprint26Story12208\\ข้อกำหนดและเงื่อนไข_more_than_3_MB.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, str);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     Thread.sleep(2000);
	     page.waitVisible(PTermscondition.getbtn_pdf_3MB_error(), 5);
	     page.click(PTermscondition.getBrowse_button());
	     Thread.sleep(2000);
	     StringSelection str2 = new StringSelection(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\Sprint26Story12208\\Terms_and_Conditions_ more_than_40_character.pdf");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str2, null);
		     robot.keyPress(KeyEvent.VK_CONTROL);
		     robot.keyPress(KeyEvent.VK_V);
		     robot.keyRelease(KeyEvent.VK_CONTROL);
		     robot.keyRelease(KeyEvent.VK_V);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		     page.waitVisible(PTermscondition.getbtn_pdf_40_character(), 5);
		     page.click(PTermscondition.getBrowse_button());
		     Thread.sleep(2000);
		     StringSelection str3 = new StringSelection(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\Sprint26Story12208\\Terms_and_Conditions.pdf");
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str3, null);
			     robot.keyPress(KeyEvent.VK_CONTROL);
			     robot.keyPress(KeyEvent.VK_V);
			     robot.keyRelease(KeyEvent.VK_CONTROL);
			     robot.keyRelease(KeyEvent.VK_V);
			     robot.keyPress(KeyEvent.VK_ENTER);
			     robot.keyRelease(KeyEvent.VK_ENTER);
			     page.waitVisible(PTermscondition.btngetUploaded(), 5);		     
			     page.enter_text(PTermscondition.gettext_rich_text_Editor(), " Automation Enter text in thai content");
			     page.click(PTermscondition.getContent_Eng());
			     Thread.sleep(2000);
			     page.enter_text(PTermscondition.gettext_rich_text_Editor(), " Automation Enter text in English content");
			     Thread.sleep(2000);
			     page.scrollIntoView(PTermscondition.getSave_button());
			     assertTrue(PTermscondition.getSave_button().isEnabled(), "Save Button is Enabled");
			    page.click(PTermscondition.getSave_button());
			    page.waitVisible(driver.findElement(By.xpath("//div[text()='" +ProductTCID +"\']/../../td[3]")), 30);
			 
	
	}	
	
	//@Test(priority=2)
	public void CaptureActivityLogs_CreateProductTermsandConditions() throws InterruptedException {
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
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9003002"));
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
		//Assert.assertTrue(logsData.activity_type.equals("Create Phrase"), "Save action captured in activity log");
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
