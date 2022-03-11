package com.tmb.automation.api.investment.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;

public class Setting {
    public static final String BASE_URL_INVESTMENT = "http://investment-service-https-internal-dev1-oneapp.apps.ddid1.tmbcps.com";
    public static final String BASE_URL_PRODUCT = "http://products-exp-service-https-internal-dev1-oneapp.apps.ddid1.tmbcps.com";
    public static final String BASE_URL_CUSTOMER = "http://customers-service-https-internal-dev1-oneapp.apps.ddid1.tmbcps.com";

    public static String BASE_URL_UI = "https://cc-dev1.oneapp.tmbbank.local/login";
    public static String BASE_URL_API = "https://oneapp-dev1.tau2904.com";
    public static final String BASE_URL_UI_DEV = "https://cc-dev1.oneapp.tmbbank.local/login";
    public static final String BASE_URL_UI_VIT = "https://cc-vit1.oneapp.tmbbank.local/login";
    public static final String BASE_URL_UI_PRE = "https://cc-dev1.oneapp.tmbbank.local/login";
    public static final String BASE_URL_API_DEV = "https://oneapp-dev1.tau2904.com";
    public static final String BASE_URL_API_VIT = "https://oneapp-vit1.tau2904.com";
    public static final String BASE_URL_API_PRE = "https://cc-dev1.oneapp.tmbbank.local";
    public static final String DATE_TIME = new SimpleDateFormat("yyyy-MM-dd hh mm:ss").format(new Date());
    public static String DATE_TIME_REPORT = new SimpleDateFormat("yyyy-MM-dd-hh-mm:ss").format(new Date());
    public static final String IE_DRIVER = "src\\main\\resources\\driver\\IEDriverServer_11.exe";
    public static final String CH_DRIVER = "src\\main\\resources\\driver\\chromedriver_88.exe";
    public static final String CH_DRIVER_WIN = "src\\main\\resources\\driver\\chromedriver_88.exe";
    public static final String CH_DRIVER_MAC = "src\\main\\resources\\driver\\chromedriver_88_mac";
    public static final String ED_DRIVER_MAC = "src\\main\\resources\\driver\\msedgedriver_88_mac";
    public static BROWSER_TYPE BROWSER = BROWSER_TYPE.CHROME;
    public static String SERVER = "dev";
    public static AUTOMATE_TYPE AUTOMATE = AUTOMATE_TYPE.API;
    public static String TOKEN = "";

    public static String PROJECT_NAME = "TMB ONEAPP";
    public static String TEAM_NAME = "INVESTMENT";

    public static final int TIME_OUT_IN_SECONDS = 60;
    public static final String MONGO_CLIENT_URL_DEV = "mongodb://employeeactivityusr:DEVemp_2021@10.171.0.83:27017/employeeactivity";
    public static final String MONGO_DATABASE_NAME_DEV = "employeeactivity";
    public static final String MONGO_COLLECTION_NAME_DEV = "employee_activity_log_information_202102";
    public static final String MONGO_SORTS_BY_COLUMN_DEV = "activity_date";

    public static final String MONGO_CLIENT_URL_VIT = "mongodb://oneappusr:vitPwd_20@10.171.0.88:28000/oneappvit";
    public static final String MONGO_DATABASE_NAME_VIT = "oneappvit";
    public static final String MONGO_COLLECTION_NAME_VIT = "employee_activity_log_information_202102";
    public static final String MONGO_SORTS_BY_COLUMN_VIT = "activity_date";

    public static String MONGO_CLIENT_URL = "mongodb://oneappusr:vitPwd_20@10.171.0.88:28000/oneappvit";
    public static String MONGO_DATABASE_NAME = "oneappvit";
    public static String MONGO_COLLECTION_NAME = "employee_activity_log_information_202102";
    public static String MONGO_SORTS_BY_COLUMN = "activity_date";

    public static final String KEY_REPORT_EXPECTED_RESULT = "Expected Result: ";
    public static final String KEY_REPORT_RESPONSE_DATA = "Response Data: ";
    public static final String SUCCESS = "success";
    public static final String DATA_NOT_FOUND = "DATA NOT FOUND";
    public static final int MAX_STRING_IN_EXCEL_CELL = 32767;

    public static final String KEY_REPORT_DISPLAY_ERROR_MESSAGE = "Display Error message: ";
    public static final String KEY_REPORT_INPUT_DATA = "Input data: ";
    public static final String KEY_REPORT_BODY = "Body  ";
    public static final String KEY_REPORT_VISIT_PAGE = "Visit main page: ";
    public static final String KEY_REPORT_AUTHORIZATION = "Authorization: ";


    public static final String KEY_REPORT_COLUMN_EXCEL_NO = "No";
    public static final String KEY_REPORT_COLUMN_EXCEL_NAME = "Testcase name";
    public static final String KEY_REPORT_COLUMN_EXCEL_EXPECTED_RESULT = "Expected Result";
    public static final String KEY_REPORT_COLUMN_EXCEL_REQUEST = "Request";
    public static final String KEY_REPORT_COLUMN_EXCEL_HTTP_CODE = "Http Code";
    public static final String KEY_REPORT_COLUMN_EXCEL_RESPONSE = "Response";
    public static final String KEY_REPORT_COLUMN_EXCEL_LOGS_MONGO_DB = "Logs in MongoDB";
    public static final String KEY_REPORT_COLUMN_EXCEL_DATE_TIME = "Date Time";
    public static final String KEY_REPORT_COLUMN_EXCEL_STATUS = "Status";


    public static int MONGO_LIMIT = 1;
    public static int LOGS_ACTIVITY_DATE_MIN = 10;
    public static final String APP_KEY_NAME_DEV = "oneapp-dev";
    public static final String APP_KEY_VALUE_DEV = "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2";
    public static final int MIN_ACCOUNT_LOCKED = 7;
    public static String USER_ID = "occ_040";
    public static final String SERVER_NAME[] = {
            "DEV server",
            "UAT server",
            "PRE PROD server"};

    public enum RESULT_TYPE {
        PASS,
        FAILED
    }

    public enum LOGS_ACTIVITY_STATUS {
        SUCCESS,
        FAILED
    }

    public enum AUTOMATE_TYPE {
        API,
        UI,
        APP,
        DESKTOP
    }

    public enum BROWSER_TYPE {
        IE,
        CHROME,
        FIREFOX,
        OPERA,
        SAFARI,
        MICROSOFT_EDGE,
        NON
    }

    public enum LOGS_ACTIVITY_TYPE_ID {
        LOGIN,
        SEARCH
    }

    public static EnumMap<LOGS_ACTIVITY_TYPE_ID, String> logsActivityTypeId;

}
