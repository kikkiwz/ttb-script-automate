package com.tmb.automation.api.customerservice.sprint25;

import com.tmb.automation.api.customerservice.ViewVirtualPassbook;
import com.aventstack.extentreports.Status;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GeneratePDF {

    private void ApplicationStatusTrackingGet(String testCaseID, String body, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("x-correlation-id", "TestApi_5")
                .header("Content-Type", "application/json")
                .header("appect", "*/*")
                .body(body)
                .when()
                .post("apis/customer/financialcert/generate").then().assertThat().extract().response();


        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonStatus =  (JSONObject)json.get("status.code");
        System.err.println("jsonObj1 : " + jsonStatus);
        boolean isOK;
        if(isScenario == true || DeviceId == 1){
            System.err.println(response.getStatusCode());
            isOK = (response.getStatusCode() == 200);

            Assert.assertTrue(isOK);
        }else{
            isOK = (response.getStatusCode() == 400);
        }
        System.err.println("isOk : " + isOK);
       
        Assert.assertTrue(isOK);
        
    }

    private void ApplicationStatusTrackingGet2(String testCaseID, String body, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().auth().oauth2("aasdasd").log().all()
                .header("x-correlation-id", "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da")
                .body(body)
                .when()
                .post("apis/customer/financialcert/generate").then().assertThat().extract().response();

        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonObj1 =  (JSONObject)json.get("data");
        System.err.println("jsonObj1 : " + response.getStatusCode());
        boolean isOK;
        if(isScenario == true || DeviceId == 1){
            System.err.println(response.getStatusCode());
            isOK = (response.getStatusCode() == 401);
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
        String CrmId = "001100000000000000000012037609";
        String body = "{   \n" +
                "    \"account_numbers\": [    \n" +
                "        \"1102416367\"  \n" +
                "    ],  \n" +
                "    \"asset_owner_name\": \"test\",  \n" +
                "    \"deposit_value\": 300000.00,  \n" +
                "    \"document_language\": \"en\",  \n" +
                "    \"document_type\": \"financial_certificate_self\",  \n" +
                "    \"investment_value\": 340000.00,  \n" +
                "    \"sponsor_name\": \"john\",  \n" +
                "    \"unit_holder_numbers\": [    \n" +
                "        \"PT01829800\"  \n" +
                "    ]\n" +
                "}";
        ApplicationStatusTrackingGet(testCaseID, body,true, CrmId, 1, "Application Status Tracking", "I+3sHPLEKNvnJG4X9x8zaJ2wy+75HBZOcwr4xcRPNAOTrUdxSphC8yU04WhAcqPAYp6rK5jiapIjwvpRCCO7wZZggKT01jKvk/h3bXouQMNBtXrGs/lG10LCbqW8sGj/+h+Vrya82XzgU+1ZtwokXfy+DqatJAnpdUgXLJKvSwLMFiI4pN2zSFKfu6PA3pDv9tC5cNDl7o8d1NY8ICIXzj9rD3fR+/hgi6jVWLDvCcODGaKr4ByCHjxUTT9RV4ztdOXk9+dZrbGaLW+5RFiSq7taati0/8XUJwo8tgqgA5fKqH1i9pIBw/WJGeRLgFYs44KxoNvBac3Fo5B02aNQWA==");
    }
    @Test(priority = 1)
    void ApplicationStatusTracking02() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000012037609";
        String body = "{  }";
        ApplicationStatusTrackingGet(testCaseID, body, false, CrmId, 2, "Application Status Tracking", "I+3sHPLEKNvnJG4X9x8zaJ2wy+75HBZOcwr4xcRPNAOTrUdxSphC8yU04WhAcqPAYp6rK5jiapIjwvpRCCO7wZZggKT01jKvk/h3bXouQMNBtXrGs/lG10LCbqW8sGj/+h+Vrya82XzgU+1ZtwokXfy+DqatJAnpdUgXLJKvSwLMFiI4pN2zSFKfu6PA3pDv9tC5cNDl7o8d1NY8ICIXzj9rD3fR+/hgi6jVWLDvCcODGaKr4ByCHjxUTT9RV4ztdOXk9+dZrbGaLW+5RFiSq7taati0/8XUJwo8tgqgA5fKqH1i9pIBw/WJGeRLgFYs44KxoNvBac3Fo5B02aNQWA==");
    }
    @Test(priority = 2)
    void ApplicationStatusTracking03() throws ParseException, IOException {
        String testCaseID = "Validate response for Bad Request";
        String CrmId = "0011000000000000000000120376099999";
        String body = "";
        ApplicationStatusTrackingGet(testCaseID, body, false, CrmId, 2, "Application Status Tracking", "I+3sHPLEKNvnJG4X9x8zaJ2wy+75HBZOcwr4xcRPNAOTrUdxSphC8yU04WhAcqPAYp6rK5jiapIjwvpRCCO7wZZggKT01jKvk/h3bXouQMNBtXrGs/lG10LCbqW8sGj/+h+Vrya82XzgU+1ZtwokXfy+DqatJAnpdUgXLJKvSwLMFiI4pN2zSFKfu6PA3pDv9tC5cNDl7o8d1NY8ICIXzj9rD3fR+/hgi6jVWLDvCcODGaKr4ByCHjxUTT9RV4ztdOXk9+dZrbGaLW+5RFiSq7taati0/8XUJwo8tgqgA5fKqH1i9pIBw/WJGeRLgFYs44KxoNvBac3Fo5B02aNQWA==");
    }
    @Test(priority = 3)
    void ApplicationStatusTracking04() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000012037609";
        String body = "{    \n" +
                "    \"citizen_id\":\"1451000172770\",\n" +
                "    \"mobile_no\":\"1234567890\"\n" +
                "}";
        ApplicationStatusTrackingGet2(testCaseID, body, true, CrmId, 2, "Application Status Tracking", "");
    }
}
