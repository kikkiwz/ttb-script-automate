package com.tmb.automation.investment.config;

import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.ReadJson;
import org.json.simple.JSONObject;

public class GetJsonData {
    public static JSONObject getMyMutualFund() {
        return ReadJson.readJson("/src/main/resources/investment/json/ui/my_mutual_fund_screen_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getFundSummary() {
        return ReadJson.readJson("/src/main/resources/investment/json/ui/fund_summary_screen_testcase_" + Setting.SERVER + ".json");
    }

}
