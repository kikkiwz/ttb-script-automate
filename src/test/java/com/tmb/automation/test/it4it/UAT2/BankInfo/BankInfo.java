package com.tmb.automation.test.it4it.UAT2.BankInfo;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import com.tmb.automation.pages.web.CCAdmin_Editproductinfo;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_bankinfo;
import com.tmb.automation.pages.web.CCAdmin_phases;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.pages.web.CCAdmin_productinfo;
import com.tmb.automation.util.ActivityLogWeb;
import com.tmb.automation.util.Base;

public class BankInfo extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public static String bankcode;
	CCAdmin_producticon CreateProdicon;
	CCAdmin_Home_Page page;
	String dirpath = System.getProperty("user.dir");
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		Date date =new Date();
		StartTime = date.getTime();
		driver = initializeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Extentreportfeature();
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

		mapData = Helper.testData("TestData_it4it_sp11","IT4IT");
		String username = mapData.get("username");
		String password = mapData.get("password");

		// entering usrer name and passwpord
		page.enter_text(page.getIn_username(), username);
		page.enter_text(page.getIn_password(), password);
		Thread.sleep(3000);
		page.click(page.getBtn_submit());
		Thread.sleep(3000);
		ExtentTest Scenario = getFeature().createNode(Scenario.class, "Loging validation");
		String Image = "images/IT4IT/ProductIcon/logged_in.png";
		takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Logged in successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).pass("pass");
	}

	@Test(dataProvider="getExcelData",description="Bank Info",priority=1)
	public void Bank_Info_Validation(String login,String password) throws Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		verify_Dashboard();
		Create_NewBankInfo();
		Edit_ExistingBank();

	}

	public void verify_Dashboard() throws InterruptedException, ParseException, IOException {
		mapData = Helper.testData("TestData_it4it_sp11","IT4IT");
		CCAdmin_bankinfo getBankInfo = new CCAdmin_bankinfo(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
		CreateProdicon = new CCAdmin_producticon(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Verify Dashboard for Bank Info");
		try {

			// GotoBank Info
			page.waitVisible(page.getBtn_Admin(), 20);
			page.click(page.getBtn_Admin());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			page.click(getBankInfo.getBtn_Bankinfo());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(2000);
			String Image = "images/IT4IT/BankInfo/BankInfo_Page.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully loaded Bank Info page").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_Page.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Bank Info page not loaded successfully").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
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
			Assert.assertTrue(getBankInfo.getbtn_newCreateBank().isDisplayed(), "The new Bank button is displayed");		
			Assert.assertTrue(getBankInfo.getbtn_editbankinfo().isDisplayed(), "The edit Bank info button is displayed");		
			String Image = "images/IT4IT/BankInfo/BankInfo_Dashboard_header.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Verified presence of header on dashboard").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_Dashboard_header.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of header on dashboard is failed").addScreenCaptureFromPath(Image).fail(t);
		}

		try {		
			List<WebElement> BankStatus=getBankInfo.getCurrent_BankStatus();
			Assert.assertEquals(BankStatus.size(),10); 
			for(int i=0;i<BankStatus.size();i++)
			{	
				System.out.println("The bank status for "+i+" is "+BankStatus.get(i).getText());
				Assert.assertTrue(BankStatus.get(i).getText().equalsIgnoreCase("Active") ||BankStatus.get(i).getText().equalsIgnoreCase("Inactive") ||BankStatus.get(i).getText().equalsIgnoreCase("Close"),"The bank status should be Active or Inactive or close but found "+BankStatus.get(i).getText());

			}
			String Image = "images/IT4IT/BankInfo/BankInfo_BankStatus.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully verified bank status as Active--> Inactive--> Close").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_BankStatus.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Bank status is failed").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			String DisplayOrder1=getBankInfo.getbtn_DisplayOrder1().getText();
			String DisplayOrder2=getBankInfo.getbtn_DisplayOrder2().getText();
			String DisplayOrder3=getBankInfo.getbtn_DisplayOrder3().getText();
			int Displayorder1value=Integer.valueOf(DisplayOrder1);
			int Displayorder2value=Integer.valueOf(DisplayOrder2);
			int Displayorder3value=Integer.valueOf(DisplayOrder3);	    
			Assert.assertTrue(Displayorder1value<Displayorder2value, "Display order is sorted");
			Assert.assertTrue(Displayorder2value<Displayorder3value, "Display order is sorted");
			String Image = "images/IT4IT/BankInfo/BankInfo_DisplayOrder.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully verified sorting of Order number").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_DisplayOrder.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification for sorting of Order Number is failed").addScreenCaptureFromPath(Image).fail(t);
		}

		try {	
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdicon.getbtn_next());
			Assert.assertTrue(CreateProdicon.getbtn_next().isEnabled(), "The Next button is Enabled");		
			Assert.assertTrue(!CreateProdicon.getbtn_previous().isEnabled(), "The previous button should disabled");
			CreateProdicon.getbtn_secondtab().click();
			Thread.sleep(2000);
			Assert.assertTrue(CreateProdicon.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(CreateProdicon.getbtn_previous().isEnabled(), "The previous button should Enable");
			CreateProdicon.getbtn_firsttab().click();
			Thread.sleep(2000);
			Assert.assertTrue(CreateProdicon.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(!CreateProdicon.getbtn_previous().isEnabled(), "The previous button should Disable");
			String Image = "images/IT4IT/BankInfo/BankInfo_Page_Pagination.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully verified pagination on Bank info page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_Page_Pagination.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Pagination is failed on Bank info page").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			getBankInfo.getbtn_lastupdate().click();
			SimpleDateFormat   lastupdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(getBankInfo.getBtn_Date1().getText());
			System.out.println(getBankInfo.getBtn_Date2().getText());		
			Date d1 = lastupdate.parse(getBankInfo.getBtn_Date1().getText());
			Date d2 = lastupdate.parse(getBankInfo.getBtn_Date2().getText());
			Date d3 = lastupdate.parse(getBankInfo.getBtn_Date3().getText());
			Assert.assertTrue(d1.after(d2)|| d1.equals(d2),"The dates are shorted newest to oldest");
			Assert.assertTrue(d2.after(d3) || d2.equals(d3),"The dates are shorted newest to oldest");
			String Image = "images/IT4IT/BankInfo/BankInfo_Page_sorting_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_Page_sorting_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are not sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			CreateProdicon.getbtn_secondtab().click();
			Thread.sleep(2000);
			CreateProdicon.gettxt_Last_Update().click();
			Assert.assertTrue(CreateProdicon.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(!CreateProdicon.getbtn_previous().isEnabled(), "The previous button should Disable");		
			String Image = "images/IT4IT/BankInfo/BankInfo_Page_sorting_except_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "After sorting on any page except page 1 successfully navigates back to page 1").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_Page_sorting_except_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of sorting on any page except page 1 is failed").addScreenCaptureFromPath(Image).fail(t);
		}

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-180)"," ");
		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_orderNumber().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Order No. working");
			Thread.sleep(1000);
			getBankInfo.getbtn_orderNumber().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Order No. is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Order No. is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_BankCode().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Bank Code working fine");
			Thread.sleep(1000);
			getBankInfo.getbtn_BankCode().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Bank Code is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Bank Code is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_Shortname().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Short Name working");
			Thread.sleep(1000);
			getBankInfo.getbtn_Shortname().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Short Name is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Short Name is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_nameTH().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Name TH working");
			Thread.sleep(1000);
			getBankInfo.getbtn_nameTH().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Name TH is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Name TH is not working").fail(t);	
		}

		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_nameEN().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Name EN working");
			Thread.sleep(1000);
			getBankInfo.getbtn_nameEN().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Name EN is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Name EN is not working").fail(t);	
		}

		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			//getBankInfo.getbtn_Logo().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertEquals(iconid1,iconid2, "Sorting not present on LOGO");
			Thread.sleep(1000);
			//getBankInfo.getbtn_Logo().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting Should not present for LOGO").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting present for LOGO").fail(t);	
		}
		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_lastupdate().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Last Update working");
			Thread.sleep(1000);
			getBankInfo.getbtn_lastupdate().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Last Update is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Last Update is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_updateby().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Update by working");
			Thread.sleep(1000);
			getBankInfo.getbtn_updateby().click();
			Scenario.createNode(Given.class, "Sorting on Update By is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Update By is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_BankStatus().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Bank Status working");
			Thread.sleep(1000);
			getBankInfo.getbtn_BankStatus().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Bank Status is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Bank Status is not working").fail(t);	
		}

		try {
			String iconid1=CreateProdicon.getbtn_Sorting().getText();
			Thread.sleep(1000);
			getBankInfo.getbtn_Promptpaystatus().click();
			Thread.sleep(2000);
			String iconid2=CreateProdicon.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for PromptPay Status working");
			Thread.sleep(1000);
			getBankInfo.getbtn_Promptpaystatus().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on PromptPay Status is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on PromptPay Status is not working").fail(t);	
		}

	}
	public void Create_NewBankInfo() throws InterruptedException, IOException, AWTException, ParseException {
		Date date =new Date();
		StartTime = date.getTime();
		mapData = Helper.testData("TestData_it4it_sp11","IT4IT");
		CCAdmin_bankinfo getBankInfo = new CCAdmin_bankinfo(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
		CreateProdicon = new CCAdmin_producticon(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Create New Bank");
		try {
			getBankInfo.getbtn_newCreateBank().click();
			page.waitVisible(getBankInfo.gettxt_Edit_Add_Bankinfo(),20);
			getBankInfo.gettxt_back_to_dashboard().click();
			page.waitVisible(getBankInfo.getbtn_BankCode(), 20);
			getBankInfo.getbtn_newCreateBank().click();
			page.waitVisible(getBankInfo.gettxt_Edit_Add_Bankinfo(),20);
			String Image = "images/IT4IT/BankInfo/BankInfo_Page_NewBankInfo.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Landed on New Bank Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_Page_NewBankInfo.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Create new Bank page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
		}

		try {
			for(int i=11;i<=99;i++) {			
				bankcode=String.valueOf(i);
				getBankInfo.getIn_bankcd().sendKeys(bankcode);
				List<WebElement> Duplicate_code=getBankInfo.gettxt_BankCode_Duplicate_Error_msg();
				if(Duplicate_code.size()>0) {
					getBankInfo.getIn_bankcd().clear();
					System.out.println("Bank Code "+i+" is already present");
					continue;
				}
				else {
					break;
				}
			}
			String Image = "images/IT4IT/BankInfo/BankInfo_BankCode.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Bank Code successfully enterd and Error message also verified for Entering lesss than 2 digit and duplicate").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_BankCode.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Bank code is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
		}
		Robot robot = new Robot();
		try {

			for(int i=1;i<=2;i++) {
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				Thread.sleep(500);
			}
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
			String Image = "images/IT4IT/BankInfo/BankInfo_Bankshortname.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "The Field required message is verified for Bank Code").addScreenCaptureFromPath(Image).pass("PASS");


		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_BankCode.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "This field is required error message not display for Bank code").addScreenCaptureFromPath(Image).fail(t);	
		}
		getBankInfo.getIn_bankcd().sendKeys(bankcode);
		Thread.sleep(2000);
		getBankInfo.getIn_bankShortname().sendKeys("Test");
		for(int i=1;i<=4;i++) {
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(500);
		}
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
		String Image1 = "images/IT4IT/BankInfo/BankInfo_BanknameEN.png";
		takeScreenshot(Image1, driver);
		Scenario.createNode(Given.class, "The Field required message is verified for Bank NameEN").addScreenCaptureFromPath(Image1).pass("PASS");
		getBankInfo.getIn_bankShortname().sendKeys("Test");
		getBankInfo.getIn_banknameEN().sendKeys("TMB");
		for(int i=1;i<=3;i++) {
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(500);
		}
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
		String Image2 = "images/IT4IT/BankInfo/BankInfo_BanknameTH.png";
		takeScreenshot(Image2, driver);
		Scenario.createNode(Given.class, "The Field required message is verified for Bank Name TH").addScreenCaptureFromPath(Image2).pass("PASS");
		getBankInfo.getIn_banknameEN().sendKeys("TMB");
		getBankInfo.getIn_banknameTH().sendKeys("ธนาคาร");
		getBankInfo.getin_bankStatus().click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Scenario.createNode(Given.class, "Bank Status is selected as Active").pass("PASS");

		//    Select BankStatus=new Select(getBankInfo.getin_bankStatus());
		//    BankStatus.selectByValue("Inactive");
		//    Thread.sleep(1000);
		//    BankStatus.selectByIndex(0);;
		// Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
		getBankInfo.getIn_Accountlength().sendKeys("123,");
		for(int i=1;i<=4;i++) {
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(500);
		}
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
		getBankInfo.getIn_Accountlength().sendKeys("123,");
		getBankInfo.getIn_displayorder().sendKeys("10");
		for(int i=1;i<=2;i++) {
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(500);
		}
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
		getBankInfo.getIn_displayorder().sendKeys("10");

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,80)"," ");
		Thread.sleep(1000);
		getBankInfo.getUpload_chosebanklogo().sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint32Story22394\\upload_img_bankinfo_Wrong.png"); 
		Assert.assertTrue(getBankInfo.getupload_chosebanklogoErrormsg().isDisplayed(), "The Img should be 240 * 240");
		String Image3 = "images/IT4IT/BankInfo/BankInfo_WrongImage.png";
		takeScreenshot(Image3, driver);
		Scenario.createNode(Given.class, "The Error message is displayed for uploading wrong image and the Error message is "+getBankInfo.getupload_chosebanklogoErrormsg().getText()).addScreenCaptureFromPath(Image3).pass("PASS");
		getBankInfo.getUpload_chosebanklogo().sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint32Story22394\\upload_img_bankinfo.png");
		String Image4 = "images/IT4IT/BankInfo/BankInfo_CorrectImage.png";
		takeScreenshot(Image4, driver);
		Scenario.createNode(Given.class, "Successfully uploaded the image").addScreenCaptureFromPath(Image4).pass("PASS");
		getBankInfo.getSel_promptpayStatus().click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Scenario.createNode(Given.class, "PromptPayStatus is selected as Available").pass("PASS");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getBankInfo.getSel_promptpayStatus());
		Assert.assertTrue(!getBankInfo.getbtn_savebank().isEnabled(), "Save button is disabled");
		String Image5 = "images/IT4IT/BankInfo/BankInfo_Save_Disabled.png";
		takeScreenshot(Image5, driver);
		Scenario.createNode(Given.class, "Save button is in disabled State").addScreenCaptureFromPath(Image5).pass("PASS");
		getBankInfo.getIn_Effectivedate().click();
		int date_size=getBankInfo.getin_date_promptpay().size();
		for(int i=1;i<date_size;i++) {
			String date_enabled=getBankInfo.getin_date_promptpay().get(i).getAttribute("aria-disabled");
			if(date_enabled.equalsIgnoreCase("false")) {
				getBankInfo.getin_date_promptpay().get(i).click();
				break;
			}
			else {
				continue;
			}
		}

		getBankInfo.getIn_Expiredate().click();
		int date_size_Expire=getBankInfo.getin_date_promptpay().size();
		for(int i=1;i<date_size_Expire;i++) {
			String date_enabled=getBankInfo.getin_date_promptpay().get(i).getAttribute("aria-disabled");
			if(date_enabled.equalsIgnoreCase("false")) {
				getBankInfo.getin_date_promptpay().get(i).click();
				break;
			}
			else {
				continue;
			}
		}	
		Assert.assertTrue(getBankInfo.getbtn_savebank().isEnabled(), "Save button is Enabled");
		String Image6 = "images/IT4IT/BankInfo/BankInfo_Save_Enabled.png";
		takeScreenshot(Image6, driver);
		Scenario.createNode(Given.class, "Successfully uploaded the image").addScreenCaptureFromPath(Image6).pass("PASS");
		SimpleDateFormat   PromptpayDateformat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(getBankInfo.getBtn_EffectiveDate().getText());
		System.out.println(getBankInfo.getBtn_ExpireDate().getText());				
		Date d1 = PromptpayDateformat.parse(getBankInfo.getBtn_EffectiveDate().getText());
		Date d2 = PromptpayDateformat.parse(getBankInfo.getBtn_ExpireDate().getText());       
		Assert.assertTrue(d2.after(d1),"Not allow expire date bigger than effective date");
		String Image7 = "images/IT4IT/BankInfo/BankInfo_ExpireDate.png";
		takeScreenshot(Image7, driver);
		Scenario.createNode(Given.class, "Not allow expire date bigger than effective date Error message is visible").addScreenCaptureFromPath(Image7).pass("PASS");
		getBankInfo.getbtn_savebank().click();
		WebElement BankCode1=getBankInfo.getbtn_orderNumber();
		page.waitVisible(BankCode1, 20);
		ActivityLogWeb activitylog=new ActivityLogWeb();
		activitylog.ActivityLog("9003020","Manage Bank Info","Success",StartTime,0,"Add Bank Info",Scenario,"Activity Log captured after clicking on save button from  new Bank Info");
		String Image8 = "images/IT4IT/BankInfo/BankInfo_Created.png";
		takeScreenshot(Image8, driver);
		Scenario.createNode(Given.class, "New Bank Created Successfully").addScreenCaptureFromPath(Image8).pass("PASS");
	}
	public void Edit_ExistingBank() throws Exception {
		Date date =new Date();
		StartTime = date.getTime();
		mapData = Helper.testData("TestData_it4it_sp11","IT4IT");
		CCAdmin_bankinfo getBankInfo = new CCAdmin_bankinfo(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
		CreateProdicon = new CCAdmin_producticon(driver);
		Robot robot = new Robot();
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Create New Bank");
		try {

			getBankInfo.getbtn_editbankinfo().click();
			page.waitVisible(getBankInfo.gettxt_Edit_Add_Bankinfo(),20);
			Thread.sleep(2000);
			Assert.assertTrue(!getBankInfo.getIn_bankcd().isEnabled(),"Bank code should be disabled");
			Assert.assertTrue(getBankInfo.getbtn_savebank().isEnabled(), "Save button is Enabled");
			String Image = "images/IT4IT/BankInfo/BankInfo_Edit.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Sucessfully landed on Edit Bank Page and Bank code is Disabled and Save button is enabled").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_Edit.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to load Edit bank successfully").addScreenCaptureFromPath(Image).fail(t);	
		}

		try {
			getBankInfo.getIn_banknameEN().clear();
			Thread.sleep(2000);
			getBankInfo.getIn_banknameEN().sendKeys("TMB");
			for(int i=1;i<=3;i++) {
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				Thread.sleep(500);
			}
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
			getBankInfo.getIn_banknameEN().sendKeys("TMB");
			getBankInfo.getIn_displayorder().clear();
			getBankInfo.getIn_displayorder().sendKeys("10");
			for(int i=1;i<=2;i++) {
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				Thread.sleep(500);
			}
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
			getBankInfo.getIn_displayorder().sendKeys("10");
			getBankInfo.getbtn_savebank().click();
			WebElement BankCode2=getBankInfo.getbtn_orderNumber();
			page.waitVisible(BankCode2, 20);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9003020","Manage Bank Info","Success",StartTime,0,"Add Bank Info",Scenario,"Activity Log captured after clicking on save button from  Edit Bank Info");
			String Image = "images/IT4IT/BankInfo/BankInfo_Edited.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Sucessfully Edited certain field and clicked on save button and landed on Bank Info Dashboard page").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/BankInfo/BankInfo_Edited.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to Edit bank info successfully").addScreenCaptureFromPath(Image).fail(t);	
		}

	}

	@AfterClass
	public void closebrowser(Throwable t) {

		driver.quit();
	}


	@DataProvider
	public  Object[][] getExcelData() throws IOException
	{
		Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "IT4IT");
		return Data;


	}



}
