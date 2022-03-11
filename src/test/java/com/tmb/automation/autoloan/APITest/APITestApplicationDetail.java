package com.tmb.automation.autoloan.APITest;

import com.tmb.automation.autoloan.AutoloanUtility;
import io.restassured.path.json.JsonPath;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class APITestApplicationDetail {

    @Test
    public void getApplicationDetailSuccess() {
        String  token = AutoloanUtility.genToken(DataConstant.dataForToken);
        System.out.println("token = " + token);
        String body = GetJsonData.getApplicationDetailSuccess().toJSONString();
        String response = callApplicationDetail(token, body, HttpStatus.OK);


        JsonPath jsonPath = new JsonPath(response);
        assertEquals("0000", jsonPath.getString("status.code"));
        assertEquals("success", jsonPath.getString("status.message"));
        assertEquals("hp-ex-service", jsonPath.getString("status.service"));
        assertEquals("success", jsonPath.getString("status.description"));

        assertNotNull( jsonPath.getString("data.ProviderUserID"));
        assertEquals("USED CAR", jsonPath.getString("data.WSRecord[0].ProductType"));
        assertEquals("24639219706", jsonPath.getString("data.WSRecord[0].AppNo"));
        assertTrue(jsonPath.getString("data.WSRecord[0].AppInDate").matches("^([1-9]|([012][0-9])|(3[01]))\\/([0]{0,1}[1-9]|1[012])\\/\\d\\d\\d\\d (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$"));
        assertEquals("Toyota", jsonPath.getString("data.WSRecord[0].CarBrand"));
        assertEquals("Fortuner", jsonPath.getString("data.WSRecord[0].CarFamily"));
        assertEquals("ฎส 4505", jsonPath.getString("data.WSRecord[0].CarRegisNo"));
        assertEquals("CK", jsonPath.getString("data.WSRecord[0].HPAPStatus"));
        assertTrue(jsonPath.getString("data.WSRecord[0].StatusDate").matches("^([1-9]|([012][0-9])|(3[01]))\\/([0]{0,1}[1-9]|1[012])\\/\\d\\d\\d\\d (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$"));
        assertEquals("Application No. 24639219706 In process of loan approval", jsonPath.getString("data.WSRecord[0].Msg"));
        assertNotNull(jsonPath.getString("data.WSRecord[0].HPAccountNo"));
        assertEquals("1", jsonPath.getString("data.WSRecord[0].StatusCode"));
    }

    @Test
    public void getApplicationDetailBadRequest() {
        String  token = AutoloanUtility.genToken(DataConstant.dataForToken);
        String body = GetJsonData.getApplicationDetailBadRequest().toJSONString();
        String response = callApplicationDetail(token, body, HttpStatus.BAD_REQUEST);

        JsonPath jsonPath = new JsonPath(response);
        Assert.assertEquals("400", jsonPath.getString("status.code"));
        Assert.assertEquals("BAD REQUEST", jsonPath.getString("status.message"));
        Assert.assertEquals("hp-ex-service", jsonPath.getString("status.service"));
        Assert.assertEquals("BAD REQUEST", jsonPath.getString("status.description"));
        assertNull(jsonPath.getString("data"));
    }

    @Test
    public void getApplicationDetailInternalServerError() {
        String  token = AutoloanUtility.genToken(DataConstant.dataForToken);
        String body = GetJsonData.getApplicationDetailInternalServerError().toJSONString();
        String response = callApplicationDetail(token, body, HttpStatus.INTERNAL_SERVER_ERROR);

     JsonPath jsonPath = new JsonPath(response);
        Assert.assertEquals("0001", jsonPath.getString("status.code"));
        Assert.assertEquals("Failed", jsonPath.getString("status.message"));
        Assert.assertEquals("hp-services", jsonPath.getString("status.service"));
        Assert.assertEquals("Unable to proceed your transaction. Sorry for inconvenience caused. For more information please call 1428", jsonPath.getString("status.description.en"));
        Assert.assertEquals("ไม่สามารถทำรายการได้ ธนาคารขออภัยในความไม่สะดวกมา ณ ที่นี้  สอบถามเพิ่มเติม โทร. 1428", jsonPath.getString("status.description.th"));
        assertNull(jsonPath.getString("data"));
    }

    private String callApplicationDetail(String token, String body, HttpStatus statusCodeActual) {
        return given().relaxedHTTPSValidation().auth().oauth2(token).log().all()
                .header("X-Correlation-Id", "4e953db0-f5e7-4cf9-b44f-2819ee8e7866")
                .header("Content-Type", "application/json")
                .body(body).when()
                .post("https://oneapp-dev1.tau2904.com/apis/hpservice/loan-status/application-detail").then().statusCode(statusCodeActual.value()).assertThat().extract().response().asString();
    }
}
