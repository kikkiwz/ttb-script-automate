package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import com.tmb.automation.util.Base;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APITestCopyOfContract extends Base {

        private String token;
        @Attachment(value = "{0}", type = "text/plain")
        public static String saveLog(String massage) {
            return massage;
        }


        public void CopyOfContractSuccess() throws IOException {


            token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxNzYxNDQ5MjcyMCwiYWNjb3VudE51bWJlciI6IjI2NjAwODI5NCIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTgyOTQifQ==");


            GetJsonData bodyObj = new GetJsonData();
            String body = bodyObj.getCopyOfContractSuccess().toJSONString();
            RestAssured.baseURI = "https://oneapp-sit1.tau2904.com";
            String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                    .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                    .header("Content-Type", "application/json")
                    .body(body).when()
                    .post("apis/hpservice/service-request/copy-of-contract").then().assertThat().extract().response().asString();
            JsonPath jsonPath = new JsonPath(response);
            String StatusCode = jsonPath.getString("status.code");
            String StatusMSG = jsonPath.getString("status.message");
            Assert.assertEquals(StatusCode,"0000");
            Assert.assertEquals(StatusMSG,"success");
            saveLog(response);
        }


        private void CopyOfContractDataNotFound() throws IOException {



            GetJsonData bodyObj = new GetJsonData();
            String body = bodyObj.getCopyOfContract_failed().toJSONString();
            RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
            String response = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                    .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                    .header("Content-Type", "application/json")
                    .body(body).when()
                    .post("apis/hpservice/service-request/copy-of-contract").then().assertThat().extract().response().asString();
            JsonPath jsonPath = new JsonPath(response);
            String StatusCode = jsonPath.getString("status.code");
            String StatusMSG = jsonPath.getString("status.message");
            Assert.assertEquals(StatusCode,"100903102");
            Assert.assertEquals(StatusMSG,"100903102");
            saveLog(response.toString());
        }

        @Test(groups = "Test Car transfer form API ")
        public void Print() throws IOException {
            CopyOfContractSuccess();
            CopyOfContractDataNotFound();
        }
    }

