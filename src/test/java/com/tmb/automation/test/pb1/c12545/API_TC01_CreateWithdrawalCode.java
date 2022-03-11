package com.tmb.automation.test.pb1.c12545;

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

public class API_TC01_CreateWithdrawalCode extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		}
	
	@Test(groups = {"api", "PB1"}, description ="Create Withdrawal Code")
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
		String DeviceID = ApiUrlCardless.DeviceID;
		String verifypin=ApiUrlCardless.verifypin;
		String pin=ApiUrlCardless.pin;
		System.out.println("----------CRM---------- " + CRM);
		System.out.println("----------GenerateCode---------- " + GenerateCode);
		String activity_type_id = "102300102";
		
		String access_tokenV= API_Login.Login(); //to call into test class
		System.out.println("///////////Login Success/////////////// ");
		
		
		//-------Verify Pin--------------
		String module = "cardless";
		String ref_id = "abc";
		
		
		HashMap<String, String> hmC3 = new HashMap<>();
		hmC3.put("module", module);
		hmC3.put("pin", pin);
		hmC3.put("ref_id", ref_id);
		
		System.out.println("/////////body///////////-  " + "\n" + hmC3);
		RestAssured.baseURI = BaseURI;
		Response response2 = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("App-Version", "10.0")
				.header("Channel", "MB")
				.header("Timestamp", "1625738794")
				.header("X-CRMID", CRM)
				.header("Device-Id", "S9L9u77t6RNcNufZYPA+JSfRvIF5HLeWZa+OGxjWiD4zA30t5I6fTaCAsRpEKNSbg2CWmMtwAnXwtuLH7mN9Fhr9S2E24ix9ZHBWOmXRXDxxYaa/pfGnVTCth49jLbpIFk2FWPH5++Ek2OmREx5aOKryGS033XWvNRsuHs2Nrbx9JMg/7BEFJml9A1D+dus3bRSlXuIz+TgSzJoLLwLI1qcoUH4V+jUeeAu6iMw2dvujI9BnIAxD74YckdjsC0pDryNAnDSzprL8Gq0UNZvomTMFa9dV7LANARt5xu8kgPcxpyzKPpJZ5PimlNhKjDGRx5SPTh3frDDBM2Vr3KDCow==")
				.auth().oauth2(access_tokenV)
				.body(hmC3).when().post(verifypin).then().assertThat().statusCode(200).extract().response();
		
		String responseStringverify =response2.asString();
		System.out.println("////////////////responseStringC//////////////////-  " +responseStringverify);
		OpenReport.reportAPI(responseStringverify);
		
		JsonPath jsC1=new JsonPath(responseStringverify); //for parsing Json
		String codeC1verify=jsC1.getString("status.code");
		String CodeExpectedC1verify= "0000";
		System.out.println("///////////AssertCodeC1 ////////////- " + codeC1verify);
		Assert.assertEquals(codeC1verify, CodeExpectedC1verify);
		
		String messageC1verify=jsC1.getString("status.message");
		String messageexpectedCverify = "success";
		System.out.println("/////////AssertMessageC1///////-  "+ messageC1verify);
		Assert.assertEquals(messageC1verify, messageexpectedCverify);

		String messageS1verify=jsC1.getString("status.service");
		String messageexpectedS1verify = "oneapp-auth-service";
		System.out.println("/////////AssertServiceS1///////-  "+ messageS1verify);
		Assert.assertEquals(messageS1verify, messageexpectedS1verify);
		
		String messageD1verify=jsC1.getString("data");
		String messageexpectedDverify = "Pin verification successful";
		System.out.println("/////////AssertmessageD1///////-  "+ messageD1verify);
		Assert.assertEquals(messageD1verify, messageexpectedDverify);
		

//Script -----------------------------------------------------------------------------------
		String account_number = "0012705869";
		String account_name ="all free account";
		String customer_name = "MR MUKESH PATRA";
		String account_type = "SDA";
		String mobile_number = "0817315935";
		String transaction_date = "2022-01-12 10:04:23";
		String transaction_type = "Withdraw";
		String amount = "200.00";
		String language = "en";
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
				.header("App-Version", "10.0")
				.header("Channel", "MB")
				.header("Timestamp", "1625738794")
				.header("X-Real-IP", "10.10.188.123")
				.header("X-CRMID", CRM)
				.header("Device-Id", DeviceID)
				.header("Flow-Name", "home")
				.header("ref-id", "abc").auth().oauth2(access_tokenV)
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
				.header("X-Correlation-ID", XCorrelation).header("Timestamp", "1605501863")
				.header("Accept-Language", "en-US")
				.auth().oauth2(access_tokenV1).body(hmC2).when().post(ccweb);

		String responseStringW = response1.asString();
		System.out.println("////////////////responseStringW//////////////////-  " + "\n" + responseStringW);
		OpenReport.reportString("ccweb API- " +ccwebBase +ccweb);
		OpenReport.reportAPI(responseStringW);
		int statusCode2 = response1.getStatusCode();
		String statusString2 = Integer.toString(statusCode2);
		OpenReport.reportString("ccweb Status- "+statusString2);
		System.out.println("-----statusCode2-----: " +statusCode2);
		Assert.assertEquals(statusCode2, 200);

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
		String Details1d = Details1[3];
		String Details1e = Details1[4];
		System.out.println("-------Details1a-------- : " +Details1a);
		System.out.println("-------Details1b-------- : " + Details1b);
		System.out.println("-------Details1c-------- : " +Details1c);
		System.out.println("-------Details1d-------- : " + Details1d);
		System.out.println("-------Details1e-------- : " + Details1e);
		
		Assert.assertEquals(Details1a, "Flow = "+"home");
		String from_account1 = account_number.substring(account_number.length() - 4);
		Assert.assertEquals(Details1b, "From Account = XX" +from_account1);

		Assert.assertEquals(Details1c, "Amount = "+amount);
		Assert.assertEquals(Details1d, "Withdrawal Code = "+messageAC1);
		
		System.out.println("///////////Cardless Withdrawal Code Success/////////////// ");				
	}
	
}
