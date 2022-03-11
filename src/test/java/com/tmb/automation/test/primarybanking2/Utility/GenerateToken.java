package com.tmb.automation.test.primarybanking2.Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GenerateToken {


    public static Map<String, String> headersGenerateToken = new HashMap<>();

    public static String accessToken;
    public static String generateToken() {

        // set headers and put it to hashMap
        headersGenerateToken.put("api-key", "oneapp-dev");
        headersGenerateToken.put("Timestamp",  "1611029592903");
        headersGenerateToken.put("Flow-Name", "Login");
        headersGenerateToken.put("Login-Method", "Pin");
        headersGenerateToken.put("Device-Model", "Samsung-500");
        headersGenerateToken.put("Device-Nickname", "Amit");
        headersGenerateToken.put("App-Version", "1.0");
        headersGenerateToken.put("Channel", "MB");
        headersGenerateToken.put("OS-Version", "Andriod 10.0");
        headersGenerateToken.put("X-Correlation-ID", "4153cb83-53c5-4837-893a-d3d502b0a53a");
        headersGenerateToken.put("Authorization","Basic b25lYXBwLWRldjo0T2QxMDQ1UmV3VXJHdXg4YWoxb1h6enJYT29ueUc3b09TSWhFUlRMMjdXMnRZSWtET042UFhsSUhHa3YyNkky");
        headersGenerateToken.put("Cookie", "511a2bda58977cafd124dc70932f5a2b=39521a57b1918017192d25c936d8453e");


        Response res = given().relaxedHTTPSValidation().contentType("multipart/form-data")
                .multiPart("grant_type","password")
                .multiPart("username", "gDciifnWWIWy/bHYGRxEaDzK6e5Jl63Oa9wgpcSv9ZDW59jhq81CNlkVzrCVagS6PQxFFxHcuj4yK7ZjjnoFRv4I7YzVmpqs8syvyYvPSNgcJjIQjJ2slyyW34kBfU6tAI+YUAscd3E6+57yNl7pk4hcDW7cg1VsPKHrxZly71W+zmcYWzSzSBR0115J2ROv+7PoH/cza6BEgA09skk1++mZKPF84uvz9SxWfEdgKDNZwyN6N/xFyVVt+40un3QH/CbdsywlQ470LCyGVFsrKQViyeAuBOgpTyhj9frz4hy/uTcB5iBTUclLPcmdaHhckQ7m8wZ5z2newPxbq0XR4w==")
                .multiPart("password", "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==")
                .multiPart("subscriptionToken", "327732ye3232")
                .multiPart("scope", "mobile")
                .headers(headersGenerateToken)
                .when()
                .post("https://oneapp-dev1.tau2904.com/apis/auth/token")
                .then().assertThat().statusCode(200).log().all().extract().response();

        ResponseBody response = res.getBody();
        System.out.println("\n\n" + response.asString());
        JsonPath jsonPath = response.jsonPath();
        String accessToken = response.jsonPath().getString("data.access_token");

        return accessToken;


    }

    public static String initialGenerateToken(String userName,String environment) {

        // set headers and put it to hashMap
        headersGenerateToken.put("api-key", "oneapp-dev");
        headersGenerateToken.put("Timestamp",  "1611029592903");
        headersGenerateToken.put("Flow-Name", "Login");
        headersGenerateToken.put("Login-Method", "Pin");
        headersGenerateToken.put("Device-Model", "Samsung-500");
        headersGenerateToken.put("Device-Nickname", "Amit");
        headersGenerateToken.put("App-Version", "1.0");
        headersGenerateToken.put("Channel", "MB");
        headersGenerateToken.put("OS-Version", "Andriod 10.0");
        headersGenerateToken.put("X-Correlation-ID", "4153cb83-53c5-4837-893a-d3d502b0a53a");
        headersGenerateToken.put("Authorization","Basic b25lYXBwLWRldjo0T2QxMDQ1UmV3VXJHdXg4YWoxb1h6enJYT29ueUc3b09TSWhFUlRMMjdXMnRZSWtET042UFhsSUhHa3YyNkky");
        headersGenerateToken.put("Cookie", "511a2bda58977cafd124dc70932f5a2b=39521a57b1918017192d25c936d8453e");


        Response res = given().relaxedHTTPSValidation().contentType("multipart/form-data")
                .multiPart("grant_type","password")
                .multiPart("username", userName)
                .multiPart("password", "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==")
                .multiPart("subscriptionToken", "327732ye3232")
                .multiPart("scope", "mobile")
                .headers(headersGenerateToken)
                .when()
                .post( environment+"/apis/auth/token")
                .then().assertThat().statusCode(200).log().all().extract().response();

        ResponseBody response = res.getBody();
        System.out.println("\n\n" + response.asString());
        JsonPath jsonPath = response.jsonPath();
        String accessToken = response.jsonPath().getString("data.access_token");

        return accessToken;
    }
}
