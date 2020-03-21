package com.concurrency.reentrantlockstudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-21 13:45
 **/

public class TestInterrupt {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("被打断了，没有竞争到锁，退出");
                return;
            }

            // 竞争到了锁
            try {
                System.out.println("拿到了锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");
        lock.lock();
        t1.start();
//        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
    }
}
