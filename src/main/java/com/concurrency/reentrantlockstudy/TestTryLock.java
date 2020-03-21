package com.concurrency.reentrantlockstudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-21 14:05
 **/

public class TestTryLock {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println("没有拿到锁");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("拿到了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        t1.start();
        TimeUnit.SECONDS.sleep(5);
        lock.unlock();
    }
}
