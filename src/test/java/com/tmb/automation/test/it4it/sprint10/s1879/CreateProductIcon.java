package com.tmb.automation.test.it4it.sprint10.s1879;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.web.CCAdmin_Home_Page;
import com.tmb.automation.pages.web.CCAdmin_phases;
import com.tmb.automation.pages.web.CCAdmin_producticon;
import com.tmb.automation.util.Base;

public class CreateProductIcon extends Base {

	public WebDriver driver;
	Map<String, String> data;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {

		driver = initializeDriver();
		Thread.sleep(3000);
		ExtentListeners.setDriver(driver);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
		String Environment=prop.getProperty("Environment");
		if(Environment.equals("vit")) {
			String url = prop.getProperty("url_vit");
			driver.get(url);		
			driver.findElement(By.xpath("//button[contains(text(),'     ')]")).click();		
			driver.findElement(By.xpath("//a[contains(text(),'Proceed to cc-vit1.oneapp.tmbbank.local (unsafe)')]"))
			.click();
		}
		else if(Environment.equals("dev")) {
			String url = prop.getProperty("url_dev");
			driver.get(url);		
			driver.findElement(By.xpath("//button[contains(text(),'     ')]")).click();		
			driver.findElement(By.xpath("//a[contains(text(),'Proceed to cc-dev1.oneapp.tmbbank.local (unsafe)')]"))
			.click();
		}
		////////////////////////////////////////////// login///////////////////////////////////////////////////

		mapData = Helper.testData("TestData_it4it_sp11", "IT4IT");
		String username = mapData.get("username");
		String password = mapData.get("password");

		// entering usrer name and passwpord
		page.enter_text(page.getIn_username(), username);
		page.enter_text(page.getIn_password(), password);
		Thread.sleep(3000);
		page.waitVisible(page.getBtn_submit(), 20);
		Thread.sleep(1000);
		page.click(page.getBtn_submit());

		Thread.sleep(9000);

	}

	@Test(dataProvider="getExcelData",description="New product Icon created with all the valid details",priority=1)
	public void createProductIcon(String login,String password,String Iconname,String Description) throws InterruptedException {

		// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
		mapData = Helper.testData("TestData_it4it_sp11", "IT4IT");
		//String IconName = mapData.get("IconName");
		//String IconDescrfiption = mapData.get("IconDescription");

		CCAdmin_producticon picon = new CCAdmin_producticon(driver);
		CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);

///////////////////////////////////////create product Icon/////////////////////////////////////////////////////////
		
		Thread.sleep(3000);
		page.waitVisible(page.getBtn_Admin(), 20);
		page.click(page.getBtn_Admin());
		page.click(picon.getBtn_product());
		page.click(picon.getBtn_productIcon());
		page.click(picon.getBtn_createproductICON());
		page.waitVisible(picon.getIn_iconname(), 20);
		// String iconid= page.gettextvalue(picon.getIn_iconid());

		String iconid = picon.getIn_iconid().getAttribute("value");
		page.enter_text(picon.getIn_iconname(), Iconname);
		page.enter_text(picon.getIn_iconDescription(), Description);
		page.uploadLogo(picon.getIn_imglogo(), "crdetcard1.png");
		page.pagescrollbottom();
		// page.click(picon.getImg_imgUploadlogo());
		Thread.sleep(10000);
		page.waitVisible(picon.getBtn_iconSave(), 20);
		page.click(picon.getBtn_iconSave());
		Thread.sleep(3000);
		String iconidXpath = "//div[contains(text(),'" + iconid + "')]";
		Thread.sleep(5000);
		System.out.println(iconidXpath);
		page.pagescrolltop();
		WebElement searchelement = driver.findElement(By.xpath(iconidXpath));
		page.checkElement_multpgae(searchelement, "productIcon_id");
		String nameXpath = iconidXpath + "//..//following::td[1]//div[1]";
		WebElement name = driver.findElement(By.xpath(nameXpath));
		Assert.assertEquals(page.gettextvalue(name), Iconname, "The name logo name is not same as entered");
	}

	////////////////////////// Negative test
	////////////////////////// case///////////////////////////////////////////////////////////////

	
	  @Test(dataProvider="getExcelDatanegetive",description="Product icon validation passed with invalid image size",priority=2) 
	  public void creatProductIcon_Negative(String login,String password,String
	  Iconname,String Description) throws InterruptedException {
	  
	  mapData = Helper.testData("TestData_it4it_sp11","IT4IT"); //String IconName =
	  mapData.get("IconName"); //String IconDescrfiption =
	  mapData.get("IconDescription");
	  
	  CCAdmin_producticon picon = new CCAdmin_producticon(driver);
	  CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);
	  
	  Thread.sleep(3000);
	  
	  ///////////////////////////////////////create product Icon/////////////////////////////////////////////////////////
	  page.waitVisible(page.getBtn_Admin(), 20); page.click(page.getBtn_Admin());
	  page.click(picon.getBtn_product()); page.click(picon.getBtn_productIcon());
	  page.click(picon.getBtn_createproductICON());
	  page.waitVisible(picon.getIn_iconname(), 20); //String iconid=
	  page.gettextvalue(picon.getIn_iconid());
	  
	  String iconid = picon.getIn_iconid().getAttribute("value");
	  page.enter_text(picon.getIn_iconname(), Iconname);
	  page.enter_text(picon.getIn_iconDescription(), Description);
	  page.pagescrollbottom(); 
	  page.uploadLogo(picon.getIn_imglogo(),"tmb logo.png"); Thread.sleep(5000); page.pagescrolltop();
	  boolean key =picon.getTag_imageerror().isDisplayed(); Assert.assertEquals(key, true,"dffirent size image is accpted");
	  
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
	@DataProvider
	public  Object[][] getExcelDatanegetive() throws IOException
	{
		 Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "EditProductShortcut");
		return Data;
		
		
		}
	
	
}