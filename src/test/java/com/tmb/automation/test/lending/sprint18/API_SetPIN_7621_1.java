//package com.tmb.automation.test.lending.sprint18;
//
//import com.google.gson.Gson;
//import com.tmb.automation.helper.ExtentReport4;
//import com.tmb.automation.helper.Helper;
//import com.tmb.automation.pages.lending.ChangeUsageLimitPage;
//import com.tmb.automation.util.Base;
//import io.restassured.path.json.JsonPath;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
//
//public class API_SetPIN_7621_1 {
//    private Map<String, Object> hashMap = Helper.convertJsonToMap("LendingResources/json/SetPIN.json");
//    private String accessToken="";
//    @BeforeMethod
//    public void setUp() {
//        //Get Token
//        String response = given().relaxedHTTPSValidation().auth().preemptive()
//                .basic(hashMap.get("api-key").toString(), hashMap.get("Authorization").toString())
//                .headers(Helper.convertStringToHashMap(hashMap.get("headers").toString()))
//                .formParams(Helper.convertStringToHashMap(hashMap.get("body").toString()))
//                .when()
//                .post(hashMap.get("hostname").toString()+hashMap.get("api-path1").toString()).then().assertThat().statusCode(200).extract().response().asString();
//        accessToken = new JsonPath(response).getString("data.access_token");
//    }
//    @Test
//    public void TestAPI1() {
//        ExtentReport4.printReportMessage("Get Token = "+ accessToken);
//        //run automate UI for iOS
//        Map<String, String> body = getSetPIN();
//
//        String accountId_value = body.get("accountId");
//        String anb_value = body.get("anb");
//        String e2eesid_value = body.get("e2eesid");
//        String rpin_value = body.get("rpin");
//
//        String bodyString = "{\r\n  \"account_id\": \""+accountId_value+"\",\r\n  \"anb\": \""+anb_value
//                +"\",\r\n  \"e2eesid\": \""+e2eesid_value+"\",\r\n  \"rpin\": \""+rpin_value+"\"\r\n}";
//
//
//        System.out.println("access token = " + accessToken);
//
//        //Second API
//        String response2 = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
//                .when()
//                .get(hashMap.get("hostname").toString()+hashMap.get("api-path2").toString()).then().assertThat().statusCode(200)
//                .body(matchesJsonSchema(new Gson().toJson(hashMap.get("api_path1-expected1")))).extract().response().asString();
//        ExtentReport4.printReportMessageJson(response2);
//    }
//    public static Map<String, String>  getSetPIN(){
//        Map<String, String> body  = new HashMap<String, String>();
//        body.put("accountId", "");
//        body.put("anb", "");
//        body.put("e2eesid", "");
//        body.put("rpin", "");
//        return body;
//    }
//    @Test
//    public void getRPIN() {
//        Helper.setiOS();
////        Base base = new Base();
//        Base.iOSCapabilities();
//        ChangeUsageLimitPage ld = new ChangeUsageLimitPage(Base.appiumDriver);
//    }
//
//}
