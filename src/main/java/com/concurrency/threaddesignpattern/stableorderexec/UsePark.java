package com.concurrency.threaddesignpattern.stableorderexec;

import java.util.concurrent.locks.LockSupport;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-22 12:41
 **/

public class UsePark {
    static boolean flag = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!flag){
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            flag = true;
            LockSupport.unpark(t1);
        }, "t2");

        t1.start();
        t2.start();
    }
}
