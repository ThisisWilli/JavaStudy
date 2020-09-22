package com.concurrency.completablefuturestudy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.completablefuturestudy
 * \* author: Willi Wei
 * \* date: 2020-09-22 11:24:17
 * \* description:
 * \
 */
public class FutureTaskStudy {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int result = 101;
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println("this is runnable");
        }, result);
        task.run();
        System.out.println(task.get());
    }
}