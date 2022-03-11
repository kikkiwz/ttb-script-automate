package com.tmb.automation.test.pb1.c14814;

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
import com.tmb.automation.pages.pb1.cardless.API_Login;
import com.tmb.automation.pages.pb1.cardless.ApiUrlCardless;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* API Test
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_TC04_CRMProfile extends Base {
	
	@Parameters({"DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		}
	
	@Test(groups = {"api", "PB1"}, description ="CRM Profile")
	public void Test001 () throws InterruptedException, IOException {
		log("------------Start "+this.getClass().getSimpleName());
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		
		System.out.println("----------BaseURI---------- " + BaseURI);
		System.out.println("----------XCorrelation---------- " + XCorrelation);
		
		
		String CRM = ApiUrlCardless.CRM;
		String CRMProfile = ApiUrlCardless.CRMProfile;
		System.out.println("----------CRM---------- " + CRM);
		System.out.println("----------CRMProfile---------- " + CRMProfile);
		
		String access_tokenV= API_Login.Login(); //to call into test class
		System.out.println("///////////Login Success/////////////// ");

//Script -----------------------------------------------------------------------------------
		
		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().log().all()
				.header("X-Correlation-ID", XCorrelation)
				.auth().oauth2(access_tokenV)
				.when().get(CRMProfile)
				.then().assertThat().statusCode(200).extract().response();
		
		String responseStringC =response.asString();
		System.out.println("////////////////responseStringC//////////////////-  " +responseStringC);
		OpenReport.reportAPI(responseStringC);
		
		JsonPath jsC=new JsonPath(responseStringC); //for parsing Json
		String codeC1=jsC.getString("status.code");
		String CodeExpectedC1= "0000";
		System.out.println("///////////AssertCodeC1 ////////////- " + codeC1);
		Assert.assertEquals(codeC1, CodeExpectedC1);
		
		String messageC1=jsC.getString("status.message");
		String messageexpectedC = "success";
		System.out.println("/////////AssertMessageC1///////-  "+ messageC1);
		Assert.assertEquals(messageC1, messageexpectedC);

		String messageS1=jsC.getString("status.service");
		String messageexpectedS1 = "customer exp service";
		System.out.println("/////////AssertServiceS1///////-  "+ messageS1);
		Assert.assertEquals(messageS1, messageexpectedS1);
		
		String messageD1=jsC.getString("status.description");
//		String messageexpectedD = "success";
		System.out.println("/////////AssertmessageD1///////-  "+ messageD1);
//		Assert.assertEquals(messageD1, messageexpectedD);

		String codeCrm1=jsC.getString("data.crm_id");
		System.out.println("///////////AssertCodeCrm1 ////////////- " + codeCrm1);
		Assert.assertEquals(codeCrm1, CRM);
		
		String messageDL1=jsC.getString("data.cardless_max_limit_amt");
		String messageexpectedDL1 = "100000";
		System.out.println("/////////AssertMessageDL1///////-  "+ messageDL1);
		Assert.assertEquals(messageDL1, messageexpectedDL1);

		String messageCA1=jsC.getString("data.cardless_accu_usg_amt");
		System.out.println("/////////AssertServiceCA1///////-  "+ messageCA1);
		Assert.assertNotNull(messageCA1);
		
		System.out.println("///////////CRM Profile Success/////////////// ");
					
	}
}
