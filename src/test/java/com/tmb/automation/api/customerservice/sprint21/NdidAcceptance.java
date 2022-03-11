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

public class NdidAcceptance {

    private void GetBiometricConsent(String testCaseID, Boolean isScenario, String CrmId, String body, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("apis/customer/customers/ekyc/ndidAcceptance").then().assertThat().extract().response();


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

    private void GetBiometricConsent2(String testCaseID, Boolean isScenario, String CrmId, String body, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {


        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("apis/customer/customers/ekyc/ndidAcceptance").then().assertThat().extract().response();


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

    @Test(priority = 0)
    void BiometricConsent01() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000012037178";
        GetJsonData bodyObject = new GetJsonData();
        String body = bodyObject.setNdidAcceptance().toString();
        GetBiometricConsent(testCaseID, true, CrmId, body, 1, "Term and Condition In case Success", "RlzlayT1bFvctTdoKE57RyEHPEkxZW4XcwPjF5ojooYwG5LhSIofKT6MDJMrLKmiVMrVsse/Xp+31fn0px62/m4FMbF7LUu6k1C7UYkUlxTHBwyCKZ4Wn91LtgNyeUcatMEXZROMs972u7nbz0uFmELAv1ww48X/cNDgp4R4G18OEx6iRm3Ga5/iEXJvb4cIJE5G7GsoOXmnqkAy1TkMci+1I9q4ExKPBDXNW4IUeRBYTPzHVhm8Guo7HwtJK3la6QwsnDRqesyCc7pzDfS2OTyrHDrbgTsupQ8blOomZIJRHAiqxmgUVVAJceln5n/gH5eMHe+fYIP2lAqSQHGYZw==");
    }

    @Test(priority = 1)
    void BiometricConsent02() throws ParseException, IOException {
        String testCaseID = "Validate response for Bad Request";
        String CrmId = "001100000000000000000012037178";
        String body = "";
        GetBiometricConsent(testCaseID, false, CrmId, body, 2, "Term and Condition In case Success", "RlzlayT1bFvctTdoKE57RyEHPEkxZW4XcwPjF5ojooYwG5LhSIofKT6MDJMrLKmiVMrVsse/Xp+31fn0px62/m4FMbF7LUu6k1C7UYkUlxTHBwyCKZ4Wn91LtgNyeUcatMEXZROMs972u7nbz0uFmELAv1ww48X/cNDgp4R4G18OEx6iRm3Ga5/iEXJvb4cIJE5G7GsoOXmnqkAy1TkMci+1I9q4ExKPBDXNW4IUeRBYTPzHVhm8Guo7HwtJK3la6QwsnDRqesyCc7pzDfS2OTyrHDrbgTsupQ8blOomZIJRHAiqxmgUVVAJceln5n/gH5eMHe+fYIP2lAqSQHGYZw==");
    }

    @Test(priority = 1)
    void BiometricConsent03() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000012037178";
        GetJsonData bodyObject = new GetJsonData();
        String body = bodyObject.setBiometric().toString();
        GetBiometricConsent2(testCaseID, false, CrmId, body, 2, "Term and Condition In case Success", "");
    }
}
