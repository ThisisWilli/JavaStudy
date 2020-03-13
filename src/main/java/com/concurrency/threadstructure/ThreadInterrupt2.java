package com.concurrency.threadstructure;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-13 13:58
 **/

public class ThreadInterrupt2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (; ; ) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName() + "被打断了");
                    break;
                }
            }
        }, "t1");

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
    }
}
