package com.tmb.automation.autoloan.APITest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Builder
@Getter
@Setter
public class CallServiceRequest {
    private String url;
    private HttpMethod httpMethod;
    private Map<String, String> headerRequest;
    private String body;
    private HttpStatus statusCodeActual;
    private String rmId;
}
