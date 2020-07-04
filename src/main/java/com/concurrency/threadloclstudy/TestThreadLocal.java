package com.concurrency.threadloclstudy;

import java.util.concurrent.TimeUnit;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.threadloclstudy
 * \* author: Willi Wei
 * \* date: 2020-07-04 14:16:40
 * \* description:
 * \
 */
public class TestThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>().withInitial(()->"inital");

    public static void main(String[] args) {
        System.out.println(threadLocal.get());
        threadLocal.set(Thread.currentThread().getName());
        System.out.println(threadLocal.get());
        Thread t1 = new Thread(() -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}