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

public class API_CashForYou {
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
    public void API2401_CashForYou_GetAccountSaving_Successful() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("saving.header"))
                .config(config)
                .when()
                .get(data.getString("saving.hostname") + data.getString("saving.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("saving.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("saving.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("saving.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("saving.path"));
        result.put("header", data.get("saving.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("saving.hostname"));
        result.put("description", data.get("saving.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toJSONString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2402_CashForYou_GetAccountSaving_withOut_Authorization() {
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .headers(data.getMap("saving.header"))
                .config(config)
                .when()
                .get(data.getString("saving.hostname") + data.getString("saving.path")).then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("saving.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("saving.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("saving.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("saving.path"));
        result.put("header", data.get("saving.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("saving.hostname"));
        result.put("description", data.get("saving.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2403_CashForYou_GetEligibleLead_successful(){
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("get-eligible-lead.header"))
                .body(data.getMap("get-eligible-lead.body"))
                .config(config)
                .when()
                .post(data.getString("get-eligible-lead.hostname") + data.getString("get-eligible-lead.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-eligible-lead.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-eligible-lead.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-eligible-lead.expected1.status.service"));
        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-eligible-lead.path"));
        result.put("header", data.get("get-eligible-lead.header"));
        result.put("body", data.getMap("get-eligible-lead.body"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-eligible-lead.hostname"));
        result.put("description", data.get("get-eligible-lead.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2404_CashForYou_GetEligibleLead_without_Authorization(){
        Response response = given().relaxedHTTPSValidation() //.auth().oauth2(accessToken)
                .headers(data.getMap("get-eligible-lead.header"))
                .body(data.getMap("get-eligible-lead.body"))
                .config(config)
                .when()
                .post(data.getString("get-eligible-lead.hostname") + data.getString("get-eligible-lead.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-eligible-lead.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-eligible-lead.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-eligible-lead.expected2.status.service"));
        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-eligible-lead.path"));
        result.put("header", data.get("get-eligible-lead.header"));
        result.put("body", data.getMap("get-eligible-lead.body"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-eligible-lead.hostname"));
        result.put("description", data.get("get-eligible-lead.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2405_CashForYou_GetAccountInstallment_successful(){
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("get-installment-rate.header"))
                .body(data.getMap("get-installment-rate.body"))
                .config(config)
                .when()
                .post(data.getString("get-installment-rate.hostname") + data.getString("get-installment-rate.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-installment-rate.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-installment-rate.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-installment-rate.expected1.status.service"));
        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-installment-rate.path"));
        result.put("header", data.get("get-installment-rate.header"));
        result.put("body", data.getMap("get-installment-rate.body"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-installment-rate.hostname"));
        result.put("description", data.get("get-installment-rate.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2406_CashForYou_GetAccountInstallment_without_Authorization(){
        Response response = given().relaxedHTTPSValidation() //.auth().oauth2(accessToken)
                .headers(data.getMap("get-eligible-lead.header"))
                .body(data.getMap("get-eligible-lead.body"))
                .config(config)
                .when()
                .post(data.getString("get-eligible-lead.hostname") + data.getString("get-eligible-lead.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-eligible-lead.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-eligible-lead.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-eligible-lead.expected2.status.service"));
        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-eligible-lead.path"));
        result.put("header", data.get("get-eligible-lead.header"));
        result.put("body", data.getMap("get-installment-rate.body"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-eligible-lead.hostname"));
        result.put("description", data.get("get-eligible-lead.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
}
