package com.tmb.automation.test.pb1.se11413;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
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

public class API_TC01_UpdateProspectFlowState extends Base {

	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1eKYC", "TestData_Sheet1", this.getClass().getSimpleName());
	}

	@Test(groups = { "android", "PB1" }, description = "Update Prospect FlowState")
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
		System.out.println("/////////hmCbody///////////-  " + "\n" + hmC);
		
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
		
//ekYC Script Flow State OTP_PASS----------------------------------------------------
		String UpdateProspect = ApiUrlEKYC.UpdateProspect;
		System.out.println("////////UpdateProspect///////////-  " +"\n" +UpdateProspect);
		
		HashMap<String, Object> hmC2 =new HashMap<>();
		hmC2.put("prospect_id", dataP1);
		hmC2.put("flow_state", "OTP_PASS");
		System.out.println("/////////hmC2body///////////-  "+"\n" +hmC2);
		
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
		System.out.println("/////////AssertMessageC13///////-  "+"\n" + messageC3);
		Assert.assertEquals(messageC3, messageexpectedC3, "message validated");
		
		String messageS3=jsC3.getString("status.service");
		String messageexpectedS3 = "customers-ex-service";
		System.out.println("/////////AssertServiceS3///////-  "+"\n" + messageS3);
		Assert.assertEquals(messageS3, messageexpectedS3, "Service validated");
		
		String messageD3=jsC3.getString("status.description.en");
		String messageexpectedD3 = "success";
		System.out.println("/////////AssertmessageD3///////-  "+"\n" + messageD3);
		Assert.assertEquals(messageD3, messageexpectedD3, "description validated");

		System.out.println("///////////Prospect Verify flow state1/////////////// ");
		
//Update flow state ACCEPT_TANDC_NDID ----------------------------------------------------
		HashMap<String, Object> hmC1 =new HashMap<>();
		hmC1.put("prospect_id", dataP1);
		hmC1.put("flow_state", "ACCEPT_TANDC_NDID");
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
		OpenReport.reportAPI(responseStringC2);
		
		JsonPath jsC2=new JsonPath(responseStringC2); //for parsing Json
		String codeC2=jsC2.getString("status.code");
		String CodeExpectedC2= "0000";
		Assert.assertEquals(codeC2, CodeExpectedC2, "code validated");
		System.out.println("///////////AssertCodeC2 ////////////-   "+"\n" + codeC2);
		
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
		
		System.out.println("///////////Prospect verify flow state 2 /////////////// ");					
	}
}
