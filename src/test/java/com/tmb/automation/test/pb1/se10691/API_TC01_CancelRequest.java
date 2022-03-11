package com.tmb.automation.test.pb1.se10691;

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

public class API_TC01_CancelRequest extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1eKYC", "TestData_Sheet1", this.getClass().getSimpleName());
	}

	@Test(groups = { "android", "PB1" }, description = "Cancel Request")
	public void Test001() throws InterruptedException, IOException {
		log("------------Start " + this.getClass().getSimpleName());
		
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
		String device_id = map("device_id");
		String tc_channel = "Y|1.0";
		String tc_product = "Y|1.0";
		String fatca_answer = "N|N";

		String image = "kdfjkkjfkdjkfdjkfsklfskdfjlksdjflksdj";

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

// Update Prospect ----------------------------------------------------
		String UpdateProspect = ApiUrlEKYC.UpdateProspect;
		System.out.println("////////UpdateProspect///////////-  " + UpdateProspect);

		HashMap<String, Object> hmC2 = new HashMap<>();
		hmC2.put("prospect_id", dataP1);
		hmC2.put("verify_method", "7-11 or MB");
		hmC2.put("flow_state", "OTP_PASS");
		System.out.println("/////////body///////////-  " + "\n" + hmC2);

		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).auth().none().body(hmC2).when()
				.post(UpdateProspect).then().assertThat().statusCode(200).extract().response();

		String responseStringC3 = response.asString();
		System.out.println("////////////////responseStringC3//////////////////-  " + "\n" + responseStringC3);
		OpenReport.reportString("UpdateProspect API- " +BaseURI +UpdateProspect);
		OpenReport.reportAPI(responseStringC3);

		JsonPath jsC3 = new JsonPath(responseStringC3); // for parsing Json
		String codeC3 = jsC3.getString("status.code");
		String CodeExpectedC3 = "0000";
		System.out.println("///////////AssertCodeC3 ////////////-   " + "\n" + codeC3);
		Assert.assertEquals(codeC3, CodeExpectedC3, "code validated");
		
		String messageC3 = jsC3.getString("status.message");
		String messageexpectedC3 = "success";
		System.out.println("/////////AssertMessageC3///////-  " + "\n" + messageC3);
		Assert.assertEquals(messageC3, messageexpectedC3, "message validated");

		String messageS3 = jsC3.getString("status.service");
		String messageexpectedS3 = "customers-ex-service";
		System.out.println("/////////AssertServiceS3///////-  " + "\n" + messageS3);
		Assert.assertEquals(messageS3, messageexpectedS3, "Service validated");

		String messageD3 = jsC3.getString("status.description.en");
		String messageexpectedD3 = "success";
		System.out.println("/////////AssertmessageD3///////-  " + "\n" + messageD3);
		Assert.assertEquals(messageD3, messageexpectedD3, "description validated");

		System.out.println("///////////Update Prospect Success/////////////// ");

// Get Bank for verification ----------------------------------------------------------------
		String VerifyNDID = ApiUrlEKYC.VerifyNDID;
		System.out.println("////////VerifyNDID///////////-  " + "\n" + VerifyNDID);

		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).header("X-Citizen-ID", citizen_id).auth().none()
				.when().get(VerifyNDID).then().assertThat().statusCode(200).extract().response();

		String responseStringC4 = response.asString();
		System.out.println("////////////////responseStringC4//////////////////-  " + "\n" + responseStringC4);
		
		JsonPath jsC4 = new JsonPath(responseStringC4); // for parsing Json
		String codeC4 = jsC4.getString("status.code");
		String CodeExpectedC4 = "0000";
		System.out.println("///////////AssertCodeC4 ////////////-   " + "\n" + codeC4);
		Assert.assertEquals(codeC4, CodeExpectedC4, "code validated");
		
		String messageC4 = jsC4.getString("status.message");
		String messageexpectedC4 = "success";
		System.out.println("/////////AssertMessageC4///////-  " + "\n" + messageC4);
		Assert.assertEquals(messageC4, messageexpectedC4, "message validated");

		String messageC4a = jsC4.getString("status.service");
		String messageexpectedC4a = "accounts-service";
		System.out.println("/////////AssertServiceC4a///////-  " + "\n" + messageC4a);
		Assert.assertEquals(messageC4a, messageexpectedC4a, "Service validated");

		String messageC4b = jsC4.getString("status.description.en");
		String messageexpectedC4b = "success";
		System.out.println("/////////AssertmessageC4b///////-  " + "\n" + messageC4b);
		Assert.assertEquals(messageC4b, messageexpectedC4b, "description validated");

		JSONObject jo1 = new JSONObject(responseStringC4);
		JSONArray ja1 = jo1.getJSONArray("data");
		System.out.println("////////////////ja1//////////////////-  " + ja1);
		String s1 = ja1.get(2).toString();
		JSONObject jo2 = new JSONObject(s1);
		System.out.println("////////////////jo2//////////////////-  " + jo2);
		String idr = jo2.getString("id");
		System.out.println("////////////////idr//////////////////-  " + idr);
		String nar = jo2.getString("description");
		System.out.println("////////////////nar//////////////////-  " + nar);

// Bank Transaction ----------------------------------------------------
		String NDIDRequest = ApiUrlEKYC.NDIDRequest;
		System.out.println("////////NDIDRequest///////////-  " + NDIDRequest);

		HashMap<String, Object> hmC1 = new HashMap<>();
		hmC1.put("prospect_id", dataP1);
		hmC1.put("citizen_id", citizen_id);
		hmC1.put("aal_level", "2.2");
		hmC1.put("ial_level", "2.3");
		hmC1.put("provider_list", idr); // get bank id of bkk
		System.out.println("/////////bodyC1///////////-  " + "\n" + hmC1);

		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).auth().none().body(hmC1).when()
				.post(NDIDRequest).then().assertThat().statusCode(200).extract().response();

		String responseStringW = response.asString();
		System.out.println("////////////////responseStringW//////////////////-  " + "\n" + responseStringW);
		OpenReport.reportString("NDIDRequest API- " +BaseURI +NDIDRequest);
		OpenReport.reportAPI(responseStringW);

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
		String messageexpectedWS = "accounts-service";
		System.out.println("/////////AssertServiceWS///////-  " + "\n" + messageWS);
		Assert.assertEquals(messageWS, messageexpectedWS);

		String messageWD = jsW.getString("status.description.en");
		String messageexpectedWD = "success";
		System.out.println("/////////AssertmessageWD///////-  " + "\n" + messageWD);
		Assert.assertEquals(messageWD, messageexpectedWD);

		String dataWI = jsW.getString("data.customer.id");
		System.out.println("/////////dataWI///////-  " + dataWI);
		Assert.assertEquals(dataWI, citizen_id);
		
		String dataWPI = jsW.getString("data.providers.id");
		System.out.println("/////////dataWPI///////-  " + dataWPI);
		Assert.assertEquals(dataWPI, ("["+idr+"]"));
		
		String dataWRI = jsW.getString("data.reference_id");
		System.out.println("/////////dataWRI///////-  " + dataWRI);
		Assert.assertNotNull(dataWRI, "reference");

		String dataWNI = jsW.getString("data.ndid_reference_id");
		System.out.println("/////////dataWNI///////-  " + dataWNI);
		Assert.assertNotNull(dataWNI, "ndid reference");

		System.out.println("///////////Bank Transaction Passed/////////////// ");

// ekYC Search Prospect ----------------------------------------------------
		String SearchProspect = ApiUrlEKYC.SearchProspect;
		System.out.println("////////SearchProspect///////////-  " + "\n" + SearchProspect);
		
		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).header("device-id", DeviceID).auth().none()
				.when().get(SearchProspect).then().assertThat().statusCode(200).extract().response();

		String responseStringS1 = response.asString();
		System.out.println("////////////////responseStringS1//////////////////-  " + "\n" + responseStringS1);
		OpenReport.reportString("SearchProspect API- " +BaseURI +SearchProspect);
		OpenReport.reportAPI(responseStringS1);

		JsonPath jsS1 = new JsonPath(responseStringS1); // for parsing Json
		String codeS1 = jsS1.getString("status.code");
		String CodeExpectedS1 = "0000";
		System.out.println("///////////AssertCodeW1 ////////////-   " + "\n" + codeW1);
		Assert.assertEquals(codeS1, CodeExpectedS1);
		
		String messageS1a = jsS1.getString("status.message");
		String messageexpectedS1a = "success";
		System.out.println("/////////AssertMessageS1///////-  " + "\n" + messageS1a);
		Assert.assertEquals(messageS1a, messageexpectedS1a);

		String messageS1b = jsS1.getString("status.service");
		String messageexpectedS1b = "customers-ex-service";
		System.out.println("/////////AssertServiceS1b///////-  " + "\n" + messageS1b);
		Assert.assertEquals(messageS1b, messageexpectedS1b);

		String messageS1c = jsS1.getString("status.description.en");
		String messageexpectedS1c = "success";
		System.out.println("/////////AssertmessageS1c///////-  " + "\n" + messageS1c);
		Assert.assertEquals(messageS1c, messageexpectedS1c);

		String dataS1d = jsS1.getString("data.customer.identification.id");
		System.out.println("/////////dataS1d///////-  " + dataS1d);
		Assert.assertEquals(dataS1d, citizen_id);

		String dataS1e = jsS1.getString("data.customer.title_thai");
		System.out.println("/////////dataWS1e///////-  " + dataS1e);
		Assert.assertEquals(dataS1e, title_th);

		String dataS1f = jsS1.getString("data.customer.title_eng");
		System.out.println("/////////dataS1f///////-  " + dataS1f);
		Assert.assertEquals(dataS1f, title_en);

		String dataS1g = jsS1.getString("data.customer.firstname_thai");
		System.out.println("/////////dataS1g///////-  " + dataS1g);
		Assert.assertEquals(dataS1g, name_th);

		String dataS1h = jsS1.getString("data.customer.firstname_eng");
		System.out.println("/////////dataS1h///////-  " + dataS1h);
		Assert.assertEquals(dataS1h, name_en);

		String dataS1i = jsS1.getString("data.customer.lastname_thai");
		System.out.println("/////////dataS1i///////-  " + dataS1i);
		Assert.assertEquals(dataS1i, surname_th);

		String dataS1j = jsS1.getString("data.customer.lastname_eng");
		System.out.println("/////////dataS1j///////-  " + dataS1j);
		Assert.assertEquals(dataS1j, surname_en);

		String dataS1k = jsS1.getString("data.customer.birth_date");
		System.out.println("/////////dataS1k///////-  " + dataS1k);
		Assert.assertEquals(dataS1k, date_of_birth);

		String dataS1l = jsS1.getString("data.customer.mobile_no");
		System.out.println("/////////dataS1l///////-  " + dataS1l);
		Assert.assertEquals(dataS1l, mobile_no);

		String dataS1m = jsS1.getString("data.prospect_id");
		System.out.println("/////////dataS1m///////-  " + dataS1m);
		Assert.assertEquals(dataS1m, dataS1m);

		String dataS1n = jsS1.getString("data.customer.flow_state");
		System.out.println("/////////dataS1n///////-  " + dataS1n);
		Assert.assertEquals(dataS1n, "SEND_NDID_REQUEST");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date());
		String dataS1o = jsS1.getString("data.customer.validate_date");
		System.out.println("/////////dataS1o///////-  " + dataS1o);
		Assert.assertEquals(dataS1o, date);

		String dataS1p = jsS1.getString("data.customer.device_id");
		System.out.println("/////////dataS1p///////-  " + dataS1p);
		Assert.assertEquals(dataS1p, device_id);

		String dataS1q = jsS1.getString("data.customer.reference_id");
		System.out.println("/////////dataS1q///////-  " + dataS1q);
		Assert.assertEquals(dataS1q, dataWRI);

		String dataS1r = jsS1.getString("data.customer.product_code");
		System.out.println("/////////dataS1r///////-  " + dataS1r);
		Assert.assertEquals(dataS1r, product_code);

		System.out.println("///////////Search Prospect after bank validate/////////////// ");

// Verify Status pending--------------------------------------------------------
		String VerifyStatus = ApiUrlEKYC.VerifyStatus;
		System.out.println("////////VerifyStatus///////////-  " + VerifyStatus);

		HashMap<String, Object> hmC4 = new HashMap<>();
		hmC4.put("prospect_id", dataP1);
		hmC4.put("citizen_id", citizen_id);
		hmC4.put("reference_id", dataS1q);
		System.out.println("/////////bodyC3///////////-  " + "\n" + hmC4);

		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).auth().none().body(hmC4).when()
				.post(VerifyStatus).then().assertThat().statusCode(400).extract().response();

		String responseStringV2 = response.asString();
		System.out.println("////////////////responseStringV2//////////////////-  " + "\n" + responseStringV2);
		OpenReport.reportString("VerifyStatus API- " +BaseURI +VerifyStatus);
		OpenReport.reportAPI(responseStringV2);

		JsonPath jsV2 = new JsonPath(responseStringV2); // for parsing Json
		String codeV2 = jsV2.getString("status.code");
		String CodeExpectedV2 = "ekyc_ndid_0000";
		System.out.println("///////////AssertCodeV2 ////////////-   " + "\n" + codeV2);
		Assert.assertEquals(codeV2, CodeExpectedV2);

		String messageV2 = jsV2.getString("status.message");
		String messageexpectedV2 = "request ndid is pending.";
		System.out.println("/////////AssertMessageV2///////-  " + "\n" + messageV2);
		Assert.assertEquals(messageV2, messageexpectedV2);

		String messageV2S = jsV2.getString("status.service");
		String messageexpectedV2S = "customers-ex-service";
		System.out.println("/////////AssertServiceV2S///////-  " + "\n" + messageV2S);
//		Assert.assertEquals(messageV2S, messageexpectedV2S);

		String messageV2D = jsV2.getString("status.description.en");
		String messageexpectedV2D = "Unable to proceed. For more information please call 1428.";
		System.out.println("/////////AssertmessageV2D///////-  " + "\n" + messageV2D);
//		Assert.assertEquals(messageV2D, messageexpectedV2D);

		String messageV2I = jsV2.getString("data.provider.id");
		System.out.println("/////////AssertServiceV2I///////-  " + "\n" + messageV2S);
		Assert.assertEquals(messageV2I, idr);

		String messageV2B = jsV2.getString("data.provider.name_en");
		System.out.println("/////////AssertServiceV2B///////-  " + "\n" + messageV2B);
		Assert.assertEquals(messageV2B, nar);
		
		System.out.println("///////////Verify Status pending passed/////////////// ");
		
// Verify Cancel Request --------------------------------------------------------
		String CancelRequest = ApiUrlEKYC.CancelRequest;
		System.out.println("////////CancelRequest///////////-  " + CancelRequest);
		
		HashMap<String, Object> hmC3 = new HashMap<>();
		hmC3.put("prospect_id", dataP1);
		hmC3.put("reference_id", dataS1q);
		System.out.println("/////////bodyC3///////////-  " + "\n" + hmC3);

		response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).auth().none().body(hmC3).when()
				.post(CancelRequest).then().assertThat().statusCode(200).extract().response();

		String responseStringV = response.asString();
		System.out.println("////////////////responseStringV//////////////////-  " + "\n" + responseStringV);
		OpenReport.reportString("CancelRequest API- " +BaseURI +CancelRequest);
		OpenReport.reportAPI(responseStringV);

		JsonPath jsV1 = new JsonPath(responseStringV); // for parsing Json
		String codeV11 = jsV1.getString("status.code");
		String CodeExpectedV11 = "0000";
		System.out.println("///////////AssertCodeV11 ////////////-   " + "\n" + codeV11);
		Assert.assertEquals(codeV11, CodeExpectedV11);
		
		String messageV1 = jsV1.getString("status.message");
		String messageexpectedV1 = "success";
		System.out.println("/////////AssertMessageV11///////-  " + "\n" + messageV1);
		Assert.assertEquals(messageV1, messageexpectedV1);

		String messageV1S = jsV1.getString("status.service");
		String messageexpectedV1S = "customers-ex-service";
		System.out.println("/////////AssertServiceV1S///////-  " + "\n" + messageV1S);
//		Assert.assertEquals(messageV1S, messageexpectedV1S);

		String messageV1D = jsV1.getString("status.description.en");
		String messageexpectedV1D = "success";
		System.out.println("/////////AssertmessageV1D///////-  " + "\n" + messageV1D);
//		Assert.assertEquals(messageV1D, messageexpectedV1D);

		System.out.println("///////////Verify Cancel Request Passed/////////////// ");		
		}

}
