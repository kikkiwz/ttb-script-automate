package com.tmb.automation.util;

import com.tmb.automation.helper.Setting;
import org.json.simple.JSONObject;

public class GetJsonData {

    public static JSONObject getLoginTestCase() {
        return ReadJson.readJson("/src/main/resources/example/json/login_testcase_"+ Setting.SERVER+".json");
    }

    public static JSONObject getBiometricConsentTestCase() {
        return ReadJson.readJson("/src/main/resources/example/json/biometric_consent_testcase_"+ Setting.SERVER+".json");
    }

    public static JSONObject getEnvironment() {
        return ReadJson.readJson("/src/main/resources/example/json/environment.json");
    }

    public static JSONObject getUpdateEmail() {
        return ReadJson.readJson("/src/main/resources/platform2/update_email_dev.json");
    }

}
