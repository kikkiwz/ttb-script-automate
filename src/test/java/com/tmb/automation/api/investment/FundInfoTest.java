package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.FundInfoModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FundInfoTest extends Base {

    public void verifyFundInfo(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/products/funds/info";

        FundInfoModel fundInfoModel = new Gson().fromJson(String.valueOf(GetJsonData.getFundInfo().get(testcaseName)), FundInfoModel.class);

        if (isScenario) {
            parentReport = extent.createTest(fundInfoModel.ScenarioName, fundInfoModel.ScenarioName);
        }
        childReport = parentReport.createNode(fundInfoModel.Description);

        httpRequest.body(new Gson().toJson(fundInfoModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(fundInfoModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                fundInfoModel.Description, Arrays.toString(fundInfoModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, fundInfoModel.ExpectedResultKey[0], fundInfoModel.ExpectedResultKey[1], fundInfoModel.ExpectedResultKey[2], fundInfoModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyFundInfoSuccess() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Fund_Info_0001";
        addHeader();
        verifyFundInfo(testcaseName, true);

    }


}