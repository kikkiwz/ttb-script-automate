package com.tmb.automation.api.customerservice;

import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.Log;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.TextColor;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.tmb.automation.util.ConvertStringToJson;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.UUID;

public class ViewVirtualPassbook extends BasePlatform2 {

    String AccesToken = null;

    @BeforeTest
    public void Token() throws IOException {
        AccesToken = this.GetAccessToken("aLptKL0kco/aIBKx6VBFrgjaqLOuycD7HVcOEl8RFQKR+axROM56AEXsmLKH5I/vwE23EMSCWgNt/rriXSCwFeiBFbw3A9UHkYC5bo3hPbjdN/sqMobYnuklYqU55blMphlO19zsFzSM2orJ6zLXUarjygqtGGwb4WPTVlPcz6a2DmO729EyL1k8DuulwREP4oX/XgeTvIfkUq9SYUu+G4dPBaAKVB97xCXsa+ZFgXAMh5vHZywpUKIcSss+e9j8WS2Qe8p+oTJDX/Oox7w8VFH1+Y+8z5hkpqj4s4glU1WKF9B5LX+TIg7gTS0bUanVh2AGywEnGIEmeoebjRkgtw==");
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveLog(String massage) {

        return massage;
    }

    public static String GetAccessToken(String UserName) throws IOException {

        RestAssured.baseURI="https://oneapp-dev1.tau2904.com";
        String username=UserName;
        String password="WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==";
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().preemptive()
                .basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").multiPart("grant_type", "password")
                .multiPart("username", username).multiPart("password", password).multiPart("scope","mobile").when()
                .post("apis/auth/token").then().assertThat().statusCode(200).extract().response().asString();
        System.out.println("Response" + response);
        JsonPath jsonPath = new JsonPath(response);
        String AccessToken = jsonPath.getString("data.access_token");
        System.out.println("access token" + AccessToken);

        return AccessToken;
    }

    @Test(priority = 0)
    @Step
    private String DataCompair() throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(AccesToken).log().all()
                .header("X-Correlation-Id", "mockCorrelationId12412412424")
                .header("Content-Type", "application/json")
                .header("x-crmid", "001100000000000000000006311541")
                .header("device-id", "FUzgnbIP/aegKo+se+1gkXhF9R3bWuIut4LF/TQyZUk1OvBUOeGZn0caYN3Lznn07USdt9JMmVyv1whHNTe40fHUBR5E8k+o7rh3byBLDJY9MY21UFv3p4iTLLSveC8WoavayzQvzSW2/i2AIpAEqhbm2N/8noU522mx7Rr6hnd8PQ0doeVvS2vBkeK9fJRuUVPUjd4CEdUDVAscz15fCuDFmIS6Gp3gAZ+gt2uLZIMtuiayQvVm9CuX+rKskZZOJCftpG3V6J7SYG1Y5mxKUbp+pZvEt1BxAlknGS/WoyyHl3COFALHlOD0rhb8k0RsnAwBljai7kADM+WaMgj4hg==")
                .when()
                .get("apis/customer/accounts/saving").then().assertThat().extract().response().asString();

        return response;
    }


    @Test(priority = 1)
    @Step("Success and print body")
    private void Success() throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().param("service_type_id","serviceTypeId").auth().oauth2(AccesToken).log().all()
                .header("X-Correlation-Id", "mockCorrelationId12412412424")
                .header("Content-Type", "application/json")
                .header("x-crmid", "001100000000000000000006311541")
                .header("device-id", "FUzgnbIP/aegKo+se+1gkXhF9R3bWuIut4LF/TQyZUk1OvBUOeGZn0caYN3Lznn07USdt9JMmVyv1whHNTe40fHUBR5E8k+o7rh3byBLDJY9MY21UFv3p4iTLLSveC8WoavayzQvzSW2/i2AIpAEqhbm2N/8noU522mx7Rr6hnd8PQ0doeVvS2vBkeK9fJRuUVPUjd4CEdUDVAscz15fCuDFmIS6Gp3gAZ+gt2uLZIMtuiayQvVm9CuX+rKskZZOJCftpG3V6J7SYG1Y5mxKUbp+pZvEt1BxAlknGS/WoyyHl3COFALHlOD0rhb8k0RsnAwBljai7kADM+WaMgj4hg==")
                .when()
                .get("apis/customer/viewVirtualPassbook").then().assertThat().extract().response();

//        httpRequest.body(requestParams.toJSONString());
//        response = httpRequest.filters(logsFilter).request(Method.GET, "https://oneapp-dev1.tau2904.com" + "/apis/customer/viewVirtualPassbook");
//        System.out.println("res : " + resjsonPath.getString("data.virtual_passbook_details"));
//        JsonPath resjsonPath = new JsonPath(response.getBody().toString());
//        JsonPath resjsonPath2 = new JsonPath(this.DataCompair());
//        String StatusCode = resjsonPath.getString("data.virtual_passbook_details[0].account_number");
//        System.err.println("result view virtual : " +response.getBody().asString());
        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonObj1 =  (JSONObject)json.get("data");
//        JSONObject jsonStatus =  (JSONObject)json.get("status.code");
        JSONObject json2 = (JSONObject)new JSONParser().parse(this.DataCompair().toString());

//        System.err.println("dataCompair : " + jsonStatus);
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonA =  (JSONArray)jsonObj1.get("virtual_passbook_details");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("deposit_account_lists");
        System.err.println("length AAA : " +jsonA.size());
        System.err.println("length BBB : " +jsonB.size());
//        System.err.println("view : " +jsonB);
        int lengthArr = jsonA.size();
        int lengthArr2 = jsonB.size();

        JSONArray MappingData = new JSONArray();
        for (int i = 0; i < lengthArr; i++){
            for (int j = 0; j < lengthArr2; j++) {
                JSONObject jsonObj = new JSONObject();
                JSONObject jsonObjIndexA =  (JSONObject)jsonA.get(i);
                JSONObject jsonObjIndexB =  (JSONObject)jsonB.get(j);
                if(jsonObjIndexA.get("account_number").equals(jsonObjIndexB.get("account_number")) && jsonObjIndexA.get("account_name").equals(jsonObjIndexB.get("account_name")) && jsonObjIndexA.get("product_name_th").equals(jsonObjIndexB.get("product_name_th")) && jsonObjIndexA.get("product_name_en").equals(jsonObjIndexB.get("product_name_en"))){
                    System.err.println(jsonObjIndexA.get("account_number") + " == " + jsonObjIndexB.get("account_number"));
                    System.err.println(jsonObjIndexA.get("account_nick_name") + " == " + jsonObjIndexB.get("account_nick_name"));
                    Assert.assertTrue(jsonObjIndexA.get("account_name").equals(jsonObjIndexB.get("account_name")));
                    Assert.assertTrue(jsonObjIndexA.get("product_name_th").equals(jsonObjIndexB.get("product_name_th")));
                    Assert.assertTrue(jsonObjIndexA.get("product_name_en").equals(jsonObjIndexB.get("product_name_en")));
                    if(jsonObjIndexA.get("account_nick_name") == null){
                        Assert.assertTrue(jsonObjIndexA.get("account_nick_name")==(jsonObjIndexB.get("account_nick_name")));
                    }else {
                        Assert.assertTrue(jsonObjIndexA.get("account_nick_name").equals(jsonObjIndexB.get("account_nick_name")));
                    }
                    jsonObj.put("Account name " + i, jsonObjIndexA.get("account_name") + " == " + jsonObjIndexB.get("account_name"));
                    jsonObj.put("Account number " + i, jsonObjIndexA.get("account_number") + " == " + jsonObjIndexB.get("account_number"));
                    jsonObj.put("Account nickname " + i, jsonObjIndexA.get("account_nick_name") + " == " + jsonObjIndexB.get("account_nick_name"));
                    jsonObj.put("Account product name th " + i, jsonObjIndexA.get("product_name_th") + " == " + jsonObjIndexB.get("product_name_th"));
                    jsonObj.put("Account product name en " + i, jsonObjIndexA.get("product_name_en") + " == " + jsonObjIndexB.get("product_name_en"));
                    MappingData.add(jsonObj);
                }
            }
        }
        System.err.println("Push json data : " + MappingData.toJSONString());

        boolean isOK = (response.getStatusCode() == 200);
        Assert.assertTrue(isOK);

        parentReport = extent.createTest("View virtual Pass Book", "View virtual Pass Book");
        childReport = parentReport.createNode("Validate response for success check mapping data View Virtual Passbook");
        childReport.log(Status.INFO, "Crm id : " + TextColor.blueColor("response success check mapping data View Virtual Passbook"));
        childReport.log(Status.INFO, "Expected Result : " + TextColor.blueColor("001100000000000000000006311541"));
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK,ConvertStringToJson.jsonFormat(response.getBody().asString())) + "</pre>");
        childReport.log(Status.INFO, "Result Mapping: <pre> " + TextColor.resultColor(isOK,ConvertStringToJson.jsonFormatArray(MappingData.toJSONString()).replace("\\u003d\\u003d","==")) + "</pre>");

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                "TS_OneApp_API_VIEW_VIRTUAL_PASSBOOK_001",
                "Validate response for check mapping data View Virtual Passbook",
                "N/A",
                response.getStatusCode(),
                ConvertStringToJson.jsonFormat(response.getBody().asString())/*response*/,
                MappingData.toJSONString(),
                "",
                getDateTime(),
                isPass(isOK)});
        saveLog(response.toString());
    }


    @Test(priority = 2)
    @Step("Unauthorized")
    private void Unauthorized() throws IOException, ParseException {
        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().param("service_type_id","serviceTypeId").auth().oauth2("aasdasd").log().all()
                .header("Content-Type", "application/json")
                .header("device-id", "FUzgnbIP/aegKo+se+1gkXhF9R3bWuIut4LF/TQyZUk1OvBUOeGZn0caYN3Lznn07USdt9JMmVyv1whHNTe40fHUBR5E8k+o7rh3byBLDJY9MY21UFv3p4iTLLSveC8WoavayzQvzSW2/i2AIpAEqhbm2N/8noU522mx7Rr6hnd8PQ0doeVvS2vBkeK9fJRuUVPUjd4CEdUDVAscz15fCuDFmIS6Gp3gAZ+gt2uLZIMtuiayQvVm9CuX+rKskZZOJCftpG3V6J7SYG1Y5mxKUbp+pZvEt1BxAlknGS/WoyyHl3COFALHlOD0rhb8k0RsnAwBljai7kADM+WaMgj4hg==")
                .when()
                .get("apis/customer/viewVirtualPassbook").then().assertThat().extract().response();

        System.err.println("response.getStatusCode() : " + response.getStatusCode());
        boolean isOK = (response.getStatusCode() == 401);
        childReport = parentReport.createNode("Validate response for fail Unauthorized");
        childReport.log(Status.INFO, "Crm id : " + TextColor.blueColor("response success check mapping data View Virtual Passbook"));
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK,ConvertStringToJson.jsonFormat(response.getBody().asString())) + "</pre>");
        Assert.assertTrue(isOK);

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                "TS_OneApp_API_VIEW_VIRTUAL_PASSBOOK_002",
                "Validate response for Verify failed in case View Virtual Passbook",
                "N/A",
                response.getStatusCode(),
                ConvertStringToJson.jsonFormat(response.getBody().asString())/*response*/,
                "N/A",
                "N/A",
                getDateTime(),
                isPass(isOK)});
    }




}
