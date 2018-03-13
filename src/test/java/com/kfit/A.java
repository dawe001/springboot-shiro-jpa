package com.kfit;

import java.util.Random;

/**
 * Created by davi on 2018/2/25.
 */
public class A {

    public static final int a = 1;

    public static int me() {

        try {
            System.out.println(11);
            throw new NullPointerException("aa");

        } catch (NullPointerException e) {
            System.out.println(12);
            return 1;
        } finally {
            System.out.println(13);
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(numGenerator(11));
    }

    public static int numGenerator(int count) {
        if (count <= 10) {
            return 1;
        } else {
            return new Random().nextInt((count - 10));
        }
    }
}
