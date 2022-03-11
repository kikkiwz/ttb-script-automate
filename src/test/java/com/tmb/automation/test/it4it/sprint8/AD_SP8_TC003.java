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
// * Verify fields on Pin page screen
// * @author Admin
// *
// */
//public class AD_SP8_TC003 extends Base {
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
//		appLib.waitVisibleXpath(homePage.saBtnShowBalance);
//		appLib.click(homePage.fXpath(homePage.saBtnShowBalance));
//		sleep();
//		appLib.setContext("native");
//		appLib.waitVisibleXpath(homePage.saBtnPin0);
//		
//		log("Verify all fields on pin page");
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin0));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin1));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin2));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin3));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin4));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin5));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin6));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin7));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin8));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin9));
////		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnBackSpace));
////		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnForgetPIN));
////		appLib.assertTrue(appLib.isElementPresent(homePage.siLbEnterYourPIN));
//	}
//}
