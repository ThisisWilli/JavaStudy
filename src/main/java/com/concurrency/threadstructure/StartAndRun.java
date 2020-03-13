package com.concurrency.threadstructure;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-12 20:00
 **/

public class StartAndRun {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " is running..");
        }).start();
    }
}
