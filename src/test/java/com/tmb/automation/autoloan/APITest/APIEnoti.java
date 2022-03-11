package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIEnoti {

    private String token;

    @Attachment(value = "{0}", type = "text,plain")
    public static String saveLog(String message){
        return message;
    }

    @Step("Test API enoti Success")
    private void EnotiSuccess(){
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");
        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getEnitiSuccess().toJSONString();
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-ID","4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type","application/json")
                .body(body).when()
                .post("/e-noti/sendMessage").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode,"0000");
        Assert.assertEquals(StatusMSG,"success");
        saveLog(response);
    }

    @Test(description = "API test for Enoti")
    public  void  apiEnoti(){
        EnotiSuccess();
    }
}
