package com.concurrency.synchronizedstudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-19 11:55
 **/

public class ParkAndUnpack {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "is running");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println("resume...");
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("unpack...");
        LockSupport.unpark(t1);
    }
}
