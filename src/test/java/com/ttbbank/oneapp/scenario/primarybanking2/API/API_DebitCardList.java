package com.ttbbank.oneapp.scenario.primarybanking2.API;


import com.ttbbank.oneapp.scenario.lending.iosUtil.ExReport;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import com.ttbbank.oneapp.scenario.primarybanking2.PB2Common;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class API_DebitCardList {
    private String accessToken = "";
    private final JsonPath data = new JsonPath(PB2Common.getInput(System.getProperty("user.dir")
            + "\\src\\test\\java\\com\\ttbbank\\oneapp\\scenario\\primarybanking2\\DataTest\\PB2_API_Test_Data.json"));
//    private final RestAssuredConfig config = RestAssuredConfig.config()
//            .httpClient(HttpClientConfig.httpClientConfig()
//                    .setParam("http.socket.timeout", 5000)
//                    .setParam("http.connection.timeout", 5000));

    @BeforeClass
    public void setUp() {//Get Token
        System.out.println("setUP()");
        accessToken = PB2Common.getToken(data);
        System.out.println("accessToken:" + accessToken);
    }

/*    @Test
    public void Test1() {
        System.out.println("Test1");
        accessToken = PB2Common.getToken(data);
        System.out.println("accessToken:" + accessToken);
    }*/


    @Test
    public void API_GetCardList() {
        Response response = given().relaxedHTTPSValidation().auth().oauth2(accessToken)
                .headers(data.getMap("get-card-list.header"))
//                .config(config)
                .body(data.getMap("get-card-list.body"))
                .when()
                .post(data.getString("get-card-list.dev_url") + data.getString("get-card-list.path"))
                .then().assertThat().statusCode(200).extract().response();
//                .then().extract().response();
        System.out.println("status="+response.getStatusCode());
        System.out.println("json="+response.jsonPath().prettify());
//        System.out.println("data1="+response.jsonPath().getList("get-card-list.data").get(0).toString());
        List<String> cards = response.jsonPath().getList("data.card_group");
        int cardCount=0;
        for (String card:cards) {
            System.out.println(card);
        }
        for (int i=0;i<cards.size();i++){
            if (cards.get(i).equalsIgnoreCase(""))
            cardCount = i;
        }
        System.out.println("getMap()="+response.jsonPath().getList("data"));
        Map<String, String> cardMap = (Map<String, String>) response.jsonPath().getList("data").get(cardCount);
        System.out.println("cardMap="+cardMap);
//        Assert.assertEquals(200, response.getStatusCode());
////        ExReport.printReportMessage("aaa="+response.jsonPath().prettify());
//        ExReport.printReportMessageJson(response.jsonPath().prettify());
//        Assert.assertEquals(response.jsonPath().getString("status.code"), data.get("get-card-list.expected1.status.code"));
//        Assert.assertEquals(response.jsonPath().getString("status.message"), data.get("get-card-list.expected1.status.message"));
//        Assert.assertEquals(response.jsonPath().getString("status.service"), data.get("get-card-list.expected1.status.service"));
//
//        JSONObject request = new JSONObject();
//        request.put("api-path", data.get("fetch-installment-plan.path"));
//        request.put("header", data.get("fetch-installment-plan.header"));
//        request.put("accessToken", accessToken);
//        request.put("hostname", data.get("fetch-installment-plan.hostname"));
//        request.put("description", data.get("fetch-installment-plan.description"));
//
//        JSONObject result = new JSONObject();
////        result.put("api-path", data.get("fetch-installment-plan.path"));
////        result.put("header", data.get("fetch-installment-plan.header"));
//        result.put("response", response.jsonPath().get());
////        result.put("accessToken", accessToken);
////        result.put("hostname", data.get("fetch-installment-plan.hostname"));
////        result.put("description", data.get("fetch-installment-plan.description"));
//        result.put("request", request);
//
//        Lib.writeJsonResult(System.getProperty("user.dir") + "/target/reports/"
//                , new Object() {
//                }.getClass().getEnclosingMethod().getName(), result.toString());
//        ExReport.printReportMessageJson(result.toJSONString());
    }
}
