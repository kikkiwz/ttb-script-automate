package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.FundListBySuitScoreModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FundListBySuitScoreTest extends Base {

    public void verifyFundListBySuitScore(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/products/fundsBySuitScore";

        FundListBySuitScoreModel fundListBySuitScoreModel = new Gson().fromJson(String.valueOf(GetJsonData.getFundListBySuitScore().get(testcaseName)), FundListBySuitScoreModel.class);

        if (isScenario) {
            parentReport = extent.createTest(fundListBySuitScoreModel.ScenarioName, fundListBySuitScoreModel.ScenarioName);
        }
        childReport = parentReport.createNode(fundListBySuitScoreModel.Description);

        httpRequest.body(new Gson().toJson(fundListBySuitScoreModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(fundListBySuitScoreModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                fundListBySuitScoreModel.Description, Arrays.toString(fundListBySuitScoreModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel,fundListBySuitScoreModel.ExpectedResultKey[0],fundListBySuitScoreModel.ExpectedResultKey[1],fundListBySuitScoreModel.ExpectedResultKey[2],fundListBySuitScoreModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyFundListBySuitScoreCaseScoreEqualOne() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Fund_List_By_Suitability_Score_0001";
        addHeader();
        verifyFundListBySuitScore(testcaseName, true);

    }

    @Test(priority = 2)
    void verifyFundListBySuitScoreCaseScoreEqualTwo() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Fund_List_By_Suitability_Score_0002";
        verifyFundListBySuitScore(testcaseName, false);

    }

    @Test(priority = 3)
    void verifyFundListBySuitScoreCaseScoreEqualTree() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Fund_List_By_Suitability_Score_0003";
        verifyFundListBySuitScore(testcaseName, false);

    }

    @Test(priority = 4)
    void verifyFundListBySuitScoreCaseScoreEqualFour() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Fund_List_By_Suitability_Score_0004";
        verifyFundListBySuitScore(testcaseName, false);

    }

    @Test(priority = 5)
    void verifyFundListBySuitScoreCaseScoreEqualFive() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Fund_List_By_Suitability_Score_0005";
        verifyFundListBySuitScore(testcaseName, false);

    }



}