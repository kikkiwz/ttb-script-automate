package com.tmb.automation.test.pb1.se5991;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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

public class API_TC01_SelectProduct extends Base {

	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}

	@Test(groups = {"android", "PB1"}, description="Select Product")
	public void Test001 () throws InterruptedException, IOException, ParseException {
		log("------------Start "+this.getClass().getSimpleName());

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

		String SelectProduct = ApiUrlEKYC.SelectProduct;
		System.out.println("////////SelectProduct///////////-  " +"\n" +SelectProduct);

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
		if (time_from.before(timeNow) && time_to.after(timeNow)) {
			response = given().relaxedHTTPSValidation().log().all()
					.header("Content-Type", "application/json")
					.header("X-Correlation-ID", XCorrelation)
					.header("X-Citizen-ID", "1234567890123")
					.header("X-Service-Module", "EKYC")
					.auth().none()
					.when().get(SelectProduct)
					.then().assertThat().statusCode(200).extract().response();

			String responseStringC =response.asString();
			System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
			OpenReport.reportString("SelectProduct API- " +BaseURI +SelectProduct);
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
			String messageexpectedS = "products-exp-service";
			System.out.println("/////////AssertServiceS1///////-  "+"\n" + messageS1);
			Assert.assertEquals(messageS1, messageexpectedS, "Service validated");

			String messageD1=jsC.getString("status.description");
			String messageexpectedD = "success";
			System.out.println("/////////AssertmessageD1///////-  "+"\n" + messageD1);
			Assert.assertEquals(messageD1, messageexpectedD, "description validated");

//Verify Product Code from Excel ---------------------------------------------------	
			JSONObject jo1 = new JSONObject(responseStringC);
			JSONArray ja1 = jo1.getJSONArray("data");
			System.out.println("////////////////ja1//////////////////-  " + ja1);

			for (int i = 0; i < ja1.length(); i++) {
				System.out.println("--------Loop : " +(i+1)) ;
				JSONObject jo3 = ja1.getJSONObject(i);
				String product_coder = jo3.getString("product_code");
				String product_name_enr = jo3.getString("product_name_en");
				String product_name_thr = jo3.getString("product_name_th");
				String icon_idr = jo3.getString("icon_id");

				System.out.println("/////////////product_coder//////////- " + product_coder);
				System.out.println("/////////////product_name_enr//////////- " + product_name_enr);
				System.out.println("/////////////product_name_thr//////////- " + product_name_thr);
				System.out.println("/////////////icon_idr//////////- " + icon_idr);

				ExcelBasePB1 row = new ExcelBasePB1(); // to import ExcelBase class from main
				String ExcelFile = Helper.getProperties("TestData_pb1eKYC_excel_path");
				ArrayList<String> data1 = row.getData(product_coder, "SelectProduct", ExcelFile); // Import data from excel		
				String product_code = data1.get(0);
				String product_name_en = data1.get(1);
				String product_name_th = data1.get(2);
				String icon_id = data1.get(3);
				System.out.println("--------product_code-------- " + product_code);
				System.out.println("--------product_name_en-------- " + product_name_en);
				System.out.println("--------product_name_th-------- " + product_name_th);
				System.out.println("--------icon_id-------- " + icon_id);

				Assert.assertEquals(product_code, product_coder, "product_code validated");
				Assert.assertEquals(product_name_en, product_name_enr, "product_name_en validated");	
				Assert.assertEquals(product_name_th, product_name_thr, "product_name_th validated");
//				Assert.assertEquals(icon_id, icon_idr, "icon_id validated");	
			}

		} else {
			response = given().relaxedHTTPSValidation().log().all()
					.header("Content-Type", "application/json")
					.header("X-Correlation-ID", XCorrelation)
					.header("X-Citizen-ID", "1234567890123")
					.header("X-Service-Module", "EKYC")
					.auth().none()
					.when().get(SelectProduct)
					.then().assertThat().statusCode(400).extract().response();

			String responseStringC =response.asString();
			System.out.println("////////////////responseStringC//////////////////-  "+"\n" +responseStringC);
			OpenReport.reportString("SelectProduct API- " +BaseURI +SelectProduct);
			OpenReport.reportAPI(responseStringC);

			JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
			String codeC1=jsC.getString("status.code");
			String CodeExpectedC1= "service_hour_error";
			System.out.println("///////////AssertCodeC1 ////////////-   "+"\n" + codeC1);
			Assert.assertEquals(codeC1, CodeExpectedC1, "code validated");

			String messageC1=jsC.getString("status.message");
			String messageexpectedC = "out of service hour";
			System.out.println("/////////AssertMessageC1///////-  "+"\n" + messageC1);
			Assert.assertEquals(messageC1, messageexpectedC, "message validated");

			String messageS1=jsC.getString("status.service");
			String messageexpectedS = "products-exp-service";
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

		System.out.println("///////////Select Product Success/////////////// ");
	}
}
