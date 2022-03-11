package com.tmb.automation.api.IT4IT;



import org.apache.tomcat.util.codec.binary.Base64;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
//import org.apache.tomcat.util.codec.binary.Base64;

public class Content_Signing {

    //server public key :  will get it from app config
    public static String publicKeyBase64String = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgWp5YcdZc1yeLp9q/SroHwEGy9UR5RQsB8xMlZ2qY0zbbKzm/O+KefkK/auYrwKU0Op9UPc1bR2Zd3w24QSRsSFIhAjNZxusRQWkuV2rgiojfqFfBA95YlnHgBoG7Zg6+VnLeqRTb6llP2wguMbL6BgqohWEaNi11F2Oqw+xRMsbDft5AWjsCZ43+LJdvynm0fTkLajvsf3ZYkbRlm7uSOhChi7+ZeGgPyMLlCAyRGfDOCtOr0cmZNQ4Z4dmlMswrgXT0vfFmutLwecqHqR63Olhm44lx2ycqZ8A2GnBFJ+N7Vwxwo7aBGfvVFh9RFnoz5E2ujGbrOPkdJ80AfUU9QIDAQAB";
    //device private key : will be stored in device
    public static String privateKeyBase64String = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBanlhx1lzXJ4un2r9KugfAQbL1RHlFCwHzEyVnapjTNtsrOb874p5+Qr9q5ivApTQ6n1Q9zVtHZl3fDbhBJGxIUiECM1nG6xFBaS5XauCKiN+oV8ED3liWceAGgbtmDr5Wct6pFNvqWU/bCC4xsvoGCqiFYRo2LXUXY6rD7FEyxsN+3kBaOwJnjf4sl2/KebR9OQtqO+x/dliRtGWbu5I6EKGLv5l4aA/IwuUIDJEZ8M4K06vRyZk1Dhnh2aUyzCuBdPS98Wa60vB5yoepHrc6WGbjiXHbJypnwDYacEUn43tXDHCjtoEZ+9UWH1EWejPkTa6MZus4+R0nzQB9RT1AgMBAAECggEAflRXZNFaSjhw2QYZRETsDcfMwJCfRUUprfsKD0q3FvPhhfZKDUIvpN0sk288PiqA5mbgKXcHmho4wuBoGcOCDKx2wxxslWf4A/B8Wc5MK2XC/Eu+GpKYZR9KlYvSk3/0oY+8B139bJSpFv4P+w9j4I4mn83tUQOqi0FAkU9iNcnBYwyrmKPYlJzwYqCnezeaR8N/CUNIiaAVeSM0y0U8roZ0iy5MSDLrMUsDrCLfjm4TfzUrZfAmLhGjimSD7eUcXQqKPPaqv9DXSr3EBUWIMum8pACilNusHvJcEhtyXujbYsbbFGfZ5qA5clnZcrXO9DQAuUhTdeXA6n/OAzO4gQKBgQDF/qsBHC2sqihnudeRIcIFsFklIgs+Eu9RxRtmHBh7UiF31nawnZfo8MwFThqw08cbXBdQxD5qwa6HFOroaJ7WSgkRiKqkpsXYrh6S+HFOrlqh5oVVkAe3Ez4Z3upqJAqfO+T2C6iwDFC4r3y9MwBJj3HK9a8ZtBLNW2MkPoUWsQKBgQCnVHx3ttCXYf/JF6SBOYlwZme86dlXxe8e3tl9pr9jTXSHsVE1RkEbYsV7RLkJKXCrIsi+LP+sPPhvk2vhPDMZSqEh8nQ3vrnp1MklyXncAvK6LY7r5tMKqfwMmJR5apYfqqVhbcDufK4XKCmdXQow7wGGbecEfv6Rx4bLPE27hQKBgGzqz39o1OdrI5cL8L3x6B3hCOkYdT7Mg8Jjv9LIGd+dKrQV0m0OBIcsD8/LS3uCxMEUQ+82RW/M5AmDREZdZyNSzvJKUDULWUL9ZexLp2k1GL5/ZVHQTa40c7Efo6yH7x/xft6rQzy1SaKPRvt9lubgdiTESnLFUKKPZ1aE3gnBAoGBAKLly/pbfjwxymrBWoP3OIa1Gv69hbo+VmjuODtr7txEllJXXCCKEW4QvQIhSCXUMvxX86e4dPr/rDgrA5YVHgXcMnuy5lMymRk77sqblseKEzUOjxm27/NswpScocaF7jpLzY7I408JEA45KjIpVneG5iwxp/oni7rtzJrkTSRlAoGAaktbyUuOOQC3Ur5aIHTaHGhbRqGKjczKnhkJZgDg2tY0vjP50TZo4Rs5CyHBKm22rIsY8F4GvknP1UXGUlBI95KsJwclTTHVeoJtFrjTIHmTEhM8p5pmi10ngLV+M/+CFALREGfWd5RfmWDvSuD6EKZWO0eTd09caO6ZzNIo1wE=";
    public static final String SHA256_WITH_RSA = "SHA256withRSA";


    public static String sign(RSAPrivateKey rsaPrivateKey , String header) throws IOException, GeneralSecurityException, URISyntaxException {
        Signature sign = Signature.getInstance(SHA256_WITH_RSA);
        sign.initSign(rsaPrivateKey);
        sign.update(header.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.encodeBase64(sign.sign()), StandardCharsets.UTF_8);
    }
    public static boolean verify(RSAPublicKey rsaPublicKey, String header, String signature) throws IOException, GeneralSecurityException, URISyntaxException {
        Signature sign = Signature.getInstance(SHA256_WITH_RSA);
        sign.initVerify(rsaPublicKey);
        sign.update(header.getBytes(StandardCharsets.UTF_8));
        return sign.verify(Base64.decodeBase64(signature.getBytes(StandardCharsets.UTF_8)));
    }
    public static RSAPrivateKey privateKey(String key) throws GeneralSecurityException {
        String privateKeyPEM = key;
        // Base64 decode data
        byte[] encoded = Base64.decodeBase64(privateKeyPEM);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) kf.generatePrivate(new PKCS8EncodedKeySpec(encoded));
    }

    public static RSAPublicKey publicKey(String key) throws GeneralSecurityException {
        String publicKeyPEM = key;
        // Base64 decode data
        byte[] encoded = Base64.decodeBase64(publicKeyPEM);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) kf.generatePublic(new X509EncodedKeySpec(encoded));
    }

    public static String prepareSigningKey(String timeStamp, String requestURI, String body){
        StringBuilder contentSignKey = new StringBuilder();
        return contentSignKey.append(timeStamp).append(requestURI).append(body).toString();
    }


//	public static void main(String[] args) throws GeneralSecurityException, IOException, URISyntaxException  {
//		String plainSigningKey = prepareSigningKey("168900100", "/apis/customers/inbox/badge", "");
//        String signingBase64 = sign(privateKey(privateKeyBase64String),plainSigningKey);
//        System.out.println("signingBase64 : "+signingBase64);
//        boolean verifyStatus = verify(publicKey(publicKeyBase64String), plainSigningKey, signingBase64);
//        System.out.println("verify status : "+verifyStatus);
//
//	}
//















}