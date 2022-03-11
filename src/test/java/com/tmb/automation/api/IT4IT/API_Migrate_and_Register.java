package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tmb.automation.model.PhrasesPojo;
import com.tmb.automation.model.PhrasesPojo.current_phrase;
import com.tmb.automation.model.PhrasesPojo.phrases;
import com.tmb.automation.model.PhrasesPojo.update_phrase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class API_Migrate_and_Register {

	private Long Timestamp;
	
	@Test(description="Migrate API",priority=1)
	public void Migrate_API()
	{
		Date date =new Date();
		Timestamp = date.getTime();
		String public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugnOavqvRCbtg/CvOKCd7ci6x0xc1u3rfN06nsi7dWRG0BmbvbP+XQZ3saZZdOQS4xcLXJqGh47MtvJynb8C52EgZ897DOvMz56dRQzLUEbrEBSKSRkyffsVPoLzDlbZW+2MW6wanXh6fudxhD2Cz4IZViUE6428+aXbaxXUr/WJd9dBB+vv7D9+HjhlwZlluzTU9pc+WZ6LCS/HNhVNRToOh3n0vKILnR7hJSB7kNNqNcMIxXUmj1HRWVn3pu5mtz4Mo7FkfbBZboVT/F8YjW/otRQ85599OBkPiRQCHwSTq2CD/BhOIq3gXepsDx+87CCf9lcGP9Rvv9IjiSTpeQIDAQAB";
		RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
		String response = given().relaxedHTTPSValidation().auth().preemptive().basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-ID", "6cd91013-8ad0-4b2e-bd14-ebccf6856").header("touch-deviceid","KegaRe62aVYS/h8BpS8dpaQoOhVAeFi8U5/6Xl5OsMI=")
				.header("auth-public-key",public_key)
				.header("Timestamp",Timestamp).when()
				.get("apis/customer/device/migrate").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));
		String rm_id=(js.getString("data.rm_id"));
		Assert.assertTrue(!rm_id.equals(""));
		String ref_id=(js.getString("data.ref_id"));
		Assert.assertTrue(!ref_id.equals(""));
		String language=(js.getString("data.language"));
		Assert.assertTrue(language.equals("EN") || language.equals("TH"));
		System.out.println("The rm-id is "+rm_id+" and ref_id is "+ref_id );
	
		

	}
	@Test(description="Register API",priority=2)
	public void Register_API()
	{
		Date date =new Date();
		Timestamp = date.getTime();
		RestAssured.baseURI = "https://oneapp-dev1.tau2904.com";
		String response = given().relaxedHTTPSValidation().auth().preemptive().basic("oneapp-dev", "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2").log().all()
				.header("X-Correlation-Id", "6cd91013-8ad0-4b2e-bd14-ebccf6856").header("touch-deviceid","KegaRe62aVYS/h8BpS8dpaQoOhVAeFi8U5/6Xl5OsMI=")
				.header("auth-public-key","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAugnOavqvRCbtg/CvOKCd7ci6x0xc1u3rfN06nsi7dWRG0BmbvbP+XQZ3saZZdOQS4xcLXJqGh47MtvJynb8C52EgZ897DOvMz56dRQzLUEbrEBSKSRkyffsVPoLzDlbZW+2MW6wanXh6fudxhD2Cz4IZViUE6428+aXbaxXUr/WJd9dBB+vv7D9+HjhlwZlluzTU9pc+WZ6LCS/HNhVNRToOh3n0vKILnR7hJSB7kNNqNcMIxXUmj1HRWVn3pu5mtz4Mo7FkfbBZboVT/F8YjW/otRQ85599OBkPiRQCHwSTq2CD/BhOIq3gXepsDx+87CCf9lcGP9Rvv9IjiSTpeQIDAQAB")
				.header("Timestamp",Timestamp).header("oneapp-deviceid","Q7SjGqheETxAjOyx4ydYATjueQtp34qotG04TJHRnxPq5AhgMCTGclAxvkTwHwZAFWkJex4sHzDqzUiuQM6kL+Ng/oOQH6hjwGmOgxJcgO/FsKH0yZTFa97ruNIVxDKXFplJh1lQgsiTWNQY9y9PoQgm3Ln7YThZpBT6mCRs+ECkiYI4UasakYjKbaJm9onuBbrSSpm7kO0EfPC6Dlh1eqB8MhSMQTZvIyXisK5OiAUGtkCJyLbxNzTMqcQFId/pHMZlBZ+r32yXIpJGZHoTYXtp2GEwAz41SpfbQcA+a23++S5huz4tAqY2miRqnVGwVeRuSSnHXuM3VsCIwMtYgA==").when()
				.post("apis/customer/device/register").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js= new JsonPath(response);
		System.out.println("The response is---"+response);
		String message=(js.getString("status.message"));
		Assert.assertTrue(message.equals("success"));

	}
		
}

