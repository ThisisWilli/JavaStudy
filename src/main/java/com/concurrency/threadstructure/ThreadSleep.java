package com.concurrency.threadstructure;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-12 20:37
 **/

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "is sleeping");
                TimeUnit.SECONDS.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "is interrupted");
                e.printStackTrace();
            }
        }, "t1");

        Thread.sleep(500);
        t1.start();
        t1.interrupt();
    }
}
