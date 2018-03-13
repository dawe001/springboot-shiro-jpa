package com.kfit.crypto;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by davi on 2017/8/27.
 */
public class TestRsa {

    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            System.out.println(Hex.encodeHexString(publicKey.getEncoded()));
            System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));

            EncodedKeySpec encodedKeySpec=new X509EncodedKeySpec(publicKey.getEncoded());
            PublicKey publicKey1= keyFactory.generatePublic(encodedKeySpec);

        } catch (Exception e) {
        }
    }
}
