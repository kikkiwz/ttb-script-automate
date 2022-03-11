package com.tmb.automation.test.it4it.sprint23.s9641;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
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

public class PhraseListDashboard extends Base {
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
		Extentreportfeature();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
		String Environment=prop.getProperty("Environment");
		//String Environment=System.getenv("Environment");
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

		mapData = Helper.testData("TestData_it4it_sp11","IT4IT");
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

	@Test(dataProvider="getExcelData",description="Phrase list Dashboard",priority=1)
	public void ViewPhraseListDashboard(String login,String password) throws InterruptedException, ParseException {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		mapData = Helper.testData("TestData_it4it_sp11","IT4IT");
		CCAdmin_GetAllPhrasesDashboard getallphrases = new CCAdmin_GetAllPhrasesDashboard(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);


		// GotoProduct Info
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		//page.waitVisible(getallphrases.getBtn_newphrases(), 5);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		page.click(getallphrases.getBtn_newphrases());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//page.waitVisible(getallphrases.getBtn_Selectmoduledropdown(), 5);
		Thread.sleep(5000);
		Assert.assertTrue(getallphrases.getBtn_Selectmoduledropdown().isEnabled(), "The Module dropdown is enabled");
		Assert.assertTrue(!getallphrases.getBtn_SearchKeyword().isEnabled(), "The Search Keyword is disabled");
		Assert.assertTrue(!getallphrases.getbtn_Search().isEnabled(), "The Search is disabled");
		Assert.assertTrue(!getallphrases.getbtn_Clear().isEnabled(), "The Clear button is disabled");
		Assert.assertTrue(!getallphrases.getbtn_NewPhrase().isEnabled(), "The new phrases is disabled");
		Assert.assertTrue(getallphrases.getbtn_WaitForApproval().isEnabled(), "The Wait for approval is Enable");
		Select modulename=new Select(getallphrases.getBtn_Selectmoduledropdown());
		modulename.selectByIndex(1);
		page.waitVisible(getallphrases.getBtn_Module(), 5);
		Assert.assertTrue(getallphrases.getBtn_SearchKeyword().isEnabled(), "The Search Keyword is Enabled");		
		Assert.assertTrue(getallphrases.getbtn_Clear().isEnabled(), "The Clear button is Enabled");
		Assert.assertTrue(getallphrases.getbtn_NewPhrase().isEnabled(), "The new phrases is Enabled");
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
		List<WebElement> Status=getallphrases.getBtn_StatusProduct();
		for(int i=0;i<Status.size();i++)
		{			
			Assert.assertTrue(Status.get(i).getText().equalsIgnoreCase("Draft") ||Status.get(i).getText().equalsIgnoreCase("Approved")||Status.get(i).getText().equalsIgnoreCase("Published"),"The status should be draft or Approved or Published");
		
			}
		
		SimpleDateFormat   lastupdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(getallphrases.getBtn_Date1().getText());
		System.out.println(getallphrases.getBtn_Date2().getText());		
		Date d1 = lastupdate.parse(getallphrases.getBtn_Date1().getText());
        Date d2 = lastupdate.parse(getallphrases.getBtn_Date2().getText());
        Date d3 = lastupdate.parse(getallphrases.getBtn_Date3().getText());
        Assert.assertTrue(d1.after(d2)|| d1.equals(d2),"The dates are shorted newest to oldest");
        Assert.assertTrue(d2.after(d3) || d2.equals(d3),"The dates are shorted newest to oldest");
        
		
	}
	
	
	
	@AfterClass
	public void closebrowser() {
		driver.quit();
		

	}
	
	
	

	
	
	
	@DataProvider
	public  Object[][] getExcelData() throws IOException
	{
		Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "IT4IT");
		return Data;
		
		
		}
	
	

}
