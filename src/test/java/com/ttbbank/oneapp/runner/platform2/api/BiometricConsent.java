package com.ttbbank.oneapp.runner.platform2.api;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.tmb.automation.api.investment.model.BaseApiModel;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.platform2.BiometricConsentPassModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.platform2.Common;
import com.ttbbank.oneapp.framework.BaseScenarioApi;
import io.restassured.http.Method;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class BiometricConsent extends BaseScenarioApi {

    String apiPath = "/apis/customers/ekyc/biometricConsent";

    void verifyBiometricConsentService(String testCaseID, boolean isScenario) throws IOException, DocumentException {

        BiometricConsentPassModel dataModel = new Gson().fromJson(String.valueOf(com.tmb.automation.util.GetJsonData.getBiometricConsentTestCase().get(testCaseID)), BiometricConsentPassModel.class);
        new Common().addScenarioNameToReport(isScenario, dataModel.ScenarioName);
        new Common().addDescriptionToReport(dataModel.Description);
        isSkipTest(dataModel.IsSkip, dataModel.Description);
        new Common().addUrlApiPathToReport(apiPath);
        new Common().addExpectedResultToReport(dataModel.ExpectedResult);
        new Common().addRequestBodyApiToReport(new Gson().toJson(dataModel.TestData.body));
        httpRequest.body(dataModel.TestData.body);
        response = httpRequest.filters(logsFilter).request(Method.POST, Setting.baseUrlApi + apiPath);
        BaseApiModel responseModel = new Gson().fromJson(response.getBody().asString(), BaseApiModel.class);
        boolean isPass = String.valueOf(response.getStatusCode()).equals(dataModel.ExpectedResultKey[0]);
        new Common().addResponseApiToReport(isPass, response.getBody().asString());
        new Common().exportExcelToTestcase(dataModel.Description, dataModel.ExpectedResult, response.getStatusCode(), logsFilter.getRequestBuilder().toString(), ConvertStringToJson.jsonFormat(response.getBody().asString()), "", isPass);
        Assert.assertTrue(isPass);
        Assert.assertEquals(responseModel.status.code.toLowerCase(),    dataModel.ResponseBody.status.code.toLowerCase());
        Assert.assertEquals(responseModel.status.message.toLowerCase(), dataModel.ResponseBody.status.message.toLowerCase());
        Assert.assertEquals(responseModel.status.service.toLowerCase(), dataModel.ResponseBody.status.service.toLowerCase());

    }

    @Test(priority = 1)
    void biometricConsentPass() throws ParseException, IOException, DocumentException {
        String testCaseID = "TC_OneApp1682_CC_BiometricConsent_0001";
        addHeader();
        verifyBiometricConsentService(testCaseID,true);
    }

    @Test(priority = 2)
    void biometricConsentSkip() throws ParseException, IOException, DocumentException {
        String testCaseID = "TC_OneApp1682_CC_BiometricConsent_0002";
        verifyBiometricConsentService(testCaseID,false);
    }

    @Test(priority = 3)
    void biometricConsentFailed() throws ParseException, IOException, DocumentException {
        String testCaseID = "TC_OneApp1682_CC_BiometricConsent_0003";
        verifyBiometricConsentService(testCaseID,false);
    }


}
