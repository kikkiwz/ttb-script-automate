package com.tmb.automation.test.it4it.sprint20.s1332;



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
	import com.tmb.automation.pages.web.CCAdmin_Home_Page;
	import com.tmb.automation.pages.web.CCAdmin_phases;
	import com.tmb.automation.pages.web.CCAdmin_producticon;
	import com.tmb.automation.pages.web.CCAdmin_productinfo;
	import com.tmb.automation.util.Base;

	public class PublishProductInfo  extends Base {
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
			}
			////////////////////////////////////////////// login///////////////////////////////////////////////////

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

		@Test(dataProvider="getExcelData",description="Get Product Info and publish",priority=1)
		public void PublishProductInfo(String login,String password) throws InterruptedException {

			// ////////////////////////////////////////////TestData///////////////////////////////////////////////////////////////////////////
			mapData = Helper.testData("TestData_it4it_sp11", this.getClass().getSimpleName());
			CCAdmin_productinfo pinfo = new CCAdmin_productinfo(driver);
			CCAdmin_Home_Page page = new CCAdmin_Home_Page(driver);


			// GotoProduct Info

			page.waitVisible(page.getBtn_Admin(), 20);
			page.click(page.getBtn_Admin());
			page.click(pinfo.getBtn_product());
			page.click(pinfo.getBtn_productInfo());
			page.waitVisible(pinfo.getBtn_WaitforApproval(),5);
			page.click(pinfo.getBtn_WaitforApproval());
			page.waitVisible(pinfo.getBtn_Productcode(),5);
			
			//Verify Approve Button is Disabled
			
			
			String Productcode= page.gettextvalue(pinfo.getBtn_Productcode());
			WebElement Approvebutton=pinfo.getBtn_Approve();
			boolean IsEnaabled=Approvebutton.isEnabled();
			System.out.println("-----------------"+IsEnaabled);
			Assert.assertEquals(IsEnaabled, false);
			page.click(pinfo.getBtn_DateButton());
			page.waitVisible(pinfo.getBtn_selectdate(),5);
			page.click(pinfo.getBtn_selectdate());
			Approvebutton.click();
			
			// Verify Error Message of Time as well as set current time
			page.waitVisible(pinfo.getBtn_ErrorMessage(),5);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,80)"," ");
			String Errormessage= page.gettextvalue(pinfo.getBtn_ErrorMessage());
			Assert.assertTrue(Errormessage.equalsIgnoreCase("Please select Date & Time greater than Current Date & Time"), "Error message doesn't displayed or might be changes with some other text");
			DateFormat dateFormat = new SimpleDateFormat("HH");
			Date date = new Date();
			String hour= dateFormat.format(date);
			System.out.println("time is " +hour);
			DateFormat dateFormat2 = new SimpleDateFormat("mm");
			Date date2 = new Date();
			String min= dateFormat2.format(date2);
			System.out.println("time is " +min);
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
			page.select_by_value(pinfo.getBtn_selecthour(), finalhourtring);
			page.select_by_value(pinfo.getBtn_selectminute(), finalminutestring);
			boolean IsEnaablednow=Approvebutton.isEnabled();
			System.out.println("-----------------"+IsEnaablednow);
			Assert.assertEquals(IsEnaablednow, true);
			Approvebutton.click();
			page.waitVisible(pinfo.getBtn_Approvepopup(), 10);
			page.click(pinfo.getBtn_Approvepopup());
			page.waitVisible(pinfo.gettext_Approvepopup(), 10);
			page.click(pinfo.getBtn_Closepopup());
			
			// Verify Approve under current product Info
			
			
			page.click(pinfo.getBtn_productInfo());
			page.waitVisible(pinfo.getBtn_CurrentproductInfo(),5);
			page.click(pinfo.getBtn_CurrentproductInfo());
			WebElement Approved =driver.findElement(By.xpath("//div[text()='" +Productcode +"\']/../../td[7]/div/div"));		
			String ApprovedText=Approved.getText();
			Assert.assertTrue(ApprovedText.equalsIgnoreCase("Approved"), "The Status is not in approved state");
			Thread.sleep(150000);
			page.click(pinfo.getBtn_NewFeedproductInfo());
			Thread.sleep(5000);
			page.click(pinfo.getBtn_CurrentproductInfo());
			Thread.sleep(5000);
			Thread.sleep(150000);
			page.click(pinfo.getBtn_NewFeedproductInfo());
			Thread.sleep(5000);
			page.click(pinfo.getBtn_CurrentproductInfo());
			Thread.sleep(5000);
			WebElement published =driver.findElement(By.xpath("//div[text()='" +Productcode +"\']/../../td[7]/div/div"));		
			String publishedText=published.getText();
			Assert.assertTrue(publishedText.equalsIgnoreCase("Published"), "The Status is not in Published state");
		}

		
		@AfterClass
		public void closebrowser() {
			driver.quit();
			

		}
		
		
		
		@DataProvider
		public  Object[][] getExcelData() throws IOException
		{
			Object Data[][]=Helper.testadataDataprovider("TestData_it4it_sp11", "PublishProductInfo");
			return Data;
			
			
			}
		
		

	}



