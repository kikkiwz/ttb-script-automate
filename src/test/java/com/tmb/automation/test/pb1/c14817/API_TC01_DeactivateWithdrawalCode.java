package com.tmb.automation.test.pb1.c14817;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.OpenReport;
import com.tmb.automation.pages.pb1.cardless.API_Login;
import com.tmb.automation.pages.pb1.cardless.ApiUrlCardless;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* API Test
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC01_DeactivateWithdrawalCode extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		}
	
	@Test(groups = {"api", "PB1"}, description ="Deactivate Withdrawal Code")
	public void Test001 () throws InterruptedException, IOException, ParseException {
		log("------------Start "+this.getClass().getSimpleName());
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		
		System.out.println("----------BaseURI---------- " + BaseURI);
		System.out.println("----------XCorrelation---------- " + XCorrelation);
		
		String CRM = ApiUrlCardless.CRM;
		String GenerateCode = ApiUrlCardless.GenerateCode;
		String DeactivateCode = ApiUrlCardless.DeactivateCode;
		String DeviceID = ApiUrlCardless.DeviceID;
		System.out.println("----------CRM---------- " + CRM);
		System.out.println("----------GenerateCode---------- " + GenerateCode);
		System.out.println("----------DeactivateCode---------- " + DeactivateCode);
		String activity_type_id = "102300200";
		
		String access_tokenV= API_Login.Login(); //to call into test class
		System.out.println("///////////Login Success/////////////// ");

//Script -----------------------------------------------------------------------------------
		String account_number = "0017644972";
		String account_name ="Acount Name";
		String customer_name = "Customer Name";
		String account_type = "SDA";
		String mobile_number = "0817315935";
		String transaction_date = "2021-01-01 15:35:06";
		String transaction_type = "Withdraw";
		String amount = "200.00";
		String language = "EN";
		String channel_id = "02";
		
		HashMap<String, String> hmC = new HashMap<>();
		hmC.put("account_number", account_number);
		hmC.put("account_name", account_name);
		hmC.put("customer_name", customer_name);
		hmC.put("account_type", account_type);
		hmC.put("mobile_number", mobile_number);
		hmC.put("transaction_date", transaction_date);
		hmC.put("transaction_type", transaction_type);
		hmC.put("amount", amount);
		hmC.put("language", language);
		hmC.put("channel_id", channel_id);
		System.out.println("/////////body///////////-  " + "\n" + hmC);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("Device-Model", "AndroidPhone")
				.header("App-Version", "1.0")
				.header("OS-Version", "Android 11.0")
				.header("Channel", "MB")
				.header("Timestamp", "1625738794")
				.header("X-Real-IP", "10.10.188.123")
				.header("device-os-type", "Android")
				.header("device-os-version", "10")
				.header("Device-Id", DeviceID)
				.header("flow-name", "Cardless Screen")
				.auth().oauth2(access_tokenV)
				.body(hmC).when().post(GenerateCode).then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " +responseStringC);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0000";
		System.out.println("///////////AssertCodeC1 ////////////- " + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1);
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "success";
		System.out.println("/////////AssertMessageC1///////-  "+ messageC1);
		Assert.assertEquals(messageC1, messageexpectedC);

		String messageS1=jsC.getString("status.service");
		String messageexpectedS1 = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  "+ messageS1);
		Assert.assertEquals(messageS1, messageexpectedS1);
		
		String messageD1=jsC.getString("status.description.en");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+ messageD1);
		Assert.assertEquals(messageD1, messageexpectedD);

		String messageAC1=jsC.getString("data.access_code");
		System.out.println("///////////messageAC1 ////////////- " + messageAC1);
		
		String messageAC2=jsC.getString("data.account_number");
		System.out.println("/////////messageAC2///////-  "+ messageAC2);
		Assert.assertEquals(messageAC2, account_number);

		String messageAN1=jsC.getString("data.account_name");
		System.out.println("/////////messageAN1///////-  "+ messageAN1);
		Assert.assertEquals(messageAN1, account_name);
		
		String messageAM1=jsC.getString("data.amount");
		System.out.println("/////////messageAM1///////-  "+ messageAM1);
		Assert.assertEquals(messageAM1, amount);
		
		String messageGD1=jsC.getString("data.generate_date");
		System.out.println("/////////messageGD1///////-  "+ messageGD1);
		String TimeStart= messageGD1.substring(11,16);
		System.out.println("/////////TimeStart///////-  "+ TimeStart);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Date d = df.parse(TimeStart); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, 2);
		String EndTime = df.format(cal.getTime());
		System.out.println("/////////EndTime///////-  "+ EndTime);
		
		String messageEX1=jsC.getString("data.expire_date");
		System.out.println("/////////messageEX1///////-  "+ messageEX1);
		String EndTime2= messageEX1.substring(11,16);
		System.out.println("/////////EndTime2///////-  "+ EndTime2);
//		Assert.assertEquals(EndTime, EndTime2);
		
//Deactive code ------------------------------------------------------------------------
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("Device-Model", "AndroidPhone")
				.header("App-Version", "1.0")
				.header("OS-Version", "Android 11.0")
				.header("Channel", "MB")
				.header("Timestamp", "1625738794")
				.header("X-Real-IP", "10.10.188.123")
				.header("device-os-type", "Android")
				.header("device-os-version", "10")
				.header("Device-Id", DeviceID)
				.header("flow-name", "Cardless Screen")
				.auth().oauth2(access_tokenV)
				.when().post(DeactivateCode).then().assertThat().statusCode(200).extract().response();
		
		String responseStringC2 =response.asString();
		System.out.println("////////////////responseStringC2//////////////////-  " +responseStringC2);
		OpenReport.reportAPI(responseStringC2);
		
		JsonPath jsC2=new JsonPath(responseStringC2); //for parsing Json
		String codeC2=jsC2.getString("status.code");
		String CodeExpectedC2= "0000";
		System.out.println("///////////codeC2 ////////////- " + codeC2);
		Assert.assertEquals(codeC2, CodeExpectedC2);
		
		String messageC2=jsC2.getString("status.message");
		String messageexpectedC2 = "success";
		System.out.println("/////////messageC2///////-  "+ messageC2);
		Assert.assertEquals(messageC2, messageexpectedC2);

		String messageS2=jsC2.getString("status.service");
		String messageexpectedS2 = "customers-ex-service";
		System.out.println("/////////messageS2///////-  "+ messageS2);
		Assert.assertEquals(messageS2, messageexpectedS2);
		
		String messageD2=jsC2.getString("status.description.en");
		String messageexpected2 = "success";
		System.out.println("/////////messageD2///////-  "+ messageD2);
		Assert.assertEquals(messageD2, messageexpected2);
		
//Verify in ccweb ------------------------------------------------------------------
		String ccwebBase= prop.getProperty("ccwebBase");
		ccwebBase= System.getProperty("ccWeb", ccwebBase);
		String userN1 = prop.getProperty("ccwebuserName");
		String passW1 = prop.getProperty("ccwebpassword");
		String ccweblogin= prop.getProperty("ccweblogin");
		String ccwebAuthorization= prop.getProperty("ccwebAuthorization");
		if (ccwebBase.equals("https://cc-uat2.oneapp.tmbbank.local")) {
			ccwebAuthorization= prop.getProperty("ccwebAuthorizationUAT");
		}
		String ccweb = prop.getProperty("ccweburl");
		ccweb= System.getProperty("ccWebEnv", ccweb);
				
		RestAssured.baseURI = ccwebBase;
		Response response1 = given().relaxedHTTPSValidation()
				.header("X-Correlation-ID", XCorrelation)
				.header("Authorization", ccwebAuthorization)
				.multiPart("grant_type", "password").multiPart("username", userN1)
				.multiPart("password", passW1).when().post(ccweblogin);

		String responseString1 = response1.asString();
		System.out.println("////////////////responseString//////////////////-  " + responseString1);
		int statusCode1 = response1.getStatusCode();
		String statusString = Integer.toString(statusCode1);
		OpenReport.reportString("ccweblogin API- " +ccwebBase +ccweblogin);
		OpenReport.reportString("ccweblogin Status- "+statusString);
		System.out.println("-----statusCode1-----: " +statusCode1);
		Assert.assertEquals(statusCode1, 200);
		
		JsonPath js1 = new JsonPath(responseString1); // for parsing Json
		String codeV1 = js1.getString("status.code");
		System.out.println("////////////////code//////////////////-  " + codeV1);
		String messageV1 = js1.getString("status.message");
		System.out.println("////////////////message//////////////////-   " + messageV1);
		String access_tokenV1 = js1.getString("data.access_token");
		System.out.println("////////////////access_token1//////////////////-  " + access_tokenV1);

		System.out.println("///////////CCWeb Login Success/////////////// ");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());
		
		HashMap<String, Object> hmC2 = new HashMap<>();
		hmC2.put("crm_id", CRM);
		hmC2.put("start_date", date);
		hmC2.put("start_time", "00:00");
		hmC2.put("end_date", date);
		hmC2.put("end_time", "23:59");
		hmC2.put("activity_type_id", activity_type_id);
		hmC2.put("page", "1");

		System.out.println("/////////bodyC1///////////-  " + "\n" + hmC2);

		response1 = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).header("Timestamp", "1625738794")
				.header("Accept-Language", "en-US")
				.auth().oauth2(access_tokenV1).body(hmC2).when().post(ccweb);

		String responseStringW = response1.asString();
		System.out.println("////////////////responseStringW//////////////////-  " + responseStringW);
		OpenReport.reportString("ccweb API- " +ccwebBase +ccweb);
		OpenReport.reportAPI(responseStringW);
		int statusCodeW = response1.getStatusCode();
		String statusStringW = Integer.toString(statusCodeW);
		OpenReport.reportString("ccweb Status- "+statusStringW);
		Assert.assertEquals(statusCodeW, 200);
		
		JsonPath jsW = new JsonPath(responseStringW); // for parsing Json
		String codeW1 = jsW.getString("status.code");
		String CodeExpectedW1 = "0000";
		System.out.println("///////////AssertCodeW1 ////////////-   " + codeW1);
		Assert.assertEquals(codeW1, CodeExpectedW1);
		
		String messageW = jsW.getString("status.message");
		String messageexpectedW = "success";
		System.out.println("/////////AssertMessageW1///////-  " + messageW);
		Assert.assertEquals(messageW, messageexpectedW);

		String messageWS = jsW.getString("status.service");
		String messageexpectedWS = "cc-exp-service";
		System.out.println("/////////AssertServiceWS///////-  " + "\n" + messageWS);
		Assert.assertEquals(messageWS, messageexpectedWS);

		JSONObject jo1 = new JSONObject(responseStringW);
		JSONArray ja1 = jo1.getJSONArray("data");
		System.out.println("////////////////ja1//////////////////-  " + ja1);
		
		JSONObject jo3 = ja1.getJSONObject(0);
		String result = jo3.getString("result");
		String activity_detail = jo3.getString("activity_detail");
		System.out.println("/////////////result//////////- " + result);
		Assert.assertEquals(result, "Success");
		
		System.out.println("/////////////activity_detail//////////- " + activity_detail);	
		String Details1[] = activity_detail.split("@#@");
		String Details1a = Details1[0];
		String Details1b = Details1[1];
		String Details1c = Details1[2];
		System.out.println("-------Details1a-------- : " +Details1a);
		System.out.println("-------Details1b-------- : " + Details1b);
		System.out.println("-------Details1c-------- : " +Details1c);
		
		Assert.assertEquals(Details1a, "Flow = "+"Cardless Screen");
		Assert.assertNotNull(Details1b);
		Assert.assertNotNull(Details1c);
		
		System.out.println("///////////Deactivate Withdrawal Code Success/////////////// ");
	}
	
}
