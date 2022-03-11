//package com.ttbbank.oneapp.scenario.lending.API;
//
//import com.ttbbank.oneapp.scenario.lending.iosUtil.ExReport;
//import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
//import io.restassured.path.json.JsonPath;
//import org.json.simple.JSONObject;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.LinkedHashMap;
//
//public class APIViewAccountDetailsScenario {
//
//    private final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
//            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/DataTest/view_account_detail_dev.json"));
//
//    private static String accessToken;
//    private final JsonPath VIEW_ACCOUNT_CONFIG = new JsonPath(Lib.getInput(System.getProperty("user.dir")
//            + "/src/test/java/com/ttbbank//oneapp/scenario/primarybanking2/Config/view_account_detail_config.json"));
//
//
//    @Test
//    public void TS_OneApp_API_VIEW_ACCOUNT_001() {
//
//        LinkedHashMap dataResponse = ViewAccount.viewAccount(data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.RequestParamsAllFree.account_no")
//                , data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.RequestParamsAllFree.account_type")
//                ,GenerateToken.generateToken(),"data");
//
//
//
//        Assert.assertEquals((String) dataResponse.get("accountNo"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.accountNo"));
//        Assert.assertEquals((String) dataResponse.get("accountType"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.accountType"));
//        Assert.assertEquals((String) dataResponse.get("accountName"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.accountName"));
//        Assert.assertEquals((String) dataResponse.get("branchNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.branchNameEn"));
//        Assert.assertEquals((String) dataResponse.get("branchNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.branchNameTh"));
//        Assert.assertEquals((String) dataResponse.get("productNameEn"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.productNameEn"));
//        Assert.assertEquals((String) dataResponse.get("productNameTh"), data.getString("TS_OneApp_API_VIEW_ACCOUNT_001.ExpectedResult.productNameTh"));
//
//        JSONObject result = new JSONObject();
//        result.put("api-path", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.path"));
//        result.put("header", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.header"));
//        result.put("response", dataResponse.get("data"));
//        result.put("accessToken", accessToken);
//        result.put("hostname", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.hostname"));
//        result.put("description", VIEW_ACCOUNT_CONFIG.get("view-account-detail-config.description"));
//
//        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2"
//                , new Object(){}.getClass().getEnclosingMethod().getName(), result.toString());
//        ExReport.printReportMessageJson(result.toJSONString());
//
//
//    }