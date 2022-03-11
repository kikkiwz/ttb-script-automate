package com.ttbbank.oneapp.framework.client;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaUtil {
    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgWp5YcdZc1yeLp9q/SroHwEGy9UR5RQsB8xMlZ2qY0zbbKzm/O+KefkK/auYrwKU0Op9UPc1bR2Zd3w24QSRsSFIhAjNZxusRQWkuV2rgiojfqFfBA95YlnHgBoG7Zg6+VnLeqRTb6llP2wguMbL6BgqohWEaNi11F2Oqw+xRMsbDft5AWjsCZ43+LJdvynm0fTkLajvsf3ZYkbRlm7uSOhChi7+ZeGgPyMLlCAyRGfDOCtOr0cmZNQ4Z4dmlMswrgXT0vfFmutLwecqHqR63Olhm44lx2ycqZ8A2GnBFJ+N7Vwxwo7aBGfvVFh9RFnoz5E2ujGbrOPkdJ80AfUU9QIDAQAB";
    public static PublicKey getPublicKey(String base64PublicKey){
        PublicKey publicKey = null;
        try{
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static byte[] encrypt(String data)  {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(PUBLIC_KEY));
            return cipher.doFinal(data.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static String encryptBase64(String data)  {
        return Base64.getEncoder().encodeToString(encrypt(data));
    }
}
