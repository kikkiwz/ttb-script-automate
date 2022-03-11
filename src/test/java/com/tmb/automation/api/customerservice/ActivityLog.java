package com.tmb.automation.api.customerservice;

import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.platform2.GetJsonData;
import com.tmb.automation.model.platform2.SearchTestCasesModel;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.UUID;

public class ActivityLog extends BasePlatform2 {

    private void addHeader() {
        httpRequest.header("device-id", "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da");
        httpRequest.header("x-crmid", "EN");
        httpRequest.header("Timestamp", "001100000000000000000000086006");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("Authorization", "Bearer " + Setting.TOKEN);
    }
    private void addExportExcel(SearchTestCasesModel searchTestCasesModel, boolean isOK) {
        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                searchTestCasesModel.Description, Arrays.toString(searchTestCasesModel.ExpectedResult),
                logsFilter.getRequestBuilder().toString(),
                response.getStatusCode(),
                ConvertStringToJson.jsonFormat(response.getBody().asString()),
                "",
                getDateTime(),
                isPass(isOK)});
    }

    private void verifySearchApi(String testCaseID, boolean isScenario) {
        SearchTestCasesModel searchTestCasesModel = new Gson().fromJson(String.valueOf(GetJsonData.getSearchApiTestCase().get(testCaseID)), SearchTestCasesModel.class);
        response = httpRequest.filters(logsFilter).request(Method.GET, "https://apis-portal.oneapp.tmbbank.local/apis/customers/firstTimeUsage?serviceTypeId=EPB");
        BaseApiModel responseModel = new Gson().fromJson(response.getBody().asString(), BaseApiModel.class);
        System.err.println("asd  " + responseModel);
//        Assert.assertEquals(responseModel.status.code.toLowerCase(), "0000");
//        boolean isOK = (response.getStatusCode() == 200);
//        childReport.log(Status.PASS, "message: " + TextColor.greenColor(responseModel.status.message.toLowerCase()));
//        childReport.log(Status.PASS, "service: " + TextColor.greenColor(responseModel.status.service.toLowerCase()));
//        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(response.getBody().asString())) + "</pre>");
//        addExportExcel(searchTestCasesModel, isOK);
    }
    @Test(priority = 1)
    void SearchTestPassportNoSuccess() throws ParseException, IOException {
        String testCaseID = "TC_OneApp1685_CC_Customer_search_0011";
        addHeader();
        verifySearchApi(testCaseID, true);
    }

}
