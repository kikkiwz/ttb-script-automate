package com.tmb.automation.test.it4it.sprint21.s7419;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.web.CCAdmin_Editproductinfo;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_phases;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.util.Base;

public class EditProductInfo extends Base {
	public WebDriver driver;
	Map<String, String> data;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {

		driver = initializeDriver();
		Extentreportfeature();
		Thread.sleep(3000);
		driver.manage().window().maximize();
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

		mapData = Helper.testData("TestData_it4it_sp11", this.getClass().getSimpleName());
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

	@Test(dataProvider="getExcelData",description="Get Product Info Dashboard and Edit",priority=1)
	public void EditProductInfoDashboard(String login,String password) throws InterruptedException {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		mapData = Helper.testData("TestData_it4it_sp11", this.getClass().getSimpleName());
		CCAdmin_Editproductinfo Editpinfo = new CCAdmin_Editproductinfo(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);


		// GotoProduct Info
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		Thread.sleep(3000);
		page.click(Editpinfo.getBtn_product());
		Thread.sleep(3000);
		page.click(Editpinfo.getBtn_editproductInfobutton());
		page.waitVisible(Editpinfo.getBtn_editproductSelectIcon(), 5);
		page.click(Editpinfo.getBtn_editproductSelectIcon());
		WebElement Savebutton=Editpinfo.getBtn_editproductSelectImageSaveButton();
		boolean IsEnaabled=Savebutton.isEnabled();
		Assert.assertEquals(IsEnaabled, false);
		page.waitVisible(Editpinfo.getBtn_editproductSelectImage(), 5);
		page.click(Editpinfo.getBtn_editproductSelectImage());
		IsEnaabled=Savebutton.isEnabled();
		Assert.assertEquals(IsEnaabled, true);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebutton);
		Savebutton.click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)"," ");
		page.waitVisible(Editpinfo.getBtn_editproductCategory(), 5);
		WebElement Productrdering=Editpinfo.getBtn_editproductCategory();
		page.select_by_id(Productrdering, 2);
		WebElement Productcode=Editpinfo.getBtn_editproduct_code();
		String ProductcodeText=Productcode.getAttribute("value");
		//WebElement Accounttype=Editpinfo.getBtn_editaccount_type();
		WebElement ProductDescription=Editpinfo.getBtn_editproduct_description();
		WebElement ProductNameEN=Editpinfo.getBtn_editproduct_name_en();
		WebElement ProductNameTH=Editpinfo.getBtn_editproduct_name_th();
		WebElement ProductCategoryEN=Editpinfo.getBtn_editproduct_category_en();
		WebElement ProductCategoryTH=Editpinfo.getBtn_editproduct_category_th();
		WebElement AccountTypeEN=Editpinfo.getBtn_editaccount_type_desc_en();
		WebElement AccountTypeTH=Editpinfo.getBtn_editaccount_type_desc_th();
		WebElement MarketingConcept=Editpinfo.getBtn_editmarketing_concept();
		Assert.assertTrue(!Productcode.getAttribute("value").equals(""), "Product Code is either editable or having null value");
		//Assert.assertTrue(!Accounttype.getAttribute("value").equals(""), "Account type is either editable or having null value");
		Assert.assertTrue(!ProductDescription.getAttribute("value").equals(""), "Product Description is either editable or having null value");
		Assert.assertTrue(!ProductNameEN.getAttribute("value").equals(""), "ProductNameEN is either editable or having null value");
		Assert.assertTrue(!ProductNameTH.getAttribute("value").equals(""), "ProductNameTH is either editable or having null value");
		Assert.assertTrue(!ProductCategoryEN.getAttribute("value").equals(""), "ProductCategoryEN is either editable or having null value");
		Assert.assertTrue(!ProductCategoryTH.getAttribute("value").equals(""), "ProductCategoryTH is either editable or having null value");
		Assert.assertTrue(!AccountTypeEN.getAttribute("value").equals(""), "AccountTypeEN is either editable or having null value");
		Assert.assertTrue(!AccountTypeTH.getAttribute("value").equals(""), "AccountTypeTH is either editable or having null value");
		Assert.assertTrue(!MarketingConcept.getAttribute("value").equals(""), "MarketingConcept is either editable or having null value");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
		page.waitVisible(Editpinfo.getBtn_editdebitcardflag(), 5);
		page.click(Editpinfo.getBtn_editdebitcardflag());
		page.waitVisible(Editpinfo.getBtn_editdebitcardfee(), 5);
		page.clearvalue(Editpinfo.getBtn_editdebitcardfee());
		//page.enter_text(Editpinfo.getBtn_editdebitcardfee(),"1000");
		page.waitVisible(Editpinfo.getBtn_editreceivecashback(), 5);
		page.click(Editpinfo.getBtn_editreceivecashback());
		page.waitVisible(Editpinfo.getBtn_editpromptpay(), 5);
		page.click(Editpinfo.getBtn_editpromptpay());	
		page.waitVisible(Editpinfo.getBtn_editcashadvance(), 5);
		page.click(Editpinfo.getBtn_editcashadvance());		
		page.waitVisible(Editpinfo.getBtn_editcardlessWithdraw(), 5);
		page.click(Editpinfo.getBtn_editcardlessWithdraw());
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
		page.waitVisible(Editpinfo.getBtn_editsavealert(), 5);
		page.click(Editpinfo.getBtn_editsavealert());
		page.waitVisible(Editpinfo.getBtn_editpurchaseba(), 5);
		page.click(Editpinfo.getBtn_editpurchaseba());
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
		Thread.sleep(1000);
		page.waitVisible(Editpinfo.getBtn_editsavinggoal(), 5);
		page.click(Editpinfo.getBtn_editsavinggoal());
		page.click(Editpinfo.getBtn_editChequeview());
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
		page.waitVisible(Editpinfo.getBtn_editfeeflag(), 5);
		page.click(Editpinfo.getBtn_editfeeflag());		
		page.waitVisible(Editpinfo.getBtn_editsavefrom(), 5);
		page.click(Editpinfo.getBtn_editsavefrom());		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"," ");
		page.waitVisible(Editpinfo.getBtn_editfeeflag(), 5);
		page.click(Editpinfo.getBtn_editfeeflag());
		page.waitVisible(Editpinfo.getBtn_editallowtransfer(), 5);
		page.click(Editpinfo.getBtn_editallowtransfer());
		page.click(Editpinfo.getBtn_editepayment());		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)"," ");
		page.waitVisible(Editpinfo.getBtn_editaddIcon(), 5);
		page.click(Editpinfo.getBtn_editaddIcon());
		WebElement Savebutton2=Editpinfo.getBtn_editproductSelectImageSaveButton();
		boolean IsEnaabled2=Savebutton2.isEnabled();
		Assert.assertEquals(IsEnaabled2, false);
		page.waitVisible(Editpinfo.getBtn_editaddImage1(), 2);
		page.click(Editpinfo.getBtn_editaddImage1());
		page.waitVisible(Editpinfo.getBtn_editaddImage2(), 2);
		page.click(Editpinfo.getBtn_editaddImage2());
		page.waitVisible(Editpinfo.getBtn_editaddImage3(), 2);
		page.click(Editpinfo.getBtn_editaddImage3());
		page.click(Editpinfo.getBtn_editaddIcon2());
		IsEnaabled2=Savebutton2.isEnabled();
		Assert.assertEquals(IsEnaabled2, true);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebutton);
		Thread.sleep(2000);
		Savebutton2.click();
		WebElement Savebutton3=Editpinfo.getBtn_editfinalsavebutton();
		boolean IsEnaabled3=Savebutton3.isEnabled();
		Assert.assertEquals(IsEnaabled3, true);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Savebutton3);
		Savebutton3.click();
		page.waitVisible(Editpinfo.getBtn_CurrentproductInfo(), 10);
		page.click(Editpinfo.getBtn_CurrentproductInfo());
		WebElement Drafted =driver.findElement(By.xpath("//div[text()='" +ProductcodeText +"\']/../../td[7]/div/div"));		
		String DraftedText=Drafted.getText();
		Assert.assertTrue(DraftedText.equalsIgnoreCase("Draft"), "The Status is in Draft state");
	
	}		
	@AfterClass
	public void closebrowser() {
		driver.quit();

	}
	
	
	
	@DataProvider
	public  Object[][] getExcelData() throws IOException
	{
		Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "EditProductInfo");
		return Data;
		
		
		}
	
	

}
