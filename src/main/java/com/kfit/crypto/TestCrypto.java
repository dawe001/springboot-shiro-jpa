package com.kfit.crypto;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * Created by davi on 2017/8/21.
 */
public class TestCrypto {
    private static final String KEY = "nfasdfa;asdjfl";
    public static String KEYSTRING = "202cb962ac59075b964b07152d234b70";

    public static void main(String[] args) {
        try {
            String encode = base64Encode();
            base64Decode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String base64Encode() throws Exception {
        String testString = "testString";
        byte[] bytes = testString.getBytes();
        String string1 = null;
        String string2 = null;

        Cipher cipher = Cipher.getInstance("DES");
        Key key = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec("aaaaaaaa".getBytes()));
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] outputBytes = cipher.doFinal(bytes);
        BASE64Encoder base64Encoder = new BASE64Encoder();

        string1 = base64Encoder.encode(outputBytes);
        string2 = new String(Base64.getEncoder().encode(outputBytes));

        System.out.println(string1);
        System.out.println(string2);
        return null;
    }


    static String base64Decode() throws Exception {
        String testString = "testString";
        byte[] bytes = testString.getBytes();
        String string1 = null;
        String string2 = null;

        Cipher cipher = Cipher.getInstance("DES");
        Key key = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec("aaaaaaaaaaaaaaaa".getBytes()));
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder base64Decoder = new BASE64Decoder();

        byte[] aa = base64Decoder.decodeBuffer("KhkrRSs24NeBJ5D+ns4JYQ==");
        byte[] stringBytes = cipher.doFinal(aa);
        string1 = new String(stringBytes, "UTF8");
        string2 = new String(Base64.getDecoder().decode(stringBytes));

        System.out.println(string1);
        System.out.println(string2);
        return null;
    }
}
