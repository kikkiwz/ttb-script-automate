package com.tmb.automation.test.it4it.UAT2.ProductShortcut;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.web.CCAdmin_CreateProductShortcut;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_productinfo;
import com.tmb.automation.util.ActivityLogWeb;
import com.tmb.automation.util.Base;

public class ProductShortcut extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public static Long StartTime;
	public static Long Endtime;
	public static String ShortcutIDValue;
	CCAdmin_CreateProductShortcut CreateProdshort;
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
		ExtentTest Scenario = getFeature().createNode(Scenario.class, "Loging validation");
		String Image = "images/IT4IT/ProductShortcut/logged_in.png";
		takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Logged in successfully on "+Environment+" Environment").addScreenCaptureFromPath(Image).pass("pass");
	}

	@Test(dataProvider="getExcelData",description="Validate Product Shortcut with Admin role",priority=1)
	public void ProductShortcut_Validation_Admin(String login,String password) throws Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////

		initialize("IT4IT_Admin");
		verify_Dashboard("Verify Dashboard for Admin Role");
		driver.quit();


	}
	@Test(dataProvider="getExcelData",description="Validate Product Shortcut with Super Admin role",priority=2)
	public void ProductShortcut_Validation_SuperAdmin(String login,String password) throws Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////

		initialize("IT4IT");		
		verify_Dashboard("Verify Dashboard for Super Admin Role");
		Create_NewProductShortcut();
		Edit_NewProductShortcut();
		Approve_Publish_ProductShortcut();

	}

	public void verify_Dashboard(String Scenarioname) throws InterruptedException, ParseException, IOException {
		page = new CCAdmin_Home_Page(driver);
		CreateProdshort = new CCAdmin_CreateProductShortcut(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, Scenarioname);
		try {
			page.waitVisible(page.getBtn_Admin(), 20);
			page.click(page.getBtn_Admin());
			page.click(CreateProdshort.getBtn_product());
			page.click(CreateProdshort.getBtn_CreateProductShortcut());
			page.waitVisible(CreateProdshort.getBtn_newproductshortcut(), 5);
			Thread.sleep(2000);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully loaded product shortcut page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Product shortcut page not loaded successfully").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			Assert.assertTrue(CreateProdshort.gettxt_ShortcutID().isDisplayed(), "The Shortcut ID is displayed");
			Assert.assertTrue(CreateProdshort.gettxt_Name_EN().isDisplayed(), "The Name EN is displayed");
			Assert.assertTrue(CreateProdshort.gettxt_Name_TH().isDisplayed(), "The Bank name TH is displayed");
			Assert.assertTrue(CreateProdshort.gettxt_Description().isDisplayed(), "The Description is displayed");
			Assert.assertTrue(CreateProdshort.gettxt_Design().isDisplayed(), "The Desgin is displayed");
			Assert.assertTrue(CreateProdshort.gettxt_Last_Update().isDisplayed(), "The last update is displayed");
			Assert.assertTrue(CreateProdshort.gettxt_Update_By().isDisplayed(), "The update by is displayed");
			Assert.assertTrue(CreateProdshort.gettxt_Status().isDisplayed(), "The status is displayed");
			Assert.assertTrue(CreateProdshort.getbtn_WaitForApprove().isDisplayed(), "The Wait for approve button is displayed");		
			Assert.assertTrue(CreateProdshort.getBtn_newproductshortcut().isDisplayed(), "The new product icon button is displayed");
			Assert.assertTrue(CreateProdshort.getbtn_DeleteProductShortcut().isDisplayed(), "The Delete button is displayed");		
			Assert.assertTrue(CreateProdshort.getBtn_EditProductShortcut().isDisplayed(), "The Edit  button is displayed");
			Assert.assertTrue(CreateProdshort.getBtn_newproductshortcut().isEnabled(), "The new product icon button is Enabled");
			Assert.assertTrue(CreateProdshort.getbtn_DeleteProductShortcut().isEnabled(), "The Delecte button is Disabled");
			if(Scenarioname.contains("Super Admin")) {
				Assert.assertTrue(CreateProdshort.getbtn_WaitForApprove().isEnabled(), "The Wait for approve button is Enabled");		
				String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Dashboard_header.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Verified presence of header on dashboard for product shortcut for super admin role as Wait for approval is Enabled").addScreenCaptureFromPath(Image).pass("PASS");
			}
			else {
				Assert.assertFalse(CreateProdshort.getbtn_WaitForApprove().isEnabled(), "The Wait for approve button is Disabled");		
				String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Dashboard_header.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Verified presence of header on dashboard for product shortcut for Admin role as Wait for Approval is disabled").addScreenCaptureFromPath(Image).pass("PASS");

			}
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Dashboard_header.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of header on dashboard is failed for product Shortcut").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdshort.getbtn_next());
			Assert.assertTrue(CreateProdshort.getbtn_next().isEnabled(), "The Next button is Enabled");		
			Assert.assertTrue(!CreateProdshort.getbtn_previous().isEnabled(), "The previous button should disabled");
			CreateProdshort.getbtn_secondtab().click();
			Thread.sleep(2000);
			Assert.assertTrue(CreateProdshort.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(CreateProdshort.getbtn_previous().isEnabled(), "The previous button should Enable");
			CreateProdshort.getbtn_firsttab().click();
			Thread.sleep(2000);
			Assert.assertTrue(CreateProdshort.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(!CreateProdshort.getbtn_previous().isEnabled(), "The previous button should Disable");
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_Pagination.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully verified pagination").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_Pagination.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Pagination is failed").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			SimpleDateFormat   lastupdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(CreateProdshort.getBtn_Date1().getText());
			System.out.println(CreateProdshort.getBtn_Date2().getText());		
			Date d1 = lastupdate.parse(CreateProdshort.getBtn_Date1().getText());
			Date d2 = lastupdate.parse(CreateProdshort.getBtn_Date2().getText());
			Date d3 = lastupdate.parse(CreateProdshort.getBtn_Date3().getText());
			Assert.assertTrue(d1.after(d2)|| d1.equals(d2),"The dates are shorted newest to oldest");
			Assert.assertTrue(d2.after(d3) || d2.equals(d3),"The dates are shorted newest to oldest");
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_sorting_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_sorting_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Dates are not sorted as 'Last update  to first, first update to last'").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			CreateProdshort.getbtn_secondtab().click();
			Thread.sleep(2000);
			CreateProdshort.gettxt_Last_Update().click();
			Assert.assertTrue(CreateProdshort.getbtn_next().isEnabled(), "The Next button is Enable");		
			Assert.assertTrue(!CreateProdshort.getbtn_previous().isEnabled(), "The previous button should Disable");		
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_sorting_except_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "After sorting on any page except page 1 successfully navigates back to page 1").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_sorting_except_page1.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of sorting on any page except page 1 is failed").addScreenCaptureFromPath(Image).fail(t);
		}
		try {
			String iconid1=CreateProdshort.getbtn_Sorting().getText();
			Thread.sleep(1000);
			CreateProdshort.gettxt_ShortcutID().click();
			Thread.sleep(2000);
			String iconid2=CreateProdshort.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Shortcut ID id working");
			Thread.sleep(1000);
			CreateProdshort.gettxt_ShortcutID().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Shortcut ID is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Shortcut ID is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdshort.getbtn_Sorting().getText();
			Thread.sleep(1000);
			CreateProdshort.gettxt_Name_EN().click();
			Thread.sleep(2000);
			String iconid2=CreateProdshort.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Name EN working fine");
			Thread.sleep(1000);
			CreateProdshort.gettxt_Name_EN().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Name EN is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Name EN is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdshort.getbtn_Sorting().getText();
			Thread.sleep(1000);
			CreateProdshort.gettxt_Name_TH().click();
			Thread.sleep(2000);
			String iconid2=CreateProdshort.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Name TH working");
			Thread.sleep(1000);
			CreateProdshort.gettxt_Name_TH().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Name TH is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Name TH is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdshort.getbtn_Sorting().getText();
			Thread.sleep(1000);
			CreateProdshort.gettxt_Description().click();
			Thread.sleep(2000);
			String iconid2=CreateProdshort.getbtn_Sorting().getText();
			Assert.assertEquals(iconid1,iconid2, "Sorting for Description working");
			Thread.sleep(1000);
			CreateProdshort.gettxt_Description().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting should not present for Descriptions").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Description is working").fail(t);	
		}
		try {
			String iconid1=CreateProdshort.getbtn_Sorting().getText();
			Thread.sleep(1000);
			CreateProdshort.gettxt_Design().click();
			Thread.sleep(2000);
			String iconid2=CreateProdshort.getbtn_Sorting().getText();
			Assert.assertEquals(iconid1,iconid2, "Sorting not present on Design");
			Thread.sleep(1000);
			CreateProdshort.gettxt_Design().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting Should not present for Design").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting present for Design").fail(t);	
		}
		try {
			String iconid1=CreateProdshort.getbtn_Sorting().getText();
			Thread.sleep(1000);
			CreateProdshort.gettxt_Last_Update().click();
			Thread.sleep(2000);
			String iconid2=CreateProdshort.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1,iconid2, "Sorting for Last Update working");
			Thread.sleep(1000);
			CreateProdshort.gettxt_Last_Update().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Last Update is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Last Update is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdshort.getbtn_Sorting().getText();
			Thread.sleep(1000);
			CreateProdshort.gettxt_Update_By().click();
			Thread.sleep(2000);
			String iconid2=CreateProdshort.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Update by working");
			Thread.sleep(1000);
			CreateProdshort.gettxt_Update_By().click();
			Scenario.createNode(Given.class, "Sorting on Update By is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Update By is not working").fail(t);	
		}
		try {
			String iconid1=CreateProdshort.getbtn_Sorting().getText();
			Thread.sleep(1000);
			CreateProdshort.gettxt_Status().click();
			Thread.sleep(2000);
			String iconid2=CreateProdshort.getbtn_Sorting().getText();
			Assert.assertNotEquals(iconid1.equals(iconid2), "Sorting for Status working");
			Thread.sleep(1000);
			CreateProdshort.gettxt_Status().click();
			Thread.sleep(2000);
			Scenario.createNode(Given.class, "Sorting on Status is working fine").pass("PASS");
		}
		catch(Throwable t){
			Scenario.createNode(Given.class, "Sorting on Status is not working").fail(t);	
		}

	}
	public void Create_NewProductShortcut() throws InterruptedException, IOException {
		Date date =new Date();
		StartTime = date.getTime();
		page = new CCAdmin_Home_Page(driver);
		CreateProdshort = new CCAdmin_CreateProductShortcut(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdshort.getBtn_newproductshortcut());
		Thread.sleep(2000);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Create New Product Shortcut");
		try {
			page.click(CreateProdshort.getBtn_newproductshortcut());
			page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Loaded on New Product Shortcut Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Create new product Shortcut page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			page.click(CreateProdshort.getBtn_CreateShrortcutCancelbutton());
			page.waitVisible(CreateProdshort.getBtn_newproductshortcut(), 5);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Create Product Shortcut Cancel",Scenario,"Activity Log captured after clicking on cancel button from Create new Product Shortcut");
			page.click(CreateProdshort.getBtn_newproductshortcut());
			page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Landed on New Product Shortcut Page after clicking on cancel button").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Create new product icon page is not loaded after clicking on cancel button").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			WebElement ShortcutID=CreateProdshort.getBtn_ShortcutID();
			ShortcutIDValue=ShortcutID.getAttribute("value");
			System.out.println("The Shortcut Id is--"+ShortcutIDValue);
			WebElement ShortcutNameTH=CreateProdshort.getBtn_ShortcutThaiName();
			WebElement ShortcutNameEN=CreateProdshort.getBtn_ShortcutENGName();
			WebElement ShortcutDescription=CreateProdshort.getBtn_ShortcutDescription();
			Assert.assertFalse(ShortcutID.getAttribute("value").equals(""));
			Assert.assertTrue(ShortcutNameTH.getAttribute("value").equals(""));
			Assert.assertTrue(ShortcutNameEN.getAttribute("value").equals(""));
			Assert.assertTrue(ShortcutDescription.getAttribute("value").equals(""));
			page.enter_text(CreateProdshort.getBtn_ShortcutThaiName(),"TMB");			
			Assert.assertTrue(ShortcutNameTH.getAttribute("value").equals(""));
			page.enter_text(CreateProdshort.getBtn_ShortcutENGName(),"ไอคอนทีเอ็มบีในภาษาไทย");
			Assert.assertTrue(ShortcutNameEN.getAttribute("value").equals(""));			
			try {
				page.enter_text(CreateProdshort.getBtn_ShortcutThaiName(),"การทดสอบระบบอัตโนมัติเป็นเทคนิคการทดสอบซอฟต์แวร์เพื่อทดสอบและเปรียบเทียบผลลัพธ์จริงกับผลลัพธ์ที่คาดหวัง");
				Thread.sleep(2000);
				Assert.assertTrue(CreateProdshort.MoreThaiCharError().isDisplayed(),"Thai Error message for more than 100 char should display");
				String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Thai100.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully verified Thai error message for more tham 100 char ").addScreenCaptureFromPath(Image).pass("PASS");
			}
			catch(Throwable t){
				CreateProdshort.getBtn_ShortcutThaiName().clear();
				Thread.sleep(2000);
				CreateProdshort.getBtn_ShortcutThaiName().click();
				String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Thai100.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Verification of error message for More than 100 char on Thai for create new product Shortcut page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
			}
			try {
				page.enter_text(CreateProdshort.getBtn_ShortcutENGName(),"Automation testing is a Software testing technique to test and compare the actual outcome with the expected outcome");
				Thread.sleep(2000);
				Assert.assertTrue(CreateProdshort.MoreEngCharError().isDisplayed(),"English Error message for more than 100 char should display");
				String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Eng100.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully verified English error message for more tham 100 char ").addScreenCaptureFromPath(Image).pass("PASS");
			}
			catch(Throwable t){
				CreateProdshort.getBtn_ShortcutENGName().clear();
				Thread.sleep(2000);
				CreateProdshort.getBtn_ShortcutENGName().click();
				String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Eng100.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Verification of error message for More than 100 char on English for create new product Shortcut page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
			}
			try {
				page.enter_text(CreateProdshort.getBtn_ShortcutDescription(),"Automation testing is a Software testing technique to test and compare the actual outcome with the expected outcome. This can be achieved by writing test scripts or using any automation testing tool. Test automation is used to automate repetitive tasks and other testing tasks which are difficult to perform manually.");
				Thread.sleep(2000);
				Assert.assertTrue(CreateProdshort.MoreThaiCharError().isDisplayed(),"Description Error message for more than 100 char should display");
				String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Description.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully verified Description error message for more tham 255 char ").addScreenCaptureFromPath(Image).pass("PASS");
			}
			catch(Throwable t){
				CreateProdshort.getBtn_ShortcutDescription().clear();
				Thread.sleep(2000);
				CreateProdshort.getBtn_ShortcutDescription().click();
				String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Description.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Verification of error message for More than 255 char on Description for create new product Shortcut page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
			}

			page.enter_text(CreateProdshort.getBtn_ShortcutThaiName(),"ไอคอนทีเอ็มบีในภาษาไทย");
			page.enter_text(CreateProdshort.getBtn_ShortcutENGName(), "TMB Shortcut in Eng");
			page.enter_text(CreateProdshort.getBtn_ShortcutDescription(), "This shortcut icon is created for testing purpose through automation");
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Verification.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Verified create new product Shortcut page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Verification.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of create new product Shortcut page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			WebElement redMandatorymark=CreateProdshort.getBtn_CreateShrortcutRedMandatorymark();
			WebElement Addbutton=CreateProdshort.getBtn_CreateShrortcutAddbutton();
			String Colour=redMandatorymark.getCssValue("color");	    
			Assert.assertEquals(Colour, "rgba(255, 0, 0, 1)");
			boolean IsEnaabled=Addbutton.isEnabled();
			Assert.assertEquals(IsEnaabled, false);
			Thread.sleep(3000);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Verification_Red_Add.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Verified Red * Mandatory mark and Add Button is disabled as data is incomplete").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Verification_Red_Add.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Red * mandatory and Add button is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			WebElement uploadfile=CreateProdshort.getBtn_CreateShrortcutBrowsebutton();
			uploadfile.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Story_8275_wrong.png");
			page.waitVisible(CreateProdshort.getBtn_CreateShrortcutBrowsebuttonWrongformat(), 5);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Verification_Wrong_Image.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Verified Error message after uploading wrong format image and error message is "+CreateProdshort.getBtn_CreateShrortcutBrowsebuttonWrongformat().getText()).addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Verification_Wrong_Image.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "No Error message is displayed after uploading wrong format image").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			WebElement uploadfile2=CreateProdshort.getBtn_CreateShrortcutBrowsebutton();
			uploadfile2.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Shortcut_img1.png");
			Thread.sleep(3000);
			WebElement Addbutton2=CreateProdshort.getBtn_CreateShrortcutAddbutton();
			Assert.assertTrue(CreateProdshort.getBtn_CreateShrortcutAddbutton().isEnabled(),"The add button is enabled successfully");	page.waitclickable(Addbutton2, 60);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Verification_Uploaded.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully uploaded product Shortcut and Add button is Enabled").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_NewProductIcon_Verification_Uploaded.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Upload of product Shortcut and Enable of Add button is failed").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			page.click(CreateProdshort.getBtn_CreateShrortcutAddbutton());	
			Thread.sleep(3000);	
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9003013","Create Product Shortcut","Success",StartTime,0,"Add Product Shortcut",Scenario,"Activity Log captured after clicking on save button from Create new Product Shortcut");
			System.out.println("The shortcut id is--"+ShortcutIDValue);
			page.waitVisible(driver.findElement(By.xpath("//div[text()='" +ShortcutIDValue +"\']/../../td[1]")), 30);
			String status=driver.findElement(By.xpath("//div[text()='" +ShortcutIDValue +"\']/../../td[8]")).getText();
			Assert.assertTrue(status.equalsIgnoreCase("Draft"), "Product Shortcut is created and status is draft");
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Created";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Created new product Shortcut and status changed to draft").addScreenCaptureFromPath(Image).pass("PASS");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdshort.getbtn_next());
			Assert.assertTrue(CreateProdshort.getbtn_next().isEnabled(), "The Next button is Enabled");		
			Assert.assertTrue(!CreateProdshort.getbtn_previous().isEnabled(), "The previous button should disabled");
			Scenario.createNode(Given.class, "Successfully verified new product Shortcut created on page 1").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Created.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Create new product Shortcut is failed").addScreenCaptureFromPath(Image).fail(t);	
		}
	}


	public void Edit_NewProductShortcut() throws InterruptedException, IOException {
		Date date =new Date();
		StartTime = date.getTime();
		page = new CCAdmin_Home_Page(driver);
		CreateProdshort = new CCAdmin_CreateProductShortcut(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Edit Product Shortcut");
		try {
			page.waitVisible(CreateProdshort.getBtn_EditProductShortcut(), 5);
			page.click(CreateProdshort.getBtn_EditProductShortcut());
			page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);
			String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_EditProductShortcut.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Loaded on Edit Product Icon Page").addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Edit product Shortcut page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			page.click(CreateProdshort.getBtn_CreateShrortcutCancelbutton());
			page.waitVisible(CreateProdshort.getBtn_EditProductShortcut(), 5);
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Edit Product Shortcut Cancel",Scenario,"Activity Log captured after clicking on cancel button from Edit Product Shortcut page");
			page.click(CreateProdshort.getBtn_EditProductShortcut());
			page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Landed on Edit Product Shortcut Page after clicking on cancel button").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Edit product icon page is not loaded after clicking on cancel button").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			page.waitVisible(CreateProdshort.getBtn_ShortcutID(), 5);		
			WebElement ShortcutID=CreateProdshort.getBtn_ShortcutID();
			WebElement ShortcutNameTH=CreateProdshort.getBtn_ShortcutThaiName();
			WebElement ShortcutNameEN=CreateProdshort.getBtn_ShortcutENGName();
			WebElement ShortcutDescription=CreateProdshort.getBtn_ShortcutDescription();
			Assert.assertFalse(ShortcutID.getAttribute("value").equals(""));
			Assert.assertFalse(ShortcutNameTH.getAttribute("value").equals(""));
			Assert.assertFalse(ShortcutNameEN.getAttribute("value").equals(""));
			Assert.assertFalse(ShortcutDescription.getAttribute("value").equals(""));
			page.clearvalue(CreateProdshort.getBtn_ShortcutENGName());
			page.enter_text(CreateProdshort.getBtn_ShortcutENGName(), "TMB Shortcut in Eng Edited");
			page.enter_text(CreateProdshort.getBtn_ShortcutDescription(), "This product shortcut  is edited for testing purpose through automation");
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Verification.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Verified Edit product Shortcut page").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Verification.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Edit product Shortcut page is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			WebElement Addbutton=CreateProdshort.getBtn_EditShrortcutsavebutton();	
			boolean IsEnaabled=Addbutton.isEnabled();
			Assert.assertEquals(IsEnaabled, true);
			Scenario.createNode(Given.class, "Successfully Verified Add Button is Enabled").pass("PASS");	
			/*WebElement redMandatorymark=CreateProdshort.getBtn_CreateShrortcutRedMandatorymark();
			String Colour=redMandatorymark.getCssValue("color");	    
			Assert.assertEquals(Colour, "rgba(255, 0, 0, 1)");	
			Thread.sleep(3000);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Verification_Red_Add.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Verified Red * Mandatory mark is visible on edit product Shortcut page").addScreenCaptureFromPath(Image).pass("PASS");*/
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Verification_Red_Add.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Red * mandatory is failed on Edit product Shortcut page").addScreenCaptureFromPath(Image).fail(t);	
		}

		try {
			page.waitVisible(CreateProdshort.getBtn_EditShrortcutbinbutton(), 5);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_bin.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully verified presence of bin button").addScreenCaptureFromPath(Image).pass("PASS");
			CreateProdshort.getBtn_EditShrortcutbinbutton().click();
			Thread.sleep(2000);
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_bin.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of bin button is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);	
		}

		try {
			WebElement uploadfile=CreateProdshort.getBtn_CreateShrortcutBrowsebutton();
			uploadfile.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Story_8275_wrong.png");
			page.waitVisible(CreateProdshort.getBtn_CreateShrortcutBrowsebuttonWrongformat(), 5);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Verification_Wrong_Image.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Verified Error message after uploading wrong format image and error message is "+CreateProdshort.getBtn_CreateShrortcutBrowsebuttonWrongformat().getText()).addScreenCaptureFromPath(Image).pass("PASS");
		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Verification_Wrong_Image.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "No Error message is displayed after uploading wrong format image").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			WebElement uploadfile2=CreateProdshort.getBtn_CreateShrortcutBrowsebutton();
			uploadfile2.sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint22Story8275\\Shortcut_img1.png");
			Thread.sleep(3000);
			WebElement Addbutton2=CreateProdshort.getBtn_EditShrortcutsavebutton();
			page.waitclickable(Addbutton2, 60);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Verification_Uploaded.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully uploaded product Shortcut and Add button is Enabled").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Verification_Uploaded.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Upload of product Shortcut and Enable of Add button is failed").addScreenCaptureFromPath(Image).fail(t);	
		}
		try {
			page.click(CreateProdshort.getBtn_EditShrortcutsavebutton());	
			Thread.sleep(3000);	
			ActivityLogWeb activitylog=new ActivityLogWeb();
			activitylog.ActivityLog("9003013","Create Product Shortcut","Success",StartTime,1,"Add Product Shortcut",Scenario,"Activity Log captured after clicking on Save button from Edit Product Shortcut page");			
			page.waitVisible(driver.findElement(By.xpath("//div[text()='" +ShortcutIDValue +"\']/../../td[1]")), 30);
			String status=driver.findElement(By.xpath("//div[text()='" +ShortcutIDValue +"\']/../../td[8]")).getText();
			Assert.assertTrue(status.equalsIgnoreCase("Draft"), "Product Shortcut is created and status is draft");
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Created";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Successfully Edited new product Icon and status changed to draft").addScreenCaptureFromPath(Image).pass("PASS");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdshort.getbtn_next());
			Assert.assertTrue(CreateProdshort.getbtn_next().isEnabled(), "The Next button is Enabled");		
			Assert.assertTrue(!CreateProdshort.getbtn_previous().isEnabled(), "The previous button should disabled");
			Scenario.createNode(Given.class, "Product Shortcut Edited successfully on page 1").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t){
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_EditProductShortcut_Created.png";
			takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Verification of Edit product Shortcut is failed").addScreenCaptureFromPath(Image).fail(t);	
		}
	}

	public void Approve_Publish_ProductShortcut() throws Exception, InterruptedException {
		Date date1 =new Date();
		StartTime = date1.getTime();
		CCAdmin_productinfo pinfo = new CCAdmin_productinfo(driver);
		ExtentTest Scenario=getFeature().createNode(Scenario.class, "Approve and Publish Product Shortcut");

		System.out.println("The number of approvals are---"+pinfo.getBtn_WaitforApproval().getText());
		if(!pinfo.getBtn_WaitforApproval().getText().contains("( 0 )") && pinfo.getBtn_WaitforApproval().isEnabled()) {
			try {
				page.waitVisible(pinfo.getBtn_WaitforApproval(),5);
				page.click(pinfo.getBtn_WaitforApproval());
				page.waitVisible(CreateProdshort.btn_WaitForApprove_ShortcutIDtext(),5);
				String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_WaitforApproval.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Successfully Loaded Wait for approval page").addScreenCaptureFromPath(Image).pass("PASS");

			}
			catch(Throwable t){
				String Image = "images/IT4IT/ProductShortcut/ProductIcon_Page_WaitforApproval.png";
				takeScreenshot(Image, driver);
				Scenario.createNode(Given.class, "Wait for approval page is not loaded").addScreenCaptureFromPath(Image).fail(t);	
			}

			String ShortcutID= page.gettextvalue(CreateProdshort.btn_WaitForApprove_ShortcutIDtext());
			WebElement Approvebutton=pinfo.getBtn_Approve();
			boolean IsEnaabled=Approvebutton.isEnabled();
			System.out.println("-----------------"+IsEnaabled);
			Assert.assertEquals(IsEnaabled, false);
			String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_ApproveButton.png";
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
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Error_message.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Error message is displayed 'Please select Date & Time greater than Current Date & Time'").addScreenCaptureFromPath(Image1).pass("PASS");

			}catch(Throwable t){
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Error_message.png";
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
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_enabled.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Successfully entered correct date and time and approve button is enabled").addScreenCaptureFromPath(Image1).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_enabled.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Entering correct date and time is unsuccessfull").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				Approvebutton.click();
				page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Approvepopup.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Approve pop-up is visible").addScreenCaptureFromPath(Image1).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Approvepopup.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Approve popup is not visible").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				Thread.sleep(2000);
				page.click(pinfo.getbtn_Approvepopup_close());	
				Thread.sleep(2000);
				ActivityLogWeb activitylog=new ActivityLogWeb();
				activitylog.ActivityLog("9000002","Close Pop-up","Success",StartTime,1,"Approve product cancel",Scenario,"Activity Log captured after clicking on close icon X from Approve Product Shortcut page");					
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Approvepopup_cancel.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Cancel button is clicked successfully on approve pop-up ").addScreenCaptureFromPath(Image1).pass("PASS");
				Thread.sleep(1000);
				Approvebutton=pinfo.getBtn_Approve();
				Approvebutton.click();
				page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
				page.click(pinfo.getBtn_Approvepopup());
				activitylog.ActivityLog("9003006","Approve for Publish","Success",StartTime,0,"Product Shortcut",Scenario,"Activity Log captured after clicking on Yes button from Approve Product Shortcut page");			

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Approvepopup_cancel.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Cancel button is not clicked successfully").addScreenCaptureFromPath(Image1).fail(t);	
			}
			try {
				Thread.sleep(5000);
				page.waitVisible(pinfo.getbtn_Approvepopup_cancel(), 10);
				page.click(pinfo.getbtn_Approvepopup_cancel());
				Thread.sleep(10000);
				WebElement BackProductshortcut=CreateProdshort.getbtn_BackProductShortcut();
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BackProductshortcut);
				BackProductshortcut.click();			
				Thread.sleep(2000);
				page.waitVisible(driver.findElement(By.xpath("//div[text()='" +ShortcutID +"']/../../td[8]")), 10);
				WebElement Approved =driver.findElement(By.xpath("//div[text()='" +ShortcutID +"']/../../td[8]"));		
				String ApprovedText=Approved.getText();
				System.out.println("The status is---"+ApprovedText);
				Assert.assertTrue(ApprovedText.equalsIgnoreCase("Approved") || ApprovedText.equalsIgnoreCase("Published"), "The Status is not in approved state");
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Approved.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Successfully approved the product Shortcut ").addScreenCaptureFromPath(Image1).pass("PASS");

			}
			catch(Throwable t){
				String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Approved.png";
				takeScreenshot(Image1, driver);
				Scenario.createNode(Given.class, "Product Shortcut is not approved").addScreenCaptureFromPath(Image1).fail(t);	
			}
		}

		else if(CreateProdshort.getbtn_WaitForApprove().getText().contains("( 0 )")){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			System.out.println("No Product Shortcut are there to approve");
			String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_No.png";
			takeScreenshot(Image1, driver);
			Scenario.createNode(Given.class, "No product Shortcut is present for approval").addScreenCaptureFromPath(Image1).pass("PASS");

		}
		else if(!CreateProdshort.getbtn_WaitForApprove().isEnabled()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			System.out.println("Wait for approval is disabled for Super Admin User");
			String Image1 = "images/IT4IT/ProductShortcut/ProductShortcut_Page_WaitforApproval_Disabled.png";
			takeScreenshot(Image1, driver);
			Scenario.createNode(Given.class, "Wait for Approval is in Disabled state for Super Admin Role for Product Shortcut").addScreenCaptureFromPath(Image1).fail("FAIL");

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
