package com.tmb.automation.test.it4it.UAT2.ProductBrief;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
import com.tmb.automation.pages.web.CCAdmin_phases;
import com.tmb.automation.pages.web.CCAdmin_productBrief;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.pages.web.CCAdmin_productinfo;
import com.tmb.automation.util.ActivityLogWeb;
import com.tmb.automation.util.Base;

public class ProductBrief extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public static String Productname;
	public static ExtentTest Scenario1;
	public static ExtentTest Scenario2;
	public static String ProductBriefID;
	public static String BinButton="Not Validated";
	CCAdmin_productBrief CreateProdBrief;
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
		try
		{
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
			String Image = "images/logged_in.png";
	        takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Logged in successfully on "+Environment+" Environment to automate ProductBrief").addScreenCaptureFromPath(Image).pass("pass");
		}
		catch(Throwable t) {
			ExtentTest Scenario = getFeature().createNode(Scenario.class, "Loging validation");
			String Image = "images/logged_in.png";
	        takeScreenshot(Image, driver);
			Scenario.createNode(Given.class, "Logged in not successfully on "+Environment+" Environment to automate ProductBrief").addScreenCaptureFromPath(Image).fail(t);
		}

		}
	@Test(dataProvider="getExcelData",description="Validate Product Brief with Admin role",priority=1)
	public void ProductShortcut_Validation_Admin(String login,String password) throws Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////

		initialize("IT4IT_Admin");
		verify_Dashboard("Verify Dashboard for Admin Role");


	}
		@Test(dataProvider="getExcelData",description="Validate Product Brief with Super Admin role",priority=2)
		public void ProductBrief_Validation(String login,String password) throws Exception {

			// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////

			initialize("IT4IT");
			verify_Dashboard("Verify Dashboard for Super Admin Role");
			Create_NewProductBrief();
			Approve_Publish_ProductBrief();
			
		}

public void verify_Dashboard(String Scenarioname) throws InterruptedException, ParseException, IOException {
	page = new CCAdmin_Home_Page(driver);
	CreateProdBrief = new CCAdmin_productBrief(driver);
	ExtentTest Scenario = getFeature().createNode(Scenario.class, Scenarioname);
	try {
	page.waitVisible(page.getBtn_Admin(), 20);
	page.click(page.getBtn_Admin());
	page.click(CreateProdBrief.getBtn_product());
	Thread.sleep(1000);
	page.click(CreateProdBrief.getBtn_productBrief());
	page.waitVisible(CreateProdBrief.gettxt_productCode(), 5);
	Thread.sleep(2000);	
	String Image = "images/IT4IT/ProductBrief/ProductBrief_Page.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully navigate to product brief page").addScreenCaptureFromPath(Image).pass("pass");
	}
	catch(Throwable t) {
		String Image = "images/IT4IT/ProductBrief/ProductBrief_Page.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Unable to navigate to product Brief page").addScreenCaptureFromPath(Image).fail(t);

	}
	try {
	Assert.assertTrue(CreateProdBrief.gettxt_productCode().isDisplayed(), "The Product code is displayed");
	Assert.assertTrue(CreateProdBrief.gettxt_Name().isDisplayed(), "The Name is displayed");
	Assert.assertTrue(CreateProdBrief.gettxt_ID().isDisplayed(), "The ID is displayed");
	Assert.assertTrue(CreateProdBrief.gettxt_Description().isDisplayed(), "The Description is displayed");
	Assert.assertTrue(CreateProdBrief.gettxt_Channel().isDisplayed(), "The Channel is displayed");
	Assert.assertTrue(CreateProdBrief.gettxt_LastUpdate().isDisplayed(), "The last update is displayed");
	Assert.assertTrue(CreateProdBrief.gettxt_UpdateBy().isDisplayed(), "The update by is displayed");
	Assert.assertTrue(CreateProdBrief.gettxt_PublishDate().isDisplayed(), "The Publish is displayed");
	Assert.assertTrue(CreateProdBrief.gettxt_Version().isDisplayed(), "The version is displayed");
	Assert.assertTrue(CreateProdBrief.getBtn_WaitforApproval().isDisplayed(), "The Wait for approve button is displayed");		
	Assert.assertTrue(CreateProdBrief.getbtn_new_product_Brief().isDisplayed(), "The new product brief button is displayed");		
	Assert.assertTrue(CreateProdBrief.getbtn_EditProductBrief().isDisplayed(), "The Edit  button is displayed");
	try {
	if(Scenarioname.contains("Super Admin")) {
		Assert.assertTrue(CreateProdBrief.getBtn_WaitforApproval().isEnabled(), "The Wait for approve button is Enabled");		
		String Image = "images/IT4IT/ProductBrief/ProductBrief_Dashboard_header.png";
		takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Successfully Verified presence of header on dashboard for product Brief for super admin role as Wait for approval is Enabled").addScreenCaptureFromPath(Image).pass("PASS");
	}
	else {
		Assert.assertFalse(CreateProdBrief.getBtn_WaitforApproval().isEnabled(), "The Wait for approve button is Disabled");		
		String Image = "images/IT4IT/ProductBrief/ProductBrief_Dashboard_header.png";
		takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Successfully Verified presence of header on dashboard for product Brief for Admin role as Wait for Approval is disabled").addScreenCaptureFromPath(Image).pass("PASS");

	}
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductBrief/ProductBrief_Dashboard_header.png";
		takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Wait for Approval is Disabled for Super Admin User").addScreenCaptureFromPath(Image).fail(t);
	}
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdBrief.getbtn_next());
	Assert.assertTrue(CreateProdBrief.getbtn_next().isEnabled(), "The Next button is Enabled");		
	Assert.assertTrue(!CreateProdBrief.getbtn_previous().isEnabled(), "The previous button should disabled");
	CreateProdBrief.getbtn_secondtab().click();
	Thread.sleep(2000);
	Assert.assertTrue(CreateProdBrief.getbtn_next().isEnabled(), "The Next button is Enable");
	Assert.assertTrue(CreateProdBrief.getbtn_previous().isEnabled(), "The previous button should Enable");
	CreateProdBrief.getbtn_firsttab().click();
	Thread.sleep(2000);
	Assert.assertTrue(CreateProdBrief.getbtn_next().isEnabled(), "The Next button is Enable");		
	Assert.assertTrue(!CreateProdBrief.getbtn_previous().isEnabled(), "The previous button should Disable");
	SimpleDateFormat   lastupdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	System.out.println(CreateProdBrief.getBtn_Date1().getText());
	System.out.println(CreateProdBrief.getBtn_Date2().getText());		
	Date d1 = lastupdate.parse(CreateProdBrief.getBtn_Date1().getText());
    Date d2 = lastupdate.parse(CreateProdBrief.getBtn_Date2().getText());
    Date d3 = lastupdate.parse(CreateProdBrief.getBtn_Date3().getText());
    Assert.assertTrue(d1.after(d2)|| d1.equals(d2),"The dates are shorted newest to oldest");
    Assert.assertTrue(d2.after(d3) || d2.equals(d3),"The dates are shorted newest to oldest");
    List<WebElement> Status=CreateProdBrief.getBtn_StatusProduct();
	for(int i=0;i<Status.size();i++)
	{			
		System.err.println("The status is"+Status.get(i).getText());
		Assert.assertTrue(Status.get(i).getText().equalsIgnoreCase("Draft") ||Status.get(i).getText().equalsIgnoreCase("Approved")||Status.get(i).getText().equalsIgnoreCase("Published"),"The status should be draft or Approved or Published");	
	} 
	String Image = "images/IT4IT/ProductBrief/ProductBrief_Dashboard.png";
    takeScreenshot(Image, driver);
	Scenario.createNode(Given.class, "Successfully verified Product brief Dashboard").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t) {
		String Image = "images/IT4IT/ProductBrief/ProductBrief_Dashboard.png";
	    takeScreenshot(Image, driver);
		Scenario.createNode(Given.class, "Verification Product Brief dashboard is unsuccessfull").addScreenCaptureFromPath(Image).fail(t);

	}
}
public void Create_NewProductBrief() throws InterruptedException, IOException {
	page = new CCAdmin_Home_Page(driver);
	CreateProdBrief = new CCAdmin_productBrief(driver);
	ExtentTest Scenario1 = getFeature().createNode(Scenario.class, "Create New Product Brief");
	try {
	page.click(CreateProdBrief.getbtn_new_product_Brief());
	page.waitVisible(CreateProdBrief.gettext_productcode(),5);
	page.click(CreateProdBrief.gettext_productcode());	
	String Image = "images/IT4IT/ProductBrief/NewProductBrief.png";
    takeScreenshot(Image, driver);
	Scenario1.createNode(Given.class, "Successfully navigated to new product brief page").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t) {
		String Image = "images/IT4IT/ProductBrief/NewProductBrief.png";
	    takeScreenshot(Image, driver);
		Scenario1.createNode(Given.class, "Unable to navigate to new product brief page").addScreenCaptureFromPath(Image).fail(t);

	}
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
	try {
	String noresultfound=driver.findElement(By.tagName("body")).getText();
	Assert.assertTrue(noresultfound.contains("No result found"), "No result found is present");
	System.out.println("the text is---"+noresultfound);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_A);
	robot.keyPress(KeyEvent.VK_DELETE);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_A);
	robot.keyRelease(KeyEvent.VK_DELETE);
	StringSelection stringSelection = new StringSelection("TMB");
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
	String Image = "images/IT4IT/ProductBrief/ProductCode.png";
    takeScreenshot(Image, driver);
	Scenario1.createNode(Given.class, "Successfully selected Product code").addScreenCaptureFromPath(Image).pass("PASS");
	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductBrief/ProductCode.png";
	    takeScreenshot(Image, driver);
		Scenario1.createNode(Given.class, "Issue found on product code").addScreenCaptureFromPath(Image).fail(t);
	}
	try {
	Assert.assertTrue(!CreateProdBrief.gettextproduct_Name().getAttribute("placeholder").equals(""), "Product name is not null");
	Assert.assertTrue(!CreateProdBrief.gettextproduct_Name().isEnabled(), "Product name is Disable");
	Assert.assertTrue(!CreateProdBrief.gettextproduct_ID().getAttribute("placeholder").equals(""), "Product Brief ID is not null");
	Assert.assertTrue(!CreateProdBrief.gettextproduct_ID().isEnabled(), "Product TCID is Disable");
	Productname=CreateProdBrief.gettextproduct_Name().getAttribute("placeholder");
	Assert.assertTrue(CreateProdBrief.gettextproduct_Description().getAttribute("maxlength").equals("255"), "Product Description maximum length is 255");
	page.enter_text(CreateProdBrief.gettextproduct_Description(),"Automation Testing for Create Terms and Conditions");
    page.select_by_id(CreateProdBrief.getProductChannel(), 2);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CreateProdBrief.getBrowse_button1());
    int count=0;
    try {
		List<WebElement> redMandatorymark=CreateProdBrief.getBtn_CreateBriefRedMandatorymark();
		for(int i=0;i<redMandatorymark.size();i++) {
		String Colour=redMandatorymark.get(i).getCssValue("color");	    
		Assert.assertEquals(Colour, "rgba(255, 0, 0, 1)");
		Thread.sleep(3000);
		count++;
		}
		Assert.assertTrue(count==3);
		Scenario1.createNode(Given.class, "Successfully Verified Red * Mandatory mark is present for Product Code, Product Brief Description and Channel").pass("PASS");
		Assert.assertTrue(count>3);
		String Image = "images/IT4IT/ProductShortcut/ProductShortcut_Page_NewProductShortcut_Verification_Red_Add.png";
		takeScreenshot(Image, driver);
		Scenario1.createNode(Given.class, "Successfully Verified Red * Mandatory mark present for Browse Button").addScreenCaptureFromPath(Image).pass("PASS");

	}
	catch(Throwable t){
		String Image = "images/IT4IT/ProductBrief/ProductShortcut_Page_NewProductShortcut_Verification_Red_Add.png";
		takeScreenshot(Image, driver);
		Scenario1.createNode(Given.class, "Red * mandatory is missing at Browse Button").addScreenCaptureFromPath(Image).fail(t);	
	}
     page.click(CreateProdBrief.getBrowse_button1());
    Thread.sleep(2000);
    StringSelection str = new StringSelection(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\ProductBrief\\ProductBrief_wrong.png");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, str);
     robot.keyPress(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_CONTROL);
     robot.keyRelease(KeyEvent.VK_V);
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     Thread.sleep(5000);
     page.waitVisible(CreateProdBrief.getbtn_pdf_3MB_error(), 5);
     String Image = "images/IT4IT/ProductBrief/ProductCodeimage_wrong_upload.png";
     takeScreenshot(Image, driver);
 	Scenario1.createNode(Given.class, "Wrong Image upload Error message verified successfully").addScreenCaptureFromPath(Image).pass("PASS");
	}
	catch(Throwable t) {
		BinButton="Validated";
		String Image = "images/IT4IT/ProductBrief/ProductCodeimage_wrong_upload.png";
	    takeScreenshot(Image, driver);
		Scenario1.createNode(Given.class, "Wrong Image error message 'Sorry, the available image is only 1920 x 1080 Pixel. JPG, PNG . and Maximum 3 MB' is not present").addScreenCaptureFromPath(Image).fail(t);
		page.waitVisible(CreateProdBrief.getbtn_ProductBriefbinbutton(), 5);
		String Image1 = "images/IT4IT/ProductBrief/ProductBrief_Page_ProductBrief_bin.png";
		takeScreenshot(Image, driver);
		Scenario1.createNode(Given.class, "Successfully verified presence of bin button").addScreenCaptureFromPath(Image1).pass("PASS");
		CreateProdBrief.getbtn_ProductBriefbinbutton().click();
		Thread.sleep(2000);
		System.out.println("Bin button in catch "+BinButton);
	}
	
	try {
       page.click(CreateProdBrief.getBrowse_button1());
      Thread.sleep(2000);
       StringSelection str2 = new StringSelection(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\ProductBrief\\ProductBrief.png");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str2, null);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     Thread.sleep(5000);
	     String Image = "images/IT4IT/ProductBrief/ProductCodeimage_upload.png";
		 takeScreenshot(Image, driver);
		 Scenario1.createNode(Given.class, "Image uploaded successfully on THAI Version").addScreenCaptureFromPath(Image).pass("PASS");
if(BinButton.equals("Not Validated")) {
	System.out.println("Bin button is "+BinButton);
	page.waitVisible(CreateProdBrief.getbtn_ProductBriefbinbutton(), 5);
	String Image1 = "images/IT4IT/ProductBrief/ProductBrief_Page_ProductBrief_bin.png";
	takeScreenshot(Image, driver);
	Scenario1.createNode(Given.class, "Successfully verified presence of bin button").addScreenCaptureFromPath(Image1).pass("PASS");
	CreateProdBrief.getbtn_ProductBriefbinbutton().click();
	Thread.sleep(2000);
	 page.click(CreateProdBrief.getBrowse_button1());
     Thread.sleep(2000);
      StringSelection str3 = new StringSelection(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\ProductBrief\\ProductBrief.png");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str3, null);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     Thread.sleep(5000);
	     String Image2 = "images/IT4IT/ProductBrief/ProductCodeimage_upload.png";
		 takeScreenshot(Image, driver);
		 Scenario1.createNode(Given.class, "Image uploaded successfully on THAI Version again after validating the bin button").addScreenCaptureFromPath(Image2).pass("PASS");

}
	
	
	}
	catch(Throwable t) {
		String Image = "images/IT4IT/ProductBrief/ProductCodeimage_upload.png";
	    takeScreenshot(Image, driver);
		Scenario1.createNode(Given.class, "Image not uploaded on Thai version").addScreenCaptureFromPath(Image).fail(t);

		
	}
    // page.click(CreateProdBrief.getBrowse_button1());
	try {
        page.click(CreateProdBrief.getContent_Eng());
        Thread.sleep(2000);
        page.click(CreateProdBrief.getBrowse_button1());
        Thread.sleep(2000);
	     StringSelection str3 = new StringSelection(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\ProductBrief\\ProductBrief.png");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str3, str3);
		     robot.keyPress(KeyEvent.VK_CONTROL);
		     robot.keyPress(KeyEvent.VK_V);
		     robot.keyRelease(KeyEvent.VK_CONTROL);
		     robot.keyRelease(KeyEvent.VK_V);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		     Thread.sleep(5000);
		     String Image = "images/IT4IT/ProductBrief/ProductCodeimage_upload.png";
			    takeScreenshot(Image, driver);
				Scenario1.createNode(Given.class, "Image uploaded successfully on ENG Version").addScreenCaptureFromPath(Image).pass("PASS");

		}
		catch(Throwable t) {
			String Image = "images/IT4IT/ProductBrief/ProductCodeimage_upload.png";
		    takeScreenshot(Image, driver);
			Scenario1.createNode(Given.class, "Image not uploaded on ENG Version").addScreenCaptureFromPath(Image).fail(t);

	}
	try {
		     page.scrollIntoView(CreateProdBrief.getSave_button());
		     Assert.assertTrue(CreateProdBrief.getSave_button().isEnabled(), "Save Button is Enabled");
		    page.click(CreateProdBrief.getSave_button());
		     ((JavascriptExecutor) driver)
		    .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		    page.waitVisible(driver.findElement(By.xpath("//div[text()='" +Productname +"\']/../../td[2]")), 30);
		    Assert.assertTrue(driver.findElement(By.xpath("//div[text()='" +Productname +"\']/../../td[10]")).getText().equalsIgnoreCase("Draft"), "The newely added product brief is in draft state");
		    String Image = "images/IT4IT/ProductBrief/Save_button.png";
		    takeScreenshot(Image, driver);
			Scenario1.createNode(Given.class, "New product brief verified successfully").addScreenCaptureFromPath(Image).pass("PASS");
		 
	}catch(Throwable t) {
				String Image = "images/IT4IT/ProductBrief/Save_button.png";
			    takeScreenshot(Image, driver);
				Scenario1.createNode(Given.class, "Unable to create new product brief").addScreenCaptureFromPath(Image).fail(t);

				    }
}

public void Approve_Publish_ProductBrief() throws Exception, InterruptedException {
	Date date1 =new Date();
	StartTime = date1.getTime();
	((JavascriptExecutor) driver)
    .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	CCAdmin_productinfo pinfo = new CCAdmin_productinfo(driver);
	ExtentTest Scenario2 = getFeature().createNode(Scenario.class, "Approve and Publish Product Brief");
	System.out.println("The number of approvals are---"+pinfo.getBtn_WaitforApproval().getText());
	if(!pinfo.getBtn_WaitforApproval().getText().contains("( 0 )") && pinfo.getBtn_WaitforApproval().isEnabled()) {
		try {
	page.waitVisible(pinfo.getBtn_WaitforApproval(),5);
	page.click(pinfo.getBtn_WaitforApproval());
	page.waitVisible(CreateProdBrief.getbtn_WaitForApprove_ProductBrief(),5);
	ProductBriefID= page.gettextvalue(CreateProdBrief.getbtn_WaitForApprove_ProductBrief());
	WebElement Approvebutton=pinfo.getBtn_Approve();
	boolean IsEnaabled=Approvebutton.isEnabled();
	System.out.println("-----------------"+IsEnaabled);
	Assert.assertEquals(IsEnaabled, false);
	
	String Image = "images/IT4IT/ProductBrief/Approve.png";
    takeScreenshot(Image, driver);
	Scenario2.createNode(Given.class, "Successfully navigate to product brief Approve Page").addScreenCaptureFromPath(Image).pass("PASS");
	}
	catch(Throwable t) {
		
		String Image = "images/IT4IT/ProductBrief/Approve.png";
	    takeScreenshot(Image, driver);
		Scenario2.createNode(Given.class, "Unable to navigate to product Brief Approve page").addScreenCaptureFromPath(Image).fail(t);

	}
try
{
	page.click(pinfo.getBtn_DateButton());
	page.waitVisible(pinfo.getBtn_selectdate(),5);
	page.click(pinfo.getBtn_selectdate());
	WebElement Approvebutton=pinfo.getBtn_Approve();
	Approvebutton.click();		
	// Verify Error Message of Time as well as set current time
	page.waitVisible(pinfo.getBtn_ErrorMessage(),5);
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,80)"," ");
	String Errormessage= page.gettextvalue(pinfo.getBtn_ErrorMessage());
	Assert.assertTrue(Errormessage.equalsIgnoreCase("Please select Date & Time greater than Current Date & Time"), "Error message doesn't displayed or might be changes with some other text");
	Scenario2.createNode(Given.class, "Successfully Verified error message for incorrect date and time").pass("PASS");
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
	Approvebutton.click();
	page.waitVisible(CreateProdBrief.getbtn_Approvepopup(), 10);
	page.click(CreateProdBrief.getbtn_Approvepopup_cancel());
	Thread.sleep(1000);
	Approvebutton=pinfo.getBtn_Approve();
	Approvebutton.click();
	page.waitVisible(CreateProdBrief.getbtn_Approvepopup(), 10);
	page.click(CreateProdBrief.getbtn_Approvepopup());
	Thread.sleep(2000);
	ActivityLogWeb activitylog=new ActivityLogWeb();
	activitylog.ActivityLog("9003006","Approve for Publish","Success",StartTime,0,"Product Brief",Scenario2,"Activity Log captured after clicking on Yes button from Approve Product Brief page");
	page.waitVisible(CreateProdBrief.gettext_Approvepopup(), 10);
	page.click(CreateProdBrief.getBtn_Closepopup());
	Scenario2.createNode(Given.class, "Successfully Verified Approve Popup").pass("PASS");
	WebElement BackProductbrief=CreateProdBrief.getbtn_BackProductBrief();
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BackProductbrief);
	BackProductbrief.click();
	Thread.sleep(2000);
	Scenario2.createNode(Given.class, "Successfully Verified Back to product brief dashboard link ").pass("PASS");
	page.waitVisible(driver.findElement(By.xpath("//div[text()='" +ProductBriefID +"']/../../td[10]")), 10);
	WebElement Approved =driver.findElement(By.xpath("//div[text()='" +ProductBriefID +"']/../../td[10]"));		
	String ApprovedText=Approved.getText();
	System.out.println("The status is---"+ApprovedText);
	Assert.assertTrue(ApprovedText.equalsIgnoreCase("Approved") || ApprovedText.equalsIgnoreCase("Published"), "The Status is not in approved state");
	String Image = "images/IT4IT/ProductBrief/SuccessfullyApprove.png";
    takeScreenshot(Image, driver);
	Scenario2.createNode(Given.class, "Successfully Approved Product Brief").addScreenCaptureFromPath(Image).pass("PASS");	
}
	
	catch(Throwable t) {
		String Image = "images/IT4IT/ProductBrief/SuccessfullyApprove.png";
	    takeScreenshot(Image, driver);
		Scenario2.createNode(Given.class, "Unable to approve Product Brief ").addScreenCaptureFromPath(Image).fail(t);	

	}
	}	
	
	else if(pinfo.getBtn_WaitforApproval().getText().contains("( 0 )")){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println("No Product Brief are there to approve");
		String Image1 = "images/IT4IT/ProductBrief/ProductBrief_Page_WaitforApproval_No.png";
		takeScreenshot(Image1, driver);
		Scenario2.createNode(Given.class, "No product Shortcut is present for approval").addScreenCaptureFromPath(Image1).pass("PASS");

	}
	else if(!pinfo.getBtn_WaitforApproval().isEnabled()) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println("Wait for approval is disabled for Super Admin User");
		String Image1 = "images/IT4IT/ProductBrief/ProductBrief_Page_WaitforApproval_Disabled.png";
		takeScreenshot(Image1, driver);
		Scenario2.createNode(Given.class, "Wait for Approval is in Disabled state for Super Admin Role").addScreenCaptureFromPath(Image1).fail("FAIL");

	}
	
}	
	
	


	

		@AfterTest
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
