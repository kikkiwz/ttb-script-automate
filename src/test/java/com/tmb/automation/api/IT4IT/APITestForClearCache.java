package com.tmb.automation.api.IT4IT;

import static io.restassured.RestAssured.given;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.automation.model.Request_ETE_ClearCache_POJO;
import com.tmb.automation.model.ResponsePojo;

import io.restassured.RestAssured;

public class APITestForClearCache {

	@Test(description = "Successfully updated DB and cleared Cache")
	public void clearCacheAndUpdateDB() throws SQLException, ClassNotFoundException {

		Request_ETE_ClearCache_POJO reqPOJO = new Request_ETE_ClearCache_POJO();
		reqPOJO.setChannel_name("ete");
		reqPOJO.setCrm_id("001100000000000000000012018156");
		reqPOJO.setProduct_group("deposit");

		
		RestAssured.baseURI = "https://api-dev1.oneapp.tmbbank.local";
		ResponsePojo response = given().relaxedHTTPSValidation()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
				.header("Content-Type", "application/json").header("Timestamp", "1611032036")
				.header("API-Key", "Pxw2hpJXXs5zNwSrp218DWzbDIh1XZaGEGOGNSF0xhFfnheA").body(reqPOJO).when()
				.post("/apis/internal/customer-transaction/trigger").then().assertThat().statusCode(200).extract()
				.response().as(ResponsePojo.class);

		Assert.assertEquals("0000", response.getStatus().getCode());
		DBConnection conn = new DBConnection();
		ResultSet rs = conn.connection("select * from CRMADM.customer_acct_inq_flag where crm_id='001100000000000000000000777002'");
		while (rs.next()) {
			String crmId = rs.getString(1);
			String updatedFlag = rs.getString(2);
			System.out.println(crmId + "  " + updatedFlag);
			Assert.assertEquals("Y", updatedFlag);

		}

		conn.con.close();

	}

	@Test(description = " invalid API key Status code validation")
	public void statusCodeValidation() throws SQLException, ClassNotFoundException {

		Request_ETE_ClearCache_POJO reqPOJO = new Request_ETE_ClearCache_POJO();
		reqPOJO.setChannel_name("ete");
		reqPOJO.setCrm_id("0011000000000000000000");
		reqPOJO.setProduct_group("deposit");

		RestAssured.baseURI = "https://api-dev1.oneapp.tmbbank.local";
		ResponsePojo response = given().relaxedHTTPSValidation()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
				.header("Content-Type", "application/json").header("Timestamp", "1611032036")
				.header("API-Key", "Pxw2hpJXXs5zNwSrp218DWzbDIh1XZaGEGOGNSF0xhFfnheA").body(reqPOJO).when()
				.post("/apis/internal/customer-transaction/trigger").then().assertThat().statusCode(400).extract()
				.response().as(ResponsePojo.class);

		Assert.assertEquals("0001", response.getStatus().getCode());

	}

	@Test(description = "Unauthorised status code validation ")
	public void invalidAPIKey() throws SQLException, ClassNotFoundException {

		Request_ETE_ClearCache_POJO reqPOJO = new Request_ETE_ClearCache_POJO();
		reqPOJO.setChannel_name("ete");
		reqPOJO.setCrm_id("0011000000000000000000");
		reqPOJO.setProduct_group("deposit");

		RestAssured.baseURI = "https://api-dev1.oneapp.tmbbank.local";
		ResponsePojo response = given().relaxedHTTPSValidation()
				.header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
				.header("Content-Type", "application/json").header("Timestamp", "1611032036").body(reqPOJO).when()
				.post("/apis/internal/customer-transaction/trigger").then().assertThat().statusCode(401).extract()
				.response().as(ResponsePojo.class);

		Assert.assertEquals("10020", response.getStatus().getCode(), "success code mismatch");

	}

}
