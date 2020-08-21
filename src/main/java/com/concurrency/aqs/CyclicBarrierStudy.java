package com.concurrency.aqs;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.aqs
 * \* author: Willi Wei
 * \* date: 2020-07-24 16:20:04
 * \* description:
 * \
 */
public class CyclicBarrierStudy {
    // 等到5个线程到达之后，才可以开始执行
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public void test(int threadNum){
        System.out.println("threadNum = " + threadNum +" is ready...");
        try {
            cyclicBarrier.await(60, TimeUnit.SECONDS);
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("threadNum = " + threadNum +" finished...");
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        CyclicBarrierStudy study = new CyclicBarrierStudy();
        for (int i = 0; i < 10; i++) {
            final int num = i;
            Thread.sleep(1000);
            pool.execute(()->{
                study.test(num);
            });
        }
    }
}