package com.tmb.automation.api.customerservice.sprint18;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class ApplicationStatusTracking  {
    @Test
    public static String AST(String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        String response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("X-Correlation-Id", "mockCorrelationId12412412424")
                .header("Content-Type", "application/json")
                .header("x-crmid", "001100000000000000000006311541")
                .header("device-id", "FUzgnbIP/aegKo+se+1gkXhF9R3bWuIut4LF/TQyZUk1OvBUOeGZn0caYN3Lznn07USdt9JMmVyv1whHNTe40fHUBR5E8k+o7rh3byBLDJY9MY21UFv3p4iTLLSveC8WoavayzQvzSW2/i2AIpAEqhbm2N/8noU522mx7Rr6hnd8PQ0doeVvS2vBkeK9fJRuUVPUjd4CEdUDVAscz15fCuDFmIS6Gp3gAZ+gt2uLZIMtuiayQvVm9CuX+rKskZZOJCftpG3V6J7SYG1Y5mxKUbp+pZvEt1BxAlknGS/WoyyHl3COFALHlOD0rhb8k0RsnAwBljai7kADM+WaMgj4hg==")
                .when()
                .post("apis/products/application/status?service_type_id=AST").then().assertThat().extract().response().asString();

//        JsonPath jsonPath = new JsonPath(response);
//        String asd = jsonPath.getString("data.in_progress[0].product_type_th");
        return response;
//        System.err.println(asd);
    }

    private void ApplicationStatusTrackingGet(String testCaseID, Boolean prospective, String body, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

            RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
            Response response = given().relaxedHTTPSValidation().auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                    .header("x-correlation-id", "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da")
                    .header("Content-Type", "application/json")
                    .header("accept-language", "en")
                    .header("prospective", prospective)
                    .header("device-id", "d9iCqhAiMJ5C0vlvbxhYm6r2Uqd5/oJH2bL3uvDVWzCFhF0TC2Apgjb5al/WumSnYJA+LhFHnWSvieshXE1GxkRKtvusWmAMkmo3P6CGG2x7YdxreMJJp1gebudmq3v6vqeih9fFGqvJzdVvbguxp0yEPBHBzEXg2v2IOX9njYia53LpYhjH0VmUyyjSdDjwuIdr77vNQNiRCBpGRhHy9oahLWb/aUCh85sh3ax3MGwwouTNGW/iCzW1f5fTjG6ccL8rxx2T8+m3GsgC28IokKUfc8AUcIOhmpBsCbv0dwbeQRnRZLYhwTo7JPm/Ggp51CKeoxUS+4xA6ri6yF5OtQ==")
                    .body(body)
                    .when()
                    .post("apis/products/application/status?service_type_id=AST").then().assertThat().extract().response();


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

    private void ApplicationStatusTrackingGet2(String testCaseID, Boolean prospective, String body, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

            RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
            Response response = given().relaxedHTTPSValidation().auth().oauth2("aasdasd").log().all()
                    .header("x-correlation-id", "32fbd3b2-3f97-4a89-ae39-b4f628fbc8da")
                    .header("Content-Type", "application/json")
                    .header("accept-language", "en")
                    .header("prospective", prospective)
                    .header("device-id", "d9iCqhAiMJ5C0vlvbxhYm6r2Uqd5/oJH2bL3uvDVWzCFhF0TC2Apgjb5al/WumSnYJA+LhFHnWSvieshXE1GxkRKtvusWmAMkmo3P6CGG2x7YdxreMJJp1gebudmq3v6vqeih9fFGqvJzdVvbguxp0yEPBHBzEXg2v2IOX9njYia53LpYhjH0VmUyyjSdDjwuIdr77vNQNiRCBpGRhHy9oahLWb/aUCh85sh3ax3MGwwouTNGW/iCzW1f5fTjG6ccL8rxx2T8+m3GsgC28IokKUfc8AUcIOhmpBsCbv0dwbeQRnRZLYhwTo7JPm/Ggp51CKeoxUS+4xA6ri6yF5OtQ==")
                    .body(body)
                    .when()
                    .post("apis/products/application/status?service_type_id=AST").then().assertThat().extract().response();

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
        String body = "{    \n" +
                "    \"citizen_id\":\"1451000172770\",\n" +
                "    \"mobile_no\":\"1234567890\"\n" +
                "}";
        Boolean prospective = true;
        ApplicationStatusTrackingGet(testCaseID, prospective, body,true, CrmId, 1, "Application Status Tracking", "PL3KEeK0kR7gjGxG9ulbbavE0of/qPAG7cRXuWj5xukr8fET0idr0un8VSzqrU4xHvPuQvqaLHJAHgIw7mZVmd8Le4lF3JWYh7x0tlTudVw2H6/aoCOcbwg/Uo8d1er/dR56y6epugRYuftjAkJlszf41z3iRYt7/F1HuieY5EFxly24ou1hPSFynPuOo/lKP5SCMND4peGWlEP913jybXo28jskFm8OamCX4jnTIWXIHKezCkkdmwWnfA9CoD5wXh+e2UZJnqQLD17HKArkIUvXNU+YOeDJom4USNm68U0trB405QaIMh+7oLA1H+uLYcMuB/OQFA9Q0DHX3Qi4TA==");
    }
    @Test(priority = 1)
    void ApplicationStatusTracking02() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000012037609";
        String body = "{    \n" +
                "    \"citizen_id\":\"\",\n" +
                "    \"mobile_no\":\"\"\n" +
                "}";
        Boolean prospective = false;
        ApplicationStatusTrackingGet(testCaseID, prospective, body, true, CrmId, 1, "Application Status Tracking", "PL3KEeK0kR7gjGxG9ulbbavE0of/qPAG7cRXuWj5xukr8fET0idr0un8VSzqrU4xHvPuQvqaLHJAHgIw7mZVmd8Le4lF3JWYh7x0tlTudVw2H6/aoCOcbwg/Uo8d1er/dR56y6epugRYuftjAkJlszf41z3iRYt7/F1HuieY5EFxly24ou1hPSFynPuOo/lKP5SCMND4peGWlEP913jybXo28jskFm8OamCX4jnTIWXIHKezCkkdmwWnfA9CoD5wXh+e2UZJnqQLD17HKArkIUvXNU+YOeDJom4USNm68U0trB405QaIMh+7oLA1H+uLYcMuB/OQFA9Q0DHX3Qi4TA==");
    }
    @Test(priority = 2)
    void ApplicationStatusTracking03() throws ParseException, IOException {
        String testCaseID = "Validate response for Bad Request";
        String CrmId = "0011000000000000000000120376099999";
        String body = "{    \n" +
                "    \"citizen_id\":\"\",\n" +
                "    \"mobile_no\":\"\"\n" +
                "}";
        Boolean prospective = true;
        ApplicationStatusTrackingGet(testCaseID, prospective, body, false, CrmId, 2, "Application Status Tracking", "PL3KEeK0kR7gjGxG9ulbbavE0of/qPAG7cRXuWj5xukr8fET0idr0un8VSzqrU4xHvPuQvqaLHJAHgIw7mZVmd8Le4lF3JWYh7x0tlTudVw2H6/aoCOcbwg/Uo8d1er/dR56y6epugRYuftjAkJlszf41z3iRYt7/F1HuieY5EFxly24ou1hPSFynPuOo/lKP5SCMND4peGWlEP913jybXo28jskFm8OamCX4jnTIWXIHKezCkkdmwWnfA9CoD5wXh+e2UZJnqQLD17HKArkIUvXNU+YOeDJom4USNm68U0trB405QaIMh+7oLA1H+uLYcMuB/OQFA9Q0DHX3Qi4TA==");
    }
    @Test(priority = 3)
    void ApplicationStatusTracking04() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000012037609";
        String body = "{    \n" +
                "    \"citizen_id\":\"1451000172770\",\n" +
                "    \"mobile_no\":\"1234567890\"\n" +
                "}";
        Boolean prospective = true;
        ApplicationStatusTrackingGet2(testCaseID, prospective, body, true, CrmId, 2, "Application Status Tracking", "");
    }
    @Test(priority = 4)
    void ApplicationStatusTracking05() throws ParseException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String DateTimeNow = dtf.format(now) + "T" + time.format(now).toLowerCase(Locale.ROOT);
        System.err.println("DateTimeNow : " + DateTimeNow);
    }
}
