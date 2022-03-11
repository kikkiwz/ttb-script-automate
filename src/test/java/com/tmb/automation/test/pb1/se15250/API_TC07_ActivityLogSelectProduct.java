package com.tmb.automation.test.pb1.se15250;

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
import com.tmb.automation.pages.pb1.ekyc.ApiUrlEKYC;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC07_ActivityLogSelectProduct extends Base {

	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1eKYC", "TestData_Sheet1", this.getClass().getSimpleName()); 
	}
	
	@Test(groups = {"android", "PB1"}, description="ActivityLog SelectMethod")
	public void Test001 () throws InterruptedException, IOException {
		log("------------Start "+this.getClass().getSimpleName());

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		System.out.println("////////BaseURI///////////-  " + "\n" + BaseURI);
		System.out.println("///////XCorrelation////////////-  " + "\n" + XCorrelation);
		
		String CreateProspect = ApiUrlEKYC.CreateProspect;
		System.out.println("////////CreateProspect///////////-  " + "\n" + CreateProspect);

//ekYC Create prospect Script ----------------------------------------------------
		String citizen_id = map("id");
		String title_en = map("titleEn");
		String title_th = map("titleTh");
		String gender = map("gender");
		String name_en = map("firstNameEn");
		String surname_en = map("lastNameEn");
		String name_th = map("firstNameTh");
		String surname_th = map("lastNameTh");
		String date_of_birth = map("dob");
		String mobile_no = map("mobile");
		String product_code = map("product_code");
		String cardIssueDate = map("cardIssueDate");
		String cardExpiryDate = map("cardExpiryDate");
		String DeviceID = map("DeviceID");
		String tc_channel = "Y|1.0";
		String tc_product = "Y|1.0";
		String fatca_answer = "N|N";
		String image = "kdfjkkjfkdjkfdjkfsklfskdfjlksdjflksdj";
		
		String activity_type = map("ActivityID");
		
		HashMap<String, String> hmC = new HashMap<>();
		hmC.put("citizen_id", citizen_id);
		hmC.put("title_en", title_en);
		hmC.put("title_th", title_th);
		hmC.put("gender", gender);
		hmC.put("name_en", name_en);
		hmC.put("name_th", name_th);
		hmC.put("surname_en", surname_en);
		hmC.put("surname_th", surname_th);
		hmC.put("date_of_birth", date_of_birth);
		hmC.put("issue_date", cardIssueDate);
		hmC.put("expiry_date", cardExpiryDate);
		hmC.put("mobile_no", mobile_no);
		hmC.put("tc_channel", tc_channel);
		hmC.put("tc_product", tc_product);
		hmC.put("fatca_answer", fatca_answer);
		hmC.put("image", image);
		hmC.put("product_code", product_code);
		System.out.println("/////////body///////////-  " + "\n" + hmC);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).header("device-id", DeviceID).auth().none()
				.body(hmC).when().post(CreateProspect).then().assertThat().statusCode(200).extract().response();

		String responseStringC = response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " + "\n" + responseStringC);
		OpenReport.reportString("CreateProspect API- " +BaseURI +CreateProspect);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC = new JsonPath(responseStringC); // for parsing Json
		String codeC1 = jsC.getString("status.code");
		String CodeExpectedC1 = "0000";
		System.out.println("///////////AssertCodeC1 ////////////-   " + "\n" + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		
		String messageC1 = jsC.getString("status.message");
		String messageexpectedC = "success";
		System.out.println("/////////AssertMessageC1///////-  " + "\n" + messageC1);
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");

		String messageS1 = jsC.getString("status.service");
		String messageexpectedS = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  " + "\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");

		String messageD1 = jsC.getString("status.description.en");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  " + "\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");

		String dataP1 = jsC.getString("data.prospect_id");
		System.out.println("/////////dataP1///////-  " + "\n" + dataP1);
		Assert.assertNotNull(dataP1, "prospect_id validated");

		String dataC1 = jsC.getString("data.citizen_id");
		System.out.println("/////////dataC1///////-  " + "\n" + dataC1);
		Assert.assertEquals(dataC1, citizen_id);

		System.out.println("///////////Create Prospect Success/////////////// ");

//ekYC Activity Log ----------------------------------------------------
		String ActivityLog = ApiUrlEKYC.ActivityLog;
		System.out.println("////////ActivityLog///////////-  " +"\n" +ActivityLog);
		String Input1 = "eKYC - Start to select Product";
		String Input2 = "Home Screen";
		String Input3 = "All Free Account";
		
		HashMap<String, Object> hmC1 =new HashMap<>();
		hmC1.put("activity_type_id", activity_type);
		hmC1.put("activity_status", "success");
		hmC1.put("fail_reason", "");
		hmC1.put("step_number", Input1);
		hmC1.put("flow", Input2);
		hmC1.put("product", Input3);
	    	
		System.out.println("/////////hmC1///////////-  "+"\n" +hmC1);
	
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("X-crmid", dataP1)
				.auth().none()
				.body(hmC1)
				.when().post(ActivityLog)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC1 =response.asString();
		System.out.println("////////////////responseStringC1//////////////////-  "+"\n" +responseStringC1);
		OpenReport.reportString("ActivityLog API- " +BaseURI +ActivityLog);
		OpenReport.reportAPI(responseStringC1);
		
		JsonPath jsC3=new JsonPath(responseStringC1); //for parsing Json
		String codeC3=jsC3.getString("status.code");
		String CodeExpectedC3= "0000";
		System.out.println("///////////AssertCodeC3 ////////////-   "+"\n" + codeC3);
		Assert.assertEquals(codeC3, CodeExpectedC3, "code validated");
		
		String messageC3=jsC3.getString("status.message");
		String messageexpectedC3 = "success";
		System.out.println("/////////AssertMessageC3///////-  "+"\n" + messageC3);
		Assert.assertEquals(messageC3, messageexpectedC3, "message validated");
		
		String messageS3=jsC3.getString("status.service");
		String messageexpectedS3 = "customers-ex-service";
		System.out.println("/////////AssertServiceS3///////-  "+"\n" + messageS3);
		Assert.assertEquals(messageS3, messageexpectedS3, "Service validated");
		
		String messageD3=jsC3.getString("status.description");
		String messageexpectedD3 = "success";
		System.out.println("/////////AssertmessageD3///////-  "+"\n" + messageD3);
		Assert.assertEquals(messageD3, messageexpectedD3, "description validated");

		System.out.println("///////////ActivityLog Success/////////////// ");
		
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
		OpenReport.reportString("Login Status is "+statusString);
		System.out.println("-----statusCode1-----: " +statusCode1);
		Assert.assertEquals(statusCode1, 200);
		
		JsonPath js1 = new JsonPath(responseString1); // for parsing Json
		String codeV1 = js1.getString("status.code");
		System.out.println("////////////////code//////////////////-  " + "\n" + codeV1);
		String messageV1 = js1.getString("status.message");
		System.out.println("////////////////message//////////////////-   " + "\n" + messageV1);
		String access_tokenV1 = js1.getString("data.access_token");
		System.out.println("////////////////access_token1//////////////////-  " + "\n" + access_tokenV1);

		System.out.println("///////////CCWeb Login Success/////////////// ");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());
		
		HashMap<String, Object> hmC2 = new HashMap<>();
		hmC2.put("crm_id", dataP1);
		hmC2.put("start_date", date);
		hmC2.put("start_time", "00:00");
		hmC2.put("end_date", date);
		hmC2.put("end_time", "23:59");
		hmC2.put("activity_type_id", activity_type);
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
		OpenReport.reportString("CCWeb Status2 is "+statusString2);
		System.out.println("-----statusCode2-----: " +statusCode2);
		Assert.assertEquals(statusCode2, 200);

		JsonPath jsW = new JsonPath(responseStringW); // for parsing Json
		String codeW1 = jsW.getString("status.code");
		String CodeExpectedW1 = "0000";
		System.out.println("///////////AssertCodeW1 ////////////-   " + "\n" + codeW1);
		Assert.assertEquals(codeW1, CodeExpectedW1);
		
		String messageW = jsW.getString("status.message");
		String messageexpectedW = "success";
		System.out.println("/////////AssertMessageW1///////-  " + "\n" + messageW);
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
		Assert.assertEquals(Details1a, "Step = "+Input1);
		Assert.assertEquals(Details1b, "Flow = "+Input2);
		Assert.assertEquals(Details1c, "Product = "+Input3);
	
		System.out.println("///////////ActivityLog Success/////////////// ");
	}
	
}
