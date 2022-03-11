package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.util.Base;
import io.restassured.path.json.JsonPath;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class APITestEventCardTest extends Base {

    @Test
    public void getEventCardSuccess() {
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/eventCard")
                .httpMethod(HttpMethod.GET)
                .statusCodeActual(HttpStatus.OK)
                .rmId("001100000000000000000006889828")
                .build();

        String response = CallService.call(callServiceRequest);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-exp-service");
        assertEquals(jsonPath.getString("status.description"), "success");

        assertEquals(jsonPath.getString("data.eventCard[0].rmId"), "001100000000000000000006889828");

    }

    @Test
    public void getEventCardSuccessEventNull() {
        CallServiceRequest callServiceRequest = CallServiceRequest.builder()
                .url("/apis/hpservice/eventCard")
                .httpMethod(HttpMethod.GET)
                .statusCodeActual(HttpStatus.OK)
                .rmId("00110000000000000000006889814")
                .build();

        String response =  CallService.call(callServiceRequest);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-exp-service");
        assertEquals(jsonPath.getString("status.description"), "success");

        assertNull(jsonPath.getString("data.eventCard"));
    }
}
