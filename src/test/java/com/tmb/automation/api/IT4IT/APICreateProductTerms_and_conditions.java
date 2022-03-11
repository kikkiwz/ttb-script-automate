package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class APICreateProductTerms_and_conditions {
	
	private static String AccessToken;
	private Long Timestamp;
	
	public String GetAccessToken()
	{
		Date date =new Date();
		Timestamp = date.getTime();
		RestAssured.baseURI = "https://cc-vit1.oneapp.tmbbank.local";
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
				.multiPart("username", "occ_padmin02").multiPart("password", "P@ss12345").when()
				.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		AccessToken = jsonPath.getString("data.access_token");
         System.out.println(AccessToken);
         return AccessToken;
	}
	@Test(description="Create product T&C",priority=1)
	public void Create_product_TandC()
	{
		String AccessToken=GetAccessToken();
		String id="abcdc_";
		String code="efghim_";
		int character = (int)Math.floor(Math.random() * 89999 + 6769);
		String randomnumberString=String.valueOf(character);
		String TandC_id=id+randomnumberString;
		String productcode=code+randomnumberString;
		File file=new File(System.getProperty("user.dir") + "\\src\\main\\resources\\IT4IT\\Sprint26Story12208\\Terms_and_Conditions.pdf");
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("file", file)
				.multiPart("term_and_condition_id", TandC_id).multiPart("product_code", productcode).multiPart("channel", "mb")
				.multiPart("term_and_condition_description", "API Automtion Testing").multiPart("html_th", "API Automtion Testing for Thai").multiPart("html_en", "API Automtion Testing for English")
				.when()
				.post("apis/internal/cc-exp/create-product-term-condition").then().assertThat().statusCode(200).extract().response().asString();						
		JsonPath js= new JsonPath(response);
		String TermsandConditioncreated = js.getString("data");
		System.out.println("The data is-----"+TermsandConditioncreated);
		Assert.assertTrue(TermsandConditioncreated.contains("Product term and condition created successfully"),"Product terms and conditions created successfully");

		
		
}
}

