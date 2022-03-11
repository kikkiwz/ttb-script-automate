package com.tmb.automation.autoloan.APITest;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class APITestDataFromMongo {
    @Test
    public void mongoDBDataFetch_SERVICE_TYPE_CYC() {
        JSONObject body = GetJsonData.fetchDataMongoCycSuccessCyc();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/data/fetch")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .body(body.toString())
                .build();

        String response = CallService.call(callServiceRequest);
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertNull(jsonPath.getString("status.description"));
        assertEquals(jsonPath.getString("data.serviceType"), "AL0400");
        assertNotNull(jsonPath.getString("data.marketingCode"));
    }

    @Test
    public void mongoDBDataFetch_SERVICE_TYPE_AccountDetail() {
        JSONObject body = GetJsonData.fetchDataMongoCycSuccessAccountDetail();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/data/fetch")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .body(body.toString())
                .build();

        String response = CallService.call(callServiceRequest);
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertNull(jsonPath.getString("status.description"));
        assertEquals(jsonPath.getString("data.serviceType"), "AL0100");
        assertNotNull(jsonPath.getString("data.marketingCode"));
    }

    @Test
    public void mongoDBDataFetch_SERVICE_TYPE_ApplicationDetail() {
        JSONObject body = GetJsonData.fetchDataMongoCycSuccessApplicationDetail();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/data/fetch")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .body(body.toString())
                .build();

        String response = CallService.call(callServiceRequest);
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertNull(jsonPath.getString("status.description"));
        assertEquals(jsonPath.getString("data.serviceType"), "AL0100");
        assertNotNull(jsonPath.getString("data.marketingCode"));
    }


    @Test
    public void saveDataToMongDb_SERVICE_TYPE_CYC() {

        Map<String, String> header = new HashMap<>();
        header.put("crmid", "001100000000000000000005976132");
        JSONObject body = GetJsonData.saveDataMongoCycSuccess();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/data/save")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .headerRequest(header)
                .body(body.toString())
                .build();

        String response = CallService.call(callServiceRequest);
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertNull(jsonPath.getString("status.description"));
        assertEquals(jsonPath.getString("data"),"Success");
    }

    @Test
    public void saveDataToMongDb_SERVICE_TYPE_AccountDetail() {

        Map<String, String> header = new HashMap<>();
        header.put("crmid", "001100000000000000000005976132");
        JSONObject body = GetJsonData.saveDataMongoAccountDetailSuccess();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/data/save")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .headerRequest(header)
                .body(body.toString())
                .build();

        String response = CallService.call(callServiceRequest);
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertNull(jsonPath.getString("status.description"));
        assertEquals(jsonPath.getString("data"),"Success");
    }

    @Test
    public void saveDataToMongDb_SERVICE_TYPE_ApplicationDetail() {

        Map<String, String> header = new HashMap<>();
        header.put("crmid", "001100000000000000000005976132");
        JSONObject body = GetJsonData.saveDataMongoApplicationDetailSuccess();
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/data/save")
                .httpMethod(HttpMethod.POST)
                .statusCodeActual(HttpStatus.OK)
                .headerRequest(header)
                .body(body.toString())
                .build();

        String response = CallService.call(callServiceRequest);
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertNull(jsonPath.getString("status.description"));
        assertEquals(jsonPath.getString("data"),"Success");
    }
}
