package com.tmb.automation.test.it4it.sprint32.s22389;




import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_bankinfo;
import com.tmb.automation.util.Base;

public class BankInfo_Dashboard extends Base {
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

	@Test(dataProvider="getExcelData",description="Bank info list Dashboard",priority=1)
	public void ViewBankinfoDashboard(String login,String password) throws InterruptedException, ParseException {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		mapData = Helper.testData("TestData_it4it_sp11","IT4IT");
		CCAdmin_bankinfo getBankInfo = new CCAdmin_bankinfo(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);


		// GotoBank Info
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		page.click(getBankInfo.getBtn_Bankinfo());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(getBankInfo.getbtn_orderNumber().isDisplayed(), "The Order number is displayed");
		Assert.assertTrue(getBankInfo.getbtn_BankCode().isDisplayed(), "The bank code is displayed");
		Assert.assertTrue(getBankInfo.getbtn_nameEN().isDisplayed(), "The Bank name EN is displayed");
		Assert.assertTrue(getBankInfo.getbtn_nameTH().isDisplayed(), "The Bank name TH is displayed");
		Assert.assertTrue(getBankInfo.getbtn_Shortname().isDisplayed(), "The bank Sortname is displayed");
		Assert.assertTrue(getBankInfo.getbtn_Logo().isDisplayed(), "The bank logo is displayed");
		Assert.assertTrue(getBankInfo.getbtn_BankStatus().isDisplayed(), "The bank status is displayed");
		Assert.assertTrue(getBankInfo.getbtn_lastupdate().isDisplayed(), "The last update is displayed");
		Assert.assertTrue(getBankInfo.getbtn_updateby().isDisplayed(), "The update by is displayed");
		Assert.assertTrue(getBankInfo.getbtn_Promptpaystatus().isDisplayed(), "The promptpaystatus is displayed");
		Assert.assertTrue(getBankInfo.getbtn_status().isDisplayed(), "The status is displayed");
		Assert.assertTrue(getBankInfo.getbtn_newCreateBank().isDisplayed(), "The new Bank button is displayed");		
		Assert.assertTrue(getBankInfo.getbtn_editbankinfo().isDisplayed(), "The edit Bank info button is displayed");
		
		List<WebElement> BankStatus=getBankInfo.getCurrent_BankStatus();
		Assert.assertEquals(BankStatus.size(),10); 
		for(int i=0;i<BankStatus.size();i++)
		{	
			System.out.println("The bank status for "+i+" is "+BankStatus.get(i).getText());
			Assert.assertTrue(BankStatus.get(i).getText().equalsIgnoreCase("Active") ||BankStatus.get(i).getText().equalsIgnoreCase("Inactive") ||BankStatus.get(i).getText().equalsIgnoreCase("Close"),"The bank status should be Active or Inactive or close but found "+BankStatus.get(i).getText());
		
			}
		
		List<WebElement> Status= getBankInfo.getCurrent_Status();
		Assert.assertEquals(Status.size(),10); 
		for(int i=0;i<Status.size();i++)
		{	
			System.out.println("The bank status for "+i+" is "+Status.get(i).getText());
			//Assert.assertTrue(Status.get(i).getText().equalsIgnoreCase("Draft") ||Status.get(i).getText().equalsIgnoreCase("Approved")||Status.get(i).getText().equalsIgnoreCase("Published"),"The status should be draft or Approved or Published but found "+Status.get(i).getText());
		
			}
	    String DisplayOrder1=getBankInfo.getbtn_DisplayOrder1().getText();
	    String DisplayOrder2=getBankInfo.getbtn_DisplayOrder2().getText();
	    String DisplayOrder3=getBankInfo.getbtn_DisplayOrder3().getText();
	    int Displayorder1value=Integer.valueOf(DisplayOrder1);
	    int Displayorder2value=Integer.valueOf(DisplayOrder2);
	    int Displayorder3value=Integer.valueOf(DisplayOrder3);	    
	    Assert.assertTrue(Displayorder1value<Displayorder2value, "Display order is sorted");
	    Assert.assertTrue(Displayorder2value<Displayorder3value, "Display order is sorted");
		getBankInfo.getbtn_lastupdate().click();
		SimpleDateFormat   lastupdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(getBankInfo.getBtn_Date1().getText());
		System.out.println(getBankInfo.getBtn_Date2().getText());		
		Date d1 = lastupdate.parse(getBankInfo.getBtn_Date1().getText());
        Date d2 = lastupdate.parse(getBankInfo.getBtn_Date2().getText());
        Date d3 = lastupdate.parse(getBankInfo.getBtn_Date3().getText());
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
