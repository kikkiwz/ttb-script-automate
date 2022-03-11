package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APITestGetListOfReceipt {
    String token;

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveLog(String massage) {
        return massage;
    }

    private void ListOfReceiptSuccess() throws IOException {


        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxMjQzMjc4OTExOCwiYWNjb3VudE51bWJlciI6IjI2NjE1MTc3NyIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTE3NzcifQ==");


        System.out.println("AccessToken is" + token);


        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getSrTrackingList_Success().toString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/service-request/get-list-of-receipt").then().assertThat().extract().response().asString();
        saveLog(response.toString());
    }

    private void ListOfReceiptDataNotFound() throws IOException {


        System.out.println("AccessToken is" + token);


        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getSrTrackingList_Failed().toString();

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/service-request/get-list-of-receipt").then().assertThat().extract().response().asString();
        JsonPath jsonPath = new JsonPath(response);
        String StatusCode = jsonPath.getString("status.code");
        String StatusMSG = jsonPath.getString("status.message");
        Assert.assertEquals(StatusCode, "0010");
        Assert.assertEquals(StatusMSG, "Failed");
        saveLog(response);
    }


    @Test(groups = "Test Get list of receipt API ")
    public void Print() throws IOException {
        ListOfReceiptSuccess();
        ListOfReceiptDataNotFound();
    }
}
