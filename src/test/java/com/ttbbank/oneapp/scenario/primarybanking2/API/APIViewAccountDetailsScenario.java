package com.ttbbank.oneapp.scenario.primarybanking2.API;

import com.tmb.automation.primarybanking2.APITest.ViewAccountDetails.ViewAccount;
import com.tmb.automation.test.primarybanking2.Utility.GenerateToken;
import com.ttbbank.oneapp.scenario.lending.iosUtil.ExReport;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class APIViewAccountDetailsScenario {

    private final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/DataTest/view_account_detail_dev.json"));

    private static String accessToken = "";
    private final JsonPath VIEW_ACCOUNT_CONFIG = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/Config/view_account_detail_config.json"));


    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_001() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.RequestParamsAllFree.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.RequestParamsAllFree.account_type")
                , GenerateToken.generateToken(), "data");

        System.out.println("Response  : " + dataResponse);
        Assert.assertEquals((String) dataResponse.get("accountNo"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.accountNo"));
        Assert.assertEquals((String) dataResponse.get("accountType"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.accountType"));
        Assert.assertEquals((String) dataResponse.get("accountName"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.accountName"));
        Assert.assertEquals((String) dataResponse.get("branchNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.branchNameEn"));
        Assert.assertEquals((String) dataResponse.get("branchNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.branchNameTh"));
        Assert.assertEquals((String) dataResponse.get("productNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.productNameEn"));
        Assert.assertEquals((String) dataResponse.get("productNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.productNameTh"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_001.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2/"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());


    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_002() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.RequestParamsNoFixed.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.RequestParamsNoFixed.account_type")
                , GenerateToken.generateToken(), "data");


        Assert.assertEquals((String) dataResponse.get("accountNo"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.ExpectedResult.accountNo"));
        Assert.assertEquals((String) dataResponse.get("accountType"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.ExpectedResult.accountType"));
        Assert.assertEquals((String) dataResponse.get("accountName"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.ExpectedResult.accountName"));
        Assert.assertEquals((String) dataResponse.get("branchNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.ExpectedResult.branchNameEn"));
        Assert.assertEquals((String) dataResponse.get("branchNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.ExpectedResult.branchNameTh"));
        Assert.assertEquals((String) dataResponse.get("productNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.ExpectedResult.productNameEn"));
        Assert.assertEquals((String) dataResponse.get("productNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.ExpectedResult.productNameTh"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_002.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_002.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());


    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_003() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.RequestParamsBasicSaving.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.RequestParamsBasicSaving.account_type")
                , GenerateToken.generateToken(), "data");


        Assert.assertEquals((String) dataResponse.get("accountNo"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.ExpectedResult.accountNo"));
        Assert.assertEquals((String) dataResponse.get("accountType"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.ExpectedResult.accountType"));
        Assert.assertEquals((String) dataResponse.get("accountName"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.ExpectedResult.accountName"));
        Assert.assertEquals((String) dataResponse.get("branchNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.ExpectedResult.branchNameEn"));
        Assert.assertEquals((String) dataResponse.get("branchNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.ExpectedResult.branchNameTh"));
        Assert.assertEquals((String) dataResponse.get("productNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.ExpectedResult.productNameEn"));
        Assert.assertEquals((String) dataResponse.get("productNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.ExpectedResult.productNameTh"));


        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_003.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_003.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_004() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.RequestParamsDreamSaving.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.RequestParamsDreamSaving.account_type")
                , GenerateToken.generateToken(), "data");


        Assert.assertEquals((String) dataResponse.get("accountNo"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.ExpectedResult.accountNo"));
        Assert.assertEquals((String) dataResponse.get("accountType"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.ExpectedResult.accountType"));
        Assert.assertEquals((String) dataResponse.get("accountName"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.ExpectedResult.accountName"));
        Assert.assertEquals((String) dataResponse.get("branchNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.ExpectedResult.branchNameEn"));
        Assert.assertEquals((String) dataResponse.get("branchNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.ExpectedResult.branchNameTh"));
        Assert.assertEquals((String) dataResponse.get("productNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.ExpectedResult.productNameEn"));
        Assert.assertEquals((String) dataResponse.get("productNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.ExpectedResult.productNameTh"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_004.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_004.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_005() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.RequestParamsCurrentSaving.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.RequestParamsCurrentSaving.account_type")
                , GenerateToken.generateToken(), "data");


        Assert.assertEquals((String) dataResponse.get("accountNo"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.ExpectedResult.accountNo"));
        Assert.assertEquals((String) dataResponse.get("accountType"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.ExpectedResult.accountType"));
        Assert.assertEquals((String) dataResponse.get("accountName"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.ExpectedResult.accountName"));
        Assert.assertEquals((String) dataResponse.get("branchNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.ExpectedResult.branchNameEn"));
        Assert.assertEquals((String) dataResponse.get("branchNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.ExpectedResult.branchNameTh"));
        Assert.assertEquals((String) dataResponse.get("productNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.ExpectedResult.productNameEn"));
        Assert.assertEquals((String) dataResponse.get("productNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.ExpectedResult.productNameTh"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_005.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_005.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());

    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_008() {


        LinkedHashMap dataResponse
                = ViewAccount.viewAccountDeleteBodyParams(data.getString("TS_OneApp_API_VIEW_ACCOUNT_008.RequestParamsDeleteAccountNo.account_type")
                , GenerateToken.generateToken(), "data");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_008.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_008.ResponseBody.data.status.message"));
    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_009() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.getString("TS_OneApp_API_VIEW_ACCOUNT_009.RequestParamsInvalidAccountType.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_009.RequestParamsInvalidAccountType.account_type")
                , GenerateToken.generateToken(), "status");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_009.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_009.ResponseBody.data.status.message"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_009.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_009.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());


    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_010() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount("",
                "SDA", GenerateToken.generateToken(), "status");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_010.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_010.ResponseBody.data.status.message"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_010.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_010.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_011() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.getString("TS_OneApp_API_VIEW_ACCOUNT_011.RequestParamsNullAccountType.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_011.RequestParamsNullAccountType.account_type"), GenerateToken.generateToken(), "status");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_011.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_011.ResponseBody.data.status.message"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_011.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_011.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_012() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount("", "", GenerateToken.generateToken(), "status");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_012.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_012.ResponseBody.data.status.message"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_012.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_012.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());


    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_013() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.get("TS_OneApp_API_VIEW_ACCOUNT_013.RequestParams.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_013.RequestParams.account_type")
                , GenerateToken.generateToken(), "status");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_013.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_013.ResponseBody.data.status.message"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_013.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_013.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_014() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.get("TS_OneApp_API_VIEW_ACCOUNT_014.RequestParams.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_014.RequestParams.account_type")
                , GenerateToken.generateToken(), "status");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_014.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_014.ResponseBody.data.status.message"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_014.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_014.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());

    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_015() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.get("TS_OneApp_API_VIEW_ACCOUNT_015.RequestParams.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_015.RequestParams.account_type")
                , GenerateToken.generateToken(), "status");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_015.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_015.ResponseBody.data.status.message"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_015.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_015.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());
    }

    @Test
    public void TS_OneApp_API_VIEW_ACCOUNT_016() {

        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.get("TS_OneApp_API_VIEW_ACCOUNT_016.RequestParams.account_no")
                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_016.RequestParams.account_type")
                , GenerateToken.generateToken(), "status");

        System.out.println("Code :" + (String) dataResponse.get("code"));
        System.out.println("Message :" + (String) dataResponse.get("message"));
        Assert.assertEquals((String) dataResponse.get("code"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_016.ResponseBody.data.status.code"));
        Assert.assertEquals((String) dataResponse.get("message"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_016.ResponseBody.data.status.message"));

        JSONObject result = new JSONObject();
        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
        result.put("expectedResult", data.getString("TS_OneApp_API_VIEW_ACCOUNT_016.ExpectedResult"));
        result.put("actualResult", dataResponse);
        result.put("accessToken", GenerateToken.generateToken());
        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
        result.put("description", data.get("TS_OneApp_API_VIEW_ACCOUNT_016.Description"));

        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
                , new Object() {
                }.getClass().getEnclosingMethod().getName(), result.toString());
        ExReport.printReportMessageJson(result.toJSONString());

    }
}
