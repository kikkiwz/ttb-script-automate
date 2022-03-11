package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.AIPOrderModel;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AipOrderTest extends Base {

    public void verifyAIPOrder(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/transaction/createAIPOrder";

        AIPOrderModel aipOrderModel = new Gson().fromJson(String.valueOf(GetJsonData.getAipOrder().get(testcaseName)), AIPOrderModel.class);

        if (isScenario) {
            parentReport = extent.createTest(aipOrderModel.ScenarioName, aipOrderModel.ScenarioName);
        }
        childReport = parentReport.createNode(aipOrderModel.Description);

        httpRequest.body(new Gson().toJson(aipOrderModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(aipOrderModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                aipOrderModel.Description, Arrays.toString(aipOrderModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel,aipOrderModel.ExpectedResultKey[0],aipOrderModel.ExpectedResultKey[1],aipOrderModel.ExpectedResultKey[2],aipOrderModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void aipOnetime() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Aip_Order_0001";
        addHeader();
        verifyAIPOrder(testcaseName, true);

    }

    @Test(priority = 2)
    void aipSchedule() throws Exception{
        String testcaseName = "TC_OneApp_Investment_Aip_Order_0002";
        verifyAIPOrder(testcaseName, false);

    }

}