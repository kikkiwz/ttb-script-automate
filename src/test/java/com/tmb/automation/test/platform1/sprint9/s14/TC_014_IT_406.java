package com.tmb.automation.test.platform1.sprint9.s14;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
 TC_OneApp14_MB_Invalid PIN EN_SIT_00003	Validate enter invalid PIN on second time  

 */



public class TC_014_IT_406 extends Base {
	
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
		
		log("Validate enter invalid PIN on second time ");
		
		hs.click(hs.fX(hs.swBtnHS_ShowBalance));
		hs.setNative();
		hs.waitVisible(hs.siLbPinLock_Title, 100);
		
		
		hs.assertText(hs.fX(hs.siLbPinLock_Title).getText()
				, map("PinLock_Title_TH"));
		
		hs.assertText(hs.fX(hs.siLbPinLock_Message).getText()
				, map("PinLock_Message_TH"));
		
		hs.assertText(hs.fX(hs.siLbPinLock_Description).getText()
				, map("PinLock_Description_TH"));
		
		hs.assertText(hs.fX(hs.siBtnPinLock_SetNewPin).getText()
				, map("SetNewPin_TH"));
		
		hs.assertTrue(hs.isElementPresent(hs.siBtnPinLock_close));
		updateDB("001100000000000000000001184383");
		resetPin("001100000000000000000001184383");
		
	}
	public static Boolean resetPin(String rm_id) {
	String Result = given()
	.header("Content-Type", " application/json; charset=UTF-8")
	.body("{\r\n    \"dynamicAgentSession\": true,\r\n    \"sessionToken\": \"\",\r\n    \"userId\": \""+rm_id+"\",\r\n    \"userStoreId\": \"DefaultStore\",\r\n    \"loginModuleId\": \"MB_AcPwd\",\r\n    \"password\": \"010203\",\r\n    \"params\": {\r\n        \"segmentId\": \"MIB\",\r\n        \"checkPasswordHistory\": false,\r\n        \"checkPasswordQuality\": true,\r\n        \"updateLastPasswordChangeTime\": true,\r\n        \"forcePasswordChange\": false\r\n    }\r\n}")
	.relaxedHTTPSValidation().when().post("https://10.209.23.93:9443/am5/rest/password/reset")
	.then().statusCode(200).extract().asString();
	System.out.println(Result);
	return false;
}
	public static void updateDB(String rm_id) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.209.33.52:1522:crm1v", "custcrmusr",
					"Crm_vit123");
			Statement stmt = con.createStatement();
			String sql = "update crm_cust_profile SET mb_user_status_id = '02' where crm_id = '"+rm_id+"'";
			System.out.println("sql="+sql);
			int rs = stmt.executeUpdate(sql);
			System.out.println(rs);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
