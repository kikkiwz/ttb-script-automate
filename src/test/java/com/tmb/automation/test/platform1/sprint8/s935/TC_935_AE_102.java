package com.tmb.automation.test.platform1.sprint8.s935;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
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



public class TC_935_AE_102 extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Helper.resetEmail("001100000000000000000012027155", false);
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
		
		
		log("TC_OneApp935_MB_POC_MessageSection_VIT_00002	Validate static text \"Message\"");
		hs.assertText(hs.fX(hs.swLbHS_Message).getText(), map("Text1"));
		
		log("TC_OneApp935_MB_POC_SeeAllButton_VIT_00002	Validate \"See all\" button but unclickable");
		hs.assertText(hs.fX(hs.swLbHS_Seeall).getText(), map("Text2"));
		
		log("TC_OneApp935_MB_POC_VerifyEmailCard_VIT_00002	Validate Verify Email Card when a customer not verify email yet (Email flag =\"No\")");
		hs.assertText(hs.fX(hs.swLbHS_VerifyEmail).getText(), map("Text3"));
		
		log("TC_OneApp935_MB_POC_MessageTopic_VIT_00002	Validate Message Topic in Verify Email Card");
		hs.assertText(hs.fX(hs.swLbHS_VerifyEmail).getText(), map("Text4"));
		
		log("TC_OneApp935_MB_POC_CloseCardButton_VIT_00002	Validate Close card button in Verify Email Card ");
		hs.assertTrue(hs.swBtnHS_close);
		
		log("TC_OneApp935_MB_POC_Message Body_VIT_00002	Validate Message Body in Verify Email Card ");
		hs.assertText(hs.fX(hs.swLbHS_ChangeEmail_Content).getText(), map("Text5"));
		
		log("TC_OneApp935_MB_POC_Message image_VIT_00002	Validate Message image in Verify Email Card");
		hs.assertTrue(hs.swImgHS_VerifyEmail_image);
		
		log("TC_OneApp935_MB_POC_VerifyEmailButton_VIT_00002 \"Validate Verify Email button in Verify Email Card \"");
		hs.assertTrue(hs.swBtnVerifyEmail);
		hs.click(hs.fX(hs.swBtnVerifyEmail));
		sleep();
		hs.setContext("native");
		hs.assertTrue(hs.isElementPresent(hs.saBtnHS_Pin0));
	}
	public static Boolean resetEmail(String crm_id, Boolean flag) {
		String flagY = "{\r\n    \"customer\": {\r\n        \"profile\": {\r\n            \"rm_id\": \""+crm_id+"\"\r\n        },\r\n        \"additional_kyc\": {\r\n            \"email_type\": \"B\",\r\n            \"email_address\": \"mahesh.psr2011@gmail.com\",\r\n            \"email_verify_flag\": \"Y\"\r\n        }\r\n    }\r\n}";
		String flagN = "{\r\n    \"customer\": {\r\n        \"profile\": {\r\n            \"rm_id\": \""+crm_id+"\"\r\n        },\r\n        \"additional_kyc\": {\r\n            \"email_type\": \"B\",\r\n            \"email_address\": \"mahesh.psr2011@gmail.com\"\r\n           \r\n        }\r\n    }\r\n}";
		String flagTotal = "";
		if (flag) {
			flagTotal = flagY;
		} else {
			flagTotal = flagN;
		}
		String Result = given()
			  .header("Content-Type", "application/json; charset=UTF-8")
			  .header("service-name", "customers-personal-kyc-update")
			  .header("request-uid", "c607e37d-9f53-4b64-bf00-d0fcd0b81d5c")
			  .header("request-app-id", "MB-INQ")
			  .header("request-datetime", "2020-09-21T19:19:33+0700")
			  .body(flagTotal)
	.relaxedHTTPSValidation().when().post("https://10.200.115.196:35568/v3.0/internal/customers/personal/kyc/update-kyc")
	.then().statusCode(200).extract().asString();
	System.out.println(Result);
	return false;
}
	
}
