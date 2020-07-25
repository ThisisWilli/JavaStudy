package com.concurrency.aqs;


import java.util.concurrent.*;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.aqs
 * \* author: Willi Wei
 * \* date: 2020-07-24 15:51:00
 * \* description:
 * \
 */
public class SemaphoreStudy {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool =
                new ThreadPoolExecutor(
                        6,
                        50,
                        2L,
                        TimeUnit.SECONDS,
                        new SynchronousQueue<Runnable>()
                );

        Semaphore semaphore = new Semaphore(3);
        CountDownLatch latch = new CountDownLatch(50);
        for (int i = 0; i < 50; i++){
            pool.execute(()->{
                try {
                    latch.countDown();
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "----");
//                    TimeUnit.SECONDS.sleep(10);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        latch.await();
        pool.shutdown();
    }

}