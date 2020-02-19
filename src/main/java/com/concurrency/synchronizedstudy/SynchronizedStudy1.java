package com.concurrency.synchronizedstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-19 12:54
 **/

public class SynchronizedStudy1 {
    private int count = 0;

    public void m(){
        // 任何一个线程要执行以下代码，首先要拿到this的锁
        synchronized (this){
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args) {
        SynchronizedStudy1 study1 = new SynchronizedStudy1();
        // 所有线程共用一把锁
        Runnable r = study1::m;
        for (int i = 0; i < 10; i++){
            new Thread(r).start();
        }
    }
}
