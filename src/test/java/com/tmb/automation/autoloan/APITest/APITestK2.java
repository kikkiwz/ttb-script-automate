package com.tmb.automation.autoloan.APITest;

import io.restassured.path.json.JsonPath;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class APITestK2 {

    @Test
    public void addServiceRequest() {
        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getK2AddServiceRequest().toJSONString();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/internal/service-request/close-account/k2/add-service-request")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .body(body)
                .build();

        String response = CallService.call(callServiceRequest);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");
        assertNotNull(jsonPath.get("data"));
    }

    @Test
    public void updatePaymentFlag() {
        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getK2updatePaymentFlag().toJSONString();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/internal/service-request/close-account/k2/update-payment-flag")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .body(body)
                .build();

        String response = CallService.call(callServiceRequest);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");
        assertNotNull(jsonPath.get("data"));
    }

    @Test
    public void updatePaymentFlag_fail() {
        GetJsonData bodyOjb = new GetJsonData();
        String body = bodyOjb.getK2updatePaymentFlag().toJSONString();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/internal/service-request/close-account/k2/update-payment-flag")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.BAD_REQUEST)
                .body(body)
                .build();

        String response = CallService.call(callServiceRequest);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "400");
        assertEquals(jsonPath.getString("status.message"), "BAD REQUEST");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "BAD REQUEST");
        assertNull(jsonPath.get("data"));
    }
}
