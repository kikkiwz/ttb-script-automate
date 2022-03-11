package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.ViewAIPModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ViewAIPTest extends Base {

    public void verifyViewAIP(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/view/aip";

        ViewAIPModel viewAIPModel = new Gson().fromJson(String.valueOf(GetJsonData.getViewAIP().get(testcaseName)), ViewAIPModel.class);


        if (isScenario) {
            parentReport = extent.createTest(viewAIPModel.ScenarioName, viewAIPModel.ScenarioName);
        }
        childReport = parentReport.createNode(viewAIPModel.Description);

        httpRequest.body(new Gson().toJson(viewAIPModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(viewAIPModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                viewAIPModel.Description, Arrays.toString(viewAIPModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, viewAIPModel.ExpectedResultKey[0], viewAIPModel.ExpectedResultKey[1], viewAIPModel.ExpectedResultKey[2], viewAIPModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyViewAIPByCRMId() throws Exception {
        String testcaseName = "TC_OneApp_Investment_View_AIP_0001";
        addHeader();
        verifyViewAIP(testcaseName, true);

    }

    @Test(priority = 2)
    void verifyViewAIPPortfolio() throws Exception {
        String testcaseName = "TC_OneApp_Investment_View_AIP_0002";
        verifyViewAIP(testcaseName, false);

    }

    @Test(priority = 3)
    void verifyViewAIPFundCode() throws Exception {
        String testcaseName = "TC_OneApp_Investment_View_AIP_0003";
        verifyViewAIP(testcaseName, false);

    }

}