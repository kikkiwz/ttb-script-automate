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

public class API_ApplySoGood_1 {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(Helper.getInput("./LendingResources/json/ApplySoGood.json"));
    private final RestAssuredConfig config = RestAssuredConfig.config()
            .httpClient(HttpClientConfig.httpClientConfig()
                    .setParam("http.socket.timeout",5000)
                    .setParam("http.connection.timeout", 5000));
    @BeforeClass
    public void setUp() {//Get Token
        accessToken = LendingTestLib.getToken( "./LendingResources/json/GetToken.json");
    }
    @Test
    public void API2401_ApplySoGood_FetchInstallmentPlan_Success() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("fetch-installment-plan.header"))
                .config(config)
                .when()
                .get(data.getString("fetch-installment-plan.hostname") + data.getString("fetch-installment-plan.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-installment-plan.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-installment-plan.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-installment-plan.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("fetch-installment-plan.path"));
        result.put("header", data.get("fetch-installment-plan.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("fetch-installment-plan.hostname"));
        result.put("description", data.get("fetch-installment-plan.description"));

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2401_ApplySoGood_FetchInstallmentPlan_WithOut_Authorization() {
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .headers(data.getMap("fetch-installment-plan.header"))
                .config(config)
                .when()
                .get(data.getString("fetch-installment-plan.hostname") + data.getString("fetch-installment-plan.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-installment-plan.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-installment-plan.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-installment-plan.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("fetch-installment-plan.path"));
        result.put("header", data.get("fetch-installment-plan.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("fetch-installment-plan.hostname"));
        result.put("description", data.get("fetch-installment-plan.description"));

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2401_ApplySoGood_GetCampaignTransactions_Success() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("get-campaign-transactions.header"))
                .body(data.getMap("get-campaign-transactions.body"))
                .config(config)
                .when()
                .post(data.getString("get-campaign-transactions.hostname") + data.getString("get-campaign-transactions.path"))
                .then()
                .assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-campaign-transactions.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-campaign-transactions.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-campaign-transactions.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-campaign-transactions.path"));
        result.put("header", data.get("get-campaign-transactions.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-campaign-transactions.hostname"));
        result.put("description", data.get("get-campaign-transactions.description"));

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2401_ApplySoGood_GetCampaignTransactions_WithOut_Authorization() {
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .headers(data.getMap("get-campaign-transactions.header"))
                .body(data.getMap("get-campaign-transactions.body"))
                .config(config)
                .when()
                .post(data.getString("get-campaign-transactions.hostname") + data.getString("get-campaign-transactions.path"))
                .then()
                .assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-campaign-transactions.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-campaign-transactions.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-campaign-transactions.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-campaign-transactions.path"));
        result.put("header", data.get("get-campaign-transactions.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-campaign-transactions.hostname"));
        result.put("description", data.get("get-campaign-transactions.description"));

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2401_ApplySoGood_CardInstallmentConfirm_Success() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("card-installment-confirm.header"))
                .body(data.getMap("card-installment-confirm.body"))
                .config(config)
                .when()
                .post(data.getString("card-installment-confirm.hostname") + data.getString("card-installment-confirm.path"))
                .then()
                .assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("card-installment-confirm.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("card-installment-confirm.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("card-installment-confirm.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("card-installment-confirm.path"));
        result.put("header", data.get("card-installment-confirm.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("card-installment-confirm.hostname"));
        result.put("description", data.get("card-installment-confirm.description"));

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2401_ApplySoGood_CardInstallmentConfirm_WithOut_Authorization() {
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .headers(data.getMap("card-installment-confirm.header"))
                .body(data.getMap("card-installment-confirm.body"))
                .config(config)
                .when()
                .post(data.getString("card-installment-confirm.hostname") + data.getString("card-installment-confirm.path"))
                .then()
                .assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("card-installment-confirm.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("card-installment-confirm.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("card-installment-confirm.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("card-installment-confirm.path"));
        result.put("header", data.get("card-installment-confirm.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("card-installment-confirm.hostname"));
        result.put("description", data.get("card-installment-confirm.description"));

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
}
