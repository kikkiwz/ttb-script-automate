package com.tmb.automation.primarybanking2.APITest.ViewAccountDetails;

import com.tmb.automation.helper.Helper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ViewAccount {

    //public static Map<String, String> headerInquiryPromptPay = new HashMap<String, String>();

    private static Map<String, String> headers = new HashMap<String, String>();
    private static Map<String, String> headers_inquiry = new HashMap<String, String>();

    private static String accessToken;
    private static String accountNo;
    private static String accountType;

    public static LinkedHashMap viewAccount(String accountNo, String accountType, String accessToken, String jSonObject) {

        headers_inquiry.put("X-Correlation-ID", Helper.generateCorrelationId());
        headers_inquiry.put("Authorization", "Bearer" +" "+ accessToken);

        headers_inquiry.put("Content-Type", "application/json");
        headers_inquiry.put("Cookie", "511a2bda58977cafd124dc70932f5a2b=bdf453969496b795ca919e7036b61f9f");

        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put("accountNo", accountNo);
        parameters.put("accountType", accountType);

        System.out.println(parameters);

        //JSONObject jsonObject = new JSONObject(parameters);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(parameters);

        Response response = (Response) given().headers(headers_inquiry).accept(ContentType.JSON).relaxedHTTPSValidation()
                .body(jsonObject.toJSONString()).when().post("https://oneapp-dev1.tau2904.com/apis/customer/accounts/details/")
                .then().log().all().extract()
                .response();

        ResponseBody responseService = response.getBody();
        System.out.println("\n\n" + responseService.asString());
        JsonPath jsonPath = responseService.jsonPath();
        LinkedHashMap dataReponse = jsonPath.get(jSonObject);

        return dataReponse;

    }

    public static LinkedHashMap viewAccountDeleteBodyParams (String accountType, String accessToken, String jSonObject) {

        headers_inquiry.put("X-Correlation-ID", Helper.generateCorrelationId());
        headers_inquiry.put("Authorization", "Bearer" +" "+ accessToken);

        headers_inquiry.put("Content-Type", "application/json");
        headers_inquiry.put("Cookie", "511a2bda58977cafd124dc70932f5a2b=bdf453969496b795ca919e7036b61f9f");

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("accountNo", accountNo);
        parameters.put("accountType", accountType);

        System.out.println(parameters);

        JSONObject jsonObject = new JSONObject(parameters);


        Response response = (Response) given().headers(headers_inquiry).accept(ContentType.JSON)
                .body(jsonObject.toJSONString()).when().post("https://oneapp-dev1.tau2904.com/apis/customer/accounts/details")
                .then().log().all().extract()
                .response();

        ResponseBody responseService = response.getBody();
        System.out.println("\n\n" + responseService.asString());
        JsonPath jsonPath = responseService.jsonPath();
        LinkedHashMap dataReponse = jsonPath.get("status");

        return dataReponse;

    }
}
