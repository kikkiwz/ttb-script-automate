package com.tmb.automation.test.primarybanking2.APITest.SettingPromptpay;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tmb.automation.helper.Helper;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APISettingPromptPay {

    public static Map<String, String> headersInquiryPromptPay = new HashMap<>();

    public static Map<String, String> headersRegisterPromptPay = new HashMap<>();

    private static String accessToken = "";
    public static Response response;
    public static Object object;

    private static final JsonPath data = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/DataTest/setting_promptpay.json"));


    private static final JsonPath config = new JsonPath(Lib.getInput(System.getProperty("user.dir")
            + "/src/test/java/com/ttbbank/oneapp/scenario/primarybanking2/Config/setting_promptpay_config.json"));




    public static Response promptPayInquiry(String accessToken, String environment) {

        headersInquiryPromptPay.put("X-Correlation-ID", Helper.generateCorrelationId());
        headersInquiryPromptPay.put("Authorization", "Bearer" +" "+ accessToken);
        headersInquiryPromptPay.put("Content-Type", "application/json");

        Response response
                = (Response) given().relaxedHTTPSValidation().accept(ContentType.JSON).headers(headersInquiryPromptPay)
                .when().get(environment+"/apis/customer/promptpay/inquiry")
                .then().assertThat().log().all().extract();

        return response;


    }

    public static Response registerPromptPay
            (String environment, String activationMode
                    , String accountNumber, String bankCode, String accessToken){
        headersRegisterPromptPay.put("X-Correlation-ID", Helper.generateCorrelationId());
        headersRegisterPromptPay.put("X-CRM-ID","" );
        headersRegisterPromptPay.put("Authorization","Bearer" +" "+ accessToken);
        headersRegisterPromptPay.put("Content-Type", "application/json");
        headersRegisterPromptPay.put("Cookie","");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("activationMode", activationMode);
        parameters.put("accountNumber", accountNumber);
        parameters.put("bankCode", bankCode);

        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(parameters);


        Response response = (Response)
                given().headers(headersRegisterPromptPay).accept(ContentType.JSON).relaxedHTTPSValidation()
                        .body(jsonObject.toJSONString()).when().post(environment+"/apis/customer/promptpay/activate")
                        .then().assertThat().log().all().extract().response();

        return response;
    }





    @Test
    public void checkInquiryStatusBeforeRegister(String expectedMobileNo
                                                , String expectedCitizenID, String path, String accessToken) {

        // PromptPayInquiry
        Response response =
                APISettingPromptPay.promptPayInquiry(accessToken
                        , path);

        JsonPath jsonPathAfterRegister = response.jsonPath();
        jsonPathAfterRegister.get("data");

        //mobileNo
        Assert.assertEquals(jsonPathAfterRegister.getString("data[0].phoneNo"), expectedMobileNo);
        Assert.assertEquals(jsonPathAfterRegister.getString("data[0].status"), "NOT REGISTERED");

        //citizenID
        Assert.assertEquals(jsonPathAfterRegister.getString("data[1].citizenId"), expectedCitizenID);
        Assert.assertEquals(jsonPathAfterRegister.getString("data[1].status"), "NOT REGISTERED");

    }

    @Test
    public void checkInquiryStatusBeforeRegisterWithCitizenID(String expectedCitizenID, String path, String accessToken) {

        // PromptPayInquiry
        Response response =
                APISettingPromptPay.promptPayInquiry(accessToken
                        , path);

        JsonPath jsonPathAfterRegister = response.jsonPath();
        jsonPathAfterRegister.get("data");


        //citizenID
        Assert.assertEquals(jsonPathAfterRegister.getString("data[1].citizenId"), expectedCitizenID);
        Assert.assertEquals(jsonPathAfterRegister.getString("data[1].status"), "NOT REGISTERED");

    }

    @Test
    public void checkInquiryStatusBeforeRegisterWithMobileNo(String expectedMobileNo, String path, String accessToken) {

        // PromptPayInquiry
        Response response =
                APISettingPromptPay.promptPayInquiry(accessToken
                        , path);

        JsonPath jsonPathAfterRegister = response.jsonPath();
        jsonPathAfterRegister.get("data");

        //mobileNo
        Assert.assertEquals(jsonPathAfterRegister.getString("data[0].phoneNo"), expectedMobileNo);
        Assert.assertEquals(jsonPathAfterRegister.getString("data[0].status"), "NOT REGISTERED");


    }



    @Test
    public void registerPromptPaySuccess(String path
                                                     , String activationMode
                                                     , String accountNumber
                                                     , String bankCode
                                                     , String testCaseNo
                                                     , String accessToken) throws JsonProcessingException {
        response
                = APISettingPromptPay.registerPromptPay(path
                , activationMode
                , accountNumber
                , bankCode
                , accessToken);

        //check HTTP status code
        int statusCode = response.getStatusCode();
        Assert.assertTrue(statusCode == 200);

        JsonPath jsonPathAfterRegister = response.jsonPath();
        jsonPathAfterRegister.get("status");

        //Verify response after registration success
        Assert.assertEquals(jsonPathAfterRegister.get("status.code")
                ,data.getString(testCaseNo+".ResponseBody.status.code"));
        Assert.assertEquals(jsonPathAfterRegister.get("status.message")
                ,data.getString(testCaseNo+".ResponseBody.status.message"));
        Assert.assertEquals(jsonPathAfterRegister.get("status.service")
                ,data.getString(testCaseNo+".ResponseBody.status.service"));
        Assert.assertEquals(jsonPathAfterRegister.get("status.description")
                ,data.getString(testCaseNo+".ResponseBody.status.description"));

    }

    @Test
    public Response checkInquiryStatusAfterRegisterSuccess(String jsonIndex
            , String path
            , String testcaseNo
            , String accessToken) {

        //Calling PPInquiry after registration success
        Response response =
                APISettingPromptPay.promptPayInquiry(accessToken, path);

        JsonPath jsonPathInquiryAfterRegister = response.jsonPath();
        jsonPathInquiryAfterRegister.get("data");

        //Verify PPInquiry response after registration success
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].statusDesc")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.statusDesc"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].accountNumber")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.accountNumber"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].citizenId")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.citizenId"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].status")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.status"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].phoneNo")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.phoneNo"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].activationMode")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.activationMode"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].bankCode")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.bankCode"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].bankNameTh")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.bankNameTh"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].bankNameEn")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.bankNameEn"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].productNameEn")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.productNameEn"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].productNameTh")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.productNameTh"));
        Assert.assertEquals
                (jsonPathInquiryAfterRegister.getString("data["+jsonIndex+"].bankShortname")
                        , data.getString(testcaseNo+".Expected_Result_After_Register_PromptPay.bankShortname"));

        return response;
    }

    @Test
    public void checkInquiryStatusBeforeDeRegister(String expectedMobileNo
            , String expectedCitizenID, String path, String accessToken) {

        // PromptPayInquiry
        Response response =
                APISettingPromptPay.promptPayInquiry(accessToken
                        , path);

        JsonPath jsonPathAfterRegister = response.jsonPath();
        jsonPathAfterRegister.get("data");

        //mobileNo
        Assert.assertEquals(jsonPathAfterRegister.getString("data[0].phoneNo"), expectedMobileNo);
        Assert.assertEquals(jsonPathAfterRegister.getString("data[0].status"), "REGISTERED");

        //citizenID
        Assert.assertEquals(jsonPathAfterRegister.getString("data[1].citizenId"), expectedCitizenID);
        Assert.assertEquals(jsonPathAfterRegister.getString("data[1].status"), "REGISTERED");

    }
    @Test
    public void checkInquiryStatusBeforeDeRegisterWithMobileNo(String expectedMobileNo, String path, String accessToken) {

        // PromptPayInquiry
        Response response =
                APISettingPromptPay.promptPayInquiry(accessToken
                        , path);

        JsonPath jsonPathAfterRegister = response.jsonPath();
        jsonPathAfterRegister.get("data");

        //mobileNo
        Assert.assertEquals(jsonPathAfterRegister.getString("data[0].phoneNo"), expectedMobileNo);
        Assert.assertEquals(jsonPathAfterRegister.getString("data[0].status"), "REGISTERED");


    }
    @Test
    public void checkInquiryStatusBeforeDeRegisterWithCitizenID(String expectedCitizenID, String path, String accessToken) {

        // PromptPayInquiry
        Response response =
                APISettingPromptPay.promptPayInquiry(accessToken
                        , path);

        JsonPath jsonPathAfterRegister = response.jsonPath();
        jsonPathAfterRegister.get("data");

        //citizenID
        Assert.assertEquals(jsonPathAfterRegister.getString("data[1].citizenId"), expectedCitizenID);
        Assert.assertEquals(jsonPathAfterRegister.getString("data[1].status"), "REGISTERED");

    }

    @Test
    public static void deRegisterPromptPay
            (String environment
                    , String xCRMID
                    , String activationMode
                    , String accountNumber
                    , String testCaseNo
                    , String accessToken){

        headersRegisterPromptPay.put("X-Correlation-ID", Helper.generateCorrelationId());
        headersRegisterPromptPay.put("X-CRM-ID",xCRMID);
        headersRegisterPromptPay.put("Authorization","Bearer" +" "+ accessToken);
        headersRegisterPromptPay.put("Content-Type", "application/json");
        headersRegisterPromptPay.put("Cookie","eb911a1df66b3f243135173f0fd323ef=f393b79626f154e5255b8ef4ead1c9b7");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("activationMode", activationMode);
        parameters.put("accountNumber", accountNumber);

        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(parameters);


        Response response = (Response)
                given().headers(headersRegisterPromptPay).accept(ContentType.JSON).relaxedHTTPSValidation()
                        .body(jsonObject.toJSONString()).when().post(environment+"/apis/customer/promptpay/deactivate")
                        .then().assertThat().log().all().extract().response();

//        ResponseBody responseService = response.getBody();
//        System.out.println("\n\n" + responseService.asString());
        JsonPath jsonPathAfterDeRegister = response.jsonPath();
        jsonPathAfterDeRegister.get("status");

        //Verify response after registration success
        Assert.assertEquals(jsonPathAfterDeRegister.get("status.code")
                ,data.getString(testCaseNo+".ResponseBody.status.code"));
        Assert.assertEquals(jsonPathAfterDeRegister.get("status.message")
                ,data.getString(testCaseNo+".ResponseBody.status.message"));
        Assert.assertEquals(jsonPathAfterDeRegister.get("status.service")
                ,data.getString(testCaseNo+".ResponseBody.status.service"));
        Assert.assertEquals(jsonPathAfterDeRegister.get("status.description")
                ,data.getString(testCaseNo+".ResponseBody.status.description"));


    }

    @Test
    public Response checkInquiryStatusAfterDeRegisterSuccess(String jsonIndex
            , String path
            , String testcaseNo
            , String accessToken) {

        //Calling PPInquiry after registration success
        Response response =
                APISettingPromptPay.promptPayInquiry(accessToken, path);

        JsonPath jsonPathInquiryAfterDeRegister = response.jsonPath();
        jsonPathInquiryAfterDeRegister.get("data");

        //Verify PPInquiry response after registration success
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].statusDesc")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.statusDesc"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].accountNumber")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.accountNumber"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].citizenId")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.citizenId"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].status")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.status"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].phoneNo")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.phoneNo"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].activationMode")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.activationMode"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].bankCode")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.bankCode"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].bankNameTh")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.bankNameTh"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].bankNameEn")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.bankNameEn"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].productNameEn")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.productNameEn"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].productNameTh")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.productNameTh"));
        Assert.assertEquals
                (jsonPathInquiryAfterDeRegister.getString("data["+jsonIndex+"].bankShortname")
                        , data.getString(testcaseNo+".Expected_Result_After_DeRegister_PromptPay.bankShortname"));

        return response;
    }

}
