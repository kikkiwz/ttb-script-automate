package com.tmb.automation.test.pb1.se8086;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.ExcelBasePB1;
import com.tmb.automation.pages.pb1.OpenReport;
import com.tmb.automation.pages.pb1.ekyc.ApiUrlEKYC;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC01_FaceDetectMotion extends Base {

	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
//		mapData = Helper.getExcelData("TestData_pb1eKYC", "TestData_Sheet1", this.getClass().getSimpleName()); 
	}
	
	@Test(groups = {"android", "PB1"}, description="Get FaceDetect")
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
		
		String FaceDetect = ApiUrlEKYC.CommonEKYC;
		System.out.println("////////FaceDetect///////////-  " +"\n" +FaceDetect);
		
//ekYC Script ----------------------------------------------------
	
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation)
				.auth().none()
				.when().get(FaceDetect)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
		OpenReport.reportString("FaceDetect API- " +BaseURI +FaceDetect);
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
		String messageexpectedS = "mobile";
		System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");
		
		String messageD1=jsC.getString("status.description");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");
		
		String dataA1=jsC.getString("data.face_detect.actionDelay");
		String messageexpectedA = "[5]";
		System.out.println("/////////dataA1///////-  "+"\n" + dataA1);
		Assert.assertEquals(dataA1, messageexpectedA, "actionDelay validated");
		
		String dataT1=jsC.getString("data.face_detect.timeout");
		String messageexpectedT = "[30]";
		System.out.println("/////////dataT1///////-  "+"\n" + dataT1);
		Assert.assertEquals(dataT1, messageexpectedT, "timeout validated");
		
		String dataI1=jsC.getString("data.face_detect.instructDelay");
		String messageexpectedI = "[5]";
		System.out.println("/////////dataI1///////-  "+"\n" + dataI1);
		Assert.assertEquals(dataI1, messageexpectedI, "instructDelay validated");
		
		String dataM1=jsC.getString("data.face_detect.minWidth");
		String messageexpectedM = "[720]";
		System.out.println("/////////dataM1///////-  "+"\n" + dataM1);
		Assert.assertEquals(dataM1, messageexpectedM, "minWidth validated");
		
		String dataM2=jsC.getString("data.face_detect.minHeigth");
		String messageexpectedM2 = "[1280]";
		System.out.println("/////////dataM2///////-  "+"\n" + dataM2);
		Assert.assertEquals(dataM2, messageexpectedM2, "minHeigth validated");

//Verify Product Code from Excel ---------------------------------------------------
		ExcelBasePB1 row = new ExcelBasePB1(); // to import ExcelBase class from main
		String ExcelFile = Helper.getProperties("TestData_pb1eKYC_excel_path");
		ArrayList<String> data1 = row.getData("motionType", "FaceDetectMotion", ExcelFile); // Type word of excel for data

		String motionType1 = data1.get(1);
		String motionType2 = data1.get(2);
		String motionType3 = data1.get(3);
		String motionType4 = data1.get(4);
		String motionType5 = data1.get(5);
		System.out.println("--------motionType1-------- " + motionType1);
		System.out.println("--------motionType2-------- " + motionType2);
		System.out.println("--------motionType3-------- " + motionType3);
		System.out.println("--------motionType4-------- " + motionType4);
		System.out.println("--------motionType5-------- " + motionType5);
		
		JSONObject jo1= new JSONObject(responseStringC);
		JSONArray ja1 = jo1.getJSONArray("data");
		System.out.println("////////////////ja1//////////////////-  " + ja1);
		String s1 = ja1.get(0).toString();
		JSONObject jo2 = new JSONObject(s1);
		System.out.println("////////////////jo2//////////////////-  " + jo2);
		JSONObject jo3 = jo2.getJSONObject("face_detect");
		System.out.println("////////////////jo3//////////////////-  " + jo3);
		JSONArray ja2 = jo3.getJSONArray("motionType");
		
		for (int i = 0; i < ja2.length(); i++) {
			String ResponseOutput = ja2.getString(i);
			String motionType = data1.get(i+1);
			System.out.println("----Response   "+(i+1) +": " +ResponseOutput);
			System.out.println("----motionType "+(i+1) +": " +motionType );
			Assert.assertEquals(ResponseOutput, motionType, "Face Motion validated");			
		}

		System.out.println("///////////Get FaceDetect Success/////////////// ");			
	}
}
