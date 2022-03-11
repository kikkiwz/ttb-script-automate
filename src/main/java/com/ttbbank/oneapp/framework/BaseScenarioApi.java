package com.ttbbank.oneapp.framework;

import com.itextpdf.text.DocumentException;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.ReporterApi;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.util.UUID;

public class BaseScenarioApi extends ReporterApi {

    public RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
    public JSONObject requestParams = new JSONObject();

    public void addHeader() {
        httpRequest.header("X-Correlation-ID", UUID.randomUUID());
        httpRequest.header("Accept-Language", "EN");
        httpRequest.header("Timestamp", "2020");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("Authorization", "Bearer " + Setting.TOKEN);
    }

    public void getUserId() {
//TODO
    }

    private void sendReportToEmail() throws IOException, DocumentException {
//TODO

    }


}

