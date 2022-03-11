package com.tmb.automation.pages.pb1;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class PhrasesAPI  {

	public String phrasesEn (String keyEn) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		String XCorrelation = prop.getProperty("XCorrelation");
		
		RestAssured.baseURI = BaseURI;
		String response1 = given().relaxedHTTPSValidation().queryParam("channel", "mb").log().all()
				.header("X-Correlation-Id", XCorrelation)
				.header("Accept-Language", "en-US, th-TH")
				.header("Timestamp", "123")
				.header("Content-Type", "application/json")
				.when().get("apis/mobile/config").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsonPath = new JsonPath(response1);
		Map<String, String>EngPhrases = jsonPath.get("data.phrases.en");
		System.out.println("-----EngPhrases------"+EngPhrases);
		
		String value=EngPhrases.get(keyEn);
		return value;
	}

public String phrasesTh (String keyTh) throws IOException {
		
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(
	System.getProperty("user.dir") + "/src/main/resources/Global.properties");
	prop.load(fis);
	
	String BaseURI = prop.getProperty("BaseURL");
	String XCorrelation = prop.getProperty("XCorrelation");
	
	RestAssured.baseURI = BaseURI;
	String response1 = given().relaxedHTTPSValidation().queryParam("channel", "mb").log().all()
			.header("X-Correlation-Id", XCorrelation)
				.header("Accept-Language", "en-US, th-TH")
				.header("Timestamp", "123")
				.header("Content-Type", "application/json")
				.when().get("apis/mobile/config").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsonPath = new JsonPath(response1);
		Map<String,String>ThaiPhrases = jsonPath.get("data.phrases.th");
		System.out.println("-----ThaiPhrases------"+ThaiPhrases);
		
		String value1=ThaiPhrases.get(keyTh);
		return value1;
	}


public String setMenu (String keyList) throws IOException {
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(
	System.getProperty("user.dir") + "/src/main/resources/Global.properties");
	prop.load(fis);
	
	String BaseURI = prop.getProperty("BaseURL");
	String XCorrelation = prop.getProperty("XCorrelation");
	
	RestAssured.baseURI = BaseURI;
	String response1 = given().relaxedHTTPSValidation().queryParam("channel", "mb").log().all()
			.header("X-Correlation-Id", XCorrelation)
			.header("Accept-Language", "en-US, th-TH")
			.header("Timestamp", "123")
			.header("Content-Type", "application/json")
			.when().get("apis/mobile/config").then().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js = new JsonPath(response1);
	@SuppressWarnings("rawtypes")
	ArrayList<HashMap> Menu = js.get("data.menu");
	System.out.println("-----Menu------"+Menu);
	String value2 = null;
	
	for (int i=0; i<Menu.size(); i++) {
	System.out.println("--------ArrayLoop Count-------- " +i);
	value2 = (String) Menu.get(i).get(keyList);
	System.out.println("-----Name------"+value2);
	}
	return value2;
}
}
