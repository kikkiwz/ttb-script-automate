package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.FundSummaryModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FundSummaryTest extends Base {

    public void verifyFundSummary(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/products/funds/summary";

        FundSummaryModel fundSummaryModel = new Gson().fromJson(String.valueOf(GetJsonData.getFundSummary().get(testcaseName)), FundSummaryModel.class);

        if (isScenario) {
            parentReport = extent.createTest(fundSummaryModel.ScenarioName, fundSummaryModel.ScenarioName);
        }
        childReport = parentReport.createNode(fundSummaryModel.Description);

        httpRequest.body(new Gson().toJson(fundSummaryModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(fundSummaryModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                fundSummaryModel.Description, Arrays.toString(fundSummaryModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel,fundSummaryModel.ExpectedResultKey[0],fundSummaryModel.ExpectedResultKey[1],fundSummaryModel.ExpectedResultKey[2],fundSummaryModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void mutualFundSummary() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Fund_Summary_0001";
        addHeader();
        verifyFundSummary(testcaseName, true);

    }
//
//    @Test(priority = 2)
//    void aipSchedule() throws Exception{
//        String testcaseName = "TC_OneApp_Investment_Aip_Order_0002";
//        verifyAIPOrder(testcaseName, false);
//
//    }

}