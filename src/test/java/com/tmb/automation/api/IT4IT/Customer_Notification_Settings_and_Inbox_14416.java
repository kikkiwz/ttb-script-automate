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
import com.tmb.automation.model.Customer_Notification_Settings_Inbox_Pojo;
import com.tmb.automation.model.Customer_Notification_Settings_Inbox_Pojo_2;
import com.tmb.automation.model.Customer_Notification_Settings_Inbox_Pojo_2.settings;
import com.tmb.automation.model.Customer_Notification_Settings_Inbox_Pojo_2.updated_settings;
import com.tmb.automation.model.DataPojo;
import com.tmb.automation.model.PhrasesPojo;
import com.tmb.automation.model.PhrasesPojo.current_phrase;
import com.tmb.automation.model.PhrasesPojo.phrases;
import com.tmb.automation.model.PhrasesPojo.update_phrase;
import com.tmb.automation.model.ResponsePojoKYC_ReviewData;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Customer_Notification_Settings_and_Inbox_14416 {

	private static String AccessToken;
	private Long Timestamp;
	private String first_id;
	private String Second_id;
	//@Test(description="AccessToken",priority=1)
	public String GetAccessToken()
	{
		Date date =new Date();
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

	
	@Test(description="Get inbox messages",priority=1)
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
	@Test(description="Update Red Flag",priority=2)
	public void Update_Red_flag() throws IOException, GeneralSecurityException, URISyntaxException
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
	@Test(description="Delete Messages",priority=3)
	public void Delete_messages() throws IOException, GeneralSecurityException, URISyntaxException
	{
		
	
		ArrayList<String> ids=new ArrayList<String>();
		ids.add(first_id);
		ids.add(Second_id);
		ArrayList<String> message_Subject=new ArrayList<String>();
		message_Subject.add("ID Verification Request");
		message_Subject.add("ID Verification Request");
		String AccessToken=GetAccessToken();
		Customer_Notification_Settings_Inbox_Pojo Delete_message_body=new Customer_Notification_Settings_Inbox_Pojo();
		Delete_message_body.setIds(ids);
		Delete_message_body.setMessage_subject(message_Subject);
     	Customer_Notification_Settings_Inbox_Pojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).body(Delete_message_body).when()
				.delete("/apis/customer/inbox/messages").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo.class);
	Assert.assertTrue(response.getData().contains("message deleted successfully"), "message deleted successfully");

	}
	
	@Test(description="Get badge count",priority=4)
	public void Get_badge_count()
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
	@Test(description="Update badge count",priority=5)
	public void Update_badge_count()
	{
		String AccessToken= GetAccessToken();		
		Customer_Notification_Settings_Inbox_Pojo response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", Timestamp).when()
				.put("apis/customers/inbox/update-badge").then().assertThat().statusCode(200).extract().response().as(Customer_Notification_Settings_Inbox_Pojo.class);
				String Success=response.getStatus().getMessage();
				Assert.assertTrue(Success.contentEquals("success"), "Update Badge count success");
	
	}
	@Test(description="Get email notification details",priority=6)
	public void Get_email_notification_details()
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
	@Test(description="Update email notification details",priority=7)
	public void Update_email_notification_details()
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
	
	
	@Test(description="Get push settings",priority=8)
	public void Get_push_settings()
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
	@Test(description="Update push settings",priority=9)
	public void Update_push_settings()
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
	
	@Test(description="Get email notification details with timestamp",priority=10)
	public void Get_email_notification_details_with_timestamp()
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

