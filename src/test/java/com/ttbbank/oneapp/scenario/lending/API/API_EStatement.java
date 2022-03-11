package com.ttbbank.oneapp.scenario.lending.API;

import com.tmb.automation.helper.ExtentReport4;
import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_EStatement {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "\\src\\test\\java\\com\\ttbbank\\oneapp\\scenario\\lending\\API\\Lending_API_TestData.json"));

    @Test
    public void API2401_CashForYou_GetEStatement_Successful() {
        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2("accessToken")
                .headers(data.getMap("get-e-statement.header"))
//                .config(config)
                .when()
                .post(data.getString("get-e-statement.hostname") + data.getString("get-e-statement.path"))
                .then().assertThat().statusCode(200).extract().response();

        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-e-statement.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-e-statement.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-e-statement.expected1.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("get-e-statement.path"));
        request.put("header", data.get("get-e-statement.header"));
        request.put("body", data.get("get-e-statement.body"));
//        request.put("accessToken", accessToken);
        request.put("hostname", data.get("get-e-statement.hostname"));
        request.put("description", data.get("get-e-statement.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toJSONString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2402_CashForYou_GetEStatement_Failed() {
        Response response = given().relaxedHTTPSValidation()
                //.auth().oauth2(accessToken)
                .headers(data.getMap("get-e-statement.header_fail"))
//                .config(config)
                .when()
                .post(data.getString("get-e-statement.hostname") + data.getString("get-e-statement.path"))
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-e-statement.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-e-statement.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-e-statement.expected2.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("get-e-statement.path"));
        request.put("header", data.get("get-e-statement.header_fail"));
        request.put("body", data.get("get-e-statement.body"));
//        request.put("accessToken", accessToken);
        request.put("hostname", data.get("get-e-statement.hostname"));
        request.put("description", data.get("get-e-statement.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2403_CashForYou_FetchCardDetails_successful(){
        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2(accessToken)
                .headers(data.getMap("fetch-card-details.header"))
                .body(data.getMap("fetch-card-details.body"))
//                .config(config)
                .when()
                .post(data.getString("fetch-card-details.hostname") + data.getString("fetch-card-details.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-card-details.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-card-details.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-card-details.expected1.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("fetch-card-details.path"));
        request.put("header", data.get("fetch-card-details.header"));
        request.put("body", data.get("fetch-card-details.body"));
//        request.put("accessToken", accessToken);
        request.put("hostname", data.get("fetch-card-details.hostname"));
        request.put("description", data.get("fetch-card-details.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2404_CashForYou_FetchCardDetails_Failed(){
        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2(accessToken)
                .headers(data.getMap("fetch-card-details.header_fail"))
                .body(data.getMap("fetch-card-details.body"))
//                .config(config)
                .when()
                .post(data.getString("fetch-card-details.hostname") + data.getString("fetch-card-details.path"))
                .then().assertThat().statusCode(400).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("fetch-card-details.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("fetch-card-details.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("fetch-card-details.expected2.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("fetch-card-details.path"));
        request.put("header", data.get("fetch-card-details.header_fail"));
        request.put("body", data.get("fetch-card-details.body"));
//        request.put("accessToken", accessToken);
        request.put("hostname", data.get("fetch-card-details.hostname"));
        request.put("description", data.get("fetch-card-details.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    //==
    @Test
    public void API2403_CashForYou_UpdateEStatement_successful(){
        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2(accessToken)
                .headers(data.getMap("update-e-statement.header"))
                .body(data.getMap("update-e-statement.body"))
//                .config(config)
                .when()
                .post(data.getString("update-e-statement.hostname") + data.getString("update-e-statement.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("update-e-statement.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("update-e-statement.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("update-e-statement.expected1.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("update-e-statement.path"));
        request.put("header", data.get("update-e-statement.header"));
        request.put("body", data.get("update-e-statement.body"));
//        request.put("accessToken", accessToken);
        request.put("hostname", data.get("update-e-statement.hostname"));
        request.put("description", data.get("update-e-statement.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
    @Test
    public void API2403_CashForYou_UpdateEStatement_Failed(){
        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2(accessToken)
                .headers(data.getMap("update-e-statement.header_fail"))
                .body(data.getMap("update-e-statement.body"))
//                .config(config)
                .when()
                .post(data.getString("update-e-statement.hostname") + data.getString("update-e-statement.path"))
                .then().assertThat().statusCode(200).extract().response();
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("update-e-statement.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("update-e-statement.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("update-e-statement.expected2.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("update-e-statement.path"));
        request.put("header", data.get("update-e-statement.header_fail"));
        request.put("body", data.get("update-e-statement.body"));
//        request.put("accessToken", accessToken);
        request.put("hostname", data.get("update-e-statement.hostname"));
        request.put("description", data.get("update-e-statement.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }
}
