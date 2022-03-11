package com.tmb.automation.api.IT4IT;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.tmb.automation.model.Bankinfo_Pojo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API_Get_Create_Edit_Bankinfo {
	private static String AccessToken;
	

	public String GetAccessToken()
	{

		RestAssured.baseURI = "https://cc-vit1.oneapp.tmbbank.local";

		// The Below API Running For Access Token----	
		String response = given().relaxedHTTPSValidation().auth().preemptive()
				.basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "550e8400-e29b-41d4-a716-446655440000").multiPart("grant_type", "password")
				.multiPart("username", "occ_padmin02").multiPart("password", "P@ss12345").when()
				.post("apis/internal/auth/token").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonPath = new JsonPath(response);
		AccessToken = jsonPath.getString("data.access_token");
		return AccessToken;
	}
	@Test(description="Get Bank Info",priority=1)
	public void Get_Bank_info()
	{
		String AccessToken= GetAccessToken();
		String GetBankInfo = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json" )
				.header("Accept-Language", "EN").header("Timestamp", "1620369525321").when()
				.get("apis/common/internal/bank/details").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("the response is---"+GetBankInfo);
		JsonPath js= new JsonPath(GetBankInfo);			
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));
		String Description=(js.getString("status.description"));
		Assert.assertTrue(Description.equals("Bank Information"));
		String bank_cd=(js.getString("data.bank_cd"));
		System.out.println("The bank code is---"+bank_cd);
		Assert.assertTrue(!bank_cd.equals(""));
}
	@Test(description="Save Bank Info",priority=2)
	public void Save_Bank_info()
	{
		String AccessToken= GetAccessToken();
		Bankinfo_Pojo SaveBankInfo=new Bankinfo_Pojo();
		SaveBankInfo.setBank_acct_length("10");
		SaveBankInfo.setBank_cd("02");
		SaveBankInfo.setBank_logo("/bank/logo/02");
		SaveBankInfo.setBank_name_en("Bangkok Bank");
		SaveBankInfo.setBank_name_th("ธนาคารกรุงเทพ จำกัด (มหาชน)");
		SaveBankInfo.setBank_shortname("BBL");
		SaveBankInfo.setBank_status("Active");
		SaveBankInfo.setDisplay_order(2);
		SaveBankInfo.setOrft_effective_date("2013-10-31T17:00:00.000Z");
		SaveBankInfo.setOrft_expire_date("2099-10-31T17:00:00.000Z");
		SaveBankInfo.setPromptpay_effective_date("2013-10-31T17:00:00.000Z");
		SaveBankInfo.setPromptpay_expire_date("2099-10-31T17:00:00.000Z");
		SaveBankInfo.setPromptpay_status("Available");
		SaveBankInfo.setSmart_effective_date("2013-10-31T17:00:00.000Z");
		SaveBankInfo.setSmart_expire_date("2099-10-31T17:00:00.000Z");
		Bankinfo_Pojo Bankresponse = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json; charset=UTF-8" )
				.header("Accept-Language", "EN").header("IS-UPDATE", "true").header("Timestamp", "1620369525321").body(SaveBankInfo).when()
				.post("apis/internal/cc-exp/bank/info").then().assertThat().statusCode(200).extract().response().as(Bankinfo_Pojo.class);
		System.out.println("the response is---"+Bankresponse.getData());
		Assert.assertTrue(Bankresponse.getStatus().getMessage().equals("success"));
		Assert.assertTrue(Bankresponse.getData().equals("Bank info saved successfully"));
}
	@Test(description="Upload Bank Logo",priority=2)
	public void Upload_Bank_Logo()
	{
		String AccessToken= GetAccessToken();
	
		String UploadBanklogo = given().relaxedHTTPSValidation().auth().oauth2(AccessToken).log().all()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866").header("Content-Type","application/json; charset=UTF-8" )
				.header("Accept-Language", "EN").header("IS-UPDATE", "true").header("Timestamp", "1620369525321").contentType("multipart/form-data").multiPart("file", new File("./src/main/resources/IT4IT/Sprint32Story22394/upload_img_bankinfo.png"))
				.multiPart("path", "bank/logo").multiPart("fileName", "02").when()
				.post("apis/firebase/internal/upload/image").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(UploadBanklogo);	
		Assert.assertTrue(js.getString("status.message").equals("success"));
		Assert.assertTrue(js.getString("status.service").equals("firebase-service"));
}
}