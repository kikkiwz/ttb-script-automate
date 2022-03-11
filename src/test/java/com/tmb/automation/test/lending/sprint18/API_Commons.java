//package com.tmb.automation.test.lending.sprint18;
//
//import com.tmb.automation.pages.lending.Helper;
//import io.restassured.path.json.JsonPath;
//
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//
//public class API_Commons {
//
//    public static String getToken(String getTokenJsonPath){
//        Map<String, Object> hashMap = Helper.convertJsonToMap(getTokenJsonPath);//"LendingResources/json/GetToken.json"
//        String response = given().relaxedHTTPSValidation().auth().preemptive()
//                .basic(hashMap.get("api-key").toString(), hashMap.get("Authorization").toString())
//                .headers(Helper.convertStringToHashMap(hashMap.get("headers").toString()))
//                .formParams(Helper.convertStringToHashMap(hashMap.get("body").toString()))
//                .when()
//                .post(hashMap.get("hostname").toString()+hashMap.get("api-path1").toString())
//                .then().assertThat().statusCode(200).extract().response().asString();
//        String accessToken = new JsonPath(response).getString("data.access_token");
//        return accessToken;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getToken("LendingResources/json/GetToken.json"));
//    }
//}
