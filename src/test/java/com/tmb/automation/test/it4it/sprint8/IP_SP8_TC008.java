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
// * Verify click Verify Email button
// * @author Admin
// *
// */
//public class IP_SP8_TC008 extends Base {
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
//		homePage.EnterPiniOS("010203");
//		sleep(20);
//		appLib.setContext("webview");
//		
//		appLib.assertTrue(appLib.isElementPresent(homePage.swBtnChangeEmail));
//		
//	}
//}
