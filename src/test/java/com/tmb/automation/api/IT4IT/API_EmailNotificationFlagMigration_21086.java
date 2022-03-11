package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tmb.automation.model.PhrasesPojo;
import com.tmb.automation.model.PhrasesPojo.current_phrase;
import com.tmb.automation.model.PhrasesPojo.phrases;
import com.tmb.automation.model.PhrasesPojo.update_phrase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API_EmailNotificationFlagMigration_21086 {

	private static String AccessToken;
	private Long Timestamp;
	public String GetAccessToken()
	{
		Date date =new Date();
		Timestamp = date.getTime();
		Timestamp = date.getTime();
		RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username", "XAiN4JXphjKA+HjADvizKUNwX/hsibnIC3x+/4/Z8KsfErhMI2XCUKugi+q8eULx7CyYP9Sxzoz/mKgr4/cV4MrqhEPtlK4ytSVInmj7AlY6Cx4k5Zs9hpZJW51xsCP8qU3Vi/cT5wvAd9j5iYkbqGj6wNWB7uVivLlF7MmWVc6r3/3ikp2/6tB/W7iZv/9A+P7XGtuZw4o4B1nra4ihwy48Ah3SQSI8/vO6JKJE+srIgC3cQWuQ7ggh5esXe1mrGQflMb4ROIbVJFI4jp3zb1FyPSsj+t+MFtnHbkZvHvkWqc5KnnyGEZdU5FQXVRaEwvJNjSIpkgECCJXynE8pwQ==")
				.multiPart("password", "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==")
				.multiPart("scope", "mobile").when()
				.post("apis/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		AccessToken = jsonPath.getString("data.access_token");
		return AccessToken;
	}
	@Test(description="Email Notification Flag Migration",priority=1)
	public void API_EmailNotificationFlagMigration()
	{
		Date date =new Date();
		Timestamp = date.getTime();
		String CRMID="001100000000000000000018595882";
		String AccessToken=GetAccessToken();
		RestAssured.baseURI = "http://customers-service-https-internal-dev1-oneapp.apps.ddid1.tmbcps.com";
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-ID", "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da")
				.header("X-CRMID",CRMID)
				.header("Timestamp",Timestamp).when()
				.post("apis/customers/settings/notification/email/migrate").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));
		String data=(js.getString("data"));
		Assert.assertTrue(data.equals("Email notification settings update successfully"));
		

	}
	
		
}

