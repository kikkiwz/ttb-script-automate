package com.tmb.automation.test.it4it.sprint32.s22394;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.tmb.automation.common.MongoDB;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.LoginLogsModel;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_bankinfo;
import com.tmb.automation.util.Base;

public class BankInfo_CreateandEdit extends Base {
	public WebDriver driver;
	Map<String, String> data;
	public Long StartTime;
	public Long Endtime;
	public String Environment;
	public String MongoDBdate;
	public static String bankcode;
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
	public void Create_Edit_BakInfo(String login,String password) throws InterruptedException, ParseException, Exception {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		mapData = Helper.testData("TestData_it4it_sp11","IT4IT");
		CCAdmin_bankinfo getBankInfo = new CCAdmin_bankinfo(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);

		String dirpath = System.getProperty("user.dir");
		// Goto Edit/ Add Bank Info
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		page.click(getBankInfo.getBtn_Bankinfo());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		page.waitVisible(getBankInfo.getbtn_BankCode(), 20);
		getBankInfo.getbtn_newCreateBank().click();
		page.waitVisible(getBankInfo.gettxt_Edit_Add_Bankinfo(),20);
		getBankInfo.gettxt_back_to_dashboard().click();
		page.waitVisible(getBankInfo.getbtn_BankCode(), 20);
		getBankInfo.getbtn_newCreateBank().click();
		page.waitVisible(getBankInfo.gettxt_Edit_Add_Bankinfo(),20);
		
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
		Robot robot = new Robot();
		for(int i=1;i<=2;i++) {
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(500);
			}
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
		getBankInfo.getIn_bankcd().sendKeys(bankcode);
		getBankInfo.getIn_bankShortname().sendKeys("Test");
		for(int i=1;i<=4;i++) {
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(500);
		}
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
		getBankInfo.getIn_bankShortname().sendKeys("Test");
		getBankInfo.getIn_banknameEN().sendKeys("TMB");
		for(int i=1;i<=3;i++) {
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			Thread.sleep(500);
			}
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
		getBankInfo.getIn_banknameEN().sendKeys("TMB");
		getBankInfo.getIn_banknameTH().sendKeys("ธนาคาร");
	    Select BankStatus=new Select(getBankInfo.getin_bankStatus());
	    BankStatus.selectByValue("Inactive");
	    Thread.sleep(1000);
	    BankStatus.selectByIndex(0);;
	    Assert.assertTrue(getBankInfo.gettxt_EmptyErrormsg().isDisplayed(), "The Field is required message is displayed");
	    BankStatus.selectByValue("Inactive");
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
		getBankInfo.getUpload_chosebanklogo().sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint32Story22394\\upload_img_bankinfo_Wrong.png"); 
		Assert.assertTrue(getBankInfo.getupload_chosebanklogoErrormsg().isDisplayed(), "The Img should be 240 * 240");
		getBankInfo.getUpload_chosebanklogo().sendKeys(dirpath+"\\src\\main\\resources\\IT4IT\\Sprint32Story22394\\upload_img_bankinfo.png");
		Select PromptPayStatus=new Select(getBankInfo.getSel_promptpayStatus());
		PromptPayStatus.selectByValue("Available");
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PromptPayStatus);
		Assert.assertTrue(!getBankInfo.getbtn_savebank().isEnabled(), "Save button is disabled");
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
		SimpleDateFormat   PromptpayDateformat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(getBankInfo.getBtn_EffectiveDate().getText());
		System.out.println(getBankInfo.getBtn_ExpireDate().getText());				
		Date d1 = PromptpayDateformat.parse(getBankInfo.getBtn_EffectiveDate().getText());
        Date d2 = PromptpayDateformat.parse(getBankInfo.getBtn_ExpireDate().getText());       
        Assert.assertTrue(d2.after(d1),"Not allow expire date bigger than effective date");
        getBankInfo.getbtn_savebank().click();
        WebElement BankCode1=getBankInfo.getbtn_orderNumber();
        page.waitVisible(BankCode1, 20);
        getBankInfo.getbtn_editbankinfo().click();
        page.waitVisible(getBankInfo.gettxt_Edit_Add_Bankinfo(),20);
        Thread.sleep(2000);
        Assert.assertTrue(!getBankInfo.getIn_bankcd().isEnabled(),"Bank code should be disabled");
        Assert.assertTrue(getBankInfo.getbtn_savebank().isEnabled(), "Save button is Enabled");
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
        
	}
	
	//@Test(priority=2)
	public void CaptureActivityLogs_CreateandEditBankifo() throws InterruptedException {
		Date date =new Date();
		Endtime = date.getTime();
		ActivityLogs_save();
		
	}
	public void ActivityLogs_save() {
		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", "occ_padmin02"));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq","9003020"));
		query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
		System.out.println("The query is-----"+query);
		if(Environment.equalsIgnoreCase("vit")) {
		List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_VIT,
				Setting.MONGO_DATABASE_NAME_VIT, Setting.MONGO_COLLECTION_NAME_VIT+MongoDBdate, query,
				Setting.MONGO_SORTS_BY_COLUMN_VIT, Setting.MONGO_LIMIT);
		System.out.println("The size for add  is ----"+listData.size());
		if(listData.size()>0) {
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
			}
		//Assert.assertEquals(listData.size(), 3,"The action stored in activity log is more than one");
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
		Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
		System.out.println("MongoDB connection done sucessfully");
		}
		}
		else if(Environment.equalsIgnoreCase("dev")) {
			List listData = mongoDB.connectDB(Setting.MONGO_CLIENT_URL_DEV,
					Setting.MONGO_DATABASE_NAME_DEV, Setting.MONGO_COLLECTION_NAME_DEV+MongoDBdate, query,
					Setting.MONGO_SORTS_BY_COLUMN_DEV, Setting.MONGO_LIMIT);
			System.out.println("The size for add  is ----"+listData.size());
			if(listData.size()>0) {
			for(int i=0;i<listData.size();i++) {
				System.out.println("The data is----"+listData.get(i));
				}
			//Assert.assertEquals(listData.size(), 3,"The action stored in activity log is more than one");
			LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
			Assert.assertTrue(logsData.activity_status.equals("Success"), "Success status action captured in activity log");
			System.out.println("MongoDB connection done sucessfully");
			}
		}

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
