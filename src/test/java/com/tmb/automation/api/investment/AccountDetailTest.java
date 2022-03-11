package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.AccountDetailModel;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AccountDetailTest extends Base {

    public void verifyAccountDetail(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/products/funds/account/detail";

        AccountDetailModel accountDetailModel = new Gson().fromJson(String.valueOf(GetJsonData.getAccountDetail().get(testcaseName)), AccountDetailModel.class);

        if (isScenario) {
            parentReport = extent.createTest(accountDetailModel.ScenarioName, accountDetailModel.ScenarioName);
        }
        childReport = parentReport.createNode(accountDetailModel.Description);

        httpRequest.body(new Gson().toJson(accountDetailModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(accountDetailModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                accountDetailModel.Description, Arrays.toString(accountDetailModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel,accountDetailModel.ExpectedResultKey[0],accountDetailModel.ExpectedResultKey[1],accountDetailModel.ExpectedResultKey[2],accountDetailModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void accountDetailMutualFund() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Account_Detail_0001";
        addHeader();
        verifyAccountDetail(testcaseName, true);

    }

    @Test(priority = 2)
    void accountDetailTTBSmartPort() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Account_Detail_0002";
        verifyAccountDetail(testcaseName, false);

    }

//    @Test(priority = 3)
//    void accountDetailPTES() throws Exception{
//        String testcaseName = "TC_OneApp_Investment_Account_Detail_0003";
//        verifyAccountDetail(testcaseName, false);
//
//    }


}