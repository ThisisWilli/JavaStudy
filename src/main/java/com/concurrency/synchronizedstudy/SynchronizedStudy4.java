package com.concurrency.synchronizedstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-19 13:12
 **/

public class SynchronizedStudy4 {

    private static synchronized void fun(){
        System.out.print(Thread.currentThread().getName() + "在静态方法内使用类锁  ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束了");
    }

    public static void main(String[] args) {
        Runnable r = ()->{
          fun();
        };
        for (int i = 0; i < 5; i++) {
            new Thread(r).start();
        }
    }
}
