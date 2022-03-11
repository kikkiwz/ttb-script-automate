package com.tmb.automation.test.lending.sprint18;

import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.test.lending.sprint15.LendingTestLib;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_Bill_UnBilled_1 {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(Helper.getInput("./LendingResources/json/Billed_Unbilled.json"));
    private final RestAssuredConfig config = RestAssuredConfig.config()
            .httpClient(HttpClientConfig.httpClientConfig()
                    .setParam("http.socket.timeout",5000)
                    .setParam("http.connection.timeout", 5000));
    @BeforeClass
    public void setUp() {//Get Token
        accessToken = LendingTestLib.getToken( "./LendingResources/json/GetToken.json");
    }
//    @Test
//    public void API2401_BillUnbilled_CreditCardBilledStatement_Success() {
//        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
//                .headers(data.getMap("creditcard-billed-statement-period.header"))
//                .body(data.getMap("creditcard-billed-statement-period.body"))
//                .config(config)
//                .when()
//                .get(data.getString("creditcard-billed-statement-period.hostname") + data.getString("creditcard-billed-statement-period.path"))
//                .then().assertThat().statusCode(200).extract().response();
//        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("creditcard-billed-statement-period.expected1.status.code"));
//        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("creditcard-billed-statement-period.expected1.status.message"));
//        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("creditcard-billed-statement-period.expected1.status.service"));
//
//        JSONObject result = new JSONObject();
//        result.put("api-path", data.get("creditcard-billed-statement-period.path"));
//        result.put("header", data.get("creditcard-billed-statement-period.header"));
//        result.put("response", response.jsonPath().get());
//        result.put("accessToken", accessToken);
//        result.put("hostname", data.get("creditcard-billed-statement-period.hostname"));
//        result.put("description", data.get("creditcard-billed-statement-period.description"));
//
//        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
//                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
//        ExtentReport4.printReportMessageJson(result.toJSONString());
//    }
//    @Test
//    public void API2401_BillUnbilled_CreditCardBilledStatement_WithOut_Authorization() {
//        Response response = given().relaxedHTTPSValidation() //.auth().oauth2(accessToken)
//                .headers(data.getMap("creditcard-billed-statement-period.header"))
//                .body(data.getMap("creditcard-billed-statement-period.body"))
//                .config(config)
//                .when()
//                .get(data.getString("creditcard-billed-statement-period.hostname") + data.getString("creditcard-billed-statement-period.path"))
//                .then().assertThat().statusCode(401).extract().response();
//        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("creditcard-billed-statement-period.expected2.status.code"));
//        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("creditcard-billed-statement-period.expected2.status.message"));
//        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("creditcard-billed-statement-period.expected2.status.service"));
//
//        JSONObject result = new JSONObject();
//        result.put("api-path", data.get("creditcard-billed-statement-period.path"));
//        result.put("header", data.get("creditcard-billed-statement-period.header"));
//        result.put("response", response.jsonPath().get());
//        result.put("accessToken", accessToken);
//        result.put("hostname", data.get("creditcard-billed-statement-period.hostname"));
//        result.put("description", data.get("creditcard-billed-statement-period.description"));
//
//        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
//                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
//        ExtentReport4.printReportMessageJson(result.toJSONString());
//    }
//    @Test
//    public void API2401_BillUnbilled_CreditCardUnBilledStatement_Success() {
//        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
//                .headers(data.getMap("creditcard-unbilled-statement-period.header"))
//                .body(data.getMap("creditcard-unbilled-statement-period.body"))
//                .config(config)
//                .when()
//                .get(data.getString("creditcard-unbilled-statement-period.hostname") + data.getString("creditcard-unbilled-statement-period.path"))
//                .then().assertThat().statusCode(200).extract().response();
//        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("creditcard-unbilled-statement-period.expected1.status.code"));
//        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("creditcard-unbilled-statement-period.expected1.status.message"));
//        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("creditcard-unbilled-statement-period.expected1.status.service"));
//
//        JSONObject result = new JSONObject();
//        result.put("api-path", data.get("creditcard-unbilled-statement-period.path"));
//        result.put("header", data.get("creditcard-unbilled-statement-period.header"));
//        result.put("response", response.jsonPath().get());
//        result.put("accessToken", accessToken);
//        result.put("hostname", data.get("creditcard-unbilled-statement-period.hostname"));
//        result.put("description", data.get("creditcard-unbilled-statement-period.description"));
//
//        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
//                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
//        ExtentReport4.printReportMessageJson(result.toJSONString());
//    }
    @Test
    public void API2401_BillUnbilled_CreditCardUnBilledStatement_WithOut_Authorization() {
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .headers(data.getMap("creditcard-unbilled-statement-period.header"))
                .body(data.getMap("creditcard-unbilled-statement-period.body"))
                .config(config)
                .when()
                .get(data.getString("creditcard-unbilled-statement-period.hostname") + data.getString("creditcard-unbilled-statement-period.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("creditcard-unbilled-statement-period.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("creditcard-unbilled-statement-period.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("creditcard-unbilled-statement-period.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("creditcard-unbilled-statement-period.path"));
        result.put("header", data.get("creditcard-unbilled-statement-period.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("creditcard-unbilled-statement-period.hostname"));
        result.put("description", data.get("creditcard-unbilled-statement-period.description"));

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
}
