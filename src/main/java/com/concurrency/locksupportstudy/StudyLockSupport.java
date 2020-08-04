package com.concurrency.locksupportstudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.locksupportstudy
 * \* author: Willi Wei
 * \* date: 2020-08-03 19:28:15
 * \* description:
 * \
 */
public class StudyLockSupport {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "running....");
            LockSupport.park(Thread.currentThread());
            LockSupport.unpark(Thread.currentThread());
            System.out.println("parking...");
            System.out.println(Thread.currentThread().getName() + "over....");
        });

//        t1.start();
//        TimeUnit.SECONDS.sleep(4);
//        System.out.println("unpark t1");
//        LockSupport.unpark(t1);
        new StudyLockSupport().test(Thread.currentThread());
    }

    public void test(Thread t){
        LockSupport.park(t);
        LockSupport.unpark(t);

    }
}