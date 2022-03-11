package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.automation.model.ResponsePojoKYC_Review;
import com.tmb.automation.model.ResponsePojoKYC_ReviewData;
import com.tmb.automation.model.TermsandConditionPojo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API_Link_KYC_Review {
	private Long Timestamp;
	public String ref_id;
	public String GetAccessToken()
	{
		String AccessToken;
		Date date =new Date();
		Timestamp = date.getTime();
		RestAssured.baseURI = "https://oneapp-vit1.tau2904.com";
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
	
	@Test(description="Get Block flag",priority=1)
	public void Get_block_flag()
	{
		String AccessToken=GetAccessToken();
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp",Timestamp ).when()
				.get("apis/customers/kyc/profile/block-flag").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);		
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));
	}
	@Test(description="Get Landing page web URL",priority=2)
	public void Get_LandingPageWebURL()
	{
		String AccessToken=GetAccessToken();
		ResponsePojoKYC_Review  kyc_pojo=new ResponsePojoKYC_Review();
		kyc_pojo.setState("introduction");
		kyc_pojo.setRef_id("");		
		ResponsePojoKYC_Review response=given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
				 .header("Content-Type","application/json")
			     .header("Timestamp",Timestamp).body(kyc_pojo).when()
				 .post("apis/customers/kyc/profile/token")
				 .then().assertThat().statusCode(200).extract().response().as(ResponsePojoKYC_Review.class);
		ref_id=response.getData().getRef_id();
		System.out.println("The reference id is---"+ref_id);
		
	}
	@Test(description="Validate Pin Success",priority=3)
	public void Validate_Pin_Success ()
	{
		String AccessToken=GetAccessToken();
		ResponsePojoKYC_Review  kyc_pojo=new ResponsePojoKYC_Review();
		kyc_pojo.setPin("WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==");
		kyc_pojo.setRef_id(ref_id);	
		kyc_pojo.setModule("KYC_VERIFY_PIN_STATUS");
		ResponsePojoKYC_ReviewData response=given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
				 .header("Content-Type","application/json")
			     .header("Timestamp",Timestamp).body(kyc_pojo).when()
				 .post("apis/auth/verify/pin")
				 .then().assertThat().statusCode(200).extract().response().as(ResponsePojoKYC_ReviewData.class);
		Assert.assertTrue(response.getData().equals("Pin verification successful"), "Pin verification successful");
	
	
}
	@Test(description="Get Verified Web URL",priority=4)
	public void Get_Verified_Web_URL()
	{
		String AccessToken=GetAccessToken();
		ResponsePojoKYC_Review  kyc_pojo=new ResponsePojoKYC_Review();
		kyc_pojo.setState("verified");
		kyc_pojo.setRef_id(ref_id);	
		ResponsePojoKYC_Review response=given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				 .header("X-Correlation-Id","4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
				 .header("Content-Type","application/json")
			     .header("Timestamp",Timestamp).body(kyc_pojo).when()
				 .post("apis/customers/kyc/profile/token")
				 .then().assertThat().statusCode(200).extract().response().as(ResponsePojoKYC_Review.class);
		Assert.assertTrue(response.getStatus().getMessage().equals("success"), "Get Verified Web URL is success");	
}

}


