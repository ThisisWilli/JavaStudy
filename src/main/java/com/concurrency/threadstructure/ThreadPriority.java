package com.concurrency.threadstructure;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-12 20:21
 **/

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                System.out.println("---->1" + count);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            int count = 0;
            Thread.yield();
            for (; ; ) {
                System.out.println("      ---->2" + count);
            }
        }, "t2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
