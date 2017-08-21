package com.kfit.config.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.concurrent.atomic.AtomicInteger;

public class HashTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        test();
    }

    static void test() {
        AtomicInteger retryCount = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            retryCount.getAndIncrement();
            System.out.println(retryCount);
        }

    }

    static void test1() {
        //		YWRtaW5kYTdmMWNmMTBlMzE1ZjJhZjFkNmZkNDk4Y2Q3OTQ1ZA==
        int a = 123456;

        String sha1 = new Md5Hash("123456", "admin8d78869f470951332959580424d4bf4f", 2).toString();
        System.out.println(sha1);
    }
}
