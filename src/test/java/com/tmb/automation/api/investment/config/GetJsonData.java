package com.tmb.automation.api.investment.config;

import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.util.ReadJson;
import org.json.simple.JSONObject;

public class GetJsonData {

    public static JSONObject getLogin() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/login_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getAccountDetail() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/account_detail_testcase_" + Setting.SERVER + ".json");
    }


    public static JSONObject getCreateFavoriteFund() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/create_favorite_fund_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getAipOrder() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/aip_order_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getFundCategory() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/fund_category_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getEditPortNickName() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/edit_portofolio_nickname_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getFundFactSheet() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/fund_fact_sheet_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getFundInfo() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/fund_info_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getFundListBySuitScore() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/fund_list_by_suitability_score_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getFundList() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/fund_list_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getFundSummary() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/fund_summary_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getOpenPortfolio() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/open_portfolio_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getPastPerformance() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/past_performance_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getSearchFund() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/search_fund_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getStatement() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/statement_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getSuggestAllocation() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/suggest_allocation_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getSuitabilityAnswer() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/suitability_answer_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getSuitabilityInquiry() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/suitability_inquiry_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getSuitabilityQuestion() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/suitability_question_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getTaxDocument() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/tax_document_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getTaxSummary() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/tax_summary_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getUpdateFavoriteFund() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/update_favorite_fund_testcase_" + Setting.SERVER + ".json");
    }

    public static JSONObject getViewAIP() {
        return ReadJson.readJson("/src/main/resources/investment/json/api/view_aip_testcase_" + Setting.SERVER + ".json");
    }


//    public static JSONObject getDailyNav() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/daily_nav_testcase_" + Setting.SERVER + ".json");
//    }
//
//
//    public static JSONObject getFundFamily() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/fund_family_testcase_" + Setting.SERVER + ".json");
//    }
//
//    public static JSONObject getFundHoliday() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/fund_holiday_testcase_" + Setting.SERVER + ".json");
//    }
//
//    public static JSONObject getAvailableSummary() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/available_Summary_testcase_" + Setting.SERVER + ".json");
//    }
//
//
//    public static JSONObject getAlternativeBuy() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/alternative_buy_testcase_" + Setting.SERVER + ".json");
//    }
//
//    public static JSONObject getAlternativeSellAndSwitch() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/alternative_sell_and_switch_testcase_" + Setting.SERVER + ".json");
//    }
//

//

//
//    public static JSONObject getPaymentDetail() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/payment_detail_testcase_" + Setting.SERVER + ".json");
//    }
//
//
//    public static JSONObject getStatementByPort() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/statement_by_port_testcase_" + Setting.SERVER + ".json");
//    }
//

//
//    public static JSONObject getTermFund() {
//        return ReadJson.readJson("/src/main/resources/investment/json/api/term_fund_testcase_" + Setting.SERVER + ".json");
//    }
//


}
