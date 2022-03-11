package com.tmb.automation.api.platform2;

import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.ReadJson;
import org.json.simple.JSONObject;

public class GetJsonData {

    public static JSONObject getLoginTestCase() {
        return ReadJson.readJson("/src/main/resources/platform2/json/login_testcase_"+ Setting.SERVER+".json");
    }

    public static JSONObject getSearchApiTestCase() {
        return ReadJson.readJson("/src/main/resources/platform2/json/search_testcase_api_"+ Setting.SERVER+".json");
    }

    public static JSONObject getSearchUiTestCase() {
        return ReadJson.readJson("/src/main/resources/platform2/json/search_testcase_"+ Setting.SERVER+".json");
    }

    public static JSONObject getSearchProfileApiTestCase() {
        return ReadJson.readJson("/src/main/resources/platform2/json/search_profile_testcase_api_"+ Setting.SERVER+".json");
    }

    public static JSONObject getSearchActivityLogsApiTestCase() {
        return ReadJson.readJson("/src/main/resources/platform2/json/search_activity_log_testcase_api_"+ Setting.SERVER+".json");
    }

}
