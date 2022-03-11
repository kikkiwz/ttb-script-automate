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

public class API_CaptureInstallmentPlan {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "\\src\\test\\java\\com\\ttbbank\\oneapp\\scenario\\lending\\API\\Lending_API_TestData.json"));

    @Test
    public void API2401_CashForYou_GetEStatement_Successful() {

        Response response = given().relaxedHTTPSValidation()
//                .auth().oauth2("accessToken")
                .headers(data.getMap("capture-installment-plan.header"))
                .body(data.getMap("capture-installment-plan.body"))
                .when()
                .post(data.getString("capture-installment-plan.hostname") + data.getString("capture-installment-plan.path"))
                .then().assertThat().statusCode(200).extract().response();


        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("capture-installment-plan.expected1.status.code"));
        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("capture-installment-plan.expected1.status.message"));
        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("capture-installment-plan.expected1.status.service"));

        JSONObject request = new JSONObject();
        request.put("api-path", data.get("capture-installment-plan.path"));
        request.put("header", data.get("capture-installment-plan.header"));
        request.put("body", data.get("capture-installment-plan.body"));
        request.put("hostname", data.get("capture-installment-plan.hostname"));
        request.put("description", data.get("capture-installment-plan.description"));
        JSONObject result = new JSONObject();
        result.put("request", request);
        result.put("response", response.jsonPath().get());

        Helper.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toJSONString());
        ExtentReport4.printReportMessageJson(result.toJSONString());
    }

}
