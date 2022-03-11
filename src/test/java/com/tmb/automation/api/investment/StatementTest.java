package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.StatementModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class StatementTest extends Base {

    public void verifyStatement(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/orders/statement";

        StatementModel statementModel = new Gson().fromJson(String.valueOf(GetJsonData.getStatement().get(testcaseName)), StatementModel.class);

        if (isScenario) {
            parentReport = extent.createTest(statementModel.ScenarioName, statementModel.ScenarioName);
        }
        childReport = parentReport.createNode(statementModel.Description);

        httpRequest.body(new Gson().toJson(statementModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(statementModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                statementModel.Description, Arrays.toString(statementModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, statementModel.ExpectedResultKey[0], statementModel.ExpectedResultKey[1], statementModel.ExpectedResultKey[2], statementModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyStatementByAll() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0001";
        addHeader();
        verifyStatement(testcaseName, true);

    }

    @Test(priority = 2)
    void verifyStatementByStatementTypePending() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0002";
        verifyStatement(testcaseName, false);

    }

    @Test(priority = 3)
    void verifyStatementByStatementTypeCancel() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0003";
        verifyStatement(testcaseName, false);

    }

    @Test(priority = 4)
    void verifyStatementByFundCode() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0004";
        verifyStatement(testcaseName, false);

    }

    @Test(priority = 5)
    void verifyStatementByFundTypeMF() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0005";
        verifyStatement(testcaseName, false);

    }

//    @Test(priority = 6)
//    void verifyStatementByFundTypeTSP() throws Exception {
//        String testcaseName = "TC_OneApp_Investment_Statement_0006";
//        verifyStatement(testcaseName, true);
//
//    }

    @Test(priority = 7)
    void verifyStatementByTranTypeBuy() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0007";
        verifyStatement(testcaseName, false);

    }

    @Test(priority = 8)
    void verifyStatementByTranTypeSell() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0008";
        verifyStatement(testcaseName, false);

    }

    @Test(priority = 9)
    void verifyStatementByTranTypeSwitch() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0009";
        verifyStatement(testcaseName, false);

    }

    @Test(priority = 10)
    void verifyStatementByTranTypeDCA() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Statement_0010";
        verifyStatement(testcaseName, false);

    }

}