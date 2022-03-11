package com.tmb.automation.api.customerservice;

import com.aventstack.extentreports.Status;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.UUID;

public class firstTimeUsage  {

    private void firstTimeUsageGet(String testCaseID, Boolean isScenario, String CrmId, String DeviceId, String Scenerios) throws IOException, ParseException {

        RestAssured.baseURI = "https://apis-portal.oneapp.tmbbank.local/";
        Response response = given().relaxedHTTPSValidation().log().all()
                .header("device-id", DeviceId)
                .header("Content-Type", "application/json")
                .header("x-crmid", CrmId)
                .when()
                .get("apis/customers/firstTimeUsage?serviceTypeId=EPB").then().assertThat().extract().response();

        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonObj1 =  (JSONObject)json.get("data");
        boolean isOK;
        if(isScenario == true){
            System.err.println(response.getStatusCode());
            isOK = (response.getStatusCode() == 200);
        }else{
            System.err.println(jsonObj1);
            isOK = (response.getStatusCode() == 400);
        }
       
        Assert.assertTrue(isOK);
        
    }

    private void firstTimeUsagePost(String testCaseID, Boolean isScenario, String CrmId, String DeviceId, String Scenerios) throws IOException, ParseException {

        RestAssured.baseURI = "https://apis-portal.oneapp.tmbbank.local/";
        Response response = given().relaxedHTTPSValidation().log().all()
                .header("device-id", DeviceId)
                .header("Content-Type", "application/json")
                .header("x-crmid", CrmId)
                .when()
                .post("apis/customers/firstTimeUsage?serviceTypeId=EPB").then().assertThat().extract().response();

        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonObj1 =  (JSONObject)json.get("data");
        boolean isOK;
        if(isScenario == true){
            System.err.println(jsonObj1);
            isOK = (response.getStatusCode() == 200);
        }else{
            System.err.println(jsonObj1);
            isOK = (response.getStatusCode() == 400);
        }
        Assert.assertTrue(isOK);
            }


    @Test(priority = 1)
    void verifyfirstTimeUsage00() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000000086006";
        firstTimeUsageGet(testCaseID, true, CrmId, "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da", "First Time Usage");
    }

    @Test(priority = 2)
    void verifyfirstTimeUsage01() throws ParseException, IOException {
        String testCaseID = "Validate response for failed";
        String CrmId = "001100000000000000000000086066";
        firstTimeUsageGet(testCaseID, false, CrmId, "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da","First Time Usage");
    }
    //insert success
    @Test(priority = 3)
    void verifyfirstTimeUsage02() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000000086076";
        firstTimeUsagePost(testCaseID, true, CrmId, "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da", "Insert First Time Usage Success");
    }

    //input crmid more than 30 digit
    @Test(priority = 4)
    void verifyfirstTimeUsage03() throws ParseException, IOException {
        String testCaseID = "Validate response for failed with an input crm id more than 30 digits";
        String CrmId = "0011000000000000000000000860767777777";
        firstTimeUsagePost(testCaseID, false, CrmId, "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da", "Insert First Time Usage Fail");
    }

    // crm_id (Empty String)
    @Test(priority = 5)
    void verifyfirstTimeUsage04() throws ParseException, IOException {
        String testCaseID = "Validate response for failed with an empty crm id";
        String CrmId = " ";
        firstTimeUsagePost(testCaseID, false, CrmId, "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da", "");
    }

    @Test(priority = 6)
    void verifyfirstTimeUsage05() throws ParseException, IOException {
        String testCaseID = "Validate response for success after insert first time usage";
        String CrmId = "001100000000000000000000086076";
        firstTimeUsageGet(testCaseID, true, CrmId, "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da", "After insert first time usage");
    }


    @Test(priority = 7)
    public void saving(String testCaseID, Boolean isScenario, String CrmId, String DeviceId, String Scenerios) throws IOException, ParseException {

        RestAssured.baseURI = "https://apis-portal.oneapp.tmbbank.local/";
        Response response = given().relaxedHTTPSValidation().log().all()
                .header("X-Correlation-ID", "32fbd3b2-3f97-4a89-ar39-b4f628fbc8da")
                .header("Content-Type", "application/json")
                .header("x-crmid", "001100000000000000000012004043")
                .when()
                .get("apis/customer/accounts/saving").then().assertThat().extract().response();

        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        System.err.println(json);
    }

}
