package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.tmb.automation.model.CreateProductIconRequest;
import com.tmb.automation.model.ResponsePojo;
import com.tmb.automation.model.ResponsePojoProductIcon;
import com.tmb.automation.model.StatusPojo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class APICreateProductIcon {
	
	
	@Test(description="Create of Product ICon With all valid data")
	public void CreateProduct()
	{
	
	RestAssured.baseURI = "https://cc-dev1.oneapp.tmbbank.local";
	String response1 = given().relaxedHTTPSValidation().auth().preemptive()
			.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
			.multiPart("username", "occ_padmin02").multiPart("password", "P@ss12345").when()
			.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();

	
	JsonPath jsonPath = new JsonPath(response1);
	String AccessToken = jsonPath.getString("data.access_token");
	CreateProductIconRequest pIcon=new CreateProductIconRequest();
	pIcon.setIcon_id("123e4567-e89b-12d3-a456-426614174000");
	pIcon.setIcon_name_en("TMB Product 123");
	pIcon.setIcon_name_th("TMB Product 123");
	pIcon.setDescription("TMB Product is a good product");
	pIcon.setIcon("https://storage.googleapis.com/oneapp-vit.appspot.com/product/logo/icon_02.png");
	pIcon.setLast_updated_time(1605510413);
	pIcon.setStatus("Draft");
	pIcon.setUpdated_by("occ_padmin02");
	List<CreateProductIconRequest>ProductBody=new ArrayList<CreateProductIconRequest>();
	
	//StatusPojo status = js.getObject("status", StatusPojo.class);
	ResponsePojoProductIcon response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
			.header("Accept-Language", "en-US, th-TH").header("Timestamp", "786").body(ProductBody).when()
			.post("apis/common/internal/products/icon").then().assertThat().statusCode(200).extract().response()
			.as(ResponsePojoProductIcon.class);
	System.out.println("status Aru" + response2.getStatus().getCode());
   
}
	
	@Test(description="Create of Product ICon With get request")
	public void InvalidMethod()
	{
	
	RestAssured.baseURI = "https://cc-dev1.oneapp.tmbbank.local";
	String response1 = given().relaxedHTTPSValidation().auth().preemptive()
			.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
			.multiPart("username", "occ_padmin02").multiPart("password", "P@ss12345").when()
			.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();

	
	JsonPath jsonPath = new JsonPath(response1);
	String AccessToken = jsonPath.getString("data.access_token");
	CreateProductIconRequest pIcon=new CreateProductIconRequest();
	pIcon.setIcon_id("123e4567-e89b-12d3-a456-426614174000");
	pIcon.setIcon_name_en("TMB Product 123");
	pIcon.setIcon_name_th("TMB Product 123");
	pIcon.setDescription("TMB Product is a good product");
	pIcon.setIcon("https://storage.googleapis.com/oneapp-vit.appspot.com/product/logo/icon_02.png");
	pIcon.setLast_updated_time(1605510413);
	pIcon.setStatus("Draft");
	pIcon.setUpdated_by("occ_padmin02");
	List<CreateProductIconRequest>ProductBody=new ArrayList<CreateProductIconRequest>();
	
	//StatusPojo status = js.getObject("status", StatusPojo.class);
	ResponsePojoProductIcon response2 = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
	.header("Content-Type","application/json" )
			.header("Accept-Language", "en-US, th-TH").header("Timestamp", "786").body(ProductBody).when()
			.get("apis/common/internal/products/icon").then().assertThat().statusCode(400).extract().response()
			.as(ResponsePojoProductIcon.class);
	System.out.println("status Aru" + response2.getStatus().getCode());
   
	
	

	

}
	
	
	@Test(description="Validate Api with wrong data")
	public void Badrequest()
	{
	
	RestAssured.baseURI = "https://cc-dev1.oneapp.tmbbank.local";
	RestAssured.baseURI = "https://cc-dev1.oneapp.tmbbank.local";
	String response1 = given().relaxedHTTPSValidation().auth().preemptive()
			.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
			.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
			.multiPart("username", "occ_padmin02").multiPart("password", "P@ss12345").when()
			.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();

	
	
	JsonPath jsonPath = new JsonPath(response1);
	String AccessToken = jsonPath.getString("data.access_token");
	CreateProductIconRequest pIcon=new CreateProductIconRequest();
	pIcon.setIcon_id("123e4567-e89b-12d3-a456-426614174000");
	pIcon.setIcon_name_en("TMB Product 123");
	pIcon.setIcon_name_th("TMB Product 123");
	pIcon.setDescription("TMB Product is a good product");
	pIcon.setIcon("https://storage.googleapis.com/oneapp-vit.appspot.com/product/logo/icon_02.png");
	pIcon.setLast_updated_time(1605510413);
	pIcon.setStatus("Draft");
	pIcon.setUpdated_by("occ_padmin02");
	List<CreateProductIconRequest>ProductBody=new ArrayList<CreateProductIconRequest>();
	
	//StatusPojo status = js.getObject("status", StatusPojo.class);
	 String badResponse= given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
			.header("X-Correlation-Id", "  ").header("Content-Type","application/json" )
			.header("Accept-Language", "en-US, th-TH").header("Timestamp", "786").body(ProductBody).when()
			.get("apis/common/internal/products/icon").then().assertThat().statusCode(400).extract().response()
			.asString();
	System.out.println("status Bad Response is  " + badResponse);
   
	
	

	

}
	
	
}