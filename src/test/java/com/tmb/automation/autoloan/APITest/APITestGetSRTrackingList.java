package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.tmb.automation.autoloan.APITest.APITestGetListOfReceipt.saveLog;
import static io.restassured.RestAssured.given;

public class APITestGetSRTrackingList {

    private String token;

    @Attachment(value = "{0}", type = "text/plain")
    public static String SaveLog(String massage) {
        return massage;
    }




    @Step("Success and print body")
    private void Success() throws IOException {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        String body = "{\"srNo\":\"TMP900400221000001\",\"language\":\"TH\"}";
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/service-request/list/tracking/detail").then().assertThat().extract().response().asString();


        saveLog(response);

    }

    @Test(description = "Test API ")
    public void Print() throws IOException {
        Success();
    }
}

