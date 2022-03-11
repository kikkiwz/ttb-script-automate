package com.tmb.automation.common;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PhrasesConfigServiceMongoDb implements PhrasesConfigService {

    private HashMap<String, String> enPhrases;
    private HashMap<String, String> thPhrases;

    public PhrasesConfigServiceMongoDb() {
        init();

    }

    public void init() {
        String body = "{\r\n" +
                " \"id\": \"app_config_mb\",\r\n" +
                " \"channel\": \"mb\",\r\n" +
                " \"details\": {\r\n" +
                " \"app_name\": \"TMB One App\",\r\n" +
                " \"app_version\": \"1.0\"\r\n" +
                " }\r\n" +
                " }";
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response1 = given().relaxedHTTPSValidation().queryParam("channel", "mb").log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Accept-Language", "en-US, th-TH").header("Timestamp", "786")
                .header("Content-Type", "application/json").body(body).when()
                .get("apis/mobile/config").then().assertThat().statusCode(200).extract().response().asString();
        JsonPath jsonPath = new JsonPath(response1);
        enPhrases = jsonPath.get("data.phrases.en");
        thPhrases = jsonPath.get("data.phrases.th");

    }

    @Override
    public String getValueTh(String key) {
        return thPhrases.get(key);
    }

    @Override
    public String getValueEn(String key) {
        return enPhrases.get(key);
    }

    @Override
    public String getValue(String language , String key) {
        if("en".equalsIgnoreCase(language )) return getValueEn(key);
        return getValueTh(key);
    }
}
