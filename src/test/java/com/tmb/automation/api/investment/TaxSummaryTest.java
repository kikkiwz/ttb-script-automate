package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.TaxSummaryModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TaxSummaryTest extends Base {

    public void verifyTaxSummary(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/tax/summary";

        TaxSummaryModel taxSummaryModel = new Gson().fromJson(String.valueOf(GetJsonData.getTaxSummary().get(testcaseName)), TaxSummaryModel.class);

        if (isScenario) {
            parentReport = extent.createTest(taxSummaryModel.ScenarioName, taxSummaryModel.ScenarioName);
        }
        childReport = parentReport.createNode(taxSummaryModel.Description);

        httpRequest.body(new Gson().toJson(taxSummaryModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(taxSummaryModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                taxSummaryModel.Description, Arrays.toString(taxSummaryModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
//                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, taxSummaryModel.ExpectedResultKey[0], taxSummaryModel.ExpectedResultKey[1], taxSummaryModel.ExpectedResultKey[2], taxSummaryModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyTaxSummaryByCurrentYear() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Tax_Summary_0001";
        addHeader();
        verifyTaxSummary(testcaseName, true);

    }@Test(priority = 2)
    void verifyTaxSummaryByPreviousYear() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Tax_Summary_0002";
        verifyTaxSummary(testcaseName, false);

    }

}