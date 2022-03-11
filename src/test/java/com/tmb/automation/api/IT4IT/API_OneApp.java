package com.tmb.automation.api.IT4IT;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.automation.model.CardlessPojo;
import com.tmb.automation.model.CardlessPojo.uvAccessCodeKeys;
import com.tmb.automation.model.CardlessPojo.uvAddlogsKeys;
import com.tmb.automation.model.Customer_Notification_Settings_Inbox_Pojo;
import com.tmb.automation.model.Customer_Notification_Settings_Inbox_Pojo_2;
import com.tmb.automation.model.Customer_Notification_Settings_Inbox_Pojo_2.settings;
import com.tmb.automation.model.Customer_Notification_Settings_Inbox_Pojo_2.updated_settings;
import com.tmb.automation.model.ResponsePojoKYC_Review;
import com.tmb.automation.model.ResponsePojoKYC_ReviewData;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
public class API_OneApp {
	public static  Properties prop;
	public static String username;
	public static String password;
	public static Long Timestamp;
	public static String ref_id;
	private static String Accesscode;
	private static String first_id;
	private static String Second_id;
	
	public String GetAccessToken() throws Exception
	{
		prop = new Properties();
		Date date =new Date();
		Timestamp = date.getTime();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		String Environment=prop.getProperty("oneapp_environment");
		username=prop.getProperty("usernameoneapp");
		password=prop.getProperty("passwordoneapp");
		if(Environment.equalsIgnoreCase("dev")) {
			RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
		}
		else if(Environment.equalsIgnoreCase("vit")) {
			RestAssured.baseURI = "https://oneapp-vit1.tau2904.com";
		}
		else if(Environment.equalsIgnoreCase("uat")) {
			RestAssured.baseURI = "https://oneapp-uat2.tau2904.com";
		}
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username",username)
				.multiPart("password",password)
				.multiPart("scope", "mobile").when()
				.post("apis/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		String AccessToken = jsonPath.getString("data.access_token");
		System.out.println("The access token is--"+AccessToken);
		return AccessToken;
	}
	
	@Test(description="Email Notification Flag Migration",priority=1)
	public void API_EmailNotificationFlagMigration() throws Exception
	{
		String AccessToken=GetAccessToken();
		String crmid=prop.getProperty("CRMID");
		Date date =new Date();
		Timestamp = date.getTime();		
		RestAssured.baseURI = "http://customers-service-https-internal-dev1-oneapp.apps.ddid1.tmbcps.com";
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-ID", "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da")
				.header("X-CRMID",crmid)
				.header("Timestamp",Timestamp).when()
				.post("apis/customers/settings/notification/email/migrate").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));
		String data=(js.getString("data"));
		Assert.assertTrue(data.equals("Email notification settings update successfully"));
	}
	@Test(description="Get Block flag",priority=2)
	public void Get_block_flag() throws Exception
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
	@Test(description="Get Landing page web URL",priority=3)
	public void Get_LandingPageWebURL() throws Exception
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
	@Test(description="Validate Pin Success",priority=4)
	public void Validate_Pin_Success () throws Exception
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
	@Test(description="Get Verified Web URL",priority=5)
	public void Get_Verified_Web_URL() throws Exception
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
	@Test(description="Migrate API",priority=6)
	public void Migrate_API()
	{
		Date date =new Date();
		Timestamp = date.getTime();
		String public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugnOavqvRCbtg/CvOKCd7ci6x0xc1u3rfN06nsi7dWRG0BmbvbP+XQZ3saZZdOQS4xcLXJqGh47MtvJynb8C52EgZ897DOvMz56dRQzLUEbrEBSKSRkyffsVPoLzDlbZW+2MW6wanXh6fudxhD2Cz4IZViUE6428+aXbaxXUr/WJd9dBB+vv7D9+HjhlwZlluzTU9pc+WZ6LCS/HNhVNRToOh3n0vKILnR7hJSB7kNNqNcMIxXUmj1HRWVn3pu5mtz4Mo7FkfbBZboVT/F8YjW/otRQ85599OBkPiRQCHwSTq2CD/BhOIq3gXepsDx+87CCf9lcGP9Rvv9IjiSTpeQIDAQAB";
		//RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
		String response = given().relaxedHTTPSValidation().auth().preemptive().basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-ID", "6cd91013-8ad0-4b2e-bd14-ebccf6856").header("touch-deviceid","dGMmKV6v9dnfOYOzCaiHtZgh9r4DxZv3diNAwNCuTQE=")
				.header("auth-public-key",public_key)
				.header("Timestamp",Timestamp).when()
				.get("apis/customer/device/migrate").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));
		String rm_id=(js.getString("data.rm_id"));
		Assert.assertTrue(!rm_id.equals(""));
		String ref_id=(js.getString("data.ref_id"));
		Assert.assertTrue(!ref_id.equals(""));
		System.out.println("The rm-id is "+rm_id+" and ref_id is "+ref_id);
	
		

	}
	@Test(description="Register API",priority=7)
	public void Register_API()
	{
		Date date =new Date();
		Timestamp = date.getTime();
		//RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
		String response = given().relaxedHTTPSValidation().auth().preemptive().basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "6cd91013-8ad0-4b2e-bd14-ebccf6856").header("touch-deviceid","dGMmKV6v9dnfOYOzCaiHtZgh9r4DxZv3diNAwNCuTQE=")
				.header("auth-public-key","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugnOavqvRCbtg/CvOKCd7ci6x0xc1u3rfN06nsi7dWRG0BmbvbP+XQZ3saZZdOQS4xcLXJqGh47MtvJynb8C52EgZ897DOvMz56dRQzLUEbrEBSKSRkyffsVPoLzDlbZW+2MW6wanXh6fudxhD2Cz4IZViUE6428+aXbaxXUr/WJd9dBB+vv7D9+HjhlwZlluzTU9pc+WZ6LCS/HNhVNRToOh3n0vKILnR7hJSB7kNNqNcMIxXUmj1HRWVn3pu5mtz4Mo7FkfbBZboVT/F8YjW/otRQ85599OBkPiRQCHwSTq2CD/BhOIq3gXepsDx+87CCf9lcGP9Rvv9IjiSTpeQIDAQAB")
				.header("Timestamp",Timestamp).header("oneapp-deviceid","Q7SjGqheETxAjOyx4ydYATjueQtp34qotG04TJHRnxPq5AhgMCTGclAxvkTwHwZAFWkJex4sHzDqzUiuQM6kL+Ng/oOQH6hjwGmOgxJcgO/FsKH0yZTFa97ruNIVxDKXFplJh1lQgsiTWNQY9y9PoQgm3Ln7YThZpBT6mCRs+ECkiYI4UasakYjKbaJm9onuBbrSSpm7kO0EfPC6Dlh1eqB8MhSMQTZvIyXisK5OiAUGtkCJyLbxNzTMqcQFId/pHMZlBZ+r32yXIpJGZHoTYXtp2GEwAz41SpfbQcA+a23++S5huz4tAqY2miRqnVGwVeRuSSnHXuM3VsCIwMtYgA==").when()
				.post("apis/customer/device/register").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));

	}
	@Test(description="Generate cardless AccessCode",priority=8)
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
		
		CardlessPojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).body(cardless).when()
				.post("apis/auth/cardless/accesscode/generate").then().assertThat().statusCode(200).extract().response().as(CardlessPojo.class);
		//JsonPath js= new JsonPath(response);
		Accesscode=response.getData().getAccess_code();
				
		

	}
	
	@Test(description="Get access code details",priority=9)
	public void Get_access_code_details() throws Exception
	{
		String AccessToken=GetAccessToken();
		CardlessPojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.get("apis/auth/cardless/accesscode").then().assertThat().statusCode(200).extract().response().as(CardlessPojo.class);
		String Accesscode_verify=response.getData().getAccess_code();
		System.out.println("The expected access code is--"+Accesscode+" but found "+Accesscode_verify);
		Assert.assertTrue(Accesscode_verify.equals(Accesscode), "Access code details Verified");		

	}
	
	@Test(description="Deactivate Cardless Request",priority=10)
	public void Deactivate_cardless_Request() throws Exception
	{
			
		String AccessToken=GetAccessToken();
		ResponsePojoKYC_ReviewData response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.post("apis/auth/cardless/accesscode").then().assertThat().statusCode(200).extract().response().as(ResponsePojoKYC_ReviewData.class);
		String Deactivate_successful=response.getData();
		Assert.assertTrue(Deactivate_successful.equals("successfully deactivated card less withdraw request"), "successfully deactivated card less withdraw request");
	
	
	}
	@Test(description="Verify Cardless Request",priority=11)
	public void Verify_cardless_Request()
	{
			
		
		RestAssured.baseURI = "https://api-dev1.oneapp.tmbbank.local";
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
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).header("API-Key", "Pxw2hpJXXs5zNwSrp218DWzbDIh1XZaGEGOGNSF0xhFfnheA").body(cardless1).when()
				.post("apis/internal/oauth/cardless/verify").then().assertThat().statusCode(200).extract().response().as(CardlessPojo.class);
		String statusDesc=response.getStatusDesc();
		String approvalDesc=response.getUvAccessCodeInfo().getApprovalDesc();
		System.out.println("The response is ---"+statusDesc+"  "+approvalDesc);
		Assert.assertTrue(statusDesc.equals("Success") && approvalDesc.equals("Success") , "statusDesc and approvalDesc is success");		
	
	}
	@Test(description="Acknowledge Cardless Request",priority=12)
	public void Acknowledge_cardless_Request()
	{		
		RestAssured.baseURI = "https://api-dev1.oneapp.tmbbank.local";
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
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).header("API-Key", "Pxw2hpJXXs5zNwSrp218DWzbDIh1XZaGEGOGNSF0xhFfnheA").body(cardless1).when()
				.post("apis/internal/oauth/cardless/acknowledge").then().assertThat().statusCode(200).extract().response().as(CardlessPojo.class);
		String statusDesc=response.getStatusDesc();
		String ResponseCode=response.getUvAddlogsInfo().getResponseCode();
		Assert.assertTrue(statusDesc.equals("Success") && ResponseCode.equals("0") , "statusDesc and ResponseCode is Verification is success");			
	
	}
	@Test(description="Get inbox messages",priority=13)
	public void Get_inbox_messages() throws Exception, GeneralSecurityException, URISyntaxException
	{
		String AccessToken= GetAccessToken();
			
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.get("apis/customers/inbox/messages").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		String[] id = jsonPath.getString("data.id").split(",");
		first_id=id[1].replace(" ", "");
		Second_id=id[2].replace(" ", "");
	}
	@Test(description="Update Red Flag",priority=14)
	public void Update_Red_flag() throws Exception
	{
		String AccessToken=GetAccessToken();
				String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.put("apis/customers/inbox/messages/"+first_id).then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		String updated=jsonPath.getString("data");
		Assert.assertTrue(updated.contains("message status updated successfully"), "message status updated successfully");

	}
	@Test(description="Delete Messages",priority=15)
	public void Delete_messages() throws Exception
	{
		
		String AccessToken=GetAccessToken();
		ArrayList<String> ids=new ArrayList<String>();
		ids.add(first_id);
		ids.add(Second_id);
		ArrayList<String> message_Subject=new ArrayList<String>();
		message_Subject.add("ID Verification Request");
		message_Subject.add("ID Verification Request");		
		Customer_Notification_Settings_Inbox_Pojo Delete_message_body=new Customer_Notification_Settings_Inbox_Pojo();
		Delete_message_body.setIds(ids);
		Delete_message_body.setMessage_subject(message_Subject);
     	Customer_Notification_Settings_Inbox_Pojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).body(Delete_message_body).when()
				.delete("/apis/customer/inbox/messages").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo.class);
	Assert.assertTrue(response.getData().contains("message deleted successfully"), "message deleted successfully");

	}
	
	@Test(description="Get badge count",priority=16)
	public void Get_badge_count() throws Exception
	{
		String AccessToken= GetAccessToken();		
		Customer_Notification_Settings_Inbox_Pojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN")
				.header("deviceId", "XAiN4JXphjKA+HjADvizKUNwX/hsibnIC3x+/4/Z8KsfErhMI2XCUKugi+q8eULx7CyYP9Sxzoz/mKgr4/cV4MrqhEPtlK4ytSVInmj7AlY6Cx4k5Zs9hpZJW51xsCP8qU3Vi/cT5wvAd9j5iYkbqGj6wNWB7uVivLlF7MmWVc6r3/3ikp2/6tB/W7iZv/9A+P7XGtuZw4o4B1nra4ihwy48Ah3SQSI8/vO6JKJE+srIgC3cQWuQ7ggh5esXe1mrGQflMb4ROIbVJFI4jp3zb1FyPSsj+t+MFtnHbkZvHvkWqc5KnnyGEZdU5FQXVRaEwvJNjSIpkgECCJXynE8pwQ==").header("Timestamp", Timestamp)
				.when()
				.get("apis/customers/inbox/badge").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo.class);
				String Success=response.getStatus().getMessage();
				Assert.assertTrue(Success.contentEquals("success"), "Get Badge count success");
	
	}
	@Test(description="Update badge count",priority=17)
	public void Update_badge_count() throws Exception
	{
		String AccessToken= GetAccessToken();		
		Customer_Notification_Settings_Inbox_Pojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.put("apis/customers/inbox/update-badge").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo.class);
				String Success=response.getStatus().getMessage();
				Assert.assertTrue(Success.contentEquals("success"), "Update Badge count success");
	
	}
	@Test(description="Get email notification details",priority=18)
	public void Get_email_notification_details() throws Exception
	{
		String AccessToken= GetAccessToken();		
		Customer_Notification_Settings_Inbox_Pojo_2 response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.get("apis/customer/settings/notification/email").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo_2.class);
				String Email_notification=response.getStatus().getMessage();
				Assert.assertTrue(response.getData().getApp_level_notification().equals(false) || response.getData().getApp_level_notification().equals(true), "App level notification verified");
				Assert.assertTrue(response.getData().getLogin_notification().equals(false) || response.getData().getLogin_notification().equals(true), "Login notification verified");
				Assert.assertTrue(response.getData().getTransaction_notification().equals(false) || response.getData().getTransaction_notification().equals(true), "Transaction notification verified");
				Assert.assertTrue(Email_notification.contentEquals("success"), "Email notification status success");
	}
	@Test(description="Update email notification details",priority=19)
	public void Update_email_notification_details() throws Exception
	{
		String AccessToken= GetAccessToken();	
		Customer_Notification_Settings_Inbox_Pojo_2 update= new Customer_Notification_Settings_Inbox_Pojo_2();
		settings setting=new settings();
		setting.setApp_level_notification(false);
		setting.setFlow("settings");
		setting.setLogin_notification(false);
		setting.setTransaction_notification(false);
		update.setSettings(setting);
		updated_settings updated_setting=new updated_settings();
		updated_setting.setApp_level_notification(true);
		updated_setting.setFlow("settings");
		updated_setting.setLogin_notification(true);
		updated_setting.setTransaction_notification(true);
		update.setUpdated_settings(updated_setting);		
		Customer_Notification_Settings_Inbox_Pojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).body(update).when()
				.post("apis/customer/settings/notification/email").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo.class);
		Assert.assertTrue(response.getData().contains("Email notification settings update successfully"), "Email notification settings update successfully");
					}
	
	
	@Test(description="Get push settings",priority=20)
	public void Get_push_settings() throws Exception
	{
		String AccessToken= GetAccessToken();		
		Customer_Notification_Settings_Inbox_Pojo_2 response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.get("apis/notification/settings/push/config").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo_2.class);
				String Email_notification=response.getStatus().getMessage();
				Assert.assertTrue(response.getData().getNews_notification_enabled().equals(false) || response.getData().getNews_notification_enabled().equals(true), "News notification enabled verified");
				Assert.assertTrue(response.getData().getApp_level_push_notification_enabled().equals(false) || response.getData().getApp_level_push_notification_enabled().equals(true), "App level push notification verified");
				Assert.assertTrue(Email_notification.contentEquals("success"), "Email notification status success");
	}
	@Test(description="Update push settings",priority=21)
	public void Update_push_settings() throws Exception
	{
		String AccessToken= GetAccessToken();	
		Customer_Notification_Settings_Inbox_Pojo_2 update_push= new Customer_Notification_Settings_Inbox_Pojo_2();
		update_push.setFlow("settings");
		update_push.setApp_level_push_notification_enabled(false);
		update_push.setNews_notification_enabled(false);
		
		
		Customer_Notification_Settings_Inbox_Pojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).body(update_push).when()
				.post("apis/customer/settings/notification/push").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo.class);
		Assert.assertTrue(response.getData().contains("Push notification config updated successfully"), "Push notification config updated successfully");
					}
	
	@Test(description="Get email notification details with timestamp",priority=22)
	public void Get_email_notification_details_with_timestamp() throws Exception
	{
		String AccessToken= GetAccessToken();		
		Customer_Notification_Settings_Inbox_Pojo_2 response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.get("apis/customer/settings/notification/email").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo_2.class);
				String Email_notification=response.getStatus().getMessage();
				Assert.assertTrue(response.getData().getApp_level_notification().equals(false) || response.getData().getApp_level_notification().equals(true), "App level notification verified");
				Assert.assertTrue(response.getData().getLogin_notification().equals(false) || response.getData().getLogin_notification().equals(true), "Login notification verified");
				Assert.assertTrue(response.getData().getTransaction_notification().equals(false) || response.getData().getTransaction_notification().equals(true), "Transaction notification verified");
				Assert.assertTrue(!response.getData().getTransaction_notification_date().equals(null) , "Transaction notification date verified");
				Assert.assertTrue(!response.getData().getLogin_notification_date().equals(null) , "Login notification date verified");
				Assert.assertTrue(Email_notification.contentEquals("success"), "Email notification status success");
	
	}
	

	

	




}
