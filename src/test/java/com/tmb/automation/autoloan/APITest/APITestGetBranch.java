package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import com.tmb.automation.model.Autolaon.GetToken;
import com.tmb.automation.util.ReadJson;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class APITestGetBranch {

    private String token ;
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveLog(String massage) {
        return massage;
    }

    @Step("English Respond Success")
    private void getBranchSuccess() throws IOException {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxNDkxNTkwOTM1NywiYWNjb3VudE51bWJlciI6IjI2NjE1NTgxMCIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTU4MTAifQ==");

        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getBranchSuccess().toString();
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()

                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/common/branch").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode,"0000");
        Assert.assertEquals(StatusMSG,"success");
        saveLog(response);


    }

    @Step("Thai Respond Success")
    private void getBranchTHSuccess(){
        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getBranchTHSuccess().toString();
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()

                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/common/branch").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode,"0000");
        Assert.assertEquals(StatusMSG,"success");
        saveLog(response.toString());
    }

    @Step("Bad request not sent langue return400")
    private void getBranchBadReq(){
        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getBranchBadReq().toString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        int response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/common/branch").then().assertThat().extract().response().getStatusCode();;
        Assert.assertEquals(response,400);
    }

    @Test(description = "Test get branch")
    public void testGetBranch() throws IOException {
        getBranchSuccess();
        getBranchTHSuccess();
        getBranchBadReq();
    }
}
