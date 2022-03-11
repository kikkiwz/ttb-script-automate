package com.tmb.automation.api.investment;

import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.AIPOrderModel;
import com.tmb.automation.api.investment.model.LoginModel;
import com.tmb.automation.api.investment.model.LoginSuccessApiModel;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;

public class LoginSuccessTest extends Base {
    String apiPath = "/apis/auth/token";

    @Parameters({"testCaseId"})
    @Test(priority = 1)
    void LoginTestSuccess(String testCaseId) throws ParseException, IOException, InterruptedException, DocumentException {

        System.err.println(testCaseId);

        LoginModel loginModel = new Gson().fromJson(String.valueOf(GetJsonData.getLogin().get(testCaseId)), LoginModel.class);
        RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
        parentReport = extent.createTest(loginModel.ScenarioName, loginModel.Description);
        childReport = parentReport.createNode(loginModel.Description);


        childReport.log(Status.INFO, "Username: <pre> " + TextColor.blueColor(loginModel.TestData.body.username) + "</pre>");
        childReport.log(Status.INFO, "Password: <pre> " + TextColor.blueColor(loginModel.TestData.body.password) + "</pre>");

        httpRequest.header("X-Correlation-ID", UUID.randomUUID());

        httpRequest.multiPart("username", loginModel.TestData.body.username);
        httpRequest.multiPart("password", loginModel.TestData.body.password);
        httpRequest.multiPart("grant_type", loginModel.TestData.body.grant_type);
        httpRequest.multiPart("scope", loginModel.TestData.body.scope);
        httpRequest.auth().preemptive().basic(Setting.APP_KEY_NAME_DEV, Setting.APP_KEY_VALUE_DEV);

        responseBody = httpRequest.request(Method.POST, Setting.BASE_URL_API + apiPath);

        LoginSuccessApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), LoginSuccessApiModel.class);

        Boolean isOk = responseBody.getStatusCode() == 200;
        childReport.log(Status.PASS, "Response data: <pre> " + TextColor.resultColor(isOk, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");
        Setting.TOKEN = responseModel.data.access_token;
        Assert.assertTrue(isOk);
        Assert.assertEquals(responseModel.data.token_type.toLowerCase(), "bearer");
        Assert.assertTrue(responseModel.data.access_token != null);

    }

}