package com.concurrency.threadlock;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-20 20:46
 **/

public class SimulateLiveLock {
    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                while (count > 0){
                    TimeUnit.SECONDS.sleep(1);
                    count--;
                    System.out.println(count);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            try {
                while (count <20){
                    TimeUnit.SECONDS.sleep(1);
                    count++;
                    System.out.println(count);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
