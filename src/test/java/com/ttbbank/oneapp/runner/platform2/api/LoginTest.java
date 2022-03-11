package com.ttbbank.oneapp.runner.platform2.api;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.platform2.LoginPassModel;
import com.tmb.automation.model.platform2.LoginSuccessApiModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.GetJsonData;
import com.tmb.automation.util.platform2.Common;
import com.tmb.automation.util.platform2.MapTmb;
import com.ttbbank.oneapp.framework.BaseScenarioApi;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.UUID;

public class LoginTest extends BaseScenarioApi {
    String apiPath = "/apis/auth/token";

    void verifyLogin(String testCaseID, boolean isScenario) throws ParseException, IOException, InterruptedException, DocumentException {

        LoginPassModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getLoginTestCase().get(testCaseID)), LoginPassModel.class);
        new Common().addScenarioNameToReport(isScenario, dataModel.ScenarioName);
        new Common().addDescriptionToReport(dataModel.Description);
        isSkipTest(dataModel.IsSkip, dataModel.Description);
        new Common().addUrlApiPathToReport(apiPath);
        new Common().addExpectedResultToReport(dataModel.ExpectedResult);
        new Common().addRequestBodyApiToReport(new Gson().toJson(dataModel.TestData.body));
        if (isScenario) {
            httpRequest.header("X-Correlation-ID", UUID.randomUUID());
        }
        Map<String, Object> mapData = MapTmb.pojoToMap(dataModel.TestData.body);
        for (Map.Entry<String, Object> inputData : mapData.entrySet()) {
            httpRequest.multiPart(inputData.getKey().toString(), inputData.getValue().toString());
        }
        httpRequest.auth().preemptive().basic(Setting.APP_KEY_NAME_DEV, Setting.APP_KEY_VALUE_DEV);
        response = httpRequest.filters(logsFilter).request(Method.POST, Setting.baseUrlApi + apiPath);
        LoginSuccessApiModel responseModel = new Gson().fromJson(response.getBody().asString(), LoginSuccessApiModel.class);
        boolean isPass = String.valueOf(response.getStatusCode()).equals(dataModel.ExpectedResultKey[0]);
        new Common().addResponseApiToReport(isPass, response.getBody().asString());
        new Common().exportExcelToTestcase(dataModel.Description, dataModel.ExpectedResult, response.getStatusCode(), logsFilter.getRequestBuilder().toString(), ConvertStringToJson.jsonFormat(response.getBody().asString()), "", isPass);
        Assert.assertTrue(isPass);
        Setting.TOKEN = responseModel.data.access_token;
       // Assert.assertEquals(responseModel.status.code.toLowerCase(),    dataModel.ResponseBody.status.code.toLowerCase());
        //Assert.assertEquals(responseModel.status.message.toLowerCase(), dataModel.ResponseBody.status.message.toLowerCase());
        //Assert.assertEquals(responseModel.status.service.toLowerCase(), dataModel.ResponseBody.status.service.toLowerCase());
        Assert.assertNotEquals(responseModel.data.access_token, null);
        Assert.assertNotEquals(responseModel.data.refresh_token, null);
        Assert.assertEquals(responseModel.data.token_type.toLowerCase(), dataModel.ResponseBody.data.token_type.toLowerCase());
        Assert.assertEquals(responseModel.data.scope.toLowerCase(), dataModel.ResponseBody.data.scope.toLowerCase());
        Assert.assertEquals(responseModel.data.channel.toLowerCase(), dataModel.ResponseBody.data.channel.toLowerCase());
    }

    @Test(priority = 1)
    public void verifyLoginPass() throws DocumentException, ParseException, IOException, InterruptedException {
        String testCaseId = "TC_OneApp1682_CC_LogIn_0001";
        verifyLogin(testCaseId, true);
    }

    @Test(priority = 2)
    public void verifyLoginSkip() throws DocumentException, ParseException, IOException, InterruptedException {
        String testCaseId = "TC_OneApp1682_CC_LogIn_0002";
        verifyLogin(testCaseId, false);
    }

}