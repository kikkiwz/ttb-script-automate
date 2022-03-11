package com.tmb.automation.test.pb1.se7892;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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

public class API_TC01_PinSetupPass extends Base {

	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1eKYC", "TestData_Sheet1", this.getClass().getSimpleName()); 
	}

	@Test(groups = {"android", "PB1"}, description="PinSetup Pass")
	public void Test001 () throws InterruptedException, IOException, ParseException {
		log("------------Start "+this.getClass().getSimpleName());

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);

		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		System.out.println("////////URL///////////-  " + "\n" + BaseURI);
		System.out.println("///////X-Correlation-ID////////////-  " + "\n" + XCorrelation);

//Service Hour ---------------------------------------------------------------------------------
		String CommonServiceHour = ApiUrlEKYC.CommonServiceHour;
		System.out.println("////////CommonServiceHour///////////-  " +"\n" +CommonServiceHour);

		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.when().get(CommonServiceHour)
				.then().assertThat().statusCode(200).extract().response();

		String responseStringS =response.asString();
		System.out.println("////////////////responseStringS//////////////////-  "+"\n" +responseStringS);
		OpenReport.reportString("CommonServiceHour API- " +BaseURI +CommonServiceHour);
		OpenReport.reportAPI(responseStringS);

		JsonPath jsS=new JsonPath(responseStringS); //for parsing Json
		String codeS1=jsS.getString("status.code");
		String CodeExpectedS1= "0000";
		System.out.println("///////////AssertCodeS1 ////////////-   "+"\n" + codeS1);
		Assert.assertEquals(codeS1, CodeExpectedS1, "code validated");

		String messageM1=jsS.getString("status.message");
		String messageexpectedM = "success";
		System.out.println("/////////AssertMessageM1///////-  "+"\n" + messageM1);
		Assert.assertEquals(messageM1, messageexpectedM, "message validated");

		String TimeFrom=jsS.getString("data.ndid_none_service_hour.end");
		TimeFrom= TimeFrom.substring(1,6);
		System.out.println("/////////TimeFrom///////-  "+ TimeFrom);
		String TimeTo=jsS.getString("data.ndid_none_service_hour.start");
		TimeTo= TimeTo.substring(1,6);
		System.out.println("/////////TimeTo///////-  " + TimeTo);

		SimpleDateFormat time = new SimpleDateFormat("HH:mm", Locale.getDefault());
		String CurrentTime = time.format(new Date()).toString();
		System.out.println("CurrentTime----- " +CurrentTime);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date time_from = formatter.parse(TimeFrom);
		Date time_to = formatter.parse(TimeTo);
		Date timeNow = formatter.parse(CurrentTime);

//ekYC Script ---------------------------------------------------------------------------------
		String Pin010203 = map("pin010203");
		String PinSetup = ApiUrlEKYC.PinSetup;
		System.out.println("////////Pin010203///////////-  " + "\n" + Pin010203);
		System.out.println("////////PinSetup///////////-  " + "\n" + PinSetup);

		HashMap<String, String> hmC1 =new HashMap<>();
		hmC1.put("pin", Pin010203);
		System.out.println("/////////body///////////-  "+"\n" +hmC1);

		if (time_from.before(timeNow) && time_to.after(timeNow)) {
			response = given().relaxedHTTPSValidation().log().all()
					.header("Content-Type", "application/json")
					.header("X-Correlation-ID", XCorrelation)
					.header("X-Service-Module", "EKYC")
					.auth().none()
					.body(hmC1)
					.when().post(PinSetup)
					.then().assertThat().statusCode(200).extract().response();

			String responseStringC1 =response.asString();
			System.out.println("////////////////responseStringC1//////////////////-  "+"\n" +responseStringC1);
			OpenReport.reportString("PinSetup API- " +BaseURI +PinSetup);
			OpenReport.reportAPI(responseStringC1);

			JsonPath jsC3=new JsonPath(responseStringC1); //for parsing Json
			String codeC3=jsC3.getString("status.code");
			String CodeExpectedC3= "0000";
			Assert.assertEquals(codeC3, CodeExpectedC3, "code validated");
			System.out.println("///////////AssertCodeC3 ////////////-   "+"\n" + codeC3);

			String messageC3=jsC3.getString("status.message");
			String messageexpectedC3 = "success";
			System.out.println("/////////AssertMessageC3///////-  "+"\n" + messageC3);
			Assert.assertEquals(messageC3, messageexpectedC3, "message validated");

			String messageS3=jsC3.getString("status.service");
			String messageexpectedS3 = "oneapp-auth-service";
			System.out.println("/////////AssertServiceS3///////-  "+"\n" + messageS3);
			Assert.assertEquals(messageS3, messageexpectedS3, "Service validated");

			String messageD3=jsC3.getString("status.description.en");
			String messageexpectedD3 = "success";
			System.out.println("/////////AssertmessageD3///////-  "+"\n" + messageD3);
			Assert.assertEquals(messageD3, messageexpectedD3, "description validated");
		} 
		else {
			response = given().relaxedHTTPSValidation().log().all()
					.header("Content-Type", "application/json")
					.header("X-Correlation-ID", XCorrelation)
					.header("X-Service-Module", "EKYC")
					.auth().none()
					.body(hmC1)
					.when().post(PinSetup)
					.then().assertThat().statusCode(400).extract().response();

			String responseStringC1 =response.asString();
			System.out.println("////////////////responseStringC1//////////////////-  "+"\n" +responseStringC1);
			OpenReport.reportString("PinSetup API- " +BaseURI +PinSetup);
			OpenReport.reportAPI(responseStringC1);

			JsonPath jsC=new JsonPath(responseStringC1); //for parsing Json
			String codeC1=jsC.getString("status.code");
			String CodeExpectedC1= "service_hour_error";
			System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
			Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");

			String messageC1=jsC.getString("status.message");
			String messageexpectedC = "out of service hour";
			System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);
			Assert.assertEquals(messageC1, messageexpectedC, "message validated");

			String messageS1=jsC.getString("status.service");
			String messageexpectedS = "oneapp-auth-service";
			System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
			Assert.assertEquals(messageS1, messageexpectedS, "Service validated");

			String messageD1=jsC.getString("status.description.en");
			String messageexpectedD1 = "Unable to proceed. For more information please call 1428.";
			System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
			Assert.assertEquals(messageD1, messageexpectedD1, "description validated");

			String messageD2=jsC.getString("status.description.th");
			String messageexpectedD2 = "ไม่สามารถทำรายการ ได้ธนาคารขออภัยในความไม่สะดวกมา ณ ที่นี้ สอบถามเพื่มเติม โทร. 1428";
			System.out.println("/////////AssertmessageD2///////-  "+"\n" + messageD2);
			Assert.assertEquals(messageD2, messageexpectedD2, "description validated");
		}

		System.out.println("///////////Pin Setup 1 Passed/////////////// ");
	}

	@Test(groups = {"android", "PB1"}, description="PinSetup")
	public void Test002 () throws InterruptedException, IOException, ParseException {
		log("------------Start "+this.getClass().getSimpleName());

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);

		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		System.out.println("////////URL///////////-  " + "\n" + BaseURI);
		System.out.println("///////X-Correlation-ID////////////-  " + "\n" + XCorrelation);

		//Service Hour ---------------------------------------------------------------------------------
		String CommonServiceHour = ApiUrlEKYC.CommonServiceHour;
		System.out.println("////////CommonServiceHour///////////-  " +"\n" +CommonServiceHour);

		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.when().get(CommonServiceHour)
				.then().assertThat().statusCode(200).extract().response();

		String responseStringS =response.asString();
		System.out.println("////////////////responseStringS//////////////////-  "+"\n" +responseStringS);
		OpenReport.reportString("CommonServiceHour API- " +BaseURI +CommonServiceHour);
		OpenReport.reportAPI(responseStringS);

		JsonPath jsS=new JsonPath(responseStringS); //for parsing Json
		String codeS1=jsS.getString("status.code");
		String CodeExpectedS1= "0000";
		System.out.println("///////////AssertCodeS1 ////////////-   "+"\n" + codeS1);
		Assert.assertEquals(codeS1, CodeExpectedS1, "code validated");

		String messageM1=jsS.getString("status.message");
		String messageexpectedM = "success";
		System.out.println("/////////AssertMessageM1///////-  "+"\n" + messageM1);
		Assert.assertEquals(messageM1, messageexpectedM, "message validated");

		String TimeFrom=jsS.getString("data.ndid_none_service_hour.end");
		TimeFrom= TimeFrom.substring(1,6);
		System.out.println("/////////TimeFrom///////-  "+ TimeFrom);
		String TimeTo=jsS.getString("data.ndid_none_service_hour.start");
		TimeTo= TimeTo.substring(1,6);
		System.out.println("/////////TimeTo///////-  " + TimeTo);

		SimpleDateFormat time = new SimpleDateFormat("HH:mm", Locale.getDefault());
		String CurrentTime = time.format(new Date()).toString();
		System.out.println("CurrentTime----- " +CurrentTime);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date time_from = formatter.parse(TimeFrom);
		Date time_to = formatter.parse(TimeTo);
		Date timeNow = formatter.parse(CurrentTime);

		//ekYC Script ---------------------------------------------------------------------------------
		String Pin102030 = map("pin102030");
		String PinSetup = ApiUrlEKYC.PinSetup;
		System.out.println("///////Pin102030////////////-  " + "\n" + Pin102030);
		System.out.println("////////PinSetup///////////-  " + "\n" + PinSetup);

		HashMap<String, String> hmC1 =new HashMap<>();
		hmC1.put("pin", Pin102030);
		System.out.println("/////////body///////////-  "+"\n" +hmC1);

		if (time_from.before(timeNow) && time_to.after(timeNow)) {
			response = given().relaxedHTTPSValidation().log().all()
					.header("Content-Type", "application/json")
					.header("X-Correlation-ID", XCorrelation)
					.header("X-Service-Module", "EKYC")
					.auth().none()
					.body(hmC1)
					.when().post(PinSetup)
					.then().assertThat().statusCode(200).extract().response();

			String responseStringC1 =response.asString();
			System.out.println("////////////////responseStringC1//////////////////-  "+"\n" +responseStringC1);
			OpenReport.reportString("PinSetup API- " +BaseURI +PinSetup);
			OpenReport.reportAPI(responseStringC1);

			JsonPath jsC3=new JsonPath(responseStringC1); //for parsing Json
			String codeC3=jsC3.getString("status.code");
			String CodeExpectedC3= "0000";
			Assert.assertEquals(codeC3, CodeExpectedC3, "code validated");
			System.out.println("///////////AssertCodeC3 ////////////-   "+"\n" + codeC3);

			String messageC3=jsC3.getString("status.message");
			String messageexpectedC3 = "success";
			System.out.println("/////////AssertMessageC3///////-  "+"\n" + messageC3);
			Assert.assertEquals(messageC3, messageexpectedC3, "message validated");

			String messageS3=jsC3.getString("status.service");
			String messageexpectedS3 = "oneapp-auth-service";
			System.out.println("/////////AssertServiceS3///////-  "+"\n" + messageS3);
			Assert.assertEquals(messageS3, messageexpectedS3, "Service validated");

			String messageD3=jsC3.getString("status.description.en");
			String messageexpectedD3 = "success";
			System.out.println("/////////AssertmessageD3///////-  "+"\n" + messageD3);
			Assert.assertEquals(messageD3, messageexpectedD3, "description validated");
		} 
		else {
			response = given().relaxedHTTPSValidation().log().all()
					.header("Content-Type", "application/json")
					.header("X-Correlation-ID", XCorrelation)
					.header("X-Service-Module", "EKYC")
					.auth().none()
					.body(hmC1)
					.when().post(PinSetup)
					.then().assertThat().statusCode(400).extract().response();

			String responseStringC1 =response.asString();
			System.out.println("////////////////responseStringC1//////////////////-  "+"\n" +responseStringC1);
			OpenReport.reportString("PinSetup API- " +BaseURI +PinSetup);
			OpenReport.reportAPI(responseStringC1);

			JsonPath jsC=new JsonPath(responseStringC1); //for parsing Json
			String codeC1=jsC.getString("status.code");
			String CodeExpectedC1= "service_hour_error";
			System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
			Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");

			String messageC1=jsC.getString("status.message");
			String messageexpectedC = "out of service hour";
			System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);
			Assert.assertEquals(messageC1, messageexpectedC, "message validated");

			String messageS1=jsC.getString("status.service");
			String messageexpectedS = "oneapp-auth-service";
			System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
			Assert.assertEquals(messageS1, messageexpectedS, "Service validated");

			String messageD1=jsC.getString("status.description.en");
			String messageexpectedD1 = "Unable to proceed. For more information please call 1428.";
			System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
			Assert.assertEquals(messageD1, messageexpectedD1, "description validated");

			String messageD2=jsC.getString("status.description.th");
			String messageexpectedD2 = "ไม่สามารถทำรายการ ได้ธนาคารขออภัยในความไม่สะดวกมา ณ ที่นี้ สอบถามเพื่มเติม โทร. 1428";
			System.out.println("/////////AssertmessageD2///////-  "+"\n" + messageD2);
			Assert.assertEquals(messageD2, messageexpectedD2, "description validated");
		}

		System.out.println("///////////Pin Setup 2 Passed/////////////// ");
	}

}
