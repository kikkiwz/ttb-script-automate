package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.CreateFavoriteFundModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CreateFavoriteFundTest extends Base {

    public void verifyCreateFund(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/fund/createFavoriteFund";

        CreateFavoriteFundModel createFavoriteFundModel = new Gson().fromJson(String.valueOf(GetJsonData.getCreateFavoriteFund().get(testcaseName)), CreateFavoriteFundModel.class);

        if (isScenario) {
            parentReport = extent.createTest(createFavoriteFundModel.ScenarioName, createFavoriteFundModel.ScenarioName);
        }
        childReport = parentReport.createNode(createFavoriteFundModel.Description);

        httpRequest.body(new Gson().toJson(createFavoriteFundModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(createFavoriteFundModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                createFavoriteFundModel.Description, Arrays.toString(createFavoriteFundModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
//                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, createFavoriteFundModel.ExpectedResultKey[0], createFavoriteFundModel.ExpectedResultKey[1], createFavoriteFundModel.ExpectedResultKey[2], createFavoriteFundModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyCreateFundSuccess() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Create_Favorite_Fund_0001";
        addHeader();
        verifyCreateFund(testcaseName, true);

    }

}