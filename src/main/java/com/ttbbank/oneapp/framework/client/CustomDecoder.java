package com.ttbbank.oneapp.framework.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomDecoder extends JacksonDecoder implements ErrorDecoder {

    private Map<String, Collection<String>> headers;
    ErrorDecoder errorDecoder = new ErrorDecoder.Default();

    @Override
    public Object decode(Response response, Type type) throws IOException {
        headers = response.headers();
        String text = new BufferedReader(
                new InputStreamReader(response.body().asInputStream(), StandardCharsets.UTF_8)).lines()
                .collect(Collectors.joining("\n"));
        return text;
    }

    public Map<String, Collection<String>> getHeaders() {
        return headers;
    }


    @Override
    public Exception decode(String methodKey, Response response) {
        headers = response.headers();
        return errorDecoder.decode(methodKey, response);
    }
}