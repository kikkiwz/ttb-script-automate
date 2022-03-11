package com.tmb.automation.util.platform2;

import com.google.gson.Gson;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.GetJsonData;


public class TmbConfiguration {
    public static void setup(String environment,Boolean isGenerateExportExcelFile,Boolean isSendExportEmail) {

       // Properties prop = new Properties();
        //            prop.load(App.class.getClassLoader().getResourceAsStream("Platform2.properties"));
        EnvironmentModel dataModel = new Gson().fromJson(String.valueOf(GetJsonData.getEnvironment()), EnvironmentModel.class);

        switch (environment.toLowerCase().toString()) {
            case "dev":
                Setting.SERVER = "dev";
                Setting.baseUrlUi = dataModel.server.dev;
                Setting.baseUrlApi = dataModel.server.dev;
                Setting.mongoEmployeeClientUrl = dataModel.mongodb.employee.dev.client_url;
                Setting.mongoEmployeeDatabaseName = dataModel.mongodb.employee.dev.database_name;
                Setting.mongoEmployeeCollectionName = DateTime.getMongoCollectionName(dataModel.mongodb.employee.dev.collection_name);
                Setting.mongoEmployeeSortsByColumn = dataModel.mongodb.employee.dev.sorts_by_column;
                Setting.mongoCustomerClientUrl = dataModel.mongodb.customer.dev.client_url;
                Setting.mongoCustomerDatabaseName= dataModel.mongodb.customer.dev.database_name;
                Setting.mongoCustomerCollectionName = DateTime.getMongoCollectionName(dataModel.mongodb.customer.dev.collection_name);
                Setting.mongoCustomerSortsByColumn = dataModel.mongodb.customer.dev.sorts_by_column;
                break;
            case "vit":
                Setting.SERVER = "vit";
                Setting.baseUrlUi = dataModel.server.vit;
                Setting.baseUrlApi = dataModel.server.vit;
                Setting.mongoEmployeeClientUrl = dataModel.mongodb.employee.vit.client_url;
                Setting.mongoEmployeeDatabaseName = dataModel.mongodb.employee.vit.database_name;
                Setting.mongoEmployeeCollectionName = DateTime.getMongoCollectionName(dataModel.mongodb.employee.vit.collection_name);
                Setting.mongoEmployeeSortsByColumn = dataModel.mongodb.employee.vit.sorts_by_column;
                Setting.mongoCustomerClientUrl = dataModel.mongodb.customer.vit.client_url;
                Setting.mongoCustomerDatabaseName= dataModel.mongodb.customer.vit.database_name;
                Setting.mongoCustomerCollectionName = DateTime.getMongoCollectionName(dataModel.mongodb.customer.vit.collection_name);
                Setting.mongoCustomerSortsByColumn = dataModel.mongodb.customer.vit.sorts_by_column;
                break;
            case "sit":
                Setting.SERVER = "sit";
                break;
            case "uat":
                Setting.SERVER = "uat";
                break;
        }

        Setting.Config.IS_SEND_EMAIL = isSendExportEmail;
        Setting.Config.IS_EXPORT_EXCEL = isGenerateExportExcelFile;
    }
}
