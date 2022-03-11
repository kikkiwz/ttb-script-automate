package com.tmb.automation.pages.pb1.cardless;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.OpenReport;
import com.tmb.automation.util.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class API_Login extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod()
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
	}

	public static String Login() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "/src/main/resources/Global.properties");
		prop.load(fis);
		
		String BaseURI = prop.getProperty("BaseURL");
		BaseURI= System.getProperty("Environment", BaseURI);
		String XCorrelation = prop.getProperty("XCorrelation");
		
		String oneappD = ApiUrlCardless.oneappD;
		String grantT = ApiUrlCardless.grantT;
		String scopE = ApiUrlCardless.scopE;
		String userN = ApiUrlCardless.userN;
		String passW = ApiUrlCardless.passW;
		String loginApi =ApiUrlCardless.loginApi;
		
		System.out.println("----------BaseURI---------- " + BaseURI);
		System.out.println("----------XCorrelation---------- " + XCorrelation);
		System.out.println("----------oneappD---------- " + oneappD);
		System.out.println("----------grantT---------- " + grantT);
		System.out.println("----------scopE---------- " + scopE);
		System.out.println("----------userN---------- " + userN);
		System.out.println("----------passW---------- " + passW);
		System.out.println("----------loginApi---------- " + loginApi);

		RestAssured.baseURI = BaseURI;
		Response response = given().relaxedHTTPSValidation().auth().preemptive().basic("oneapp-dev", oneappD)
				.header("X-Correlation-ID", XCorrelation).multiPart("grant_type", grantT).multiPart("username", userN)
				.multiPart("password", passW).multiPart("scope", scopE).when().post(loginApi);

		String responseLogin = response.asString();
		System.out.println("----------Login responseLogin---------- " + responseLogin);
		int statusLogin = response.getStatusCode();
		System.out.println("-----statusLogin-----: " +statusLogin);
		String statusString = Integer.toString(statusLogin);
		OpenReport.reportString("Login Status is "+statusString);
		Assert.assertEquals(statusLogin, 200);
		
		JsonPath js = new JsonPath(responseLogin); // for parsing Json
		String codeV = js.getString("status.code");
		System.out.println("----------code---------- " + codeV);
		Assert.assertEquals(codeV, "0000");
		
		String access_tokenV = js.getString("data.access_token");
		System.out.println("----------access_token---------- " + access_tokenV);
		
		return access_tokenV;  //String access_tokenV= API_Login.Login(); //to call into test class
	}

}
