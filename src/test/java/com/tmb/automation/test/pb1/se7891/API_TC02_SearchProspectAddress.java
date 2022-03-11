package com.tmb.automation.test.pb1.se7891;

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

public class API_TC02_SearchProspectAddress extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1eKYC", "TestData_Sheet1", this.getClass().getSimpleName());
	}

	@Test(groups = { "android", "PB1" }, description = "Search Prospect Address")
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

// Update Prospect Flow State----------------------------------------------------
		String UpdateProspect = ApiUrlEKYC.UpdateProspect;
		System.out.println("////////UpdateProspect///////////-  " +"\n" +UpdateProspect);
		
		String address = ("{\r\n"
				+ "    \"prospect_id\": \""+dataP1+"\",\r\n"
				+ "    \"email\": \"email@email.com\",\r\n"
				+ "    \"registered_address\": {\r\n"
				+ "        \"no\": \"ซันชายน์แมนชั่น\",\r\n"
				+ "        \"moo\": \"\",\r\n"
				+ "        \"building\": \"99/9 ซ.วิภาวดี 7ถ.วิภาวดี,\",\r\n"
				+ "        \"soi\": \"\",\r\n"
				+ "        \"road\": \"\",\r\n"
				+ "        \"sub_district\": \"แขวงจอมพล\",\r\n"
				+ "        \"district\": \"เขตจตุจักร\",\r\n"
				+ "        \"province\": \"กรุงเทพฯ\",\r\n"
				+ "        \"postal_code\": \"10900\",\r\n"
				+ "        \"country\": \"TH\"\r\n"
				+ "    },\r\n"
				+ "    \"primary_address\": {\r\n"
				+ "        \"no\": \"ซันชายน์แมนชั่น\",\r\n"
				+ "        \"moo\": \"\",\r\n"
				+ "        \"building\": \"99/9 ซ.วิภาวดี 7ถ.วิภาวดี,\",\r\n"
				+ "        \"soi\": \"\",\r\n"
				+ "        \"road\": \"\",\r\n"
				+ "        \"sub_district\": \"แขวงจอมพล\",\r\n"
				+ "        \"district\": \"เขตจตุจักร\",\r\n"
				+ "        \"province\": \"กรุงเทพฯ\",\r\n"
				+ "        \"postal_code\": \"10900\",\r\n"
				+ "        \"country\": \"TH\"\r\n"
				+ "    },\r\n"
				+ "    \"office_address\": {\r\n"
				+ "        \"company_name\": \"ธนาคารเพื่อการเกษตรและสหกรณ์การเกษตร\",\r\n"
				+ "        \"no\": \"ธนาคารทหารไทย จำกัด (มหาชน)\",\r\n"
				+ "        \"moo\": \"\",\r\n"
				+ "        \"building\": \"3000 ถ.พหลโยธิน\",\r\n"
				+ "        \"soi\": \"\",\r\n"
				+ "        \"road\": \"\",\r\n"
				+ "        \"sub_district\": \"แขวงจอมพล\",\r\n"
				+ "        \"district\": \"เขตจตุจักร\",\r\n"
				+ "        \"province\": \"กรุงเทพฯ\",\r\n"
				+ "        \"postal_code\": \"10900\",\r\n"
				+ "        \"country\": \"TH\",\r\n"
				+ "        \"phone_no\": \"09201919\",\r\n"
				+ "        \"phone_extension\": \"\"\r\n"
				+ "    }\r\n"
				+ "}");
		
		System.out.println("/////////body///////////-  "+"\n" +address);
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(address)
				.when().post(UpdateProspect)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringU =response.asString();
		System.out.println("////////////////responseStringU//////////////////-  "+"\n" +responseStringU);
		OpenReport.reportString("UpdateProspect API- " +BaseURI +UpdateProspect);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsU=new JsonPath(responseStringU); //for parsing Json
		String codeU1=jsU.getString("status.code");
		String CodeExpectedU1= "0000";
		System.out.println("///////////AssertCodeU1 ////////////-   "+"\n" + codeU1);
		Assert.assertEquals(codeU1, CodeExpectedU1, "code validated");
		
		String messageU1=jsU.getString("status.message");
		String messageexpectedC1 = "success";
		System.out.println("/////////AssertMessageU1///////-  "+"\n" + messageU1);
		Assert.assertEquals(messageU1, messageexpectedC1, "message validated");
		
		String messageS2=jsU.getString("status.service");
		String messageexpectedS2 = "customers-ex-service";
		System.out.println("/////////AssertServiceS2///////-  "+"\n" + messageS2);
		Assert.assertEquals(messageS2, messageexpectedS2, "Service validated");
		
		String messageD2=jsU.getString("status.description.en");
		String messageexpectedD2 = "success";
		System.out.println("/////////AssertmessageD2///////-  "+"\n" + messageD2);
		Assert.assertEquals(messageD2, messageexpectedD2, "description validated");

		System.out.println("///////////Prospect Verify Update Address Success/////////////// ");
		
//ekYC Search Prospect Address----------------------------------------------------
		String SearchProspect = ApiUrlEKYC.SearchProspect;
		System.out.println("////////SearchProspect///////////-  " + "\n" + SearchProspect);
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
		OpenReport.reportAPI(responseStringS1); 
		
		JsonPath jsS1 = new JsonPath(responseStringS1); // for parsing Json
		String codeS1 = jsS1.getString("status.code");
		String CodeExpectedS1 = "0000";
		System.out.println("///////////AssertCodeS1 ////////////-   " + "\n" + codeS1);
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
		Assert.assertEquals(dataS1m, dataP1 );

		String dataS1r = jsS1.getString("data.customer.risk.dopa_flag");
		System.out.println("/////////dataS1r///////-  " + dataS1r);
		Assert.assertEquals(dataS1r, "false");
		
		String dataS1s = jsS1.getString("data.customer.registered_address.no");
		System.out.println("/////////dataS1s///////-  " + dataS1s);
		Assert.assertNotNull(dataS1s);
		
		String dataS1t = jsS1.getString("data.customer.primary_address.no");
		System.out.println("/////////dataS1t///////-  " + dataS1t);
		Assert.assertNotNull(dataS1t);

		String dataS1u = jsS1.getString("data.customer.office_address.company_name");
		System.out.println("/////////dataS1u///////-  " + dataS1u);
		Assert.assertNotNull(dataS1u);

		String dataS1v = jsS1.getString("data.customer.consent.ekyc_consent_flag");
		System.out.println("/////////dataS1v///////-  " + dataS1v);
		Assert.assertEquals(dataS1v, "false");
        		
		String dataS1p = jsS1.getString("data.customer.device_id");
		System.out.println("/////////dataS1p///////-  " + dataS1p);
		Assert.assertEquals(dataS1p, device_id );

		String dataS1q = jsS1.getString("data.customer.product_code");
		System.out.println("/////////dataS1q///////-  " + dataS1q);
		Assert.assertEquals(dataS1q, product_code );
			
		System.out.println("///////////Search prospect after update FlowState Passed/////////////// ");	
	}
	
}
