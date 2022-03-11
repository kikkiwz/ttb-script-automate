package com.tmb.automation.util.platform2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public  class MapTmb {
    public static Map pojoToMap(Object fromValue){
        return (Map) new ObjectMapper().convertValue(fromValue, new TypeReference<Map<String, Object>>() {});
    }
}
