package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.util.DateFormatUtil;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class APITestCalculateDebtAmount {
    @Test
    public void getCalculateSuccess() {
        JSONObject body = GetJsonData.calculateDebtAmountSuccess();
        body.put("tranDate", DateFormatUtil.dateFormatYYYYMMDD(new Date()));
        CallServiceRequest request = CallServiceRequest.builder()
                .url("/apis/hpservice/service-request/close-account/calculate-debt-amount")
                .statusCodeActual(HttpStatus.OK)
                .httpMethod(HttpMethod.POST)
                .body(body.toJSONString())
                .build();
        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "0000");
        assertEquals(jsonPath.getString("status.message"), "success");
        assertEquals(jsonPath.getString("status.service"), "hp-ex-service");
        assertEquals(jsonPath.getString("status.description"), "success");

        assertEquals(jsonPath.getString("data[0].debt_Detail[0].DebtDesc"), "ค่างวด");
        assertEquals(jsonPath.getString("data[0].debt_Detail[0].DebtAmount"), "5433.00");

        assertEquals(jsonPath.getString("data[0].debt_Detail[1].DebtDesc"), "ส่วนลดปิดบัญชีล่วงหน้า");
        assertEquals(jsonPath.getString("data[0].debt_Detail[1].DebtAmount"), "-14.99");

        assertEquals(jsonPath.getString("data[0].debt_TotalAmt"), "5418.01");
    }

    @Test
    public void getCalculateBadRequest() {
        JSONObject body = GetJsonData.calculateDebtAmountFail();
        CallServiceRequest request = CallServiceRequest.builder()
                .url("/apis/hpservice/service-request/close-account/calculate-debt-amount")
                .statusCodeActual(HttpStatus.BAD_REQUEST)
                .httpMethod(HttpMethod.POST)
                .body(body.toString())
                .build();
        String response = CallService.call(request);
        JsonPath jsonPath = new JsonPath(response);
        assertEquals(jsonPath.getString("status.code"), "100903103");
        assertEquals(jsonPath.getString("status.message"), "100903103");
        assertEquals(jsonPath.getString("status.service"), "hp-exp-service");
        assertEquals(jsonPath.getString("status.description.th"), "ไม่พบข้อมูลในขณะนี้ กรุณาทำรายการใหม่อีกครั้ง หรือสอบถามเพิ่มเติม โทร. 1428");
        assertEquals(jsonPath.getString("status.description.en"), "There is no data as request, Please try again later or contact 1428 for more information.");
        assertNull(jsonPath.get("data"));
    }
}
