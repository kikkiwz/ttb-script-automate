package com.tmb.automation.test.pb1.se7891;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
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

public class API_TC01_UpdateAddress extends Base {

	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}
	
	@Test(groups = {"android", "PB1"}, description="Update Address")
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
		
		String prospectID= "P52998255961";
		String UpdateProspect = ApiUrlEKYC.UpdateProspect;
		System.out.println("////////UpdateProspect///////////-  " +"\n" +UpdateProspect);
		
//ekYC Script Prospect Address  ----------------------------------------------------
		String address = ("{\r\n"
				+ "    \"prospect_id\": \""+prospectID +"\",\r\n"
				+ "    \"email\": \"email@email.com\",\r\n"
				+ "    \"registered_address\": {\r\n"
				+ "        \"no\": \"11\",\r\n"
				+ "        \"moo\": \"\",\r\n"
				+ "        \"building\": \"\",\r\n"
				+ "        \"soi\": \"\",\r\n"
				+ "        \"road\": \"\",\r\n"
				+ "        \"sub_district\": \"distric\",\r\n"
				+ "        \"district\": \"\",\r\n"
				+ "        \"province\": \"\",\r\n"
				+ "        \"postal_code\": \"10110\",\r\n"
				+ "        \"country\": \"thailand\"\r\n"
				+ "    },\r\n"
				+ "    \"primary_address\": {\r\n"
				+ "        \"no\": \"112\",\r\n"
				+ "        \"moo\": \"\",\r\n"
				+ "        \"building\": \"\",\r\n"
				+ "        \"soi\": \"\",\r\n"
				+ "        \"road\": \"\",\r\n"
				+ "        \"sub_district\": \"distric\",\r\n"
				+ "        \"district\": \"\",\r\n"
				+ "        \"province\": \"\",\r\n"
				+ "        \"postal_code\": \"10300\",\r\n"
				+ "        \"country\": \"thailand\"\r\n"
				+ "    },\r\n"
				+ "    \"office_address\": {\r\n"
				+ "        \"company_name\": \"tcs\",\r\n"
				+ "        \"no\": \"\",\r\n"
				+ "        \"moo\": \"\",\r\n"
				+ "        \"building\": \"\",\r\n"
				+ "        \"soi\": \"\",\r\n"
				+ "        \"road\": \"\",\r\n"
				+ "        \"sub_district\": \"\",\r\n"
				+ "        \"district\": \"\",\r\n"
				+ "        \"province\": \"\",\r\n"
				+ "        \"postal_code\": \"\",\r\n"
				+ "        \"country\": \"\",\r\n"
				+ "        \"phone_no\": \"09201919\",\r\n"
				+ "        \"phone_extension\": \"\"\r\n"
				+ "    }\r\n"
				+ "}");
		
		System.out.println("/////////body///////////-  "+"\n" +address);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(address)
				.when().post(UpdateProspect)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		OpenReport.reportString("UpdateProspect API- " +BaseURI +UpdateProspect);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0000";
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");
		System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
		
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

		System.out.println("///////////Prospect Verify Update Address Success/////////////// ");	
	}
}
