package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.api.investment.model.SuitabilityInquiryModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SuitabilityInquiryTest extends Base {

    public void verifySuitabilityInquiry(String testcaseName, Boolean isScenario) {

        String pathApi = "/apis/investment/customers/suitabilityInquiry";

        SuitabilityInquiryModel suitabilityInquiryModel = new Gson().fromJson(String.valueOf(GetJsonData.getSuitabilityInquiry().get(testcaseName)), SuitabilityInquiryModel.class);

        if (isScenario) {
            parentReport = extent.createTest(suitabilityInquiryModel.ScenarioName, suitabilityInquiryModel.ScenarioName);
        }
        childReport = parentReport.createNode(suitabilityInquiryModel.Description);

        httpRequest.body(new Gson().toJson(suitabilityInquiryModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);

        System.err.println(responseBody.getBody().asString());

        BaseApiModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), BaseApiModel.class);

        boolean isOK = responseBody.getStatusCode() == 200;

        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(suitabilityInquiryModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(responseBody.getBody().asString())) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                suitabilityInquiryModel.Description, Arrays.toString(suitabilityInquiryModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
//                StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                ConvertStringToJson.jsonFormat(StringUtils.substring(responseBody.getBody().asString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);
        validateResponseStatus(responseModel, suitabilityInquiryModel.ExpectedResultKey[0], suitabilityInquiryModel.ExpectedResultKey[1], suitabilityInquiryModel.ExpectedResultKey[2], suitabilityInquiryModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifySuitabilityInquirySuccess() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Suitability_Inquiry_0001";
        addHeader();
        verifySuitabilityInquiry(testcaseName, true);

    }

}