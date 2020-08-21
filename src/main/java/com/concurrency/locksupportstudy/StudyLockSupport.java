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
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        TestThread testThread = new TestThread(Thread.currentThread());
        testThread.start();
        System.out.println("被阻塞");
        LockSupport.park(Thread.currentThread());
        System.out.println("被释放");
    }
}
class TestThread extends Thread{
    Object object;

    public TestThread(Object object) {
        this.object = object;
        System.out.println("构造器中" + object);
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object blocker = LockSupport.getBlocker((Thread) object);
        System.out.println(blocker);
        LockSupport.unpark((Thread) blocker);
    }
}