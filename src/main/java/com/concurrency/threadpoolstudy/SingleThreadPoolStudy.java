package com.concurrency.threadpoolstudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-03 13:46
 **/

public class SingleThreadPoolStudy {
    public static void main(String[] args) {
        // 任务如果是前后顺序执行的，那么选择SingleThreadPool
        ExecutorService service = Executors.newSingleThreadExecutor();
        System.out.println(service);
        for (int i = 0; i < 5; i++){
            service.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        service.shutdown();
    }
}
