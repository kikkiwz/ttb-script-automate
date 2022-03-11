package com.tmb.automation.test.lending.sprint22Android;

import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.parser.ParseException;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import com.tmb.automation.helper.Setting;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.util.TextColor;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.ConvertStringToJson;
import com.tmb.automation.util.TextColor;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.File;
import java.nio.charset.StandardCharsets;

import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.aventstack.extentreports.MediaEntityBuilder;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.restassured.RestAssured.given;

public class getProductLanding extends Base {
	 private static String ac;
	    private static String getAccount;
	    //    String ac;
//	    String acc;
//	    String getAccount;
	    private static String getAccountStatus;
	    private static String getProductOrder;

	    public static String[] getProductLandingList(String a) throws IOException, ParseException {

	      //  ac = generateToken.GetAccessToken();

	        RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
	        Response response =given().relaxedHTTPSValidation().auth().oauth2("")
	                .header("accept", "*/*")
	                .header("X-CRMID", "001100000000000000000011004078")
	                .header("X-Correlation-ID", "32fbd3b2-3f97-4a89-ar39-b4f628fbc8da")
	                .when()
	                .get("/apis/customer/accounts/creditcard")
	                .then().assertThat().extract().response();

	        JSONObject json = (JSONObject)new JSONParser().parse(response.getBody().asString());
	        JSONObject jsonObj1 =  (JSONObject)json.get("data");
	        JSONArray jsonA =  (JSONArray)jsonObj1.get("credit_cards");


	        for(int i=0;i<jsonA.size();i++)
	        {
	            JSONObject jsonobj_1 = (JSONObject)jsonA.get(i);

	                getAccount = jsonobj_1.get("account_id").toString();
	                if(getAccount.substring(getAccount.length()-4).equals(a)){
//	                    System.out.println("Testttttttttttttt : "+getAccount.substring(getAccount.length()-4));
	                    getAccountStatus = jsonobj_1.get("account_status").toString();
	                    getProductOrder = jsonobj_1.get("product_order").toString();
	                    break;
	                }
	        }

//	        Assert.assertEquals(responseModel.data.credit_cards, "0000000050078690679020455");
	        boolean isOK = response.getStatusCode() == 200;

//	        parentReport = extent.createTest("ScenarioName", "ScenarioName");
	       
//	        dataTestcase.put(indexTestCase++, new Object[]{indexTestCase,
//	                "Fetch Reason List is Success",
//	                "Validate response for Reason list is show",
//	                "N/A",
//	                isOK,
//	                ConvertStringToJson.jsonFormat(response.getBody().asString())/*response*/,
//	                "N/A",
//	                getDateTime(),
//	                isPass(isOK)});

	        Assert.assertTrue(isOK);
//	    return new getProductLandingList(getAccount,getAccountStatus,getProductOrder);
	        return new String[]{getAccount,getAccountStatus,getProductOrder};
	    }
//	    @Test
//	    public void TestGetAPI() throws IOException, ParseException {
//	        String[] result = getProductLandingList("0960");
//	        System.out.println(result[0]+" "+result[1]+" "+result[2]);
//	    }
}