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

public class EligibilityAcc {

    private void EligibilityAccIncaseSucces(String testCaseID, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().param("serviceTypeId", "NCBR")
                .auth().oauth2(ViewVirtualPassbook.GetAccessToken(UserToken)).log().all()
                .header("accept", "application/json")
                .header("Device-Id","d9iCqhAiMJ5C0vlvbxhYm6r2Uqd5/oJH2bL3uvDVWzCFhF0TC2Apgjb5al/WumSnYJA+LhFHnWSvieshXE1GxkRKtvusWmAMkmo3P6CGG2x7YdxreMJJp1gebudmq3v6vqeih9fFGqvJzdVvbguxp0yEPBHBzEXg2v2IOX9njYia53LpYhjH0VmUyyjSdDjwuIdr77vNQNiRCBpGRhHy9oahLWb/aUCh85sh3ax3MGwwouTNGW/iCzW1f5fTjG6ccL8rxx2T8+m3GsgC28IokKUfc8AUcIOhmpBsCbv0dwbeQRnRZLYhwTo7JPm/Ggp51CKeoxUS+4xA6ri6yF5OtQ==")
                .when()
                .get("apis/customer/NCB/eligibility").then().assertThat().extract().response();


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


    private void EligibilityAccIncaseUnauthorized(String testCaseID, Boolean isScenario, String CrmId, int DeviceId, String Scenerios, String UserToken) throws IOException, ParseException {

        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
        Response response = given().relaxedHTTPSValidation().param("serviceTypeId", "NCBR")
                .header("accept", "application/json")
                .header("Device-Id","d9iCqhAiMJ5C0vlvbxhYm6r2Uqd5/oJH2bL3uvDVWzCFhF0TC2Apgjb5al/WumSnYJA+LhFHnWSvieshXE1GxkRKtvusWmAMkmo3P6CGG2x7YdxreMJJp1gebudmq3v6vqeih9fFGqvJzdVvbguxp0yEPBHBzEXg2v2IOX9njYia53LpYhjH0VmUyyjSdDjwuIdr77vNQNiRCBpGRhHy9oahLWb/aUCh85sh3ax3MGwwouTNGW/iCzW1f5fTjG6ccL8rxx2T8+m3GsgC28IokKUfc8AUcIOhmpBsCbv0dwbeQRnRZLYhwTo7JPm/Ggp51CKeoxUS+4xA6ri6yF5OtQ==")
                .when()
                .get("apis/customer/NCB/eligibility").then().assertThat().extract().response();


        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
        JSONObject jsonStatus =  (JSONObject)json.get("data");
        JsonPath jsonPath = new JsonPath(response.asString());
        String AccessToken = jsonPath.getString("status.code");
        System.err.println("jsonObj1 : " + AccessToken);
        boolean isOK;
        isOK = (response.getStatusCode() == 401);
        System.err.println("isOk : " + isOK);
       
        Assert.assertTrue(isOK);
        
    }

    @Test(priority = 0)
    void EligibilityAcc01() throws ParseException, IOException {
        String testCaseID = "Validate response for success";
        String CrmId = "001100000000000000000012037609";
        EligibilityAccIncaseSucces(testCaseID, true, CrmId, 1, "NCB Eligibility Account in case Success", "E7OFyu5SGxLRncI6Y5suMOywwJpvVoKqDOsYGxxRF29ceYxGWR3aVPy6fg2C3096JKC4of6ORagNXYiDE481B+wM7+9BBmCMs2IhKVH+CbEzVqxGe7j2YtO9dxQ8LXCxsisLuKe1nq5p59QhZPypmg/u3VMoVS6UuPRbEP5udhZ5VEj75OmLEyakPQrNXsSrOYB/6DLw4wwAx8S/A3gdVaRqmX2Fz/2g3TbJyLKmq+iTMiqaeiG8pmtvXIJZ1lhbcc3FuD1n2+RrU4gDgpdagHHx+q6X2E4XNqIrk0qa13nFXcaNyp4JwGS1nE36eVZwsSudMDrzKUNEZR+Mo3cHHw==");
    }
    @Test(priority = 1)
    void EligibilityAcc02() throws ParseException, IOException {
        String testCaseID = "Validate response for Unauthorized";
        String CrmId = "001100000000000000000012037609";
        EligibilityAccIncaseUnauthorized(testCaseID, false, CrmId, 1,"NCB Eligibility Account in case Unauthorized", "E7OFyu5SGxLRncI6Y5suMOywwJpvVoKqDOsYGxxRF29ceYxGWR3aVPy6fg2C3096JKC4of6ORagNXYiDE481B+wM7+9BBmCMs2IhKVH+CbEzVqxGe7j2YtO9dxQ8LXCxsisLuKe1nq5p59QhZPypmg/u3VMoVS6UuPRbEP5udhZ5VEj75OmLEyakPQrNXsSrOYB/6DLw4wwAx8S/A3gdVaRqmX2Fz/2g3TbJyLKmq+iTMiqaeiG8pmtvXIJZ1lhbcc3FuD1n2+RrU4gDgpdagHHx+q6X2E4XNqIrk0qa13nFXcaNyp4JwGS1nE36eVZwsSudMDrzKUNEZR+Mo3cHHw==");
    }
}
