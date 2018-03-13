package com.kfit;

import java.util.concurrent.CompletableFuture;

/**
 * Created by davi on 2018/3/10.
 */
public class BaseMain1 {

    public static void main(String[] args) throws Exception {
        Long a = System.currentTimeMillis();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName());
            } catch (Exception e) {
            }
            return 100;
        });
        System.out.println(1);
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName());
        System.out.println(2);
        System.out.println(future.join());
        System.out.println((System.currentTimeMillis() - a));

    }


}
