package com.tmb.automation.api.customerservice.sprint19;

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

public class TermAndCondition {

    public static String TermAndConditionByPost(String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("Content-Type", "application/json")
                .when()
                .get("apis/customer/termNCondition/NCB_POST").then().assertThat().extract().response().asString();

        return response;
    }

    private void ApplicationStatusTrackingGet(String testCaseID, Boolean isScenario, String CrmId, int DeviceId, String Delivery_Method, String Scenerios, String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().param("service_type_id", "AST").auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("Content-Type", "application/json")
                .when()
                .get(Delivery_Method).then().assertThat().extract().response();


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

    private void ApplicationStatusTrackingGet2(String testCaseID, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().param("service_type_id", "AST")
                .header("Content-Type", "application/json")
                .when()
                .get("apis/customer/termNCondition/NCB_POST").then().assertThat().extract().response();

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
        
    }

    @Test(priority = 0)
    void ApplicationStatusTracking01() throws ParseException, IOException {
        String testCaseID = "Validate response for success by post";
        String CrmId = "001100000000000000000012037609";
        String Delivery_Method = "apis/customer/termNCondition/NCB_POST";
        ApplicationStatusTrackingGet(testCaseID, true, CrmId, 1, Delivery_Method, "Term and Condition In case Success", "Uku3SwmI/DdIb9uDeicv8kF+Gany4+/DgHUMtMzVqryNKRFuVsaJKsVsME+l4RKtdLi/UuugAP6cZfL0jG4gozjKot5ne5CcoF0hkHK3QcfFXvtGoFShwX0AH4LZEFnYlkDKPrrnPOgfBCm/GElpzBlIwJiW/PWrKkufY5sIgkSZ4CrqRystw3IJVwlXTHvmud4qJG4iVhcaaMLa17yUm9lyfPJE29nf34yBSQZbXzHyQ/q6ZKpVHHlL72stbxMGC145oJKpGhnhi1oMZEn0HmDUW/Prcrj4YApNd5Wd2wOiWaT4qWOqhGITgH8A82Q2yDsh4VFy7XiiKGJu9Upxyg==");
    }

    @Test(priority = 1)
    void ApplicationStatusTracking02() throws ParseException, IOException {
        String testCaseID = "Validate response for success by email";
        String CrmId = "001100000000000000000012037609";
        String Delivery_Method = "apis/customer/termNCondition/NCB_EMAIL";
        ApplicationStatusTrackingGet(testCaseID, true, CrmId, 1, Delivery_Method, "Term and Condition In case Success", "Uku3SwmI/DdIb9uDeicv8kF+Gany4+/DgHUMtMzVqryNKRFuVsaJKsVsME+l4RKtdLi/UuugAP6cZfL0jG4gozjKot5ne5CcoF0hkHK3QcfFXvtGoFShwX0AH4LZEFnYlkDKPrrnPOgfBCm/GElpzBlIwJiW/PWrKkufY5sIgkSZ4CrqRystw3IJVwlXTHvmud4qJG4iVhcaaMLa17yUm9lyfPJE29nf34yBSQZbXzHyQ/q6ZKpVHHlL72stbxMGC145oJKpGhnhi1oMZEn0HmDUW/Prcrj4YApNd5Wd2wOiWaT4qWOqhGITgH8A82Q2yDsh4VFy7XiiKGJu9Upxyg==");
    }
    @Test(priority = 2)
    void ApplicationStatusTracking03() throws ParseException, IOException {
        String testCaseID = "Validate response for Bad Request";
        String CrmId = "0011000000000000000000120376099999";
        ApplicationStatusTrackingGet2(testCaseID, false, CrmId, 2, "Term and Condition In case Unauthorized", "Uku3SwmI/DdIb9uDeicv8kF+Gany4+/DgHUMtMzVqryNKRFuVsaJKsVsME+l4RKtdLi/UuugAP6cZfL0jG4gozjKot5ne5CcoF0hkHK3QcfFXvtGoFShwX0AH4LZEFnYlkDKPrrnPOgfBCm/GElpzBlIwJiW/PWrKkufY5sIgkSZ4CrqRystw3IJVwlXTHvmud4qJG4iVhcaaMLa17yUm9lyfPJE29nf34yBSQZbXzHyQ/q6ZKpVHHlL72stbxMGC145oJKpGhnhi1oMZEn0HmDUW/Prcrj4YApNd5Wd2wOiWaT4qWOqhGITgH8A82Q2yDsh4VFy7XiiKGJu9Upxyg==");
    }
}
