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

public class IdpConsent {

    private void GetIDPConsent(String testCaseID, Boolean isScenario, String CrmId, String expected, String body, int DeviceId, String Statusidp, String Scenerios, String UserToken) throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation()
                .param("status", Statusidp)
                .auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("apis/customer/ekyc/idpconsent").then().assertThat().extract().response();


        JSONObject json = (JSONObject) new JSONParser().parse(response.getBody().asString());
        JSONObject jsonStatus = (JSONObject) json.get("data");
        JsonPath jsonPath = new JsonPath(response.asString());
        String AccessToken = jsonPath.getString("status.code");
        System.err.println("jsonObj1 : " + AccessToken);
        boolean isOK;
        System.err.println(response.getStatusCode());
        if (isScenario == true || DeviceId == 1) {
            System.err.println(response.getStatusCode());
            isOK = (response.getStatusCode() == 200);

        } else {
            isOK = (response.getStatusCode() == 400);
            
        }
        System.err.println("isOk : " + isOK);
        
        Assert.assertTrue(isOK);
        
        if (DeviceId != 3) {
            String status = jsonPath.getString("data.status");
            Assert.assertTrue(status.equals(Statusidp));
        }

        
    }

    private void GetIDPConsent02(String testCaseID, Boolean isScenario, String CrmId, String expected, String body, int DeviceId, String Statusidp, String Scenerios, String UserToken) throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation()
                .param("status", Statusidp)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("apis/customer/ekyc/idpconsent").then().assertThat().extract().response();


        JSONObject json = (JSONObject) new JSONParser().parse(response.getBody().asString());
        JSONObject jsonStatus = (JSONObject) json.get("data");
        JsonPath jsonPath = new JsonPath(response.asString());
        String AccessToken = jsonPath.getString("status.code");;
        System.err.println("jsonObj1 : " + AccessToken);
        boolean isOK;
        System.err.println(response.getStatusCode());
        isOK = (response.getStatusCode() == 401);
        System.err.println("isOk : " + isOK);
        
        Assert.assertTrue(isOK);
        
    }

    @Test(priority = 0)
    void IDPConsent01() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidIdpconsent_001";
        String expected = "Validate response for Verify success in case confirmed ipdconsent";
        String CrmId = "001100000000000000000012037451";
        String body = "{ \n" +
                "    \"reference_id\": \"a72a6787-18b7-4255-8cc8-3c1907ca19d6\",  \n" +
                "    \"response_code\": 0,\n" +
                "    \"status\": \"confirmed\"\n" +
                "}";
        String status = "confirmed";
        GetIDPConsent(testCaseID, true, CrmId, expected, body, 1, status, "NDID Idpconsent in case success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }

    @Test(priority = 1)
    void IDPConsent02() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidIdpconsent_002";
        String expected = "Validate response for Verify success in case denied ipdconsent";
        String CrmId = "001100000000000000000012037451";
        String body = "{ \n" +
                "    \"reference_id\": \"173ec864-240e-4de1-b74f-fc9656235b23\",  \n" +
                "    \"response_code\": 0,\n" +
                "    \"status\": \"denied\"\n" +
                "}";
        String status = "denied";
        GetIDPConsent(testCaseID, false, CrmId, expected, body, 1, status, "NDID Authen in case success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }

    @Test(priority = 2)
    void IDPConsent03() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidIdpconsent_003";
        String expected = "Validate response for Verify success in case time out ipdconsent";
        String CrmId = "001100000000000000000012037451";
        String body = "{ \n" +
                "    \"reference_id\": \"22eccff0-d426-4462-8f35-d45876ae65f4\",  \n" +
                "    \"response_code\": 30400,\n" +
                "    \"status\": \"other\"\n" +
                "}";
        String status = "other";
        GetIDPConsent(testCaseID, false, CrmId, expected, body, 1, status, "NDID Authen in case success", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }

    @Test(priority = 3)
    void IDPConsent04() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidIdpconsent_004";
        String expected = "Validate response for Bad Request";
        String CrmId = "001100000000000000000012037451";
        String body = "";
        String status = "other";
        GetIDPConsent(testCaseID, false, CrmId, expected, body, 3, status, "NDID Authen In case fail", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }

    @Test(priority = 3)
    void IDPConsent05() throws ParseException, IOException {
        String testCaseID = "TS_OneApp_API_NdidIdpconsent_005";
        String expected = "Validate response for Unauthorized";
        String CrmId = "001100000000000000000012037451";
        String body = "{ \"reference_id\": \"af460b29-0faa-4757-9f59-db8f2dd6d2a2\",  \"response_code\": 30400 }";
        String status = "other";
        GetIDPConsent02(testCaseID, false, CrmId, expected, body, 2, status, "NDID Authen In case fail", "DxIID5TtLE7E+q6cp0ujfUMIXU/wkJPewkM9CZ+DqAqDoGZc8Z8Ple3Is6K/6XNAGt2f7veQJrb1oUgwBZPIsCus7eW9sSDIIVcjwxVQeOTUuasnNwUMnciuzBcTMUYYoy5Mpb4DmU87g5fgdwA5RzPnlij7fqCse19nzWfMU/DX4HkFahs7o5kaFSZWqH+5S5zue1vxnulTGDnN4EIQzrsbgrZWZCFMDP04O0Jcp4S6er3NX0CyVxr/V8b1E7gjtwcnrZVQIbbicdwMRLgl3zTuTLf44Zz+yCQohRTLvc/cKJjbNRi4zAjt3LCK5ZhPOvP7MtKDm/xP3jia3ctzCg==");
    }
}
