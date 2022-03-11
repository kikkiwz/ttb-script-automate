package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Save_phrases_ccAdmin {
	
	@Test(dataProvider = "requestbody")

	public void Auth(String body) {

		
		
		
		
		RestAssured.baseURI = "https://cc-dev1.oneapp.tmbbank.local";
		String response1 = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username", "f2f149").multiPart("password", "P@ss12345").when()
				.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath jsonPath = new JsonPath(response1);
		String AccessToken = jsonPath.getString("data.access_token");

		RestAssured.baseURI = "https://cc-dev1.oneapp.tmbbank.local";
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "en-US, th-TH").header("Timestamp", "786").header("channel","mb").body(body).when()
				.post("/apis/common/phrases").then().assertThat().statusCode(200).extract().response()
				.asString();

		System.out.println(response);
		

	}
	
	@DataProvider(name = "requestbody")
	public String[] createCircuitTestData() 
	{
		
		String body = "[{\r\n" + 
				"    \"module_key\": \"link\",\r\n" + 
				"    \"module_name\": \"Link\",\r\n" + 
				"    \"channel\": \"mb\",\r\n" + 
				"    \"details\": {\r\n" + 
				"		\"test\": {\r\n" + 
				"            \"last_updated_time\": 1579442310413,\r\n" + 
				"            \"created_time\": 1579442310413,\r\n" + 
				"            \"updated_by\": \"System\",\r\n" + 
				"            \"en\": \"Test\",\r\n" + 
				"            \"th\": \"Test-th\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}]";
		
		
		String body1 = "[{\r\n" + 
				"    \"module_key\": \"\",\r\n" + 
				"    \"module_name\": \"Link\",\r\n" + 
				"    \"channel\": \"mb\",\r\n" + 
				"    \"details\": {\r\n" + 
				"		\"test1\": {\r\n" + 
				"            \"last_updated_time\": 1579442310413,\r\n" + 
				"            \"created_time\": 1579442310413,\r\n" + 
				"            \"updated_by\": \"System\",\r\n" + 
				"            \"en\": \"Test\",\r\n" + 
				"            \"th\": \"Test-th\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}]";
		String body2 = "[{\r\n" + 
				"    \"module_key\": \"link\",\r\n" + 
				"    \"module_name\": \"Link\",\r\n" + 
				"    \"channel\": \" \",\r\n" + 
				"    \"details\": {\r\n" + 
				"		\"test\": {\r\n" + 
				"            \"last_updated_time\": 1579442310413,\r\n" + 
				"            \"created_time\": 1579442310413,\r\n" + 
				"            \"updated_by\": \"System\",\r\n" + 
				"            \"en\": \"Test\",\r\n" + 
				"            \"th\": \"Test-th\"\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}]";
		
		
		return new String[]{ body,body1,body2
				
		
	};
		
		
	}
	
	
	
	// Get Place

}


