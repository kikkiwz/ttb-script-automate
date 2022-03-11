package com.tmb.automation.test.it4it.sprint8;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.tmb.automation.util.Base;

/**
 * Verify Enter OTP value to Enter invalid 4 Digit code
 * @author Admin
 *
 */
public class IP_SP8_TC014 extends Base {
	@BeforeSuite(groups= {"ios"})
	public void BeforeSuite() {
		startEmulator();
		startServer();
	}
	@AfterSuite(groups = {"ios"})
	public void AfterSuite() {
		stopServer();
		stopEmulator();
	}
	
	@BeforeClass(groups={"ios"})
	public void setUp() throws IOException {
		Base.iOSCapabilities();
	}

	@AfterClass(groups={"ios"})
	public void teardown() {
		appiumDriver.quit();
	}
	@Test(groups = { "functest", "ios" })
	public void IPTest() throws IOException {
		
	}
}
