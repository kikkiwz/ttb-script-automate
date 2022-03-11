package com.tmb.automation.test.pb1.se6788;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

public class API_TC01_FATCAanswer extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}

	@Test(groups = { "android", "PB1" }, description = "FATCA Screen")
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
		
		String FatcsScreen = ApiUrlEKYC.FatcsScreen;
		System.out.println("////////FatcsScreen///////////-  " + "\n" + FatcsScreen);

//ekYC Script Answer N & N ----------------------------------------------------
		
		HashMap<String, Object> hmC = new HashMap<>();
		hmC.put("fatca_answers", new String[]{"N", "N"});    
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC)
				.when().post(FatcsScreen)
				.then().assertThat().statusCode(200).extract().response();

		String responseStringC = response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " + "\n" + responseStringC);
		OpenReport.reportString("FatcsScreen API- " +BaseURI +FatcsScreen);
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

		System.out.println("///////////FATCA Screen N N Success/////////////// ");
		
//ekYC Script Answer Y & N ----------------------------------------------------
		
		Map<String, Object> hmC2 = new HashMap<>();
		hmC2.put("fatca_answers", new Object[]{"Y", "N"} );
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC2)
				.when().post(FatcsScreen)
				.then().assertThat().statusCode(400).extract().response();

		String responseStringC2 = response.asString();
		System.out.println("////////////////responseStringC2//////////////////-  " + "\n" + responseStringC2);
		OpenReport.reportString("FatcsScreen API- " +BaseURI +FatcsScreen);
		OpenReport.reportAPI(responseStringC2);
		
		JsonPath jsC2 = new JsonPath(responseStringC2); // for parsing Json
		String codeC2 = jsC2.getString("status.code");
		String CodeExpectedC2 = "ekyc_fatca_0001";
		System.out.println("///////////AssertCodeC2 ////////////-   " + "\n" + codeC2);
		Assert.assertEquals(codeC2, CodeExpectedC2, "code validated");
		
		String messageC2 = jsC2.getString("status.message");
		String messageexpectedC2 = "the anwsers are incorrect.";
		System.out.println("/////////AssertMessageC2///////-  " + "\n" + messageC2);
		Assert.assertEquals(messageC2, messageexpectedC2, "message validated");

		String messageS2 = jsC2.getString("status.service");
		String messageexpectedS2 = "customers-ex-service";
		System.out.println("/////////AssertServiceS2///////-  " + "\n" + messageS2);
		Assert.assertEquals(messageS2, messageexpectedS2, "Service validated");

		String messageD2 = jsC2.getString("status.description.en");
		String messageexpectedD2 = "Your FATCA wasn't verified. Please contact our ttb branch to open an account.";
		System.out.println("/////////AssertmessageD2///////-  " + "\n" + messageD2);
		Assert.assertEquals(messageD2, messageexpectedD2, "description En validated");

		String messageD2a = jsC2.getString("status.description.th");
		String messageexpectedD2a = "คุณตอบแบบสอบถาม FATCA ไม่ผ่าน โปรดติดต่อสาขาเพื่อเปิดบัญชี";
		System.out.println("/////////AssertmessageD2a///////-  " + "\n" + messageD2a);
		Assert.assertEquals(messageD2a, messageexpectedD2a, "description Th validated");

		System.out.println("///////////FATCA Screen Y N Success/////////////// ");
		
//ekYC Script Answer N & Y ----------------------------------------------------
		String hmC3 = "{ \"fatca_answers\": [\r\n"
				+ "        \"N\",\r\n"
				+ "        \"Y\"\r\n"
				+ "        ] }";
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC3)
				.when().post(FatcsScreen)
				.then().assertThat().statusCode(400).extract().response();

		String responseStringC3 = response.asString();
		System.out.println("////////////////responseStringC3//////////////////-  " + "\n" + responseStringC3);
		OpenReport.reportString("FatcsScreen API- " +BaseURI +FatcsScreen);
		OpenReport.reportAPI(responseStringC3);
		
		JsonPath jsC3 = new JsonPath(responseStringC3); // for parsing Json
		String codeC3 = jsC3.getString("status.code");
		String CodeExpectedC3 = "ekyc_fatca_0001";
		System.out.println("///////////AssertCodeC3 ////////////-   " + "\n" + codeC3);
		Assert.assertEquals(codeC3, CodeExpectedC3, "code validated");
		
		String messageC3 = jsC3.getString("status.message");
		String messageexpectedC3 = "the anwsers are incorrect.";
		System.out.println("/////////AssertMessageC3///////-  " + "\n" + messageC3);
		Assert.assertEquals(messageC3, messageexpectedC3, "message validated");

		String messageS3 = jsC3.getString("status.service");
		String messageexpectedS3 = "customers-ex-service";
		System.out.println("/////////AssertServiceS3///////-  " + "\n" + messageS3);
		Assert.assertEquals(messageS3, messageexpectedS3, "Service validated");

		String messageD3 = jsC3.getString("status.description.en");
		String messageexpectedD3 = "Your FATCA wasn't verified. Please contact our ttb branch to open an account.";
		System.out.println("/////////AssertmessageD3///////-  " + "\n" + messageD3);
		Assert.assertEquals(messageD3, messageexpectedD3, "description En validated");

		String messageD3a = jsC3.getString("status.description.th");
		String messageexpectedD3a = "คุณตอบแบบสอบถาม FATCA ไม่ผ่าน โปรดติดต่อสาขาเพื่อเปิดบัญชี";
		System.out.println("/////////AssertmessageD3a///////-  " + "\n" + messageD3a);
		Assert.assertEquals(messageD3a, messageexpectedD3a, "description Th validated");
		
		System.out.println("///////////FATCA Screen N Y Success/////////////// ");
		
//ekYC Script Answer Y & Y ----------------------------------------------------
		Map<String, Object> hmC4 = new HashMap<>();
		hmC4.put("fatca_answers", new Object[]{"Y", "Y"} );
		
		response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC4)
				.when().post(FatcsScreen)
				.then().assertThat().statusCode(400).extract().response();

		String responseStringC4 = response.asString();
		System.out.println("////////////////responseStringC4//////////////////-  " + "\n" + responseStringC4);
		OpenReport.reportString("FatcsScreen API- " +BaseURI +FatcsScreen);
		OpenReport.reportAPI(responseStringC4);
		
		JsonPath jsC4 = new JsonPath(responseStringC4); // for parsing Json
		String codeC4 = jsC4.getString("status.code");
		String CodeExpectedC4 = "ekyc_fatca_0001";
		System.out.println("///////////AssertCodeC4 ////////////-   " + "\n" + codeC4);
		Assert.assertEquals(codeC4, CodeExpectedC4, "code validated");
		
		String messageC4 = jsC4.getString("status.message");
		String messageexpectedC4 = "the anwsers are incorrect.";
		System.out.println("/////////AssertMessageC4///////-  " + "\n" + messageC4);
		Assert.assertEquals(messageC4, messageexpectedC4, "message validated");

		String messageS4 = jsC4.getString("status.service");
		String messageexpectedS4 = "customers-ex-service";
		System.out.println("/////////AssertServiceS4///////-  " + "\n" + messageS4);
		Assert.assertEquals(messageS4, messageexpectedS4, "Service validated");

		String messageD4 = jsC4.getString("status.description.en");
		String messageexpectedD4 = "Your FATCA wasn't verified. Please contact our ttb branch to open an account.";
		System.out.println("/////////AssertmessageD4///////-  " + "\n" + messageD4);
		Assert.assertEquals(messageD4, messageexpectedD4, "description En validated");

		String messageD4a = jsC4.getString("status.description.th");
		String messageexpectedD4a = "คุณตอบแบบสอบถาม FATCA ไม่ผ่าน โปรดติดต่อสาขาเพื่อเปิดบัญชี";
		System.out.println("/////////AssertmessageD4a///////-  " + "\n" + messageD4a);
		Assert.assertEquals(messageD4a, messageexpectedD4a, "description Th validated");

		System.out.println("///////////FATCA Screen Y Y Success/////////////// ");
	}
}
