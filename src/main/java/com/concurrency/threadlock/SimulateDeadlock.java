package com.concurrency.threadlock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-20 13:55
 **/

/**
 * 模拟死锁
 */
public class SimulateDeadlock {
    Object a = new Object();
    Object b = new Object();

    public void methodA(){
        synchronized (a){
            try {
                System.out.println(Thread.currentThread().getName() + "拿到了a锁");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println(Thread.currentThread().getName() + "拿到了b锁");
            }
        }
    }

    public void methodB(){
        synchronized (b){
            try {
                System.out.println(Thread.currentThread().getName() + "拿到了b锁");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a){
                System.out.println(Thread.currentThread().getName() + "拿到了a锁");
            }
        }
    }

    public static void main(String[] args) {
        SimulateDeadlock deadlock = new SimulateDeadlock();
        new Thread(()->{
            deadlock.methodA();
        }).start();
        new Thread(()->{
            deadlock.methodB();
        }).start();
    }
}
