package com.ttbbank.oneapp.scenario.primarybanking2.API;

import com.tmb.automation.test.primarybanking2.APITest.SettingPromptpay.APISettingPromptPay;
import com.tmb.automation.test.primarybanking2.Utility.GenerateToken;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APISettingPromptPayScenario {

    private static final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/DataTest/setting_promptpay.json"));
    private static final JsonPath config = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/Config/setting_promptpay_config.json"));
    public static Response response;
    public static Object object;
    public static APISettingPromptPay apiSettingPromptPay = new APISettingPromptPay();
    private static String accessToken = "";


    @Test(groups = "SetUp")
    public void setUp() {

        accessToken = GenerateToken
                .initialGenerateToken
                        (data.getString("TC_Register_PromptPay_001.TestData.user_name")
                                , config.get("setting_promptPay_config.hostName_path.DEV"));

    }


//    @Test(groups = {"Setting PromptPay","Register", "mobileNo"}, priority = 1)
//    public static void registerPromptPayWithMobileNoSuccess() throws JsonProcessingException {
//        apiSettingPromptPay.checkInquiryStatusBeforeRegisterWithMobileNo("XXX-XXX-0008"
//                , config.get("setting_promptPay_config.hostName_path.DEV")
//                , accessToken);
//
//        accessToken = GenerateToken
//                .initialGenerateToken
//                        (data.getString("TC_Register_PromptPay_001.TestData.user_name")
//                                , config.get("setting_promptPay_config.hostName_path.DEV"));
//
//        apiSettingPromptPay.registerPromptPaySuccess(
//                config.get("setting_promptPay_config.hostName_path.DEV")
//                , data.getString("TC_Register_PromptPay_001.RegisterPromptPayParams.activationMode")
//                , data.getString("TC_Register_PromptPay_001.RegisterPromptPayParams.accountNumber")
//                , data.getString("TC_Register_PromptPay_001.RegisterPromptPayParams.bankCode")
//                , "TC_Register_PromptPay_001"
//                , accessToken);
//
//        response = apiSettingPromptPay.checkInquiryStatusAfterRegisterSuccess(
//                "0"
//                ,config.get("setting_promptPay_config.hostName_path.DEV")
//                ,"TC_Register_PromptPay_001"
//                , accessToken);
//
//
//        //Insert into report
//        JSONObject result = new JSONObject();
//        result.put("api-path", config.getString("setting_promptPay_config.registerPromptPay_path"));
//        result.put("header", config.get("setting_promptPay_config.headers"));
//        result.put("expectedResult", data.getString("TC_Register_PromptPay_001.Expected_Result_After_Register_PromptPay"));
//        result.put("actualResult", response.asString());
//        result.put("accessToken", accessToken);
//        result.put("hostname", config.get("setting_promptPay_config.hostName_path.DEV"));
//        result.put("description", data.get("TC_Register_PromptPay_001.Description"));
//
//        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2/"
//                , new Object() {
//                }.getClass().getEnclosingMethod().getName(), result.toString());
//        ExReport.printReportMessageJson(result.toJSONString());
//
//    }
//
//
//    @Test(groups = {"Setting PromptPay","Register", "citizenID"}, priority = 2)
//    public static void registerPromptPayWithCitizenIDSuccess() throws JsonProcessingException {
//
//                apiSettingPromptPay.checkInquiryStatusBeforeRegisterWithCitizenID("X-XXXX-XXXX8-37-6"
//                , config.get("setting_promptPay_config.hostName_path.DEV")
//                , accessToken);
//
//
//        accessToken = GenerateToken
//                .initialGenerateToken
//                        (data.getString("TC_Register_PromptPay_002.TestData.user_name")
//                                , config.get("setting_promptPay_config.hostName_path.DEV"));
//
//        apiSettingPromptPay.registerPromptPaySuccess(
//                config.get("setting_promptPay_config.hostName_path.DEV")
//                , data.getString("TC_Register_PromptPay_002.RegisterPromptPayParams.activationMode")
//                , data.getString("TC_Register_PromptPay_002.RegisterPromptPayParams.accountNumber")
//                , data.getString("TC_Register_PromptPay_002.RegisterPromptPayParams.bankCode")
//                , "TC_Register_PromptPay_002"
//                , accessToken);
//
//        response = apiSettingPromptPay.checkInquiryStatusAfterRegisterSuccess(
//                "1"
//                ,config.get("setting_promptPay_config.hostName_path.DEV")
//                ,"TC_Register_PromptPay_002"
//                , accessToken);
//
//
//        //Insert into report
//        JSONObject result = new JSONObject();
//        result.put("api-path", config.getString("setting_promptPay_config.registerPromptPay_path"));
//        result.put("header", config.get("setting_promptPay_config.headers"));
//        result.put("expectedResult", data.getString("TC_Register_PromptPay_002.Expected_Result_After_Register_PromptPay"));
//        result.put("actualResult", response.asString());
//        result.put("accessToken", accessToken);
//        result.put("hostname", config.get("setting_promptPay_config.hostName_path.DEV"));
//        result.put("description", data.get("TC_Register_PromptPay_002.Description"));
//
//        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2/"
//                , new Object() {
//                }.getClass().getEnclosingMethod().getName(), result.toString());
//        ExReport.printReportMessageJson(result.toJSONString());
//
//    }
//
//    @Test(groups = {"Setting PromptPay","DeRegister", "mobileNo"}, priority = 3)
//    public void deRegisterPromptPayWithMobileNoSuccess(){
//        apiSettingPromptPay.checkInquiryStatusBeforeDeRegisterWithMobileNo("XXX-XXX-0008"
//                , config.get("setting_promptPay_config.hostName_path.DEV")
//                , accessToken);
//
//        accessToken = GenerateToken
//                .initialGenerateToken
//                        (data.getString("TC_Register_PromptPay_001.TestData.user_name")
//                                , config.get("setting_promptPay_config.hostName_path.DEV"));
//
//         apiSettingPromptPay.deRegisterPromptPay(config.getString("setting_promptPay_config.hostName_path.DEV")
//                , data.getString("TC_DeRegister_PromptPay_001.TestData.crm_id")
//                , data.getString("TC_DeRegister_PromptPay_001.DeRegisterPromptPayParams.activationMode")
//                , data.getString("TC_DeRegister_PromptPay_001.DeRegisterPromptPayParams.accountNumber")
//                , "TC_DeRegister_PromptPay_001"
//                , accessToken);
//
//
//
//        response = apiSettingPromptPay.checkInquiryStatusAfterDeRegisterSuccess(
//                "0"
//                ,config.get("setting_promptPay_config.hostName_path.DEV")
//                ,"TC_DeRegister_PromptPay_001"
//                , accessToken);
//
//
//        //Insert into report
//        JSONObject result = new JSONObject();
//        result.put("api-path", config.getString("setting_promptPay_config.registerPromptPay_path"));
//        result.put("header", config.get("setting_promptPay_config.headers"));
//        result.put("expectedResult", data.getString("TC_DeRegister_PromptPay_001.Expected_Result_After_DeRegister_PromptPay"));
//        result.put("actualResult", response.asString());
//        result.put("accessToken", accessToken);
//        result.put("hostname", config.get("setting_promptPay_config.hostName_path.DEV"));
//        result.put("description", data.get("TC_DeRegister_PromptPay_001.Description"));
//
//        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2/"
//                , new Object() {
//                }.getClass().getEnclosingMethod().getName(), result.toString());
//        ExReport.printReportMessageJson(result.toJSONString());
//
//
//
//    }
//
//    @Test(groups = {"Setting PromptPay","DeRegister", "citizenID"}, priority = 4)
//    public void deRegisterPromptPayWithCitiZenIDSuccess(){
//        apiSettingPromptPay.checkInquiryStatusBeforeDeRegisterWithCitizenID("X-XXXX-XXXX8-37-6"
//                , config.get("setting_promptPay_config.hostName_path.DEV")
//                , accessToken);
//
//        accessToken = GenerateToken
//                .initialGenerateToken
//                        (data.getString("TC_DeRegister_PromptPay_002.TestData.user_name")
//                                , config.get("setting_promptPay_config.hostName_path.DEV"));
//
//        apiSettingPromptPay.deRegisterPromptPay(config.getString("setting_promptPay_config.hostName_path.DEV")
//                , data.getString("TC_DeRegister_PromptPay_002.TestData.crm_id")
//                , data.getString("TC_DeRegister_PromptPay_002.DeRegisterPromptPayParams.activationMode")
//                , data.getString("TC_DeRegister_PromptPay_002.DeRegisterPromptPayParams.accountNumber")
//                , "TC_DeRegister_PromptPay_002"
//                , accessToken);
//
//
//
//        response = apiSettingPromptPay.checkInquiryStatusAfterDeRegisterSuccess(
//                "1"
//                ,config.get("setting_promptPay_config.hostName_path.DEV")
//                ,"TC_DeRegister_PromptPay_002"
//                , accessToken);
//
//
//        //Insert into report
//        JSONObject result = new JSONObject();
//        result.put("api-path", config.getString("setting_promptPay_config.registerPromptPay_path"));
//        result.put("header", config.get("setting_promptPay_config.headers"));
//        result.put("expectedResult", data.getString("TC_DeRegister_PromptPay_002.Expected_Result_After_DeRegister_PromptPay"));
//        result.put("actualResult", response.asString());
//        result.put("accessToken", accessToken);
//        result.put("hostname", config.get("setting_promptPay_config.hostName_path.DEV"));
//        result.put("description", data.get("TC_DeRegister_PromptPay_002.Description"));
//
//        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/primarybanking2/"
//                , new Object() {
//                }.getClass().getEnclosingMethod().getName(), result.toString());
//        ExReport.printReportMessageJson(result.toJSONString());
//
//    }


//    @AfterTest(alwaysRun = false)
//    public void tearDown() {
//        APISettingPromptPay
//                .deRegisterPromptPay(config.getString("setting_promptPay_config.hostName_path.DEV")
//                        , data.getString("TC_DeRegister_PromptPay_001.TestData.crm_id")
//                        , data.getString("TC_DeRegister_PromptPay_001.DeRegisterPromptPayParams.activationMode")
//                        , data.getString("TC_DeRegister_PromptPay_001.DeRegisterPromptPayParams.accountNumber")
//                        ,"TC_DeRegister_PromptPay_001"
//                        , accessToken);
//
//        APISettingPromptPay
//                .deRegisterPromptPay(config.getString("setting_promptPay_config.hostName_path.DEV")
//                        , data.getString("TC_DeRegister_PromptPay_002.TestData.crm_id")
//                        , data.getString("TC_DeRegister_PromptPay_002.DeRegisterPromptPayParams.activationMode")
//                        , data.getString("TC_DeRegister_PromptPay_002.DeRegisterPromptPayParams.accountNumber")
//                        ,"TC_DeRegister_PromptPay_002"
//                        , accessToken);
//    }
}
