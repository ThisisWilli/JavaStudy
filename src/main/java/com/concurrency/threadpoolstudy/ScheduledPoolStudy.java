package com.concurrency.threadpoolstudy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-03 13:49
 **/

public class ScheduledPoolStudy {
    public static void main(String[] args) throws InterruptedException {
        // 定时器线程池，线程可以服用，以固定频率执行一个任务
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName());
        }, 0, 500, TimeUnit.MILLISECONDS);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(service);
        service.shutdown();
    }
}
