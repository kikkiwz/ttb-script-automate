package com.ttbbank.oneapp.runner.platform2.api;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.platform2.LoginPassModel;
import com.tmb.automation.model.platform2.LoginSuccessApiModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.GetJsonData;
import com.tmb.automation.util.platform2.Common;
import com.tmb.automation.util.platform2.MapTmb;
import com.ttbbank.oneapp.framework.BaseScenarioApi;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.RsaUtil;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.UUID;

public class LoginOneAppTest extends BaseScenarioApi {
//    String apiPath = "/apis/auth/token";

    void verifyLogin(String testCaseID, boolean isScenario) throws ParseException, IOException, InterruptedException, DocumentException {

//        LoginPassModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getLoginTestCase().get(testCaseID)), LoginPassModel.class);
//        new Common().addScenarioNameToReport(isScenario, dataModel.ScenarioName);
//        new Common().addDescriptionToReport(dataModel.Description);
//        isSkipTest(dataModel.IsSkip, dataModel.Description);
////        new Common().addUrlApiPathToReport(apiPath);
//        new Common().addExpectedResultToReport(dataModel.ExpectedResult);
//        new Common().addRequestBodyApiToReport(new Gson().toJson(dataModel.TestData.body));
//        OneAppClient oneAppClient = new OneAppClient();
//       oneAppClient.getToken("0eba1d2a2e01fa57bc8c551796ee334a288e19bc5a7ea02ab9ce7e7340c98107");
//        boolean isPass = !oneAppClient.getToken().isEmpty();
//        new Common().addResponseApiToReport(isPass, oneAppClient.getToken());
//        new Common().exportExcelToTestcase(dataModel.Description, dataModel.ExpectedResult, response.getStatusCode(), "", oneAppClient.getToken(), "", isPass);
//        Assert.assertTrue(isPass);

    }

    @Test(priority = 1)
    public void verifyLoginPass() throws DocumentException, ParseException, IOException, InterruptedException {
        String testCaseId = "TC_OneApp1682_CC_LogIn_0001";
        verifyLogin(testCaseId, true);
    }
//
//    @Test(priority = 2)
//    public void verifyLoginSkip() throws DocumentException, ParseException, IOException, InterruptedException {
//        String testCaseId = "TC_OneApp1682_CC_LogIn_0002";
//        verifyLogin(testCaseId, false);
//    }

    public static void main(String[] arg){
//        OneAppClient oneAppClient = new OneAppClient();
//        System.err.println(oneAppClient.getToken("0eba1d2a2e01fa57bc8c551796ee334a288e19bc5a7ea02ab9ce7e7340c98107"));
        String password = RsaUtil.encryptBase64("010203");
        System.err.println(password);
    }

}