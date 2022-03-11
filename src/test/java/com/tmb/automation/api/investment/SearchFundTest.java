package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.SearchFundListModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SearchFundTest extends Base {

    public void verifySearchFund(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/products/funds/search/fundList";

        SearchFundListModel searchFundListModel = new Gson().fromJson(String.valueOf(GetJsonData.getSearchFund().get(testcaseName)), SearchFundListModel.class);

        if (isScenario) {
            parentReport = extent.createTest(searchFundListModel.ScenarioName, searchFundListModel.ScenarioName);
        }
        childReport = parentReport.createNode(searchFundListModel.Description);

        httpRequest.body(new Gson().toJson(searchFundListModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(searchFundListModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                searchFundListModel.Description, Arrays.toString(searchFundListModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel,searchFundListModel.ExpectedResultKey[0],searchFundListModel.ExpectedResultKey[1],searchFundListModel.ExpectedResultKey[2],searchFundListModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void searchFundBySinglePort() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Search_Fund_0001";
        addHeader();
        verifySearchFund(testcaseName, true);

    }

    @Test(priority = 2)
    void searchFundByMultiplePort() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Search_Fund_0002";
        verifySearchFund(testcaseName, false);

    }

//    @Test(priority = 3)
//    void accountDetailPTES() throws Exception{
//        String testcaseName = "TC_OneApp_Investment_Account_Detail_0003";
//        verifyAccountDetail(testcaseName, false);
//
//    }


}