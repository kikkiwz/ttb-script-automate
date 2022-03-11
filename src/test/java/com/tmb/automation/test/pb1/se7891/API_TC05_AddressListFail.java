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

public class API_TC05_AddressListFail extends Base {

	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1eKYC", "TestData_Sheet1", this.getClass().getSimpleName()); 
	}
	
	@Test(groups = {"android", "PB1"}, description="Address List Fail")
	public void Test001 () throws InterruptedException, IOException {
		log("------------Start "+this.getClass().getSimpleName());
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");		
		System.out.println("////////URL///////////-  " +"\n" +BaseURI);
		System.out.println("///////X-Correlation-ID////////////-  "+"\n"  +XCorrelation);

		String pin = map("pin");
		String AdderssList = ApiUrlEKYC.AdderssList;
		System.out.println("///////pin//////////// -  " +"\n"  +pin);
		System.out.println("///////AdderssList//////////// -  " +"\n"  +AdderssList);
		
//ekYC Script Address List ----------------------------------------------------	
		HashMap<String, Object> hmC1 = new HashMap<>();
		hmC1.put("field", "postcode");
		hmC1.put("language", "en");
		hmC1.put("search", pin);
		System.out.println("/////////bodyC1///////////-  " + "\n" + hmC1);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC1)
				.when().post(AdderssList)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		OpenReport.reportString("AdderssList API- " +BaseURI +AdderssList);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0000";
		System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "success";
		System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");
		
		String messageS1=jsC.getString("status.service");
		String messageexpectedS = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");
		
		String messageD1=jsC.getString("status.description.en");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");
		
		String messageD2=jsC.getString("status.data");
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD2);
		Assert.assertNull(messageD2);
		
		System.out.println("///////////Address List En Success/////////////// ");
	}
	
	@Test(groups = {"android", "PB1"}, description="Address List Fail")
	public void Test002 () throws InterruptedException, IOException {
		log("------------Start "+this.getClass().getSimpleName());
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");		
		System.out.println("////////URL///////////-  " +"\n" +BaseURI);
		System.out.println("///////X-Correlation-ID////////////-  "+"\n"  +XCorrelation);

		String pin = map("pin");
		String AdderssList = ApiUrlEKYC.AdderssList;
		System.out.println("///////pin//////////// -  " +"\n"  +pin);
		System.out.println("///////AdderssList//////////// -  " +"\n"  +AdderssList);
		
//ekYC Script Address List ----------------------------------------------------	
		HashMap<String, Object> hmC1 = new HashMap<>();
		hmC1.put("field", "postcode");
		hmC1.put("language", "th");
		hmC1.put("search", pin);
		System.out.println("/////////bodyC1///////////-  " + "\n" + hmC1);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC1)
				.when().post(AdderssList)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		OpenReport.reportString("AdderssList API- " +BaseURI +AdderssList);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0000";
		System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "success";
		System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");
		
		String messageS1=jsC.getString("status.service");
		String messageexpectedS = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");
		
		String messageD1=jsC.getString("status.description.en");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");
		
		String messageD2=jsC.getString("status.data");
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD2);
		Assert.assertNull(messageD2);
		
		System.out.println("///////////Address List Th Success/////////////// ");
	}

	@Test(groups = {"android", "PB1"}, description="Address List Fail")
	public void Test003 () throws InterruptedException, IOException {
		log("------------Start "+this.getClass().getSimpleName());
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");		
		System.out.println("////////URL///////////-  " +"\n" +BaseURI);
		System.out.println("///////X-Correlation-ID////////////-  "+"\n"  +XCorrelation);

		String AdderssList = ApiUrlEKYC.AdderssList;
		System.out.println("///////AdderssList//////////// -  " +"\n"  +AdderssList);
		
//ekYC Script Address List ----------------------------------------------------	
		HashMap<String, Object> hmC1 = new HashMap<>();
		hmC1.put("field", "postcode");
		hmC1.put("language", "en");
		System.out.println("/////////bodyC1///////////-  " + "\n" + hmC1);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC1)
				.when().post(AdderssList)
				.then().assertThat().statusCode(400).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		OpenReport.reportString("AdderssList API- " +BaseURI +AdderssList);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0001";
		System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "Unknown Error";
		System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");
		
		String messageS1=jsC.getString("status.service");
		String messageexpectedS = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");
		
		String messageD1=jsC.getString("status.description.en");
		String messageexpectedD = "Unknown Error";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");
		
		String messageD2=jsC.getString("status.data");
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD2);
		Assert.assertNull(messageD2);
		
		System.out.println("///////////Address List Eng Fail/////////////// ");
	}

	@Test(groups = {"android", "PB1"}, description="Address List Fail")
	public void Test004() throws InterruptedException, IOException {
		log("------------Start "+this.getClass().getSimpleName());
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");		
		System.out.println("////////URL///////////-  " +"\n" +BaseURI);
		System.out.println("///////X-Correlation-ID////////////-  "+"\n"  +XCorrelation);

		String AdderssList = ApiUrlEKYC.AdderssList;
		System.out.println("///////AdderssList//////////// -  " +"\n"  +AdderssList);
		
//ekYC Script Address List ----------------------------------------------------	
		HashMap<String, Object> hmC1 = new HashMap<>();
		hmC1.put("field", "postcode");
		hmC1.put("language", "th");
		System.out.println("/////////bodyC1///////////-  " + "\n" + hmC1);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC1)
				.when().post(AdderssList)
				.then().assertThat().statusCode(400).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		OpenReport.reportString("AdderssList API- " +BaseURI +AdderssList);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0001";
		System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "Unknown Error";
		System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");
		
		String messageS1=jsC.getString("status.service");
		String messageexpectedS = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");
		
		String messageD1=jsC.getString("status.description.en");
		String messageexpectedD = "Unknown Error";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");
		
		String messageD2=jsC.getString("status.data");
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD2);
		Assert.assertNull(messageD2);
		
		System.out.println("///////////Address List Thai Fail/////////////// ");
	}
	
}
