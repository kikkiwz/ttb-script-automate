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
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ActivityDetailsAndroid extends BaseScenario {
	
	@Parameters("DeviceProfile")
	@BeforeTest(alwaysRun = true)
	public void BeforeTest(String deviceProfile) {
		testWithDeviceProfile(deviceProfile);
		
		TtbTestContext ttbTestContext = getTtbTestContext();
        ExtentListeners.setDriver(ttbTestContext.getDriver());
        ExtentReports extentReports = new ExtentReports();
        ExtentReporter extentReporter = new ExtentHtmlReporter("reports/ActivityDetailsAndroid.html");
        extentReports.attachReporter(extentReporter);
        ExtentTest feature = extentReports.createTest("ActivityDetailsAndroid");
        setFeature(feature);
        setExtentReports(extentReports);
	}

	@Test (groups = "PB2")
    public void Activity() throws InterruptedException, IOException {
    	
        TtbTestContext ttbTestContext = getTtbTestContext();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.ACCOUNT_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON).click();

        enterPin();

		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_DEPOSIT_ACCOUNT_LIST).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_ACCOUNT_NICKNAME);
		System.out.println("Waiting for Menu");
		Thread.sleep(20000);
		System.out.println("Continue");
		
		String Language = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_ACTIVITY).getText();
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_ACTIVITY).click();
		
		if (Language.equals("ค้นหา")) {
			ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_FIELD).sendKeys("โอนเงินออก");
		} else {
			ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_FIELD).sendKeys("Transfer out");
		}
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_BUTTON).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_ACTIVITY_DATE_TITLE);
		Thread.sleep(1000);
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_EXPEND_ACTIVITY).click();
		Thread.sleep(1000);
		
		String TransferOutTitle = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_ACTIVITY_TRANSFER_TITLE).getText();
		System.out.println("TransferOutTitle-- "+TransferOutTitle);
		Assert.assertNotNull(TransferOutTitle);
		
		String TransferOutBeforeAmount = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_BEFOREAMOUNT).getText();
		System.out.println("TransferOutBeforeAmount-- "+TransferOutBeforeAmount);
		Assert.assertEquals("-", TransferOutBeforeAmount);
		
		String TransferOutAmount = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_AMOUNT).getText();
		System.out.println("TransferOutAmount-- "+TransferOutAmount);
		Assert.assertNotNull(TransferOutAmount);
		
		String TransferOutDate = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_DATE).getText();
		System.out.println("TransferOutDate-- "+TransferOutDate);
		Assert.assertNotNull(TransferOutDate);
		
		String TransferOutFromAc = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_FROMAC).getText();
		System.out.println("TransferOutFromAc-- "+TransferOutFromAc);
		Assert.assertNotNull(TransferOutFromAc);
		
		String TransferOutToAc = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_TOAC).getText();
		System.out.println("TransferOutToAc-- "+TransferOutToAc);
		Assert.assertNotNull(TransferOutToAc);
		
		String TransferOutChannel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_CHANNEL).getText();
		System.out.println("TransferOutChannel-- "+TransferOutChannel);
		Assert.assertNotNull(TransferOutChannel);
		
		String TransferOutSeeDetails = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFEROUT_SEEDETAILS).getText();
		System.out.println("TransferOutSeeDetails-- "+TransferOutSeeDetails);
		Assert.assertNotNull(TransferOutSeeDetails);
		Thread.sleep(4000);
		
		ExtentTest Scenario = getFeature().createNode(Scenario.class, "Transfer out");
        String Image = "images/Transfer out.png";
        takeScreenshot(Image);
        Scenario.createNode(Given.class, "Transfer out").addScreenCaptureFromPath(Image).pass("pass");
        getExtent().flush();
        Thread.sleep(2000);
        
        
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_FIELD).clear();		
		if (Language.equals("ค้นหา")) {
			ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_FIELD).sendKeys("รับเงินโอน");
		} else {
			ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_FIELD).sendKeys("Transfer in");
		}
		
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SEARCH_BUTTON).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_ACTIVITY_DATE_TITLE);
		Thread.sleep(1000);
		ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_EXPEND_ACTIVITY).click();
		Thread.sleep(1000);
		
		String TransferInTitle = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_ACTIVITY_TRANSFER_TITLE).getText();
		System.out.println("TransferInTitle-- "+TransferInTitle);
		Assert.assertNotNull(TransferInTitle);
		
		String TransferInBeforeAmount = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_BEFOREAMOUNT).getText();
		System.out.println("TransferInBeforeAmount-- "+TransferInBeforeAmount);
		Assert.assertEquals("+", TransferInBeforeAmount);
		
		String TransferInAmount = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_AMOUNT).getText();
		System.out.println("TransferInAmount-- "+TransferInAmount);
		Assert.assertNotNull(TransferInAmount);
		
		String TransferInDate = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_DATE).getText();
		System.out.println("TransferInDate-- "+TransferInDate);
		Assert.assertNotNull(TransferInDate);
		
		String TransferInChannel = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_CHANNEL).getText();
		System.out.println("TransferInChannel-- "+TransferInChannel);
		Assert.assertNotNull(TransferInChannel);
		
		String TransferInSeeDetails = ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_TRANSFERIN_SEEDETAILS).getText();
		System.out.println("TransferInSeeDetails-- "+TransferInSeeDetails);
		Assert.assertNotNull(TransferInSeeDetails);
		Thread.sleep(4000);

		Scenario = getFeature().createNode(Scenario.class, "Transfer in");
        Image = "images/Transfer in.png";
        takeScreenshot(Image);
        Scenario.createNode(Given.class, "Transfer in").addScreenCaptureFromPath(Image).pass("pass");
        getExtent().flush();
        Thread.sleep(2000);
        
        System.out.println("Done--");
        Thread.sleep(2000);
    }
	
}
