package com.tmb.automation.test.platform1.sprint9.s14;

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
import static io.restassured.RestAssured.given;

/**
 * This Automation script created by TCS company for run with OneApp from TMB Bank 
 * @author Aniwat Ruttanuadom
 * @version OneApp 
 * @since   2020-11-26 
 * 
TC_OneApp14_MB_Invalid PIN EN_SIT_00001	Validate enter invalid PIN on fist time 
 */



public class TC_014_AE_105 extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod(groups= {"android", "plaform1", "Sprint8", "935",})
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		Base.appiumCapabilities();
		mapData = Helper.getExcelData("TestData_platform1", "TestData_14", this.getClass().getSimpleName());
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
		
		log("TC_OneApp14_MB_Access PIN TH_SIT_00009	 Validate input PIN field "
				+ "If customer input correct PIN and customer email flag as \"N\"");
		
		hs.click(hs.fX(hs.swBtnHS_ShowBalance));
		hs.setNative();
		hs.waitVisible(hs.saBtnHS_Pin0);
		
		hs.EnterPin("010204");
		sleep();
		hs.waitVisible(hs.saLbHS_TextShow);
		hs.assertText(hs.fX(hs.saLbHS_TextShow).getText(), map( "Error_Text_Show1"));
		
		hs.EnterPin("010204");
		sleep();
		hs.waitVisible(hs.saLbHS_TextShow);
		hs.assertText(hs.fX(hs.saLbHS_TextShow).getText(), map( "Error_Text_Show2"));
		
		//
		hs.EnterPin("010204");
		sleep(5);
		
		hs.waitVisible(hs.saLbPinLock_Title, 100);
		hs.assertText(hs.fX(hs.saLbPinLock_Title).getText()
				,map("PinLock_Title"));
		
		hs.assertText(hs.fX(hs.saLbPinLock_Message).getText()
				, map("PinLock_Message"));
		
		hs.assertText(hs.fX(hs.saLbPinLock_Description).getText()
				, map("PinLock_Description"));
		
		hs.assertText(hs.fX(hs.saBtnPinLock_SetNewPin).getText()
				, map("SetNewPin"));
//		resetPin("");
	}
	
//	public static Boolean resetPin(String rm_id) {
//	String Result = given()
//	.header("Content-Type", " application/json; charset=UTF-8")
//	.body("{\r\n    \"dynamicAgentSession\": true,\r\n    \"sessionToken\": \"\",\r\n    \"userId\": \""+rm_id+"\",\r\n    \"userStoreId\": \"DefaultStore\",\r\n    \"loginModuleId\": \"MB_AcPwd\",\r\n    \"password\": \"010203\",\r\n    \"params\": {\r\n        \"segmentId\": \"MIB\",\r\n        \"checkPasswordHistory\": false,\r\n        \"checkPasswordQuality\": true,\r\n        \"updateLastPasswordChangeTime\": true,\r\n        \"forcePasswordChange\": false\r\n    }\r\n}")
//	.relaxedHTTPSValidation().when().post("https://10.209.23.93:9443/am5/rest/password/reset")
//	.then().statusCode(200).extract().asString();
//	System.out.println(Result);
//	return false;
//}
//	HttpResponse<String> response = Unirest.post("https://10.209.23.93:9443/am5/rest/password/reset")
//			  .header("Content-Type", " application/json; charset=UTF-8")
//			  .body("{\r\n    \"dynamicAgentSession\": true,\r\n    \"sessionToken\": \"\",\r\n    \"userId\": \"001100000000000000000001184383\",\r\n    \"userStoreId\": \"DefaultStore\",\r\n    \"loginModuleId\": \"MB_AcPwd\",\r\n    \"password\": \"010203\",\r\n    \"params\": {\r\n        \"segmentId\": \"MIB\",\r\n        \"checkPasswordHistory\": false,\r\n        \"checkPasswordQuality\": true,\r\n        \"updateLastPasswordChangeTime\": true,\r\n        \"forcePasswordChange\": false\r\n    }\r\n}")
//			  .asString();
}
