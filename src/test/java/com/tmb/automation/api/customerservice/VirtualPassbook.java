package com.tmb.automation.api.customerservice;

import com.aventstack.extentreports.Status;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class VirtualPassbook  {
    @Test
    public static String getAccountSaving() throws IOException, ParseException {

        RestAssured.baseURI = "https://apis-portal.oneapp.tmbbank.local/";
        String response = given().relaxedHTTPSValidation().log().all()
                .header("X-Correlation-ID", "32fbd3b2-3f97-4a89-ar39-b4f628fbc8da")
                .header("Content-Type", "application/json")
                .header("x-crmid", "001100000000000000000018591228")
                .when()
                .get("apis/customer/accounts/saving").then().assertThat().extract().response().asString();

        return response;
    }
}
