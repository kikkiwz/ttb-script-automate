package com.tmb.automation.api.investment;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tmb.automation.api.investment.base.Base;
import com.tmb.automation.api.investment.base.Setting;
import com.tmb.automation.api.investment.config.GetJsonData;
import com.tmb.automation.api.investment.model.FundListModel;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.http.Method;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FundListTest extends Base {

    public enum CheckFlag {
        ALL,
        BOUGHT,
        FOLLOWING
    }

    public enum CategoryGroup {
        TYPE_OF_FUND,
        ASSET_CLASS,
        FUND_HOUSE,
        CUSTOM
    }

    public void verifyFundList(String testcaseName, Boolean isScenario, @Optional CheckFlag checkFlag, @Optional CategoryGroup categoryGroup) throws JsonProcessingException {

        String pathApi = "/apis/products/funds/search/fundList";

        FundListModel fundListModel = new Gson().fromJson(String.valueOf(GetJsonData.getFundList().get(testcaseName)), FundListModel.class);

        if (isScenario) {
            parentReport = extent.createTest(fundListModel.ScenarioName, fundListModel.ScenarioName);
        }
        childReport = parentReport.createNode(fundListModel.Description);

        httpRequest.body(new Gson().toJson(fundListModel.TestData));

        responseBody = httpRequest.filters(logsFilter).request(Method.POST, Setting.BASE_URL_API + pathApi);


        FundListModel responseModel = new Gson().fromJson(responseBody.getBody().asString(), FundListModel.class);

        boolean isOK = false;
        JSONArray finalResult = new JSONArray();
        JSONObject allFinalResult = new JSONObject();
        String finalResponse = null;


        switch (checkFlag) {
            case ALL:
                try {
                    if (categoryGroup.equals(CategoryGroup.TYPE_OF_FUND)) {
                        for (int i = 0; i < responseModel.data.length; i++) {
                            if (responseBody.getStatusCode() == 200 && (responseModel.data[i].fundTypeGroup).equalsIgnoreCase(fundListModel.ExpectedResultKey[4])) {

                            }

                        }

                    } else if (categoryGroup.equals(CategoryGroup.ASSET_CLASS)) {

                    } else if (categoryGroup.equals(CategoryGroup.FUND_HOUSE)) {

                    } else if (categoryGroup.equals(CategoryGroup.CUSTOM)) {

                    }
                } catch (Exception ex) {
                    for (int i = 0; i < responseModel.data.length; i++) {
                        isOK = true;
                        finalResult.add(responseModel.data[i]);
                    }
                }
                isOK = true;

                break;
            case BOUGHT:
                for (int i = 0; i < responseModel.data.length; i++) {
                    if (responseBody.getStatusCode() == 200 && responseModel.data[i].fundCode.toLowerCase().equals(fundListModel.ResponseData.data[0].fundCode.toLowerCase()) && fundListModel.ResponseData.data[0].boughtFlag.toLowerCase().equals(fundListModel.ResponseData.data[0].boughtFlag.toLowerCase())) {
                        isOK = true;
                        finalResult.add(responseModel.data[i]);
                        break;
                    } else {
                        isOK = false;
                    }
                }
                break;
            case FOLLOWING:
                for (int i = 0; i < responseModel.data.length; i++) {
                    if (responseBody.getStatusCode() == 200 && responseModel.data[i].fundCode.toLowerCase().equals(fundListModel.ResponseData.data[0].fundCode.toLowerCase()) && fundListModel.ResponseData.data[0].followingFlag.toLowerCase().equals(fundListModel.ResponseData.data[0].followingFlag.toLowerCase())) {
                        isOK = true;
                        finalResult.add(responseModel.data[i]);
                        break;
                    } else {
                        isOK = false;
                    }
                }
                break;
        }

//        System.err.println("finalResult >>" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(finalResult));

        allFinalResult.put("status", responseModel.status);
        allFinalResult.put("data", finalResult);

        finalResponse = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(allFinalResult);


        childReport.log(Status.INFO, "Request data: <pre> " + TextColor.blueColor(ConvertStringToJson.jsonFormat(new Gson().toJson(fundListModel.TestData))) + "</pre>");
        childReport.log(Status.INFO, "Response data: <pre> " + TextColor.resultColor(isOK, ConvertStringToJson.jsonFormat(finalResponse) + "</pre>"));

        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
                fundListModel.Description, Arrays.toString(fundListModel.ExpectedResult),
                StringUtils.substring(logsFilter.getRequestBuilder().toString(), 0, Setting.MAX_STRING_IN_EXCEL_CELL),
                responseBody.getStatusCode(),
                StringUtils.substring(finalResponse, 0, Setting.MAX_STRING_IN_EXCEL_CELL),
//                ConvertStringToJson.jsonFormat(StringUtils.substring(finalResponse, 0, Setting.MAX_STRING_IN_EXCEL_CELL)),
                "",
                getDateTime(),
                isPass(isOK)});

        Assert.assertTrue(isOK);

        validateResponseStatus(responseModel, fundListModel.ExpectedResultKey[0], fundListModel.ExpectedResultKey[1], fundListModel.ExpectedResultKey[2], fundListModel.ExpectedResultKey[3]);

    }

    @Test(priority = 1)
    void verifyFundListAll() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Fund_List_0001";
        addHeader();
        verifyFundList(testcaseName, true, CheckFlag.ALL, null);

    }


    @Test(priority = 2)
    void verifyFundListBoughtFlagIsY() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Fund_List_0002";
//        addHeader();
        verifyFundList(testcaseName, false, CheckFlag.BOUGHT, null);

    }

    @Test(priority = 3)
    void verifyFundListFollowingFlagIsY() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Fund_List_0003";
        verifyFundList(testcaseName, false, CheckFlag.FOLLOWING, null);

    }

    @Test(priority = 4)
    void verifyFundListBoughtFlagIsN() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Fund_List_0004";
        verifyFundList(testcaseName, false, CheckFlag.BOUGHT, null);

    }

    @Test(priority = 5)
    void verifyFundListFollowingFlagIsN() throws Exception {
        String testcaseName = "TC_OneApp_Investment_Fund_List_0005";
        verifyFundList(testcaseName, false, CheckFlag.FOLLOWING, null);
    }

}