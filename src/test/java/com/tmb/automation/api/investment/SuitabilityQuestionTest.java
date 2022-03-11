package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.SuitabilityQuestionModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SuitabilityQuestionTest extends Base {

    public void verifySuitabilityAnswer(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/suitability/questions";

        SuitabilityQuestionModel suitabilityQuestionModel = new Gson().fromJson(String.valueOf(GetJsonData.getSuitabilityQuestion().get(testcaseName)), SuitabilityQuestionModel.class);


        if (isScenario) {
            parentReport = extent.createTest(suitabilityQuestionModel.ScenarioName, suitabilityQuestionModel.ScenarioName);
        }
        childReport = parentReport.createNode(suitabilityQuestionModel.Description);

        httpRequest.body(new Gson().toJson(suitabilityQuestionModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(suitabilityQuestionModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                suitabilityQuestionModel.Description, Arrays.toString(suitabilityQuestionModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, suitabilityQuestionModel.ExpectedResultKey[0], suitabilityQuestionModel.ExpectedResultKey[1], suitabilityQuestionModel.ExpectedResultKey[2], suitabilityQuestionModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifySuitabilityThaiQuestion() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Suitability_Question_0001";
        addHeader();
        verifySuitabilityAnswer(testcaseName, true);

    }

    @Test(priority = 2)
    void verifySuitabilityEnglishQuestion() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Suitability_Question_0002";
        verifySuitabilityAnswer(testcaseName, false);

    }

}