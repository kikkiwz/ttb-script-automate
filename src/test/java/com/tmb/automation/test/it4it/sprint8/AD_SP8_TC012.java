package com.tmb.automation.test.it4it.sprint8;
//package com.automation.test.sprint8;
//
//import java.io.IOException;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import com.tmb.automation.pages.platform1.HomeScreenpage;
//import com.tmb.automation.util.AppiumLibrary;
//import com.tmb.automation.util.Base;
//
///**
// * Verify fields on Enter 4 digit code page screen.
// * @author Admin
// *
// */
//public class AD_SP8_TC012 extends Base {
//	@BeforeSuite(groups= {"android", "sprint8"})
//	public void BeforeSuite() {
//		startEmulator();
//		startServer();
//	}
//	@AfterSuite(groups = {"android", "sprint8"})
//	public void AfterSuite() {
//		stopServer();
//		stopEmulator();
//	}
//	
//	@BeforeClass(groups={"android", "sprint8"})
//	public void setUp() throws IOException {
//		Base.androidCapabilities();
//	}
//
//	@AfterClass(groups={"android", "sprint8"})
//	public void teardown() {
//		appiumDriver.quit();
//	}
//	@Test(groups = {"android", "sprint8"})
//	public void IPTest() throws IOException {
//		log("--------------"+this.getClass().getSimpleName());
//		AppiumLibrary appLib = new AppiumLibrary(appiumDriver);
//		HomeScreenpage homePage = new HomeScreenpage(appiumDriver);
//		homePage.skipSplashScreen();
//		appLib.alertAction("accept");
//		appLib.setContext("webview");
//		log("Click Show Balance");
//		appLib.click(homePage.fXpath(homePage.saBtnShowBalance));
//		sleep();
//		appLib.setContext("native");
//		appLib.waitVisibleXpath(homePage.saBtnPin0);
//		homePage.EnterPinAndroid("010203");
//		sleep(10);
//		appLib.setContext("webview");
//		
//		appLib.click(appLib.fXpath(homePage.swBtnChangeEmail));
//		sleep();
//		
//		String[] testData = {"tcs.qa.911@tutanota.com"};
//		log("Enter Email = "+testData[testData.length-1]);
//		appLib.setText(appLib.fXpath(homePage.swTxtEmail), testData[testData.length-1]);
//		log("Click Verify button");
//		appLib.click(appLib.fXpath(homePage.swBtnVerify));
//		sleep(5);
//		
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtOTPPin1));
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtOTPPin2));
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtOTPPin3));
//		appLib.assertTrue(appLib.isElementPresent(homePage.swTxtOTPPin4));
//	}
//}
