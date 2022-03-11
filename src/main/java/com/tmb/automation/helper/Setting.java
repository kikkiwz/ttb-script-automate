package com.tmb.automation.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;

public class Setting {
    public static String baseUrlUi = "https://cc-vit1.oneapp.tmbbank.local/useTab";
    public static String baseUrlApi = "https://cc-dev1.oneapp.tmbbank.local";
    public static String BASE_URL_UI = "https://cc-vit1.oneapp.tmbbank.local/useTab";
    public static String BASE_URL_API = "https://cc-dev1.oneapp.tmbbank.local";
    public static final String BASE_URL_UI_DEV = "https://cc-dev1.oneapp.tmbbank.local/useTab";
    public static final String BASE_URL_UI_VIT = "https://cc-vit1.oneapp.tmbbank.local/useTab";
    public static final String BASE_URL_UI_PRE = "https://cc-vit1.oneapp.tmbbank.local/useTab";
    public static final String BASE_URL_API_DEV = "https://cc-dev1.oneapp.tmbbank.local";
    public static final String BASE_URL_API_VIT = "https://cc-vit1.oneapp.tmbbank.local";
    public static final String BASE_URL_API_PRE = "https://cc-dev1.oneapp.tmbbank.local";
    public static final String DATE_TIME = new SimpleDateFormat("yyyy-MM-dd hh mm:ss").format(new Date());
    public static String DATE_TIME_REPORT = new SimpleDateFormat("yyyy-MM-dd-hh-mm:ss").format(new Date());
    public static final String IE_DRIVER = "src\\main\\resources\\driver\\IEDriverServer_11.exe";
    public static final String CH_DRIVER = "src\\main\\resources\\driver\\chromedriver_88.exe";
    public static final String EDGE_DRIVER = "src\\main\\resources\\driver\\msedgedriver_89_0_774_54.exe";
    public static final String CH_DRIVER_WIN = "src\\main\\resources\\driver\\chromedriver_88.exe";
    public static final String CH_DRIVER_MAC = "src\\main\\resources\\driver\\chromedriver_88_mac";
    public static final String ED_DRIVER_MAC = "src\\main\\resources\\driver\\msedgedriver_88_mac";
    public static BROWSER_TYPE BROWSER = BROWSER_TYPE.CHROME;
    public static String SERVER = "dev";
    public static AUTOMATE_TYPE AUTOMATE = AUTOMATE_TYPE.API;
    public static String TOKEN = "";
    public static String PROJECT_NAME = "Customer Care";
    public static String TEAM_NAME = "Platform2";
    public static final int TIME_OUT_IN_SECONDS = 60;
    public static final String MONGO_CLIENT_URL_DEV = "mongodb://employeeactivityusr:DEVemp_2021@10.171.0.83:27017/employeeactivity";
    public static final String MONGO_DATABASE_NAME_DEV = "employeeactivity";
    public static final String MONGO_COLLECTION_NAME_DEV = "employee_activity_log_information_";
    public static final String MONGO_SORTS_BY_COLUMN_DEV = "activity_date";
    public static String mongoEmployeeClientUrl = "mongodb://oneappusr:vitPwd_20@10.171.0.88:28000/oneappvit";
    public static String mongoEmployeeDatabaseName = "oneappvit";
    public static String mongoEmployeeCollectionName = "employee_activity_log_information_";
    public static String mongoEmployeeSortsByColumn = "activity_date";
    public static String mongoCustomerClientUrl = "mongodb://activityusr:DEVact_2021@10.171.0.83:27017/activity";
    public static String mongoCustomerDatabaseName = "activity";
    public static String mongoCustomerCollectionName = "activity_log_information_";
    public static String mongoCustomerSortsByColumn = "activity_date";

    public static String USER_ID = "occ_040";
    public static String API_PATH = "API Path: ";
//    public static final String MONGO_CLIENT_URL_VIT = "mongodb://oneappusr:vitPwd_20@10.171.0.88:28000/oneappvit";
//    public static final String MONGO_DATABASE_NAME_VIT = "oneappvit";
//    public static final String MONGO_COLLECTION_NAME_VIT = "employee_activity_log_information_202102";
//    public static final String MONGO_SORTS_BY_COLUMN_VIT = "activity_date";

    public static final String MONGO_CLIENT_URL_VIT = "mongodb://employeeactivityusr:PwDemp_2021@10.171.0.88:28000/employeeactivity";
    public static final String MONGO_DATABASE_NAME_VIT = "employeeactivity";
    public static final String MONGO_COLLECTION_NAME_VIT = "employee_activity_log_information_";
    public static final String MONGO_SORTS_BY_COLUMN_VIT = "activity_date";

    public static final String MONGO_CLIENT_URL_UAT = "mongodb://stmoneadbu4:28000,stmoneadbu5:28000/uat2_activity?replicaset=rs0&authsource=uat2_activity&tls=true&sslinvalidhostnameallowed=true";
    
    public static String MONGO_CLIENT_URL= "mongodb://activityusr:DEVact_2021@10.171.0.83:27017/oneappdev?authSource=activity&readPreference=primary&appname=MongoDB%20Compass&ssl=false";
    public static String MONGO_CLIENT_URL_ONEAPP_DEV = "mongodb://activityusr:DEVact_2021@10.171.0.83:27017/oneappdev?authSource=activity&readPreference=primary&appname=MongoDB%20Compass&ssl=false";
    public static String MONGO_DATABASE_NAME = "activity";
    public static String MONGO_COLLECTION_NAME = "activity_log_information_";
    public static String MONGO_SORTS_BY_COLUMN = "activity_date";
    public static String MONGO_CLIENT_URL_ONEAPP_VIT="mongodb://activityusr:PwDact_2021@10.171.0.88:28000/?authSource=activity&readPreference=primary&appname=MongoDB%20Compass&ssl=false";
    public static final String KEY_REPORT_EXPECTED_RESULT = "Expected Result: ";
    public static final String KEY_REPORT_RESPONSE_DATA = "Response Data: ";
    public static final String KEY_REPORT_REQUEST_DATA = "Request Body: ";
    public static final String SUCCESS = "success";
    public static final String FAILED = "failed";
    public static final String DATA_NOT_FOUND = "DATA NOT FOUND";
    public static final int MAX_STRING_IN_EXCEL_CELL = 32767;
    public static final String KEY_REPORT_DISPLAY_ERROR_MESSAGE = "Display Error message: ";
    public static final String KEY_REPORT_INPUT_DATA = "Input data: ";
    public static final String KEY_REPORT_BODY = "Body  ";
    public static final String KEY_REPORT_VISIT_PAGE = "Visit main page: ";
    public static final String KEY_REPORT_AUTHORIZATION = "Authorization: ";
    public static final String KEY_REPORT_PATH_URL = "Path URL: ";
    public static final String KEY_REPORT_COLUMN_EXCEL_NO = "No";
    public static final String KEY_REPORT_COLUMN_EXCEL_NAME = "Testcase name";
    public static final String KEY_REPORT_COLUMN_EXCEL_EXPECTED_RESULT = "Expected Result";
    public static final String KEY_REPORT_COLUMN_EXCEL_REQUEST = "Request";
    public static final String KEY_REPORT_COLUMN_EXCEL_HTTP_CODE = "Http Code";
    public static final String KEY_REPORT_COLUMN_EXCEL_RESPONSE = "Response";
    public static final String KEY_REPORT_COLUMN_EXCEL_LOGS_MONGO_DB = "Logs in MongoDB: ";
    public static final String KEY_REPORT_COLUMN_EXCEL_DATE_TIME = "Date Time";
    public static final String KEY_REPORT_COLUMN_EXCEL_STATUS = "Status";
    public static int MONGO_LIMIT = 10;
    public static int LOGS_ACTIVITY_DATE_MIN = 5;
    public static final String APP_KEY_NAME_DEV = "oneapp-dev";
    public static final String APP_KEY_VALUE_DEV = "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2";
    public static final int MIN_ACCOUNT_LOCKED = 7;
    public static final String SERVER_NAME[] = {
            "DEV server",
            "VIT server",
            "SIT server",
            "UAT server"};

    public enum RESULT_TYPE {
        PASS,
        FAILED,
        SKIP
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

    public class MongoDbLogsKey {
        public static final String KEY_AGENT_ID = "agent_id";
        public static final String KEY_EMP_ID = "emp_id";
        public static final String KEY_ACTIVITY_ID = "activity_type_id";
        public static final String KEY_CRM_ID = "crm_id";
    }

    public class SearchActivityLogs {
        public static final int DEFAULT_RECORD_NUMBERS = 25;
        public static final String KEY_TOTAL_RECORD = "Total record: ";
    }

    public class ExportPdfKey {
        public static final String TITLE_FILE = "TMB TCS Test Results & Evaluation Report of Platform2";
        public static final String SUBJECT = "Automate testing for Platform2";
        public static final String KEYWORDS = "TMB, TCS, AT, QA, Automate, Testing, Automation, Automate Testing, Platform, Platform2, Platform-II, PlatformII";
        public static final String AUTHOR = "Sakchai Choorat";
        public static final String CREATOR = "Sakchai Choorat";
        public static final String COVER_PAGE_TITLE = "TMB Test Results & Evaluation Report";
        public static final String COVER_PAGE_REPORT_BY = "Report generated by:";
        public static final String COVER_PAGE_SIGN_OFF = "Sign Off";
        public static final String COVER_PAGE_SIGN_OFF_DETAIL = "I have carefully assessed the Test Results and Evaluation Report for the Customer Care. This document has been completed in accordance with the requirements for the Customer Care Application.";
        public static final String COVER_PAGE_SIGN_OFF_CHECK_LIST = "BUSINESS SPONSOR CERTIFICATION - Please check the appropriate statement.";
        public static final String COVER_PAGE_SIGN_OFF_CHOICE_I = "☐ System is error free and ready to release.";
        public static final String COVER_PAGE_SIGN_OFF_CHOICE_II = "☐ System has errors that need to be addressed, but may still be released.";
        public static final String COVER_PAGE_SIGN_OFF_CHOICE_III = "☐ System has major shortcomings return for further development and testing.";
    }

    public static class Config {
        public static Boolean IS_EXPORT_EXCEL = false;
        public static Boolean IS_EXPORT_PDF = false;
        public static Boolean IS_SEND_EMAIL = false;
    }

    public static class EmailConfig {
        public static String SMTP_SERVER = "";
        public static String USER_NAME = "";
        public static String PASSWORD = "";
        public static String EMAIL_FROM = "";
    }




    public static class ManageAppDownTime {
        public static String seqNo = "";
    }


    public class SauceLabs {
//        public static final String USERNAME = "Sakchai.c";
//        public static final String ACCESS_KEY = "2e923e6b-f3f7-4a84-af85-ba16beb3d687";
//        public static final String URL = "https://Sakchai.c:2e923e6b-f3f7-4a84-af85-ba16beb3d687@ondemand.us-west-1.saucelabs.com:443/wd/hub";

        public static final String USERNAME = "cutterqa";
        public static final String ACCESS_KEY = "e383204a-617e-43b1-8783-241e4d5265da";
        public static final String URL = "https://cutterqa:e383204a-617e-43b1-8783-241e4d5265da@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    }
}


