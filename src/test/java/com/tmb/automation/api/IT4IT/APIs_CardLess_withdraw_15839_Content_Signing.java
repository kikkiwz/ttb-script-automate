package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.automation.model.CardlessPojo;
import com.tmb.automation.model.CardlessPojo.uvAccessCodeKeys;
import com.tmb.automation.model.CardlessPojo.uvAddlogsKeys;
import com.tmb.automation.model.DataPojo;
import com.tmb.automation.model.PhrasesPojo;
import com.tmb.automation.model.PhrasesPojo.current_phrase;
import com.tmb.automation.model.PhrasesPojo.phrases;
import com.tmb.automation.model.PhrasesPojo.update_phrase;
import com.tmb.automation.model.ResponsePojoKYC_ReviewData;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class APIs_CardLess_withdraw_15839_Content_Signing {

	private static String AccessToken;
	private Long Timestamp;
	private static String Accesscode;
	public static Boolean ContentSigning=true;
	//@Test(description="AccessToken",priority=1)
	public String GetAccessToken()
	{
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


	@Test(description="Generate cardless AccessCode",priority=1)
	public void Generate_Cardless_AccessCode() throws Exception
	{
		String AccessToken= GetAccessToken();
		CardlessPojo cardless= new CardlessPojo();
		cardless.setAccount_number("0017644972");
		cardless.setAccount_name("ZZZ4972");
		cardless.setCustomer_name("NAME TEST");
		cardless.setAccount_type("SDA");
		cardless.setMobile_number("0817315935");
		cardless.setTransaction_date("2021-06-02T15:35:06");
		cardless.setTransaction_type("Withdraw");
		cardless.setAmount("200.00");		
		cardless.setLanguage("EN");
		cardless.setChannel_id("02");
		Content_Signing signing=new Content_Signing();
		String plainSigningKey = signing.prepareSigningKey(Timestamp.toString(), "/apis/auth/cardless/accesscode/generate", new ObjectMapper().writeValueAsString(cardless));
		String signingBase64 = signing.sign(signing.privateKey(signing.privateKeyBase64String),plainSigningKey);
		System.out.println("plainSigningKey : "+plainSigningKey);
		if(!ContentSigning) {
			signingBase64="";
		}
		Response res = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp)
				.header("Content-Signature",signingBase64)
				.body(cardless).when()
				.post("apis/auth/cardless/accesscode/generate").then().assertThat().statusCode(200).extract().response();
		CardlessPojo response=res.as(CardlessPojo.class); 
		if(ContentSigning) {  
			String responseTimeStamp = res.getHeader("Timestamp");
			String responseSign = res.getHeader("Content-Signature"); 
			String responseBody = res.getBody().asString();
			String responseVerifyKey = signing.prepareSigningKey(responseTimeStamp, "/apis/auth/cardless/accesscode/generate", responseBody);	  
			System.out.println("responseBody : "+responseBody);
			System.out.println("responseVerifyKey : "+responseVerifyKey);
			boolean verifyStatus = signing.verify(signing.publicKey(signing.publicKeyBase64String), responseVerifyKey, responseSign);
			System.out.println("verify status : "+verifyStatus);
			if(!verifyStatus) {
				throw new IOException("Some changes occure between request and response"); 

			}
		}
		Accesscode=response.getData().getAccess_code();
		System.out.println("The access code is---"+Accesscode);



	}



	@Test(description="Get access code details",priority=2)
	public void Get_access_code_details() throws Exception
	{
		String AccessToken=GetAccessToken();

		Content_Signing signing=new Content_Signing();
		String plainSigningKey = signing.prepareSigningKey(Timestamp.toString(), "/apis/auth/cardless/accesscode", "");
		String signingBase64 = signing.sign(signing.privateKey(signing.privateKeyBase64String),plainSigningKey);
		System.out.println("plainSigningKey : "+plainSigningKey);	
		if(!ContentSigning) {
			signingBase64="";
		}
		Response res= given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("content-signature",signingBase64).header("Timestamp", Timestamp).when()
				.get("apis/auth/cardless/accesscode").then().assertThat().statusCode(200).extract().response();
		CardlessPojo response=res.as(CardlessPojo.class); 
		if(ContentSigning) {  
		String responseTimeStamp = res.getHeader("Timestamp");
		String responseSign = res.getHeader("Content-Signature"); 
		String responseBody = res.getBody().asString();;
		String responseVerifyKey = signing.prepareSigningKey(responseTimeStamp, "/apis/auth/cardless/accesscode", responseBody);	  
		System.out.println("responseBody : "+responseBody);
		System.out.println("responseVerifyKey : "+responseVerifyKey);
		boolean verifyStatus = signing.verify(signing.publicKey(signing.publicKeyBase64String), responseVerifyKey, responseSign);
		System.out.println("verify status : "+verifyStatus);

		if(!verifyStatus) { throw new
			IOException("Some changes occure between request and response");

		}
		}

		String Accesscode_verify=response.getData().getAccess_code();
		System.out.println("The expected access code is--"+Accesscode+" but found "+Accesscode_verify);
		Assert.assertTrue(Accesscode_verify.equals(Accesscode), "Access code details Verified");		

	}

	@Test(description="Deactivate Cardless Request",priority=3)
	public void Deactivate_cardless_Request() throws IOException, GeneralSecurityException, URISyntaxException
	{

		String AccessToken=GetAccessToken();
		Content_Signing signing=new Content_Signing();
		String plainSigningKey = signing.prepareSigningKey(Timestamp.toString(), "/apis/auth/cardless/accesscode","");
		String signingBase64 = signing.sign(signing.privateKey(signing.privateKeyBase64String),plainSigningKey);
		System.out.println("plainSigningKey : "+plainSigningKey);
		if(!ContentSigning) {
			signingBase64="";
		}
		Response res = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json")
				.header("Accept-Language", "EN").header("Content-Signature",signingBase64).header("Timestamp", Timestamp).when()
				.post("apis/auth/cardless/accesscode").then().assertThat().statusCode(200).extract().response();
		ResponsePojoKYC_ReviewData response=res.as(ResponsePojoKYC_ReviewData.class);
		if(ContentSigning) {  
		String responseTimeStamp = res.getHeader("Timestamp");
		String responseSign = res.getHeader("Content-Signature"); 
		String responseBody = res.getBody().asString();
		String responseVerifyKey = signing.prepareSigningKey(responseTimeStamp, "/apis/auth/cardless/accesscode", responseBody);	  
		System.out.println("responseBody : "+responseBody);
		System.out.println("responseVerifyKey : "+responseVerifyKey);
		boolean verifyStatus = signing.verify(signing.publicKey(signing.publicKeyBase64String), responseVerifyKey, responseSign);
		System.out.println("verify status : "+verifyStatus);

		if(!verifyStatus ) { 
			throw new
			IOException("Some changes occure between request and response");
		}
		}
		String Deactivate_successful=response.getData();
		Assert.assertTrue(Deactivate_successful.equals("successfully deactivated card less withdraw request"), "successfully deactivated card less withdraw request");


	}
	@Test(description="Verify Cardless Request",priority=4)
	public void Verify_cardless_Request()
	{


		RestAssured.baseURI = "https://api-vit1.oneapp.tmbbank.local";
		CardlessPojo cardless1= new CardlessPojo();
		uvAccessCodeKeys cardless= new uvAccessCodeKeys();
		cardless.setMode("V");
		cardless.setAccessCode(Accesscode);
		cardless.setChannelId("04");
		cardless.setMobileNumber("0817315935");
		cardless.setTerminalId("T007B011B001P100");
		cardless.setTerminalLocation("TMB UAT TEST DIEBOLD");
		cardless.setTranDate("2021-06-02T15:39:24");
		cardless.setTransactionId("21060215392417315935");
		cardless.setTranType("M15");
		cardless1.setUvAccessCodeKeys(cardless);
		CardlessPojo response = given().relaxedHTTPSValidation()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).header("API-Key", "KCYmJjg4ODg2NjYyMyk5ODc2NTY1QCFwbyQjKA==").body(cardless1).when()
				.post("apis/uv/cardless/verify").then().assertThat().statusCode(200).extract().response().as(CardlessPojo.class);
		String statusDesc=response.getStatusDesc();
		String approvalDesc=response.getUvAccessCodeInfo().getApprovalDesc();
		Assert.assertTrue(statusDesc.equals("Success") && approvalDesc.equals("Success") , "statusDesc and approvalDesc is success");		

	}
	@Test(description="Acknowledge Cardless Request",priority=5)
	public void Acknowledge_cardless_Request()
	{



		RestAssured.baseURI = "https://api-vit1.oneapp.tmbbank.local";
		CardlessPojo cardless1= new CardlessPojo();
		uvAddlogsKeys cardless= new uvAddlogsKeys();
		cardless.setMode("V");
		cardless.setAccessCode(Accesscode);
		cardless.setChannelId("04");
		cardless.setAmount("200.00");
		cardless.setMobileNumber("0817315935");
		cardless.setTerminalId("T007B011B001P100");
		cardless.setTerminalLocation("TMB UAT TEST DIEBOLD");
		cardless.setTranDate("2021-06-02T15:39:24");
		cardless.setTransactionId("21060215392417315935");
		cardless.setTranType("M15");
		cardless1.setUvAddlogsKeys(cardless);
		CardlessPojo response = given().relaxedHTTPSValidation()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).header("API-Key", "KCYmJjg4ODg2NjYyMyk5ODc2NTY1QCFwbyQjKA==").body(cardless1).when()
				.post("apis/uv/cardless/acknowledge").then().assertThat().statusCode(200).extract().response().as(CardlessPojo.class);
		String statusDesc=response.getStatusDesc();
		String ResponseCode=response.getUvAddlogsInfo().getResponseCode();
		Assert.assertTrue(statusDesc.equals("Success") && ResponseCode.equals("0") , "statusDesc and ResponseCode is Verification is success");		


	}





























}

