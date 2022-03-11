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

public class APIs_Manage_Product_Terms_and_Condition {

	private static String AccessToken;
	private Long Timestamp;
	//@Test(description="AccessToken",priority=1)
	public void GetAccessToken()
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

	}

	
	@Test(description="Get all product T&C",priority=1)
	public void Get_all_product_TandC()
	{
		GetAccessToken();
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").params("page", "0", "size","10","sort-by","last_updated_date","order-by","DESC").when()
				.get("apis/common/internal/term-condition/products").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);		
		String term_and_condition_id=(js.getString("data.term_and_conditions.term_and_condition_id"));
		Assert.assertTrue(!term_and_condition_id.equals(""));

	}
	@Test(description="Get published product T&C by productCode and channel",priority=2)
	public void Get_pblished_product_TandC_By_productCode_and_channel()
	{
		GetAccessToken();
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
				.get("apis/common/internal/term-condition/product/101/ib").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);		
		String term_and_condition_id=(js.getString("data.term_and_condition_id"));
		String status=(js.getString("data.status"));
		Assert.assertTrue(!term_and_condition_id.equals(""));
		Assert.assertTrue(status.equals("Published"));

	}
	@Test(description="Get published service T&C by serviceCode and channel",priority=3)
	public void Get_published_service_TandC_by_serviceCode_and_channel()
	{
		GetAccessToken();
		String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").params("page", "0", "size","10","sort-by","last_updated_date","order-by","DESC").when()
				.get("apis/common/internal/term-condition/service/S222/mb").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);		
		String service_term_and_condition_id=(js.getString("data.service_term_and_condition_id"));
		Assert.assertTrue(!service_term_and_condition_id.equals(""));
		String service_code=(js.getString("data.service_code"));
		Assert.assertTrue(service_code.equals("S222"));
		String service_term_and_condition_description=(js.getString("data.service_term_and_condition_description"));
		Assert.assertTrue(!service_term_and_condition_description.equals(""));
		

	}
	


	
}

