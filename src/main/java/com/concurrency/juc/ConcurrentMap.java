package com.concurrency.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-29 13:08
 **/

public class ConcurrentMap {

    public static void main(String[] args) {
//  ================线程安全====================
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        // 该并发并且需要排序
//    ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
//    Map<String, String> map = new Hashtable<>();


//  ================线程不安全==================
//    Map<String, String> map = new HashMap<>();
        // LinkedList也是有序的
//    Map<String, String> map = new LinkedHashMap<>();

        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < ths.length; i++){
            ths[i] = new Thread(()->{
                for (int j = 0; j < 10000; j++){
                    map.put("a" + r.nextInt(10000), "a" + r.nextInt(10000));
                    latch.countDown();
                }
            });
        }

        Arrays.asList(ths).forEach(Thread::start);

        try {
            // latch主线程等所有thread执行完之后再执行
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println(end - start + "ms");
    }
}
