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

public class API_ProductOriented {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "\\src\\test\\java\\com\\ttbbank\\oneapp\\scenario\\lending\\API\\Lending_API_TestData.json"));

    @Test
    public void API2401_CashForYou_GetEStatement_Successful() {

        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2("accessToken")
                .headers(data.getMap("product-orientation.header"))
                .body(data.getMap("product-orientation.body"))
                .when()
                .post(data.getString("product-orientation.hostname") + data.getString("product-orientation.path"))
                .then().assertThat().statusCode(200).extract().response();


        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("product-orientation.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("product-orientation.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("product-orientation.expected1.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("product-orientation.path"));
        request.put("header", data.get("product-orientation.header"));
        request.put("body", data.get("product-orientation.body"));
        request.put("hostname", data.get("product-orientation.hostname"));
        request.put("description", data.get("product-orientation.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toJSONString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void API2402_CashForYou_GetEStatement_Failed_without_AccountID() {
        Response response = given().relaxedHTTPSValidation()
                //.auth().oauth2(accessToken)
                .headers(data.getMap("product-orientation.header_fail"))
                .body(data.getMap("product-orientation.body"))
                .when()
                .post(data.getString("product-orientation.hostname") + data.getString("product-orientation.path"))
                .then().assertThat().statusCode(400).extract().response();
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("product-orientation.expected2.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("product-orientation.expected2.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("product-orientation.expected2.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("product-orientation.path"));
        request.put("header", data.get("product-orientation.header_fail"));
        request.put("body", data.get("product-orientation.body"));
        request.put("hostname", data.get("product-orientation.hostname"));
        request.put("description", data.get("product-orientation.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

}
