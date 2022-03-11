package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.SuitabilityAnswerModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SuitabilityAnswerTest extends Base {

    public void verifySuitabilityAnswer(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/suitability/answer";

        SuitabilityAnswerModel suitabilityAnswerModel = new Gson().fromJson(String.valueOf(GetJsonData.getSuitabilityAnswer().get(testcaseName)), SuitabilityAnswerModel.class);

        if (isScenario) {
            parentReport = extent.createTest(suitabilityAnswerModel.ScenarioName, suitabilityAnswerModel.ScenarioName);
        }
        childReport = parentReport.createNode(suitabilityAnswerModel.Description);

        httpRequest.body(new Gson().toJson(suitabilityAnswerModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(suitabilityAnswerModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                suitabilityAnswerModel.Description, Arrays.toString(suitabilityAnswerModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, suitabilityAnswerModel.ExpectedResultKey[0], suitabilityAnswerModel.ExpectedResultKey[1], suitabilityAnswerModel.ExpectedResultKey[2], suitabilityAnswerModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifySuitabilityAnswerScoreIsOne() throws Exception {
        addHeader();
        String testcaseName = "TC_OneApp_Investment_Suitability_Answer_0001";
        verifySuitabilityAnswer(testcaseName, true);

    }

    @Test(priority = 2)
    void verifySuitabilityAnswerScoreIsTwo() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Suitability_Answer_0002";
        verifySuitabilityAnswer(testcaseName, false);

    }

    @Test(priority = 3)
    void verifySuitabilityAnswerScoreIsThree() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Suitability_Answer_0003";
        verifySuitabilityAnswer(testcaseName, false);

    }

    @Test(priority = 4)
    void verifySuitabilityAnswerScoreIsFour() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Suitability_Answer_0004";
        verifySuitabilityAnswer(testcaseName, false);

    }

    @Test(priority = 5)
    void verifySuitabilityAnswerScoreIsFive() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Suitability_Answer_0005";
        verifySuitabilityAnswer(testcaseName, false);

    }

}