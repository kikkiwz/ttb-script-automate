package com.tmb.automation.autoloan.APITest;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.UUID;

import static org.junit.Assert.*;

public class APITestCloseAccountServiceDetail {

    private String endpointUrl = "/apis/hpservice/service-request/close-account/service-detail";
    private CallServiceRequest request;
    private JSONObject body;

    @BeforeMethod
    public void setup() {
        body = GetJsonData.closeAccountServiceDetail();
        request = CallServiceRequest.builder()
                .url(endpointUrl)
                .httpMethod(HttpMethod.POST)
                .build();
    }

    @Test
    public void getServiceDetailObjectiveId02_success() {

        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.OK);

        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);

        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");

        assertNull(jsonPath.getString("data.error"));
        assertNotNull(jsonPath.getString("data.debt_FeeId"));
        assertEquals(jsonPath.getString("data.debt_FeetotalAmt"), "1400.0");

        assertNotNull(jsonPath.get("data.paymentDetail"));
        assertEquals(jsonPath.getString("data.paymentDetail[0].debt_FeeCode"), "372");
        assertEquals(jsonPath.getString("data.paymentDetail[0].debt_FeeDesc"), "ค่าโอนกรรมสิทธิ์(ปิดบัญชี)");
        assertEquals(jsonPath.getString("data.paymentDetail[0].debt_FeeAmount"), "1400.0");
    }

    @Test
    public void getServiceDetail_objectiveId02AccountEmpty_returnBadRequest() {

        body.put("accountNo", "");

        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.BAD_REQUEST);

        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(response);

        assertBadRequest(jsonPath);
    }

    @Test
    public void getServiceDetail_objectiveId02MethodIdEmpty_returnBadRequest() {

        body.put("methodId", "");

        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.BAD_REQUEST);

        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(response);

        assertBadRequest(jsonPath);
    }

    @Test
    public void getServiceDetail_objectiveId01_success() {
        body.put("objectiveId", "01");
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.OK);

        String response = CallService.call(request);
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");

        assertNotNull(jsonPath.get("data"));
        assertNull(jsonPath.get("data.error"));
        assertNotNull(jsonPath.getString("data.debt_FeeId"));
        assertEquals(jsonPath.getString("data.debt_FeetotalAmt"), "1400.0");

        assertNotNull(jsonPath.get("data.paymentDetail"));
        assertEquals(jsonPath.getString("data.paymentDetail[0].debt_FeeCode"), "372");
        assertEquals(jsonPath.getString("data.paymentDetail[0].debt_FeeDesc"), "ค่าโอนกรรมสิทธิ์(ปิดบัญชี)");
        assertEquals(jsonPath.getString("data.paymentDetail[0].debt_FeeAmount"), "1400.0");
    }

    @Test
    public void getServiceDetail_objectiveId01AccountEmpty_returnBadRequest() {

        body.put("objectiveId", "01");
        body.put("accountNo", "");
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.BAD_REQUEST);

        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(response);

        assertBadRequest(jsonPath);
    }

    @Test
    public void getServiceDetail_objectiveId01ClosingDateEmpty_returnBadRequest() {

        body.put("objectiveId", "01");
        body.put("closingDate", "");
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.BAD_REQUEST);

        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(response);

        assertBadRequest(jsonPath);
    }
    @Test
    public void getServiceDetail_objectiveId01MethodIdEmpty_returnBadRequest() {

        body.put("objectiveId", "01");
        body.put("methodId", "");
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.BAD_REQUEST);

        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(response);

        assertBadRequest(jsonPath);
    }

    @Test
    public void getServiceDetail_objectiveIdEmpty_returnBadRequest() {

        body.put("objectiveId", "");
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.BAD_REQUEST);

        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(response);

        assertBadRequest(jsonPath);
    }

    private void assertBadRequest(JsonPath jsonPath) {
        assertEquals(jsonPath.getString("status.code"), "400");
        assertEquals(jsonPath.getString("status.message"), "BAD REQUEST");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "BAD REQUEST");

        assertNull(jsonPath.get("data"));
    }


}
