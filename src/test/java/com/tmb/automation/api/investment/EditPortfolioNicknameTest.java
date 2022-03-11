package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.EditNickNameModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class EditPortfolioNicknameTest extends Base {

    public void verifyEditPortfolioNickname(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/portfolio/nickname";

        EditNickNameModel editNickNameModel = new Gson().fromJson(String.valueOf(GetJsonData.getEditPortNickName().get(testcaseName)), EditNickNameModel.class);

        if (isScenario) {
            parentReport = extent.createTest(editNickNameModel.ScenarioName, editNickNameModel.ScenarioName);
        }
        childReport = parentReport.createNode(editNickNameModel.Description);

        httpRequest.body(new Gson().toJson(editNickNameModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(editNickNameModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                editNickNameModel.Description, Arrays.toString(editNickNameModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, editNickNameModel.ExpectedResultKey[0], editNickNameModel.ExpectedResultKey[1], editNickNameModel.ExpectedResultKey[2], editNickNameModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyEditPortfolioNicknameThaiOnly() throws Exception {
        String testcaseName = "TC_OneApp_Edit_Portfolio_Nickname_0001";
        addHeader();
        verifyEditPortfolioNickname(testcaseName, true);

    }

    @Test(priority = 2)
    void verifyEditPortfolioNicknameEnglishOnly() throws Exception {
        String testcaseName = "TC_OneApp_Edit_Portfolio_Nickname_0002";
        verifyEditPortfolioNickname(testcaseName, false);

    }

    @Test(priority = 3)
    void verifyEditPortfolioNicknameMixLanguage() throws Exception {
        String testcaseName = "TC_OneApp_Edit_Portfolio_Nickname_0003";
        verifyEditPortfolioNickname(testcaseName, false);

    }


}