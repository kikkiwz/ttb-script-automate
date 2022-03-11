package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.PastPerformanceModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PastPerformanceTest extends Base {

    public void verifyPastPerformance(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/performance/stats";

        PastPerformanceModel pastPerformanceModel = new Gson().fromJson(String.valueOf(GetJsonData.getPastPerformance().get(testcaseName)), PastPerformanceModel.class);

        if (isScenario) {
            parentReport = extent.createTest(pastPerformanceModel.ScenarioName, pastPerformanceModel.ScenarioName);
        }
        childReport = parentReport.createNode(pastPerformanceModel.Description);

        httpRequest.body(new Gson().toJson(pastPerformanceModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(pastPerformanceModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                pastPerformanceModel.Description, Arrays.toString(pastPerformanceModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, pastPerformanceModel.ExpectedResultKey[0], pastPerformanceModel.ExpectedResultKey[1], pastPerformanceModel.ExpectedResultKey[2], pastPerformanceModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyPastPerformanceMFByAllYear() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Past_Performance_0001";
        addHeader();
        verifyPastPerformance(testcaseName, true);
    }

    @Test(priority = 2)
    void verifyPastPerformanceMFByYearly() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Past_Performance_0002";
        verifyPastPerformance(testcaseName, false);
    }

    @Test(priority = 3)
    void verifyPastPerformanceTSPByAllYear() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Past_Performance_0003";
        verifyPastPerformance(testcaseName, false);
    }

    @Test(priority = 4)
    void verifyPastPerformanceTSPByYearly() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Past_Performance_0004";
        verifyPastPerformance(testcaseName, false);
    }

}