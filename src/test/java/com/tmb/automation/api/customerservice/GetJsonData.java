package com.tmb.automation.api.customerservice;

import com.tmb.automation.util.ReadJson;
import org.json.simple.JSONObject;

public class GetJsonData {
    public static JSONObject setBiometric(){
        return ReadJson.readJson("/src/main/resources/customerservice/Biometric.json");
    }
    public static JSONObject setNdidAcceptance(){
        return ReadJson.readJson("/src/main/resources/customerservice/NdidAcceptance.json");
    }
    public static JSONObject setNdidAuthen(){
        return ReadJson.readJson("/src/main/resources/customerservice/NdidAuthen.json");
    }
}
