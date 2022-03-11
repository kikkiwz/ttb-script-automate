package com.ttbbank.oneapp.framework.client;

import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Map;

public interface GetAccessTokenClient {

    @RequestLine("POST /apis/auth/token")
    @Headers("Content-Type: multipart/form-data")
    ResponseGenToken genToken(@HeaderMap Map<String, Object> headerMap, @Param("grant_type") String grantType,
                    @Param("username") String username,
                    @Param("password") String password,
                    @Param("scope") String scope
    );
}
