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
// * Verify fields on Pin page screen
// * @author Admin
// *
// */
//public class IP_SP8_TC003 extends Base {
//	@BeforeSuite(groups= {"ios"})
//	public void BeforeSuite() {
//		startEmulator();
//		startServer();
//	}
//	@AfterSuite(groups = {"ios"})
//	public void AfterSuite() {
//		stopServer();
//		stopEmulator();
//	}
//	
//	@BeforeClass(groups={"ios"})
//	public void setUp() throws IOException {
//		Base.iOSCapabilities();
//	}
//
//	@AfterClass(groups={"ios"})
//	public void teardown() {
//		appiumDriver.quit();
//	}
//	@Test(groups = { "functest", "ios" })
//	public void IPTest() throws IOException {
//		log("--------------"+this.getClass().getSimpleName());
//		AppiumLibrary appLib = new AppiumLibrary(appiumDriver);
//		HomeScreenpage homePage = new HomeScreenpage(appiumDriver);
//		sleep();
//		appLib.alertAction("accept");
//		appLib.setContext("webview");
//		log("Click Show Balance");
//		appLib.click(homePage.fXpath(homePage.siBtnShowBalance));
//		sleep();
//		appLib.setContext("native");
//		appLib.waitVisibleXpath(homePage.siBtnPin0);
//		
//		//verify all fields on pin page
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin0));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin1));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin2));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin3));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin4));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin5));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin6));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin7));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin8));
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnPin9));
////		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnBackSpace));
////		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnForgetPIN));
////		appLib.assertTrue(appLib.isElementPresent(homePage.siLbEnterYourPIN));
//	}
//}
