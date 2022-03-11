package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class APITestCreateLead {
    private static String token;
    private static String data;

    @BeforeTest
    public String getIdFromHeader() {
        data = AutoloanUtility.EncodeDataForCYC();
        System.err.println(data);
        token = AutoloanUtility.genToken(data);
        System.out.println("AccessToken is" + token);
        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getPostLoan().toString();
        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        Response response = given().urlEncodingEnabled(false).relaxedHTTPSValidation().auth().oauth2(token).redirects().follow(false)
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .header("Timestamp", "786").body(body).when()
                .post("apis/redirect/auto-loan").then().assertThat().extract().response();
        String headerLocation = response.getHeader("Location");
        Optional<String> idKeyValue = Arrays.stream(headerLocation.split("&")).filter(s -> s.contains("_id=")).findFirst();
        if (idKeyValue.isPresent()) {
            return idKeyValue.get().split("=")[1];

        } else {
            System.out.println("_id not found");
        }
        return null;
    }

    private void cycCreateLead() {
        data = AutoloanUtility.EncodeDataForCYC();
        token = AutoloanUtility.genToken(data);
        System.out.println("AccessToken is" + token);
        GetJsonData bodyOjb = new GetJsonData();
        JSONObject body = bodyOjb.cycCreateLeadSuccess();
        String _id = getIdFromHeader();
        body.put("id", _id);
        String bodyEditID = body.toJSONString();


        RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
        given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(bodyEditID)
                .when().post("/apis/hpservice/cyc/createLead").then().assertThat().statusCode(200)
                .body("status.code", equalTo("0000"))
                .body("status.message", equalToIgnoringCase("success"));

    }

    @Test(groups = "API Test CYC Create Lead")
    public void apiTestCYCCreateLead() {
        cycCreateLead();
    }
}
