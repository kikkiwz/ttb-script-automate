package com.ttbbank.oneapp.pb2.UI.s14030;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tmb.automation.helper.ExtentListeners;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StatementIOS extends BaseScenario {
	
	@Parameters("DeviceProfile")
	@BeforeTest(alwaysRun = true)
	public void BeforeTest(String deviceProfile) {
		testWithDeviceProfile(deviceProfile);
		
		TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentListeners.setDriver(ttbTestContext.getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/StatementIOS.html");
        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest("StatementIOS");
        setFeature(feature);
        setExtentReports(extentReports);
	}

	@Test (groups = "PB2")
    public void Statement() throws InterruptedException, IOException {
    	
        TtbTestContext ttbTestContext = getTtbTestContext();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();

        enterPin();

		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_DEPOSIT_ACCOUNT_LIST).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_ACCOUNT_NICKNAME);
		System.out.println("Waiting for Menu");
		Thread.sleep(20000);
		System.out.println("Continue");
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_MORE_MENU).click();

		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_MENU);
		 
		String Language = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_MENU).getText();
		System.out.println("Language-- " + Language);
		Thread.sleep(1000);
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_BUTTON).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_REQUEST_STATEMENT_TITLE);
		System.out.println("Request Statement Title--"+ ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_REQUEST_STATEMENT_TITLE).getText());
		Thread.sleep(2000);
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SELECT_LANGUAGE_TH_RADIO_BUTTON).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_CONDENSED_STATEMENT_RADIO_BUTTON).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSACTION_PERIOD_FROM_BUTTON).click();
		
		WebElement SelectMonth7 = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SELECT_MONTH7);
		JavascriptExecutor js = (JavascriptExecutor) ttbTestContext.getDriver();
		HashMap<String, Object> month = new HashMap<>();
		month.put("order", "next");
		month.put("offset", 0.15);
		month.put("element", SelectMonth7);
	    for (int i=1;i<7;i++) {
	        js.executeScript("mobile: selectPickerWheelValue", month);
	    }
		
	    Thread.sleep(2000);
	    ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_KEYPAD_DONE).click();	   
	    
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON).click();
		
		String ErrorTitle= ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_TITLE).getText();
		String ErrorDetails= ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_DETAILS).getText();
		System.out.println("ErrorTitle-- "+ErrorTitle);
		System.out.println("ErrorDetails-- "+ErrorDetails);
		
		if (Language.equals("อื่นๆ")) {
			Assert.assertEquals(ErrorTitle, "ท่านเลือกรายการเกินกว่า 6 เดือน");
			Assert.assertEquals(ErrorDetails, "ท่านสามารถขอรายการเดินบัญชีได้สูงสุด 6 เดือนเท่านั้น");
			} else {
				Assert.assertEquals(ErrorTitle, "You request exceeds 6 months");
				Assert.assertEquals(ErrorDetails, "You can have maximum 6 months transaction per request.");			
				}
		
		Thread.sleep(1000);
//		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_OK_BUTTON).click();
		ttbTestContext.getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='Close']")).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSACTION_PERIOD_FROM_BUTTON).click();
		Thread.sleep(2000);
		
		WebElement SelectMonth6 = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SELECT_MONTH6);
		month.put("order", "previous");
		month.put("offset", 0.15);
		month.put("element", SelectMonth6);
	    js.executeScript("mobile: selectPickerWheelValue", month);
		
	    Thread.sleep(2000);
	    ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_KEYPAD_DONE).click();
	    
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_PAGE_LABEL);
		Thread.sleep(2000);
		System.out.println("Statement Title--"+ ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_PAGE_LABEL).getText());
		Thread.sleep(1000);
		
		String SaveButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_SAVE_FILE_BUTTON).getText();
		System.out.println("SaveButton--"+SaveButton);
		Assert.assertNotNull(SaveButton);
		
		String ShareButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_SHARE_FILE_BUTTON).getText();
		System.out.println("ShareButton--"+ShareButton);
		Assert.assertNotNull(ShareButton);
		Thread.sleep(5000);
		
		ExtentTest Scenario = getFeature().createNode(Scenario.class, "Condensed Statement");
        String Image = "images/Condensed Statement.png";
        takeScreenshot(Image);
        Scenario.createNode(Given.class, "Condensed Statement").addScreenCaptureFromPath(Image).pass("pass");
        getExtent().flush();
        Thread.sleep(2000);
        
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_BACKBUTTON).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_REQUEST_STATEMENT_TITLE);
		System.out.println("Request Statement Title--"+ ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_REQUEST_STATEMENT_TITLE).getText());
		Thread.sleep(2000);
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SELECT_LANGUAGE_EN_RADIO_BUTTON).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_DETAILS_STATEMENT_RADIO_BUTTON).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSACTION_PERIOD_FROM_BUTTON).click();
		
		WebElement SelectMonth7a = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SELECT_MONTH7);
		JavascriptExecutor js1 = (JavascriptExecutor) ttbTestContext.getDriver();
		HashMap<String, Object> month1 = new HashMap<> ();
		month1.put("order", "next");
		month1.put("offset", 0.15);
		month1.put("element", SelectMonth7a);
	    for (int i=1;i<7;i++) {
	        js1.executeScript("mobile: selectPickerWheelValue", month1);
	    }
		
	    Thread.sleep(2000);
	    ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_KEYPAD_DONE).click();	   
	    
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON).click();
		
		ErrorTitle= ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_TITLE).getText();
		ErrorDetails= ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_DETAILS).getText();
		System.out.println("ErrorTitle-- "+ErrorTitle);
		System.out.println("ErrorDetails-- "+ErrorDetails);
		
		if (Language.equals("อื่นๆ")) {
			Assert.assertEquals(ErrorTitle, "ท่านเลือกรายการเกินกว่า 6 เดือน");
			Assert.assertEquals(ErrorDetails, "ท่านสามารถขอรายการเดินบัญชีได้สูงสุด 6 เดือนเท่านั้น");
			} else {
				Assert.assertEquals(ErrorTitle, "You request exceeds 6 months");
				Assert.assertEquals(ErrorDetails, "You can have maximum 6 months transaction per request.");			
				}
		
		Thread.sleep(1000);
//		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_EXCEEDS_6MONTHS_OK_BUTTON).click();
		ttbTestContext.getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='Close']")).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSACTION_PERIOD_FROM_BUTTON).click();
		Thread.sleep(2000);
		
		WebElement SelectMonth6a = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SELECT_MONTH6);
		month1.put("order", "previous");
		month1.put("offset", 0.15);
		month1.put("element", SelectMonth6a);
	    js1.executeScript("mobile: selectPickerWheelValue", month1);
		
	    Thread.sleep(2000);
	    ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_KEYPAD_DONE).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_GENERATE_STATEMENT_BUTTON).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_PAGE_LABEL);
		Thread.sleep(2000);
		System.out.println("Statement Title-- "+ ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_PAGE_LABEL).getText());
		Thread.sleep(1000);
		
		SaveButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_SAVE_FILE_BUTTON).getText();
		System.out.println("SaveButton-- "+SaveButton);
		Assert.assertNotNull(SaveButton);
		
		ShareButton = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_STATEMENT_SHARE_FILE_BUTTON).getText();
		System.out.println("ShareButton-- "+ShareButton);
		Assert.assertNotNull(ShareButton);
		Thread.sleep(5000);
		
		Scenario = getFeature().createNode(Scenario.class, "Details Statement");
        Image = "images/Details Statement.png";
        takeScreenshot(Image);
        Scenario.createNode(Given.class, "Details Statement").addScreenCaptureFromPath(Image).pass("pass");
        getExtent().flush();
        Thread.sleep(2000);
		
		System.out.println("Done--");
		Thread.sleep(2000);
    }
	
}
