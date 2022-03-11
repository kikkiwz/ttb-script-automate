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

public class API_Loan {
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
    public void API2401_GetLoanStatement_Success() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("get-loan-statement.header"))
                .body(data.getMap("get-loan-statement.body"))
                .config(config)
                .when()
                .get(data.getString("get-loan-statement.hostname") + data.getString("get-loan-statement.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-loan-statement.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-loan-statement.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-loan-statement.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-loan-statement.path"));
        result.put("header", data.get("get-loan-statement.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-loan-statement.hostname"));
        result.put("description", data.get("get-loan-statement.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2401_GetLoanStatement_WithOut_Authorization() {
        Response response = given().relaxedHTTPSValidation() //.auth().oauth2(accessToken)
                .headers(data.getMap("get-loan-statement.header"))
                .body(data.getMap("get-loan-statement.body"))
                .config(config)
                .when()
                .get(data.getString("get-loan-statement.hostname") + data.getString("get-loan-statement.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-loan-statement.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-loan-statement.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-loan-statement.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-loan-statement.path"));
        result.put("header", data.get("get-loan-statement.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-loan-statement.hostname"));
        result.put("description", data.get("get-loan-statement.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2401_GetAccountDetail_Success() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("get-account-detail.header"))
                .body(data.getMap("get-account-detail.body"))
                .config(config)
                .when()
                .get(data.getString("get-account-detail.hostname") + data.getString("get-account-detail.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-account-detail.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-account-detail.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-account-detail.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-account-detail.path"));
        result.put("header", data.get("get-account-detail.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-account-detail.hostname"));
        result.put("description", data.get("get-account-detail.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2401_GetAccountDetail_WithOut_Authorization() {
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .headers(data.getMap("get-account-detail.header"))
                .body(data.getMap("get-account-detail.body"))
                .config(config)
                .when()
                .get(data.getString("get-account-detail.hostname") + data.getString("get-account-detail.path"))
                .then().assertThat().statusCode(401).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-account-detail.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-account-detail.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-account-detail.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("api-path", data.get("get-account-detail.path"));
        result.put("header", data.get("get-account-detail.header"));
        result.put("response", response.jsonPath().get());
        result.put("accessToken", accessToken);
        result.put("hostname", data.get("get-account-detail.hostname"));
        result.put("description", data.get("get-account-detail.description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }
}
