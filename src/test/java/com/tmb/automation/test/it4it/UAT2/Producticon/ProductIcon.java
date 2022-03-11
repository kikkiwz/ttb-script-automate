package com.tmb.automation.test.it4it.UAT2.Producticon;


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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.tmb.automation.common.MongoDB;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.LoginLogsModel;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.pages.web.CCAdmin_productinfo;
import com.tmb.automation.util.ActivityLogWeb;
import com.tmb.automation.util.Base;

public class ProductIcon extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public static String iconIDvalue;
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
			page.waitVisible(page.getBtn_submit(), 20);
			Thread.sleep(1000);
			page.click(page.getBtn_submit());
			Thread.sleep(3000);
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Loging validation");
			String Image = "images/IT4IT/ProductIcon/logged_in.png";
	        takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Logged in successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).pass("pass");
		}

		@Test(dataProvider="getExcelData",description="Create Product icon",priority=1)
		public void ProductIcon_Validation(String login,String password) throws Exception {

			// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		
			
			verify_Dashboard();
			Create_NewProductIcon();
		    Edit_NewProductIcon();
			Approve_Publish_ProductIcon();
			
		}

public void verify_Dashboard() throws InterruptedException, ParseException, IOException {
	page = new CCAdmin_Home_Page(driver);
	CreateProdicon = new CCAdmin_producticon(driver);
	ExtentTest Scenario=getFeature().createNode(Scenario.class, "Verify Dashboard");
	try {
	page.waitVisible(page.getBtn_Admin(), 20);
	page.click(page.getBtn_Admin());
	page.click(CreateProdicon.getBtn_product());
	page.click(CreateProdicon.getBtn_productIcon());
	page.waitVisible(CreateProdicon.gettxt_iconID(), 5);
	Thread.sleep(2000);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully loaded product Icon page").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Product Icon page not loaded successfully").addScreenCaptureFromPath(Image).fail(t);


	}
	try {
	Assert.assertTrue(CreateProdicon.gettxt_iconID().isDisplayed(), "The Icon ID is displayed");
	Assert.assertTrue(CreateProdicon.gettxt_Name_EN().isDisplayed(), "The Name EN is displayed");
	Assert.assertTrue(CreateProdicon.gettxt_Name_TH().isDisplayed(), "The Bank name TH is displayed");
	Assert.assertTrue(CreateProdicon.gettxt_Description().isDisplayed(), "The Description is displayed");
	Assert.assertTrue(CreateProdicon.gettxt_Design().isDisplayed(), "The Desgin is displayed");
	Assert.assertTrue(CreateProdicon.gettxt_Last_Update().isDisplayed(), "The last update is displayed");
	Assert.assertTrue(CreateProdicon.gettxt_Update_By().isDisplayed(), "The update by is displayed");
	Assert.assertTrue(CreateProdicon.gettxt_Status().isDisplayed(), "The status is displayed");
	Assert.assertTrue(CreateProdicon.getbtn_WaitForApprove().isDisplayed(), "The Wait for approve button is displayed");		
	Assert.assertTrue(CreateProdicon.getbtn_NewproductIcon().isDisplayed(), "The new product icon button is displayed");
	Assert.assertTrue(CreateProdicon.getbtn_DeleteProductIcon().isDisplayed(), "The Delete button is displayed");		
	Assert.assertTrue(CreateProdicon.getbtn_EditProductIcon().isDisplayed(), "The Edit  button is displayed");
	Assert.assertTrue(CreateProdicon.getbtn_NewproductIcon().isEnabled(), "The new product icon button is Enabled");
	Assert.assertTrue(CreateProdicon.getbtn_WaitForApprove().isEnabled(), "The Wait for approve button is Enabled");		
	
	
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Dashboard_header.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Verified presence of header on dashboard").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Dashboard_header.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of header on dashboard is failed").addScreenCaptureFromPath(Image).fail(t);
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
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_Pagination.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully verified pagination").addScreenCaptureFromPath(Image).pass("PASS");
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_Pagination.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of Pagination is failed").addScreenCaptureFromPath(Image).fail(t);
	}
	try {
		SimpleDateFormat   lastupdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(CreateProdicon.getBtn_Date1().getText());
		System.out.println(CreateProdicon.getBtn_Date2().getText());		
		Date d1 = lastupdate.parse(CreateProdicon.getBtn_Date1().getText());
	    Date d2 = lastupdate.parse(CreateProdicon.getBtn_Date2().getText());
	    Date d3 = lastupdate.parse(CreateProdicon.getBtn_Date3().getText());
	    Assert.assertTrue(d1.after(d2)|| d1.equals(d2),"The dates are shorted newest to oldest");
	    Assert.assertTrue(d2.after(d3) || d2.equals(d3),"The dates are shorted newest to oldest");
	    String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_sorting_page1.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Dates are sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_sorting_page1.png";
		    takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are not sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).fail(t);
		}
	try {
		CreateProdicon.getbtn_secondtab().click();
		Thread.sleep(2000);
		CreateProdicon.gettxt_Last_Update().click();
		Assert.assertTrue(CreateProdicon.getbtn_next().isEnabled(), "The Next button is Enable");		
		Assert.assertTrue(!CreateProdicon.getbtn_previous().isEnabled(), "The previous button should Disable");		
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_sorting_except_page1.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "After sorting on any page except page 1 successfully navigates back to page 1").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_sorting_except_page1.png";
		    takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of sorting on any page except page 1 is failed").addScreenCaptureFromPath(Image).fail(t);
		}
	try {
		String iconid1=CreateProdicon.getbtn_Sorting().getText();
		Thread.sleep(1000);
		CreateProdicon.gettxt_iconID().click();
		Thread.sleep(2000);
		String iconid2=CreateProdicon.getbtn_Sorting().getText();
		Assert.assertNotEquals(iconid1,iconid2, "Sorting for ICON ID id working");
		Thread.sleep(1000);
		CreateProdicon.gettxt_iconID().click();
		Thread.sleep(2000);
		Scenario.createNode(Given.class, "Sorting on ICON ID is working fine").pass("PASS");
	}
	catch(Throwable t){
		Scenario.createNode(Given.class, "Sorting on ICON ID is not working").fail(t);	
	}
	try {
		String iconid1=CreateProdicon.getbtn_Sorting().getText();
		Thread.sleep(1000);
		CreateProdicon.gettxt_Name_EN().click();
		Thread.sleep(2000);
		String iconid2=CreateProdicon.getbtn_Sorting().getText();
		Assert.assertNotEquals(iconid1,iconid2, "Sorting for Name EN working fine");
		Thread.sleep(1000);
		CreateProdicon.gettxt_Name_EN().click();
		Thread.sleep(2000);
		Scenario.createNode(Given.class, "Sorting on Name EN is working fine").pass("PASS");
	}
	catch(Throwable t){
		Scenario.createNode(Given.class, "Sorting on Name EN is not working").fail(t);	
	}
	try {
		String iconid1=CreateProdicon.getbtn_Sorting().getText();
		Thread.sleep(1000);
		CreateProdicon.gettxt_Name_TH().click();
		Thread.sleep(2000);
		String iconid2=CreateProdicon.getbtn_Sorting().getText();
		Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Name TH working");
		Thread.sleep(1000);
		CreateProdicon.gettxt_Name_TH().click();
		Thread.sleep(2000);
		Scenario.createNode(Given.class, "Sorting on Name TH is working fine").pass("PASS");
	}
	catch(Throwable t){
		Scenario.createNode(Given.class, "Sorting on Name TH is not working").fail(t);	
	}
	try {
		String iconid1=CreateProdicon.getbtn_Sorting().getText();
		Thread.sleep(1000);
		CreateProdicon.gettxt_Description().click();
		Thread.sleep(2000);
		String iconid2=CreateProdicon.getbtn_Sorting().getText();
		Assert.assertNotEquals(iconid1,iconid2, "Sorting for Description working");
		Thread.sleep(1000);
		CreateProdicon.gettxt_Description().click();
		Thread.sleep(2000);
		Scenario.createNode(Given.class, "Sorting on Description is working fine").pass("PASS");
	}
	catch(Throwable t){
		Scenario.createNode(Given.class, "Sorting on Description is not working").fail(t);	
	}
	try {
		String iconid1=CreateProdicon.getbtn_Sorting().getText();
		Thread.sleep(1000);
		CreateProdicon.gettxt_Design().click();
		Thread.sleep(2000);
		String iconid2=CreateProdicon.getbtn_Sorting().getText();
		Assert.assertEquals(iconid1,iconid2, "Sorting not present on Design");
		Thread.sleep(1000);
		CreateProdicon.gettxt_Design().click();
		Thread.sleep(2000);
		Scenario.createNode(Given.class, "Sorting Should not present for Design").pass("PASS");
	}
	catch(Throwable t){
		Scenario.createNode(Given.class, "Sorting present for Design").fail(t);	
	}
	try {
		String iconid1=CreateProdicon.getbtn_Sorting().getText();
		Thread.sleep(1000);
		CreateProdicon.gettxt_Last_Update().click();
		Thread.sleep(2000);
		String iconid2=CreateProdicon.getbtn_Sorting().getText();
		Assert.assertNotEquals(iconid1,iconid2, "Sorting for Last Update working");
		Thread.sleep(1000);
		CreateProdicon.gettxt_Last_Update().click();
		Thread.sleep(2000);
		Scenario.createNode(Given.class, "Sorting on Last Update is working fine").pass("PASS");
	}
	catch(Throwable t){
		Scenario.createNode(Given.class, "Sorting on Last Update is not working").fail(t);	
	}
	try {
		String iconid1=CreateProdicon.getbtn_Sorting().getText();
		Thread.sleep(1000);
		CreateProdicon.gettxt_Update_By().click();
		Thread.sleep(2000);
		String iconid2=CreateProdicon.getbtn_Sorting().getText();
		Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Update by working");
		Thread.sleep(1000);
		CreateProdicon.gettxt_Update_By().click();
		Scenario.createNode(Given.class, "Sorting on Update By is working fine").pass("PASS");
	}
	catch(Throwable t){
		Scenario.createNode(Given.class, "Sorting on Update By is not working").fail(t);	
	}
	try {
		String iconid1=CreateProdicon.getbtn_Sorting().getText();
		Thread.sleep(1000);
		CreateProdicon.gettxt_Status().click();
		Thread.sleep(2000);
		String iconid2=CreateProdicon.getbtn_Sorting().getText();
		Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Status working");
		Thread.sleep(1000);
		CreateProdicon.gettxt_Status().click();
		Thread.sleep(2000);
		Scenario.createNode(Given.class, "Sorting on Status is working fine").pass("PASS");
	}
	catch(Throwable t){
		Scenario.createNode(Given.class, "Sorting on Status is not working").fail(t);	
	}
	
}
public void Create_NewProductIcon() throws InterruptedException, IOException {
	Date date =new Date();
	StartTime = date.getTime();
	page = new CCAdmin_Home_Page(driver);
	CreateProdicon = new CCAdmin_producticon(driver);
	ExtentTest Scenario=getFeature().createNode(Scenario.class, "Create New Product Icon");
	try {
	page.click(CreateProdicon.getbtn_NewproductIcon());
	page.waitVisible(CreateProdicon.getbtn_CreateiconPageverification(), 5);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Landed on New Product Icon Page").addScreenCaptureFromPath(Image).pass("PASS");
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Create new product icon page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	page.click(CreateProdicon.getBtn_CreateShrortcutCancelbutton());
	page.waitVisible(CreateProdicon.getbtn_NewproductIcon(), 5);
	ActivityLogWeb activitylog=new ActivityLogWeb();
	activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Create Product Icon Cancel",Scenario,"Activity Log captured after clicking on cancel button from Create new Product Icon");
	page.click(CreateProdicon.getbtn_NewproductIcon());
	page.waitVisible(CreateProdicon.getbtn_CreateiconPageverification(), 5);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Landed on New Product Icon Page after clicking on cancel button").addScreenCaptureFromPath(Image).pass("PASS");
	
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Create new product icon page is not loaded after clicking on cancel button").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	WebElement iconID=CreateProdicon.getBtn_iconID();
	WebElement iconNameTH=CreateProdicon.getBtn_iconThaiName();
	WebElement iconNameEN=CreateProdicon.getBtn_iconENGName();
	WebElement iconDescription=CreateProdicon.getBtn_iconDescription();
	iconIDvalue=iconID.getAttribute("value");
	Assert.assertFalse(iconID.getAttribute("value").equals(""));
	Assert.assertTrue(iconNameTH.getAttribute("value").equals(""));
	Assert.assertTrue(iconNameEN.getAttribute("value").equals(""));
	Assert.assertTrue(iconDescription.getAttribute("value").equals(""));
	page.enter_text(CreateProdicon.getBtn_iconThaiName(), "ไอคอนทีเอ็มบีในภาษาไทย");
	page.enter_text(CreateProdicon.getBtn_iconENGName(), "TMB icon in Eng");
	page.enter_text(CreateProdicon.getBtn_iconDescription(), "This icon icon is created for testing purpose through automation");
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Verification.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Verified create new product Icon page").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Verification.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of create new product Icon page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	WebElement redMandatorymark=CreateProdicon.getBtn_CreateShrortcutRedMandatorymark();
	WebElement Addbutton=CreateProdicon.getbtn_CreateiconAddbutton();
	String Colour=redMandatorymark.getCssValue("color");	    
	Assert.assertEquals(Colour, "rgba(255, 0, 0, 1)");
	boolean IsEnaabled=Addbutton.isEnabled();
	Assert.assertEquals(IsEnaabled, false);
	Thread.sleep(3000);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Verification_Red_Add.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Verified Red * Mandatory mark and Add Button is disabled as data is incomplete").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Verification_Red_Add.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of Red * mandatory and Add button is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	WebElement uploadfile=CreateProdicon.getBtn_CreateIconBrowsebutton();
	uploadfile.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Story_ProductIcon_Wrong.png");
	page.waitVisible(CreateProdicon.getBtn_CreateIconBrowsebuttonWrongformat(), 5);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Verification_Wrong_Image.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Verified Error message after uploading wrong format image and error message is "+CreateProdicon.getBtn_CreateIconBrowsebuttonWrongformat().getText()).addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Verification_Wrong_Image.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "No Error message is displayed after uploading wrong format image").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	WebElement uploadfile2=CreateProdicon.getBtn_CreateIconBrowsebutton();
	uploadfile2.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Story_ProductIcon.png");
	Thread.sleep(3000);
	WebElement Addbutton2=CreateProdicon.getbtn_CreateiconAddbutton();
	page.waitclickable(Addbutton2, 60);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Verification_Uploaded.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully uploaded product Icon and Add button is Enabled").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Verification_Uploaded.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of Upload of product icon and Enable of Add button is failed").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	page.click(CreateProdicon.getbtn_CreateiconAddbutton());	
	Thread.sleep(3000);	
	ActivityLogWeb activitylog=new ActivityLogWeb();
	activitylog.ActivityLog("9003013","Create Product Icon","Success",StartTime,0,"Add Product Icon",Scenario,"Activity Log captured after clicking on save button from Create new Product Icon");
	page.waitVisible(driver.findElement(By.xpath("//div[text()='" +iconIDvalue +"\']/../../td[1]")), 30);
	String status=driver.findElement(By.xpath("//div[text()='" +iconIDvalue +"\']/../../td[8]")).getText();
	Assert.assertTrue(status.equalsIgnoreCase("Draft"), "Product icon is created and status is draft");
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Created";
    takeScreenshot(Image, driver);
    Scenario.createNode(Given.class, "Successfully Created new product Icon and status changed to draft").addScreenCaptureFromPath(Image).pass("PASS");
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdicon.getbtn_next());
	Assert.assertTrue(CreateProdicon.getbtn_next().isEnabled(), "The Next button is Enabled");		
	Assert.assertTrue(!CreateProdicon.getbtn_previous().isEnabled(), "The previous button should disabled");
    Scenario.createNode(Given.class, "Successfully verified new product icon created on page 1").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_NewProductIcon_Created.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Create new product icon is failed").addScreenCaptureFromPath(Image).fail(t);	
	}
}


public void Edit_NewProductIcon() throws InterruptedException, IOException {
	Date date =new Date();
	StartTime = date.getTime();
	page = new CCAdmin_Home_Page(driver);
	CreateProdicon = new CCAdmin_producticon(driver);
	ExtentTest Scenario=getFeature().createNode(Scenario.class, "Edit New Product Icon");
	try {
	page.waitVisible(CreateProdicon.getbtn_EditProductIcon(), 5);
	page.click(CreateProdicon.getbtn_EditProductIcon());
	page.waitVisible(CreateProdicon.getbtn_EditiconPageverification(), 5);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Landed on Edit Product Icon Page").addScreenCaptureFromPath(Image).pass("PASS");
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Edit product icon page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	page.click(CreateProdicon.getBtn_CreateShrortcutCancelbutton());
	page.waitVisible(CreateProdicon.getbtn_EditProductIcon(), 5);
	ActivityLogWeb activitylog=new ActivityLogWeb();
	activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Edit Product Icon Cancel",Scenario,"Activity Log captured after clicking on cancel button from Edit Product Icon page");
	page.click(CreateProdicon.getbtn_EditProductIcon());
	page.waitVisible(CreateProdicon.getbtn_EditiconPageverification(), 5);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Landed on Edit Product Icon Page after clicking on cancel button").addScreenCaptureFromPath(Image).pass("PASS");
	
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Edit product icon page is not loaded after clicking on cancel button").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	WebElement iconID=CreateProdicon.getBtn_iconID();
	WebElement iconNameTH=CreateProdicon.getBtn_iconThaiName();
	WebElement iconNameEN=CreateProdicon.getBtn_iconENGName();
	WebElement iconDescription=CreateProdicon.getBtn_iconDescription();
	iconIDvalue=iconID.getAttribute("value");
	Assert.assertFalse(iconID.getAttribute("value").equals(""));
	Assert.assertFalse(iconNameTH.getAttribute("value").equals(""));
	Assert.assertFalse(iconNameEN.getAttribute("value").equals(""));
	Assert.assertFalse(iconDescription.getAttribute("value").equals(""));
	page.clearvalue(CreateProdicon.getBtn_iconENGName());
	page.enter_text(CreateProdicon.getBtn_iconENGName(), "TMB icon in Eng Edited");
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Verification.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Verified Edit product Icon page").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Verification.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of Edit product Icon page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	WebElement Addbutton=CreateProdicon.getbtn_Createiconsavebutton();	
	boolean IsEnaabled=Addbutton.isEnabled();
	Assert.assertEquals(IsEnaabled, true);
	Scenario.createNode(Given.class, "Successfully Verified Add Button is Enabled").pass("PASS");	
	WebElement redMandatorymark=CreateProdicon.getBtn_CreateShrortcutRedMandatorymark();
	String Colour=redMandatorymark.getCssValue("color");	    
	Assert.assertEquals(Colour, "rgba(255, 0, 0, 1)");	
	Thread.sleep(3000);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Verification_Red_Add.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Verified Red * Mandatory mark is visible on edit product icon page").addScreenCaptureFromPath(Image).pass("PASS");
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Verification_Red_Add.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of Red * mandatory is failed on Edit product icon page").addScreenCaptureFromPath(Image).fail(t);	
	}
	
	try {
		page.waitVisible(CreateProdicon.getbtn_bin(), 5);
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_bin.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Successfully verified presence of bin button").addScreenCaptureFromPath(Image).pass("PASS");
		CreateProdicon.getbtn_bin().click();
		Thread.sleep(2000);
			}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_bin.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of bin button is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
	}

	try {
	WebElement uploadfile=CreateProdicon.getBtn_CreateIconBrowsebutton();
	uploadfile.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Story_ProductIcon_Wrong.png");
	page.waitVisible(CreateProdicon.getBtn_CreateIconBrowsebuttonWrongformat(), 5);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Verification_Wrong_Image.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Verified Error message after uploading wrong format image and error message is "+CreateProdicon.getBtn_CreateIconBrowsebuttonWrongformat().getText()).addScreenCaptureFromPath(Image).pass("PASS");
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Verification_Wrong_Image.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "No Error message is displayed after uploading wrong format image").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	WebElement uploadfile2=CreateProdicon.getBtn_CreateIconBrowsebutton();
	uploadfile2.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Story_ProductIcon.png");
	Thread.sleep(3000);
	WebElement Addbutton2=CreateProdicon.getbtn_Createiconsavebutton();
	page.waitclickable(Addbutton2, 60);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Verification_Uploaded.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully uploaded product Icon and Add button is Enabled").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Verification_Uploaded.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of Upload of product icon and Enable of Add button is failed").addScreenCaptureFromPath(Image).fail(t);	
	}
	try {
	page.click(CreateProdicon.getbtn_Createiconsavebutton());	
	Thread.sleep(3000);	
	ActivityLogWeb activitylog=new ActivityLogWeb();
	activitylog.ActivityLog("9003013","Create Product Icon","Success",StartTime,1,"Add Product Icon",Scenario,"Activity Log captured after clicking on Save button from Edit Product Icon page");			
	page.waitVisible(driver.findElement(By.xpath("//div[text()='" +iconIDvalue +"\']/../../td[1]")), 30);
	String status=driver.findElement(By.xpath("//div[text()='" +iconIDvalue +"\']/../../td[8]")).getText();
	Assert.assertTrue(status.equalsIgnoreCase("Draft"), "Product icon is created and status is draft");
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Created";
    takeScreenshot(Image, driver);
    Scenario.createNode(Given.class, "Successfully Edited new product Icon and status changed to draft").addScreenCaptureFromPath(Image).pass("PASS");
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdicon.getbtn_next());
	Assert.assertTrue(CreateProdicon.getbtn_next().isEnabled(), "The Next button is Enabled");		
	Assert.assertTrue(!CreateProdicon.getbtn_previous().isEnabled(), "The previous button should disabled");
    Scenario.createNode(Given.class, "Product Icon Edited successfully on page 1").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_EditProductIcon_Created.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification of Edit product icon is failed").addScreenCaptureFromPath(Image).fail(t);	
	}
}

public void Approve_Publish_ProductIcon() throws Exception, InterruptedException {
	Date date1 =new Date();
	StartTime = date1.getTime();
	CCAdmin_productinfo pinfo = new CCAdmin_productinfo(driver);
	ExtentTest Scenario=getFeature().createNode(Scenario.class, "Approve and Publish Product Icon");	
	System.out.println("The number of approvals are---"+pinfo.getBtn_WaitforApproval().getText());
	if(!pinfo.getBtn_WaitforApproval().getText().contains("( 0 )") && pinfo.getBtn_WaitforApproval().isEnabled()) {
		try {
	page.waitVisible(pinfo.getBtn_WaitforApproval(),5);
	page.click(pinfo.getBtn_WaitforApproval());
	page.waitVisible(CreateProdicon.getbtn_WaitForApprove_IconID(),5);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully Loaded Wait for approval page").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval.png";
		    takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Wait for approval page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
		}
		
	String IconID= page.gettextvalue(CreateProdicon.getbtn_WaitForApprove_IconID());
	WebElement Approvebutton=pinfo.getBtn_Approve();
	boolean IsEnaabled=Approvebutton.isEnabled();
	System.out.println("-----------------"+IsEnaabled);
	Assert.assertEquals(IsEnaabled, false);
	String Image = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_ApproveButton.png";
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
	String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Error_message.png";
    takeScreenshot(Image1, driver);
	Scenario.createNode(Given.class, "Error message is displayed 'Please select Date & Time greater than Current Date & Time'").addScreenCaptureFromPath(Image1).pass("PASS");
	
	}catch(Throwable t){
	String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Error_message.png";
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
	String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_enabled.png";
    takeScreenshot(Image1, driver);
	Scenario.createNode(Given.class, "Successfully entered correct date and time and approve button is enabled").addScreenCaptureFromPath(Image1).pass("PASS");
	
	}
	catch(Throwable t){
		String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_enabled.png";
			    takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Entering correct date and time is unsuccessfull").addScreenCaptureFromPath(Image1).fail(t);	
		}
	try {
	Approvebutton.click();
	page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
	String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Approvepopup.png";
    takeScreenshot(Image1, driver);
	Scenario.createNode(Given.class, "Approve pop-up is visible").addScreenCaptureFromPath(Image1).pass("PASS");
	
	}
	catch(Throwable t){
		String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Approvepopup.png";
			    takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Approve popup is not visible").addScreenCaptureFromPath(Image1).fail(t);	
	}
	try {
	page.click(pinfo.getbtn_Approvepopup_cancel());	
	Thread.sleep(2000);
	ActivityLogWeb activitylog=new ActivityLogWeb();
	activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Approve product cancel",Scenario,"Activity Log captured after clicking on close icon X from Approve Product Icon page");						
	String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Approvepopup_cancel.png";
    takeScreenshot(Image1, driver);
	Scenario.createNode(Given.class, "Cancel button is clicked successfully on approve pop-up ").addScreenCaptureFromPath(Image1).pass("PASS");
	Thread.sleep(1000);
	Approvebutton=pinfo.getBtn_Approve();
	Approvebutton.click();
	page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
	page.click(pinfo.getBtn_Approvepopup());
	Thread.sleep(2000);
	activitylog.ActivityLog("9003006","Approve for Publish","Success",StartTime,0,"Product Icon",Scenario,"Activity Log captured after clicking on Yes button from Approve Product Icon page");			

	}
	catch(Throwable t){
		String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Approvepopup_cancel.png";
			    takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Cancel button is not clicked successfully").addScreenCaptureFromPath(Image1).fail(t);	
	}
	try {
	page.click(CreateProdicon.getBtn_productIcon());
	Thread.sleep(2000);
	page.waitVisible(driver.findElement(By.xpath("//div[text()='" +IconID +"']/../../td[8]")), 10);
	WebElement Approved =driver.findElement(By.xpath("//div[text()='" +IconID +"']/../../td[8]"));		
	String ApprovedText=Approved.getText();
	System.out.println("The status is---"+ApprovedText);
	Assert.assertTrue(ApprovedText.equalsIgnoreCase("Approved") || ApprovedText.equalsIgnoreCase("Published"), "The Status is not in approved state");
	String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Approved.png";
    takeScreenshot(Image1, driver);
	Scenario.createNode(Given.class, "Successfully approved the product icon ").addScreenCaptureFromPath(Image1).pass("PASS");
	
	}
	catch(Throwable t){
		String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Approved.png";
			    takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Product icon is not approved").addScreenCaptureFromPath(Image1).fail(t);	
	}
	}
	else if(CreateProdicon.getbtn_WaitForApprove().getText().contains("( 0 )")){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println("No Product Icon are there to approve");
		String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_No.png";
		takeScreenshot(Image1, driver);
		Scenario.createNode(Given.class, "No product Icon is present for approval").addScreenCaptureFromPath(Image1).pass("PASS");

	}
	else if(!CreateProdicon.getbtn_WaitForApprove().isEnabled()) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println("Wait for approval is disabled for Super Admin User");
		String Image1 = "images/IT4IT/ProductIcon/ProductIcon_Page_WaitforApproval_Disabled.png";
		takeScreenshot(Image1, driver);
		Scenario.createNode(Given.class, "Wait for Approval is in Disabled state for Super Admin Role for Product Icon").addScreenCaptureFromPath(Image1).fail("FAIL");

	}	

	
}	
	
	


		//@Test(priority=2)
		public void CaptureActivityLogs_Createicon() throws InterruptedException {
			Date date =new Date();
			Endtime = date.getTime();
			ActivityLogs_cancel();
			ActivityLogs_Add();

			Thread.sleep(5000);

		}

		@AfterClass
		public void closebrowser() {
			driver.quit();


		}

		public void ActivityLogs_Add() {
			String username = mapData.get("username");
			MongoDB mongoDB = new MongoDB();
			BasicDBObject query = new BasicDBObject();
			query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", username));
			query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9003013"));
			query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
			System.out.println("The query is-----"+query);
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_VIT,
					Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+"202106", query,
					Setting.MONGO_SORTS_BY_COLUMN_VIT, Setting.MONGO_LIMIT);
			System.out.println("The size for add  is ----"+listData.size());
			for(int i=0;i<listData.size();i++) {
				System.out.println("The data is----"+listData.get(i));
			}
			Assert.assertEquals(listData.size(), 1,"The action stored in activity log is more than one");
			LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
			Assert.assertTrue(logsData.activity_type.equals("Create Product icon"), "Save action captured in activity log");
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
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_VIT,
					Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+"202106", query,
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
			Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "IT4IT");
			return Data;
			
			
			}



	}
