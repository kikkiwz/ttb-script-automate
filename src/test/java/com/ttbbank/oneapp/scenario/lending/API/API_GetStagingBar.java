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

public class API_GetStagingBar {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "\\src\\test\\java\\com\\ttbbank\\oneapp\\scenario\\lending\\API\\Lending_API_TestData.json"));

    @Test
    public void API2401_CashForYou_GetEStatement_Successful() {

        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2("accessToken")
                .headers(data.getMap("get-staging-bar.header"))
                .body(data.getMap("get-staging-bar.body"))
                .when()
                .post(data.getString("get-staging-bar.hostname") + data.getString("get-staging-bar.path"))
                .then().assertThat().statusCode(200).extract().response();


        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-staging-bar.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-staging-bar.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-staging-bar.expected1.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("get-staging-bar.path"));
        request.put("header", data.get("get-staging-bar.header"));
        request.put("body", data.get("get-staging-bar.body"));
        request.put("hostname", data.get("get-staging-bar.hostname"));
        request.put("description", data.get("get-staging-bar.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toJSONString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

/*    @Test
    public void API2401_CashForYou_GetEStatement_Failed() {

        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2("accessToken")
                .headers(data.getMap("get-staging-bar.header"))
                .body(data.getMap("get-staging-bar.body"))
                .when()
                .post(data.getString("get-staging-bar.hostname") + data.getString("get-staging-bar.path"))
                .then().assertThat().statusCode(200).extract().response();


        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-staging-bar.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-staging-bar.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-staging-bar.expected1.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("get-staging-bar.path"));
        request.put("header", data.get("get-staging-bar.header"));
        request.put("body", data.get("get-staging-bar.body"));
        request.put("hostname", data.get("get-staging-bar.hostname"));
        request.put("description", data.get("get-staging-bar.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toJSONString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }*/
}
