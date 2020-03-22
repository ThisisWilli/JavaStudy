package com.concurrency.threaddesignpattern.stableorderexec;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-22 10:55
 **/

/**
 * 顺序执行两个线程
 */
public class UseSynchronized {
    // 表示t2还没有执行
    static boolean flag = false;
    final static Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock){
                while (!flag){
                    try {
                        lock.wait();
//                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " running");
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock){
                flag = true;
                System.out.println(Thread.currentThread().getName() + " running");
                lock.notifyAll();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
