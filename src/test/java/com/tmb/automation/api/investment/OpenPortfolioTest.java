package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.OpenPortfolioModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class OpenPortfolioTest extends Base {

    public void verifyOpenPortfolio(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/products/open/portfolio";

        OpenPortfolioModel openPortfolioModel = new Gson().fromJson(String.valueOf(GetJsonData.getOpenPortfolio().get(testcaseName)), OpenPortfolioModel.class);


        if (isScenario) {
            parentReport = extent.createTest(openPortfolioModel.ScenarioName, openPortfolioModel.ScenarioName);
        }
        childReport = parentReport.createNode(openPortfolioModel.Description);

        httpRequest.body(new Gson().toJson(openPortfolioModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(openPortfolioModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                openPortfolioModel.Description, Arrays.toString(openPortfolioModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, openPortfolioModel.ExpectedResultKey[0], openPortfolioModel.ExpectedResultKey[1], openPortfolioModel.ExpectedResultKey[2], openPortfolioModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyOpenPortfolioExistingCustomer() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Open_Portfolio_0001";
        addHeader();
        verifyOpenPortfolio(testcaseName, true);
    }

    @Test(priority = 2)
    void verifyOpenPortfolioNewCustomer() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Open_Portfolio_0002";
        verifyOpenPortfolio(testcaseName, false);
    }

}