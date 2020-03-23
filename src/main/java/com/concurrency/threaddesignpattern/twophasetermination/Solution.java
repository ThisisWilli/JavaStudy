package com.concurrency.threaddesignpattern.twophasetermination;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-23 10:27
 **/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        s.start();
        TimeUnit.SECONDS.sleep(3);
        s.stop();
    }

    private Thread monitorThread;

    private volatile boolean stop = false;

    public void start(){
        monitorThread = new Thread(()->{
            while (true){
                Thread current = Thread.currentThread();
                if (stop){
                    System.out.println("is stopped, do something");
                    break;
                }
                try {
                    System.out.println("monitor....");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "monitor");
        monitorThread.start();
    }

    public void stop(){
        stop = true;
    }
}
