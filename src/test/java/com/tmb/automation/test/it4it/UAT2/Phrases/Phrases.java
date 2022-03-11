package com.tmb.automation.test.it4it.UAT2.Phrases;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.web.CCAdmin_GetAllPhrasesDashboard;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.util.ActivityLogWeb;
import com.tmb.automation.util.Base;

public class Phrases extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public static String finalkey;
	public static String KeyName;
	CCAdmin_GetAllPhrasesDashboard getallphrases;
	CCAdmin_Home_Page page;
	String dirpath = System.getProperty("user.dir");

	@BeforeClass
	public void ReportGenerate() {
		Extentreportfeature();	
	}

	public void initialize(String Sheetname) throws IOException, InterruptedException {
		Date date =new Date();
		StartTime = date.getTime();
		driver = initializeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page = new CCAdmin_Home_Page(driver);
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

		mapData = Helper.testData("TestData_it4it_sp11",Sheetname);
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
		String Image = "images/IT4IT/Phrases/logged_in.png";
		takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Logged in successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).pass("pass");
	}

	@Test(dataProvider="getExcelData",description="Validate Phrases with Admin role",priority=1)
	public void ProductShortcut_Validation_Admin(String login,String password) throws Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////

		initialize("IT4IT_Admin");
		verify_Dashboard("Verify Dashboard for Admin Role");


	}
	@Test(dataProvider="getExcelData",description="Validate Phrases with Super Admin role",priority=2)
	public void ProductShortcut_Validation_SuperAdmin(String login,String password) throws Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////

		initialize("IT4IT");
		verify_Dashboard("Verify Dashboard for Super Admin Role");
		Create_Phrases();
		Edit_Phrase();
		Approve_Publish_Phrases();

	}

	public void verify_Dashboard(String Scenarioname) throws InterruptedException, ParseException, IOException {
		page = new CCAdmin_Home_Page(driver);
		getallphrases = new CCAdmin_GetAllPhrasesDashboard(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, Scenarioname);
		try {
			page.waitVisible(page.getBtn_Admin(), 20);
			page.click(page.getBtn_Admin());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			page.click(getallphrases.getBtn_newphrases());
			//page.waitVisible(getallphrases.getBtn_Selectmoduledropdown(), 5);
			Thread.sleep(2000);
			String Image = "images/IT4IT/Phrases/Phrases_Page.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully loaded T-Phrase page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Page.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to load T-Prase page").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			Thread.sleep(5000);
			Assert.assertTrue(getallphrases.getBtn_Selectmoduledropdown().isEnabled(), "The Module dropdown is enabled");
			Assert.assertTrue(!getallphrases.getBtn_SearchKeyword().isEnabled(), "The Search Keyword is disabled");
			Assert.assertTrue(!getallphrases.getbtn_Search().isEnabled(), "The Search is disabled");
			Assert.assertTrue(!getallphrases.getbtn_Clear().isEnabled(), "The Clear button is disabled");
			Assert.assertTrue(!getallphrases.getbtn_NewPhrase().isEnabled(), "The new phrases is disabled");

			if(Scenarioname.contains("Super Admin")) {
				Assert.assertTrue(getallphrases.getbtn_WaitForApproval().isEnabled(), "The Wait for approval is Enable");	
				String Image = "images/IT4IT/Phrases/Phrases_Dashboard_header.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Verified the search Keyword, new phrases and clear button are disabled for super admin role and  Wait for approval is Enabled").addScreenCaptureFromPath(Image).pass("PASS");
			}
			else {
				Assert.assertFalse(getallphrases.getbtn_WaitForApproval().isEnabled(), "The Wait for approval is Enable");		
				String Image = "images/IT4IT/Phrases/Phrases_Dashboard_header.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Verified the search Keyword, new phrases and clear button are disabled for super admin role and  Wait for approval is Disabled").addScreenCaptureFromPath(Image).pass("PASS");

			}
		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Dashboard_header.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of dashboard is failed for T-Phrases").addScreenCaptureFromPath(Image).fail(t);
		}

		try
		{
			getallphrases.getBtn_Selectmoduledropdown().click();
			Actions action= new Actions(driver);
			WebElement ModuleNameAll=getallphrases.getBtn_SelectmoduledropdownAll();
			do {
				action.sendKeys(Keys.ARROW_DOWN).perform();
			} while (!ModuleNameAll.isDisplayed());
			ModuleNameAll.click();

			page.waitVisible(getallphrases.getBtn_Module(), 5);
			Assert.assertTrue(getallphrases.getBtn_SearchKeyword().isEnabled(), "The Search Keyword is Enabled");		
			Assert.assertTrue(getallphrases.getbtn_Clear().isEnabled(), "The Clear button is Enabled");
			Assert.assertTrue(getallphrases.getbtn_NewPhrase().isEnabled(), "The new phrases is Enabled");
			String Image = "images/IT4IT/Phrases/Phrases_Dashboard_header_Enabled.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "After Selecting module name Search, Clear and new phrases got enabled").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Dashboard_header_Enabled.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "After selecting module name button not get enabled").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			getallphrases.getBtn_SearchKeyword().sendKeys("test");
			Thread.sleep(2000);
			Assert.assertTrue(getallphrases.getbtn_Search().isEnabled(), "The Searchbutton is Enabled");
			Assert.assertTrue(getallphrases.getBtn_Module().isDisplayed(), "The Module is Displayed");
			Assert.assertTrue(getallphrases.getBtn_Key().isDisplayed(), "The Key is Displayed");
			Assert.assertTrue(getallphrases.getBtn_NameEN().isDisplayed(), "The NameEN is Displayed");
			Assert.assertTrue(getallphrases.getBtn_NameTH().isDisplayed(), "The NameTH is Displayed");
			Assert.assertTrue(getallphrases.getBtn_LastUpdate().isDisplayed(), "The LastUpdate is Displayed");
			Assert.assertTrue(getallphrases.getBtn_UpdateBy().isDisplayed(), "The UpdateBy is Displayed");
			Assert.assertTrue(getallphrases.getBtn_Status().isDisplayed(), "The Status is Displayed");
			Assert.assertTrue(getallphrases.getBtn_Publish_Date().isDisplayed(), "The PublishDate is Displayed");

			String Image = "images/IT4IT/Phrases/Phrases_Dashboard_header_Search.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "T-Phrases Header verified").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Dashboard_header_Search.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "T-Phrases Header verification failed").addScreenCaptureFromPath(Image).fail(t);
		}

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getallphrases.getbtn_next());
			Assert.assertTrue(getallphrases.getbtn_next().isEnabled(), "The Next button is Enabled");		
			Assert.assertTrue(!getallphrases.getbtn_previous().isEnabled(), "The previous button should disabled");
			getallphrases.getbtn_secondtab().click();
			Thread.sleep(2000);
			Assert.assertTrue(getallphrases.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(getallphrases.getbtn_previous().isEnabled(), "The previous button should Enable");
			getallphrases.getbtn_firsttab().click();
			Thread.sleep(2000);
			Assert.assertTrue(getallphrases.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(!getallphrases.getbtn_previous().isEnabled(), "The previous button should Disable");
			String Image = "images/IT4IT/Phrases/Phrases_Page_Pagination.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully verified pagination").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Page_Pagination.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Pagination is failed").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			((JavascriptExecutor) driver)
			.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			SimpleDateFormat   lastupdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(getallphrases.getBtn_Date1().getText());
			System.out.println(getallphrases.getBtn_Date2().getText());		
			Date d1 = lastupdate.parse(getallphrases.getBtn_Date1().getText());
			Date d2 = lastupdate.parse(getallphrases.getBtn_Date2().getText());
			Date d3 = lastupdate.parse(getallphrases.getBtn_Date3().getText());
			Assert.assertTrue(d1.after(d2)|| d1.equals(d2),"The dates are shorted newest to oldest");
			Assert.assertTrue(d2.after(d3) || d2.equals(d3),"The dates are shorted newest to oldest");
			String Image = "images/IT4IT/Phrases/Phrases_Page_sorting_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Page_sorting_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are not sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).fail(t);
		}


	}
	public void Create_Phrases() throws InterruptedException, IOException {
		Date date =new Date();
		StartTime = date.getTime();
		page = new CCAdmin_Home_Page(driver);
		getallphrases = new CCAdmin_GetAllPhrasesDashboard(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Create New Product Phrases");
		try {
			String Key1="abcdef_";
			int character = (int)Math.floor(Math.random() * 899999999 + 123456789);
			System.out.println("The integer ID--"+character);
			String randomnumberString=String.valueOf(character);
			finalkey=Key1+randomnumberString;			
			getallphrases.getBtn_SelectmoduledropdownAll().click();
			Actions action= new Actions(driver);
			WebElement ModuleNameAlt=getallphrases.getBtn_SelectmoduledropdownAlt();
			do {
				action.sendKeys(Keys.ARROW_DOWN).perform();
			} while (!ModuleNameAlt.isDisplayed());
			ModuleNameAlt.click();
			page.waitVisible(getallphrases.getBtn_Module(), 5);
			page.click(getallphrases.getbtn_NewPhrase());
			page.waitVisible(getallphrases.getNew_Phrase_ModuleNames(), 5);
			Assert.assertTrue(!getallphrases.getNew_Phrase_ModuleNames().isEnabled(), "Module name other than All is not enabled");
			page.click(getallphrases.getbtn_cancelPhrase());
			String Image = "images/IT4IT/Phrases/Phrases_Page_ModulenameDisabled.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Module Name is in Disabled state if I select module name other than 'All'").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Page_ModulenameDisabled.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Module Name is in Enabled state if I select module name other than 'All'").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			page.waitVisible(getallphrases.getBtn_SelectmoduledropdownAlt(), 5);
			getallphrases.getBtn_SelectmoduledropdownAlt().click();
			Actions action= new Actions(driver);
			WebElement ModuleNameAll=getallphrases.getBtn_SelectmoduledropdownAll();
			do {
				action.sendKeys(Keys.ARROW_DOWN).perform();
			} while (!ModuleNameAll.isDisplayed());
			ModuleNameAll.click();
			page.waitVisible(getallphrases.getBtn_Module(), 5);
			Thread.sleep(5000);
			KeyName=getallphrases.getbtn_ExistingKey().getText();
			System.out.println("The Key name is---"+KeyName);
			page.click(getallphrases.getbtn_NewPhrase());
			page.waitVisible(getallphrases.getNew_Phrase_ModuleNames(), 5);
			Assert.assertTrue(getallphrases.getNew_Phrase_ModuleNames().isEnabled(), "Module name  All is  enabled");
			Assert.assertTrue(!getallphrases.getbtn_AddPhrase().isEnabled(), "Add button is not enabled");
			Assert.assertTrue(getallphrases.getbtn_PhraseKey().isDisplayed(), "Key Phrase is displayed");
			Assert.assertTrue(getallphrases.getbtn_EnglishPhrase().isDisplayed(), "English Phrase is displayed");
			Assert.assertTrue(getallphrases.getbtn_ThaiPhrase().isDisplayed(), "Thai Phrase is displayed");
			String Image = "images/IT4IT/Phrases/Phrases_Page_ModulenameEnabled.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Module Name is in Enabled state if I select module name as 'All' with Key Phrase English Phrase and Thai Phrase are displayed").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Page_ModulenameEnabled.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "No New Phrase page is displayed").addScreenCaptureFromPath(Image).fail(t);
		}
		try
		{
			Select modulename_newphrase=new Select(getallphrases.getNew_Phrase_ModuleNames());
			modulename_newphrase.selectByIndex(3);		
			getallphrases.getbtn_InputKey().sendKeys("Automation_Error*");
			page.waitVisible(getallphrases.getbtn_Err_MSG_01(), 5);
			String Image = "images/IT4IT/Phrases/Phrases_Key_Error1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "*Key should contains English lowercase alphabets only Error message displayed").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Key_Error1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "No Error Message Displayed for entering upper case").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			page.clearvalue(getallphrases.getbtn_InputKey());
			getallphrases.getbtn_InputKey().sendKeys(KeyName);
			page.click(getallphrases.getbtn_textthPhrase());
			page.waitVisible(getallphrases.getbtn_Err_MSG_02(), 5);
			String Image = "images/IT4IT/Phrases/Phrases_Key_Error2.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "*Please don't put an existing Key Error message displayed").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Key_Error2.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "No Error Message Displayed for entering Duplicate Key").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			page.clearvalue(getallphrases.getbtn_InputKey());
			getallphrases.getbtn_InputKey().sendKeys(finalkey);
			getallphrases.getbtn_textthPhrase().sendKeys("โปรดใช้เบอร์มือถือที่คุณลงทะเบียนไว้กับทางธนาคาร หากต้องการเปลี่ยนเบอร์มือถือ คุณสามารถเปลี่ยนได้ที่ตู้เอทีเอ็มหรือที่สาขาของทีทีบี");
			getallphrases.getbtn_textengPhrase().sendKeys("Please enter the name in english");       
			Assert.assertTrue(getallphrases.getbtn_AddPhrase().isEnabled(), "Add button is enabled");
			page.click(getallphrases.getbtn_AddPhrase());
			Thread.sleep(5000);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9003008","Create Product Phrases","Success",StartTime,0,"Add Product Phrases",Scenario,"Activity Log captured after clicking on save button from Create new T-Phrases");
			String NewKeyName=getallphrases.getbtn_ExistingKey().getText();
			Assert.assertEquals(NewKeyName, finalkey);
			String Image = "images/IT4IT/Phrases/Phrases_Created.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully created new phrase").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Created.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to create new phrase").addScreenCaptureFromPath(Image).fail(t);
		}
	}


	public void Edit_Phrase() throws InterruptedException, IOException {
		Date date =new Date();
		StartTime = date.getTime();
		page = new CCAdmin_Home_Page(driver);
		getallphrases = new CCAdmin_GetAllPhrasesDashboard(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Edit Phrases");
		try
		{
			page.click(getallphrases.getbtn_EditPhrase());
			page.waitVisible(getallphrases.getNew_Phrase_ModuleNames(), 5);
			Assert.assertTrue(!getallphrases.getNew_Phrase_ModuleNames().isEnabled(), "Module name other than All is not enabled");
			page.click(getallphrases.getbtn_cancelPhrase());
			Thread.sleep(2000);
			page.click(getallphrases.getbtn_EditPhrase());
			page.waitVisible(getallphrases.getNew_Phrase_ModuleNames(), 5);
			Assert.assertTrue(!getallphrases.getbtn_InputKey().getAttribute("value").equals(""), "Key Value is disabled");
			Assert.assertTrue(!getallphrases.getNew_Phrase_ModuleNames().isEnabled(), "ModuleName is disabled");
			Assert.assertTrue(!getallphrases.getbtn_SavePhrase().isEnabled(), "Save button is enabled");
			Assert.assertTrue(getallphrases.getbtn_PhraseKey().isDisplayed(), "Key Phrase is displayed");
			Assert.assertTrue(getallphrases.getbtn_EnglishPhrase().isDisplayed(), "English Phrase is displayed");
			Assert.assertTrue(getallphrases.getbtn_ThaiPhrase().isDisplayed(), "Thai Phrase is displayed");
			getallphrases.getbtn_textthPhrase().sendKeys("abc1234");
			getallphrases.getbtn_textengPhrase().sendKeys("englishEdited");       
			Assert.assertTrue(getallphrases.getbtn_SavePhrase().isEnabled(), "Save button is enabled");
			String Key=getallphrases.getbtn_InputKey().getAttribute("value");
			page.click(getallphrases.getbtn_SavePhrase());
			Thread.sleep(2000);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9003008","Create Product Phrases","Success",StartTime,0,"Add Product Phrases",Scenario,"Activity Log captured after clicking on save button from Edit T-Phrases");
			page.waitVisible(getallphrases.getBtn_Module(), 5);
			Thread.sleep(5000);
			String EngText=driver.findElement(By.xpath("//div[text()='" +Key +"\']/../../td[3]")).getText();
			String ThText=driver.findElement(By.xpath("//div[text()='" +Key +"\']/../../td[4]")).getText();
			Assert.assertTrue(EngText.contains("englishEdited") && ThText.contains("abc1234"),"The Phrases are edited");
			String Image = "images/IT4IT/Phrases/Phrases_Edited.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Edited phrases").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/Phrases/Phrases_Edited.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Phrases edited was unsuccessfull").addScreenCaptureFromPath(Image).fail(t);
		}
	}

	public void Approve_Publish_Phrases() throws Exception, InterruptedException {
		Date date1 =new Date();
		StartTime = date1.getTime();
		getallphrases = new CCAdmin_GetAllPhrasesDashboard(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Approve and Publish T-Phrases");
		System.out.println("The number of approvals are---"+getallphrases.getBtn_WaitforApproval().getText());
		if(!getallphrases.getBtn_WaitforApproval().getText().contains("( 0 )") && getallphrases.getBtn_WaitforApproval().isEnabled()) {
			try {
				page.waitVisible(getallphrases.getBtn_WaitforApproval(),5);
				page.click(getallphrases.getBtn_WaitforApproval());
				page.waitVisible(getallphrases.getbtn_WaitApproveKey(),5);
				String Image = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Loaded Wait for approval page").addScreenCaptureFromPath(Image).pass("PASS");

			}
			catch(Throwable t){
				String Image = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Wait for approval page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
			}

			String KeyValue= page.gettextvalue(getallphrases.getbtn_WaitApproveKey());
			WebElement Approvebutton=getallphrases.getBtn_Approve();
			boolean IsEnaabled=Approvebutton.isEnabled();
			System.out.println("-----------------"+IsEnaabled);
			Assert.assertEquals(IsEnaabled, false);
			String Image = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval_ApproveButton.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Approve button is in disabled state").addScreenCaptureFromPath(Image).pass("PASS");
			try {
				page.click(getallphrases.getBtn_DateButton());
				page.waitVisible(getallphrases.getBtn_selectdate(),5);
				page.click(getallphrases.getBtn_selectdate());
				Approvebutton.click();		
				// Verify Error Message of Time as well as set current time
				page.waitVisible(getallphrases.getBtn_ErrorMessage(),5);
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,80)"," ");
				String Errormessage= page.gettextvalue(getallphrases.getBtn_ErrorMessage());
				Assert.assertTrue(Errormessage.equalsIgnoreCase("Please select Date & Time greater than Current Date & Time"), "Error message doesn't displayed or might be changes with some other text");
				String Image1 = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval_Error_message.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Error message is displayed 'Please select Date & Time greater than Current Date & Time'").addScreenCaptureFromPath(Image1).pass("PASS");

			}catch(Throwable t){
				String Image1 = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval_Error_message.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "No Error message is displayed after clicking on approve button without selecting time").addScreenCaptureFromPath(Image1).fail(t);	
			}
			Thread.sleep(2000);
			try {
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
				System.out.println("The final hour string is--"+finalhourtring);
				page.select_by_value(getallphrases.getBtn_selecthour(), finalhourtring);
				page.select_by_value(getallphrases.getBtn_selectminute(), finalminutestring);
				boolean IsEnaablednow=Approvebutton.isEnabled();
				System.out.println("-----------------"+IsEnaablednow);
				Assert.assertEquals(IsEnaablednow, true);
				String Image1 = "images/IT4IT/Phrases/ProductShortcut_Page_WaitforApproval_enabled.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Successfully entered correct date and time and approve button is enabled").addScreenCaptureFromPath(Image1).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/Phrases/ProductShortcut_Page_WaitforApproval_enabled.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Entering correct date and time is unsuccessfull").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				Approvebutton.click();
				page.waitVisible(getallphrases.getBtn_Approvepopup(), 10);
				String Image1 = "images/IT4IT/Phrases/ProductShortcut_Page_WaitforApproval_Approvepopup.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Approve pop-up is visible").addScreenCaptureFromPath(Image1).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/Phrases/ProductShortcut_Page_WaitforApproval_Approvepopup.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Approve popup is not visible").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				page.click(getallphrases.getbtn_Approvepopup_cancel());	
				Thread.sleep(2000);
				Thread.sleep(2000);
				ActivityLogWeb activitylog=new ActivityLogWeb();
				activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Approve Phrases Cancel",Scenario,"Activity Log captured after clicking on close icon X from Approve Product Shortcut page");					
				String Image1 = "images/IT4IT/Phrases/ProductShortcut_Page_WaitforApproval_Approvepopup_cancel.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Cancel button is clicked successfully on approve pop-up ").addScreenCaptureFromPath(Image1).pass("PASS");
				Thread.sleep(1000);
				Approvebutton=getallphrases.getBtn_Approve();
				Approvebutton.click();
				page.waitVisible(getallphrases.getBtn_Approvepopup(), 10);
				page.click(getallphrases.getBtn_Approvepopup());
				Thread.sleep(2000);
				activitylog.ActivityLog("9003009","Approve for Publish","Success",StartTime,0,"Product config",Scenario,"Activity Log captured after clicking on Yes button from Approve T-Phrases page");	
			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/Phrases/ProductShortcut_Page_WaitforApproval_Approvepopup_cancel.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Cancel button is not clicked successfully").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				Thread.sleep(5000);
				page.waitVisible(getallphrases.getbtn_Approvepopup_cancel(), 10);
				page.click(getallphrases.getbtn_Approvepopup_cancel());
				Thread.sleep(5000);
				WebElement BackPhrase=getallphrases.getbtn_BackPhrase();
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BackPhrase);
				BackPhrase.click();
				Thread.sleep(2000);
				WebElement Approved =driver.findElement(By.xpath("//div[text()='" +KeyValue +"\']/../../td[7]/div"));		
				String ApprovedText=Approved.getText();
				Assert.assertTrue(ApprovedText.equalsIgnoreCase("Approved") || ApprovedText.equalsIgnoreCase("Published"), "The Status is not in approved state");
				String Image1 = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval_Approved.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Successfully phrases Approved").addScreenCaptureFromPath(Image1).pass("PASS");
				Thread.sleep(900000);
				page.click(getallphrases.getBtn_LastUpdate());
				Thread.sleep(5000);
				page.click(getallphrases.getBtn_LastUpdate());
				Thread.sleep(5000);
				Thread.sleep(50000);
				page.click(getallphrases.getBtn_LastUpdate());
				Thread.sleep(5000);
				page.click(getallphrases.getBtn_LastUpdate());
				Thread.sleep(5000);
				WebElement published =driver.findElement(By.xpath("//div[text()='" +KeyValue +"\']/../../td[7]/div"));		
				String publishedText=published.getText();
				Assert.assertTrue(publishedText.equalsIgnoreCase("Published"), "The Status is not in Published state");	
				String Image2 = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval_Published.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Successfully phrases published").addScreenCaptureFromPath(Image2).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval_Published.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Product Not is not approved or published").addScreenCaptureFromPath(Image1).fail(t);	
			}
		}

		else if(getallphrases.getBtn_WaitforApproval().getText().contains("( 0 )")){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			System.out.println("No Phrases are there to approve");
			String Image1 = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval_No.png";
			takeScreenshot(Image1, driver);
			Scenario.createNode(Given.class, "No product Shortcut is present for approval").addScreenCaptureFromPath(Image1).pass("PASS");

		}
		else if(!getallphrases.getBtn_WaitforApproval().isEnabled()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			System.out.println("Wait for approval is disabled for Super Admin User");
			String Image1 = "images/IT4IT/Phrases/Phrases_Page_WaitforApproval_Disabled.png";
			takeScreenshot(Image1, driver);
			Scenario.createNode(Given.class, "Wait for Approval is in Disabled state for Super Admin Role").addScreenCaptureFromPath(Image1).fail("FAIL");

		}	


	}	

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

	@DataProvider
	public  Object[][] getExcelData() throws IOException
	{
		Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "IT4IT_Admin");
		return Data;


	}



}
