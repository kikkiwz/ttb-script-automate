package com.tmb.automation.autoloan.APITest;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;


import static org.junit.Assert.*;

public class APITestAccountList {
    private static final String endpoint = "/apis/hpservice/account-list";

    @Test
    public void getAccountListSuccess() {
        JSONObject body = GetJsonData.getAccountListSuccess();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url(endpoint)
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .body(body.toString())
                .build();

        String response = CallService.call(callServiceRequest);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");
        assertNotNull(jsonPath.get("data"));
        assertNotNull(jsonPath.get("data.accountHPDetails"));
    }

    @Test
    public void getAccountListBadRequest() {
        JSONObject body = GetJsonData.getAccountListBadRequest();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url(endpoint)
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.BAD_REQUEST)
                .body(body.toString())
                .build();

        String response = CallService.call(callServiceRequest);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "100901103");
        assertEquals(jsonPath.getString("status.message"), "100901103");
        assertEquals(jsonPath.getString("status.service"), "hp-exp-service");
        assertEquals(jsonPath.getString("status.description.th"), "ไม่พบข้อมูล เนี่องจากคุณยังไม่มีรายการสินเชื่อกับทางธนาคาร");
        assertEquals(jsonPath.getString("status.description.en"), "There is no payment history recorded due to you have no loan with ttb.");
        assertNull(jsonPath.get("data"));
    }
}
