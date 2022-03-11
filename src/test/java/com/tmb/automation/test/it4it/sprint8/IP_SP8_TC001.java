package com.tmb.automation.test.it4it.sprint8;
//package com.automation.test.sprint8;
//
//import java.io.IOException;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import com.tmb.automation.helper.Helper;
//import com.tmb.automation.pages.sprint8.HomeScreenpage;
//import com.tmb.automation.util.AppiumLibrary;
//import com.tmb.automation.util.Base;
//
///**
// * Verify fields on Welcome screen
// * @author Admin
// *
// */
//public class IP_SP8_TC001 extends Base {
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
////		log("Click Show Balance");
////		Helper.writeLog(appiumDriver.getPageSource());
//		//verify profile logo
//		appLib.assertTrue(appLib.isElementPresent(homePage.siImgProfile));
//		// verify title
//		appLib.assertTrue(appLib.isElementPresent(homePage.siLbWelcome));
//		//verify show balance button
//		appLib.assertTrue(appLib.isElementPresent(homePage.siBtnShowBalance));
//
//
//	}
//}
