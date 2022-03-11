package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APITestCarTransferForm {
    private String token;

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveLog(String massage) {
        return massage;
    }


    private void CarTransferSuccess() throws IOException {

        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getCarTransferFromSuccess().toJSONString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/service-request/car-transfer-form").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode, "0000");
        Assert.assertEquals(StatusMSG, "success");
        saveLog(response.toString());
    }

    private void CarTransferDataNotFound() throws IOException {

        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getCarTransferFromFailed().toJSONString();
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("/apis/hpservice/service-request/car-transfer-form").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode, "400");
        Assert.assertEquals(StatusMSG, "BAD REQUEST");
        saveLog(response.toString());
    }

    @Test(groups = "Test Car transfer form API ")
    public void Print() throws IOException {
        CarTransferSuccess();
        CarTransferDataNotFound();
    }
}

