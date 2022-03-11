package com.tmb.automation.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.tmb.automation.common.MongoDB;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.LoginLogsModel;

public class ActivityLogWeb extends Base {
	public static String ACTIVITY_LOG_URL;
	public static String MONGO_DATABASE_NAME;
	public static String MONGO_COLLECTION_NAME;
	public static String MONGO_SORTS_BY_COLUMN;
	
	public void ActivityLog(String activityID, String activitytype,String activitystatus,Long StartTime,int index,String value, ExtentTest Scenario,String report) {
		try {
		String Environment=prop.getProperty("Environment");
		Date date =new Date();
		Long Endtime = date.getTime();
		SimpleDateFormat MongoDBdate1 = new SimpleDateFormat("yyyyMM");  
		Date date1 = new Date();  
		String MongoDBdate=MongoDBdate1.format(date1);
		System.out.println("MongoDBdate is --"+MongoDBdate);
		String username = mapData.get("username");
		MongoDB mongoDB = new MongoDB();
		BasicDBObject query = new BasicDBObject();
		query.put(Setting.MongoDbLogsKey.KEY_AGENT_ID, new BasicDBObject("$eq", username));
		query.put(Setting.MongoDbLogsKey.KEY_ACTIVITY_ID, new BasicDBObject("$eq",activityID));
		query.put("activity_date",new BasicDBObject("$gte", StartTime).append("$lte", Endtime)); 
		System.out.println("The query is-----"+query);
		if(Environment.equalsIgnoreCase("DEV")) {
			ACTIVITY_LOG_URL=Setting.MONGO_CLIENT_URL_DEV;
			MONGO_DATABASE_NAME=Setting.MONGO_DATABASE_NAME_DEV;
			MONGO_COLLECTION_NAME=Setting.MONGO_COLLECTION_NAME_DEV;
		    MONGO_SORTS_BY_COLUMN=Setting.MONGO_SORTS_BY_COLUMN_DEV;
		}
		if(Environment.equalsIgnoreCase("VIT")) {
			ACTIVITY_LOG_URL=Setting.MONGO_CLIENT_URL_VIT;
			MONGO_DATABASE_NAME=Setting.MONGO_DATABASE_NAME_VIT;
			MONGO_COLLECTION_NAME=Setting.MONGO_COLLECTION_NAME_VIT;
		    MONGO_SORTS_BY_COLUMN=Setting.MONGO_SORTS_BY_COLUMN_VIT;
		}
		List listData = mongoDB.connectDB(ACTIVITY_LOG_URL,
				MONGO_DATABASE_NAME, MONGO_COLLECTION_NAME+MongoDBdate, query,
				MONGO_SORTS_BY_COLUMN, Setting.MONGO_LIMIT);
		System.out.println("The size for add  is ----"+listData.size());
		for(int i=0;i<listData.size();i++) {
			System.out.println("The data is----"+listData.get(i));
		}
		Assert.assertEquals(listData.size(), 1,"The action stored in activity log should be one");
		LoginLogsModel logsData = new Gson().fromJson(String.valueOf(listData.get(0)), LoginLogsModel.class);
		logsData.activitydescription[index].getValue();
		Assert.assertTrue(logsData.activity_type.equals(activitytype),activitytype+ " activitytype should captured in activity log");
		Assert.assertTrue(logsData.activity_status.equals("Success"), activitystatus+" Status should captured in activity log");
		Assert.assertTrue(logsData.activitydescription[index].getValue().equalsIgnoreCase(value), value+ " activity log verified ");
		System.out.println("MongoDB connection done sucessfully");		
		Scenario.createNode(Given.class, report+" with activity type "+activitytype+"  and ativity status "+activitystatus).pass("VERIFIED");

	}
	catch(Throwable t){
		
		Scenario.createNode(Given.class, "Verification of activity log is failed expected activity type "+activitytype+"  and ativity status "+activitystatus).fail(t);	
	}


	}

}
