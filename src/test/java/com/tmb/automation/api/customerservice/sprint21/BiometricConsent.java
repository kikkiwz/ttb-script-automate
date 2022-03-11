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

public class BiometricConsent {

    public static String  GetBiometricConsent_ForDEMO(String body, String UserToken) throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(UserToken).log().all()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("apis/customers/ekyc/biometricConsent").then().assertThat().extract().response().asString();
        return response;
    }

    private void GetBiometricConsent(String testCaseID, Boolean isScenario, String CrmId, String body, int DeviceId, String expected, String Scenerios, String UserToken) throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("apis/customers/ekyc/biometricConsent").then().assertThat().extract().response();


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
                .post("apis/customers/ekyc/biometricConsent").then().assertThat().extract().response();


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
        String testCaseID = "TS_OneApp_API_BioMetricConsent_001";
        String expected = "Validate response success for NDID BiometricConsent";
        String CrmId = "001100000000000000000012037178";
        GetJsonData bodyObject = new GetJsonData();
        String body = bodyObject.setBiometric().toString();
        GetBiometricConsent(testCaseID, true, CrmId, body, 1, expected, "NDID BiometricConsent", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }

    @Test(priority = 1)
    void BiometricConsent02() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_BioMetricConsent_002";
        String expected = "Validate response Bad Request for NDID BiometricConsent";
        String CrmId = "001100000000000000000012037178";
        String body = "";
        GetBiometricConsent(testCaseID, false, CrmId, body, 2, expected, "Term and Condition In case Success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }

    @Test(priority = 1)
    void BiometricConsent03() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_BioMetricConsent_003";
        String CrmId = "001100000000000000000012037178";
        GetJsonData bodyObject = new GetJsonData();
        String body = bodyObject.setBiometric().toString();
        GetBiometricConsent2(testCaseID, false, CrmId, body, 2, "Term and Condition In case Success", "");
    }


}
