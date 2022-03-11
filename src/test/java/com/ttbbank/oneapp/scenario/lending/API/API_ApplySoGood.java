package com.ttbbank.oneapp.scenario.lending.API;

import com.ttbbank.oneapp.scenario.lending.iosUtil.ExReport;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_ApplySoGood {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "\\src\\test\\java\\com\\ttbbank\\oneapp\\scenario\\lending\\API\\Lending_API_TestData.json"));
    private final RestAssuredConfig config = RestAssuredConfig.config()
            .httpClient(HttpClientConfig.httpClientConfig()
                    .setParam("http.socket.timeout",5000)
                    .setParam("http.connection.timeout", 5000));
    @BeforeClass
    public void setUp() {//Get Token
        accessToken = Lib.getToken(data);
        System.out.println("accessToken:"+accessToken);
    }
    @Test
    public void API2401_ApplySoGood_FetchInstallmentPlan_Success() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("fetch-installment-plan.header"))
                .config(config)
                .when()
                .get(data.getString("fetch-installment-plan.hostname") + data.getString("fetch-installment-plan.path"))
//                .then().assertThat().statusCode(200).extract().response();
                .then().extract().response();
//        System.out.println("aaa="+response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());
//        ExReport.printReportMessage("aaa="+response.jsonPath().prettify());
        ExReport.printReportMessageJson(response.jsonPath().prettify());
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-installment-plan.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-installment-plan.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-installment-plan.expected1.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("fetch-installment-plan.path"));
        request.put("header", data.get("fetch-installment-plan.header"));
        request.put("accessToken", accessToken);
        request.put("hostname", data.get("fetch-installment-plan.hostname"));
        request.put("description", data.get("fetch-installment-plan.description"));

        JSONObject result = new JSONObject();
//        result.put("api-path", data.get("fetch-installment-plan.path"));
//        result.put("header", data.get("fetch-installment-plan.header"));
        result.put("response", response.jsonPath().get());
//        result.put("accessToken", accessToken);
//        result.put("hostname", data.get("fetch-installment-plan.hostname"));
//        result.put("description", data.get("fetch-installment-plan.description"));
        result.put("request", request);

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
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

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
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

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
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

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
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

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
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

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
}
