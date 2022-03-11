package com.tmb.automation.test.pb1.se5985;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

public class API_TC02_CustomerProfileFail extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}
	
	@DataProvider
	public  Object[][] getExcelData() throws IOException 	{
		 Object Data[][]=Helper.testadataDataprovider("TestData_pb1eKYC", "CustomerProfileFail"); 
		return Data; 	}
	
	@Test(groups = {"android", "PB1"}, dataProvider="getExcelData", description="Customer Profile Fail")
	public void Test001 (String sc1, String aa1,String bb1,String cc1,String dd1, String ee1, String ff1, String co1, String me1, String de1) throws InterruptedException, IOException{
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
		
		String CustomerProfile = ApiUrlEKYC.CustomerProfile;
		System.out.println("////////CustomerProfile///////////-  " + "\n" + CustomerProfile);

//ekYC Script ----------------------------------------------------
		String birth_date = aa1; //Get data from DataProvider
		String first_name = bb1;
		String last_name = cc1;
		String first_name_en = dd1;
		String citizen_id = ee1;
		String laser_code = ff1;
		String scenario = sc1;
		String code = co1;
		String message = me1;
		String description=de1;
		
		System.out.println("////////birth_date///////////-  " + "\n" + birth_date);
		System.out.println("///////first_name//////////// -  " + "\n" + first_name);
		System.out.println("///////last_name////////////-  " + "\n" + last_name);
		System.out.println("///////first_name_en////////////-  " + "\n" + first_name_en);
		System.out.println("////////citizen_id///////////-  " + "\n" + citizen_id);
		System.out.println("////////laser_code///////////-  " + "\n" + laser_code);
		System.out.println("///////scenario////////////-  " + "\n" + scenario);
		System.out.println("////////code///////////-  " + "\n" + code);
		System.out.println("////////message///////////-  " + "\n" + message);
		System.out.println("////////description///////////-  " + "\n" + description);
		
		HashMap<String, Object> hmC =new HashMap<>();
		hmC.put("birth_date", birth_date);
		hmC.put("first_name", first_name);
		hmC.put("last_name", last_name);
		hmC.put("first_name_en", first_name_en);
		hmC.put("citizen_id", citizen_id);
		hmC.put("laser_code", laser_code);
		System.out.println("/////////body///////////-  "+"\n" +hmC);
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.body(hmC)
				.when().post(CustomerProfile)
				.then().assertThat().statusCode(400).extract().response();

		String responseStringC = response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " + "\n" + responseStringC);
		OpenReport.reportString("CustomerProfile API- " +BaseURI +CustomerProfile);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC = new JsonPath(responseStringC); // for parsing Json
		String codeC1 = jsC.getString("status.code");
		String CodeExpectedC1 = code;
		System.out.println("///////////AssertCodeC1 ////////////-   " + "\n" + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");

		String messageC1 = jsC.getString("status.message");
		String messageexpectedC = message;
		System.out.println("/////////AssertMessageC1///////-  " + "\n" + messageC1);
		Assert.assertEquals(messageC1, messageexpectedC, "message validated");

		String messageS1 = jsC.getString("status.service");
		String messageexpectedS = "customers-ex-service";
		System.out.println("/////////AssertServiceS1///////-  " + "\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");

		String messageD1 = jsC.getString("status.description.en");
		String messageexpectedD = description;
		System.out.println("/////////AssertmessageD1///////-  " + "\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");

		System.out.println("///////////Customer Profile Success/////////////// ");
	}

}
