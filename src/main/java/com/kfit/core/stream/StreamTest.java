package com.kfit.core.stream;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by davi on 2017/8/25.
 */
public class StreamTest {


    static void me0() {
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "110");
//        System.out.println(ForkJoinPool.getCommonPoolParallelism());
//        System.out.println(Runtime.getRuntime().availableProcessors());

        Long a = System.currentTimeMillis();
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            me7();
            me8();
            me9();
            return null;
        });
        future.join();
        System.out.println(System.currentTimeMillis() - a);
    }

    static void me1() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "张三");
        map1.put("count", 1L);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "李四");
        map2.put("count", 2L);
        list.add(map1);
        list.add(map2);
        List a = list.stream().sorted(Comparator.comparing((Map map3) -> (Long) map3.get("count")).reversed()).collect(toList());
        System.out.println(a);
    }

    static void me2() {
        String[] ss = {"a", "b", "c"};
        Stream a1 = Arrays.stream(ss);

        Object l1 = a1.map(r -> r.toString()).collect(toList());
        System.out.println(l1);

        String[] strings = {"hello", "world"};
        Object a = Arrays.stream(strings)
                .map(s -> s.split(""))
                .flatMap(strings1 -> Arrays.stream(strings1))
                .collect(toList());
        System.out.println(a);
    }

    static void me3() {
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);
        List<int[]> list = num1.stream().flatMap(i -> num2.stream().map(j -> new int[]{i, j})).collect(toList());
        System.out.println(list);
    }

    static void me4() {
        CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("aa");
        });
    }

    static void me5() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {
            }
            return null;
        });

    }

    static void me6() {
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {
            }
            return null;
        });
    }

    static void me7() {
        try {
            System.out.println(3);
            Thread.sleep(3000);
        } catch (Exception ex) {
        }
    }

    static void me8() {
        try {
            System.out.println(2);
            Thread.sleep(2000);

        } catch (Exception ex) {
        }
    }

    static void me9() {
        try {
            System.out.println(1);
            Thread.sleep(2000);

        } catch (Exception ex) {
        }
    }

    static void me10() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("address", null);

//        Object a2 = map.getOrDefault("address", "dawei");//当没有显示设置key时设置
//        System.out.println(a2.getClass());
//        System.out.println(a2.toString());
        map.put("aa", null);
        Object a1 = map.putIfAbsent("aa", "上海");//key未设置或设置的为null就设置并返回null，key已设置就返回val
        System.out.println(map.get("aa"));

    }

    static void me11() {

        Map<String, Object> map = new HashMap<>();

        Object a1 = map.computeIfAbsent("name", String::new);//第二个参数为function  t->r  t为第一个参数
        System.out.println(map.get("name"));

    }

    static void me12() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("address", null);

        String a1 = (String) map.computeIfPresent("aa", (a, b) -> a + b);//
        System.out.println(map.get("aa"));

    }

    static void me13() {
        int[] nums = new int[10];
        Object a = Arrays.asList(nums);
        Arrays.setAll(nums, i -> i * 2);
        Object b = Arrays.asList(nums);

    }

    static void me14() {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("a", 999);
        map.put("b", 9999);

        String result = map.search(100, (k, v) -> v > 1000 ? k : null);
        System.out.println(result);
        Object result1 = map.searchValues(2, (v) -> v > 1000 ? v : null);//function的最后一个参数 泛型为searchValues的子类
        System.out.println(result1);
    }

    static CompletableFuture<Integer> me15() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(1111);
            } catch (InterruptedException e) {
            }
            return 1;
        });
        return future;
    }

    static void me16(Integer pa) {
        System.out.println(pa);
        if (pa == null)
            throw new RuntimeException("异常");
        System.out.println(pa);
        return;
    }

    static CompletableFuture<Integer> me17() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return 12;
        });
        return future;
    }

    static void me18() throws Exception {
        Thread.sleep(3000);
        System.out.println(222);
    }

    public static void main(String[] args) {
        Long l1 = System.currentTimeMillis();
//        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
//            int a = me15();
//            me16(1);
//            return null;
//        });
//        future.join();


        CompletableFuture a = me15();
        a.join();

//        System.out.println(a.join().equals(a1.join()));
        System.out.println( a.thenCombineAsync(me17(),(s1,s2)->s1.equals(s2)).join());
        System.out.println(System.currentTimeMillis() - l1);
    }
}
