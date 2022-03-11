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



public class TC_014_AT_206 extends Base {
	
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
		hs.waitVisible(hs.saLbPinLock_Title);
		
		
		hs.assertText(hs.fX(hs.saLbPinLock_Title).getText()
				, map("PinLock_Title_TH"));
		
		hs.assertText(hs.fX(hs.saLbPinLock_Message).getText()
				, map("PinLock_Message_TH"));
		
		hs.assertText(hs.fX(hs.saLbPinLock_Description).getText()
				, map("PinLock_Description_TH"));
		
		hs.assertText(hs.fX(hs.saBtnPinLock_SetNewPin).getText()
				, map("SetNewPin_TH"));
		
		hs.assertTrue(hs.fX(hs.saBtnPinLock_close).getText());
		updateDB("001100000000000000000012027155");
		resetPin("001100000000000000000012027155");
		
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
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.209.33.52:1522:crm1v", "custcrmusr",
					"Crm_vit123");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute queryf
//			ResultSet rs = stmt.executeQuery( mb_user_status_id
//					"select mb_user_status_id from crm_cust_profile where crm_id = '"+RM_ID+"'");
			String sql = "update crm_cust_profile SET mb_user_status_id = '02' where crm_id = '"+rm_id+"'";
			System.out.println("sql="+sql);
			int rs = stmt.executeUpdate(sql);
			System.out.println(rs);
//			while (rs.next())
//				System.out.println(rs.getString(1));

			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
