package com.ttbbank.oneapp.framework.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.model.common.OneAppConfig;
import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * OneAppClient oneAppClient = new OneAppClient();
 * oneAppClient.initToken("4abf4a6ce65f9b959abb082aaf0d8c4adff1ebcb66872de8ce8675523071a94c");
 * <p>
 * Map<String, String> queryParams = new HashMap<>();
 * queryParams.put("channel", "mb");
 * TmbServiceResponse<List<BillerReponse>> response = oneAppClient.get("/apis/mobile/biller/list", queryParams, oneAppClient.constructCollectionType(BillerReponse.class));
 * ObjectMapper mapper = new ObjectMapper();
 * System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response));
 * <p>
 * <p>
 * String reqJson = "{\"accountno\":\"266008294\",\"runtype\":\"I\",\"lastrecord\":0}";
 * <p>
 * <p>
 * TmbServiceResponse<PaymentList> response2 = oneAppClient.post("/apis/hpservice/payment-list", reqJson, PaymentList.class);
 * <p>
 * System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response2));
 */
public class OneAppClient {
    private String token;
    private ObjectMapper objectMapper = new ObjectMapper();

    private final String baseUrl;
    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private OkHttpClient client = new OkHttpClient();

    public OneAppClient(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public void initToken(String deviceId) {
        this.token = this.getToken(deviceId);
    }

    private HashMap<String, HashMap<String, String>> tPhrases = new HashMap<>();

    private Headers getReqHeader(String token, Map<String, String> reqHeader) {

        Headers.Builder builder = new Headers.Builder()
                .add("X-Correlation-ID", UUID.randomUUID().toString());
        if(token!=null){
            builder.add("Authorization", "Bearer " + token);
        }
        if (reqHeader != null) {
            for (Map.Entry<String, ?> entry : reqHeader.entrySet()) {
                String value = reqHeader.get(entry.getKey());
                builder.add(entry.getKey(), value);
            }
        }
        return builder.build();
    }

    public <T> TmbServiceResponse<T> post(String endpoint, Object reqObj, Class<T> tClass) throws IOException {
        String reqJson = objectMapper.writeValueAsString(reqObj);
        return post(endpoint, reqJson, token, tClass);
    }

    public <T> TmbServiceResponse<T> post(String endpoint, String reqJson, Class<T> tClass) throws IOException {
        return post(endpoint, reqJson, token, tClass);
    }

    public <T> TmbServiceResponse<T> post(String endpoint, String reqJson, String token, Class<T> tClass) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructType(tClass);
        return post(endpoint, reqJson, token, javaType, null);
    }

    public <T> TmbServiceResponse<T> post(String endpoint, String reqJson, String token, Class<T> tClass, Map<String, String> reqHeader) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructType(tClass);
        return post(endpoint, reqJson, token, javaType, reqHeader);
    }

    public <T> TmbServiceResponse<T> post(String endpoint, String reqJson, JavaType javaType) throws IOException {
        return post(endpoint, reqJson, token, javaType, null);
    }

    public <T> TmbServiceResponse<T> post(String endpoint, String reqJson, JavaType javaType, Map<String, String> reqHeader) throws IOException {
        return post(endpoint, reqJson, token, javaType, reqHeader);
    }


    public <T> TmbServiceResponse<T> post(String endpoint, String reqJson, String token, JavaType javaType, Map<String, String> reqHeader) throws IOException {
        RequestBody body = RequestBody.create(JSON, reqJson);
        Request request = new Request.Builder()
                .headers(getReqHeader(token, reqHeader))
                .url(baseUrl + endpoint)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String responseStr = response.body().string();
            JavaType type = objectMapper.getTypeFactory().constructSimpleType(TmbServiceResponse.class, new JavaType[]{javaType});
            return objectMapper.readValue(responseStr, type);
        }
    }

    public <T> TmbServiceResponse<T> get(String endpoint, Map<String, String> reqParam, String token, Class<T> tClass) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructType(tClass);
        JavaType type = objectMapper.getTypeFactory().constructSimpleType(TmbServiceResponse.class, new JavaType[]{javaType});
        return get(endpoint, reqParam, token, type, null);
    }

    public <T> TmbServiceResponse<T> get(String endpoint, Map<String, String> reqParam, String token, Class<T> tClass, Map<String, String> reqHeader) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructType(tClass);
        JavaType type = objectMapper.getTypeFactory().constructSimpleType(TmbServiceResponse.class, new JavaType[]{javaType});
        return get(endpoint, reqParam, token, type, reqHeader);
    }

    public JavaType constructCollectionType(Class tClass) {
        return objectMapper.getTypeFactory().constructCollectionType(List.class, tClass);
    }

    public <T> TmbServiceResponse<T> get(String endpoint, Map<String, String> reqParam, Class<T> tClass) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructType(tClass);
        return get(endpoint, reqParam, token, javaType, null);
    }

    public <T> TmbServiceResponse<T> get(String endpoint, Map<String, String> reqParam, JavaType javaType) throws IOException {
        return get(endpoint, reqParam, token, javaType, null);
    }

    public <T> TmbServiceResponse<T> get(String endpoint, Map<String, String> reqParam, Class<T> tClass, Map<String, String> reqHeader) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructType(tClass);
        return get(endpoint, reqParam, token, javaType, reqHeader);
    }

    public <T> TmbServiceResponse<T> get(String endpoint, Map<String, String> reqParam, JavaType javaType, Map<String, String> reqHeader) throws IOException {
        return get(endpoint, reqParam, token, javaType, reqHeader);
    }

    public <T> TmbServiceResponse<T> get(String endpoint, Map<String, String> reqParam, String token, JavaType javaType, Map<String, String> reqHeader) throws IOException {
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse(baseUrl + endpoint).newBuilder();
        if (reqParam != null) {
            for (Map.Entry<String, ?> entry : reqParam.entrySet()) {
                String value = reqParam.get(entry.getKey());
                urlBuilder.addQueryParameter(entry.getKey(), value);
            }
        }


        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .headers(getReqHeader(token, reqHeader))
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String responseStr = response.body().string();
            JavaType type = objectMapper.getTypeFactory().constructSimpleType(TmbServiceResponse.class, new JavaType[]{javaType});
            return objectMapper.readValue(responseStr, type);
        }
    }

    public String getToken(String deviceId) {
        String username = deviceId;
        String password = "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==";

        GetAccessTokenClient getAccessTokenClient = Feign.builder()
                .client(HttpUtils.getUnsafeOkHttpClient())
                .encoder(new FormEncoder(new JacksonEncoder()))
                .decoder(new JacksonDecoder())
                .target(GetAccessTokenClient.class, baseUrl);

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("X-Correlation-ID", "f058ebd6-02f7-4d3f-942e-904344e8cde5");
        headerMap.put("Authorization", "Basic b25lYXBwLWRldjo0T2QxMDQ1UmV3VXJHdXg4YWoxb1h6enJYT29ueUc3b09TSWhFUlRMMjdXMnRZSWtET042UFhsSUhHa3YyNkky");

        ResponseGenToken tokenResponse = getAccessTokenClient.genToken(headerMap, "password", username, password, "mobile");
        return tokenResponse.getData().getAccessToken();
    }

    public OneAppConfig fetchOneAppConfig() {
        Map<String, String> reqParam = new HashMap<>();
        reqParam.put("channel", "mb");
        try{
            TmbServiceResponse<OneAppConfig> response = get("/apis/common/fetch/config", reqParam, OneAppConfig.class);
            if("0000".equals(response.getStatus().getCode())){
                tPhrases = response.getData().getPhrases();
            }
            return response.getData();
        }catch (Exception e){
            System.err.println("Unexpected exception when get T-Phrases");
            e.printStackTrace();
        }
        return null;
    }

    public String getTPhrase(String lang,String key){
        HashMap<String, String> tPhrasesContent = tPhrases.get(lang.toLowerCase());
        if(tPhrasesContent==null){
            return "";
        }
        String value = tPhrasesContent.get(key);
        return value==null?"":value;
    }
}
