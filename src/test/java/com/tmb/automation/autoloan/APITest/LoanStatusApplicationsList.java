//package com.tmb.automation.autoloan.APITest;
//
//import com.tmb.automation.autoloan.AutoloanUtility;
//import io.qameta.allure.Attachment;
//import io.qameta.allure.Step;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//
//public class LoanStatusApplicationsList {
//
//    private String token;
//
//
//    @Attachment(value = "{0}", type = "text,plain")
//    public static String saveLog(String message){
//        return message;
//    }
//
//    @Step("Get Address Provide Success")
//    public static JsonPath getLoanStatusApplicationsList(String AccessToken){
//        GetJsonData bodyObj = new GetJsonData();
//        String body = bodyObj.getApplicationsList().toJSONString();
//        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
//        String response = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
//                .header("X-Correlation-ID","4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
//                .header("Content-Type","application/json")
//                .body(body).when()
//                .post("/apis/hpservice/loan-status/application-list").then().assertThat().extract().response().asString();
//        JsonPath jsonPath = new JsonPath(response);
//        String StatusCode = jsonPath.getString("status.code");
//        String StatusMSG = jsonPath.getString("status.message");
//        Assert.assertEquals(StatusCode,"0000");
//        Assert.assertEquals(StatusMSG,"success");
//        saveLog(response);
//        return jsonPath;
//    }
//
//    @Test(description = "Test" )
//    public void test(){
//        getLoanStatusApplicationsList(token);
//    }
//}
