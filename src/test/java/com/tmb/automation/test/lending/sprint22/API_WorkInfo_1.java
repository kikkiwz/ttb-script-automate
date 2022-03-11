package com.tmb.automation.test.lending.sprint22;

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

public class API_WorkInfo_1 {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(Helper.getInput("./LendingResources/json/WorkInfo.json"));
    private final RestAssuredConfig config = RestAssuredConfig.config()
            .httpClient(HttpClientConfig.httpClientConfig()
                    .setParam("http.socket.timeout",5000)
                    .setParam("http.connection.timeout", 5000));
    @BeforeClass
    public void setUp() {//Get Token
        accessToken = LendingTestLib.getToken( "./LendingResources/json/GetToken.json");
    }

    @Test
    public void TestAPI1() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("businesstype.hostname") + data.getString("businesstype.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("businesstype.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("businesstype.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("businesstype.expected1.status.service"));
        Assert.assertEquals(response.jsonPath().getString("data.entryID[0]"), data.get("businesstype.expected1.data.entryID[0]"));
        Assert.assertEquals(response.jsonPath().getString("data.entryName[0]"), data.get("businesstype.expected1.data.entryName[0]"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("businesstype.description"));
        result.put("hostname", data.get("businesstype.hostname"));
        result.put("api-path", data.get("businesstype.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("businesstype.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI1_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .config(config)
                .when()
                .get(data.getString("businesstype.hostname") + data.getString("businesstype.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("businesstype.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("businesstype.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("businesstype.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("businesstype.description"));
        result.put("hostname", data.get("businesstype.hostname"));
        result.put("api-path", data.get("businesstype.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("businesstype.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI2() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("entrycode.hostname").toString() + data.getString("entrycode.path").toString())
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("entrycode.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("entrycode.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("entrycode.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("entrycode.description"));
        result.put("hostname", data.get("entrycode.hostname"));
        result.put("api-path", data.get("entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test(enabled = true)
    public void TestAPI2_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .config(config)
                .when()
                .get(data.getString("entrycode.hostname") + data.getString("entrycode.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("entrycode.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("entrycode.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("entrycode.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("entrycode.description"));
        result.put("hostname", data.get("entrycode.hostname"));
        result.put("api-path", data.get("entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI3() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("country.hostname") + data.getString("country.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("country.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("country.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("country.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("country.description"));
        result.put("hostname", data.get("country.hostname"));
        result.put("api-path", data.get("country.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("country.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI3_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .config(config)
                .when()
                .get(data.getString("country.hostname") + data.getString("country.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("country.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("country.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("country.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("country.description"));
        result.put("hostname", data.get("country.hostname"));
        result.put("api-path", data.get("country.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("country.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI4() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("income.hostname") + data.getString("income.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("income.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("income.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("income.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("income.description"));
        result.put("hostname", data.get("income.hostname"));
        result.put("api-path", data.get("income.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("income.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI4_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .config(config)
                .when()
                .get(data.getString("income.hostname") + data.getString("income.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("income.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("income.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("income.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("income.description"));
        result.put("hostname", data.get("income.hostname"));
        result.put("api-path", data.get("income.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("income.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI5() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("status.hostname") + data.getString("status.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("status.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("status.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("status.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("status.description"));
        result.put("hostname", data.get("status.hostname"));
        result.put("api-path", data.get("status.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("status.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI5_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .config(config)
                .when()
                .get(data.getString("status.hostname") + data.getString("status.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("status.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("status.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("status.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("status.description"));
        result.put("hostname", data.get("status.hostname"));
        result.put("api-path", data.get("status.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("status.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI6() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("status_entrycode.hostname") + data.getString("status_entrycode.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("status_entrycode.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("status_entrycode.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("status_entrycode.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("status_entrycode.description"));
        result.put("hostname", data.get("status_entrycode.hostname"));
        result.put("api-path", data.get("status_entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("status_entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI6_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .config(config)
                .when()
                .get(data.getString("status_entrycode.hostname") + data.getString("status_entrycode.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("status_entrycode.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("status_entrycode.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("status_entrycode.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("status_entrycode.description"));
        result.put("hostname", data.get("status_entrycode.hostname"));
        result.put("api-path", data.get("status_entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("status_entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI7() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("fetch-working-info_countryincome.hostname") + data.getString("fetch-working-info_countryincome.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-working-info_countryincome.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-working-info_countryincome.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-working-info_countryincome.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-working-info_countryincome.description"));
        result.put("hostname", data.get("fetch-working-info_countryincome.hostname"));
        result.put("api-path", data.get("fetch-working-info_countryincome.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-working-info_countryincome.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI7_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .config(config)
                .when()
                .get(data.getString("fetch-working-info_countryincome.hostname") + data.getString("fetch-working-info_countryincome.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-working-info_countryincome.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-working-info_countryincome.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-working-info_countryincome.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-working-info_countryincome.description"));
        result.put("hostname", data.get("fetch-working-info_countryincome.hostname"));
        result.put("api-path", data.get("fetch-working-info_countryincome.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-working-info_countryincome.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI8() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("fetch-business-type.hostname") + data.getString("fetch-business-type.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-business-type.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-business-type.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-business-type.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-business-type.description"));
        result.put("hostname", data.get("fetch-business-type.hostname"));
        result.put("api-path", data.get("fetch-business-type.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-business-type.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI8_without_Token() {
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("fetch-business-type.hostname") + data.getString("fetch-business-type.path"))
                .then().assertThat().statusCode(401)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-business-type.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-business-type.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-business-type.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-business-type.description"));
        result.put("hostname", data.get("fetch-business-type.hostname"));
        result.put("api-path", data.get("fetch-business-type.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-business-type.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI9() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("fetch-business-type_entrycode.hostname") + data.getString("fetch-business-type_entrycode.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-business-type_entrycode.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-business-type_entrycode.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-business-type_entrycode.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-business-type_entrycode.description"));
        result.put("hostname", data.get("fetch-business-type_entrycode.hostname"));
        result.put("api-path", data.get("fetch-business-type_entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-business-type_entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI9_without_Token() {
        Response response = given().relaxedHTTPSValidation()//.auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("fetch-business-type_entrycode.hostname") + data.getString("fetch-business-type_entrycode.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-business-type_entrycode.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-business-type_entrycode.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-business-type_entrycode.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-business-type_entrycode.description"));
        result.put("hostname", data.get("fetch-business-type_entrycode.hostname"));
        result.put("api-path", data.get("fetch-business-type_entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-business-type_entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI10() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("fetch-working-income_entrycode.header"))
                .config(config)
                .when()
                .get(data.getString("fetch-working-income_entrycode.hostname") + data.getString("fetch-working-income_entrycode.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-business-type_entrycode.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-business-type_entrycode.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-business-type_entrycode.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-business-type_entrycode.description"));
        result.put("hostname", data.get("fetch-business-type_entrycode.hostname"));
        result.put("api-path", data.get("fetch-business-type_entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-business-type_entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI10_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .headers(data.getMap("fetch-working-income_entrycode.header"))
//                .auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("fetch-working-income_entrycode.hostname") + data.getString("fetch-working-income_entrycode.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-business-type_entrycode.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-business-type_entrycode.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-business-type_entrycode.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-business-type_entrycode.description"));
        result.put("hostname", data.get("fetch-business-type_entrycode.hostname"));
        result.put("api-path", data.get("fetch-business-type_entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-business-type_entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI11() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("fetch-working-info.header"))
                .config(config)
                .when()
                .post(data.getString("fetch-working-info.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-working-info.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-working-info.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-working-info.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-working-info.description"));
        result.put("hostname", data.get("fetch-working-info.hostname"));
        result.put("api-path", data.get("fetch-working-info.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-working-info.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI11_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .headers(data.getMap("fetch-working-info.header"))
                .config(config)
                .when()
                .post(data.getString("fetch-working-info.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-working-info.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-working-info.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-working-info.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-working-info.description"));
        result.put("hostname", data.get("fetch-working-info.hostname"));
        result.put("api-path", data.get("fetch-working-info.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-working-info.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI12() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("fetch-working-info.header"))
                .config(config)
                .when()
                .get(data.getString("fetch-working-status.hostname") + data.getString("fetch-working-status.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-working-status.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-working-status.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-working-status.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-working-status.description"));
        result.put("hostname", data.get("fetch-working-status.hostname"));
        result.put("api-path", data.get("fetch-working-status.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-working-status.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI12_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .headers(data.getMap("fetch-working-info.header"))
//                .auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("fetch-working-status.hostname") + data.getString("fetch-working-status.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-working-status.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-working-status.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-working-status.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-working-status.description"));
        result.put("hostname", data.get("fetch-working-status.hostname"));
        result.put("api-path", data.get("fetch-working-status.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-working-status.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI13() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("fetch-working-info.header"))
                .config(config)
                .when()
                .get(data.getString("fetch-working-status_entrycode.hostname") + data.getString("fetch-working-status_entrycode.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-working-status_entrycode.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-working-status_entrycode.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-working-status_entrycode.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-working-status_entrycode.description"));
        result.put("hostname", data.get("fetch-working-status_entrycode.hostname"));
        result.put("api-path", data.get("fetch-working-status_entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-working-status_entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI13_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .headers(data.getMap("fetch-working-info.header"))//.auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("fetch-working-status_entrycode.hostname")+ data.getString("fetch-working-status_entrycode.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-working-status_entrycode.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-working-status_entrycode.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-working-status_entrycode.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("fetch-working-status_entrycode.description"));
        result.put("hostname", data.get("fetch-working-status_entrycode.hostname"));
        result.put("api-path", data.get("fetch-working-status_entrycode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("fetch-working-status_entrycode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI14() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("fetch-working-info.header"))
                .config(config)
                .when()
                .get(data.getString("zipcode.hostname") + data.getString("zipcode.path"))
                .then().assertThat().statusCode(200)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("zipcode.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("zipcode.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("zipcode.expected1.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("zipcode.description"));
        result.put("hostname", data.get("zipcode.hostname"));
        result.put("api-path", data.get("zipcode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("zipcode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TestAPI14_without_Token() {
        Response response = given().relaxedHTTPSValidation()
                .headers(data.getMap("fetch-working-info.header"))//.auth().oauth2(accessToken)
                .config(config)
                .when()
                .get(data.getString("zipcode.hostname") + data.getString("zipcode.path"))
                .then().assertThat().statusCode(401)
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("zipcode.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("zipcode.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("zipcode.expected2.status.service"));

        JSONObject result = new JSONObject();
        result.put("description", data.get("zipcode.description"));
        result.put("hostname", data.get("zipcode.hostname"));
        result.put("api-path", data.get("zipcode.path"));
        result.put("accessToken", accessToken);
        result.put("header", data.get("zipcode.header"));
        result.put("body", "");
        result.put("response", response.jsonPath().get());
        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
}
