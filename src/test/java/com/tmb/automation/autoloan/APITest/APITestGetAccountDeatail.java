package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.qameta.allure.Attachment;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITestGetAccountDeatail {
    private String token;
    @Attachment(value = "{0}", type = "text,plain")
    public static String saveLog(String message) {
        return message;
    }
    private void  accountDetailSuccess(){
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        GetJsonData bodyObj = new GetJsonData();
        String body =bodyObj.getAccountDetailSuccess().toString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-ID","4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type","application/json")
                .body(body).when()
                .post("/apis/hpservice/account-details").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode,"0000");
        Assert.assertEquals(StatusMSG,"success");
        saveLog(response);
    }

    private void  accountDetailBadRequest(){
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        GetJsonData bodyObj = new GetJsonData();
        String body =bodyObj.getAccountDetailBadRq().toString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-ID","4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type","application/json")
                .body(body).when()
                .post("/apis/hpservice/account-details").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode,"400");
        Assert.assertEquals(StatusMSG,"BAD REQUEST");
        saveLog(response);
    }


    @Test(groups = "API Account Detail")
    public void APITestGetAccountDetail(){
        accountDetailSuccess();
        accountDetailBadRequest();
    }
}
