package com.AracStickerSistemi.Model;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

public class Encryption {

    private final String key = "aesEncryption";
    private final String initVector = "initEncryption";

    public String encrypt(String strToEncrypt, String secret) {
        try
        {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(key.toCharArray(), initVector.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String secret) {
        try
        {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(key.toCharArray(), initVector.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static String encode (int id) {
        String code = String.valueOf(id);
        try{
            return Base64.getUrlEncoder().encodeToString(code.getBytes());
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static int decode (String code) {
        int id;
        try {
            byte[] decode = Base64.getUrlDecoder().decode(code);
            String actualString = new String(decode);
            id = Integer.parseInt(actualString);
            return id;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public String map () {
        StringBuilder map = new StringBuilder();
        Random r = new Random();
        String alphabet = "173xtb";
        for (int i = 0; i < 6; i++) {
            map.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return map.toString();
    }

    public String getKey() {
        return key;
    }

    public String getInitVector() {
        return initVector;
    }
}
