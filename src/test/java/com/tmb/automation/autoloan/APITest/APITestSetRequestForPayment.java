package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APITestSetRequestForPayment {

    private String token;
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveLog(String massage) {

        return massage;
    }



    @Step("Success and print body")
    private void Success() throws IOException {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDIwMSIsInRpbWVTdGFtcCI6MTYxNzA4Nzg2MjY0NSwiQ0lEIjoiMzEzOTkwMDAyMzg0MCIsImxhbmd1YWdlIjoiZW4ifQ==");

        String body = "{\"accountNo\":\"23-5910053\",\"objectiveId\":\"04\",\"receiveById\":\"01\",\"methodId\":\"02\",\"licensePlate\":\"\u0e0c\u0e18 7067\",\"branchCode\":\"10220\",\"mobileNo\":\"0955154340\",\"mailingAddress\":\"165\\/1 \u0e0b.\u0e1b\u0e23\u0e30\u0e0a\u0e32\u0e23\u0e32\u0e29\u0e0e\u0e23\u0e4c\u0e1a\u0e33\u0e40\u0e1e\u0e47\u0e0d 5 \u0e16.\u0e1b\u0e23\u0e30\u0e0a\u0e32\u0e23\u0e32\u0e29\u0e0e\u0e23\u0e4c\u0e1a\u0e33\u0e40\u0e1e\u0e47\u0e0d \u0e41\u0e02\u0e27\u0e07\u0e2b\u0e49\u0e27\u0e22\u0e02\u0e27\u0e32\u0e07 \u0e40\u0e02\u0e15\u0e2b\u0e49\u0e27\u0e22\u0e02\u0e27\u0e32\u0e07 \u0e01\u0e23\u0e38\u0e07\u0e40\u0e17\u0e1e\u0e2f 10310\",\"email\":\"test.thanachart@gmail.com\",\"crmId\":\"001100000000000000000000125858\",\"debtFeeId\":\"c5cf9534-20dc-4957-804b-2e031e27dc7c\",\"paidAmount\":\"100.00\",\"receiptNo\":[\"620553137\",\"620379339\",\"620500203\"]}";
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/service-request/set-request-for-payment").then().assertThat().extract().response().asString();

        JsonPath resjsonPath = new JsonPath(response);

        saveLog(response.toString());



    }

    @Test(description = "Test API Set Request For Payment")
    public void TestAPISetRequestPayment() throws IOException {
        Success();
    }
}
