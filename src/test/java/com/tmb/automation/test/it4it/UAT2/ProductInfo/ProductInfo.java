package com.tmb.automation.test.it4it.UAT2.ProductInfo;


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
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_productinfo;
import com.tmb.automation.util.ActivityLogWeb;
import com.tmb.automation.util.Base;

public class ProductInfo extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public static Long StartTime;
	public static String ProductcodeText;
	public static String Productcode;
	CCAdmin_productinfo ProdInfo;
	CCAdmin_Home_Page page;
	String dirpath = System.getProperty("user.dir");

	@BeforeClass
	public void ReportGenerate() {
		Extentreportfeature();	
	}

	public void initialize(String Sheetname) throws IOException, InterruptedException {

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
		ExtentTest Scenario = getFeature().createNode(Scenario.class, "Loging validation for Product Info");
		String Image = "images/IT4IT/ProductInfo/logged_in.png";
		takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Logged in successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).pass("pass");
	}

	@Test(dataProvider="getExcelData",description="Validate Product Imfp with Admin role",priority=1)
	public void ProductShortcut_Validation_Admin(String login,String password) throws Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////

		initialize("IT4IT_Admin");
		verify_Dashboard("Verify Dashboard for Admin Role");


	}
	@Test(dataProvider="getExcelData",description="Validate Product Shortcut with Super Admin role",priority=2)
	public void ProductShortcut_Validation_SuperAdmin(String login,String password) throws Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////

		initialize("IT4IT");
		verify_Dashboard("Verify Dashboard for Super Admin Role");
		Edit_NewFeedProductInfo();
		CurrentProductInfo();
		EditCurrentProductInfo();
		Approve_Publish_ProductInfo();

	}

	public void verify_Dashboard(String Scenarioname) throws InterruptedException, ParseException, IOException {
		page = new CCAdmin_Home_Page(driver);
		ProdInfo = new CCAdmin_productinfo(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, Scenarioname);
		try {
			page.waitVisible(page.getBtn_Admin(), 20);
			page.click(page.getBtn_Admin());
			page.click(ProdInfo.getBtn_product());
			page.click(ProdInfo.getBtn_productInfo());
			page.waitVisible(ProdInfo.getBtn_NewFeedproductInfo(), 5);
			Thread.sleep(2000);
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Page.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully loaded product Info page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Page.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Product Info page not loaded successfully").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			Assert.assertTrue(ProdInfo.gettxt_Product_Code().isDisplayed(), "The Product Code is displayed");
			Assert.assertTrue(ProdInfo.gettxt_Name_EN().isDisplayed(), "The Name EN is displayed");
			Assert.assertTrue(ProdInfo.gettxt_Name_TH().isDisplayed(), "The Bank name TH is displayed");
			Assert.assertTrue(ProdInfo.gettxt_Description().isDisplayed(), "The Description is displayed");
			Assert.assertTrue(ProdInfo.gettxt_Last_Update().isDisplayed(), "The last update is displayed");
			Assert.assertTrue(ProdInfo.gettxt_Status().isDisplayed(), "The status is displayed");
			Assert.assertTrue(ProdInfo.gettxt_Product_Category().isDisplayed(), "The Product Category is displayed");
			Assert.assertTrue(ProdInfo.getBtn_WaitforApproval().isDisplayed(), "The Wait for approve button is displayed");				
			Assert.assertTrue(ProdInfo.getBtn_editproductInfobutton().isDisplayed(), "The Edit  button is displayed");
			if(Scenarioname.contains("Super Admin")) {
				Assert.assertTrue(ProdInfo.getBtn_WaitforApproval().isEnabled(), "The Wait for approve button is Enabled");		
				String Image = "images/IT4IT/ProductInfo/ProductInfo_Dashboard_header.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Verified presence of header on dashboard for product info for super admin role as Wait for approval is Enabled").addScreenCaptureFromPath(Image).pass("PASS");
			}
			else {
				Assert.assertFalse(ProdInfo.getBtn_WaitforApproval().isEnabled(), "The Wait for approve button is Disabled");		
				String Image = "images/IT4IT/ProductInfo/ProductInfo_Dashboard_header.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Verified presence of header on dashboard for product info for Admin role as Wait for Approval is disabled").addScreenCaptureFromPath(Image).pass("PASS");

			}
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Dashboard_header.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of header on dashboard is failed for product Info").addScreenCaptureFromPath(Image).fail(t);
		}
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ProdInfo.getbtn_next());
			Assert.assertTrue(ProdInfo.getbtn_next().isEnabled(), "The Next button is Enabled");		
			Assert.assertTrue(!ProdInfo.getbtn_previous().isEnabled(), "The previous button should disabled");
			ProdInfo.getbtn_secondtab().click();
			Thread.sleep(2000);
			Assert.assertTrue(ProdInfo.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(ProdInfo.getbtn_previous().isEnabled(), "The previous button should Enable");
			ProdInfo.getbtn_firsttab().click();
			Thread.sleep(2000);
			Assert.assertTrue(ProdInfo.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(!ProdInfo.getbtn_previous().isEnabled(), "The previous button should Disable");
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Page_Pagination.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully verified pagination").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductImfo_Page_Pagination.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Pagination is failed").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			SimpleDateFormat   lastupdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(ProdInfo.getBtn_Date1().getText());
			System.out.println(ProdInfo.getBtn_Date2().getText());		
			Date d1 = lastupdate.parse(ProdInfo.getBtn_Date1().getText());
			Date d2 = lastupdate.parse(ProdInfo.getBtn_Date2().getText());
			Date d3 = lastupdate.parse(ProdInfo.getBtn_Date3().getText());
			Assert.assertTrue(d1.after(d2)|| d1.equals(d2),"The dates are shorted newest to oldest");
			Assert.assertTrue(d2.after(d3) || d2.equals(d3),"The dates are shorted newest to oldest");
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Page_sorting_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Page_sorting_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are not sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			ProdInfo.getbtn_secondtab().click();
			Thread.sleep(2000);
			ProdInfo.gettxt_Last_Update().click();
			Assert.assertTrue(ProdInfo.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(!ProdInfo.getbtn_previous().isEnabled(), "The previous button should Disable");		
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Page_sorting_except_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "After sorting on any page except page 1 successfully navigates back to page 1").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Page_sorting_except_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of sorting on any page except page 1 is failed").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			String iconid1=ProdInfo.getbtn_Sorting().getText();
			Thread.sleep(1000);
			ProdInfo.gettxt_Product_Code().click();
			Thread.sleep(2000);
			String iconid2=ProdInfo.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Product Code id working");
			Thread.sleep(1000);
			ProdInfo.gettxt_Product_Code().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Product Code is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Product code is not working").fail(t);	
		}
		try {
			String iconid1=ProdInfo.getbtn_Sorting().getText();
			Thread.sleep(1000);
			ProdInfo.gettxt_Name_EN().click();
			Thread.sleep(2000);
			String iconid2=ProdInfo.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Name EN working fine");
			Thread.sleep(1000);
			ProdInfo.gettxt_Name_EN().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Name EN is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Name EN is not working").fail(t);	
		}
		try {
			String iconid1=ProdInfo.getbtn_Sorting().getText();
			Thread.sleep(1000);
			ProdInfo.gettxt_Name_TH().click();
			Thread.sleep(2000);
			String iconid2=ProdInfo.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Name TH working");
			Thread.sleep(1000);
			ProdInfo.gettxt_Name_TH().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Name TH is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Name TH is not working").fail(t);	
		}
		try {
			String iconid1=ProdInfo.getbtn_Sorting().getText();
			Thread.sleep(1000);
			ProdInfo.gettxt_Description().click();
			Thread.sleep(2000);
			String iconid2=ProdInfo.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Description working");
			Thread.sleep(1000);
			ProdInfo.gettxt_Description().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting should not present for Descriptions").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Description is working").fail(t);	
		}

		try {
			String iconid1=ProdInfo.getbtn_Sorting().getText();
			Thread.sleep(1000);
			ProdInfo.gettxt_Last_Update().click();
			Thread.sleep(2000);
			String iconid2=ProdInfo.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Last Update working");
			Thread.sleep(1000);
			ProdInfo.gettxt_Last_Update().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Last Update is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Last Update is not working").fail(t);	
		}
		try {
			String iconid1=ProdInfo.getbtn_Sorting().getText();
			Thread.sleep(1000);
			ProdInfo.gettxt_Product_Category().click();
			Thread.sleep(2000);
			String iconid2=ProdInfo.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Product Category working");
			Thread.sleep(1000);
			ProdInfo.gettxt_Product_Category().click();
			Scenario.createNode(Given.class, "Sorting on Product Category is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Product Category is not working").fail(t);	
		}
		try {
			String iconid1=ProdInfo.getbtn_Sorting().getText();
			Thread.sleep(1000);
			ProdInfo.gettxt_Status().click();
			Thread.sleep(2000);
			String iconid2=ProdInfo.getbtn_Sorting().getText();
			System.out.println("The ids are--"+iconid1+"  "+iconid2);
			Assert.assertEquals(iconid1,iconid2, "Sorting for Status working");
			Thread.sleep(1000);
			ProdInfo.gettxt_Status().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Status is not present Verified").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Status is Present").fail(t);	
		}
		try {		
			List<WebElement> InfoStatus=ProdInfo.getNew_info_Status(); 
			for(int i=0;i<InfoStatus.size();i++)
			{	
				System.out.println("The bank status for "+i+" is "+InfoStatus.get(i).getText());
				Assert.assertTrue(InfoStatus.get(i).getText().equalsIgnoreCase("New"),"The New Feed Product Info should always be New");

			}
			String Image = "images/IT4IT/ProductInfo/ProductInfo_status.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully verified New Feed Product Info status as New").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_status.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of New Feed Product Info status is failed").addScreenCaptureFromPath(Image).fail(t);
		}

	}

	public void CurrentProductInfo() throws IOException {
		Date date =new Date();
		StartTime = date.getTime();
		page = new CCAdmin_Home_Page(driver);
		ProdInfo = new CCAdmin_productinfo(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Current Product Info");
		try {			
			page.click(ProdInfo.getBtn_CurrentproductInfo());		
			page.waitVisible(ProdInfo.getbtn_Search(), 5);
			String Image = "images/IT4IT/ProductInfo/ProductInfo_CurrentPage.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Landed on Current Product Info Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPage.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to Load current Product Info Page").addScreenCaptureFromPath(Image).fail(t);
		}
		try {	
			Assert.assertTrue(!ProdInfo.getbtn_Search().isEnabled());
			Assert.assertTrue(!ProdInfo.getbtn_Clear().isEnabled());
			Assert.assertTrue(ProdInfo.getbtn_SearchProduct().getAttribute("placeholder").equals("Search Product"));
			Scenario.createNode(Given.class, "Searh and Clear button are in disabled state").pass("VERIFIED");
			ProdInfo.getbtn_SearchProduct().sendKeys("UAT");
			Thread.sleep(2000);
			Assert.assertTrue(ProdInfo.getbtn_Search().isEnabled());
			Assert.assertTrue(ProdInfo.getbtn_Clear().isEnabled());
			Scenario.createNode(Given.class, "Searh and Clear button are in Enabled state after searhing any alphanumeric keyword").pass("VERIFIED");
			ProdInfo.getbtn_Search().click();
			Thread.sleep(3000);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9000007","Search Keyword","Success",StartTime,1,"UAT",Scenario,"Activity Log captured after clicking on Search button after searching alphanumeric in search keyword");			
			ProdInfo.getbtn_Clear().click();
			Thread.sleep(3000);
			Assert.assertTrue(!ProdInfo.getbtn_Search().isEnabled());
			Assert.assertTrue(!ProdInfo.getbtn_Clear().isEnabled());
			Scenario.createNode(Given.class, "Searh and Clear button are in disabled state after clicking on clear button").pass("VERIFIED");
			Assert.assertTrue(ProdInfo.getbtn_SearchProduct().getAttribute("placeholder").equals("Search Product"));		
			Select productstatus=new Select(ProdInfo.getbtn_ProductStatus());
			productstatus.selectByValue("Approved");
			Thread.sleep(2000);
			productstatus.selectByValue("Published");
			Thread.sleep(2000);
			productstatus.selectByValue("Draft");
			Thread.sleep(2000);
			productstatus.selectByValue("Stop");
			Thread.sleep(2000);
			productstatus.selectByValue("All");
			Thread.sleep(2000);	
			Scenario.createNode(Given.class, "Filters for product status verified successfully").pass("VERIFIED");
			String Image = "images/IT4IT/ProductInfo/ProductInfo_CurrentPage_Verified.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Verified Current Product Info Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_CurrentPage_Verified.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Current product info page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);
		}
	}
	public void EditCurrentProductInfo() throws IOException {
		Date date =new Date();
		StartTime = date.getTime();
		page = new CCAdmin_Home_Page(driver);
		ProdInfo = new CCAdmin_productinfo(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Edit Current Product Info page");
		try {			
			page.click(ProdInfo.getBtn_editproductInfobutton());
			page.waitVisible(ProdInfo.getBtn_editproductSelectIcon(), 5);
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditCurrentPage.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Landed on Edit Current Product Info Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditCurrentPage.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to Load Edit Current Product Info Page").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			WebElement Cancelbutton=ProdInfo.getbtn_editproductInfoCancel();
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Cancelbutton);
			Thread.sleep(3000);
			Cancelbutton.click();
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Current Product Info Cancel",Scenario,"Activity Log captured after clicking on cancel button in edit Current product info page");						
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPag_cancel.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully clicked on cancel button from Edit New Feed Product Info Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPage_cancel.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to click cancel button from Edit New Feed Product Info Page").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			Thread.sleep(3000);
			page.click(ProdInfo.getBtn_editproductInfobutton());
			page.waitVisible(ProdInfo.getBtn_editproductSelectIcon(), 5);
			Assert.assertTrue(ProdInfo.getimg_icon().isDisplayed());
			Scenario.createNode(Given.class, "Image icon is present").pass("PASS");
			WebElement Cancelbutton=ProdInfo.getbtn_editproductInfoCancel();
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Cancelbutton);
			Thread.sleep(2000);
			Assert.assertTrue(ProdInfo.getimg_productshortcut().isDisplayed());
			Scenario.createNode(Given.class, "Image Product Shortcut is present").pass("PASS");
			Assert.assertTrue(ProdInfo.getBtn_editfinalsavebutton().isEnabled());
			Scenario.createNode(Given.class, "Save Button is Enabled").pass("PASS");		
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPage_cancel.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to click cancel button from Edit New Feed Product Info Page").addScreenCaptureFromPath(Image).fail(t);
		}

		try {
			WebElement Productcode=ProdInfo.getBtn_editproduct_code();
			ProductcodeText=Productcode.getAttribute("value");
			WebElement Accounttype=ProdInfo.getBtn_editaccount_type();
			WebElement ProductDescription=ProdInfo.getBtn_editproduct_description();
			WebElement ProductNameEN=ProdInfo.getBtn_editproduct_name_en();
			WebElement ProductNameTH=ProdInfo.getBtn_editproduct_name_th();
			WebElement ProductCategoryEN=ProdInfo.getBtn_editproduct_category_en();
			WebElement ProductCategoryTH=ProdInfo.getBtn_editproduct_category_th();
			WebElement AccountTypeEN=ProdInfo.getBtn_editaccount_type_desc_en();
			WebElement AccountTypeTH=ProdInfo.getBtn_editaccount_type_desc_th();
			WebElement MarketingConcept=ProdInfo.getBtn_editmarketing_concept();
			Assert.assertTrue(!Productcode.getAttribute("value").equals(""), "Product Code is either editable or having null value");
			Assert.assertTrue(!Accounttype.getAttribute("value").equals(""), "Account type is either editable or having null value");
			Assert.assertTrue(!ProductDescription.getAttribute("value").equals(""), "Product Description is either editable or having null value");
			Assert.assertTrue(!ProductNameEN.getAttribute("value").equals(""), "ProductNameEN is either editable or having null value");
			Assert.assertTrue(!ProductNameTH.getAttribute("value").equals(""), "ProductNameTH is either editable or having null value");
			Assert.assertTrue(!ProductCategoryEN.getAttribute("value").equals(""), "ProductCategoryEN is either editable or having null value");
			Assert.assertTrue(!ProductCategoryTH.getAttribute("value").equals(""), "ProductCategoryTH is either editable or having null value");
			Assert.assertTrue(!AccountTypeEN.getAttribute("value").equals(""), "AccountTypeEN is either editable or having null value");
			Assert.assertTrue(!AccountTypeTH.getAttribute("value").equals(""), "AccountTypeTH is either editable or having null value");
			Assert.assertTrue(!MarketingConcept.getAttribute("value").equals(""), "MarketingConcept is either editable or having null value");		
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			page.waitVisible(ProdInfo.getBtn_editdebitcardflag(), 5);
			page.click(ProdInfo.getBtn_editdebitcardflag());
			page.waitVisible(ProdInfo.getBtn_editdebitcardfee(), 5);
			//page.clearvalue(ProdInfo.getBtn_editdebitcardfee());
			//page.enter_text(ProdInfo.getBtn_editdebitcardfee(),"1000");
			page.waitVisible(ProdInfo.getBtn_editreceivecashback(), 5);
			page.click(ProdInfo.getBtn_editreceivecashback());
			page.waitVisible(ProdInfo.getBtn_editpromptpay(), 5);
			page.click(ProdInfo.getBtn_editpromptpay());	
			page.waitVisible(ProdInfo.getBtn_editcashadvance(), 5);
			page.click(ProdInfo.getBtn_editcashadvance());		
			page.waitVisible(ProdInfo.getBtn_editcardlessWithdraw(), 5);
			page.click(ProdInfo.getBtn_editcardlessWithdraw());
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			page.waitVisible(ProdInfo.getBtn_editsavealert(), 5);
			page.click(ProdInfo.getBtn_editsavealert());
			page.waitVisible(ProdInfo.getBtn_editpurchaseba(), 5);
			page.click(ProdInfo.getBtn_editpurchaseba());
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			Thread.sleep(1000);
			page.waitVisible(ProdInfo.getBtn_editsavinggoal(), 5);
			page.click(ProdInfo.getBtn_editsavinggoal());
			page.click(ProdInfo.getBtn_editChequeview());
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			page.waitVisible(ProdInfo.getBtn_editfeeflag(), 5);
			page.click(ProdInfo.getBtn_editfeeflag());		
			page.waitVisible(ProdInfo.getBtn_editsavefrom(), 5);
			page.click(ProdInfo.getBtn_editsavefrom());		
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			page.waitVisible(ProdInfo.getBtn_editfeeflag(), 5);
			page.click(ProdInfo.getBtn_editfeeflag());
			page.waitVisible(ProdInfo.getBtn_editallowtransfer(), 5);
			page.click(ProdInfo.getBtn_editallowtransfer());
			page.click(ProdInfo.getBtn_editepayment());	
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPageVerify_Current.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Edited the Current Product Info Page").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPageVerify_Current.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Edit Page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			WebElement Savebutton3=ProdInfo.getBtn_editfinalsavebutton();
			boolean IsEnaabled3=Savebutton3.isEnabled();
			Assert.assertEquals(IsEnaabled3, true);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebutton3);
			Savebutton3.click();
			page.waitVisible(ProdInfo.getBtn_CurrentproductInfo(), 10);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9003001","Edit Product info","Success",StartTime,0,"Edit Product Info",Scenario,"Activity Log captured after clicking on Save button in edit current product info page");						

			page.click(ProdInfo.getBtn_CurrentproductInfo());
			WebElement Drafted =driver.findElement(By.xpath("//div[text()='" +ProductcodeText +"\']/../../td[7]/div/div"));		
			String DraftedText=Drafted.getText();
			Assert.assertTrue(DraftedText.equalsIgnoreCase("Draft"), "The Status is in Draft state");
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Edited_current.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Edited Current Product Info").addScreenCaptureFromPath(Image).pass("PASS");		
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Edited_current.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to Edit New Feed Product Info").addScreenCaptureFromPath(Image).fail(t);
		}
	}


	public void Edit_NewFeedProductInfo() throws InterruptedException, IOException {
		Date date =new Date();
		StartTime = date.getTime();
		page = new CCAdmin_Home_Page(driver);
		ProdInfo = new CCAdmin_productinfo(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Edit New Feed Product Info");
		try {			
			page.click(ProdInfo.getBtn_editproductInfobutton());
			page.waitVisible(ProdInfo.getBtn_editproductSelectIcon(), 5);
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPage.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Landed on Edit New Feed Product Info Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPage.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to Load Edit New Feed Product Info Page").addScreenCaptureFromPath(Image).fail(t);
		}

		try {
			WebElement Cancelbutton=ProdInfo.getbtn_editproductInfoCancel();
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Cancelbutton);
			Thread.sleep(3000);
			Cancelbutton.click();
			Thread.sleep(3000);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"New Product Info Cancel",Scenario,"Activity Log captured after clicking on cancel button in edit New feed product info page");									
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPag_cancel.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully clicked on cancel button from Edit New Feed Product Info Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPage_cancel.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to click cancel button from Edit New Feed Product Info Page").addScreenCaptureFromPath(Image).fail(t);
		}

		try {
			Thread.sleep(3000);
			page.click(ProdInfo.getBtn_editproductInfobutton());
			page.waitVisible(ProdInfo.getBtn_editproductSelectIcon(), 5);
			page.click(ProdInfo.getBtn_editproductSelectIcon());
			WebElement Savebutton=ProdInfo.getBtn_editproductSelectImageSaveButton();
			boolean IsEnaabled=Savebutton.isEnabled();
			Assert.assertEquals(IsEnaabled, false);
			page.waitVisible(ProdInfo.getBtn_editproductSelectImage(), 5);
			page.click(ProdInfo.getBtn_editproductSelectImage());
			IsEnaabled=Savebutton.isEnabled();
			Assert.assertEquals(IsEnaabled, true);
			String Image = "images/IT4IT/ProductInfo/ProductInfo_SelectIcon.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Click on Select Icon Button \n verified Save button is Disabled \n Selected an Icon \n Verified Save button is Enabled").addScreenCaptureFromPath(Image).pass("PASS");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebutton);
			Savebutton.click();
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_SelectIcon.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Select ICON is failed").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)"," ");
			page.waitVisible(ProdInfo.getBtn_editproductCategory(), 5);
			WebElement Productrdering=ProdInfo.getBtn_editproductCategory();
			page.select_by_id(Productrdering, 2);
			Scenario.createNode(Given.class, "Selected Product Ordering").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Unable to select Product Ordering").fail(t);
		}
		try {
			WebElement Productcode=ProdInfo.getBtn_editproduct_code();
			ProductcodeText=Productcode.getAttribute("value");
			WebElement Accounttype=ProdInfo.getBtn_editaccount_type();
			WebElement ProductDescription=ProdInfo.getBtn_editproduct_description();
			WebElement ProductNameEN=ProdInfo.getBtn_editproduct_name_en();
			WebElement ProductNameTH=ProdInfo.getBtn_editproduct_name_th();
			WebElement ProductCategoryEN=ProdInfo.getBtn_editproduct_category_en();
			WebElement ProductCategoryTH=ProdInfo.getBtn_editproduct_category_th();
			WebElement AccountTypeEN=ProdInfo.getBtn_editaccount_type_desc_en();
			WebElement AccountTypeTH=ProdInfo.getBtn_editaccount_type_desc_th();
			WebElement MarketingConcept=ProdInfo.getBtn_editmarketing_concept();
			Assert.assertTrue(!Productcode.getAttribute("value").equals(""), "Product Code is either editable or having null value");
			Assert.assertTrue(!Accounttype.getAttribute("value").equals(""), "Account type is either editable or having null value");
			Assert.assertTrue(!ProductDescription.getAttribute("value").equals(""), "Product Description is either editable or having null value");
			Assert.assertTrue(!ProductNameEN.getAttribute("value").equals(""), "ProductNameEN is either editable or having null value");
			Assert.assertTrue(!ProductNameTH.getAttribute("value").equals(""), "ProductNameTH is either editable or having null value");
			Assert.assertTrue(!ProductCategoryEN.getAttribute("value").equals(""), "ProductCategoryEN is either editable or having null value");
			Assert.assertTrue(!ProductCategoryTH.getAttribute("value").equals(""), "ProductCategoryTH is either editable or having null value");
			Assert.assertTrue(!AccountTypeEN.getAttribute("value").equals(""), "AccountTypeEN is either editable or having null value");
			Assert.assertTrue(!AccountTypeTH.getAttribute("value").equals(""), "AccountTypeTH is either editable or having null value");
			Assert.assertTrue(!MarketingConcept.getAttribute("value").equals(""), "MarketingConcept is either editable or having null value");		
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			page.waitVisible(ProdInfo.getBtn_editdebitcardflag(), 5);
			page.click(ProdInfo.getBtn_editdebitcardflag());
			page.waitVisible(ProdInfo.getBtn_editdebitcardfee(), 5);
			//page.clearvalue(ProdInfo.getBtn_editdebitcardfee());
			//page.enter_text(ProdInfo.getBtn_editdebitcardfee(),"1000");
			page.waitVisible(ProdInfo.getBtn_editreceivecashback(), 5);
			page.click(ProdInfo.getBtn_editreceivecashback());
			page.waitVisible(ProdInfo.getBtn_editpromptpay(), 5);
			page.click(ProdInfo.getBtn_editpromptpay());	
			page.waitVisible(ProdInfo.getBtn_editcashadvance(), 5);
			page.click(ProdInfo.getBtn_editcashadvance());		
			page.waitVisible(ProdInfo.getBtn_editcardlessWithdraw(), 5);
			page.click(ProdInfo.getBtn_editcardlessWithdraw());
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			page.waitVisible(ProdInfo.getBtn_editsavealert(), 5);
			page.click(ProdInfo.getBtn_editsavealert());
			page.waitVisible(ProdInfo.getBtn_editpurchaseba(), 5);
			page.click(ProdInfo.getBtn_editpurchaseba());
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			Thread.sleep(1000);
			page.waitVisible(ProdInfo.getBtn_editsavinggoal(), 5);
			page.click(ProdInfo.getBtn_editsavinggoal());
			page.click(ProdInfo.getBtn_editChequeview());
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			page.waitVisible(ProdInfo.getBtn_editfeeflag(), 5);
			page.click(ProdInfo.getBtn_editfeeflag());		
			page.waitVisible(ProdInfo.getBtn_editsavefrom(), 5);
			page.click(ProdInfo.getBtn_editsavefrom());		
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
			page.waitVisible(ProdInfo.getBtn_editfeeflag(), 5);
			page.click(ProdInfo.getBtn_editfeeflag());
			page.waitVisible(ProdInfo.getBtn_editallowtransfer(), 5);
			page.click(ProdInfo.getBtn_editallowtransfer());
			page.click(ProdInfo.getBtn_editepayment());	
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPageVerify.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Edited the New feed Product Info Page").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_EditPageVerify.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Edit Page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)"," ");
			page.waitVisible(ProdInfo.getBtn_editaddIcon(), 5);
			page.click(ProdInfo.getBtn_editaddIcon());
			WebElement Savebutton2=ProdInfo.getBtn_editproductSelectImageSaveButton();
			boolean IsEnaabled2=Savebutton2.isEnabled();
			Assert.assertEquals(IsEnaabled2, false);
			page.waitVisible(ProdInfo.getBtn_editaddImage1(), 2);
			page.click(ProdInfo.getBtn_editaddImage1());
			page.waitVisible(ProdInfo.getBtn_editaddImage2(), 2);
			page.click(ProdInfo.getBtn_editaddImage2());
			page.waitVisible(ProdInfo.getBtn_editaddImage3(), 2);
			page.click(ProdInfo.getBtn_editaddImage3());
			page.click(ProdInfo.getBtn_editaddIcon2());
			IsEnaabled2=Savebutton2.isEnabled();
			Assert.assertEquals(IsEnaabled2, true);
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Selectadd.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Click on add product shortcut Button \n verified Save button is Disabled \n Selected an Icon \n Verified Save button is Enabled").addScreenCaptureFromPath(Image).pass("PASS");		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebutton2);
			Thread.sleep(2000);
			Savebutton2.click();
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Selectadd.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to verify add product shortcut page").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			WebElement Savebutton3=ProdInfo.getBtn_editfinalsavebutton();
			boolean IsEnaabled3=Savebutton3.isEnabled();
			Assert.assertEquals(IsEnaabled3, true);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebutton3);
			Savebutton3.click();
			page.waitVisible(ProdInfo.getBtn_CurrentproductInfo(), 10);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9003001","Edit Product info","Success",StartTime,0,"Edit Product Info",Scenario,"Activity Log captured after clicking on Save button in Edit New feed product info page");									
			page.click(ProdInfo.getBtn_CurrentproductInfo());
			WebElement Drafted =driver.findElement(By.xpath("//div[text()='" +ProductcodeText +"\']/../../td[7]/div/div"));		
			String DraftedText=Drafted.getText();
			Assert.assertTrue(DraftedText.equalsIgnoreCase("Draft"), "The Status is in Draft state");
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Edited.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Edited New Feed Product Info").addScreenCaptureFromPath(Image).pass("PASS");		
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Edited.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Unable to Edit New Feed Product Info").addScreenCaptureFromPath(Image).fail(t);
		}

	}

	public void Approve_Publish_ProductInfo() throws Exception, InterruptedException {
		Date date1 =new Date();
		StartTime = date1.getTime();
		CCAdmin_productinfo pinfo = new CCAdmin_productinfo(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Approve and Publish Product Info");
		System.out.println("The number of approvals are---"+pinfo.getBtn_WaitforApproval().getText());
		if(!pinfo.getBtn_WaitforApproval().getText().contains("( 0 )") && pinfo.getBtn_WaitforApproval().isEnabled() ) {
			try {
				page.waitVisible(pinfo.getBtn_WaitforApproval(),5);
				page.click(pinfo.getBtn_WaitforApproval());
				page.waitVisible(ProdInfo.getBtn_Productcode(),5);
				String Image = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Loaded Wait for approval page").addScreenCaptureFromPath(Image).pass("PASS");

			}
			catch(Throwable t){
				String Image = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Wait for approval page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
			}

			Productcode= page.gettextvalue(ProdInfo.getBtn_Productcode());
			WebElement Approvebutton=pinfo.getBtn_Approve();
			boolean IsEnaabled=Approvebutton.isEnabled();
			System.out.println("-----------------"+IsEnaabled);
			Assert.assertEquals(IsEnaabled, false);
			String Image = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_ApproveButton.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Approve button is in disabled state").addScreenCaptureFromPath(Image).pass("PASS");
			try {
				page.click(pinfo.getBtn_DateButton());
				page.waitVisible(pinfo.getBtn_selectdate(),5);
				page.click(pinfo.getBtn_selectdate());
				Approvebutton.click();		
				// Verify Error Message of Time as well as set current time
				page.waitVisible(pinfo.getBtn_ErrorMessage(),5);
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,80)"," ");
				String Errormessage= page.gettextvalue(pinfo.getBtn_ErrorMessage());
				Assert.assertTrue(Errormessage.equalsIgnoreCase("Please select Date & Time greater than Current Date & Time"), "Error message doesn't displayed or might be changes with some other text");
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Error_message.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Error message is displayed 'Please select Date & Time greater than Current Date & Time'").addScreenCaptureFromPath(Image1).pass("PASS");

			}catch(Throwable t){
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Error_message.png";
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
				page.select_by_value(pinfo.getBtn_selecthour(), finalhourtring);
				page.select_by_value(pinfo.getBtn_selectminute(), finalminutestring);
				boolean IsEnaablednow=Approvebutton.isEnabled();
				System.out.println("-----------------"+IsEnaablednow);
				Assert.assertEquals(IsEnaablednow, true);
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_enabled.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Successfully entered correct date and time and approve button is enabled").addScreenCaptureFromPath(Image1).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_enabled.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Entering correct date and time is unsuccessfull").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				Approvebutton.click();
				page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Approvepopup.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Approve pop-up is visible").addScreenCaptureFromPath(Image1).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Approvepopup.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Approve popup is not visible").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				page.click(pinfo.getbtn_Approvepopup_cancel());	
				Thread.sleep(2000);
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Approvepopup_cancel.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Cancel button is clicked successfully on approve pop-up ").addScreenCaptureFromPath(Image1).pass("PASS");
				Thread.sleep(1000);
				ActivityLogWeb activitylog=new ActivityLogWeb();
				activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Approve Product Info Cancel",Scenario,"Activity Log captured after clicking on close icon X from Approve Product info page");									
				Approvebutton=pinfo.getBtn_Approve();
				Approvebutton.click();
				page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
				page.click(pinfo.getBtn_Approvepopup());
			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Approvepopup_cancel.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Cancel button is not clicked successfully").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				Thread.sleep(5000);
				page.waitVisible(pinfo.getbtn_Approvepopup_cancel(), 10);
				page.click(pinfo.getbtn_Approvepopup_cancel());
				Thread.sleep(10000);
				WebElement BackProductinfo=pinfo.getbtn_BackProductinfo();
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BackProductinfo);
				BackProductinfo.click();			
				Thread.sleep(2000);
				ActivityLogWeb activitylog=new ActivityLogWeb();
				activitylog.ActivityLog("9003006","Approve for Publish","Success",StartTime,0,"Product config",Scenario,"Activity Log captured after clicking on Yes button from Approve Product info page");	
				page.click(pinfo.getBtn_productInfo());
				page.waitVisible(pinfo.getBtn_CurrentproductInfo(),5);
				page.click(pinfo.getBtn_CurrentproductInfo());			
				Thread.sleep(2000);
				page.waitVisible(driver.findElement(By.xpath("//div[text()='" +Productcode +"']/../../td[7]")), 10);
				WebElement Approved =driver.findElement(By.xpath("//div[text()='" +Productcode +"']/../../td[7]"));		
				String ApprovedText=Approved.getText();
				System.out.println("The status is---"+ApprovedText);
				Assert.assertTrue(ApprovedText.equalsIgnoreCase("Approved") || ApprovedText.equalsIgnoreCase("Published"), "The Status is not in approved state");
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Approved.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Successfully approved the product Info").addScreenCaptureFromPath(Image1).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Approved.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Product Info is not approved").addScreenCaptureFromPath(Image1).fail(t);	
			}
		}

		else if(pinfo.getBtn_WaitforApproval().getText().contains("( 0 )")){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			System.out.println("No Product Info are there to approve");
			String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_No.png";
			takeScreenshot(Image1, driver);
			Scenario.createNode(Given.class, "No product Shortcut is present for approval").addScreenCaptureFromPath(Image1).pass("PASS");

		}
		else if(!pinfo.getBtn_WaitforApproval().isEnabled()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			System.out.println("Wait for approval is disabled for Super Admin User");
			String Image1 = "images/IT4IT/ProductInfo/ProductInfo_Page_WaitforApproval_Disabled.png";
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
