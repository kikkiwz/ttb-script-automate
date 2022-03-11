package com.tmb.automation.autoloan;

import com.google.gson.Gson;
import com.tmb.automation.autoloan.APITest.GetJsonData;
import com.tmb.automation.model.Autolaon.GetToken;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class AutoloanUtility extends Base {


    public static void main(String[] args) throws IOException {

    }


    public static String genToken(String data) {
        RestAssured.baseURI = "https://api-sit1.oneapp.tmbbank.local";
        String response1 = given().relaxedHTTPSValidation().auth().preemptive()

                .basic("touch-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
                .header("X-Correlation-Id", UUID.randomUUID().toString()).multiPart("grant_type", "client_credentials")
                .multiPart("username", "001100000000000000000000125858")
                .multiPart("data", data)
                .multiPart("scope", "auto-loan").when()
                .post("apis/auth/token").then().assertThat().extract().response().asString();
        GetToken responseModel = new Gson().fromJson(response1, GetToken.class);
        System.err.println("response is" + responseModel.data.access_token);
        JsonPath jsonPath = new JsonPath(response1);
        String accessToken = jsonPath.getString("data.access_token");
        return accessToken;
    }

    public static String genToken(String data, String rmId) {
        RestAssured.baseURI = "https://api-sit1.oneapp.tmbbank.local";
        String response1 = given().relaxedHTTPSValidation().auth().preemptive()

                .basic("touch-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
                .header("X-Correlation-Id", UUID.randomUUID().toString()).multiPart("grant_type", "client_credentials")
                .multiPart("username", rmId)
                .multiPart("data", data)
                .multiPart("scope", "auto-loan").when()
                .post("apis/auth/token").then().assertThat().extract().response().asString();
        GetToken responseModel = new Gson().fromJson(response1, GetToken.class);
        System.err.println("response is" + responseModel.data.access_token);
        JsonPath jsonPath = new JsonPath(response1);
        String accessToken = jsonPath.getString("data.access_token");
        return accessToken;
    }

    public static String redirectURL(String AccessToken) throws IOException {


        System.out.println("AccessToken is" + AccessToken);
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getReDirectSuccess().toString();
        Response response = given().urlEncodingEnabled(false).relaxedHTTPSValidation().auth().oauth2(AccessToken).redirects().follow(false).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .header("Timestamp", "786").body(body).when()
                .post("apis/redirect/auto-loan").then().assertThat().extract().response();
        System.out.println("REsponse header" + response.getHeaders());
        String URL = response.getHeader("Location");
        System.out.println("URL is" + URL);

        return URL;
    }

    public static JsonPath JsonAccountDetail(String AccessToken) throws IOException {


        System.out.println("AccessToken is" + AccessToken);


        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getAccDetailSuccess().toString();

        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/account-details").then().assertThat().extract().response().asString();

        JsonPath resjsonPath = new JsonPath(response);


        return resjsonPath;


    }

    public static JSONObject getLoanStatusApplicationsList(String AccessToken, String id) {
        GetJsonData bodyObj = new GetJsonData();
        System.err.println("This Request" + bodyObj.getApplicationsList());

        org.json.simple.JSONObject obj = bodyObj.getApplicationsList();
        obj.put("_id", id);
        String body = obj.toJSONString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
                .header("X-Correlation-ID", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("/apis/hpservice/loan-status/application-list").then().assertThat().extract().response().asString();
        JSONObject jsonPath = new JSONObject(response);
        return jsonPath;
    }

    public static JSONObject getLoanStatusDetail(String AccessToken, String id) {
        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getLoanStatusDetail().toJSONString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
                .header("X-Correlation-ID", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("/apis/hpservice/loan-status/application-detail").then().assertThat().extract().response().asString();
        JSONObject jsonPath = new JSONObject(response);
        return jsonPath;
    }

    public static JsonPath GetCosService(String AccessToken) {

        System.out.println("AccessToken is" + AccessToken);
        GetJsonData bodyObj4GetCus = new GetJsonData();
        String body4GetCus = bodyObj4GetCus.getCusDetail().toString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body4GetCus).when()
                .post("apis/hpservice/customer/profile").then().assertThat().extract().response().asString();

        JsonPath CostomerService = new JsonPath(response);
        return CostomerService;

    }

    public static String ExistingAppListENURL(String AccessToken) {

        System.out.println("AccessToken is" + AccessToken);

        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getReDirectSuccess().toString();


        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        Response response = given().urlEncodingEnabled(false).relaxedHTTPSValidation().auth().oauth2(AccessToken).redirects().follow(false).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .header("Timestamp", "786").body(body).when()
                .post("apis/redirect/auto-loan").then().assertThat().extract().response();
        System.out.println("REsponse header" + response.getHeaders());
        String URL = response.getHeader("Location");
        System.out.println("URL is" + URL);

        return URL;


    }

    public static String ExistingAppListTHURL(String AccessToken) {
//

        System.out.println("AccessToken is" + AccessToken);

        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getReDirectSuccess().toString();


        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        Response response = given().urlEncodingEnabled(false).relaxedHTTPSValidation().auth().oauth2(AccessToken).redirects().follow(false).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .header("Timestamp", "786").body(body).when()
                .post("apis/redirect/auto-loan").then().assertThat().extract().response();
        System.out.println("REsponse header" + response.getHeaders());
        String URL = response.getHeader("Location");
        System.err.println("URL is" + URL);

        return URL;


    }

    public static String ProspectAppListTHURL(String AccessToken) {
//


        System.out.println("AccessToken is" + AccessToken);

        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getReDirectSuccess().toString();


        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().urlEncodingEnabled(false).relaxedHTTPSValidation().auth().oauth2(AccessToken).redirects().follow(false).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .header("Timestamp", "786").body(body).when()
                .post("apis/redirect/auto-loan").then().assertThat().extract().response();
        System.out.println("REsponse header" + response.getHeaders());
        String URL = response.getHeader("Location");
        System.out.println("URL is" + URL);

        return URL;


    }

    public static JsonPath ApplicationList(String AccessToken) throws IOException {


        System.out.println("AccessToken is" + AccessToken);

        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getApplicationList().toJSONString();

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("apis/hpservice/loan-status/application-list").then().assertThat().extract().response().asString();

        JsonPath resjsonPath = new JsonPath(response);


        return resjsonPath;


    }

    public static String ProspectAppListENURL(String AccessToken) {

        System.out.println("AccessToken is" + AccessToken);

        GetJsonData bodyObj = new GetJsonData();
        String body = bodyObj.getReDirectSuccess().toString();


        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().urlEncodingEnabled(false).relaxedHTTPSValidation().auth().oauth2(AccessToken).redirects().follow(false).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .header("Timestamp", "786").body(body).when()
                .post("apis/redirect/auto-loan").then().assertThat().extract().response();
        System.out.println("REsponse header" + response.getHeaders());
        String URL = response.getHeader("Location");
        System.out.println("URL is" + URL);

        return URL;
    }

    public static String EncodeDataForCYC() {
        GetJsonData getJsonData = new GetJsonData();
        String body = getJsonData.encryptDataCYC().toJSONString();
        String encode = Base64.getEncoder().encodeToString(body.getBytes());
        System.out.println(encode);
        return encode;
    }


}
