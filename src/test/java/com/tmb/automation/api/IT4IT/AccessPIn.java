package com.tmb.automation.api.IT4IT;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.automation.model.AcceessPinResponse;
import com.tmb.automation.model.AccesspinPojo;
import com.tmb.automation.model.AccesspinResponseInavlidPin;
import com.tmb.automation.model.ResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AccessPIn {
	
	
	
	@Test(description="Access token validation with valid data",priority=1)
	public void AccesspinValidation() throws SQLException, ClassNotFoundException {
		
		/////////////////////////AccessToken//////////////////////////////////////////////////////////////////
		RestAssured.baseURI="https://oneapp-dev1.tau2904.com";
		String username="XAiN4JXphjKA+HjADvizKUNwX/hsibnIC3x+/4/Z8KsfErhMI2XCUKugi+q8eULx7CyYP9Sxzoz/mKgr4/cV4MrqhEPtlK4ytSVInmj7AlY6Cx4k5Zs9hpZJW51xsCP8qU3Vi/cT5wvAd9j5iYkbqGj6wNWB7uVivLlF7MmWVc6r3/3ikp2/6tB/W7iZv/9A+P7XGtuZw4o4B1nra4ihwy48Ah3SQSI8/vO6JKJE+srIgC3cQWuQ7ggh5esXe1mrGQflMb4ROIbVJFI4jp3zb1FyPSsj+t+MFtnHbkZvHvkWqc5KnnyGEZdU5FQXVRaEwvJNjSIpkgECCJXynE8pwQ==";
		String password="WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==";
		RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username", username).multiPart("password", password).multiPart("scope","mobile").when()
				.post("apis/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Response" + response);
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("data.access_token");
		System.out.println("access token" + accessToken);
		///////////////////////////////////////////PIN VALIDATION::::::::::::::::::::::::::???????????????///////////////////////////
		RestAssured.baseURI="https://oneapp-dev1.tau2904.com";
		
		Map<String,Object> headerMap = new HashMap<String,Object>();
		
		headerMap.put("Timestamp", "786");
		headerMap.put("X-Correlation-ID", "devops-1234");
		headerMap.put("Accept-Language", "EN");
		headerMap.put("deviceID", "Goq8vt4zGv7X9f4VyBrlRHrCyvulHnnWfOW2l8W2JbbyWyoiWcv3auJuzbFduxO5LCX//sD/sNlq8yoOvExqYhDytDmQ8K4LTA22d86kjwGHLCG530ftlkV5u3tvK98I976y4V++WBOcluc6aNiwW5ikpNemIJ7NbYKi2MjXLAFtjB5e2O10KLvG9PxkvY0uUFm4UtAxQSxVgemyk4Bs2G8NZztBbahiAIdkOSbb0Nzsu1EqmxaVWrC7qjn99tXmykyABncjqTdao1qYElorCcUtSmKr4Tp2PR0E8sQaP/fNE6T7Kl+uBK+C2MA2Ok6gp9qOqQXuVWaBcrJkD5c6Kg==");
		headerMap.put("App-Version", "10.0.2");
		headerMap.put("Device-Model", "Samsung");
		headerMap.put("Content-Type", "application/json");
		
		AccesspinPojo accesspin= new AccesspinPojo();
		accesspin.setModule("transfer");
		accesspin.setPin("WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==");
		accesspin.setRef_id("test_123");
		
		AcceessPinResponse pinResponse = given().relaxedHTTPSValidation().auth().oauth2(accessToken).headers(headerMap).body(accesspin).log().all().when().post("apis/auth/verify/pin").then().assertThat().statusCode(200).extract()
		.response().as(AcceessPinResponse.class);
		System.out.println(pinResponse.toString());
		assertEquals("0000", pinResponse.getStatus().getCode());
		
		Assert.assertEquals("Pin verification successful",pinResponse.getData() );
		
		DBConnection conn = new DBConnection();
		ResultSet rs = conn.connection("select MB_USER_STATUS_ID from CRM_CUST_PROFILE where crm_id = '001100000000000000000001184383'");
		
		
		while (rs.next()) {
			String StausCode = rs.getString(1);
			//String updatedFlag = rs.getString(2);
			System.out.println("Status CODE is" + "  " + StausCode);
			Assert.assertEquals("02",StausCode,"sTATUS CODE IS NOT 02" );
		}
		conn.con.close();

		}
		
		
		
		
		@Test(description="Access token validation with valid data",priority=2)
		public void AccessWithWrongPin() throws SQLException, ClassNotFoundException {
			
			
			System.out.println("///NEGEATIVE TEST CASE RUNNING///");
			/////////////////////////AccessToken//////////////////////////////////////////////////////////////////
			RestAssured.baseURI="https://oneapp-dev1.tau2904.com";
			String username="E7OFyu5SGxLRncI6Y5suMOywwJpvVoKqDOsYGxxRF29ceYxGWR3aVPy6fg2C3096JKC4of6ORagNXYiDE481B+wM7+9BBmCMs2IhKVH+CbEzVqxGe7j2YtO9dxQ8LXCxsisLuKe1nq5p59QhZPypmg/u3VMoVS6UuPRbEP5udhZ5VEj75OmLEyakPQrNXsSrOYB/6DLw4wwAx8S/A3gdVaRqmX2Fz/2g3TbJyLKmq+iTMiqaeiG8pmtvXIJZ1lhbcc3FuD1n2+RrU4gDgpdagHHx+q6X2E4XNqIrk0qa13nFXcaNyp4JwGS1nE36eVZwsSudMDrzKUNEZR+Mo3cHHw==";
			String password="WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==";
			RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
			String response = given().relaxedHTTPSValidation().auth().preemptive()
					.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
					.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
					.multiPart("username", username).multiPart("password", password).multiPart("scope","mobile").when()
					.post("apis/auth/token").then().assertThat().statusCode(200).extract().response().asString();
			System.out.println("Response" + response);
			JsonPath jsonPath = new JsonPath(response);
			String accessToken = jsonPath.getString("data.access_token");
			System.out.println("access token" + accessToken);
			///////////////////////////////////////////
			RestAssured.baseURI="https://oneapp-dev1.tau2904.com";
			
			Map<String,Object> headerMap = new HashMap<String,Object>();
			
			headerMap.put("Timestamp", "786");
			headerMap.put("X-Correlation-ID", "devops-1234");
			headerMap.put("Accept-Language", "EN");
			headerMap.put("deviceID", "Goq8vt4zGv7X9f4VyBrlRHrCyvulHnnWfOW2l8W2JbbyWyoiWcv3auJuzbFduxO5LCX//sD/sNlq8yoOvExqYhDytDmQ8K4LTA22d86kjwGHLCG530ftlkV5u3tvK98I976y4V++WBOcluc6aNiwW5ikpNemIJ7NbYKi2MjXLAFtjB5e2O10KLvG9PxkvY0uUFm4UtAxQSxVgemyk4Bs2G8NZztBbahiAIdkOSbb0Nzsu1EqmxaVWrC7qjn99tXmykyABncjqTdao1qYElorCcUtSmKr4Tp2PR0E8sQaP/fNE6T7Kl+uBK+C2MA2Ok6gp9qOqQXuVWaBcrJkD5c6Kg==");
			headerMap.put("App-Version", "10.0.2");
			headerMap.put("Device-Model", "Samsung");
			headerMap.put("Content-Type", "application/json");
			
			AccesspinPojo accesspin= new AccesspinPojo();
			accesspin.setModule("transfer");
			////////////WRONGPIN/////////////////////////
			accesspin.setPin("Goq8vt4zGv7X9f4VyBrlRHrCyvulHnnWfOW2l8W2JbbyWyoiWcv3auJuzbFduxO5LCX//sD/sNlq8yoOvExqYhDytDmQ8K4LTA22d86kjwGHLCG530ftlkV5u3tvK98I976y4V++WBOcluc6aNiwW5ikpNemIJ7NbYKi2MjXLAFtjB5e2O10KLvG9PxkvY0uUFm4UtAxQSxVgemyk4Bs2G8NZztBbahiAIdkOSbb0Nzsu1EqmxaVWrC7qjn99tXmykyABncjqTdao1qYElorCcUtSmKr4Tp2PR0E8sQaP/fNE6T7Kl+uBK+C2MA2Ok6gp9qOqQXuVWaBcrJkD5c6Kg==");
			accesspin.setRef_id("test_123");
			
			AccesspinResponseInavlidPin pinResponse = null;
			
			int count=2;
			
			for(int i=0;i<2;i++)
			{
			
			 pinResponse = given().relaxedHTTPSValidation().auth().oauth2(accessToken).headers(headerMap).body(accesspin).log().all().when().post("apis/auth/verify/pin").then().assertThat().statusCode(401).extract()
			.response().as(AccesspinResponseInavlidPin.class);
			System.out.println(pinResponse.toString());
			//assertEquals("1000002", pinResponse.getStatus().getCode());
			String validation=pinResponse.getStatus().getDescription().getEn();
			String EnString="You have "+count+" time left";
			Assert.assertEquals(EnString,validation,"the message is not validated ");
			count --;
			}
			
			 pinResponse = given().relaxedHTTPSValidation().auth().oauth2(accessToken).headers(headerMap).body(accesspin).log().all().when().post("apis/auth/verify/pin").then().assertThat().statusCode(401).extract()
						.response().as(AccesspinResponseInavlidPin.class);
						System.out.println(pinResponse.toString());
						assertEquals("1000006", pinResponse.getStatus().getCode());
						String validation=pinResponse.getStatus().getDescription().getEn();
						
						Assert.assertEquals("access pin locked",validation,"the message is not validated ");
			
			//Assert.assertEquals("Pin verification successful",pinResponse.getData() );
			
			DBConnection conn = new DBConnection();
			ResultSet rs = conn.connection("select MB_USER_STATUS_ID from CRMADM.CRM_CUST_PROFILE where crm_id = '001100000000000000000001184383'");
			
			
			while (rs.next()) {
				String StausCode = rs.getString(1);
				//String updatedFlag = rs.getString(2);
				System.out.println("Status CODE is" + "  " + StausCode);
				Assert.assertEquals("05",StausCode,"sTATUS CODE IS NOT 05" );
				

			}
			rs=conn.connection("update CRMADM.CRM_CUST_PROFILE set MB_USER_STATUS_ID = '02' where crm_id = '001100000000000000000001184383'");
			
			conn.con.close();
		
		
		
		
	}

}
