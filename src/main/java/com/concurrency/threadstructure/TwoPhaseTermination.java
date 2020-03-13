package com.concurrency.threadstructure;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-13 14:18
 **/

public class TwoPhaseTermination {
    public static void main(String[] args) throws InterruptedException {
        MonitorSystem system = new MonitorSystem();
        system.start();

        TimeUnit.MILLISECONDS.sleep(3000);
        system.stop();
    }
}
class MonitorSystem{
    private Thread monitor;

    public void start(){
        monitor = new Thread(()->{
            for (;;){
                Thread current = Thread.currentThread();
                if (current.isInterrupted()){
                    System.out.println("料理后事，释放锁等");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    current.interrupt();
                }
            }
        });
        monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }
}