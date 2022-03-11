package com.tmb.automation.api.customerservice.sprint21;

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

public class AdvisorInfo {

    public static String AdvisorInfoUI(String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(UserToken).log().all()
                .header("Content-Type", "application/json")
                .when()
                .get("apis/customer/getAdvisorInfo").then().assertThat().extract().response().asString();

        return response;
    }

    private void GetAdvisorInfo(String testCaseID, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("Content-Type", "application/json")
                .when()
                .get("apis/customer/getAdvisorInfo").then().assertThat().extract().response();


        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonStatus =  (JSONObject)json.get("data");
        JsonPath jsonPath = new JsonPath(response.asString());
        String AccessToken = jsonPath.getString("status.code");
        System.err.println("jsonObj1 : " + AccessToken);
        boolean isOK;
        if(isScenario == true || DeviceId == 1){
            System.err.println(response.getStatusCode());
            isOK = (response.getStatusCode() == 200);

        }else{
            isOK = (response.getStatusCode() == 400);
        }
        System.err.println("isOk : " + isOK);
       
        Assert.assertTrue(isOK);
        

    }

    private void GetAdvisorInfo2(String testCaseID, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .when()
                .get("apis/customer/getAdvisorInfo").then().assertThat().extract().response();

        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonObj1 =  (JSONObject)json.get("data");
        System.err.println("jsonObj1 : " + jsonObj1);
        boolean isOK;
        if(isScenario == true && DeviceId == 1){
            System.err.println(response.getStatusCode());
            isOK = (response.getStatusCode() == 200);
        }else{
            System.err.println(jsonObj1);
            isOK = (response.getStatusCode() == 401);
        }
        System.err.println("isOk : " + isOK);
        
        Assert.assertTrue(isOK);
            }

    @Test(priority = 0)
    void ApplicationStatusTracking01() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000001184383";
        GetAdvisorInfo(testCaseID, true, CrmId, 1, "Term and Condition In case Success", "G6gs+o2EwQx9qFWQS/9K3AIJaBpdGGGMsd+rhErRFQjz61V6eZ1hpmGibE+yOqGl76LRXF1CE5VKSABVZruGJb/n3iyRL/Xx4pH6Q+AIZjyISb5271+dx8ZwJ4WFgF0WYPOf+fKIP3aFEp9wX6UJzR1ZsOpfgDZzzHLy8w2nrHWQ7LYSibcGdl1RwPRlDQgJbsGbpbzKWp9T4467ukrbnIg/id9RDe7ru/SIewrzhTlkvKNqigELr8OfkGvuEtydMAd35kmgbJAczigiH99pLERcqqUAInBSurEf8DJY97kxPkCOmIe+ryl/slQYh0KTX4pBcz3H36C9B7YbkyQN+A==");
    }
    @Test(priority = 1)
    void ApplicationStatusTracking02() throws ParseException, IOException {
        String testCaseID = "Validate response for Unauthorized";
        String CrmId = "001100000000000000000001184383";
        GetAdvisorInfo2(testCaseID, false, CrmId, 2, "Term and Condition In case Unauthorized", "");
    }
}
