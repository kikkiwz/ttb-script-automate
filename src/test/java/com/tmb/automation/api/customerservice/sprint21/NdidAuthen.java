package com.tmb.automation.api.customerservice.sprint21;

import com.tmb.automation.api.customerservice.GetJsonData;
import com.tmb.automation.api.customerservice.ViewVirtualPassbook;
import com.aventstack.extentreports.Status;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class NdidAuthen  {

    public static String BiometricConsent(String UserToken, String body) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(UserToken).log().all()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .get("apis/customer/ekyc/ndidAuthen").then().assertThat().extract().response().asString();

        return response;
    }

    private void GetNdidAuthen(String testCaseID, Boolean isScenario, String CrmId, String expected, String body, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("apis/customer/ekyc/ndidAuthen").then().assertThat().extract().response();


        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonStatus =  (JSONObject)json.get("data");
        JsonPath jsonPath = new JsonPath(response.asString());
        String AccessToken = jsonPath.getString("status.code");
        System.err.println("jsonObj1 : " + AccessToken);
        boolean isOK;
        System.err.println(response.getStatusCode());
        if(isScenario == true || DeviceId == 1){
            System.err.println(response.getStatusCode());
            isOK = (response.getStatusCode() == 200);

        }else{
            isOK = (response.getStatusCode() == 400);
            
        }
        System.err.println("isOk : " + isOK);
        
        Assert.assertTrue(isOK);
            }

    private void GetNdidAuthen2(String testCaseID, Boolean isScenario, String expected, String CrmId, String body, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {


        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("apis/customer/ekyc/ndidAuthen").then().assertThat().extract().response();


        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonStatus =  (JSONObject)json.get("data");
        JsonPath jsonPath = new JsonPath(response.asString());
        String AccessToken = jsonPath.getString("status.code");
        System.err.println("jsonObj1 : " + AccessToken);
        boolean isOK;
        System.err.println(response.getStatusCode());
        isOK = (response.getStatusCode() == 401);
        System.err.println("isOk : " + isOK);
       
        Assert.assertTrue(isOK);
        
    }


    private void GetBiometricConsent(String testCaseID, Boolean isScenario, String CrmId, String body, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("apis/customers/ekyc/biometricConsent").then().assertThat().extract().response();

    }

//    @Test(priority = 0)
//    void BiometricConsent01() throws ParseException, IOException {
//        String testCaseID = "Validate response for success";
//        String CrmId = "001100000000000000000012037178";
//        String body = "{\n" +
//                "  \"acceptance\": \"N\",\n" +
//                "  \"version\": \"1.00\"\n" +
//                "}";
//        GetBiometricConsent(testCaseID, true, CrmId, body, 1, "Term and Condition In case Success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
//    }

    @Test(priority = 0)
    void NdidAuthen01() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidAuthen_001";
        String expected = "Validate response for Verify success  in case biometric consent flag N";
        String CrmId = "001100000000000000000012037451";
        GetJsonData bodyObject = new GetJsonData();
        String body = bodyObject.setNdidAcceptance().toString();
        GetNdidAuthen(testCaseID, true, CrmId, expected, body, 1, "NDID Authen in case success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }



    @Test(priority = 1)
    void BiometricConsent02() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000012037178";
        String body = "{\n" +
                "  \"acceptance\": \"Y\",\n" +
                "  \"version\": \"1.00\"\n" +
                "}";
        GetBiometricConsent(testCaseID, false, CrmId, body, 1, "Term and Condition In case Success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }

    @Test(priority = 2)
    void NdidAuthen02() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidAuthen_002";
        String expected = "Validate response for success in case biometric consent flag Y";
        String CrmId = "001100000000000000000012037451";
        String body = "{\n" +
                "  \"min_aal\": \"2.2\",\n" +
                "  \"min_ial\": \"2.3\",\n" +
                "  \"reference_id\": \"2dc37e20-a440-4566-9e93-7369b2f20c97\"\n" +
                "}";
        GetNdidAuthen(testCaseID, false, CrmId, expected, body, 1, "Term and Condition In case Success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }


    @Test(priority = 3)
    void NdidAuthen03() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidAuthen_003";
        String expected = "Validate response for success in case You cannot verify your identity via the National Digital ID Platform (NDID) then status code ndid_001";
        String CrmId = "001100000000000000000012037178";
        String body = "{\n" +
                "  \"min_aal\": \"2.1\",\n" +
                "  \"min_ial\": \"2.3\",\n" +
                "  \"reference_id\": \"2dc37e20-a440-4566-9e93-7369b2f20c97\"\n" +
                "}";
        GetNdidAuthen(testCaseID, false, CrmId, expected, body, 1, "Term and Condition In case Success", "RlzlayT1bFvctTdoKE57RyEHPEkxZW4XcwPjF5ojooYwG5LhSIofKT6MDJMrLKmiVMrVsse/Xp+31fn0px62/m4FMbF7LUu6k1C7UYkUlxTHBwyCKZ4Wn91LtgNyeUcatMEXZROMs972u7nbz0uFmELAv1ww48X/cNDgp4R4G18OEx6iRm3Ga5/iEXJvb4cIJE5G7GsoOXmnqkAy1TkMci+1I9q4ExKPBDXNW4IUeRBYTPzHVhm8Guo7HwtJK3la6QwsnDRqesyCc7pzDfS2OTyrHDrbgTsupQ8blOomZIJRHAiqxmgUVVAJceln5n/gH5eMHe+fYIP2lAqSQHGYZw==");
    }

    @Test(priority = 4)
    void NdidAuthen04() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidAuthen_004";
        String expected = "Validate response for success in case You cannot verify your identity via the National Digital ID Platform (NDID) then status code ndid_002";
        String CrmId = "001100000000000000000012037178";
        String body = "{\n" +
                "  \"min_aal\": \"2.2\",\n" +
                "  \"min_ial\": \"2.3\",\n" +
                "  \"reference_id\": \"2dc37e20-a440-4566-9e93-7369b2f20c97\"\n" +
                "}";
        GetNdidAuthen(testCaseID, false, CrmId, expected, body, 1, "Term and Condition In case Success", "RlzlayT1bFvctTdoKE57RyEHPEkxZW4XcwPjF5ojooYwG5LhSIofKT6MDJMrLKmiVMrVsse/Xp+31fn0px62/m4FMbF7LUu6k1C7UYkUlxTHBwyCKZ4Wn91LtgNyeUcatMEXZROMs972u7nbz0uFmELAv1ww48X/cNDgp4R4G18OEx6iRm3Ga5/iEXJvb4cIJE5G7GsoOXmnqkAy1TkMci+1I9q4ExKPBDXNW4IUeRBYTPzHVhm8Guo7HwtJK3la6QwsnDRqesyCc7pzDfS2OTyrHDrbgTsupQ8blOomZIJRHAiqxmgUVVAJceln5n/gH5eMHe+fYIP2lAqSQHGYZw==");
    }

    @Test(priority = 5)
    void NdidAuthen05() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidAuthen_005";
        String expected = "Validate response for success in case You cannot verify your identity via the National Digital ID Platform (NDID) then status code ndid_003";
        String CrmId = "001100000000000000000012037451";
        String body = "{\n" +
                "  \"min_aal\": \"2.2\",\n" +
                "  \"min_ial\": \"2.3\",\n" +
                "  \"reference_id\": \"2dc37e20-a440-4566-9e93-7369b2f20c97\"\n" +
                "}";
        GetNdidAuthen(testCaseID, false, CrmId, expected, body, 1, "Term and Condition In case Success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }

    @Test(priority = 6)
    void NdidAuthen06() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidAuthen_006";
        String expected = "Validate response for Bad Request";
        String CrmId = "001100000000000000000012037178";
        String body = "";
        GetNdidAuthen(testCaseID, false, CrmId, expected, body, 3, "NDID Authen In case fail", "RlzlayT1bFvctTdoKE57RyEHPEkxZW4XcwPjF5ojooYwG5LhSIofKT6MDJMrLKmiVMrVsse/Xp+31fn0px62/m4FMbF7LUu6k1C7UYkUlxTHBwyCKZ4Wn91LtgNyeUcatMEXZROMs972u7nbz0uFmELAv1ww48X/cNDgp4R4G18OEx6iRm3Ga5/iEXJvb4cIJE5G7GsoOXmnqkAy1TkMci+1I9q4ExKPBDXNW4IUeRBYTPzHVhm8Guo7HwtJK3la6QwsnDRqesyCc7pzDfS2OTyrHDrbgTsupQ8blOomZIJRHAiqxmgUVVAJceln5n/gH5eMHe+fYIP2lAqSQHGYZw==");
    }

    @Test(priority = 7)
    void NdidAuthen07() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidAuthen_007";
        String expected = "Validate response for Unauthorized";
        String CrmId = "001100000000000000000012037178";
        GetJsonData bodyObject = new GetJsonData();
        String body = bodyObject.setBiometric().toString();
        GetNdidAuthen2(testCaseID, false, CrmId, expected, body, 2, "NDID Authen In case Success", "");
    }
}
