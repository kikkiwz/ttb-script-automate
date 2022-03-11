package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITestCloseAccount {
    private String token;

    private void CloseAccountOnlinePaymentSuccess() {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getCloseAccountOnlinePaymentSuccess().toJSONString();
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("/apis/hpservice/service-request/close-account").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        String RedisKeyvalue = jsonPath.getString("data.redisKey");
        System.out.println("RedisKey is : " + RedisKeyvalue);
        boolean RedisKey = jsonPath.getString("data.redisKey").isEmpty();
        Assert.assertEquals(StatusCode, "0000");
        Assert.assertEquals(StatusMSG, "success");
        Assert.assertFalse(RedisKey);
    }

    private void CloseAccountOnlinePaymentBadRQ() {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getCloseAccountOnlinePaymentBadRQ().toJSONString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("/apis/hpservice/service-request/close-account").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode, "400");
        Assert.assertEquals(StatusMSG, "BAD REQUEST");
    }

    @Test(groups = "API Test Close Account")
    public void apiTestCloseAccount(){
        CloseAccountOnlinePaymentSuccess();
        CloseAccountOnlinePaymentSuccess();
    }
}
