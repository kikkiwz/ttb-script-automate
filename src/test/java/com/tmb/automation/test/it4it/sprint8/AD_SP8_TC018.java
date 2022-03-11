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
//import com.tmb.automation.pages.sprint8.Otp_TutanotaPage;
//import com.tmb.automation.util.AppiumLibrary;
//import com.tmb.automation.util.Base;
//
///**
// * Verify Show Balance - 935
// * @author Admin
// *
// */
//public class AD_SP8_TC018 extends Base {
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
//
//		log("----Verify Show balance screen");
//		appLib.assertTrue(appLib.isElementPresent(homePage.swImgProfile));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saLbWelcome));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnShowBalance));
//		
//		log("---- Verify Click Show Balance");
//		appLib.waitVisibleXpath(homePage.saBtnShowBalance);
//		appLib.click(homePage.fXpath(homePage.saBtnShowBalance));
//		appLib.setContext("native");
////		Helper.writeLog(appiumDriver.getPageSource());
//		appLib.waitVisibleXpath(homePage.saBtnPin0);
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin0));
//		//verify all fields on pin page
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin1));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin2));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin3));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin4));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin5));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin6));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin7));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin8));
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnPin9));
//		
//		appLib.assertTrue(appLib.isElementPresent(homePage.saBtnForgetPIN));
//		
//		//Verify Enter Valid PIN
//		homePage.EnterPinAndroid("010203");
//		
//		appLib.setContext("webview");
//		sleep();
//		appLib.waitVisibleXpath(homePage.siAccountType);
//		sleep(10);
//		Helper.writeLog(appiumDriver.getPageSource());
//		appLib.assertText(homePage.fXpath(homePage.saLbCustName).getText(), "Welcome K. Gameji Potter");
//		appLib.assertText(homePage.fXpath(homePage.siAccountType).getText(), "TMB All Free Account 6586");
////		appLib.assertText(homePage.fXpath(homePage.sibalanceAmount1).getText()
////				, "1,036,915.31 ฿");
////		appLib.assertContain(homePage.fXpath(homePage.sibalanceAmount1).getText(), "1,036,915.31");
//		
//		
//	}
//}
