package com.tmb.automation.test.pb1.se10014;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.model.pb1.ekyc.DataE;
import com.tmb.automation.model.pb1.ekyc.NameTitleE;
import com.tmb.automation.model.pb1.ekyc.ObjectModel;
import com.tmb.automation.pages.pb1.ExcelBasePB1;
import com.tmb.automation.pages.pb1.OpenReport;
import com.tmb.automation.pages.pb1.ekyc.ApiUrlEKYC;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC01_GetTitle extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}

	@Test(groups = { "android", "PB1" }, description = "Get Title")
	public void Test001() throws InterruptedException, IOException, SQLException {
		log("------------Start " + this.getClass().getSimpleName());

//Login-------------------------------------------------------------------------------------
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		System.out.println("////////BaseURI///////////-  " + "\n" + BaseURI);
		System.out.println("///////XCorrelation////////////-  " + "\n" + XCorrelation);
		
		String Title = ApiUrlEKYC.CommonEKYC;
		System.out.println("////////Title///////////-  " + "\n" + Title);

		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.header("X-Correlation-ID", XCorrelation).auth().none().when().get(Title).then()
				.assertThat().statusCode(200).extract().response();

		String responseStringC = response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " + "\n" + responseStringC);
		OpenReport.reportString("Title API- " +BaseURI +Title);
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
		String messageexpectedS = "mobile";
		System.out.println("/////////AssertServiceS1///////-  " + "\n" + messageS1);
		Assert.assertEquals(messageS1, messageexpectedS, "Service validated");

		String messageD1 = jsC.getString("status.description");
		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  " + "\n" + messageD1);
		Assert.assertEquals(messageD1, messageexpectedD, "description validated");

// get data mapper using POJO Model Class
		JSONObject jo1 = new JSONObject(responseStringC);
		JSONArray ja1 = jo1.getJSONArray("data");
		String s1 = ja1.toString();
		List<DataE> list1 = ObjectModel.getMapperInstance()
				.readValue(s1, new TypeReference<List<DataE>>() {}); // call ObjectModel POJO class

		List<NameTitleE> nameTitle = list1.get(0).getNameTitle();
		
		for (int i=0; i< 3; i++) {
		System.out.println("--------Loop : " +(i+1)) ;
		String st1 = ObjectModel.getMapperInstance().writeValueAsString(nameTitle.get(i));
		System.out.println("////////////////nameTitle//////////////////-  " + st1);
		String stc1 = nameTitle.get(i).getCode();	
		String std1 = nameTitle.get(i).getDescTH();	
		String std2 = nameTitle.get(i).getDescEN();	
		String std3 = nameTitle.get(i).getGender();	
		System.out.println("////////////////Title Code//////////////////-  " +stc1 );
		System.out.println("////////////////Title DesTh//////////////////-  " +std1 );
		System.out.println("////////////////Title DesEn//////////////////-  " +std2 );
		System.out.println("////////////////Title Gender//////////////////-  " +std3 );
		
		ExcelBasePB1 row = new ExcelBasePB1(); // to import ExcelBase class from main
		String ExcelFile = Helper.getProperties("TestData_pb1eKYC_excel_path");
		ArrayList<String> data1 = row.getData(stc1, "GetTitle", ExcelFile); // Import data from excel		
		String codee1 = data1.get(0);
		String descTHe1 = data1.get(1);
		String descENe1 = data1.get(2);
		String descGee1 = data1.get(3);
		System.out.println("--------code-------- " + codee1);
		System.out.println("--------descTH-------- " + descTHe1);
		System.out.println("--------descEN-------- " + descENe1);
		System.out.println("--------descGe-------- " + descGee1);
		
		Assert.assertEquals(stc1, codee1, "Title Code validated");
		Assert.assertEquals(std1, descTHe1, "Title DesTH validated");
		Assert.assertEquals(std2, descENe1, "Title DesEN validated");
		Assert.assertEquals(std3, descGee1, "Title DesGe validated");
		}

		System.out.println("///////////Get Title Success/////////////// ");
	}

}
