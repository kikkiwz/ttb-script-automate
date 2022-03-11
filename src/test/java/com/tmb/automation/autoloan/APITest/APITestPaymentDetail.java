package com.tmb.automation.autoloan.APITest;


import com.tmb.automation.autoloan.AutoloanUtility;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITestPaymentDetail {
    private String token;

    @Attachment(value = "{0}", type = "text,plain")
    public static String saveLog(String message) {
        return message;
    }

    private void getPaymentDetailSuccess() {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxNTE4ODAzNjE0NSwiYWNjb3VudE51bWJlciI6IjI2NjE1NTgxMCIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTU4MTAifQ==");
        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getPaymentDetailSuccess().toJSONString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-ID", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("/apis/hpservice/payment-details").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode, "0000");
        Assert.assertEquals(StatusMSG, "success");
        saveLog(response);
    }

    private void getPaymentDetailBadRQ() {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxNTE4ODAzNjE0NSwiYWNjb3VudE51bWJlciI6IjI2NjE1NTgxMCIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTU4MTAifQ==");
        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getPaymentDetailBadRQ().toJSONString();
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-ID", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("/apis/hpservice/payment-details").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode, "400");
        Assert.assertEquals(StatusMSG, "BAD REQUEST");
        saveLog(response);
    }
    @Test(groups = "API Test Payment Detail")
    public void apiTestPaymentDetail() {
        getPaymentDetailSuccess();
        getPaymentDetailBadRQ();
    }
}
