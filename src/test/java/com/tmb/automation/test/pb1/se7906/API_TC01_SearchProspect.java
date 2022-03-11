package com.tmb.automation.test.pb1.se7906;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
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

public class API_TC01_SearchProspect extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1eKYC", "TestData_Sheet1", this.getClass().getSimpleName());
	}

	@Test(groups = { "android", "PB1" }, description = "Search Prospect")
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
		String device_id = map("device_id");
		String product_code = map("product_code");
		String cardIssueDate = map("cardIssueDate");
		String cardExpiryDate = map("cardExpiryDate");
		String DeviceID = map("DeviceID");
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
				.body(hmC)
				.when().post(CreateProspect)
				.then().assertThat().statusCode(200).extract().response();

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

//ekYC Search Prospect ----------------------------------------------------
		String SearchProspect = ApiUrlEKYC.SearchProspect;
		System.out.println("////////SearchProspect///////////-  " + "\n" + SearchProspect);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("device-id", DeviceID)
				.auth().none()
				.when().get(SearchProspect)
				.then().assertThat().statusCode(200).extract().response();

		String responseStringW = response.asString();
		System.out.println("////////////////responseStringW//////////////////-  " + "\n" + responseStringW);
		OpenReport.reportString("SearchProspect API- " +BaseURI +SearchProspect);
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
		String messageexpectedWS = "customers-ex-service";
		System.out.println("/////////AssertServiceWS///////-  " + "\n" + messageWS);
		Assert.assertEquals(messageWS, messageexpectedWS);

		String messageWD = jsW.getString("status.description.en");
		String messageexpectedWD = "success";
		System.out.println("/////////AssertmessageWD///////-  " + "\n" + messageWD);
		Assert.assertEquals(messageWD, messageexpectedWD);

		String dataWI = jsW.getString("data.customer.identification.id");
		System.out.println("/////////dataWI///////-  " + dataWI);
		Assert.assertEquals(dataWI, citizen_id );
		
		String dataWTh = jsW.getString("data.customer.title_thai");
		System.out.println("/////////dataWTh///////-  " + dataWTh);
		Assert.assertEquals(dataWTh, title_th  );
		
		String dataWEn = jsW.getString("data.customer.title_eng");
		System.out.println("/////////dataWEn///////-  " + dataWEn);
		Assert.assertEquals(dataWEn, title_en );
		
		String dataWFTh = jsW.getString("data.customer.firstname_thai");
		System.out.println("/////////dataWFTh///////-  " + dataWFTh);
		Assert.assertEquals(dataWFTh, name_th  );

		String dataWFEn = jsW.getString("data.customer.firstname_eng");
		System.out.println("/////////dataWFEn///////-  " + dataWFEn);
		Assert.assertEquals(dataWFEn, name_en );
		
		String dataWLTh = jsW.getString("data.customer.lastname_thai");
		System.out.println("/////////dataWLTh///////-  " + dataWLTh);
		Assert.assertEquals(dataWLTh, surname_th );

		String dataWLEn = jsW.getString("data.customer.lastname_eng");
		System.out.println("/////////dataWLEn///////-  " + dataWLEn);
		Assert.assertEquals(dataWLEn, surname_en  );
		
		String dataWB = jsW.getString("data.customer.birth_date");
		System.out.println("/////////dataWB///////-  " + dataWB);
		Assert.assertEquals(dataWB, date_of_birth  );
		
		String dataWM = jsW.getString("data.customer.mobile_no");
		System.out.println("/////////dataWM///////-  " + dataWM);
		Assert.assertEquals(dataWM, mobile_no );

		String dataWP = jsW.getString("data.prospect_id");
		System.out.println("/////////dataWP///////-  " + dataWP);
		Assert.assertEquals(dataWP, dataP1 );

		String dataWF = jsW.getString("data.customer.flow_state");
		System.out.println("/////////dataWF///////-  " + dataWF);
		Assert.assertEquals(dataWF, "SAVE_PROSPECT" );

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date());
		String dataWD = jsW.getString("data.customer.validate_date");
		System.out.println("/////////dataWD///////-  " + dataWD);
		Assert.assertEquals(dataWD, date );
		
		String dataWD1 = jsW.getString("data.customer.device_id");
		System.out.println("/////////dataWD1///////-  " + dataWD1);
		Assert.assertEquals(dataWD1, device_id );

		String dataWPr = jsW.getString("data.customer.product_code");
		System.out.println("/////////dataWPr///////-  " + dataWPr);
		Assert.assertEquals(dataWPr, product_code );
		
		String dataWRf = jsW.getString("data.customer.risk.fatca_answer");
		System.out.println("/////////dataWRf///////-  " + dataWRf);
		Assert.assertEquals(dataWRf, fatca_answer);
		
		String dataWCp = jsW.getString("data.customer.tc_product");
		System.out.println("/////////dataWCp///////-  " + dataWCp);
		Assert.assertEquals(dataWCp, tc_product);
		
		String dataWCc = jsW.getString("data.customer.tc_channel");
		System.out.println("/////////dataWCc///////-  " + dataWCc);
		Assert.assertEquals(dataWCc, tc_channel);
		
		System.out.println("///////////Search Prospect after Create Prospect Passed/////////////// ");

// Update Prospect Flow State----------------------------------------------------
		String UpdateProspect = ApiUrlEKYC.UpdateProspect;
		System.out.println("////////UpdateProspect///////////-  " +"\n" +UpdateProspect);
		
		HashMap<String, Object> hmC1 =new HashMap<>();
		hmC1.put("prospect_id", dataP1);
		hmC1.put("flow_state", "OTP_PASS");
		System.out.println("/////////body///////////-  "+"\n" +hmC1);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC1)
				.when().post(UpdateProspect)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC2 =response.asString();
		System.out.println("////////////////responseStringC2//////////////////-  "+"\n" +responseStringC2);
		OpenReport.reportString("UpdateProspect API- " +BaseURI +UpdateProspect);
		OpenReport.reportAPI(responseStringW);
		
		JsonPath jsC2=new JsonPath(responseStringC2); //for parsing Json
		String codeC2=jsC2.getString("status.code");
		String CodeExpectedC2= "0000";
		System.out.println("///////////AssertCodeC2 ////////////-   "+"\n" + codeC2);
		Assert.assertEquals(codeC2, CodeExpectedC2, "code validated");
		
		String messageC2=jsC2.getString("status.message");
		String messageexpectedC2 = "success";
		System.out.println("/////////AssertMessageC2///////-  "+"\n" + messageC2);
		Assert.assertEquals(messageC2, messageexpectedC2, "message validated");
		
		String messageS2=jsC2.getString("status.service");
		String messageexpectedS2 = "customers-ex-service";
		System.out.println("/////////AssertServiceS2///////-  "+"\n" + messageS2);
		Assert.assertEquals(messageS2, messageexpectedS2, "Service validated");
		
		String messageD2=jsC2.getString("status.description.en");
		String messageexpectedD2 = "success";
		System.out.println("/////////AssertmessageD2///////-  "+"\n" + messageD2);
		Assert.assertEquals(messageD2, messageexpectedD2, "description validated");
		
		System.out.println("///////////Flow State OTP_PASS Success/////////////// ");
		
//ekYC Search Prospect with flow state----------------------------------------------------
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("device-id", DeviceID)
				.auth().none()
				.when().get(SearchProspect)
				.then().assertThat().statusCode(200).extract().response();

		String responseStringS1 = response.asString();
		System.out.println("////////////////responseStringS1//////////////////-  " + "\n" + responseStringS1);
		OpenReport.reportString("SearchProspect API- " +BaseURI +SearchProspect);
		OpenReport.reportAPI(responseStringW);
		
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
		Assert.assertEquals(dataS1d, citizen_id );
		
		String dataS1e = jsS1.getString("data.customer.title_thai");
		System.out.println("/////////dataWS1e///////-  " + dataS1e);
		Assert.assertEquals(dataS1e, title_th);
		
		String dataS1f = jsS1.getString("data.customer.title_eng");
		System.out.println("/////////dataS1f///////-  " + dataS1f);
		Assert.assertEquals(dataS1f, title_en );
		
		String dataS1g = jsS1.getString("data.customer.firstname_thai");
		System.out.println("/////////dataS1g///////-  " + dataS1g);
		Assert.assertEquals(dataS1g, name_th  );

		String dataS1h = jsS1.getString("data.customer.firstname_eng");
		System.out.println("/////////dataS1h///////-  " + dataS1h);
		Assert.assertEquals(dataS1h, name_en );
		
		String dataS1i = jsS1.getString("data.customer.lastname_thai");
		System.out.println("/////////dataS1i///////-  " + dataS1i);
		Assert.assertEquals(dataS1i, surname_th );

		String dataS1j = jsS1.getString("data.customer.lastname_eng");
		System.out.println("/////////dataS1j///////-  " + dataS1j);
		Assert.assertEquals(dataS1j, surname_en  );
		
		String dataS1k = jsS1.getString("data.customer.birth_date");
		System.out.println("/////////dataS1k///////-  " + dataS1k);
		Assert.assertEquals(dataS1k, date_of_birth  );
		
		String dataS1l = jsS1.getString("data.customer.mobile_no");
		System.out.println("/////////dataS1l///////-  " + dataS1l);
		Assert.assertEquals(dataS1l, mobile_no );
		
		String dataS1m = jsS1.getString("data.prospect_id");
		System.out.println("/////////dataS1m///////-  " + dataS1m);
		Assert.assertEquals(dataS1m, dataS1m );

		String dataS1n = jsS1.getString("data.customer.flow_state");
		System.out.println("/////////dataS1n///////-  " + dataS1n);
		Assert.assertEquals(dataS1n, "OTP_PASS" );

		String dataS1o = jsS1.getString("data.customer.validate_date");
		System.out.println("/////////dataS1o///////-  " + dataS1o);
		Assert.assertEquals(dataS1o, date );
		
		String dataS1p = jsS1.getString("data.customer.device_id");
		System.out.println("/////////dataS1p///////-  " + dataS1p);
		Assert.assertEquals(dataS1p, device_id );

		String dataS1q = jsS1.getString("data.customer.product_code");
		System.out.println("/////////dataS1q///////-  " + dataS1q);
		Assert.assertEquals(dataS1q, product_code );
			
		System.out.println("///////////Search prospect after update FlowState Passed/////////////// ");
		
// Update Prospect ----------------------------------------------------
		HashMap<String, Object> hmC2 =new HashMap<>();
		hmC2.put("prospect_id", dataP1);
		hmC2.put("verify_method", "7-11");
		System.out.println("/////////body///////////-  "+"\n" +hmC2);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC2)
				.when().post(UpdateProspect)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC3 =response.asString();
		System.out.println("////////////////responseStringC3//////////////////-  "+"\n" +responseStringC3);
		OpenReport.reportString("UpdateProspect API- " +BaseURI +UpdateProspect);
		OpenReport.reportAPI(responseStringC3);
		
		JsonPath jsC3=new JsonPath(responseStringC3); //for parsing Json
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
		
		String messageD3=jsC3.getString("status.description.en");
		String messageexpectedD3 = "success";
		System.out.println("/////////AssertmessageD3///////-  "+"\n" + messageD3);
		Assert.assertEquals(messageD3, messageexpectedD3, "description validated");
		
		System.out.println("///////////Flow State OTP_PASS Success/////////////// ");
		
//ekYC Search Prospect with verify method----------------------------------------------------
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.header("device-id", DeviceID)
				.auth().none()
				.when().get(SearchProspect)
				.then().assertThat().statusCode(200).extract().response();

		String responseStringS2 = response.asString();
		System.out.println("////////////////responseStringS2//////////////////-  " + "\n" + responseStringS2);
		OpenReport.reportString("SearchProspect API- " +BaseURI +SearchProspect);
		OpenReport.reportAPI(responseStringS2); 
		
		JsonPath jsS2 = new JsonPath(responseStringS2); // for parsing Json
		String codeS2 = jsS2.getString("status.code");
		String CodeExpectedS2 = "0000";
		System.out.println("///////////AssertCodeW1 ////////////-   " + "\n" + codeW1);
		Assert.assertEquals(codeS2, CodeExpectedS2);
		
		String messageS2a = jsS2.getString("status.message");
		String messageexpectedS2a = "success";
		System.out.println("/////////AssertMessageS2///////-  " + "\n" + messageS2a);
		Assert.assertEquals(messageS2a, messageexpectedS2a);

		String messageS2b = jsS2.getString("status.service");
		String messageexpectedS2b = "customers-ex-service";
		System.out.println("/////////AssertServiceS2b///////-  " + "\n" + messageS2b);
		Assert.assertEquals(messageS2b, messageexpectedS2b);

		String messageS2c = jsS2.getString("status.description.en");
		String messageexpectedS2c = "success";
		System.out.println("/////////AssertmessageS2c///////-  " + "\n" + messageS2c);
		Assert.assertEquals(messageS2c, messageexpectedS2c);

		String dataS2d = jsS2.getString("data.customer.identification.id");
		System.out.println("/////////dataS2d///////-  " + dataS2d);
		Assert.assertEquals(dataS2d, citizen_id );
		
		String dataS2e = jsS2.getString("data.customer.title_thai");
		System.out.println("/////////dataWS2e///////-  " + dataS2e);
		Assert.assertEquals(dataS2e, title_th);
		
		String dataS2f = jsS2.getString("data.customer.title_eng");
		System.out.println("/////////dataS2f///////-  " + dataS2f);
		Assert.assertEquals(dataS2f, title_en );
		
		String dataS2g = jsS2.getString("data.customer.firstname_thai");
		System.out.println("/////////dataS2g///////-  " + dataS2g);
		Assert.assertEquals(dataS2g, name_th  );

		String dataS2h = jsS2.getString("data.customer.firstname_eng");
		System.out.println("/////////dataS2h///////-  " + dataS2h);
		Assert.assertEquals(dataS2h, name_en );
		
		String dataS2i = jsS2.getString("data.customer.lastname_thai");
		System.out.println("/////////dataS2i///////-  " + dataS2i);
		Assert.assertEquals(dataS2i, surname_th );

		String dataS2j = jsS2.getString("data.customer.lastname_eng");
		System.out.println("/////////dataS2j///////-  " + dataS2j);
		Assert.assertEquals(dataS2j, surname_en  );
		
		String dataS2k = jsS2.getString("data.customer.birth_date");
		System.out.println("/////////dataS2k///////-  " + dataS2k);
		Assert.assertEquals(dataS2k, date_of_birth  );
		
		String dataS2l = jsS2.getString("data.customer.mobile_no");
		System.out.println("/////////dataS2l///////-  " + dataS2l);
		Assert.assertEquals(dataS2l, mobile_no );

		String dataS2m = jsS2.getString("data.prospect_id");
		System.out.println("/////////dataS2m///////-  " + dataS2m);
		Assert.assertEquals(dataS2m, dataS2m );

		String dataS2v = jsS2.getString("data.customer.verify_method");
		System.out.println("/////////dataS2v///////-  " + dataS2v);
		Assert.assertEquals(dataS2v, "7-11" );

		String dataS2n = jsS2.getString("data.customer.flow_state");
		System.out.println("/////////dataS2n///////-  " + dataS2n);
		Assert.assertEquals(dataS2n, "OTP_PASS" );
		
		String dataS2o = jsS2.getString("data.customer.validate_date");
		System.out.println("/////////dataS2o///////-  " + dataS2o);
		Assert.assertEquals(dataS2o, date );
		
		String dataS2p = jsS2.getString("data.customer.device_id");
		System.out.println("/////////dataS2p///////-  " + dataS2p);
		Assert.assertEquals(dataS2p, device_id );

		String dataS2q = jsS2.getString("data.customer.product_code");
		System.out.println("/////////dataS2q///////-  " + dataS2q);
		Assert.assertEquals(dataS2q, product_code );
		
		System.out.println("///////////Search Prospect after update verify method Passed/////////////// ");
	}
}
