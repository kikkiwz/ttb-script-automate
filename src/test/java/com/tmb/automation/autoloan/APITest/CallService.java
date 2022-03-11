package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import com.tmb.automation.autoloan.constant.RequestConstant;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CallService {


    public static String call(CallServiceRequest request) {
        String  token;
        if (StringUtils.isBlank(request.getRmId())) {
            token = AutoloanUtility.genToken(DataConstant.dataForToken);
        } else {
            token = AutoloanUtility.genToken(DataConstant.dataForToken, request.getRmId());
        }


        RequestSpecification requestSpecification = given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", UUID.randomUUID().toString())
                .header("Content-Type", "application/json");

        if (request.getHeaderRequest() != null) {
            requestSpecification.headers(request.getHeaderRequest());
        }

        switch (request.getHttpMethod()) {
            case GET:
                return requestSpecification.when().get(RequestConstant.BASE_URL +request.getUrl()).then().statusCode(request.getStatusCodeActual().value()).assertThat().extract().response().asString();
            case POST:
                return requestSpecification.when().body(request.getBody()).post(RequestConstant.BASE_URL + request.getUrl()).then().statusCode(request.getStatusCodeActual().value()).assertThat().extract().response().asString();
            case PUT:
                return requestSpecification.when().body(request.getBody()).put(RequestConstant.BASE_URL +request.getUrl()).then().statusCode(request.getStatusCodeActual().value()).assertThat().extract().response().asString();
            case DELETE:
                return requestSpecification.when().delete(RequestConstant.BASE_URL +request.getUrl()).then().statusCode(request.getStatusCodeActual().value()).assertThat().extract().response().asString();
            default:
                return null;
        }

    }
}
