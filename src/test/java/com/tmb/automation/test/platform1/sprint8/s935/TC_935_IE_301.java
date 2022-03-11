package com.tmb.automation.test.platform1.sprint8.s935;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.platform1.HomeScreenpage;
import com.tmb.automation.util.AppiumLibrary;
import com.tmb.automation.util.Base;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
 * TC_OneApp935_MB_POC_Profilepicture_VIT_00002
 * "1. Open OneApp success
 2. Check Home screen"	"- Show profile picture correctly
- The system show the layout, color and size of profile picture is correctly."
 */



public class TC_935_IE_301 extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Helper.resetEmail("001100000000000000000001184383", false);
		Base.appiumCapabilities();
		mapData = Helper.getExcelData("TestData_platform1", "TestData_935", this.getClass().getSimpleName());
	}

	@AfterMethod(groups= {"android", "plaform1", "Sprint8", "935"})
	public void teardown() {
		Base.driverQuit();
	}
	
	@Test(groups = {"android", "plaform1", "Sprint8", "935"})
	public void ADTest001() throws IOException {
		log("------------Start "+this.getClass().getSimpleName());
		HomeScreenpage hs = new HomeScreenpage(appiumDriver);
		hs.setWebview();
		hs.waitVisible(hs.swLbHS_Message);
		
		//check profile image
		log(" TC_OneApp935_MB_POC_Profilepicture_VIT_00002	Validate profile picture when a customer has already set profile picture");
		hs.assertTrue(hs.swImgHS_Profile);
		//check welcome message
		log(" TC_OneApp935_MB_POC_Welcome-Neme_VIT_00002	Validate Welcome message and customer’s name on Home screen");
		hs.assertContain(hs.fX(hs.swLbHS_Welcome).getText(), map("CustName"));
		
		//check show balance button
		log(" TC_OneApp935_MB_POC_ShowBalance_VIT_00002	Validate  Show balance button on Home screen");
		hs.assertTrue(hs.swBtnHS_ShowBalance);
		//check image on screen
		log(" TC_OneApp935_MB_POC_Image_VIT_00002	Validate image on Home screen");
		hs.assertTrue(hs.swImgHS_Robot);
	}
}
