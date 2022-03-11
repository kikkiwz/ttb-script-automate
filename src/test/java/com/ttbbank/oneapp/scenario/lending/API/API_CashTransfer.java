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

public class API_CashTransfer {
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
    public void API2411_CashTransferConfirm_Successful() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-confirm.header"))
                .body(data.getMap("cash-transfer-confirm.body"))
                .config(config)
                .when()
                .get(data.getString("cash-transfer-confirm.hostname") + data.getString(" cash-transfer-confirm.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-confirm.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-confirm.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-confirm.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("cash-transfer-confirm.path"));
        result.put("header", data.get("cash-transfer-confirm.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("cash-transfer-confirm.hostname"));
        result.put("description", data.get("cash-transfer-confirm.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toJSONString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2412_CashForYou_CashTransferConfirm_withOut_Authorization() {
        Response response = given().relaxedHTTPSValidation() //.auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-confirm.header"))
                .body(data.getMap("cash-transfer-confirm.body"))
                .config(config)
                .when()
                .get(data.getString("cash-transfer-confirm.hostname") + data.getString(" cash-transfer-confirm.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-confirm.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-confirm.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-confirm.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("cash-transfer-confirm.path"));
        result.put("header", data.get("cash-transfer-confirm.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("cash-transfer-confirm.hostname"));
        result.put("description", data.get("cash-transfer-confirm.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toJSONString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2413_CashTransferReview_CA_successful(){
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-review-ca.header"))
                .body(data.getMap("cash-transfer-review-ca.body"))
                .config(config)
                .when()
                .post(data.getString("cash-transfer-review-ca.hostname") + data.getString("cash-transfer-review-ca.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-review-ca.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-review-ca.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-review-ca.expected1.status.service"));
        JSONObject result = new JSONObject();
        result.put("response1", response.jsonPath().get());
        String requestBody1 = "{ \"reference\":\""+response.jsonPath().getString("data.reference")+"\"}";

        Response response2 = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-confirm.header"))
                .body(requestBody1)
                .config(config)
                .when()
                .post(data.getString("cash-transfer-confirm.hostname") + data.getString("cash-transfer-confirm.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-confirm.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-confirm.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-confirm.expected1.status.service"));



        result.put("api-path", data.get("cash-transfer-confirm.path"));
        result.put("header", data.get("cash-transfer-confirm.header"));
        result.put("body", data.getMap("cash-transfer-confirm.body"));
        result.put("response2", response2.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("cash-transfer-confirm.hostname"));
        result.put("description", data.get("cash-transfer-confirm.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2413_CashTransferReview_CT_successful(){
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-review-ct.header"))
                .body(data.getMap("cash-transfer-review-ct.body"))
                .config(config)
                .when()
                .post(data.getString("cash-transfer-review-ct.hostname") + data.getString("cash-transfer-review-ct.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-review-ct.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-review-ct.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-review-ct.expected1.status.service"));
        JSONObject result = new JSONObject();
        result.put("response1", response.jsonPath().get());
        String requestBody1 = "{ \"reference\":\""+response.jsonPath().getString("data.reference")+"\"}";

        Response response2 = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-confirm.header"))
                .body(requestBody1)
                .config(config)
                .when()
                .post(data.getString("cash-transfer-confirm.hostname") + data.getString("cash-transfer-confirm.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-confirm.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-confirm.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-confirm.expected1.status.service"));



        result.put("api-path", data.get("cash-transfer-confirm.path"));
        result.put("header", data.get("cash-transfer-confirm.header"));
        result.put("body", data.getMap("cash-transfer-confirm.body"));
        result.put("response2", response2.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("cash-transfer-confirm.hostname"));
        result.put("description", data.get("cash-transfer-confirm.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2413_CashTransferReview_CC_successful(){
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-review-cc.header"))
                .body(data.getMap("cash-transfer-review-cc.body"))
                .config(config)
                .when()
                .post(data.getString("cash-transfer-review-cc.hostname") + data.getString("cash-transfer-review-cc.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-review-cc.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-review-cc.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-review-cc.expected1.status.service"));
        JSONObject result = new JSONObject();
        result.put("response1", response.jsonPath().get());
        String requestBody1 = "{ \"reference\":\""+response.jsonPath().getString("data.reference")+"\"}";

        Response response2 = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-confirm.header"))
                .body(requestBody1)
                .config(config)
                .when()
                .post(data.getString("cash-transfer-confirm.hostname") + data.getString("cash-transfer-confirm.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-confirm.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-confirm.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-confirm.expected1.status.service"));



        result.put("api-path", data.get("cash-transfer-confirm.path"));
        result.put("header", data.get("cash-transfer-confirm.header"));
        result.put("body", data.getMap("cash-transfer-confirm.body"));
        result.put("response2", response2.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("cash-transfer-confirm.hostname"));
        result.put("description", data.get("cash-transfer-confirm.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2414_CashTransferReview_CA_without_Authorization(){
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-review-ca.header"))
                .body(data.getMap("cash-transfer-review-ca.body"))
                .config(config)
                .when()
                .post(data.getString("cash-transfer-review-ca.hostname") + data.getString("cash-transfer-review-ca.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-review-ca.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-review-ca.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-review-ca.expected2.status.service"));
        JSONObject result = new JSONObject();
        result.put("api-path", data.get("cash-transfer-review-ca.path"));
        result.put("header", data.get("cash-transfer-review-ca.header"));
        result.put("body", data.getMap("cash-transfer-review-ca.body"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("cash-transfer-review-ca.hostname"));
        result.put("description", data.get("cash-transfer-review-ca.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2415_CashTransferReview_CT_without_Authorization(){
        Response response = given().relaxedHTTPSValidation() //.auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-review-ct.header"))
                .body(data.getMap("cash-transfer-review-ct.body"))
                .config(config)
                .when()
                .post(data.getString("cash-transfer-review-ct.hostname") + data.getString("cash-transfer-review-ct.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-review-ct.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-review-ct.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-review-ct.expected2.status.service"));
        JSONObject result = new JSONObject();
        result.put("api-path", data.get("cash-transfer-review-ct.path"));
        result.put("header", data.get("cash-transfer-review-ct.header"));
        result.put("body", data.getMap("cash-transfer-review-ct.body"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("cash-transfer-review-ct.hostname"));
        result.put("description", data.get("cash-transfer-review-ct.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2416_CashTransferReview_CC_without_Authorization(){
        Response response = given().relaxedHTTPSValidation() //.auth().oauth2(accessToken)
                .headers(data.getMap("cash-transfer-review-cc.header"))
                .body(data.getMap("cash-transfer-review-cc.body"))
                .config(config)
                .when()
                .post(data.getString("cash-transfer-review-cc.hostname") + data.getString("cash-transfer-review-cc.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("cash-transfer-review-cc.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("cash-transfer-review-cc.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("cash-transfer-review-cc.expected2.status.service"));
        JSONObject result = new JSONObject();
        result.put("api-path", data.get("cash-transfer-review-cc.path"));
        result.put("header", data.get("cash-transfer-review-cc.header"));
        result.put("body", data.getMap("cash-transfer-review-cc.body"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("cash-transfer-review-cc.hostname"));
        result.put("description", data.get("cash-transfer-review-cc.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
}
