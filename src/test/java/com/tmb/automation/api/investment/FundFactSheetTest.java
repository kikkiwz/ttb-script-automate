package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.FundFactSheetModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FundFactSheetTest extends Base {

    public void verifyFundFactSheet(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/fund/factSheet";

        FundFactSheetModel fundFactSheetModel = new Gson().fromJson(String.valueOf(GetJsonData.getFundFactSheet().get(testcaseName)), FundFactSheetModel.class);

        if (isScenario) {
            parentReport = extent.createTest(fundFactSheetModel.ScenarioName, fundFactSheetModel.ScenarioName);
        }
        childReport = parentReport.createNode(fundFactSheetModel.Description);

        httpRequest.body(new Gson().toJson(fundFactSheetModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(fundFactSheetModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                fundFactSheetModel.Description, Arrays.toString(fundFactSheetModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel,fundFactSheetModel.ExpectedResultKey[0],fundFactSheetModel.ExpectedResultKey[1],fundFactSheetModel.ExpectedResultKey[2],fundFactSheetModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyFundFactSheetTHLanguage() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Funds_Fact_Sheet_0001";
        addHeader();
        verifyFundFactSheet(testcaseName, true);

    }

    @Test(priority = 2)
    void verifyFundFactSheetENGLanguage() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Funds_Fact_Sheet_0002";
        verifyFundFactSheet(testcaseName, false);

    }





}