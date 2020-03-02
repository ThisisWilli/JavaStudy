package com.concurrency.threadpoolstudy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-02 16:06
 **/

public class ExecutorServiceStudy {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 15; i++){
            es.execute(()->{
                System.out.println(Thread.currentThread().getName() + " 正在执行");
            });
        }
//        Future<String> future = es.submit(() -> {
//            // override call()方法
//            return Thread.currentThread().getName() + " 正在执行";
//        });
//        System.out.println();
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        es.shutdown();
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        service.execute(()->{
//            System.out.println("正在执行任务");
//        });
//        service.shutdown();
    }
}
