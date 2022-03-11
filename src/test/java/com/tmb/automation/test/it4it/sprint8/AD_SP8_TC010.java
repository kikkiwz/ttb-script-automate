package com.tmb.automation.test.it4it.sprint8;
//package com.automation.test.sprint8;
//
//import java.io.IOException;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.tmb.automation.pages.platform1.HomeScreenpage;
//import com.tmb.automation.util.AppiumLibrary;
//import com.tmb.automation.util.Base;
//
///**
// * Verify field validation for Email text field.
// * @author Admin
// *
// */
//public class AD_SP8_TC010 extends Base {
////	@BeforeSuite(groups= {"android", "sprint8"})
////	public void BeforeSuite() {
////		startEmulator();
////		startServer();
////	}
////	@AfterSuite(groups = {"android", "sprint8"})
////	public void AfterSuite() {
////		stopServer();
////		stopEmulator();
////	}
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
////		appLib.assertTrue(appLib.isElementPresent(homePage.swBtnChangeEmail));
//		appLib.click(appLib.fXpath(homePage.swBtnChangeEmail));
//		sleep();
//		
//		String[] testData = {"aaa", "@", ".", "aa@","aa@.", "aaa@aaa", "aaa@aaa.", "@aaa", "@.", "@aaa.aaa", "tcs.qa.911@tutanota.com"};
//		for (int i = 0; i < testData.length-1;i++) {
//			log("Enter Email = "+testData[i]);
//			appLib.setText(appLib.fXpath(homePage.swTxtEmail), testData[i]);
//			log("Click Verify button");
//			appLib.click(appLib.fXpath(homePage.swBtnVerify));
//			appLib.assertText(appLib.fXpath(homePage.swLbEmailErrorMsg).getText(), "Email is a wrong format");
//			
//		}
//		log("Enter Email = "+testData[testData.length-1]);
//		appLib.setText(appLib.fXpath(homePage.swTxtEmail), testData[testData.length-1]);
//		log("Click Verify button");
//		appLib.click(appLib.fXpath(homePage.swBtnVerify));
//		appLib.assertTrue(!appLib.isElementPresent(homePage.swLbEmailErrorMsg));
//	}
//}
