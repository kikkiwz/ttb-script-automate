package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.FundCategoryModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FundCategoryTest extends Base {

    public void verifyFundCategory(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/fund/category";

        FundCategoryModel fundCategoryModel = new Gson().fromJson(String.valueOf(GetJsonData.getFundCategory().get(testcaseName)), FundCategoryModel.class);

        if (isScenario) {
            parentReport = extent.createTest(fundCategoryModel.ScenarioName, fundCategoryModel.ScenarioName);
        }
        childReport = parentReport.createNode(fundCategoryModel.Description);

        httpRequest.body(new Gson().toJson(fundCategoryModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(fundCategoryModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                fundCategoryModel.Description, Arrays.toString(fundCategoryModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
//                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel,fundCategoryModel.ExpectedResultKey[0],fundCategoryModel.ExpectedResultKey[1],fundCategoryModel.ExpectedResultKey[2],fundCategoryModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyFundCategoryAll() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Funds_Category_0001";
        addHeader();
        verifyFundCategory(testcaseName, true);

    }

}