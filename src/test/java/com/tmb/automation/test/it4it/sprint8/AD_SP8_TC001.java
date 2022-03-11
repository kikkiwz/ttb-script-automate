package com.tmb.automation.test.it4it.sprint8;
//package com.automation.test.sprint8;
//
//import java.io.IOException;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
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
//public class AD_SP8_TC001 extends Base {
//	@BeforeClass(groups={"android", "sprint8"})
//	public void setUp() throws IOException {
//		Base.androidCapabilities();
//	}
//
//	@AfterClass(groups={"android", "sprint8"})
//	public void teardown() {
//		log("----------------End "+this.getClass().getSimpleName());
//		log("");
//		appiumDriver.quit();
//	}
//	@Test(groups = {"android", "sprint8" })
//	public void IPTest() throws IOException {
//		log("--------------"+this.getClass().getSimpleName());
//		AppiumLibrary appLib = new AppiumLibrary(appiumDriver);
//		HomeScreenpage homePage = new HomeScreenpage(appiumDriver);
////		homePage.skipSplashScreen();
////		Helper.writeLog(appiumDriver.getPageSource());
//		appLib.alertAction("accept");
//		appLib.setContext("webview");
//
//		//verify profile logo
//		appLib.assertTrue(appLib.isElementPresent(homePage.swImgProfile));
//		// verify title
//		appLib.assertTrue(appLib.isElementPresent(homePage.saLbWelcome));
//		Helper.writeLog(appiumDriver.getPageSource());
//		//verify show balance button
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnShowBalance));
//
//	}
//}
