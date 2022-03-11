package com.tmb.automation.test.pb1.c14814;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

public class API_TC03_CardlessActivityLog extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		}
	
	@Test(groups = {"api", "PB1"}, description ="Cardless ActivityLog")
	public void Test001 () throws InterruptedException, IOException {
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
		String ActivityLog = ApiUrlCardless.ActivityLog;
		System.out.println("----------CRM---------- " + CRM);
		System.out.println("----------ActivityLog---------- " + ActivityLog);
		
		String access_tokenV= API_Login.Login(); //to call into test class
		System.out.println("///////////Login Success/////////////// ");

//Script -----------------------------------------------------------------------------------
		String activity_type_id = "102300101";
		String activity_status = "success";
		String fail_reason = "xxx";
		String flow = "Cardless or Withdrawal Screen";
		String from_account = "0123456789";
		String amount = "121.11";
		
		HashMap<String, String> hmC = new HashMap<>();
		hmC.put("activity_type_id", activity_type_id);
		hmC.put("activity_status", activity_status);
		hmC.put("fail_reason", fail_reason);
		hmC.put("flow", flow);
		hmC.put("from_account", from_account);
		hmC.put("amount", amount);
		System.out.println("/////////body///////////-  " + "\n" + hmC);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).auth().oauth2(access_tokenV)
				.body(hmC).when().post(ActivityLog).then().assertThat().statusCode(200).extract().response();
		
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
		
		String messageD1=jsC.getString("status.description");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+ messageD1);
		Assert.assertEquals(messageD1, messageexpectedD);

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
		System.out.println("-------Details1a-------- : " +Details1a);
		System.out.println("-------Details1b-------- : " + Details1b);
		System.out.println("-------Details1c-------- : " + Details1c);
		Assert.assertEquals(Details1a, "Flow = "+flow);
		
		String from_account1 = from_account.substring(from_account.length() - 4);
		Assert.assertEquals(Details1b, "From Account = XX" +from_account1);
		Assert.assertEquals(Details1c, "Amount = "+amount);
		
		System.out.println("///////////Cardless Activity Log Success/////////////// ");				
	}
	
}
