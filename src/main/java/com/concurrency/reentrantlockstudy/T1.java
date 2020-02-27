package com.concurrency.reentrantlockstudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-24 14:04
 **/

public class T1 {
    Lock lock = new ReentrantLock();

    private volatile int count = 0;
    public static void main(String[] args) {
        T1 t = new T1();

        new Thread(()->{
            try {
                t.lock.lock();
                while (t.count < 10){
                    System.out.println(t.count);
                    t.count++;
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println(Thread.currentThread().getName() + "结束");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                t.lock.unlock();
            }
        }, "线程1").start();

        new Thread(()->{
            try {
                t.lock.lock();
                if (t.count > 5){
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                t.lock.unlock();
            }
        }, "线程2").start();
    }
}
