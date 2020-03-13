package com.concurrency.threadstructure;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-13 15:05
 **/

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(() -> {
            for (;;){
                if (Thread.currentThread().isInterrupted()){
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }, "daemon");
        daemon.setDaemon(true);
        daemon.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("主线程结束");
    }
}
