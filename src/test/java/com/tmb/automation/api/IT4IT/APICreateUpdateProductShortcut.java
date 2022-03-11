package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.automation.model.CreateProductIconRequest;
import com.tmb.automation.model.CreateProductShortcutRequest;
import com.tmb.automation.model.ResponsePojo;
import com.tmb.automation.model.ResponsePojoProductIcon;
import com.tmb.automation.model.StatusPojo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class APICreateUpdateProductShortcut {
	
private String finalrandomnumber;

	@Test(description="Create of Product Shortcut With all valid data")
	public void CreateProductShortcut()
	{

		RestAssured.baseURI = "https://cc-vit1.oneapp.tmbbank.local";
		String response1 = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username", "occ_111").multiPart("password", "P@ss12345").when()
				.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();


		JsonPath jsonPath = new JsonPath(response1);
		String AccessToken = jsonPath.getString("data.access_token");


			String randomnumber="123e4559-e89b-12d9-a456-";
			int character = (int)Math.floor(Math.random() * 899999999 + 123456789);
			System.out.println("The product shortcut id integeris--"+character);
			String randomnumberString=String.valueOf(character);
			finalrandomnumber=randomnumber+randomnumberString;	
			System.out.println("The product shortcut id is--"+finalrandomnumber);
		
		CreateProductShortcutRequest pshortcut=new CreateProductShortcutRequest();
		pshortcut.setId(finalrandomnumber);
		pshortcut.setName_en("API Automation Testing ENG");
		pshortcut.setName_th("API Automation Testing THAI");
		pshortcut.setUpdated_by("Binit Sharma");
		pshortcut.setUrl("https://firebasestorage.googleapis.com/v0/b/oneapp-vit.appspot.com/o/product%2Fshortcut%2Fcreditcard%2Ftopup.png?alt=media&token=123e4567-e89b-12d3-a456-470059595817");
		pshortcut.setDescription("API Automation triggered to create new product shortcut");
		ResponsePojoProductIcon response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "en-US, th-TH").header("Timestamp", "786").body(pshortcut).when()
				.post("apis/internal/cc-exp/save-product-shortcut").then().assertThat().statusCode(200).extract().response()
				.as(ResponsePojoProductIcon.class);
		Assert.assertTrue(response2.getData().equals("Shortcut saved successfully!!!"), "Shortcut not saved sucessfully");


	}
	@Test(description="Update of Product Shortcut With all valid data")
	public void UpdateProductShortcut()
	{

		RestAssured.baseURI = "https://cc-vit1.oneapp.tmbbank.local";
		String response1 = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username", "occ_111").multiPart("password", "P@ss12345").when()
				.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response1);
		String AccessToken = jsonPath.getString("data.access_token");


		CreateProductShortcutRequest pshortcut=new CreateProductShortcutRequest();
		pshortcut.setId(finalrandomnumber);
		pshortcut.setName_en("API Automation Testing ENG Updated");
		pshortcut.setName_th("API Automation Testing THAI Updated");
		pshortcut.setUpdated_by("Binit Sharma");
		pshortcut.setUrl("https://firebasestorage.googleapis.com/v0/b/oneapp-vit.appspot.com/o/product%2Fshortcut%2Fcreditcard%2Ftopup.png?alt=media&token=123e4567-e89b-12d3-a456-470059595817");
		pshortcut.setDescription("API Automation triggered to create new product shortcut");
		ResponsePojoProductIcon response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "en-US, th-TH").header("Timestamp", "786").body(pshortcut).when()
				.post("apis/internal/cc-exp/update-product-shortcut").then().assertThat().statusCode(200).extract().response()
				.as(ResponsePojoProductIcon.class);
		Assert.assertTrue(response2.getData().equals("Shortcut saved successfully!!!"), "Shortcut not saved sucessfully");


	}

}