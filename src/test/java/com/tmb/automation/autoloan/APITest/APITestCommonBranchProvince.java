package com.tmb.automation.autoloan.APITest;

import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

@Slf4j
public class APITestCommonBranchProvince {
    private String endpointUrl = "/apis/hpservice/common/branch/province";
    private CallServiceRequest request;

    @BeforeMethod
    public void setup() {
        request = CallServiceRequest.builder()
                .url(endpointUrl)
                .httpMethod(HttpMethod.POST)
                .build();
    }

    @Test
    public void getCommonBranchProvinceThai_success() {
        JSONObject body = GetJsonData.commonBranchProvinceThai();
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.OK);
        String response = CallService.call(request);
        log.info(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");
        assertNotNull(jsonPath.get("data"));
        assertEquals(jsonPath.getString("data[0].code"), "81");
        assertEquals(jsonPath.getString("data[0].name"), "กระบี่");
    }

    @Test
    public void getCommonBranchProvinceEnglish_success() {
        JSONObject body = GetJsonData.commonBranchProvinceEnglish();
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.OK);
        String response = CallService.call(request);
        log.info(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");
        assertNotNull(jsonPath.get("data"));
        assertEquals(jsonPath.getString("data[0].code"), "37");
        assertEquals(jsonPath.getString("data[0].name"), "Amnat Charoen");
    }

    @Test
    public void getCommonBranchProvinceLanguageEmpty_success() {
        JSONObject body = GetJsonData.commonBranchProvinceEnglish();
        body.put("language", "");
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.BAD_REQUEST);
        String response = CallService.call(request);
        log.info(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0010");
        assertEquals(jsonPath.getString("status.message"), "Failed");
        assertEquals(jsonPath.getString("status.service"), "hp-services");
        assertEquals(jsonPath.getString("status.description.en"), "Invalid Request");
        assertEquals(jsonPath.getString("status.description.th"), "Invalid Request");
        assertNull(jsonPath.get("data"));
    }

    @Test
    public void getCommonBranchProvinceLanguageNull_success() {
        JSONObject body = GetJsonData.commonBranchProvinceEnglish();
        body.put("language", null);
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.BAD_REQUEST);
        String response = CallService.call(request);
        log.info(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0010");
        assertEquals(jsonPath.getString("status.message"), "Failed");
        assertEquals(jsonPath.getString("status.service"), "hp-services");
        assertEquals(jsonPath.getString("status.description.en"), "Invalid Request");
        assertEquals(jsonPath.getString("status.description.th"), "Invalid Request");
        assertNull(jsonPath.get("data"));
    }

    @Test
    public void getCommonBranchProvinceLanguageOther_success() {
        JSONObject body = GetJsonData.commonBranchProvinceEnglish();
        body.put("language", "jp");
        request.setBody(body.toString());
        request.setStatusCodeActual(HttpStatus.OK);
        String response = CallService.call(request);
        log.info(response);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");
        assertNotNull(jsonPath.get("data"));
        assertEquals(jsonPath.getString("data[0].code"), "81");
        assertEquals(jsonPath.getString("data[0].name"), "กระบี่");
    }
}
